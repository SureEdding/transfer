package org.suree.trade.manager;

import org.springframework.stereotype.Service;
import org.suree.account.merchant.domain.MerchantAccount;
import org.suree.account.merchant.domain.param.dto.MerchantAccountOperateParamDTO;
import org.suree.account.user.domain.UserAccount;
import org.suree.account.user.domain.param.dto.UserAccountOperateParamDTO;
import org.suree.middleware.generator.SerialNumberGenerator;
import org.suree.middleware.redis.RedisClient;
import org.suree.middleware.transaction.api.TransactionService;
import org.suree.middleware.transaction.domain.TransactionContext;
import org.suree.middleware.transaction.event.EventPublisher;
import org.suree.middleware.transaction.event.TransactionCommitEvent;
import org.suree.middleware.transaction.event.TransactionRollbackEvent;
import org.suree.trade.domain.TransferRecord;
import org.suree.trade.enums.TransferFailedCodeEnum;
import org.suree.trade.enums.TransferStatusEnum;
import org.suree.trade.factory.OperateParamFactory;
import org.suree.trade.param.bo.TransferRequestParamBO;
import org.suree.trade.remote.RemoteAccountServiceWrapper;
import org.suree.trade.service.TransferRecordService;

import javax.annotation.Resource;

@Service
public class TransferManager {

    private static final Integer LOCK_EXPIRE_TIME = 1;

    @Resource
    private RedisClient redisClient;
    @Resource
    private RemoteAccountServiceWrapper remoteAccountServiceWrapper;
    @Resource
    private TransferRecordService transferRecordService;
    @Resource
    private TransactionService transactionService;
    @Resource
    private OperateParamFactory operateParamFactory;
    @Resource
    private EventPublisher eventPublisher;

    public TransferRecord doHandle(TransferRequestParamBO transferRequestParamBO) {

        //记录record
        TransferRecord record = saveRecord(transferRequestParamBO);

        //尝试获取分布式锁
        Boolean lockResult = tryLock(transferRequestParamBO);

        if (!lockResult) {
            //获取分布式锁失败
            transferRecordService.updateRecords(record, TransferStatusEnum.FAIL, TransferFailedCodeEnum.LOCK_FAILED);
            return record;
        }

        try {
            UserAccount sourceAccount = remoteAccountServiceWrapper.getUserAccount(transferRequestParamBO.getFromAccountNo());
            MerchantAccount targetAccount = remoteAccountServiceWrapper.getMerchantAccount(transferRequestParamBO.getToAccountNo());
            if (sourceAccount == null || targetAccount == null) {
                //账户不存在异常
                transferRecordService.updateRecords(record, TransferStatusEnum.FAIL, TransferFailedCodeEnum.ACCOUNT_NOT_EXSIST);
                return record;
            }

            if (sourceAccount.getAmount().compareTo(transferRequestParamBO.getAmount()) < 0) {
                //账户余额不足
                transferRecordService.updateRecords(record, TransferStatusEnum.FAIL, TransferFailedCodeEnum.BALANCE_NOT_ENOUGH);
                return record;
            }

            //开启分布式事务
            TransactionContext transactionContext = transactionService.startTransaction();

            //事务参与者1
            UserAccountOperateParamDTO userAccountOperateParamDTO = operateParamFactory.createUserOperateParam(transferRequestParamBO);
            boolean ret = remoteAccountServiceWrapper.prepareUserAccount(transactionContext, userAccountOperateParamDTO);
            if (!ret) {
                eventPublisher.publish(new TransactionRollbackEvent(transactionContext));
                transferRecordService.updateRecords(record, TransferStatusEnum.FAIL, TransferFailedCodeEnum.TRANSACTION_ERROR);
                return record;
            }

            //事务参与者2
            MerchantAccountOperateParamDTO merchantAccountOperateParamDTO = operateParamFactory.createMerchantOperateParam(transferRequestParamBO);
            ret = remoteAccountServiceWrapper.prepareMerchantAccount(transactionContext, merchantAccountOperateParamDTO);
            if (!ret) {
                eventPublisher.publish(new TransactionRollbackEvent(transactionContext));
                transferRecordService.updateRecords(record, TransferStatusEnum.FAIL, TransferFailedCodeEnum.TRANSACTION_ERROR);
                return record;
            }

            //事务提交
            eventPublisher.publish(new TransactionCommitEvent(transactionContext, userAccountOperateParamDTO, merchantAccountOperateParamDTO));
            transferRecordService.updateRecords(record, TransferStatusEnum.SUCCESS, null);
            return record;
        } catch (RuntimeException e) {
            transferRecordService.updateRecords(record, TransferStatusEnum.FAIL, TransferFailedCodeEnum.UNKNOWN);
            return record;
        } finally {
            release(transferRequestParamBO);
        }
    }

    private UserAccountOperateParamDTO generateOperateParam(TransferRequestParamBO transferRequestParamBO) {

    }

    private TransferRecord saveRecord(TransferRequestParamBO transferRequestParamBO) {
        TransferRecord transferRecord = new TransferRecord();
        transferRecord.setTransactionNo(SerialNumberGenerator.generate(32));
        //省略
        return transferRecord;
    }

    private Boolean tryLock(TransferRequestParamBO transferRequestParamBO) {
        Boolean fromResult = redisClient.lock(generateRedisKey(transferRequestParamBO.getFromAccountNo()), LOCK_EXPIRE_TIME);
        Boolean toResult = redisClient.lock(generateRedisKey(transferRequestParamBO.getToAccountNo()), LOCK_EXPIRE_TIME);
        return fromResult & toResult;
    }

    private Boolean release(TransferRequestParamBO transferRequestParamBO) {
        Boolean fromResult = redisClient.release(generateRedisKey(transferRequestParamBO.getFromAccountNo()));
        Boolean toResult = redisClient.release(generateRedisKey(transferRequestParamBO.getToAccountNo()));
        return fromResult & toResult;
    }

    private String generateRedisKey(Integer accountNo) {
        return "ACCOUNT_NO_" + accountNo.toString();
    }
}

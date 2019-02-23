package org.suree.account.user.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.suree.account.user.domain.UserAccount;
import org.suree.account.user.domain.UserAccountTransaction;
import org.suree.account.user.domain.param.bo.UserAccountOperateParamBO;
import org.suree.account.user.enums.OperateTypeEnum;
import org.suree.account.user.enums.UserAccountTransactionStatusEnum;
import org.suree.account.user.service.UserAccountDAOService;
import org.suree.account.user.service.UserAccountTransactionDAOService;
import org.suree.middleware.transaction.domain.TransactionContext;

import javax.annotation.Resource;


@Service
public class UserAccountPrepareAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAccountPrepareAction.class);

    @Resource
    private UserAccountDAOService userAccountDAOService;
    @Resource
    private UserAccountTransactionDAOService userAccountTransactionDAOService;

    public Boolean doAction(UserAccountOperateParamBO userAccountOperateParamBO) {
        UserAccount userAccount = userAccountDAOService.getUserAccountByAccountNoForUpdate(userAccountOperateParamBO.getAccountNo());
        if (userAccount == null) {
            throw new RuntimeException("账户不存在");
        }
        if (userAccount.getBalance().compareTo(userAccountOperateParamBO.getBalance()) != 0 || !userAccount.getVersion().equals(userAccountOperateParamBO.getVersion())) {
            throw new RuntimeException("CAS 失败");
        }

        saveOperateRecord(userAccountOperateParamBO, userAccount);

        if (userAccountOperateParamBO.getOperateType().equals(OperateTypeEnum.ADD.getCode())) {
            userAccount.setFrozen_amount(userAccountOperateParamBO.getAmount());
        } else if (userAccountOperateParamBO.getOperateType().equals(OperateTypeEnum.MINUS.getCode())) {
            userAccount.setFrozen_amount(userAccountOperateParamBO.getAmount().negate());
        } else {
            throw new RuntimeException("异常操作类型");
        }

        userAccountDAOService.updateUserAccount(userAccount);
        return true;
    }

    private void saveOperateRecord(UserAccountOperateParamBO userAccountOperateParamBO, UserAccount userAccount) {
        UserAccountTransaction userAccountTransaction = new UserAccountTransaction();
        userAccountTransaction.setTradeNo(userAccountTransaction.getTradeNo());
        userAccountTransaction.setAmount(userAccountOperateParamBO.getAmount());
        userAccountTransaction.setStatus(UserAccountTransactionStatusEnum.INIT.getCode());
        userAccountTransaction.setOriginBalance(userAccount.getBalance());
        userAccountTransaction.setOperateType(userAccountOperateParamBO.getOperateType());
        userAccountTransaction.setAccountNo(userAccount.getAccountNo());
        userAccountTransactionDAOService.insert(userAccountTransaction);
    }


}

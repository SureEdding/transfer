package org.suree.account.user.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.suree.account.user.action.UserAccountCommitAction;
import org.suree.account.user.action.UserAccountPrepareAction;
import org.suree.account.user.action.UserAccountRollbackAction;
import org.suree.account.user.domain.UserAccount;
import org.suree.account.user.domain.param.bo.UserAccountOperateParamBO;
import org.suree.account.user.domain.param.dto.UserAccountOperateParamDTO;
import org.suree.account.user.factory.UserAccountOperateParamFactory;
import org.suree.middleware.transaction.domain.TransactionContext;

import javax.annotation.Resource;

@Service
public class UserAccountOperateServiceImpl implements UserAccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAccountOperateServiceImpl.class);

    @Resource
    private UserAccountOperateParamFactory userAccountOperateParamFactory;
    @Resource
    private UserAccountPrepareAction userAccountPrepareAction;
    @Resource
    private UserAccountCommitAction userAccountCommitAction;
    @Resource
    private UserAccountRollbackAction userAccountRollbackAction;

    public boolean prepareUserAccountOperate(TransactionContext transactionContext, UserAccountOperateParamDTO userAccountOperateParamDTO) {
        try {
            LOGGER.info("info");
            UserAccountOperateParamBO userAccountOperateParamBO = userAccountOperateParamFactory.create(userAccountOperateParamDTO);
            return userAccountPrepareAction.doAction(userAccountOperateParamBO);
        } catch (Exception e) {
            LOGGER.error("error", e);
            transactionContext.setNeedRollback(true);
            transactionContext.setTransactionsStep(1);
            return false;
        } finally {
            transactionContext.setTransactionsStep(1);
        }
    }

    public boolean commit(TransactionContext transactionContext, UserAccountOperateParamDTO userAccountOperateParamDTO) {
        try {
            LOGGER.info("info");
            UserAccountOperateParamBO userAccountOperateParamBO = userAccountOperateParamFactory.create(userAccountOperateParamDTO);
            return userAccountCommitAction.doAction(userAccountOperateParamBO);
        } catch (Exception e) {
            LOGGER.error("error", e);
            transactionContext.setNeedRollback(true);
            transactionContext.setTransactionsStep(3);
            return false;
        } finally {
            transactionContext.setTransactionsStep(3);
        }
    }

    public boolean rollback(TransactionContext transactionContext, UserAccountOperateParamDTO userAccountOperateParamDTO) {
        try {
            LOGGER.info("info");
            UserAccountOperateParamBO userAccountOperateParamBO = userAccountOperateParamFactory.create(userAccountOperateParamDTO);
            userAccountRollbackAction.doAction(userAccountOperateParamBO);
            return true;
        } catch (Exception e) {
            //若出现回滚异常，则需要更复杂的分支了...应该是纳入分布式事务中间件的质量方面的设计考虑了。此处暂没做过深入的设计
            LOGGER.error("error", e);
            return false;
        }
    }

    public UserAccount getUserAccountByAccountNo(Integer accountNo) {
        return null;
    }
}

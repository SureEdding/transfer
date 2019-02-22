package org.suree.account.user.api;

import org.springframework.stereotype.Service;
import org.suree.account.user.domain.UserAccount;
import org.suree.account.user.domain.param.dto.UserAccountOperateParamDTO;
import org.suree.middleware.transaction.domain.TransactionContext;

@Service
public class UserAccountOperateServiceImpl implements UserAccountService {

    public boolean prepareUserAccountOperate(TransactionContext transactionContext, UserAccountOperateParamDTO userAccountOperateParamDTO) {

        return false;
    }

    public boolean commit(TransactionContext transactionContext, UserAccountOperateParamDTO userAccountOperateParamDTO) {
        return false;
    }

    public boolean rollback(TransactionContext transactionContext, UserAccountOperateParamDTO userAccountOperateParamDTO) {
        return false;
    }

    public UserAccount getUserAccountByAccountNo(Integer accountNo) {
        return null;
    }
}

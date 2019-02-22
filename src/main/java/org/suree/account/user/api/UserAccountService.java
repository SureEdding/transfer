package org.suree.account.user.api;

import org.suree.account.user.domain.UserAccount;
import org.suree.account.user.domain.param.dto.UserAccountOperateParamDTO;
import org.suree.middleware.transaction.domain.TransactionContext;

public interface UserAccountService {

    public boolean prepareUserAccountOperate(TransactionContext transactionContext, UserAccountOperateParamDTO userAccountOperateParamDTO);

    public boolean commit(TransactionContext transactionContext, UserAccountOperateParamDTO userAccountOperateParamDTO);

    public boolean rollback(TransactionContext transactionContext, UserAccountOperateParamDTO userAccountOperateParamDTO);

    public UserAccount getUserAccountByAccountNo(Integer accountNo);
}

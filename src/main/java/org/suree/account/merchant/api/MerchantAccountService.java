package org.suree.account.merchant.api;

import org.suree.account.merchant.domain.MerchantAccount;
import org.suree.account.merchant.domain.param.dto.MerchantAccountOperateParamDTO;
import org.suree.middleware.transaction.domain.TransactionContext;

public interface MerchantAccountService {

    public boolean prepareMerchantAccountOperate(TransactionContext transactionContext, MerchantAccountOperateParamDTO accountOperateParamDTO);

    public boolean commit(TransactionContext transactionContext, MerchantAccountOperateParamDTO accountOperateParamDTO);

    public boolean rollback(TransactionContext transactionContext, MerchantAccountOperateParamDTO accountOperateParamDTO);

    public MerchantAccount getMerchantAccountByAccountNo(Integer accountNo);
}

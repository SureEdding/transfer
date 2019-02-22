package org.suree.account.merchant.api;

import org.springframework.stereotype.Service;
import org.suree.account.merchant.domain.MerchantAccount;
import org.suree.account.merchant.domain.param.dto.MerchantAccountOperateParamDTO;
import org.suree.middleware.transaction.domain.TransactionContext;

@Service
public class MerchantAccountOperateServiceImpl implements MerchantAccountService {

    public boolean prepareMerchantAccountOperate(TransactionContext transactionContext, MerchantAccountOperateParamDTO accountOperateParamDTO) {

        return false;
    }

    public boolean commit(TransactionContext transactionContext, MerchantAccountOperateParamDTO accountOperateParamDTO) {
        return false;
    }

    public boolean rollback(TransactionContext transactionContext, MerchantAccountOperateParamDTO accountOperateParamDTO) {
        return false;
    }

    public MerchantAccount getMerchantAccountByAccountNo(Integer accountNo) {
        return null;
    }
}

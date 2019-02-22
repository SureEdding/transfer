package org.suree.middleware.transaction.api;

import org.springframework.stereotype.Service;
import org.suree.account.merchant.api.MerchantAccountOperateServiceImpl;
import org.suree.account.user.api.UserAccountOperateServiceImpl;
import org.suree.middleware.transaction.domain.TransactionContext;

import javax.annotation.Resource;

@Service
public class TransactionService {

    @Resource
    private UserAccountOperateServiceImpl userAccountOperateService;
    @Resource
    private MerchantAccountOperateServiceImpl merchantAccountOperateService;

    public TransactionContext startTransaction() {
        TransactionContext transactionContext = new TransactionContext();
        transactionContext.setNeedRollback(false);
        transactionContext.setTransactionsStep(0);
        return transactionContext;
    }

    public Boolean rollback(TransactionContext transactionContext) {

    }


}

package org.suree.middleware.transaction.event.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.suree.account.merchant.domain.param.dto.MerchantAccountOperateParamDTO;
import org.suree.account.user.domain.param.dto.UserAccountOperateParamDTO;
import org.suree.middleware.transaction.api.TransactionService;
import org.suree.middleware.transaction.domain.TransactionContext;
import org.suree.middleware.transaction.event.TransactionRollbackEvent;

import javax.annotation.Resource;

@Service
public class TransactionRollbackEventListener implements ApplicationListener<TransactionRollbackEvent> {

    @Resource
    TransactionService transactionService;

    public void onApplicationEvent(TransactionRollbackEvent transactionRollbackEvent) {
        TransactionContext transactionContext = (TransactionContext) transactionRollbackEvent.getSource();
        UserAccountOperateParamDTO userAccountOperateParamDTO = transactionRollbackEvent.getUserAccountOperateParamDTO();
        MerchantAccountOperateParamDTO merchantAccountOperateParamDTO = transactionRollbackEvent.getMerchantAccountOperateParamDTO();
        transactionService.rollback(transactionContext, userAccountOperateParamDTO, merchantAccountOperateParamDTO);
    }
}

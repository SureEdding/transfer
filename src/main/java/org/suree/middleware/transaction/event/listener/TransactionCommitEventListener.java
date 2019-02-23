package org.suree.middleware.transaction.event.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.suree.account.merchant.api.MerchantAccountOperateServiceImpl;
import org.suree.account.merchant.domain.param.dto.MerchantAccountOperateParamDTO;
import org.suree.account.user.api.UserAccountOperateServiceImpl;
import org.suree.account.user.domain.param.bo.UserAccountOperateParamBO;
import org.suree.account.user.domain.param.dto.UserAccountOperateParamDTO;
import org.suree.middleware.transaction.domain.TransactionContext;
import org.suree.middleware.transaction.event.EventPublisher;
import org.suree.middleware.transaction.event.TransactionCommitEvent;
import org.suree.middleware.transaction.event.TransactionRollbackEvent;

import javax.annotation.Resource;

@Service
public class TransactionCommitEventListener implements ApplicationListener<TransactionCommitEvent> {

    @Resource
    private UserAccountOperateServiceImpl userAccountOperateService;
    @Resource
    private MerchantAccountOperateServiceImpl merchantAccountOperateService;
    @Resource
    private EventPublisher eventPublisher;

    public void onApplicationEvent(TransactionCommitEvent transactionCommitEvent) {
        TransactionContext transactionContext = (TransactionContext) transactionCommitEvent.getSource();
        UserAccountOperateParamDTO userAccountOperateParamDTO = transactionCommitEvent.getUserAccountOperateParamDTO();
        MerchantAccountOperateParamDTO merchantAccountOperateParamDTO = transactionCommitEvent.getMerchantAccountOperateParamDTO();

        try {
            userAccountOperateService.commit(transactionContext, userAccountOperateParamDTO);
            merchantAccountOperateService.commit(transactionContext, merchantAccountOperateParamDTO);
        } catch (Exception e) {
            transactionContext.setNeedRollback(true);
            eventPublisher.publish(new TransactionRollbackEvent(transactionContext, userAccountOperateParamDTO, merchantAccountOperateParamDTO));
        }

    }
}

package org.suree.trade.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.suree.account.merchant.api.MerchantAccountOperateServiceImpl;
import org.suree.account.merchant.domain.MerchantAccount;
import org.suree.account.merchant.domain.param.dto.MerchantAccountOperateParamDTO;
import org.suree.account.user.api.UserAccountOperateServiceImpl;
import org.suree.account.user.domain.UserAccount;
import org.suree.account.user.domain.param.dto.UserAccountOperateParamDTO;
import org.suree.middleware.transaction.domain.TransactionContext;

import javax.annotation.Resource;

@Service
public class RemoteAccountServiceWrapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteAccountServiceWrapper.class);
    @Resource
    private UserAccountOperateServiceImpl userAccountOperateServiceImpl;
    @Resource
    private MerchantAccountOperateServiceImpl merchantAccountOperateServiceImpl;

    public boolean prepareUserAccount(TransactionContext transactionContext, UserAccountOperateParamDTO userAccountOperateParamDTO) {
        return userAccountOperateServiceImpl.prepareUserAccountOperate(transactionContext, userAccountOperateParamDTO);
    }

    public boolean prepareMerchantAccount(TransactionContext transactionContext, MerchantAccountOperateParamDTO merchantAccountOperateParamDTO) {
        return merchantAccountOperateServiceImpl.prepareMerchantAccountOperate(transactionContext, merchantAccountOperateParamDTO);
    }

    public boolean commitUserOperate(TransactionContext transactionContext, UserAccountOperateParamDTO userAccountOperateParamDTO) {
        return userAccountOperateServiceImpl.commit(transactionContext, userAccountOperateParamDTO);
    }
    public boolean commitMerchantOperate(TransactionContext transactionContext, MerchantAccountOperateParamDTO merchantAccountOperateParamDTO) {
        return merchantAccountOperateServiceImpl.commit(transactionContext, merchantAccountOperateParamDTO);
    }

    public UserAccount getUserAccount(Integer accountNo) {
        return userAccountOperateServiceImpl.getUserAccountByAccountNo(accountNo);
    }

    public MerchantAccount getMerchantAccount(Integer accountNo) {
        return merchantAccountOperateServiceImpl.getMerchantAccountByAccountNo(accountNo);
    }
}

package org.suree.middleware.transaction.event;

import org.springframework.context.ApplicationEvent;
import org.suree.account.merchant.domain.param.dto.MerchantAccountOperateParamDTO;
import org.suree.account.user.domain.param.dto.UserAccountOperateParamDTO;

public class TransactionRollbackEvent extends ApplicationEvent {

    private UserAccountOperateParamDTO userAccountOperateParamDTO;

    private MerchantAccountOperateParamDTO merchantAccountOperateParamDTO;

    public TransactionRollbackEvent(Object o, UserAccountOperateParamDTO o2, MerchantAccountOperateParamDTO o3){
        super(o);
        this.userAccountOperateParamDTO = o2;
        this.merchantAccountOperateParamDTO = o3;
    }

    public UserAccountOperateParamDTO getUserAccountOperateParamDTO() {
        return userAccountOperateParamDTO;
    }

    public void setUserAccountOperateParamDTO(UserAccountOperateParamDTO userAccountOperateParamDTO) {
        this.userAccountOperateParamDTO = userAccountOperateParamDTO;
    }

    public MerchantAccountOperateParamDTO getMerchantAccountOperateParamDTO() {
        return merchantAccountOperateParamDTO;
    }

    public void setMerchantAccountOperateParamDTO(MerchantAccountOperateParamDTO merchantAccountOperateParamDTO) {
        this.merchantAccountOperateParamDTO = merchantAccountOperateParamDTO;
    }
}

package org.suree.middleware.transaction.event;

import org.springframework.context.ApplicationEvent;
import org.suree.account.merchant.domain.param.dto.MerchantAccountOperateParamDTO;
import org.suree.account.user.domain.param.dto.UserAccountOperateParamDTO;

public class TransactionCommitEvent extends ApplicationEvent {

    private UserAccountOperateParamDTO userAccountOperateParamDTO;

    private MerchantAccountOperateParamDTO merchantAccountOperateParamDTO;


    public TransactionCommitEvent(Object o, UserAccountOperateParamDTO userAccountOperateParamDTO, MerchantAccountOperateParamDTO merchantAccountOperateParamDTO){
        super(o);
        this.setUserAccountOperateParamDTO(userAccountOperateParamDTO);
        this.setMerchantAccountOperateParamDTO(merchantAccountOperateParamDTO);
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

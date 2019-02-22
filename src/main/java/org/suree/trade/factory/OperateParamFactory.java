package org.suree.trade.factory;

import org.springframework.stereotype.Service;
import org.suree.account.merchant.domain.param.dto.MerchantAccountOperateParamDTO;
import org.suree.account.user.domain.param.dto.UserAccountOperateParamDTO;
import org.suree.trade.param.bo.TransferRequestParamBO;

@Service
public class OperateParamFactory {

    public UserAccountOperateParamDTO createUserOperateParam(TransferRequestParamBO transferRequestParamBO) {
        return null;
    }

    public MerchantAccountOperateParamDTO createMerchantOperateParam(TransferRequestParamBO transferRequestParamBO) {
        return null;
    }


}

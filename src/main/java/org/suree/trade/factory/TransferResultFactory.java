package org.suree.trade.factory;

import org.springframework.stereotype.Service;
import org.suree.trade.domain.TransferRecord;
import org.suree.trade.enums.TransferFailedCodeEnum;
import org.suree.trade.enums.TransferStatusEnum;
import org.suree.trade.param.dto.TransferResultDTO;

@Service
public class TransferResultFactory {


    public TransferResultDTO generateInvalidRequestResult() {
        TransferResultDTO transferResultDTO = new TransferResultDTO();
        transferResultDTO.setStatus(TransferStatusEnum.FAIL.getCode());
        transferResultDTO.setFailCode(TransferFailedCodeEnum.INVALID_REQUEST.getCode());
        return transferResultDTO;
    }

    public TransferResultDTO generateResult(TransferRecord transferRecord) {
        return null;
    }

}

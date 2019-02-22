package org.suree.trade.service;

import org.springframework.stereotype.Service;
import org.suree.trade.domain.TransferRecord;
import org.suree.trade.enums.TransferFailedCodeEnum;
import org.suree.trade.enums.TransferStatusEnum;
import org.suree.trade.utils.DateTool;

@Service
public class TransferRecordService {

    public boolean insertRecords(TransferRecord transferRecord) {
        return true;
    }

    public boolean updateRecords(TransferRecord transferRecord, TransferStatusEnum transferStatusEnum, TransferFailedCodeEnum transferFailedCodeEnum) {
        transferRecord.setStatus(transferStatusEnum.getCode());
        if (transferFailedCodeEnum != null) {
            transferRecord.setFailCode(transferFailedCodeEnum.getCode());
        }
        transferRecord.setUpdateTime(DateTool.unixTime());
        return true;
    }

    public TransferRecord getTransferRecordByTransactionNo(String transactionNo) {
        return null;
    }

    private Integer currentTime() {
        return (int)(System.currentTimeMillis() / 1000);
    }
}

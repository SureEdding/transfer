package org.suree.trade.api;

import org.suree.trade.param.dto.TransferRequestParamDTO;
import org.suree.trade.param.dto.TransferResultDTO;

public interface TransferService {

    public String requestToken(TransferRequestParamDTO transferRequestParamDTO);

    public TransferResultDTO transfer(TransferRequestParamDTO transferRequestParamDTO);

    public TransferResultDTO pollTransferResult(String transactionNo);

}

package org.suree.trade.api.impl;

import org.springframework.stereotype.Service;
import org.suree.middleware.redis.RedisClient;
import org.suree.trade.api.TransferService;
import org.suree.trade.factory.TransferRequestParamFactory;
import org.suree.trade.manager.TransferManager;
import org.suree.trade.param.dto.TransferRequestParamDTO;
import org.suree.trade.param.dto.TransferResultDTO;
import org.suree.trade.remote.RemoteAccountServiceWrapper;
import org.suree.trade.service.TransferRecordService;
import org.suree.trade.validator.TransferRequestParamValidator;

import javax.annotation.Resource;

@Service
public class TransferServiceImpl implements TransferService {


    @Resource
    private RemoteAccountServiceWrapper remoteAccountServiceWrapper;
    @Resource
    private TransferRecordService transferRecordService;
    @Resource
    private TransferRequestParamValidator transferRequestParamValidator;
    @Resource
    private TransferManager transferManager;
    @Resource
    private TransferRequestParamFactory transferRequestParamFactory;
    @Resource
    private RedisClient redisClient;

    public String requestToken(TransferRequestParamDTO transferRequestParamDTO) {
        return null;
    }

    public TransferResultDTO transfer(TransferRequestParamDTO transferRequestParamDTO) {

        transferRequestParamValidator.validate(transferRequestParamDTO);

        boolean ret = redisClient.validateToken(transferRequestParamDTO.getToken());

        if (!ret) {
            //异常请求

        }

        transferManager.doHandle(transferRequestParamFactory.create(transferRequestParamDTO));

        return null;
    }

    public TransferResultDTO pollTransferResult(String transactionNo) {
        return null;
    }
}

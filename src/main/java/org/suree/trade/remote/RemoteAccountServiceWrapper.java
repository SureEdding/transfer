package org.suree.trade.remote;

import org.springframework.stereotype.Service;
import org.suree.account.api.impl.AccountOperateServiceImpl;

import javax.annotation.Resource;

@Service
public class RemoteAccountServiceWrapper {

    @Resource
    private AccountOperateServiceImpl accountOperateServiceImpl;


}

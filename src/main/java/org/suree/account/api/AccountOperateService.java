package org.suree.account.api;

import org.suree.account.domain.param.dto.AccountOperateParamDTO;
import org.suree.account.domain.param.dto.AccountOperateResultDTO;


public interface AccountOperateService {


    public AccountOperateResultDTO operateAccount(AccountOperateParamDTO accountOperateParamDTO);

}

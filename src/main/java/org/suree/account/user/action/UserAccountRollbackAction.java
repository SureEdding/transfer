package org.suree.account.user.action;

import org.springframework.stereotype.Service;
import org.suree.account.user.domain.UserAccount;
import org.suree.account.user.domain.UserAccountTransaction;
import org.suree.account.user.domain.param.bo.UserAccountOperateParamBO;
import org.suree.account.user.enums.UserAccountTransactionStatusEnum;
import org.suree.account.user.service.UserAccountDAOService;
import org.suree.account.user.service.UserAccountTransactionDAOService;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class UserAccountRollbackAction {

    @Resource
    private UserAccountDAOService userAccountDAOService;
    @Resource
    private UserAccountTransactionDAOService userAccountTransactionDAOService;


    public Boolean doAction(UserAccountOperateParamBO userAccountOperateParamBO) {
        //重置为开始阶段
        UserAccount userAccount = userAccountDAOService.getUserAccountByAccountNoForUpdate(userAccountOperateParamBO.getAccountNo());
        UserAccountTransaction userAccountTransaction = userAccountTransactionDAOService.getByTradeNoForUpdate(userAccountOperateParamBO.getTradeNo());

        userAccount.setBalance(userAccountTransaction.getOriginBalance());
        userAccount.setFrozen_amount(BigDecimal.ZERO);
        userAccountTransaction.setStatus(UserAccountTransactionStatusEnum.ROLLBACK.getCode());

        userAccountDAOService.updateUserAccount(userAccount);
        userAccountTransactionDAOService.updateUserAccountTransaction(userAccountTransaction);
        return true;
    }



}

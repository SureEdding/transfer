package org.suree.account.user.action;

import org.springframework.stereotype.Service;
import org.suree.account.user.domain.UserAccount;
import org.suree.account.user.domain.UserAccountTransaction;
import org.suree.account.user.domain.param.bo.UserAccountOperateParamBO;
import org.suree.account.user.enums.OperateTypeEnum;
import org.suree.account.user.enums.UserAccountTransactionStatusEnum;
import org.suree.account.user.service.UserAccountDAOService;
import org.suree.account.user.service.UserAccountTransactionDAOService;
import org.suree.middleware.transaction.domain.TransactionContext;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class UserAccountCommitAction {

    @Resource
    private UserAccountDAOService userAccountDAOService;
    @Resource
    private UserAccountTransactionDAOService userAccountTransactionDAOService;

    public Boolean doAction(UserAccountOperateParamBO userAccountOperateParamBO) {

        UserAccount userAccount = userAccountDAOService.getUserAccountByAccountNoForUpdate(userAccountOperateParamBO.getAccountNo());
        UserAccountTransaction userAccountTransaction = userAccountTransactionDAOService.getByTradeNoForUpdate(userAccountOperateParamBO.getTradeNo());

        if (userAccount == null || userAccountTransaction == null) {
            throw new RuntimeException("异常情况提交");
        }

        if (userAccount.getBalance().compareTo(userAccountTransaction.getOriginBalance()) != 0) {
            throw new RuntimeException("中间态数据不一致");
        }

        BigDecimal operateAmount;
        if (userAccountOperateParamBO.getOperateType().equals(OperateTypeEnum.ADD.getCode())) {
            operateAmount = userAccountOperateParamBO.getAmount();
        } else if (userAccountOperateParamBO.getOperateType().equals(OperateTypeEnum.MINUS.getCode())) {
            operateAmount = userAccountOperateParamBO.getAmount().negate();
        } else {
            throw new RuntimeException("异常操作类型");
        }

        if (operateAmount.compareTo(userAccount.getFrozen_amount()) != 0) {
            throw new RuntimeException("中间态数据不一致");
        }

        userAccount.setBalance(userAccount.getBalance().add(operateAmount));
        userAccount.setFrozen_amount(BigDecimal.ZERO);
        userAccountDAOService.updateUserAccount(userAccount);

        userAccountTransaction.setStatus(UserAccountTransactionStatusEnum.COMMITTED.getCode());
        userAccountTransactionDAOService.updateUserAccountTransaction(userAccountTransaction);

        return true;
    }



}

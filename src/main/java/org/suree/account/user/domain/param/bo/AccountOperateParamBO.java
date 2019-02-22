package org.suree.account.user.domain.param.bo;

import java.math.BigDecimal;

public class AccountOperateParamBO {

    private Integer fromAccountNo;

    private Integer accountAddTransactionId;

    private Integer toAccountNo;

    private Integer accountMinusTransactionId;

    private String transactionNo;

    private BigDecimal amount;


    public Integer getFromAccountNo() {
        return fromAccountNo;
    }

    public void setFromAccountNo(Integer fromAccountNo) {
        this.fromAccountNo = fromAccountNo;
    }

    public Integer getToAccountNo() {
        return toAccountNo;
    }

    public void setToAccountNo(Integer toAccountNo) {
        this.toAccountNo = toAccountNo;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getAccountAddTransactionId() {
        return accountAddTransactionId;
    }

    public void setAccountAddTransactionId(Integer accountAddTransactionId) {
        this.accountAddTransactionId = accountAddTransactionId;
    }

    public Integer getAccountMinusTransactionId() {
        return accountMinusTransactionId;
    }

    public void setAccountMinusTransactionId(Integer accountMinusTransactionId) {
        this.accountMinusTransactionId = accountMinusTransactionId;
    }

    @Override
    public String toString() {
        return "AccountOperateParamBO{" +
                "fromAccountNo=" + fromAccountNo +
                ", accountAddTransactionId=" + accountAddTransactionId +
                ", toAccountNo=" + toAccountNo +
                ", accountMinusTransactionId=" + accountMinusTransactionId +
                ", transactionNo='" + transactionNo + '\'' +
                ", amount=" + amount +
                '}';
    }
}

package org.suree.account.domain.param.dto;

import java.math.BigDecimal;

public class AccountOperateParamDTO {


    private Integer fromAccountNo;

    private Integer toAccountNo;

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

    @Override
    public String toString() {
        return "AccountOperateParamDTO{" +
                "fromAccountNo=" + fromAccountNo +
                ", toAccountNo=" + toAccountNo +
                ", transactionNo='" + transactionNo + '\'' +
                ", amount=" + amount +
                '}';
    }
}

package org.suree.account.user.domain.param.dto;

import java.math.BigDecimal;

public class UserAccountOperateParamDTO {

    private Integer accountNo;

    private Integer operateType;

    private String transactionNo;

    private BigDecimal amount;

    private BigDecimal balance;

    private Integer version;

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "MerchantAccountOperateParamDTO{" +
                "accountNo=" + accountNo +
                ", operateType=" + operateType +
                ", transactionNo='" + transactionNo + '\'' +
                ", amount=" + amount +
                ", balance=" + balance +
                ", version=" + version +
                '}';
    }
}

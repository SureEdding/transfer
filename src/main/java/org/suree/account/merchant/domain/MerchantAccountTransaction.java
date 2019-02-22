package org.suree.account.merchant.domain;

import java.math.BigDecimal;

public class MerchantAccountTransaction {

    private Integer id;

    private String transactionNo;

    private Integer accountNo;

    private BigDecimal amount;

    private Integer type;

    private Integer status;

    private Integer createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MerchantAccountTransaction{" +
                "id=" + id +
                ", transactionNo='" + transactionNo + '\'' +
                ", accountNo=" + accountNo +
                ", amount=" + amount +
                ", type=" + type +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}

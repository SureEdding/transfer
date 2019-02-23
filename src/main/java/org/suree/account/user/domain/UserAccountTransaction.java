package org.suree.account.user.domain;

import java.math.BigDecimal;

public class UserAccountTransaction {

    private Integer id;

    private String tradeNo;

    private Integer accountNo;

    private BigDecimal originBalance;

    private BigDecimal amount;

    private Integer operateType;

    private Integer status;

    private Integer createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public BigDecimal getOriginBalance() {
        return originBalance;
    }

    public void setOriginBalance(BigDecimal originBalance) {
        this.originBalance = originBalance;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
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
        return "UserAccountTransaction{" +
                "id=" + id +
                ", tradeNo='" + tradeNo + '\'' +
                ", accountNo=" + accountNo +
                ", originBalance=" + originBalance +
                ", amount=" + amount +
                ", operateType=" + operateType +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}

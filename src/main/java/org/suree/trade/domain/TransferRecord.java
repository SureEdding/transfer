package org.suree.trade.domain;

import java.math.BigDecimal;

public class TransferRecord {

    private Integer id;

    private String transactionNo;

    private Integer fromAccountNo;

    private Integer fromAccountType;

    private Integer toAccountNo;

    private Integer toAccountType;

    private BigDecimal amount;

    private Integer status;

    private Integer failCode;

    private Integer creditTime;

    private String comments;

    private Integer createTime;

    private Integer updateTime;

    public Integer getToAccountType() {
        return toAccountType;
    }

    public void setToAccountType(Integer toAccountType) {
        this.toAccountType = toAccountType;
    }

    public Integer getFromAccountType() {
        return fromAccountType;
    }

    public void setFromAccountType(Integer fromAccountType) {
        this.fromAccountType = fromAccountType;
    }

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFailCode() {
        return failCode;
    }

    public void setFailCode(Integer failCode) {
        this.failCode = failCode;
    }

    public Integer getCreditTime() {
        return creditTime;
    }

    public void setCreditTime(Integer creditTime) {
        this.creditTime = creditTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "TransferRecord{" +
                "id=" + id +
                ", transactionNo='" + transactionNo + '\'' +
                ", fromAccountNo=" + fromAccountNo +
                ", fromAccountType=" + fromAccountType +
                ", toAccountNo=" + toAccountNo +
                ", toAccountType=" + toAccountType +
                ", amount=" + amount +
                ", status=" + status +
                ", failCode=" + failCode +
                ", creditTime=" + creditTime +
                ", comments='" + comments + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

package org.suree.account.user.domain;

import java.math.BigDecimal;

public class UserAccount {

    private Integer id;

    private Integer accountNo;

    private BigDecimal amount;

    private BigDecimal frozen_amount;

    private Integer version;

    private Integer createTime;

    private Integer updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public BigDecimal getFrozen_amount() {
        return frozen_amount;
    }

    public void setFrozen_amount(BigDecimal frozen_amount) {
        this.frozen_amount = frozen_amount;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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
        return "MerchantAccount{" +
                "id=" + id +
                ", accountNo=" + accountNo +
                ", amount=" + amount +
                ", frozen_amount=" + frozen_amount +
                ", version=" + version +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

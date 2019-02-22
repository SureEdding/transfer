package org.suree.trade.param.bo;

import java.math.BigDecimal;

public class TransferRequestParamBO {

    private Integer fromAccountNo;

    private Integer toAccountNo;

    private BigDecimal amount;

    private String comments;

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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "TransferRequestParamBO{" +
                "fromAccountNo=" + fromAccountNo +
                ", toAccountNo=" + toAccountNo +
                ", amount=" + amount +
                ", comments='" + comments + '\'' +
                '}';
    }
}

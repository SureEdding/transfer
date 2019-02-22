package org.suree.trade.param.bo;

import java.math.BigDecimal;

public class TransferRequestParamBO {

    private Integer fromAccountNo;

    private Integer toAccountNo;

    private String token;

    private BigDecimal amount;

    private String comments;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "TransferRequestParamFactory{" +
                "fromAccountNo=" + fromAccountNo +
                ", toAccountNo=" + toAccountNo +
                ", token='" + token + '\'' +
                ", amount=" + amount +
                ", comments='" + comments + '\'' +
                '}';
    }
}

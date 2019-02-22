package org.suree.trade.param.dto;

import java.math.BigDecimal;

public class TransferRequestParamDTO {

    private Integer fromAccountNo;

    private Integer toAccountNo;

    private BigDecimal amount;

    private String comments;

    private String token;

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
        return "TransferRequestParamDTO{" +
                "fromAccountNo=" + fromAccountNo +
                ", toAccountNo=" + toAccountNo +
                ", amount=" + amount +
                ", comments='" + comments + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}

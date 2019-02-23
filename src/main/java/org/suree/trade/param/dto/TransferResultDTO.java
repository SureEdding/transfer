package org.suree.trade.param.dto;

public class TransferResultDTO {

    private Integer status;

    private String statusDesc;

    private Integer failCode;

    private String failDesc;

    private String tradeNo;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public Integer getFailCode() {
        return failCode;
    }

    public void setFailCode(Integer failCode) {
        this.failCode = failCode;
    }

    public String getFailDesc() {
        return failDesc;
    }

    public void setFailDesc(String failDesc) {
        this.failDesc = failDesc;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    @Override
    public String toString() {
        return "TransferResultDTO{" +
                "status=" + status +
                ", statusDesc='" + statusDesc + '\'' +
                ", failCode=" + failCode +
                ", failDesc='" + failDesc + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                '}';
    }
}

package org.suree.trade.enums;

public enum TransferFailedCodeEnum {

    LOCK_FAILED(1, "分布式锁获取失败"),
    LOGIC_ERROR(2, "转账逻辑校验失败"),
    ACCOUNT_NOT_EXSIST(3, "账户不存在"),
    BALANCE_NOT_ENOUGH(4, "账户余额不足"),
    TRANSACTION_ERROR(5, "事务错误"),


    INVALID_REQUEST(98, "非法请求"),
    UNKNOWN(99, "未知错误发生"),
    ;


    private Integer code;

    private String desc;

    TransferFailedCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}

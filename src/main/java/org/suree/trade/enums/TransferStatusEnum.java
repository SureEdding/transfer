package org.suree.trade.enums;

public enum  TransferStatusEnum {

    INIT(0, "初始"),
    SUCCESS(1, "成功"),
    FAIL(2, "失败"),
    ;

    private Integer code;

    private String desc;

    TransferStatusEnum(Integer code, String desc) {
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

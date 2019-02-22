package org.suree.trade.enums;

public enum  AccountTypeEnum {


    USER(0, "用户账户"),
    MERCHANT(1, "商家账户"),
            ;


    private Integer code;

    private String desc;

    AccountTypeEnum(Integer code, String desc) {
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

package org.suree.account.user.enums;

public enum OperateTypeEnum {

    ADD(0),
    MINUS(1),
    ;

    private int code;

    OperateTypeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

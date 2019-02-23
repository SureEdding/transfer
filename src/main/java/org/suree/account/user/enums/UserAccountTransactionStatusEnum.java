package org.suree.account.user.enums;

public enum UserAccountTransactionStatusEnum {


    INIT(0),
    COMMITTED(1),
    ROLLBACK(2),
    ;

    int code;

    UserAccountTransactionStatusEnum(Integer code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

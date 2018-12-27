package com.ooliuyue.springboot_aoptest.enums;

/**
 * @Auther: ly
 * @Date: 2018/12/27 11:46
 */

public enum EnumResultCode {
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    private final int code;

    EnumResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

package com.okay.querydsl.enm;

public enum EnumUserType {

    USER(1, "Kullanıcı"),
    ADMIN(2, "Admin");

    private int code;
    private String value;

    EnumUserType(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
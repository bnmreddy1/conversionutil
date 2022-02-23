package com.unit.conversion.model;

public class Code {

    String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    String value;

    public Code(String code, String value) {
        this.code = code;
        this.value = value;
    }
}

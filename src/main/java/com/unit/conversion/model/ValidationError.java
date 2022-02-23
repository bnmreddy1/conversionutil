package com.unit.conversion.model;

public class ValidationError {
    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    private Field field;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    private String error;

    public ValidationError(Field field, String error) {
        this.field = field;
        this.error = error;
    }
}

package com.unvise.com.task3.exception;

import java.util.InputMismatchException;

public class SensorInputMismatchedException extends InputMismatchException {
    protected Integer id;
    protected Double value;

    public SensorInputMismatchedException(String s) {
        super(s);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}

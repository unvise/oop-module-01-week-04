package com.unvise.com.task3.exception;

public class SensorIdInputMismatchedException extends SensorInputMismatchedException {
    public SensorIdInputMismatchedException(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return String.format(super.getMessage() + " Неправильное id: {%d}", id);
    }
}

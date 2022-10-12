package com.unvise.com.task3.exception;

public class SensorValueInputMismatchedException extends SensorInputMismatchedException {
    public SensorValueInputMismatchedException(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return String.format(super.getMessage() + " Неправильное значение: {%.1f}", value);
    }
}

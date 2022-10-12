package com.unvise.com.task3;

import com.unvise.com.task3.exception.SensorIdInputMismatchedException;
import com.unvise.com.task3.exception.SensorInputMismatchedException;
import com.unvise.com.task3.exception.SensorValueInputMismatchedException;

import static java.util.Objects.nonNull;

public class Sensor {
    private Integer id;
    private Double value;

    public Sensor(Integer id, Double value) throws SensorInputMismatchedException {
        checkId(id);
        checkValue(value);
        this.id = id;
        this.value = value;
    }

    private static void checkId(Integer id) throws SensorIdInputMismatchedException {
        if (nonNull(id) && (id < 10 || id > 99)) {
            SensorIdInputMismatchedException exception =
                    new SensorIdInputMismatchedException("Значение id:{} сенсора должно быть двухзначным");
            exception.setId(id);
            throw exception;
        }
    }

    private static void checkValue(Double value) throws SensorValueInputMismatchedException {
        if (nonNull(value) && (value < -50 || value > 50)) {
            SensorValueInputMismatchedException exception =
                    new SensorValueInputMismatchedException("Значение сенсора должно быть в диапазоне [-50, 50].");
            exception.setValue(value);
            throw exception;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) throws SensorIdInputMismatchedException {
        checkId(id);
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) throws SensorValueInputMismatchedException {
        checkValue(value);
        this.value = value;
    }

    @Override
    public String toString() {
        return id + " " + value;
    }
}

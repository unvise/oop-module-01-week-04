package com.unvise.com.task3;

import com.unvise.com.task3.exception.SensorReadIllegalArgumentException;

import java.util.Arrays;
import java.util.Comparator;

import static com.unvise.com.task3.Sensors.sensorsByAverage;

public class SensorsReader {
    private static final String DELIMITER = "@";
    private final Sensor[] data;

    public SensorsReader(String data) throws SensorReadIllegalArgumentException {
        try {
            String[][] rawData = splitData(data);
            this.data = convertToSensors(rawData);
        } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
            throw new SensorReadIllegalArgumentException("Строка не соответствует шаблону");
        }
    }

    public Sensor[] getData() {
        return data;
    }

    public String read() {
        StringBuilder stringBuilder = new StringBuilder();
        Sensor[] sensorsByAverage = sensorsByAverage(data);
        for (Sensor sensor : sensorsByAverage) {
            stringBuilder
                    .append(sensor)
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    public void sort(boolean byId, boolean byValue) {
        if (byId) Arrays.sort(data, Comparator.comparingInt(Sensor::getId));
        if (byValue) Arrays.sort(data, Comparator.comparingDouble(Sensor::getValue));
    }

    private Sensor[] convertToSensors(String[][] data) {
        Sensor[] newSensors = new Sensor[data.length];
        for (int i = 0; i < data.length; i++) {
            String rawId = data[i][0];
            String rawValue = data[i][1];
            newSensors[i] = new Sensor(Integer.parseInt(rawId), Double.parseDouble(rawValue));
        }
        return newSensors;
    }

    private String[][] splitData(String data) {
        String[] splitData = data.split(DELIMITER);
        return splitIdsAndValues(splitData);
    }

    private String[][] splitIdsAndValues(String[] rawData) {
        String[][] data = new String[rawData.length][2];
        for (int i = 0; i < rawData.length; i++) {
            String rawId = rawData[i].substring(0, 2);
            String rawValue = rawData[i].substring(2);
            data[i] = new String[]{rawId, rawValue};
        }
        return data;
    }
}

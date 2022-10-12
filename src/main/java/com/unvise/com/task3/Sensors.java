package com.unvise.com.task3;

import java.util.Arrays;

import static com.unvise.com.task3.ArrayUtils.isElementInArray;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Sensors {
    public static Sensor[] sensorsByAverage(Sensor[] data) {
        Sensor[] copiedData = Arrays.copyOf(data, data.length);
        Sensor[] res = createNewEmptySensors(copiedData.length);
        Integer[] uniqueIds = new Integer[copiedData.length];
        for (int i = 0; i < copiedData.length; i++) {
            Integer id = copiedData[i].getId();
            if (nonNull(id) && !isElementInArray(uniqueIds, id)) {
                res[i].setId(id);
                res[i].setValue(findAverageById(copiedData, id));
                uniqueIds[i] = id;
            }
        }
        return filterSensorFromNull(res);
    }

    public static Sensor[] filterSensorFromNull(Sensor[] data) {
        Sensor[] res = new Sensor[data.length - countNullSensors(data)];
        int resArrayIndex = 0;
        for (Sensor sensor : data) {
            if (nonNull(sensor.getId()) && nonNull(sensor.getValue())) {
                res[resArrayIndex] = sensor;
                resArrayIndex++;
            }
        }
        return res;
    }

    public static Integer countNullSensors(Sensor[] data) {
        Integer count = 0;
        for (Sensor sensor : data) {
            if (isNull(sensor.getId()) || isNull(sensor.getValue())) {
                count++;
            }
        }
        return count;
    }

    public static Sensor[] createNewEmptySensors(Integer length) {
        Sensor[] sensors = new Sensor[length];
        for (int i = 0; i < sensors.length; i++) {
            sensors[i] = new Sensor(null, null);
        }
        return sensors;
    }

    public static Double findAverageById(Sensor[] data, Integer id) {
        double res = 0d;
        int count = 0;
        for (Sensor sensor : data) {
            if (id.equals(sensor.getId())) {
                res += sensor.getValue();
                count++;
            }
        }
        return res / count;
    }
}

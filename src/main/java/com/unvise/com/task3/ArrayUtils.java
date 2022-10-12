package com.unvise.com.task3;

import java.util.Objects;

public class ArrayUtils {
    public static Boolean isElementInArray(Object[] array, Object target) {
        for (Object element : array) {
            if (Objects.equals(element, target)) {
                return true;
            }
        }
        return false;
    }
}

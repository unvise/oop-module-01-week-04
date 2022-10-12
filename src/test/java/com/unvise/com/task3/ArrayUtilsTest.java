package com.unvise.com.task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    @Test
    void isElementInArray() {
        // given
        Object[] arr = {12, "asd", true};
        // then
        assertAll(
                () -> assertEquals(true, ArrayUtils.isElementInArray(arr, 12)),
                () -> assertEquals(true, ArrayUtils.isElementInArray(arr, "asd")),
                () -> assertEquals(false, ArrayUtils.isElementInArray(arr, false))
        );
    }
}
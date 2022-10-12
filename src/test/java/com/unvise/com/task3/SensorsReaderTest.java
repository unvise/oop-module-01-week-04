package com.unvise.com.task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SensorsReaderTest {

    @Test
    void readTest() {
        // given
        SensorsReader reader = new SensorsReader("3744@3742@6646@63-4@461@127");
        reader.sort(true, false);
        String text = """
                12 7.0
                37 43.0
                46 1.0
                63 -4.0
                66 46.0
                """;
        // then
        assertEquals(text, reader.read());
    }
}
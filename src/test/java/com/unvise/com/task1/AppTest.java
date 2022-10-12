package com.unvise.com.task1;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void readLines() throws IOException {
        // given
        String excepted = """
                Lorem ipsum dolor sit amet,
                                
                Phasellus vehicula scelerisque orci.
                """;
        URL testFileURL = getClass().getClassLoader().getResource("task1/test.txt");
        File file = new File(Objects.requireNonNull(testFileURL).getFile());
        // then
        assertEquals(excepted, App.readLines(file.getAbsolutePath()));
    }
}
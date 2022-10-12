package com.unvise.com.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimitiveWrapperTypesCasterTest {

    @Test
    void cast() {
        // given
        String inp1 = "32";
        String inp2 = "c";
        String inp3 = "32.52";
        String inp4 = "char";
        String inp5 = "32.52";
        // then
        assertAll(
                () -> assertEquals(Integer.parseInt(inp1), PrimitiveWrapperTypesCaster.cast(inp1, "integer")),
                () -> assertEquals(inp2.charAt(0), PrimitiveWrapperTypesCaster.cast(inp2, "char")),
                () -> assertEquals(Double.parseDouble(inp3), PrimitiveWrapperTypesCaster.cast(inp3, "double")),
                () -> assertThrows(IllegalArgumentException.class, () -> PrimitiveWrapperTypesCaster.cast(inp4, "char")),
                () -> assertThrows(NumberFormatException.class, () -> PrimitiveWrapperTypesCaster.cast(inp5, "integer"))
        );
    }
}
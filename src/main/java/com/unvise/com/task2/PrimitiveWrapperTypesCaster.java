package com.unvise.com.task2;

public class PrimitiveWrapperTypesCaster {
    public static Object cast(String message, String type) throws IllegalArgumentException {
        return switch (type.trim().toLowerCase()) {
            case "byte" -> Byte.parseByte(message);
            case "short" -> Short.parseShort(message);
            case "int", "integer" -> Integer.parseInt(message);
            case "long" -> Long.parseLong(message);
            case "float" -> Float.parseFloat(message);
            case "double" -> Double.parseDouble(message);
            case "boolean" -> Boolean.parseBoolean(message);
            case "char", "character" -> {
                if (message.length() > 1) {
                    throw new IllegalArgumentException("Должен быть только символ");
                }
                yield message.charAt(0);
            }
            default -> "Нет такого примитивного типа данных";
        };
    }
}

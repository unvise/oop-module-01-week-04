package com.unvise.com.task2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner stringScanner = new Scanner(System.in)) {
            System.out.print("Введите сообщение: ");
            String inputData = stringScanner.nextLine();
            System.out.print("Введите тип: ");
            String inputType = stringScanner.nextLine();

            try {
                System.out.println(PrimitiveWrapperTypesCaster.cast(inputData, inputType));
            } catch (NumberFormatException e) {
                System.out.println("Ошибка при приведении сообщения к числу. Сообщение ошибки: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка при приведении сообщения. Сообщение ошибки: " + e.getMessage());
            }
        }
    }
}

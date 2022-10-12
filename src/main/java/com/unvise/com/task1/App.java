package com.unvise.com.task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner stringScanner = new Scanner(System.in)) {
            System.out.print("Абсолютный путь до файла: ");
            System.out.println(readLines(stringScanner.nextLine()));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден...");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла. Сообщение: " + e.getLocalizedMessage());
            System.exit(1);
        }
    }

    public static String readLines(String fileToPath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToPath));
        String content;
        StringBuilder stringBuilder = new StringBuilder();
        while ((content = bufferedReader.readLine()) != null) {
            stringBuilder
                    .append(content)
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}

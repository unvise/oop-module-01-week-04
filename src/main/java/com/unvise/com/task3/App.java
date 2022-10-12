package com.unvise.com.task3;

import com.unvise.com.task3.exception.SensorInputMismatchedException;
import com.unvise.com.task3.exception.SensorReadIllegalArgumentException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner strScanner = new Scanner(System.in)) {
            String data = strScanner.nextLine();
            if (data.length() > 512) {
                throw new StringIndexOutOfBoundsException();
            }
            SensorsReader sensorReader = new SensorsReader(data);
            System.out.print("Сортировать 1) по возрастанию id 2) возрастанию средней температуры: ");

            int sortOption = strScanner.nextInt();
            if (sortOption == 1)
                sensorReader.sort(true, false);
            else if (sortOption == 2)
                sensorReader.sort(false, true);
            else
                throw new InputMismatchException();

            System.out.println(sensorReader.read());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Строка не должна превышать 512 символов...");
        } catch (SensorInputMismatchedException | SensorReadIllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
        } catch (InputMismatchException e) {
            System.out.println("Неправильная опция сортировки...");
        }
    }
}

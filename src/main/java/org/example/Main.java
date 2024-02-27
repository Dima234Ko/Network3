package org.example;


import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Workbook book;
        String NewIP;
        FileInputStream fis;
        int city;
        boolean QNQ;


        Exel exel = new Exel();
        book = exel.getBook();
        fis = exel.getFis();

        while (true) {

            city = getCity();

            IP ip = new IP();
            NewIP = ip.installNewIP(city, book);

            if (city == 2) {
                QNQ = yesQNQ();
            } else
                break;

            if (QNQ) {
                String NumberQNQ = getQnqVlan();
                System.out.println(NumberQNQ);
                break;
            } else
                break;
        }


        System.out.println(NewIP);
        Exel.write(book, fis);

    }

    public static boolean yesQNQ() {

        boolean YesQNQ;

        while (true) {

            System.out.println("Уточните используется ли QNQ \n" +
                    "1 - да \n" +
                    "2 - нет");
            Scanner scannerQNQ = new Scanner(System.in);
            int Number = Integer.parseInt(scannerQNQ.nextLine());

            if (Number == 1) {
                YesQNQ = true;
                break;
            } else if (Number == 2) {
                YesQNQ = false;
                break;
            } else
                System.out.println("Введите верное значение");
            continue;
        }

        return YesQNQ;
    }

    public static int getCity() {

        while (true) {
            System.out.println("Выберите населенный пункт где нужно выделить интерфейс \n" +
                    "1 - Западная Якутия \n" +
                    "2 - Костромская область");
            Scanner scanner = new Scanner(System.in);
            int city = Integer.parseInt(scanner.nextLine());
            if (city == 1 | city == 2) {
                return city;
            } else
                System.out.println("Введите верное значение");
            continue;
        }
    }

    public static String getQnqVlan() {

        String QNQVlan;

        System.out.println("Уточните населенный пункт из списка");
        System.out.println(Arrays.toString(Country.values()));
        Scanner scannerCountry = new Scanner(System.in);
        String country = scannerCountry.nextLine();

        switch (country) {
            case ("Мантурово"):
                QNQVlan = Country.Мантурово.getVlan();
                break;
            default:
                System.out.println("Введите верное значение");
                QNQVlan = "Ошибка";
                break;
        }

        return QNQVlan;

    }
}
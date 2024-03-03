package org.example;


import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Workbook book;
    static String NewIP;
    static String QNQVlan;
    static FileInputStream fis;
    static String City;

    public static void main(String[] args) {
        while (true) {
            Exel exel = new Exel();
            book = exel.getBook();
            fis = exel.getFis();

            Polls city = new Polls();
            City = city.getCity();

            IP ip = new IP();
            NewIP = ip.installNewIP(City, book);

            if (!City.equals("Западная Якутия") & !City.equals("Костромская область")) {
                QNQVlan = city.getQnqVlan(City);
                //Получаем QNQ Vlan
            }

            Cell cellVlan = exel.searchCell(book, City);
            // Получаем Ячейку с Vlan

            String Vlan = Exel.getTextCell(cellVlan);
            // Получаем последний использованный Vlan из таблицы

            Vlan vlan = new Vlan();
            String NewVlan = vlan.getNewVlan(Vlan);
            // Получаем новый Vlan

            exel.setCellInt(cellVlan, NewVlan);
            // Записать новый Vlan

            Cisco cisco = new Cisco();
            cisco.requestResult(NewIP, QNQVlan, NewVlan, City);
            //Сформировать команды Cisco
            System.out.println("");

            cisco.fillInTheDetails(NewIP, QNQVlan, NewVlan, City);
            //Записать данные с Cisco
            System.out.println("");

            while (true) {

            System.out.println("Записать данные в Exel?" + "\n" +
                    "1 - да" + "\n" + "2 - нет");
            Scanner scanner = new Scanner(System.in);
            String save = scanner.nextLine();

            if (save.equals("1")) {
                Exel.write(book, fis);
                System.out.println("Данные записаны!");
                break;
            } else if (save.equals("2")) {
                break;
            } else
                System.out.println("Введите верное значение");
                continue;
            }
            System.out.println("");
            //Сохранение данных в Exel
        }
        //Сохранить документ
/*
        System.out.println(NewIP);
        System.out.println("QNQ Vlan: " + QNQVlan);
        System.out.println("Последний Vlan: " + Vlan);
        System.out.println("Новый Vlan: " + NewVlan);
*/
    }
}
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


        Exel exel = new Exel();
        book = exel.getBook();
        fis = exel.getFis();

        Polls city = new Polls();
        City = city.getCity();

        IP ip = new IP();
        NewIP = ip.installNewIP(City, book);

        if (!City.equals("Западная Якутия")&!City.equals("Костромская область")) {
            QNQVlan = city.getQnqVlan(City);
            //Получаем QNQ Vlan
        }

        Cell cellVlan = exel.searchCell(book,City);
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

        Exel.write(book, fis);
        //Сохранить документ
/*
        System.out.println(NewIP);
        System.out.println("QNQ Vlan: " + QNQVlan);
        System.out.println("Последний Vlan: " + Vlan);
        System.out.println("Новый Vlan: " + NewVlan);
*/
    }
}
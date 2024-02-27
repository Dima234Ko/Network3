package org.example;



import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Workbook book;
        String NewIP;
        FileInputStream fis;

        Exel exel = new Exel();
        book = exel.getBook();
        fis = exel.getFis();

        while (true) {
        System.out.println("Выберите населенный пункт где нужно выделить интерфейс \n" +
                "1 - Западная Якутия \n" +
        "2 - Костромская область");
        Scanner scanner = new Scanner(System.in);
        int city = Integer.parseInt(scanner.nextLine());

        IP ip = new IP();
        NewIP = ip.installNewIP(city, book);



        System.out.println("Уточните населенный пункт из списка");
        System.out.println(Arrays.toString(Country.values()));
        Scanner scannerCountry = new Scanner(System.in);
        String country = scannerCountry.nextLine();

        Vlan vlan = new Vlan();

        if (country.equals("Мантурово")){
            Country thisCountry = Country.Мантурово;
            vlan.getVlan(thisCountry);
        }

            System.out.println(NewIP);
            Exel.write(book, fis);
        }

    }








}
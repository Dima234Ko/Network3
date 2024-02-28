package org.example;


import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Workbook book;
    static String NewIP;
    static String NewVlan;
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

        Vlan vlan = new Vlan();
        NewVlan = vlan.getVlan(City);

        System.out.println(NewIP);
        Exel.write(book, fis);

    }
}
package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;


public class IP {

    public String installNewIP (String city, Workbook book) {

        Cell cell = null;
        int numberStart = -1;
        String lastIP;
        String newIP;
        int lastNumber = -1;


        if (city.equals("Западная Якутия")) {
            cell = book.getSheetAt(0).getRow(1).getCell(2);
        } else  {
            cell = book.getSheetAt(0).getRow(2).getCell(2);
        }


        lastIP = String.valueOf(Exel.getCellText(cell));
        int index = lastIP.lastIndexOf(".");
        lastNumber = Integer.parseInt(lastIP.substring(index + 1)) + 1;
        newIP = lastIP.substring(0, index + 1) + lastNumber;

        Exel.setCellText(cell, newIP);
        return newIP;
    }
}

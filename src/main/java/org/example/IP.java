package org.example;

import org.apache.poi.ss.usermodel.Workbook;

import static org.example.Main.getCellText;

public class IP {

    public String installLastIP (Workbook book) {

        int numberStart = -1;
        String lastIP;
        int lastNumber = -1;

        lastIP = String.valueOf(getCellText(book.getSheetAt(0).getRow(0).getCell(0)));

        int index = lastIP.lastIndexOf(".");
        lastNumber = Integer.parseInt(lastIP.substring(index + 1)) + 1;
        lastIP = lastIP.substring(0, index + 1) + lastNumber;
        return lastIP;

    }

}

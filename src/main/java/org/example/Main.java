package org.example;



import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        String lastIP;

        Workbook book;
        FileInputStream fis;
        try {
            fis = new FileInputStream("filename.xls");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            book = new HSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        lastIP = String.valueOf(getCellText(book.getSheetAt(0).getRow(0).getCell(0)));

        setNewIP(book, lastIP);

        write(book, fis);


        //   System.out.println(lastIP);



    }

    public static String getCellText(Cell cell) {

                switch (cell.getCellType()) {
                    case STRING:
                        return cell.getRichStringCellValue().getString();
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            return String.valueOf(cell.getDateCellValue());
                        } else {
                            return String.valueOf(cell.getNumericCellValue());
                        }
                    case BOOLEAN:
                        return String.valueOf(cell.getBooleanCellValue());
                    case FORMULA:
                        return String.valueOf(cell.getCellFormula());
        }
        return null;
    }
    public static void write(Workbook book, FileInputStream fis){
        //Записать и закрыть
        try (FileOutputStream out = new FileOutputStream(new File("filename.xls"))) {
            book.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void setNewIP (Workbook book, String lastIP){
        Row row;
        Cell cell;

        Sheet sheet1 = book.getSheet("Лист1");
        row = sheet1.createRow(0);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue(lastIP + 1);
    }
}
package org.example;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;

public class Exel {

    public Workbook book;
    public FileInputStream fis;


    public FileInputStream getFis () {
        try {
            fis = new FileInputStream("filename.xls");
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return fis;
    }

    public Workbook getBook () {

        fis = getFis();

        try {
            book = new HSSFWorkbook(fis);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        return book;
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

    public static void setCellText (Cell cell, String newIP){
        cell.setCellValue(newIP);
    }

}
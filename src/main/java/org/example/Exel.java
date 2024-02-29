package org.example;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;

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

    public static void setCellText (Cell cell, String text){
        cell.setCellValue(text);
    }
    //Записать новое значение в ячейку

    public static void setCellInt (Cell cell, String text){
        int textCell = Integer.parseInt(text);
        cell.setCellValue(textCell);
    }
    //Записать новое число в ячейку

    public static Cell searchCell (Workbook book, String city) {

        Cell cell = null;
        Cell cell1 = null;

        for (int i = 1; i < 16; i++) {
            cell = book.getSheetAt(0).getRow(i).getCell(0);
            String text = String.valueOf(Exel.getCellText(cell));

            if (city.equals(text)) {
                cell1 = book.getSheetAt(0).getRow(i).getCell(1);
                break;
            }
        }
        return cell1;
    }

    public static String getTextCell (Cell cellVlan) {
        String LastVlan = String.valueOf(Exel.getCellText(cellVlan));
        int index = LastVlan.lastIndexOf(".");
        LastVlan = LastVlan.substring(0, index);
        return LastVlan;
    }


}

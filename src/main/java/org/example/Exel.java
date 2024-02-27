package org.example;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exel {

    Workbook book;
    FileInputStream fis;


    public FileInputStream getBook () {
        try {
            fis = new FileInputStream("filename.xls");
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return fis;
    }

    public Workbook getFis () {
        try {
            book = new HSSFWorkbook(fis);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

}

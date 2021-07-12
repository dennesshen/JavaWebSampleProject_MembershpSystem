/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javawebsampleproject_membershipsystem.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilForExcelService {

    private XSSFWorkbook workbook;
    String path2 = "./src/main/java/com/mycompany";
    String path3 = "/javawebsampleproject_membershipsystem/database/MemberShipExel.xlsx";

    public UtilForExcelService() throws Exception {
        InputStream is = new FileInputStream(path2 + path3);
        this.workbook = new XSSFWorkbook(is);
    }

    public void readExcel(int column, int row) throws IOException {

        XSSFSheet sheet = workbook.getSheet("MemberData");
        XSSFRow excelRow = sheet.getRow(row);
        XSSFCell cell = excelRow.getCell(column);
        //System.out.println("測試");
        if (cell == null) {
            System.out.println("沒有東西");
        } else {
            System.out.println(cell);
        }
    }

    public static void main(String[] args) throws Exception {
        UtilForExcelService ufes = new UtilForExcelService();
        for (int i = 0; i < 5; i++) {
            ufes.readExcel(i, i);
        }

    }

}

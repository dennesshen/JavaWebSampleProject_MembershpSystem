/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javawebsampleproject_membershipsystem.controller;

import java.io.File;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author denne
 */
public class TestExcel {

    public void ExcelBuild() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("測試頁1");
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(5);
        cell.setCellValue("JAVA1234EXCEL");
        String path2 ="./src/main/java/com/mycompany";
        String path3 = "/javawebsampleproject_membershipsystem/database/testExcel.xlsx";
        System.out.println("創建EXCL檔開始");
        File file = new File(path2+path3);
        workbook.write(file);
        System.out.println("創建EXCL檔成功");
    }

    public static void main(String[] args) throws IOException {
        new TestExcel().ExcelBuild();

    }

}

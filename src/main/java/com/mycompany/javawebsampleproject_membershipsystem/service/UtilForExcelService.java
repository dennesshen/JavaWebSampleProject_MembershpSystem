/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javawebsampleproject_membershipsystem.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilForExcelService {

    public static int allMemberUpLimit = 100;
    String path1 = "C:/Users/denne/OneDrive/文件/NetBeansProjects/JavaWebSampleProject_MembershipSystem";
    String path2 = "/src/main/java/com/mycompany";
    String path3 = "/javawebsampleproject_membershipsystem/database/MemberShipExel.xlsx";
    String path = path1 + path2 + path3;
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow firstEmptyRow;
    private static int emptyRowNumber;

    public UtilForExcelService() throws Exception {
        InputStream is = new FileInputStream(path);
        this.workbook = new XSSFWorkbook(is);
        this.sheet = this.workbook.getSheet("MemberData");            
        findEmptyRowNumber();
        setFirstEmptyRow();
    }

    public int getEmptyRowNumber() {
        return emptyRowNumber;
    }

    public static XSSFRow getFirstEmptyRow() {
        return firstEmptyRow;
    }
    
    private static void setFirstEmptyRow() {
        firstEmptyRow = sheet.createRow(emptyRowNumber);
    }
    
    public void findEmptyRowNumber() throws IOException{
        int row = 0;
        while (!checkExcelRowEmpty(row)) {            
            row++;
        }
        emptyRowNumber = row; 
    }
    public String readExcel(int column, int row) throws IOException {
        String returnValue = "";
        XSSFRow excelRow = sheet.getRow(row);
        if (excelRow == null) {
            returnValue = "emptyRow";
        } else {
            XSSFCell cell = excelRow.getCell(column);
            if (cell == null) {
                returnValue = "";
            } else {
                returnValue = ExcelDataMapToString(cell);
            }
        }
        return returnValue;
    }

    public void ExcelWriter(int column, int row, String inputString) throws FileNotFoundException {
        XSSFRow rowOfWrite = getFirstEmptyRow();
        XSSFCell cellOfWrite = rowOfWrite.createCell(column);
        cellOfWrite.setCellValue(inputString);
        FileOutputStream fos = new FileOutputStream(path);
        try {
            workbook.write(fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
        }
    }

    // 找尋指定Column下，指定範圍的格子當中，是否有與指定checkItem 相同的值，
    // 有的話回傳該格位於第幾列，沒有的話回傳-1。
    public int checkColumnWhichMatch(int column, String checkItem, int rowStart, int rowEnd) throws IOException {
        int row = rowStart;
        int returnValue = -1;
        while (row <= rowEnd) {
            if (readExcel(column, row).equals(checkItem)) {
                returnValue = row;
            }
            row++;
        }
        return returnValue;
    }

    public boolean checkExcelRowEmpty(int row) throws IOException {
        return readExcel(0, row).equals("emptyRow");
    }

    public String ExcelDataMapToString(XSSFCell cell) {
        String returnValue = "";
        switch (cell.getCellTypeEnum()) {
            case NUMERIC:
                returnValue = String.format("%f", cell.getNumericCellValue());
                break;
            case STRING:
                returnValue = String.format("%s", cell.getStringCellValue());
                break;
        }
        return returnValue;
    }
}

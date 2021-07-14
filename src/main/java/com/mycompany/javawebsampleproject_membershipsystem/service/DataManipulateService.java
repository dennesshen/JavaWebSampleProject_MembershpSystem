/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javawebsampleproject_membershipsystem.service;

/**
 *
 * @author denne
 */
public class DataManipulateService {

    public static boolean checkPassword(String accountName, String passWord) throws Exception {
        UtilForExcelService ufes = new UtilForExcelService();
        boolean check = false;
        int RowNumber = ufes.checkColumnWhichMatch(0, accountName, 0, 100);
        if (RowNumber != -1) {
            check = ufes.readExcel(1, RowNumber).equals(passWord);
        }
        return check;
    }

    public static String[] getMemberData(String accountName) throws Exception {
        UtilForExcelService ufes = new UtilForExcelService();
        int checkRow = ufes.checkColumnWhichMatch(0, accountName, 0, 100);
        String returnName = "";
        String returnBirth = "";
        String returnVIP = "";
        try {
            returnName = ufes.readExcel(2, checkRow);
            returnBirth = ufes.readExcel(3, checkRow);
            returnVIP = ufes.readExcel(4, checkRow);
        } catch (Exception e) {
        }
        String[] returnData = {returnName, returnBirth, returnVIP};
        return returnData;
    }

    public static boolean registerDataWriteIn(String[] registerData) throws Exception {
        UtilForExcelService ufes = new UtilForExcelService();
        boolean successWriteIn = false;
        String a = registerData[0];
        String b = registerData[1];
        String c = registerData[2];
        String d = registerData[3];
        int accountIfExist = ufes.checkColumnWhichMatch(0, registerData[0], 0, UtilForExcelService.allMemberUpLimit);

        if (accountIfExist == -1) {
            ufes.ExcelWriter(0, ufes.getEmptyRowNumber(), a);
            ufes.ExcelWriter(1, ufes.getEmptyRowNumber(), b);
            ufes.ExcelWriter(2, ufes.getEmptyRowNumber(), c);
            ufes.ExcelWriter(3, ufes.getEmptyRowNumber(), d);
            ufes.ExcelWriter(4, ufes.getEmptyRowNumber(), "4");
            ufes.ExcelWriter(5, ufes.getEmptyRowNumber(), "4");
            successWriteIn = true;
        }
        return successWriteIn;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javawebsampleproject_membershipsystem.service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author denne
 */
public class DataManipulateService {
    public static Map<String,String> users = new LinkedHashMap<>();
    static {
        users.put("John", "1234");
        users.put("Mary", "5678");
        users.put("Jean", "0000");
        users.put("admin", "9999");
    }
    
    public static boolean checkPassword(String accountName,String passWord){
        boolean check = users.entrySet().stream()
                             .filter(t -> t.getKey().equals(accountName) 
                                    && t.getValue().equals(passWord))
                             .findAny()
                             .isPresent();
        
        return check;
    }
    
    
}

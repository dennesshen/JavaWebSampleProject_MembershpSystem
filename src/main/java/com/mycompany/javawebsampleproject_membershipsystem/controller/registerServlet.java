/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javawebsampleproject_membershipsystem.controller;

import com.mycompany.javawebsampleproject_membershipsystem.service.DataManipulateService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author denne
 */
@WebServlet("/controller/registerServlet")
public class registerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        String registerAccountName = req.getParameter("registerAccountName");
        String registerPassword = req.getParameter("registerPassword");
        String registerPasswordComfirm = req.getParameter("registerPasswordComfirm");
        String registerAuthorCode = req.getParameter("registerAuthorCode");
        String memberName = req.getParameter("memberName");
        String memberBirth = req.getParameter("memberBirth");
        String authorCode = session.getAttribute("authorCode").toString();
        if (!registerAuthorCode.equals(authorCode)) {
            resp.getWriter().println("認證碼錯誤,請重新輸入");
            return;
        }
        if (!registerPassword.equals(registerPasswordComfirm)) {
            resp.getWriter().println("註冊密碼確認錯誤,請重新註冊");
            return;
        }
        String[] registerData = {registerAccountName, registerPassword, memberName, memberBirth};
        boolean successWriteIn = false;
        try {
            successWriteIn = DataManipulateService.registerDataWriteIn(registerData);
        } catch (Exception ex) {
        }
        if (successWriteIn) {
            resp.getWriter().println("註冊成功，感謝註冊");
        } else {
            resp.getWriter().println("註冊帳號已有人使用，請使用其他帳號");
        }
    }

}

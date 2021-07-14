/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javawebsampleproject_membershipsystem.controller;

import com.mycompany.javawebsampleproject_membershipsystem.service.DataManipulateService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/requestDataServlet")
public class RequestDataServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountName = req.getParameter("accountName");
        String password = req.getParameter("password");
        String[] memberData = {"", "", ""};
        try {
            memberData = DataManipulateService.getMemberData(accountName);
        } catch (Exception ex) {
        }
        String memberName = memberData[0];
        String memberBirth = memberData[1];
        String memberVIP = memberData[2];

        req.setAttribute("memberName", memberName);
        req.setAttribute("memberBirth", memberBirth);
        req.setAttribute("memberVIP", memberVIP);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/dataPage.jsp");
        rd.forward(req, resp);
    }

}

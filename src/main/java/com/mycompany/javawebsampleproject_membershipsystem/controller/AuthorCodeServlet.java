/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javawebsampleproject_membershipsystem.controller;

import com.mycompany.javawebsampleproject_membershipsystem.controller.utils.UtilsOfAuthorCode;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/contoller/AuthorCodeServlet")
public class AuthorCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int randomNumber = new Random().nextInt(10000);
        HttpSession session = request.getSession();
        session.setAttribute("authorCode", randomNumber);
        String authorCode = String.format("%04d", randomNumber);
        ImageIO.write(UtilsOfAuthorCode.getAuthImg(authorCode), "JPEG", response.getOutputStream());
    }
}

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>登入頁面</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
        
    </head>
    <body style="padding: 20px" >
        <form class="pure-form" method = "post" action = "/JavaWebSampleProject_MembershipSystem/controller/requestDataServlet">
            <fieldset>
                <legend>登入系統</legend>
                
                <input type="text"  placeholder="請輸入帳號"   name = "accountName" /><p />
                <input type ="text"  placeholder="請輸入密碼"  name ="password" /><p />
                <input type="text"   placeholder="請輸入右圖中數字"  name="enterAuthorCode">
                <img src="/JavaWebSampleProject_MembershipSystem/contoller/AuthorCodeServlet" valign="middle"><p />
                
                <button type="submit" class="pure-button pure-button-primary">登入</button>
                <button type="reset" class="pure-button pure-button-primary">重填</button>
                <button type="button" 
                             class="pure-button pure-button-primary"
                             onclick="location.href='/JavaWebSampleProject_MembershipSystem/forms/registerPage.jsp' " >新註冊</JavaWebSampleProject_MembershipSystem/forms//button>

            </fieldset>
        </form>

    </body>
</html>
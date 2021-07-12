<%-- 
    Document   : registerPage
    Created on : 2021/7/9, 上午 10:44:02
    Author     : denne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>註冊頁面</title>
    </head>
    <body style="padding: 20px">
        <form class="pure-form" method="post" action="/JavaWebSampleProject_MembershipSystem/controller/registerServlet">
            <fieldset>
                <legend><h1>註冊</h1></legend>
                註冊帳號 : <input type="text" name="registerAccountName" /><p/> 
                註冊密碼 : <input type="text" name="registerPassword" /><p/> 
                密碼確認 : <input type="text" name="registerPasswordComfirm" /><p/>
                圖形認證 : <input type="text" name="registerAuthorCode"/>
                <img src="/JavaWebSampleProject_MembershipSystem/contoller/AuthorCodeServlet" valign="middle"><p/>
                <button type="submit" class="pure-button pure-button-primary">註冊</button> 
                <button type="reset" class="pure-button pure-button-primary">重填</button> 
            </fieldset>
    </body>
</html>

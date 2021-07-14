<%-- 
    Document   : dataPage
    Created on : 2021/7/13, 下午 07:49:54
    Author     : denne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
        <title>Data Page</title>
    </head>
    <body style="padding: 20px">
        <table class="pure-table">
            <thead>
                <tr>
                    <th></th>
                    <th>客戶資料</th>
                </tr>
            </thead>
            <tbody>
                <tr class="pure-table-odd">
                    <td>客戶姓名</td>
                    <td><%=request.getAttribute("memberName") %></td>
                </tr>
                <tr>
                    <td>客戶生日</td>
                    <td><%=request.getAttribute("memberBirth")%></td>
                </tr>
                <tr class="pure-table-odd">
                    <td>VIP等級</td>
                    <td>第<%=request.getAttribute("memberVIP")%>級</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>

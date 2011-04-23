<%-- 
    Document   : InvalidData
    Created on : Apr 21, 2011, 1:31:38 AM
    Author     : trigueros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invalid Data</title>
    </head>
    <body>
        <h1>You no Enter Proper Info!!!</h1>
        <img src="http://www.gamesprays.com/images/icons/trollface-3078_preview.jpg"/>
        <p>
            Reason  :<%= request.getSession().getAttribute("message")%><br>
            Username:<%= request.getSession().getAttribute("username")%><br>
            Password:<%= request.getSession().getAttribute("password")%><br>
            Email   :<%= request.getSession().getAttribute("email")%><br>
            Phone   :<%= request.getSession().getAttribute("phone")%><br>
        </p>
    </body>
</html>

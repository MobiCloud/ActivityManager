<%-- 
    Document   : index
    Created on : Dec 7, 2010, 2:13:03 PM
    Author     : Fred, Guofu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Redirector</title>
    </head>
    <body>
        Redirecting. 
        If you haven't been redirect in 5 seconds,
        If you are a mobile phone user,click <a href="Login.jsp">here</a>.
        For PC users, click <a href="Login.jsp">here</a>.
        <%
            //response.sendRedirect("Login.jsp");
            String header=request.getHeader("user-agent");
            if(header.indexOf("Android") != -1 || header.indexOf("iPhone") != -1)
            {
                response.sendRedirect("Login.jsp");
            }
            else
            {
                response.sendRedirect("PC/Login.jsp");
            }
        %>
    </body>
</html>

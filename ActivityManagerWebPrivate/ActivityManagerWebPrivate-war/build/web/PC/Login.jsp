<%-- 
    Document   : Login
    Created on : Dec 7, 2010, 2:15:03 PM
    Author     : Fred Morstatter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Activity Manager - Login</title>
    </head>
    <body>
        PC Login snthaouethaonsuhetao
        <form action="CheckLogin" method="post">
                Username: <input name="username" type="text" /><br/>
                Password: <input name="password" type="password" /><br/>
                <input type="submit" value="Login" />
        </form>
    </body>
    <br/>
    <input type="button" onclick="window.location='Register.jsp';" value="Register">
</html>

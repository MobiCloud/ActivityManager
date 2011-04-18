<%-- 
    Document   : Register
    Created on : Dec 7, 2010, 3:43:17 PM
    Author     : Fred
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register New User</title>
    </head>
    <body>
        <form action="RegisterNewUser" method="post">
            Username: <input type="text" name="username"/><br/>
            Password: <input type="text" name="password"/><br/>
            Password Confirmation: <input type="text" name="password2" /><br/>
            Email: <input type="text" name="email" /><br/>
            Phone Number: <input type="text" name="phoneNumber" /><br/>
            <input type="submit" value="Register" /><br/>
        </form>
    </body>
</html>

<%-- 
    Document   : Login
    Created on : Dec 7, 2010, 2:15:03 PM
    Author     : Fred Morstatter, Guofu Xiong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Activity Manager - Login</title>
        <link rel="stylesheet" type="text/css" href="CSS/css.css" />
    </head>
    <body>
        <div id="login_upper">
            <img alt="logo"  src="images/upper_logo.jpg" border="0" style="width:70%;">
        </div>
        <div id="login_mid">
        </div>
        <div id="login_form">
            <form action="../CheckLogin" method="post">
                Username: <br/>
                <input name="username" type="text" class="login_input"/><br/>
                Password: <br/>
                <input name="password" type="password"  class="login_input"/><br/><br/>
                <input type="submit" value="Login" class="login_button"/><br/><br/>
                <input type="button" onclick="window.location='Register.jsp';" value="Register" class="login_button">
            </form>
        </div>
        <br/>
        <div id="login_buttom">
        This site is created for CSE 486<br/>
        Arizona State University<br/>
        </div>
    </body>  
</html>

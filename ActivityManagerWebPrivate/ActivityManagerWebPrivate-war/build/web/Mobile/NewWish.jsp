<%-- 
    Document   : NewWish
    Created on : Dec 7, 2010, 3:16:28 PM
    Author     : Fred
--%>

<%@page import="edu.asu.edu.snac.activitymanager.util.CheckLoggedIn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
    String loggedInUser = CheckLoggedIn.checkLoggedIn(request, response);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Wish</title>
        <link rel="stylesheet" type="text/css" href="CSS/wishList.css" />
    </head>
    <body>
    <div id="wishNew_upper">
            <img alt="logo" src="images/new_wish_logo.jpg" border="0" style="width:100%;">
    </div>
    <div id="wishNew_mid">
    </div>
    <div id="wishNew_form">
        <form action="../ProcessNewWish" method="post">
            Sport: <br/>
            <input type="text" name="sport" class="wishNew_input"/><br/>
            Start Time: <br/>
            <input type="text" name="starttime" class="wishNew_input"/><br/>
            End Time: <br/>
            <input type="text" name="endtime" class="wishNew_input"/><br/>
            Location: <br/>
            <input type="text" name="location" class="wishNew_input"/><br/>
            Date: <br/>
            <input type="text" name="date" class="wishNew_input"/><br/><br/>
            <input type="submit" value="Add New Wish" class="wishNew_buttom"/><br/><br/>
            <input type="button" onclick="window.location='WishList.jsp'" value="Cancel" class="wishNew_buttom"/><br/><br/>
        </form>
    </div>
    </body>
</html>

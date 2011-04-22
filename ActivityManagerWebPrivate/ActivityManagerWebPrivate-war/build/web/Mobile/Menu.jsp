<%-- 
    Document   : Menu
    Created on : Dec 7, 2010, 2:38:36 PM
    Author     : Fred Morstatter
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
        <title>Activity Manager - Menu - <%= loggedInUser %></title>
        <link rel="stylesheet" type="text/css" href="CSS/menu.css" />
    </head>
    <body>
        <div id="menu_upper">
            <img alt="logo"  src="images/menu_upper.jpg" border="0" style="width:70%">
        </div>
        <div id="menu_mid">
        </div>
        <div>
            <hr/>
        <div class="menu_items"><a href="WishList.jsp">My Wishes</a></div>
            <hr/>
        <div class="menu_items"><a href="InviteList.jsp">My Invitations</a></div>
            <hr/>
        <div class="menu_items"><a href="AllInvitations.jsp">All Invitations</a></div>
            <hr/>
        <div class="menu_items"><a href="Login.jsp">Log out</a></div>
            <hr/>
        </div>
    </body>
</html>

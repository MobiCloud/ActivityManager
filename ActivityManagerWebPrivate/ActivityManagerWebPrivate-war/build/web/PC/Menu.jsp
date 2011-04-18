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
    </head>
    <body>
        <a href="WishList.jsp">My Wishes</a><br/>
        <a href="InviteList.jsp">My Invitations</a><br/>
        <a href="AllInvitations.jsp">All Invitations</a>
    </body>
</html>

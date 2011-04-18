<%-- 
    Document   : WishList
    Created on : Dec 7, 2010, 2:46:19 PM
    Author     : Fred
--%>

<%@page import="edu.asu.eas.snac.activitymanager.messages.WishItem"%>
<%@page import="edu.asu.eas.snac.activitymanager.messages.WishListMessage"%>
<%@page import="eas.asu.edu.snac.activitymanager.networking.MessageSender"%>
<%@page import="edu.asu.eas.snac.activitymanager.messages.ReqWishMessage"%>
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
        <title><%= loggedInUser%>'s Wish List</title>
    </head>
    <body>
        <a href="NewWish.jsp">Add New Wish</a><br/><br/>

        <%
        //get the wishes
        ReqWishMessage rwm = new ReqWishMessage();
        rwm.setUsername(loggedInUser);

        WishListMessage wishes = (WishListMessage)MessageSender.sendMessage(rwm);
        %>
        <table border="1">
            <th>Sport</th>
            <th>Date</th>
            <th>Start Time</th>
            <th>End Time</th>
            <th>Location</th>
        <%
            for(int i = 0; i < wishes.getAllWishes().length; i++){
                WishItem tmp = wishes.getAllWishes()[i];
        %>
        <tr>
            <td><%= tmp.getSport() %></td>
            <td><%= tmp.getDate() %></td>
            <td><%= tmp.getStarttime() %></td>
            <td><%= tmp.getEndtime() %></td>
            <td><%= tmp.getLocation() %></td>
        </tr>
        <%
            }//close the for
        %>
        </table>
        
    </body>
</html>

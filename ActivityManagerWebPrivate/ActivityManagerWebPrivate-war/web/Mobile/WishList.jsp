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
        <link rel="stylesheet" type="text/css" href="CSS/wishList.css" />
    </head>
    <body>
    <div id="wish_upper">
            <img alt="logo"  src="images/my_wish.jpg" border="0" style="width:70%;">
    </div>
    <div id="wish_mid">
    </div>
    <div id="wish_form">
        <hr/>
        <input type="button" onclick="window.location='NewWish.jsp'" value="Add New Wish" class="wishNew_buttom"/>
        <%
        //get the wishes
        ReqWishMessage rwm = new ReqWishMessage();
        rwm.setUsername(loggedInUser);

        WishListMessage wishes = (WishListMessage)MessageSender.sendMessage(rwm);
        %>
        
        <%
            for(int i = 0; i < wishes.getAllWishes().length; i++){
                WishItem tmp = wishes.getAllWishes()[i];
        %>
        <hr/>
        <table align="center">
            <tr>
                <td   align="left" width="40%">Activity type: <%= tmp.getSport() %></td><td   align="left"  width="40%">Date: <%= tmp.getDate() %></td>
            </tr>
            <tr>
                <td   align="left" width="40%">Start time: <%= tmp.getStarttime() %></td><td   align="left" width="40%">End time: <%= tmp.getEndtime() %></td>
            </tr>
            <tr>
                <td   align="left" width="40%">Activity location: <%= tmp.getLocation() %></td><td   align="left" width="40%"></td>
            </tr>
            </table>
        <%
            }//close the for
        %>
    <hr/>
    <input type="button" onclick="window.location='javascript:history.go(-1)'" value="Back" class="wishNew_buttom"/>
    </div>
    </body>
</html>

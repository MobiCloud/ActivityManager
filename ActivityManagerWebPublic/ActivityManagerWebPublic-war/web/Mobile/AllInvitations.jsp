<%-- 
    Document   : AllInvitations
    Created on : Dec 7, 2010, 3:09:23 PM
    Author     : Fred
--%>

<%@page import="edu.asu.edu.snac.activitymanager.util.CheckLoggedIn"%>
<%@page import="edu.asu.eas.snac.activitymanager.messages.InvitationItem"%>
<%@page import="edu.asu.eas.snac.activitymanager.messages.InvitationListMessage"%>
<%@page import="eas.asu.edu.snac.activitymanager.networking.MessageSender"%>
<%@page import="edu.asu.eas.snac.activitymanager.messages.GetAllInvitationMessage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Invitations</title>
    </head>
    <body>
        <%
        //get the wishes
        GetAllInvitationMessage rwm = new GetAllInvitationMessage();

        InvitationListMessage invitations = (InvitationListMessage)MessageSender.sendMessage(rwm);
        %>
        <table border="1">
            <th>Sport</th>
            <th>Date</th>
            <th>Start Time</th>
            <th>End Time</th>
            <th>Location</th>
            <th>Max Players</th>

        <%
            for(int i = 0; i < invitations.getAllItems().length; i++){
                InvitationItem tmp = invitations.getItem(i);
        %>
        <tr>
            <td><%= tmp.getSport() %></td>
            <td><%= tmp.getDate() %></td>
            <td><%= tmp.getStarttime() %></td>
            <td><%= tmp.getEndtime() %></td>
            <td><%= tmp.getLocation() %></td>
            <td><%= tmp.getMaxgamer() %></td>
        </tr>
        <%
            }//close the for
        %>
        </table>
    </body>
</html>

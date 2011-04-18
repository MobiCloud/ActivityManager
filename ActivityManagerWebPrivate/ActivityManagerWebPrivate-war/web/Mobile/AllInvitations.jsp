<%-- 
    Document   : AllInvitations
    Created on : Dec 7, 2010, 3:09:23 PM
    Author     : Fred
--%>

<%@page import="edu.asu.edu.snac.activitymanager.util.CheckLoggedIn"%>
<%@page import="edu.asu.eas.snac.activitymanager.messages.InvitationItem"%>
<%@page import="edu.asu.eas.snac.activitymanager.messages.InvitationListMessage"%>
<%@page import="eas.asu.edu.snac.activitymanager.networking.MessageSender"%>
<%@page import="edu.asu.eas.snac.activitymanager.messages.GetAllInvitationMessagePublicVM"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
    String loggedInUser = CheckLoggedIn.checkLoggedIn(request, response);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Invitations</title>
		<link rel="stylesheet" type="text/css" href="CSS/invitation.css" />
    </head>
    <body>
    <div id="invitation_upper">
    </div>
    <div id="invitation_mid">
    </div>
    <div id="invitation_table">
        <%
        //get the wishes
        GetAllInvitationMessagePublicVM rwm = new GetAllInvitationMessagePublicVM();

        /** HACK: This section is hardcoded it must changed!! */
        rwm.setVmURL("192.168.239.247");
        rwm.setPortNumber(1337);
        rwm.setUsername("Jose");
        /** HACK */

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
              if( invitations == null )
                  System.out.println("The Invitation is null!!!!!!!!!!!!!!!!!!!!");
              if( invitations.getAllItems() != null )
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
		</div>
    </body>
</html>

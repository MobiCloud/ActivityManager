<%-- 
    Document   : InviteList
    Created on : Dec 7, 2010, 3:00:21 PM
    Author     : Fred
--%>

<%@page import="eas.asu.edu.snac.activitymanager.networking.MessageSender"%>
<%@page import="edu.asu.eas.snac.activitymanager.messages.InvitationItem"%>
<%@page import="edu.asu.eas.snac.activitymanager.messages.InvitationListMessage"%>
<%@page import="edu.asu.eas.snac.activitymanager.messages.ReqInvitationMessagePublicVM"%>
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
        <title><%= loggedInUser%>'s Invitations</title>
        <link rel="icon" type="image/x-icon" href="../favicon.ico" />
	<link rel="stylesheet" type="text/css" href="CSS/invitationList.css" />
    </head>
    <body>
	<div id="invitationList_upper">
            <img alt="logo" src="images/invite_list.jpg" border="0" style="width:100%">
    </div>
    <div id="invitationList_mid">
    </div>
    <div id="invitationList_table">
        <hr/>
        <input type="button" onclick="window.location='NewInvitation.jsp'" value="Add New Invitation" class="invitationNew_buttom"/>
        <%
        //get the wishes
        ReqInvitationMessagePublicVM rwm = new ReqInvitationMessagePublicVM();

        /** HACK: This section is hardcoded it must changed!! */
        rwm.setVmURL("192.168.239.247");
        rwm.setPortNumber(1337);
        /** HACK */

        rwm.setUsername(loggedInUser);
        InvitationListMessage invitations = (InvitationListMessage)MessageSender.sendMessage(rwm);
        %>         
        <%
            for(int i = 0; i < invitations.getAllItems().length; i++){
                InvitationItem tmp = invitations.getItem(i);
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
                <td   align="left" width="40%">Activity location: <%= tmp.getLocation() %></td><td   align="left" width="40%">Maximum persons wanted: <%= tmp.getMaxgamer() %></td>
            </tr>
        </table>
        <%
            }//close the for
        %>
        <hr/>
        <input type="button" onclick="window.location='Menu.jsp'" value="Back" class="invitationNew_buttom"/>
	</div>
        <br/><br/>
    </body>
</html>

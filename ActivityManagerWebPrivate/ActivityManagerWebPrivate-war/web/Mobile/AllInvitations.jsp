<%-- 
    Document   : AllInvitations
    Created on : Dec 7, 2010, 3:09:23 PM
    Author     : Fred
--%>

<%@page import="edu.asu.edu.snac.activitymanager.util.Constants"%>
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
            <img alt="logo" src="images/all_invite_logo.jpg" border="0" style="width:100%">
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
                        /** HACK */
                        // Request the data giving the user as a parameter
                        rwm.setUsername(loggedInUser);
                        InvitationListMessage invitations = (InvitationListMessage) MessageSender.sendMessage(rwm);
            %>
            <!-- Dummy Remove -->
            <table align="center">
                <tr>
                    <td   align="left" width="40%">Sport type: Golf</td><td   align="left"  width="40%">Date: 04/30/2011</td>
                </tr>
                <tr>
                    <td   align="left" width="40%">Start time: 01:00</td><td   align="left" width="40%">End time: 00:01</td>

                </tr>
                <tr>
                    <td   align="left" width="40%">Activity location: Tempe Golf Course</td><td   align="left" width="40%">Maximum players wanted: 18</td>
                </tr>
            </table>

            <%
                        // TODO: Need to handle exception like it was done for the invitations
                        for (int i = 0; invitations != null && invitations.getAllItems() != null && i < invitations.getAllItems().length; i++)
                        {
                            InvitationItem tmp = invitations.getItem(i);
            %>
            <hr/>
            <table align="center">
                <tr>
                    <td   align="left" width="40%">Sport type: <%= tmp.getSport()%></td><td   align="left"  width="40%">Date: <%= tmp.getDate()%></td>
                </tr>
                <tr>
                    <td   align="left" width="40%">Start time: <%= tmp.getStarttime()%></td><td   align="left" width="40%">End time: <%= tmp.getEndtime()%></td>
                </tr>
                <tr>
                    <td   align="left" width="40%">Activity location: <%= tmp.getLocation()%></td><td   align="left" width="40%">Maximum players wanted: <%= tmp.getMaxgamer()%></td>
                </tr>
                <tr>
                    <td colspan="2">
                            <%
                                              String appendInput = "";
                                              String invitationRequest = "";
                                              if (tmp.isUserOnGame())
                                              {
                                                  appendInput = "value=\"Leave\"";
                                                  invitationRequest = Constants.INVITATION_LEAVE;
                                              }
                                              else if (tmp.getCurrentgamer() == tmp.getMaxgamer())
                                              {
                                                  appendInput = "value=\"Full\" disabled=\"true\"";
                                              }
                                              else
                                              {
                                                  appendInput = "value=\"Join\"";
                                                  invitationRequest = Constants.INVITATION_JOIN;
                                              }
                            %>
                            <a href="../ProcessInvitiationRequest?invitationID=<%=tmp.getInviteID()%>&invitationRequest=<%=invitationRequest%>" ><input type="button" name="activityRequest" id="invitation_back" <%= appendInput%> /></a>
                    </td>
                </tr>
            </table>
            <%
                    }//close the for
%>
            <hr/>
            <input type="button" onclick="window.location='Menu.jsp'" value="Back" id="invitation_back"/>
            <br/>
        </div>
    </body>
</html>

<%-- 
    Document   : Menu
    Created on : Dec 7, 2010, 2:38:36 PM
    Author     : Fred Morstatter
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="edu.asu.edu.snac.activitymanager.util.Validate"%>
<%@page import="edu.asu.eas.snac.activitymanager.messages.ReqWishMessage"%>
<%@page import="edu.asu.eas.snac.activitymanager.messages.WishListMessage"%>
<%@page import="edu.asu.eas.snac.activitymanager.messages.InvitationListMessage"%>
<%@page import="eas.asu.edu.snac.activitymanager.networking.MessageSender"%>
<%@page import="edu.asu.eas.snac.activitymanager.messages.GetAllInvitationMessagePublicVM"%>
<%@page import="edu.asu.edu.snac.activitymanager.util.CheckLoggedIn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
    String loggedInUser = CheckLoggedIn.checkLoggedIn(request, response);

    //now let's find the overlapping invitations and wishes.
    //get the invitations
    GetAllInvitationMessagePublicVM rwm = new GetAllInvitationMessagePublicVM();

    /** HACK: This section is hardcoded it must changed!! */
    rwm.setVmURL("192.168.239.247");
    rwm.setPortNumber(1337);
    /** HACK */

    // Request the data giving the user as a parameter
    rwm.setUsername(loggedInUser);
    InvitationListMessage invitations = (InvitationListMessage) MessageSender.sendMessage(rwm);

    ReqWishMessage getWishes = new ReqWishMessage();
    getWishes.setUsername(loggedInUser);
    WishListMessage wishes = (WishListMessage) MessageSender.sendMessage(getWishes);

    out.println("<!--");
    ArrayList<String> inviteOverlap = Validate.findOverlappingInvitations(wishes.getAllWishes(), invitations.getAllItems(), out);
    out.println("-->");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Activity Manager - Menu - <%= loggedInUser %></title>
        <link rel="stylesheet" type="text/css" href="CSS/menu.css" />
        <link rel="icon" type="image/x-icon" href="../favicon.ico">
    </head>
    <body>
        <div id="menu_upper">
            <img alt="logo"  src="images/menu_upper.jpg" border="0" style="width:70%">
        </div>
        <div id="menu_mid">
        </div>
        <div>
            <%if(inviteOverlap.size() > 0){ %>
            <hr/>
            <%
                StringBuilder builder = new StringBuilder();
                for(String s : inviteOverlap)
                {
                    builder.append(s + ",");
                }
            %>
            <div class="menu_items_special" onclick="window.location='AllInvitations.jsp?highlight=<%= builder.toString() %>'">
                <%= inviteOverlap.size() %> Matching Invitation<%= inviteOverlap.size() > 1?"s":"" %>
            </div>
            <% } //end if%>
            <hr/>
        <div class="menu_items"><a href="WishList.jsp">My Wishes</a></div>
            <hr/>
        <div class="menu_items"><a href="InviteList.jsp">My Invitations</a></div>
            <hr/>
        <div class="menu_items"><a href="AllInvitations.jsp">All Invitations</a></div>
            <hr/>
        <div class="menu_items"><a href="../Logout">Logout</a></div>
            <hr/>
        </div>
    </body>
</html>

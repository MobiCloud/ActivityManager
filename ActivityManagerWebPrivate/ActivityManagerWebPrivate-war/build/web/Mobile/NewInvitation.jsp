<%-- 
    Document   : NewInvitation
    Created on : Dec 7, 2010, 3:34:58 PM
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
        <title>Add Invitation</title>
        <link rel="stylesheet" type="text/css" href="CSS/invitationList.css" />
        <%@include file="../WEB-INF/jspf/jsCalendarInclude.jspf" %>
    </head>
    <body>
    <div id="invitationNew_upper">
        <img alt="logo" src="images/new_invitation_logo.jpg" border="0" style="width: 100%;">
    </div>
    <div id="invitationNew_mid">
    </div>
    <div id="invitationNew_table">
        <form action="../ProcessNewInvitation" method="post">
            Activity:<br/>
            <input type="text" name="sport" class="invitationNew_input"/><br/>
            <%@include file="../WEB-INF/jspf/Time.jspf" %><br/>
            Location: <br/>
            <input type="text" name="location" class="invitationNew_input"/><br/>
            Date: <br/>
            <input type="text" name="date" class="invitationNew_input"
                   onClick="displayDatePicker('date', this)"/><br/>
            Max Players: <br/>
            <input type="text" name="maxgamer" class="invitationNew_input"/><br/><br/>
            <input type="submit" value="Add New Invitation" class="invitationNew_buttom"/><br/><br/>
            <input type="button" onclick="window.location='javascript:history.go(-1)'" value="Cancel" class="invitationNew_buttom"/><br/><br/>
        </form>
    </div>>
    </body>
</html>

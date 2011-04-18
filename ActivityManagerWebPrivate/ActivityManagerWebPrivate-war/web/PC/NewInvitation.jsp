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
    </head>
    <body>
        <h3>New Invitation</h3>
        <br/><br/>

        <form action="ProcessNewInvitation" method="post">
            Sport: <input type="text" name="sport" /><br/>
            Start Time: <input type="text" name="starttime" /><br/>
            End Time: <input type="text" name="endtime" /><br/>
            Location: <input type="text" name="location" /><br/>
            Date: <input type="text" name="date" /><br/>
            Max Players: <input type="text" name="maxgamer" /><br/>
            <input type="submit" value="Add New Invitation" />
        </form>
    </body>
</html>

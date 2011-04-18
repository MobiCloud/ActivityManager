<%-- 
    Document   : NewWish
    Created on : Dec 7, 2010, 3:16:28 PM
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
        <title>Add Wish</title>
    </head>
    <body>
        <h3>New Wish</h3>
        <br/><br/>

        <form action="../ProcessNewWish" method="post">
            Sport: <input type="text" name="sport" /><br/>
            Start Time: <input type="text" name="starttime" /><br/>
            End Time: <input type="text" name="endtime" /><br/>
            Location: <input type="text" name="location" /><br/>
            Date: <input type="text" name="date" /><br/>
            <input type="submit" value="Add New Wish" />
        </form>
    </body>
</html>

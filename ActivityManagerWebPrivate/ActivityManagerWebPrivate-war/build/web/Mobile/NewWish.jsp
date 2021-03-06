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
        <link rel="stylesheet" type="text/css" href="CSS/wishList.css" />
        <link rel="icon" type="image/x-icon" href="../favicon.ico" />
        <%@include file="../WEB-INF/jspf/jsCalendarInclude.jspf" %>
    </head>
    <body>
        <%
        // TODO: Goufu this is my place holder.
        if( request.getSession().getAttribute("errorMessage") != null )
        {
               
        %>
        <p style="color: #ffffff">
            Error: <%=request.getSession().getAttribute("errorMessage")%>
                
        </p>
        <%
            // Remove the errorMessage attribute
            session.removeAttribute("errorMessage");
        }
        %>
        
    <div id="wishNew_upper">
            <img alt="logo" src="images/new_wish_logo.jpg" border="0" style="width:100%;">
    </div>
    <div id="wishNew_mid">
    </div>
    <div id="wishNew_form">
        <form action="../ProcessNewWish" method="post" name="dataInput">
            Activity: <br/>
            <input type="text" name="sport" class="wishNew_input"/><br/>
            <%@include file="../WEB-INF/jspf/Time.jspf" %><br/>
            Location: <br/>
            <input type="text" name="location" class="wishNew_input"/><br/>
            Date: <br/>
            <input type="text" name="date" class="wishNew_input" 
                   onClick="displayDatePicker('date', this)"/><br/><br/>
            <input type="submit" value="Add New Wish" class="wishNew_buttom"/><br/><br/>
            <input type="button" onclick="window.location='javascript:history.go(-1)'" value="Cancel" class="wishNew_buttom"/><br/><br/>
        </form>
    </div>
    </body>
</html>

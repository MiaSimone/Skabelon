<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
        

        <h1>Hello ${sessionScope.email} </h1>



        You are now logged in as an EMPLOYEE of our wonderful site.
    <br>
        HER SKAL OVERSIGTEN STÅ

    <br>
    <br>
    <br>
        Opret employee:
        <form action="FrontController">
            <label for="email">Email:</label><br>
            <input type="text" id="email" email="Email"><br>
            <label for="password">Password:</label><br>
            <input type="password" id="password" name="password"><br><br>
            <input type="submit" value="Opret">
        </form>


    </body>
</html>

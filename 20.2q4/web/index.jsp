<%-- 
    Document   : index
    Created on : Apr 30, 2025, 6:40:03 PM
    Author     : gmaha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h2>Enter Your Favorites</h2>
    <form action="CheckFavorites" method="post">
        Favorite Language: <input type="text" name="language"><br><br>
        Favorite IDE: <input type="text" name="ide"><br><br>
        <input type="submit" value="Submit">
    </form>
    </body>
</html>

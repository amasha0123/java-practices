<%-- 
    Document   : postInternship
    Created on : May 9, 2025, 9:23:04 AM
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
        <form action="InternshipServlet" method="post"> 
  Title: <input type="text" name="title"><br> 
  Description: <textarea name="description"></textarea><br> 
  Deadline: <input type="date" name="deadline"><br> 
  <input type="submit" value="Post Internship"> 
</form> 
    </body>
</html>

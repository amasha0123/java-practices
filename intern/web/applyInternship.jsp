<%-- 
    Document   : applyInternship
    Created on : May 9, 2025, 9:23:12 AM
    Author     : gmaha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ page import="java.sql.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
<% 
  Connection con = DBConnection.getConnection(); 
  Statement st = con.createStatement(); 
  ResultSet rs = st.executeQuery("SELECT * FROM internships"); 
%> 
<form action="ApplicationServlet" method="post"> 
  Select Internship: 
  <select name="internshipId"> 
    <% while (rs.next()) { %> 
      <option value="<%= rs.getInt("id") %>"><%= rs.getString("title") %></option> 
    <% } %> 
  </select> 
  <input type="submit" value="Apply"> 
</form>
    </body>
</html>

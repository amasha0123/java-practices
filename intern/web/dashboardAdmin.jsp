 <%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ page import="java.util.*, model.User, dao.UserDAO" %>
<%
    String role = (String) session.getAttribute("role");
    if (role == null || !role.equalsIgnoreCase("admin")) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<User> users = new ArrayList<>();
    try {
        UserDAO userDAO = new UserDAO();
        users = userDAO.getAllUsers();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
    <h2>All Registered Users</h2>
   
<a href="viewApplications.jsp">View All Registered Users</a>

</body>
</html>

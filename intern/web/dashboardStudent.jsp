 <%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.Internship, dao.InternshipDAO" %>
<%
    // Ensure user is logged in and is a student
    String role = (String) session.getAttribute("role");
    if (role == null || !role.equals("student")) {
        response.sendRedirect("login.jsp");
        return;
    }

    InternshipDAO internshipDAO = new InternshipDAO();
    List<Internship> internships = internshipDAO.getAllInternships();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h2>Available Internships</h2>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Deadline</th>
            <th>Action</th>
        </tr>
        <%
            for (Internship internship : internships) {
        %>
        <tr>
            <td><%= internship.getTitle() %></td>
            <td><%= internship.getDescription() %></td>
            <td><%= internship.getDeadline() %></td>
            <td>
                <form action="ApplicationServlet" method="post">
                    <input type="hidden" name="internshipId" value="<%= internship.getId() %>">
                    <input type="submit" value="Apply">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>

    <!-- Logout Button -->
    <form action="LogoutServlet" method="get">
        <input type="submit" value="Logout">
    </form>
</body>
</html>

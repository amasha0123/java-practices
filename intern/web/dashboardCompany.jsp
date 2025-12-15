 <%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.Internship, dao.InternshipDAO" %>
<%
    // Ensure user is logged in and is a company
    String role = (String) session.getAttribute("role");
    if (role == null || !role.equals("company")) {
        response.sendRedirect("login.jsp");
        return;
    }

    int companyId = (int) session.getAttribute("userId");
    InternshipDAO internshipDAO = new InternshipDAO();
    List<Internship> internships = internshipDAO.getInternshipsByCompany(companyId);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Company Dashboard</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h2>Your Posted Internships</h2>
    <a href="postInternship.jsp">Post New Internship</a>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Deadline</th>
        </tr>
        <%
            for (Internship internship : internships) {
        %>
        <tr>
            <td><%= internship.getTitle() %></td>
            <td><%= internship.getDescription() %></td>
            <td><%= internship.getDeadline() %></td>
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

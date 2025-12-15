 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, util.DBConnection" %>

<%
    // Session role check
    String role = (String) session.getAttribute("role");
    if (role == null || !role.equalsIgnoreCase("admin")) {
        response.sendRedirect("login.jsp");
        return;
    }

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
%>

<!DOCTYPE html>
<html>
<head>
    <title>Internship Applications</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
     <style>
        table {
            border-collapse: collapse;
            width: 80%;
        }
        th, td {
            padding: 10px;
            border: 1px solid #999;
        }
    </style>
    <h2>All Internship Applications</h2>

    <table border="1">
        <tr>
            <th>Student</th>
            <th>Internship</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>

        <%
            try {
                con = DBConnection.getConnection();
                st = con.createStatement();
                rs = st.executeQuery("SELECT a.id, u.name AS student, i.title AS internship, a.status FROM applications a JOIN users u ON a.student_id = u.id JOIN internships i ON a.internship_id = i.id");

                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getString("student") %></td>
            <td><%= rs.getString("internship") %></td>
            <td><%= rs.getString("status") %></td>
            <td>
                <a href="ApplicationServlet?action=approve&id=<%= rs.getInt("id") %>">Approve</a> |
                <a href="ApplicationServlet?action=reject&id=<%= rs.getInt("id") %>">Reject</a>
            </td>
        </tr>
        <%
                }
            } catch (Exception e) {
                out.println("<tr><td colspan='4'>Error loading applications: " + e.getMessage() + "</td></tr>");
                e.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception e) {}
                try { if (st != null) st.close(); } catch (Exception e) {}
                try { if (con != null) con.close(); } catch (Exception e) {}
            }
        %>
    </table>
</body>
</html>

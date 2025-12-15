 package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DBConnection;

@WebServlet(name = "InternshipServlet", urlPatterns = {"/InternshipServlet"})
public class InternshipServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String desc = request.getParameter("description");
        String deadline = request.getParameter("deadline");
        int companyId = (int) request.getSession().getAttribute("userId");

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO internships (title, description, deadline, company_id) VALUES (?, ?, ?, ?)"
            );
            ps.setString(1, title);
            ps.setString(2, desc);
            ps.setString(3, deadline);
            ps.setInt(4, companyId);
            ps.executeUpdate();

            response.sendRedirect("dashboardCompany.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}

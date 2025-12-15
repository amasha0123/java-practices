 package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; // ✅ FIX: Add this import
import java.util.List;     // ✅ FIX: Add this import

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import util.DBConnection;
import dao.InternshipDAO;          // ✅ FIX: Required for InternshipDAO
import model.Internship;          // ✅ FIX: Required for Internship

@WebServlet(name = "ApplicationServlet", urlPatterns = {"/ApplicationServlet"})
public class ApplicationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));

        String status = action.equals("approve") ? "Approved" : "Rejected";

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE applications SET status = ? WHERE id = ?"
            );
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
            response.sendRedirect("viewApplications.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int internshipId = Integer.parseInt(request.getParameter("internshipId"));
        int studentId = (int) request.getSession().getAttribute("userId");

        String message;

        try (Connection con = DBConnection.getConnection()) {
            // Check if already applied
            PreparedStatement checkStmt = con.prepareStatement(
                "SELECT * FROM applications WHERE internship_id = ? AND student_id = ?"
            );
            checkStmt.setInt(1, internshipId);
            checkStmt.setInt(2, studentId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                message = "You have already applied for this internship.";
            } else {
                PreparedStatement insertStmt = con.prepareStatement(
                    "INSERT INTO applications (internship_id, student_id, status) VALUES (?, ?, 'Applied')"
                );
                insertStmt.setInt(1, internshipId);
                insertStmt.setInt(2, studentId);
                insertStmt.executeUpdate();
                message = "Application submitted successfully!";
            }

            // Load internships to show on the page
            InternshipDAO dao = new InternshipDAO();
            List<Internship> internships = dao.getAllInternships();

            request.setAttribute("internships", internships);
            request.setAttribute("applicationMessage", message);
            request.getRequestDispatcher("dashboardStudent.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}

 package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.DBConnection;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE email=? AND password=?"
            );
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role").toLowerCase();  // Normalize role
                int userId = rs.getInt("id");

                HttpSession session = request.getSession();
                session.setAttribute("userId", userId);
                session.setAttribute("role", role);

                System.out.println("Role: " + role);  // Debugging output

                switch (role) {
                    case "student":
                        System.out.println("Redirecting to student dashboard.");
                        response.sendRedirect("dashboardStudent.jsp");
                        break;
                    case "company":
                        System.out.println("Redirecting to company dashboard.");
                        response.sendRedirect("dashboardCompany.jsp");
                        break;
                    case "admin":
                        System.out.println("Redirecting to admin dashboard.");
                        response.sendRedirect("dashboardAdmin.jsp");
                        break;
                    default:
                        System.out.println("Invalid role.");
                        response.sendRedirect("login.jsp?error=invalidrole");
                        break;
                }
            } else {
                System.out.println("Invalid credentials.");
                response.sendRedirect("login.jsp?error=invalidcredentials");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}

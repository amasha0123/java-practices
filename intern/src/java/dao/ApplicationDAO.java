package dao;

import java.sql.*;
import java.util.*;
import model.Application;
import util.DBConnection;

public class ApplicationDAO {

    public void applyToInternship(Application app) throws Exception {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO applications (internship_id, student_id, status) VALUES (?, ?, ?)"
            );
            ps.setInt(1, app.getInternshipId());
            ps.setInt(2, app.getStudentId());
            ps.setString(3, app.getStatus());
            ps.executeUpdate();
        }
    }

    public void updateStatus(int appId, String status) throws Exception {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE applications SET status=? WHERE id=?"
            );
            ps.setString(1, status);
            ps.setInt(2, appId);
            ps.executeUpdate();
        }
    }

    public List<Application> getAllApplications() throws Exception {
        List<Application> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM applications");
            while (rs.next()) {
                Application app = new Application(
                    rs.getInt("id"),
                    rs.getInt("internship_id"),
                    rs.getInt("student_id"),
                    rs.getString("status")
                );
                list.add(app);
            }
        }
        return list;
    }
}

 package dao;

import java.sql.*;
import java.util.*;
import model.Internship;
import util.DBConnection;

public class InternshipDAO {

    public void addInternship(Internship i) throws Exception {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO internships (title, description, deadline, company_id) VALUES (?, ?, ?, ?)"
            );
            ps.setString(1, i.getTitle());
            ps.setString(2, i.getDescription());
            ps.setString(3, i.getDeadline());
            ps.setInt(4, i.getCompanyId());
            ps.executeUpdate();
        }
    }

    public List<Internship> getAllInternships() throws Exception {
        List<Internship> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM internships");
            while (rs.next()) {
                Internship i = new Internship(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("deadline"),
                    rs.getInt("company_id")
                );
                list.add(i);
            }
        }
        return list;
    }

    public List<Internship> getInternshipsByCompany(int companyId) throws Exception {
        List<Internship> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM internships WHERE company_id = ?"
            );
            ps.setInt(1, companyId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Internship i = new Internship(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("deadline"),
                    rs.getInt("company_id")
                );
                list.add(i);
            }
        }
        return list;
    }
}

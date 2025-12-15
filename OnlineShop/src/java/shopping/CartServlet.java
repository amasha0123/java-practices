 package shopping;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@WebServlet("/add-to-cart")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb", "root", "GMAgma2002#");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE id = ?");
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
                cart.addItem(p);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.setAttribute("cart", cart);
        resp.sendRedirect("cart.jsp");
    }
}

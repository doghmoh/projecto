/* Decompiler 6ms, total 915ms, lines 51 */
package Controller;

import Model.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(
   name = "ActivateAccount",
   urlPatterns = {"/ActivateAccount"}
)
public class ActivateAccount extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String email = request.getParameter("email");
      String id = request.getParameter("id");
      String Role = request.getParameter("role");
      String Code = request.getParameter("a") + request.getParameter("b") + request.getParameter("c") + request.getParameter("d") + request.getParameter("e") + request.getParameter("f");

      try {
         Connection con = Database.getConnection();
         PreparedStatement ps = con.prepareStatement("update " + Role + " set Active=? where id=? and code=?");
         ps.setInt(1, 1);
         ps.setString(2, id);
         ps.setString(3, Code);
         int update = ps.executeUpdate();
         if (update == 1) {
            request.setAttribute("message", "Your Account has been activated");
            request.getRequestDispatcher("/004/Signin/signin.jsp").forward(request, response);
         } else {
            request.setAttribute("message", "Invalid Code, Try again please.");
            request.setAttribute("email", email);
            request.setAttribute("uid", id);
            request.setAttribute("role", Role);
            request.getRequestDispatcher("VerificationLink.jsp").forward(request, response);
         }
      } catch (SQLException var10) {
         request.setAttribute("message", var10);
         request.getRequestDispatcher("welcom.jsp").forward(request, response);
      }

   }
}
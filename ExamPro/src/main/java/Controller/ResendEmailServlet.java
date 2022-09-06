/* Decompiler 2ms, total 1086ms, lines 39 */
package Controller;

import Model.EmailVerification;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet(
   name = "ResendEmailServlet",
   urlPatterns = {"/ResendEmailServlet"}
)
public class ResendEmailServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
         String email = request.getParameter("email");
         String id = request.getParameter("id");
         String role = request.getParameter("role");
         EmailVerification emailverifi = new EmailVerification();
         emailverifi.sendEmail(id, role);
         request.setAttribute("message", "ok");
         request.setAttribute("uid", id);
         request.setAttribute("email", email);
         request.setAttribute("role", role);
         request.getRequestDispatcher("VerificationLink.jsp").forward(request, response);
      } catch (SQLException | NoSuchAlgorithmException var7) {
         request.setAttribute("message", var7);
         request.getRequestDispatcher("Signup.jsp").forward(request, response);
      }

   }
}
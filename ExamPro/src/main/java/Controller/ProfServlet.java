/* Decompiler 4ms, total 655ms, lines 80 */
package Controller;

import Dao.AdminFunction;
import Model.EmailVerification;
import Model.Hash;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet(
   name = "ProfServlet",
   urlPatterns = {"/ProfServlet"}
)
public class ProfServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   boolean test = false;
   boolean valide = false;
   boolean value = false;

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String FirstName = request.getParameter("FirstName").toLowerCase();
      String LastName = request.getParameter("LastName").toLowerCase();
      String Email = request.getParameter("Email").toLowerCase();
      String PassWord = request.getParameter("PassWord").toLowerCase();
      String DateOfBirth = request.getParameter("DateOfBirth").toLowerCase();
      String Sexe = request.getParameter("Sexe").toLowerCase();
      String University = request.getParameter("University").toLowerCase();
      HttpSession session = request.getSession(false);
      session.invalidate();
      session = request.getSession();
      String Id = session.getId();
      Hash hash = new Hash();

      try {
         String newPassword = hash.Hashage(PassWord);
         AdminFunction profDB0 = new AdminFunction();
         this.value = profDB0.ifActivate(Email, "prof");
         if (this.value) {
            request.setAttribute("message", "email already exist.");
            request.getRequestDispatcher("004/Signup/Signup.jsp").forward(request, response);
         } else {
            User prof = new User();
            prof.setFirstName(FirstName);
            prof.setLastName(LastName);
            prof.setEmail(Email);
            prof.setPassWord(newPassword);
            prof.setDateOfBirth(DateOfBirth);
            prof.setSexe(Sexe);
            prof.setUniversity(University);
            prof.setId(Id);
            AdminFunction userDB = new AdminFunction();
            this.test = userDB.setProfData(prof);
            EmailVerification verification = new EmailVerification();
            this.valide = verification.sendEmail(Id, "Prof");
            if (this.test && this.valide) {
               request.setAttribute("uid", Id);
               request.setAttribute("email", prof.getEmail());
               request.setAttribute("role", "Prof");
               request.setAttribute("message", "");
               request.getRequestDispatcher("VerificationLink.jsp").forward(request, response);
            } else {
               request.setAttribute("message", "Signup failed. Try again please.");
               request.getRequestDispatcher("004/Signup/Signup.jsp").forward(request, response);
            }
         }
      } catch (SQLException | NoSuchAlgorithmException var18) {
         request.setAttribute("message", var18);
         request.getRequestDispatcher("welcom.jsp").forward(request, response);
      }

   }
}
/* Decompiler 5ms, total 726ms, lines 84 */
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
   name = "AdminServlet",
   urlPatterns = {"/AdminServlet"}
)
public class AdminServlet extends HttpServlet {
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
      String Faculte = request.getParameter("Faculty").toLowerCase();
      String Departement = request.getParameter("Departement").toLowerCase();
      HttpSession session = request.getSession(false);
      session.invalidate();
      session = request.getSession();
      String Id = session.getId();
      Hash hash = new Hash();

      try {
         String newPassword = hash.Hashage(PassWord);
         AdminFunction userdb = new AdminFunction();
         this.value = userdb.ifActivate(Email, "admin");
         if (this.value) {
            request.setAttribute("message", "email already exist.");
            request.getRequestDispatcher("Signup.jsp").forward(request, response);
         } else {
            User admin = new User();
            admin.setFirstName(FirstName);
            admin.setLastName(LastName);
            admin.setDateOfBirth(DateOfBirth);
            admin.setEmail(Email);
            admin.setPassWord(newPassword);
            admin.setSexe(Sexe);
            admin.setUniversity(University);
            admin.setFaculte(Faculte);
            admin.setDepartement(Departement);
            admin.setId(Id);
            AdminFunction user = new AdminFunction();
            this.test = user.setAdminData(admin);
            EmailVerification verification = new EmailVerification();
            this.valide = verification.sendEmail(Id, "Admin");
            if (this.test && this.valide) {
               request.setAttribute("uid", Id);
               request.setAttribute("email", admin.getEmail());
               request.setAttribute("role", "Admin");
               request.setAttribute("message", "");
               request.getRequestDispatcher("VerificationLink.jsp").forward(request, response);
            } else {
               request.setAttribute("message", "Signup failed. Try again please.");
               request.getRequestDispatcher("004/Signup/Signup.jsp").forward(request, response);
            }
         }
      } catch (SQLException | NoSuchAlgorithmException var20) {
         request.setAttribute("message", var20);
         request.getRequestDispatcher("welcom.jsp").forward(request, response);
      }

   }
}
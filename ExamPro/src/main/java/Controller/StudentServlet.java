/* Decompiler 5ms, total 1179ms, lines 91 */
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
   name = "StudentServlet",
   urlPatterns = {"/StudentServlet"}
)
public class StudentServlet extends HttpServlet {
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
      String GroupId = request.getParameter("GroupId").toLowerCase();
      String StudentId = request.getParameter("StudentId").toLowerCase();
      String Level = request.getParameter("Level").toLowerCase();
      HttpSession session = request.getSession(false);
      session.invalidate();
      session = request.getSession();
      String Id = session.getId();
      Hash hash = new Hash();

      try {
         String newPassword = hash.Hashage(PassWord);
         AdminFunction studentDB0 = new AdminFunction();
         this.value = studentDB0.ifActivate(Email, "student");
         if (this.value) {
            request.setAttribute("message", "email already exist.");
            request.getRequestDispatcher("Signup.jsp").forward(request, response);
         } else {
            User student = new User();
            student.setFirstName(FirstName);
            student.setLastName(LastName);
            student.setDateOfBirth(DateOfBirth);
            student.setEmail(Email);
            student.setPassWord(newPassword);
            student.setSexe(Sexe);
            student.setUniversity(University);
            student.setDepartement(Departement);
            student.setFaculte(Faculte);
            student.setGroupId(GroupId);
            student.setStudentId(StudentId);
            student.setLevel(Level);
            student.setActive(0);
            student.setId(Id);
            AdminFunction studentDB = new AdminFunction();
            this.test = studentDB.setStudentData(student);
            EmailVerification verification = new EmailVerification();
            this.valide = verification.sendEmail(Id, "Student");
            if (this.test && this.valide) {
               request.setAttribute("uid", Id);
               request.setAttribute("email", student.getEmail());
               request.setAttribute("role", "Student");
               request.setAttribute("message", "");
               request.getRequestDispatcher("VerificationLink.jsp").forward(request, response);
            } else {
               request.setAttribute("message", "Signup failed. Try again please.");
               request.getRequestDispatcher("004/Signup/Signup.jsp").forward(request, response);
            }
         }
      } catch (SQLException | NoSuchAlgorithmException var23) {
         request.setAttribute("message", var23);
         request.getRequestDispatcher("welcom.jsp").forward(request, response);
      }

   }
}
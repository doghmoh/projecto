/* Decompiler 11ms, total 753ms, lines 117 */
package Controller;

import Dao.AdminFunction;
import Dao.Signin;
import Model.Hash;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(
   name = "SigninServlet",
   urlPatterns = {"/SigninServlet"}
)
public class SigninServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String email = request.getParameter("Email");
      String password = request.getParameter("Pasword");
      String Role = request.getParameter("Role");
      HttpSession session = request.getSession();
      boolean isActive = false;

      try {
         AdminFunction am = new AdminFunction();
         Hash hash = new Hash();
         String newPassword = hash.Hashage(password);
         String departement = null;
         Signin signin = new Signin();
         ResultSet rs = signin.UserSignin(Role, email, newPassword);
         AdminFunction userDB = new AdminFunction();
         isActive = userDB.ifActivate(email, Role);
         String fname;
         String lname;
         String id;
         switch(Role.hashCode()) {
         case -214492645:
            if (Role.equals("Student")) {
               if (rs.next()) {
                  id = rs.getString(1);
                  fname = rs.getString(2);
                  lname = rs.getString(3);
                  session.setAttribute("Role", Role);
                  session.setAttribute("Username", fname + " " + lname);
                  session.setAttribute("id", id);
                  response.sendRedirect("003/StudentHome.jsp");
               } else if (isActive) {
                  request.getRequestDispatcher("004/AccountStatu.jsp").forward(request, response);
               } else {
                  request.setAttribute("message", "Try again please.");
                  request.getRequestDispatcher("004/Signin/signin.jsp").forward(request, response);
               }
            }
            break;
         case 2496377:
            if (Role.equals("Prof")) {
               if (rs.next()) {
                  id = rs.getString(1);
                  fname = rs.getString(2);
                  lname = rs.getString(3);
                  session.setAttribute("email", email);
                  session.setAttribute("Role", Role);
                  session.setAttribute("Username", fname + " " + lname);
                  session.setAttribute("id", id);
                  response.sendRedirect("002/ProfHome.jsp");
               } else if (isActive) {
                  request.getRequestDispatcher("004/AccountStatu.jsp").forward(request, response);
               } else {
                  request.setAttribute("message", "Try again please.");
                  request.getRequestDispatcher("004/Signin/signin.jsp").forward(request, response);
               }
            }
            break;
         case 63116079:
            if (Role.equals("Admin")) {
               if (rs.next()) {
                  id = rs.getString(1);
                  fname = rs.getString(2);
                  lname = rs.getString(3);
                  departement = rs.getString(10);
                  int speciality = am.GetStatsAdmin(departement, "speciality", "departementid");
                  int module = am.GetStatsAdmin2(departement, "module");
                  int groupe = am.GetStatsAdmin2(departement, "groupe");
                  List<String> notification = am.GetNotification(id, "admin");
                  session.setAttribute("notification", notification);
                  session.setAttribute("speciality", speciality);
                  session.setAttribute("module", module);
                  session.setAttribute("groupe", groupe);
                  session.setAttribute("departement", departement);
                  session.setAttribute("Role", Role);
                  session.setAttribute("Username", fname + " " + lname);
                  session.setAttribute("id", id);
                  response.sendRedirect("Profile");
               } else if (isActive) {
                  request.getRequestDispatcher("004/AccountStatu.jsp").forward(request, response);
               } else {
                  request.setAttribute("message", "Try again please.");
                  request.getRequestDispatcher("004/Signin/signin.jsp").forward(request, response);
               }
            }
         }
      } catch (NoSuchAlgorithmException | SQLException var23) {
         request.setAttribute("message", var23);
         request.getRequestDispatcher("welcom.jsp").forward(request, response);
      }

   }
}
/* Decompiler 1ms, total 679ms, lines 33 */
package Controller;

import Dao.AdminFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(
   urlPatterns = {"/StartUp"}
)
public class StartUp extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
         AdminFunction am = new AdminFunction();
         HttpSession session = request.getSession();
         String id = (String)session.getAttribute("id");
         List<String> notification = am.GetNotification(id, "prof");
         session.setAttribute("notification", notification);
         response.sendRedirect("004/Signin/signin.jsp");
      } catch (SQLException var7) {
      }

   }
}
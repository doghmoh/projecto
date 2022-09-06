/* Decompiler 3ms, total 675ms, lines 39 */
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
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

@WebServlet(
   name = "DisplayAccount",
   urlPatterns = {"/DisplayAccount"}
)
public class DisplayAccount extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      String var4 = (String)session.getAttribute("id");

      try {
         AdminFunction am = new AdminFunction();
         String data = am.GetTrueStudent();
         request.setAttribute("Student", data);
         request.getRequestDispatcher("/001/StudentAccount.jsp").forward(request, response);
      } catch (ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError | SQLException var7) {
         request.setAttribute("message", var7);
         request.getRequestDispatcher("welcom.jsp").forward(request, response);
      }

   }
}
/* Decompiler 2ms, total 2161ms, lines 37 */
package Controller;

import Dao.AdminFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

public class DisplayProf extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      String id = (String)session.getAttribute("id");
      if (id != null) {
         try {
            AdminFunction am = new AdminFunction();
            String data = am.GetTrueProf();
            request.setAttribute("Prof", data);
            request.getRequestDispatcher("001/ProfAccount.jsp").forward(request, response);
         } catch (ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError | SQLException var7) {
            request.setAttribute("message", var7);
            request.getRequestDispatcher("welcom.jsp").forward(request, response);
         }
      } else {
         response.sendRedirect("004/Signin/signin.jsp");
      }

   }
}
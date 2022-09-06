/* Decompiler 2ms, total 664ms, lines 41 */
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
import org.xml.sax.SAXException;

@WebServlet(
   name = "DisplayGroup",
   urlPatterns = {"/DisplayGroup"}
)
public class DisplayGroup extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      String id = (String)session.getAttribute("id");
      String var5 = request.getParameter("message");

      try {
         AdminFunction am = new AdminFunction();
         String data = am.GetGroups(id);
         request.setAttribute("Group", data);
         request.getRequestDispatcher("001/ManageGroup.jsp").forward(request, response);
      } catch (ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError | SAXException | SQLException var8) {
         request.setAttribute("message", var8);
         request.getRequestDispatcher("welcom.jsp").forward(request, response);
      }

   }
}
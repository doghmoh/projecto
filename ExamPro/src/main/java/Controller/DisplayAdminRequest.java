/* Decompiler 8ms, total 874ms, lines 41 */
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
   name = "DisplayAdminRequest",
   urlPatterns = {"/DisplayAdminRequest"}
)
public class DisplayAdminRequest extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      String id = (String)session.getAttribute("id");
      if (id != null) {
         try {
            AdminFunction user = new AdminFunction();
            String data1 = user.GetNotCheckedAdmin();
            request.setAttribute("Admin", data1);
            request.getRequestDispatcher("001/ManageAdminRequest.jsp").forward(request, response);
         } catch (ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError | SQLException var7) {
            response.sendRedirect("welcom.jsp");
         }
      } else {
         response.sendRedirect("004/Signin/signin.jsp");
      }

   }
}
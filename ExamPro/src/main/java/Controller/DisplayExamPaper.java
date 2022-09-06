/* Decompiler 3ms, total 638ms, lines 46 */
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
   name = "DisplayExamPaper",
   urlPatterns = {"/DisplayExamPaper"}
)
public class DisplayExamPaper extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      String id = (String)session.getAttribute("id");
      String exam = request.getParameter("exam");

      try {
         AdminFunction adminfunction = new AdminFunction();
         String key = adminfunction.GetExamDate(exam);
         boolean reponse = adminfunction.DateCompare(key);
         String data = adminfunction.GetExamPaper(exam, "id");
         if (reponse) {
            session.setAttribute("Question", data);
            response.sendRedirect("003/PassExam.jsp");
         } else {
            response.sendError(404);
         }
      } catch (ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError | SQLException var10) {
         request.setAttribute("message", var10);
         request.getRequestDispatcher("welcom.jsp").forward(request, response);
      }

   }
}
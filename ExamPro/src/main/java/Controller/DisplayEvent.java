/* Decompiler 2ms, total 857ms, lines 38 */
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

@WebServlet(
   name = "DisplayEvent",
   urlPatterns = {"/DisplayEvent"}
)
public class DisplayEvent extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      String var4 = (String)session.getAttribute("id");

      try {
         AdminFunction adminfunction = new AdminFunction();
         String data = adminfunction.GetNearestExam();
         request.setAttribute("Exam", data);
         request.getRequestDispatcher("003/ExamEvent.jsp").forward(request, response);
      } catch (TransformerException | ParserConfigurationException | SQLException var7) {
         request.setAttribute("message", var7);
         request.getRequestDispatcher("welcom.jsp").forward(request, response);
      }

   }
}
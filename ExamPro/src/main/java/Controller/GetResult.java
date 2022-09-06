/* Decompiler 37ms, total 937ms, lines 126 */
package Controller;

import Dao.AdminFunction;
import Model.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@WebServlet(
   name = "GetResult",
   urlPatterns = {"/GetResult"}
)
public class GetResult extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String div = request.getParameter("content");
      HttpSession session = request.getSession();
      String studentid = (String)session.getAttribute("id");
      String examid = request.getParameter("examid");
      String result = request.getParameter("result");
      String mark = null;
      String type = null;
      String ischeckeddb = null;
      float Qmark = 0.0F;
      float scorTotal = 0.0F;
      float scoreOption = 0.0F;
      float lose = 0.0F;
      float win = 0.0F;
      Object var17 = null;

      try {
         Connection con = Database.getConnection();
         AdminFunction am = new AdminFunction();
         am.StoreExamPaper(div, studentid, examid);
         Document doc = am.StringToXml(result);
         NodeList Questions = doc.getElementsByTagName("Question");
         float OptTotalmark = 0.0F;

         for(int i = 0; i < Questions.getLength(); ++i) {
            Node node = Questions.item(i);
            if (node.getNodeType() == 1) {
               Element ele = (Element)node;
               String id = ele.getElementsByTagName("Id").item(0).getTextContent();
               PreparedStatement ps = con.prepareStatement("select mark,type,text from question where id =?");
               ps.setString(1, id);
               ResultSet rs = ps.executeQuery();
               if (rs.next()) {
                  mark = rs.getString(1);
                  type = rs.getString(2);
               }

               Qmark = Float.parseFloat(mark);
               if (!type.equals("QRL-Question a Reponse Libre")) {
                  NodeList options = ele.getElementsByTagName("Option");
                  lose = 0.0F;
                  win = 0.0F;
                  int nbr = options.getLength();
                  float totalTrue = 0.0F;

                  for(int j = 0; j < nbr; ++j) {
                     Node node2 = options.item(j);
                     if (node2.getNodeType() == 1) {
                        Element ele2 = (Element)node2;
                        String optid = ele2.getElementsByTagName("Id").item(0).getTextContent();
                        PreparedStatement ps2 = con.prepareStatement("select isChecked from options where id =?");
                        ps2.setString(1, optid);
                        ResultSet rs2 = ps2.executeQuery();
                        if (rs2.next()) {
                           ischeckeddb = rs2.getString(1);
                        }

                        String isChecked = ele2.getElementsByTagName("isChecked").item(0).getTextContent();
                        if (type.equals("QCU-Question a Choix Unique")) {
                           if (isChecked.equals("1") && ischeckeddb.equals("1")) {
                              OptTotalmark += Qmark;
                           }
                        } else {
                           if (isChecked.equals("1") && ischeckeddb.equals("1")) {
                              ++win;
                           } else if (isChecked.equals("1") && ischeckeddb.equals("0")) {
                              ++lose;
                           }

                           if (isChecked.equals("0") && ischeckeddb.equals("1")) {
                              ++lose;
                           }
                        }
                     }

                     System.out.println("Question" + i + " :" + OptTotalmark);
                  }

                  if (lose == 0.0F) {
                     OptTotalmark += Qmark;
                  }
               }
            }
         }

         System.out.println("Question mark :" + OptTotalmark);
         session.setAttribute("Mark", OptTotalmark);
         response.sendRedirect("003/Result.jsp");
      } catch (ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError | SAXException | SQLException var38) {
         System.out.println(var38);
      }

   }
}
/* Decompiler 108ms, total 1222ms, lines 353 */
package Controller;

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

@WebServlet(
   name = "AddDelete",
   urlPatterns = {"/AddDelete"}
)
public class AddDelete extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private String sectionid;

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String operation = request.getParameter("operation");
      String variable = request.getParameter("variable");
      String variable2 = request.getParameter("variable2");
      String variable3 = request.getParameter("variable3");
      String table = request.getParameter("table");
      String objectid = request.getParameter("objectid");
      HttpSession session = request.getSession();
      String userid = (String)session.getAttribute("id");
      String[] Exam = request.getParameterValues("Exam");
      String[] objectids = request.getParameterValues("objectids[]");
      String[] options = request.getParameterValues("option");
      String[] QuestionofExam = request.getParameterValues("QuestionofExam");
      Connection con = null;

      try {
         con = Database.getConnection();
         PreparedStatement ps4 = con.prepareStatement("select departementid from admin where  id=?");
         ps4.setString(1, userid);
         ResultSet rs0 = ps4.executeQuery();
         String str = null;
         if (rs0.next()) {
            str = rs0.getString(1);
         }

         PreparedStatement pssi = con.prepareStatement("select id from  speciality where  specialityname=?");
         pssi.setString(1, variable2);
         ResultSet rssi = pssi.executeQuery();
         String str2 = null;
         if (rssi.next()) {
            str2 = rssi.getString(1);
         }

         String var;
         int var26;
         int a;
         String[] var28;
         PreparedStatement psm;
         PreparedStatement psg;
         PreparedStatement psq;
         label210:
         switch(operation.hashCode()) {
         case -1335458389:
            if (operation.equals("delete")) {
               PreparedStatement ps = con.prepareStatement("delete from " + table + " where id=?");
               ps.setString(1, objectid);
               ps.executeUpdate();
            }
            break;
         case -697920873:
            if (operation.equals("schedule")) {
               PreparedStatement ps200 = con.prepareStatement("update exam set examduration = ? ,examtarget=? , examdate= ? ,examtime=?,examtype=? where id=?");
               ps200.setString(1, objectids[0]);
               ps200.setString(2, objectids[1]);
               ps200.setString(3, objectids[2]);
               ps200.setString(4, objectids[3]);
               ps200.setString(5, objectids[4]);
               ps200.setString(6, objectids[7]);
               ps200.executeUpdate();
               PreparedStatement ps201 = con.prepareStatement("insert into permissions values(?,?,?)");
               ps201.setString(1, objectids[7]);
               if (objectids[5].equals("false")) {
                  ps201.setInt(2, 0);
               } else {
                  ps201.setInt(2, 1);
               }

               if (objectids[6].equals("false")) {
                  ps201.setInt(3, 0);
               } else {
                  ps201.setInt(3, 1);
               }

               a = ps201.executeUpdate();
               System.out.print(a);
               PreparedStatement ps202 = con.prepareStatement("insert into planning values(?)");
               ps202.setString(1, objectids[7]);
               ps202.executeUpdate();
            }
            break;
         case -358707178:
            if (!operation.equals("deleteall")) {
               break;
            }

            PreparedStatement ps22 = con.prepareStatement("delete from " + table + " where id=? ");
            var28 = objectids;
            a = objectids.length;
            var26 = 0;

            while(true) {
               if (var26 >= a) {
                  break label210;
               }

               var = var28[var26];
               ps22.setString(1, var);
               ps22.executeUpdate();
               ++var26;
            }
         case 96417:
            if (!operation.equals("add")) {
               break;
            }

            PreparedStatement pqss;
            ResultSet rqss;
            PreparedStatement pqs;
            switch(table.hashCode()) {
            case -1237460538:
               if (table.equals("groupe")) {
                  psq = con.prepareStatement("insert into groupe (groupe,specialityid) values (?,?)");
                  psq.setString(1, variable);
                  psq.setString(2, str2);
                  psq.executeUpdate();
               }
               break label210;
            case -1165870106:
               if (!table.equals("question")) {
                  break label210;
               }

               pqs = con.prepareStatement("insert into question (text,mark,type,profid) values (?,?,?,?)");
               pqs.setString(1, variable);
               pqs.setString(2, variable2);
               pqs.setString(3, variable3);
               pqs.setString(4, userid);
               pqs.executeUpdate();
               pqss = con.prepareStatement("select id from question where profid=?");
               pqss.setString(1, userid);
               rqss = pqss.executeQuery();
               String qestionid = null;

               while(rqss.next()) {
                  if (rqss.isLast()) {
                     qestionid = rqss.getString(1);
                  }
               }

               if (options != null && options.length != 0) {
                  PreparedStatement pso2 = con.prepareStatement("insert into  options (text,questionid,isChecked) values (?,?,?)");

                  for(int i = 0; i < options.length; i += 2) {
                     if (options[i].equals("on")) {
                        pso2.setString(1, options[i + 1]);
                        pso2.setString(2, qestionid);
                        pso2.setString(3, "1");
                        pso2.executeUpdate();
                     } else {
                        pso2.setString(1, options[i]);
                        pso2.setString(2, qestionid);
                        pso2.setString(3, "0");
                        pso2.executeUpdate();
                        --i;
                     }
                  }
               }
               break label210;
            case -1068784020:
               if (table.equals("module")) {
                  psg = con.prepareStatement("insert into module (modulename,specialityid) values (?,?)");
                  psg.setString(1, variable);
                  psg.setString(2, str2);
                  psg.executeUpdate();
               }
               break label210;
            case -997953195:
               if (table.equals("speciality")) {
                  psm = con.prepareStatement("insert into  speciality (specialityname,departementid) values (?,?)");
                  psm.setString(1, variable);
                  psm.setString(2, str);
                  psm.executeUpdate();
               }
               break label210;
            case 3127327:
               if (table.equals("exam")) {
                  PreparedStatement pse2 = con.prepareStatement("insert into exam (examname,examtarget,examtype,profid) values (?,?,?,?)");
                  int iteration = 1;
                  String[] var39 = Exam;
                  int var38 = Exam.length;

                  for(int var37 = 0; var37 < var38; ++var37) {
                     String item = var39[var37];
                     pse2.setString(iteration, item);
                     ++iteration;
                  }

                  pse2.setString(4, userid);
                  pse2.executeUpdate();
                  PreparedStatement peex = con.prepareStatement("select id from exam where profid=?");
                  peex.setString(1, userid);
                  ResultSet reex = peex.executeQuery();

                  String examid;
                  for(examid = null; reex.next(); examid = reex.getString(1)) {
                  }

                  if (QuestionofExam != null && QuestionofExam.length != 0) {
                     pqs = con.prepareStatement("insert into section (examid) values(?)");
                     pqs.setString(1, examid);
                     pqs.executeUpdate();
                     pqss = con.prepareStatement("select sectionid from  section where examid=?");
                     pqss.setString(1, examid);

                     for(rqss = pqss.executeQuery(); rqss.next(); this.sectionid = rqss.getString(1)) {
                     }

                     PreparedStatement pqe2 = con.prepareStatement("update question set sectionid =? ,examid =?  where id=? ");

                     for(int i = 0; i < QuestionofExam.length; ++i) {
                        pqe2.setString(1, this.sectionid);
                        pqe2.setString(2, examid);
                        String[] sentence = QuestionofExam[i].split(":");
                        pqe2.setString(3, sentence[0]);
                        pqe2.executeUpdate();
                     }
                  }
               }
            default:
               break label210;
            }
         case 3108362:
            if (operation.equals("edit")) {
               switch(table.hashCode()) {
               case -1237460538:
                  if (table.equals("groupe")) {
                     psg = con.prepareStatement("update groupe set groupe=? , specialityid=? where id=?");
                     psg.setString(1, variable);
                     psg.setString(2, str2);
                     psg.setString(3, objectid);
                     psg.executeUpdate();
                  }
                  break;
               case -1165870106:
                  if (table.equals("question")) {
                     psq = con.prepareStatement("update question set text=? ,mark=?,type=? where id=?");
                     psq.setString(1, variable);
                     psq.setString(2, variable2);
                     psq.setString(3, variable3);
                     psq.setString(4, objectid);
                     psq.executeUpdate();
                  }
                  break;
               case -1068784020:
                  if (table.equals("module")) {
                     psm = con.prepareStatement("update module set modulename=? , specialityid=? where id=?");
                     psm.setString(1, variable);
                     psm.setString(2, str2);
                     psm.setString(3, objectid);
                     psm.executeUpdate();
                  }
                  break;
               case -997953195:
                  if (table.equals("speciality")) {
                     PreparedStatement ps2 = con.prepareStatement("update speciality set specialityname=? where id=?");
                     ps2.setString(1, variable);
                     ps2.setString(2, objectid);
                     ps2.executeUpdate();
                  }
               }
            }
            break;
         case 1536890777:
            if (operation.equals("checkall")) {
               var28 = objectids;
               a = objectids.length;

               for(var26 = 0; var26 < a; ++var26) {
                  var = var28[var26];
                  PreparedStatement ps200 = con.prepareStatement("update " + table + " set checked = 1 where id=?");
                  ps200.setString(1, var);
                  ps200.executeUpdate();
               }
            }
         }

         switch(table.hashCode()) {
         case -1879145925:
            if (table.equals("student")) {
               response.sendRedirect(request.getContextPath() + "/DisplayAccount");
               return;
            }
            break;
         case -1237460538:
            if (table.equals("groupe")) {
               response.sendRedirect(request.getContextPath() + "/DisplayGroup");
               return;
            }
            break;
         case -1165870106:
            if (table.equals("question")) {
               response.sendRedirect(request.getContextPath() + "/DisplayQuestion");
               return;
            }
            break;
         case -1068784020:
            if (table.equals("module")) {
               response.sendRedirect(request.getContextPath() + "/DisplayModule");
               return;
            }
            break;
         case -997953195:
            if (table.equals("speciality")) {
               response.sendRedirect(request.getContextPath() + "/DisplaySpeciality");
               return;
            }
            break;
         case 3127327:
            if (table.equals("exam")) {
               response.sendRedirect(request.getContextPath() + "/DisplayExam");
               return;
            }
            break;
         case 3449689:
            if (table.equals("prof")) {
               response.sendRedirect(request.getContextPath() + "/DisplayProf");
               return;
            }
         }

         response.sendError(404);
      } catch (SQLException var45) {
         System.out.println(var45);
         request.setAttribute("message", var45);
         request.getRequestDispatcher("welcom.jsp").forward(request, response);
      }

   }
}
package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.HashMap;

@WebServlet(name = "ExamGetServlet",urlPatterns = {"/ExamGetServlet"})


class question {
   public static String section;
   public static String QuestionId;
   public static String QuestionText;
   public static String QuestionResponse;
   public static String QuestionType;
   public static String ExamId;
   public static String NbrOptions;
   public static String HasImg;
   public static float QuestionMark;
   public static HashMap<String, Boolean> options = new HashMap();
}
public class ExamGetServlet extends HttpServlet {
   private static String ExamId;
   private static String ExamName;
   private static String ExamDate;
   private static String ExamTime;
   private static String ExamType;
   private static String ExamDuration;
   private static String ExamTarget;
   private static String ExamPermission;
   private static String OptionText;
   private static boolean IfChecked;
   private static String SectionId;
   private static String SectionText;
   private static final long serialVersionUID = 1L;
   public static question obj = new question();
   static String section;
   static String text;
   static String type;
   static String hasImg;
   static String nbrOptions;
   static String label;
   static boolean checkBox;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String infoinput = request.getParameter("examinfo");
      String jsonrequest = request.getParameter("JsonArray");
      PrintWriter pw = response.getWriter();
      pw.println("<h1> alhmdollah.3.. : " + jsonrequest + "</h1>");
      pw.close();
      FileWriter file = new FileWriter("C:\\Users\\DELL\\Desktop\\out.json");
      file.write(jsonrequest);
      file.close();
      JSONParser jsonP = new JSONParser();

      try {
         Object obj = jsonP.parse(jsonrequest);
         JSONArray empList = (JSONArray)obj;
         System.out.println(empList);
         System.out.println("---------------------------------------");
         empList.forEach((emp) -> {
            ExtractQuestion((JSONObject)emp);
         });
      } catch (ParseException var10) {
         var10.printStackTrace();
      }

   }

   private static void ExtractQuestion(JSONObject emp) {
      obj = new question();
      JSONObject empObj = (JSONObject)emp.get("Question");
      question.section = (String)empObj.get("Section");
      question.QuestionText = (String)empObj.get("Text");
      question.QuestionType = (String)empObj.get("Type");
      question.HasImg = (String)empObj.get("HasImg");
      boolean esay = Boolean.parseBoolean(question.HasImg);
      System.out.println("Section : ge" + section);
      System.out.println("Text : " + text);
      System.out.println("Type : " + type);
      System.out.println("HasImg : " + hasImg);
      System.out.println("NbrOptions : " + nbrOptions);
      int n = Integer.valueOf(nbrOptions);
      if (n > 0) {
         for(int i = 1; i <= n; ++i) {
            label = (String)empObj.get("Label" + i);
            checkBox = (Boolean)empObj.get("CheckBox" + i);
            question.options.put(label, checkBox);
            System.out.println("----------------Label" + i + " : " + label);
            System.out.println("--------------CheckBox" + i + " : " + checkBox);
         }
      }

   }
}
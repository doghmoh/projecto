package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;



public class ExamCreationDB {
	
	public static Connection conn = null;
   public static String QID,EID,SID;
public static void SaveExam(Boolean JustSendOneExamName,String ExamName,String Section,String QuestionText,String QuestionType,String HasImg,long NbrOptions,HashMap<String, Boolean> OptionsMap) {
	 
  try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         
            conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","root");
            System.out.println("Connection is created successfully:");
 
            ////////// Exam Table /////////
            if(JustSendOneExamName) {
           
            PreparedStatement stmt_exam = conn.prepareStatement("insert into exam (ExamName) values(?)");
            stmt_exam.setString(1, ExamName);
            stmt_exam.executeUpdate(); 
            System.out.println("     Exam inserted ......... Ok");
            //////////////// Getting ExamId ////////////
            PreparedStatement stmt_exam2 = conn.prepareStatement("select ExamId from exam");
            ResultSet rs_Exam=stmt_exam2.executeQuery(); 
            while (rs_Exam.next()) {
            System.out.println(rs_Exam.getString("ExamId"));
     		EID=rs_Exam.getString("ExamId");
     		}
          //  stmt_exam2.executeUpdate(); 
            JustSendOneExamName=false;
            }
 
            ////////////// Section Table //////
            if(Section !=null) {
            PreparedStatement stmt_Section = conn.prepareStatement("insert into section (SectionText) values(?)");
            stmt_Section.setString(1,Section);
            stmt_Section.executeUpdate();
            System.out.println("Section inserted ......... Ok");
            ////////////////Getting SectionId ////////////
            PreparedStatement stmt_Section2 = conn.prepareStatement("select SectionId from section");
            ResultSet rs_Section=stmt_Section2.executeQuery(); 
              while (rs_Section.next()) {
               System.out.println(rs_Section.getString("SectionId"));
		       SID=rs_Section.getString("SectionId");
		      }
            }
            
            
            
            
            
     
            /////// Question Table /////////
            PreparedStatement stmt_question = conn.prepareStatement("insert into question(ExamID,QuestionText,QuestionMark,QuestionType,HasImg,NbrOptions,SectionId) values(?,?,?,?,?,?,?)");
            stmt_question.setInt(1,Integer.parseInt(EID));//// get it by ExamName
            stmt_question.setString(2,QuestionText);
            stmt_question.setFloat(3, 25); /// float
            stmt_question.setString(4,QuestionType);// 'TEXT','QCM','BA'
          //  if(HasImg ==null || HasImg.length()==0) {
            	InputStream img = new FileInputStream(new File(HasImg));
            	stmt_question.setBlob(5,img);
            //}
            stmt_question.setInt(6,(int)NbrOptions);
           if(Section ==null || Section.length()==0) {stmt_question.setString(6,"");}else {stmt_question.setString(7,SID);}   
            stmt_question.executeUpdate();
            System.out.println("    Question inserted ......... Ok");
            ////////////////Getting QuestionId ////////////
            PreparedStatement stmt_question2 = conn.prepareStatement("select QuestionId from question");
            ResultSet rs_Qst=stmt_question2.executeQuery(); 
            while (rs_Qst.next()) {
            	 System.out.println(rs_Qst.getString("QuestionId"));
				 QID=rs_Qst.getString("QuestionId");
			}
            System.out.println("yyyyyyyyyyyyyyyyyyyyy "+ QID);
            //stmt_question2.executeUpdate();
            

            
            /////// Q_Options Table ///////// 
            if(NbrOptions >0) {
            	for (String key: OptionsMap.keySet()) {
            PreparedStatement stmt_option = conn.prepareStatement("insert into qoptions (OptionText,IfChecked,QuestionId) values(?,?,?)");
            stmt_option.setString(1,key);
            stmt_option.setBoolean(2,OptionsMap.get(key));  
            stmt_option.setInt(3, Integer.parseInt(QID));
            stmt_option.executeUpdate();
            System.out.println("    Option inserted ......... Ok");
            	}
            }
            
           
   
    
 
    System.out.println("Record is inserted in the table successfully..................");
    conn.close();
    }
    catch(Exception e){
        System.out.println(e);
    }
}
	




}

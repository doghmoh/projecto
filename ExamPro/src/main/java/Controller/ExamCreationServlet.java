package Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Struct;
import java.sql.*;
import java.util.HashMap;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import java.util.ArrayList;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Model.ExamCreationDB;



 
@WebServlet(name="ExamCreationServlet",urlPatterns={"/ExamCreationServlet"})
public  class ExamCreationServlet extends HttpServlet {
	 public static String Section,QuestionId,QuestionText,QuestionResponse,QuestionType,ExamName,HasImg,label;
	 public static boolean Checked;
	 public static int ExamId;
	public static long NbrOptions,QuestionMark;
	 public static HashMap<String, Boolean> OptionsMap= new HashMap<String, Boolean>();//label,Checked
	 public static boolean JustOneSendExamName;

	
    
	private static final long serialVersionUID = 1L;
       @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		 
    	   String infoinput=request.getParameter("examinfo"); 
   		PrintWriter pw = response.getWriter();
           
   	    pw.println("<h1> alhmdollah.3.. : "+infoinput+"</h1>");
           pw.close();
    
         FileWriter file = new FileWriter("C:\\Users\\Mohamed\\Desktop\\example.json");
         file.write(infoinput);
         file.close();
	
     ///////////////////////////////

JSONParser jsonP = new JSONParser();
	 try(FileReader reader = new FileReader("C:\\Users\\Mohamed\\Desktop\\example.json")){
		   //Read JSON File
		   Object obj = jsonP.parse(reader);
		   JSONArray empList = (JSONArray) obj;
		   System.out.println(empList); //Control c =new Control(); c.insert();
		   System.out.println("---------------------------------------");
		   //Iterate over emp array
		/// Object[] ss=  empList.toArray();
		// for (int i=0;i<ss.length;i++) {
			// System.out.println("-lenght "+ss.length);
			// ExtractQuestion((JSONObject) ss[1]);
			// ExtractQuestion((JSONObject) ss[2]);
			// ExtractQuestion((JSONObject) ss[3]);
			 //}
		   JustOneSendExamName=true;
		  empList.forEach(emp-> ExtractQuestion((JSONObject)emp,request));
		  
		  }
	 
		  catch (FileNotFoundException e) {
		            e.printStackTrace();
		            System.out.println("--"+e);
		        } catch (IOException e) {
		        	System.out.println("--"+e);
		            e.printStackTrace();
		        } catch (ParseException e) {
		        	System.out.println("--"+e);
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 ///////////////////////////////////////////////////  Getting Form Data  /////////////
	 String Duration=request.getParameter("selectduration");
	 String Target=request.getParameter("selectgroups");
	 String ExamDate=request.getParameter("dateinfo");
	 String ExamTime=request.getParameter("examtime");
	 String ExamType=request.getParameter("examtype");
	 String AllowUploadPermission=request.getParameter("allowupload");
	 String AllowAutoCorrPermission=request.getParameter("allowautocorr");
	 
	 System.out.println("----Duration "+Duration);
	 System.out.println("----Target "+Target);
	 System.out.println("----ExamDate "+ExamDate);
	 System.out.println("----ExamTime "+ExamTime);
	 System.out.println("----ExamType "+ExamType);
	 System.out.println("----AllowUploadPermission "+AllowUploadPermission);
	 System.out.println("----AllowAutoCorrPermission "+AllowAutoCorrPermission);
	 
	 

	 
}
       
       
static  ArrayList<ExamCreationServlet> MyQuestionArray = new ArrayList<ExamCreationServlet>();	

private static void ExtractQuestion(JSONObject emp,HttpServletRequest request) {
     // ExamCreationServlet obj=new  ExamCreationServlet();
		System.out.println("--------------------------------------- from extract");

		  JSONObject empObj = (JSONObject) emp.get("Question");
		
		   Section = (String) empObj.get("Section");
		   QuestionText = (String) empObj.get("Text");
		  QuestionType = (String) empObj.get("Type");
		  HasImg = (String) empObj.get("HasImg");
		  NbrOptions = (long) (empObj.get("NbrOptions"));
		  QuestionMark = (long) (empObj.get("Mark"));
	/*	  
		  System.out.println("Section "+Section);
		  System.out.println("QuestionText "+QuestionText);
		  System.out.println("QuestionType "+QuestionType);
		  System.out.println("HasImg "+HasImg);
		  System.out.println("NbrOptions "+NbrOptions);
		 */ 
 
	
		  
		 
		  if(NbrOptions >0) {
			  for(int i=1 ;i<=NbrOptions;i++) {
		     String  str = (String) empObj.get("Label"+i);
		     label=request.getParameter(str);
		     System.out.println("----str ="+str+"------------Label"+i+" : " +label);
		     
		     if(empObj.get("CheckBox"+i).equals("true")){
		    	 Checked =true;
		    	 }
		     else { Checked=false; } 
		     
		     
		    		  
		         OptionsMap.put(label,Checked); 
		        System.out.println("----------------Label "+i+" : " +label);
		        System.out.println("----------------Checked "+i+" : " +Checked);
		        
		       
			  }
		  }
	//	  System.out.println("NbrOptions "+OptionsMap);
		 
		 // ExamCreationDB.SaveExam(JustOneSendExamName,ExamName,Section,QuestionText,HasImg,QuestionType,NbrOptions,OptionsMap);
		  OptionsMap.clear();
		  
		  
		 System.out.println("ExamName :"+request.getParameter("ExamName")); 
		 System.out.println("Section :"+request.getParameter(Section)); 
		 System.out.println("Text :"+request.getParameter(QuestionText)); 
		 System.out.println("Type :"+QuestionType); 
		 System.out.println("HasImg :"+HasImg);
		 System.out.println("NbrOptions :"+NbrOptions); 
		 
		
		 
	}
    
    
    

}//class

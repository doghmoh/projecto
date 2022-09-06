package Controller;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.security.PublicKey;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Model.ExamCreationDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.*;


public class Control {
	
	    private String ExamId,ExamName,ExamDate,ExamTime,ExamType,ExamDuration,ExamTarget,ExamPermission;
	    private String QuestionId,QuestionText,QuestionNbr,QuestionMark,QuestionResponse,QuestionType;private boolean HasImg;
	    private String OptionText;private boolean IfChecked;
	    
	    public String GetExamId(){
	    return this.ExamId;
	    }
	    //////////////////////////////////////////
	    public String GetExamName(){
	    return this.ExamName;
	    }
	    public void SetExamName(String examname){
	     this.ExamName=examname;
	    }
	    //////////////////////////////////////////
	    public String GetExamDate(){
	    return this.ExamDate;
	    }
	    public void SetExamDate(String examdate){
	     this.ExamDate=examdate;
	    }
	//////////////////////////////////////////////
	    public String GetExamTime(){
	    return this.ExamTime;
	    }
	    public void SetExamTime(String examtime){
	     this.ExamTime=examtime;
	    }  
	    /////////////////////////////////////////
	    public String GetExamType(){
	    return this.ExamType;
	    }
	    public void SetExamType(String examtype){
	     this.ExamType=examtype;
	    }
	    /////////////////////////////////////////
	    public String GetExamDuration(){
	    return this.ExamDuration;
	    }
	    public void SetExamDuration(String examduration){
	     this.ExamDuration=examduration;
	    }
	    ////////////////////////////////////////
	    public String GetExamTarget(){
	    return this.ExamTarget;
	    }
	    public void SetExamTarget(String examtarget){
	     this.ExamTarget=examtarget;
	    }
	    ////////////////////////////////////////
	    public String GetExamPermission(){
	    return this.ExamPermission;
	    }
	    public void SetExamPermission(String exampermission){
	     this.ExamName=exampermission;
	    }
	    /////////////////////////////////
	    /////////////////////////////////
	    public String GetQuestionId(){
	    return this.QuestionId;
	    }
	    //////////////////////////////////   
	    public String GetQuestionText(){
	    return this.QuestionText;
	    }
	    public void SetQuestionText(String questiontext){
	     this.QuestionText=questiontext;
	    }
	    /////////////////////////////////
	    public String GetQuestionType(){
	    return this.QuestionType;
	    }
	    public void SetQuestionType(String questiontype){
	     this.QuestionType=questiontype;
	    }
	    ////////////////////////////////
	     public String GetQuestionNbr(){
	    return this.QuestionNbr;
	    }
	    public void SetQuestionNbr(String questionnbr){
	     this.QuestionNbr=questionnbr;
	    }
	    ///////////////////////////////
	    public String GetQuestionMark(){
	    return this.QuestionMark;
	    }
	    public void SetQuestionMark(String questionmark){
	     this.QuestionMark=questionmark;
	    }
	    ///////////////////////////////
	     public String GetQuestionRespone(){
	    return this.QuestionResponse;
	    }
	    public void SetQuestionResponse(String questionresponse){
	     this.QuestionResponse=questionresponse;
	    }
	    ///////////////////////////////
	    public boolean GetHasImg(){
	    return this.HasImg;
	    }
	    public void SetHasImg(boolean hasimg){
	     this.HasImg=hasimg;
	    }
	    ///////////////////////////////
	    //////////////////////////////
	    public String GetOptionText(){
	    return this.OptionText;
	    }
	    public void SetHasImg(String optiontext){
	     this.OptionText=optiontext;
	    }
	    ////////////////////////////
	    public boolean GetIfChecked(){
	    return this.IfChecked;
	    }
	    public void SetIfChecked(boolean ifchecked){
	     this.IfChecked=ifchecked;
	    }
	    
  
	  
    public static void main(String[] args) throws org.json.simple.parser.ParseException {
   	   /*HashMap<String, Boolean> Option= new HashMap<String, Boolean>();//label,Checked
   	    Option.put("option8", false);
    	Option.put("option88", true);
    	Option.put("option888", true);
    	Option.put("option8888", true);

		 ExamCreationDB.SaveExam(true,"ExamName8","Section8","QuestionText8","QCM","C:\\Users\\Mohamed\\Desktop\\Project8.jpg",4,Option);
*/
    
  }
    
}
    
    
    























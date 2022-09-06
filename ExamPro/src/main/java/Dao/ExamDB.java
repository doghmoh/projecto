
package Dao;

import Model.Database;
import Model.ExamCreation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamDB {

    private final Connection con;
    
    public ExamDB() throws SQLException{
        this.con= Database.getConnection();
    }
    public ExamCreation getExamData(String id) throws SQLException{
     PreparedStatement ps = con.prepareStatement("select * from exam where examid=?");
     ps.setString(1, id);
     ResultSet rs = ps.executeQuery();
     ExamCreation exam =new ExamCreation();
     if(rs.next()) {
        exam.SetExamId(rs.getString(1));
        exam.SetExamName(rs.getString(2));
        exam.SetExamDate(rs.getString(3));
        exam.SetExamTime(rs.getString(4));
        exam.SetExamDuration(rs.getString(5));
        exam.SetExamType(rs.getString(6));
        exam.SetExamTarget(rs.getString(7));
        exam.SetExamPermission(rs.getString(7));
    }
    return  exam;
    }
    public ExamCreation getQuestionData(String id) throws SQLException{
     PreparedStatement ps = con.prepareStatement("select * from question where questionid= ?");
     ps.setString(1, id);
     ResultSet rs = ps.executeQuery();
     ExamCreation question =new ExamCreation();
     if(rs.next()) {
        question.SetQuestionId(rs.getString(1));
        question.SetExamId(rs.getString(2));
        question.SetQuestionText(rs.getString(3));
        question.SetQuestionNbr(rs.getString(4));
        question.SetQuestionMark(rs.getString(5));
        question.SetQuestionResponse(rs.getString(6));
        question.SetQuestionType(rs.getString(7));
        question.SetHasImg(rs.getBoolean(8));
    }
    return  question;
    }
    
    public ExamCreation getQOptionData(String id) throws SQLException{
     PreparedStatement ps = con.prepareStatement("select * from qoptions where questionid= ?");
     ps.setString(1, id);
     ResultSet rs = ps.executeQuery();
     ExamCreation qoptions = new ExamCreation();
     if(rs.next()) {
        qoptions.SetQuestionId(rs.getString(1));
        qoptions.SetOptionText(rs.getString(2));
        qoptions.SetIfChecked(rs.getBoolean(3));
    }
    return  qoptions;
    }
}

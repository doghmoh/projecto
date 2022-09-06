/* Decompiler 129ms, total 3680ms, lines 1087 */
package Dao;

import Model.Database;
import Model.User;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class AdminFunction {
   private Element Exams = null;
   private Element Exam = null;
   private Element ExamId = null;
   private Element ExamModule = null;
   private Element ExamDate = null;
   private Element ExamTime = null;
   private Element ExamDuration = null;
   private Element ExamType = null;
   private Element ExamTarget = null;
   private Element ExamPermissions = null;
   private Element ExamCreator = null;
   private Element[] ExamElements;
   private String[] ExamValue;
   private Element Sections;
   private Element Section;
   private Element SectionId;
   private Element SectionText;
   private Element SectionExamId;
   private Element[] SectionElements;
   private String[] SectionValue;
   private Element Questions;
   private Element Question;
   private Element QuestionId;
   private Element QuestionText;
   private Element QuestionMark;
   private Element QuestionType;
   private Element QuestionCreator;
   private Element QuestionExamId;
   private Element QuestionSectionId;
   private Element[] QuestionElements;
   private String[] QuestionValue;
   private Element Options;
   private Element Option;
   private Element OptionId;
   private Element OptionText;
   private Element OptionQuestionId;
   private Element OptionIsChecked;
   private Element[] OptionElements;
   private String[] OptionValue;
   private Element Permissions;
   private Element Permission;
   private Element PermissionId;
   private Element AllowUploadDocuments;
   private Element AllowAutoCorrection;
   private Element[] PermissionElements;
   private String[] PermissionValue;
   private Element Modules;
   private Element Module;
   private Element ModuleId;
   private Element ModuleName;
   private Element ModuleSpeciality;
   private Element[] ModuleElement;
   private String[] ModuleValue;
   private Element Facultys;
   private Element Faculty;
   private Element FacultyId;
   private Element FacultyName;
   private Element[] FacultyElement;
   private String[] FacultyValue;
   private Element Departements;
   private Element Departement;
   private Element DepartementName;
   private Element DepartementId;
   private Element[] DepartementElement;
   private String[] DepartementValue;
   private Element Specialitys;
   private Element Speciality;
   private Element SpecialityName;
   private Element SpecialityId;
   private Element[] SpecialityElement;
   private String[] SpecialityValue;
   private Element Groups;
   private Element Group;
   private Element GroupId;
   private Element GroupName;
   private Element GroupMember;
   private Element GroupSpecialityId;
   private Element[] GroupElement;
   private String[] GroupValue;
   private Element Students;
   private Element Student;
   private Element StudentId;
   private Element StudentFName;
   private Element Password;
   private Element StudentLName;
   private Element StudentEmail;
   private Element StudentDOB;
   private Element StudentSexe;
   private Element UniversityId;
   private Element DepartmentId;
   private Element LevelId;
   private Element Matricule;
   private Element Active;
   private Element Checked;
   private Element CreationDate;
   private Element[] StudentElements;
   private String[] StudentValue;
   private Element Profs;
   private Element Prof;
   private Element ProfId;
   private Element ProfFName;
   private Element ProfLName;
   private Element ProfEmail;
   private Element ProfDOB;
   private Element ProfSexe;
   private Element[] ProfElements;
   private String[] ProfValue;
   private Element Admins;
   private Element Admin;
   private Element AdminId;
   private Element AdminFName;
   private Element AdminLName;
   private Element AdminEmail;
   private Element AdminDOB;
   private Element AdminSexe;
   private Element[] AdminElements;
   private String[] AdminValue;
   private boolean update;
   private Connection con;
   private final User student;
   private final User prof;
   private final User admin;

   public AdminFunction() throws SQLException {
      this.ExamElements = new Element[]{this.Exams, this.Exam, this.ExamId, this.ExamModule, this.ExamDate, this.ExamTime, this.ExamDuration, this.ExamType, this.ExamTarget, this.ExamCreator};
      this.ExamValue = new String[]{"Exams", "Exam", "Id", "Module", "Date", "Time", "Duration", "Type", "Target", "Creator"};
      this.Sections = null;
      this.Section = null;
      this.SectionId = null;
      this.SectionText = null;
      this.SectionExamId = null;
      this.SectionElements = new Element[]{this.Sections, this.Section, this.SectionText, this.SectionId, this.SectionExamId};
      this.SectionValue = new String[]{"Sections", "Section", "Text", "Id", "ExamId"};
      this.Questions = null;
      this.Question = null;
      this.QuestionId = null;
      this.QuestionText = null;
      this.QuestionMark = null;
      this.QuestionType = null;
      this.QuestionCreator = null;
      this.QuestionSectionId = null;
      this.QuestionElements = new Element[]{this.Questions, this.Question, this.QuestionId, this.QuestionText, this.QuestionMark, this.QuestionType, this.QuestionCreator, this.QuestionExamId, this.QuestionSectionId};
      this.QuestionValue = new String[]{"Questions", "Question", "Id", "Text", "Mark", "Type", "Creator", "ExamId", "SectionId"};
      this.Options = null;
      this.Option = null;
      this.OptionId = null;
      this.OptionText = null;
      this.OptionQuestionId = null;
      this.OptionIsChecked = null;
      this.OptionElements = new Element[]{this.Options, this.Option, this.OptionId, this.OptionText, this.OptionQuestionId, this.OptionIsChecked};
      this.OptionValue = new String[]{"Options", "Option", "Id", "Text", "QuestionId", "IsChecked"};
      this.Permissions = null;
      this.Permission = null;
      this.PermissionId = null;
      this.AllowUploadDocuments = null;
      this.AllowAutoCorrection = null;
      this.PermissionElements = new Element[]{this.Permissions, this.Permission, this.PermissionId, this.AllowUploadDocuments, this.AllowAutoCorrection};
      this.PermissionValue = new String[]{"Permissions", "Permission", "Id", "AllowUploadDocuments", "AllowAutoCorrection"};
      this.Modules = null;
      this.Module = null;
      this.ModuleId = null;
      this.ModuleName = null;
      this.ModuleSpeciality = null;
      this.ModuleElement = new Element[]{this.Modules, this.Module, this.ModuleId, this.ModuleName, this.ModuleSpeciality};
      this.ModuleValue = new String[]{"Modules", "Module", "Id", "Name", "SpecialityId"};
      this.Facultys = null;
      this.Faculty = null;
      this.FacultyId = null;
      this.FacultyName = null;
      this.FacultyElement = new Element[]{this.Facultys, this.Faculty, this.FacultyId, this.FacultyName};
      this.FacultyValue = new String[]{"Facultys", "Faculty", "Id", "Name"};
      this.Departements = null;
      this.Departement = null;
      this.DepartementName = null;
      this.DepartementId = null;
      this.DepartementElement = new Element[]{this.Departements, this.Departement, this.DepartementId, this.DepartementName, this.FacultyId};
      this.DepartementValue = new String[]{"Departements", "Departement", "Id", "Name", "FacultyId"};
      this.Specialitys = null;
      this.Speciality = null;
      this.SpecialityName = null;
      this.SpecialityId = null;
      this.SpecialityElement = new Element[]{this.Specialitys, this.Speciality, this.SpecialityId, this.SpecialityName, this.DepartementId};
      this.SpecialityValue = new String[]{"Specialitys", "Speciality", "Id", "Name", "DepartementId"};
      this.Groups = null;
      this.Group = null;
      this.GroupId = null;
      this.GroupName = null;
      this.GroupMember = null;
      this.GroupElement = new Element[]{this.Groups, this.Group, this.GroupId, this.GroupName, this.GroupSpecialityId, this.GroupMember};
      this.GroupValue = new String[]{"Groups", "Group", "Id", "Name", "SpecialityId", "GroupMember"};
      this.Students = null;
      this.Student = null;
      this.StudentId = null;
      this.StudentFName = null;
      this.Password = null;
      this.StudentLName = null;
      this.StudentEmail = null;
      this.StudentDOB = null;
      this.StudentSexe = null;
      this.UniversityId = null;
      this.DepartmentId = null;
      this.LevelId = null;
      this.Matricule = null;
      this.Active = null;
      this.Checked = null;
      this.CreationDate = null;
      this.StudentElements = new Element[]{this.Students, this.Student, this.StudentId, this.StudentFName, this.StudentLName, this.StudentEmail, this.Password, this.StudentDOB, this.StudentSexe, this.Matricule, this.FacultyId, this.UniversityId, this.DepartmentId, this.SpecialityId, this.LevelId, this.GroupId, this.Active, this.Checked, this.CreationDate};
      this.StudentValue = new String[]{"Students", "Student", "Id", "FName", "LName", "Email", "Password", "DateOfBirth", "Sexe", "Matricule", "UniversityId", "FacultyId", "DepartmentId", "SpecialityId", "LevelId", "GroupId", "Active", "Checked", "CreationDate"};
      this.Profs = null;
      this.Prof = null;
      this.ProfId = null;
      this.ProfFName = null;
      this.ProfLName = null;
      this.ProfEmail = null;
      this.ProfDOB = null;
      this.ProfSexe = null;
      this.ProfElements = new Element[]{this.Profs, this.Prof, this.ProfId, this.ProfFName, this.ProfLName, this.ProfEmail, this.Password, this.ProfDOB, this.ProfSexe, this.UniversityId, this.Active, this.Checked, this.CreationDate};
      this.ProfValue = new String[]{"Profs", "Prof", "Id", "FName", "LName", "Email", "Password", "DateOfBirth", "Sexe", "UniversityId", "Active", "Checked", "CreationDate"};
      this.Admins = null;
      this.Admin = null;
      this.AdminId = null;
      this.AdminFName = null;
      this.AdminLName = null;
      this.AdminEmail = null;
      this.AdminDOB = null;
      this.AdminSexe = null;
      this.AdminElements = new Element[]{this.Admins, this.Admin, this.AdminId, this.AdminFName, this.AdminLName, this.AdminEmail, this.Password, this.AdminDOB, this.AdminSexe, this.UniversityId, this.DepartmentId, this.Active, this.Checked, this.CreationDate};
      this.AdminValue = new String[]{"Admins", "Admin", "Id", "FName", "LName", "Email", "Password", "DateOfBirth", "Sexe", "UniversityId", "DepartmentId", "Active", "Checked", "CreationDate"};
      this.update = false;
      this.con = null;
      this.student = null;
      this.prof = null;
      this.admin = null;
      this.con = Database.getConnection();
   }

   public void GetFaculty() throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError, SAXException, IOException {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.FacultyElement[0], this.FacultyValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from Faculty ");
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element subRoot = this.CreateXmlElement(doc, rootElement, this.FacultyElement[1], this.FacultyValue[1], "");
         this.CreateXmlElement(doc, subRoot, this.FacultyElement[2], this.FacultyValue[2], rs.getString(1));
         this.CreateXmlElement(doc, subRoot, this.FacultyElement[3], this.FacultyValue[3], rs.getString(2));
         Element old = this.GetDepartement(rs.getString(1));
         Node newer = doc.importNode(old, true);
         subRoot.appendChild(newer);
      }

      this.StringToFile(doc, rootElement);
   }

   public Element GetDepartement(String id) throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.DepartementElement[0], this.DepartementValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select d.id, d.departementname,f.facultyname from departement d , faculty f  where d.facultyid = f.id  and   d.id =? ");
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element subRoot = this.CreateXmlElement(doc, rootElement, this.DepartementElement[1], this.DepartementValue[1], "");
         this.CreateXmlElement(doc, subRoot, this.DepartementElement[2], this.DepartementValue[2], rs.getString(1));
         this.CreateXmlElement(doc, subRoot, this.DepartementElement[3], this.DepartementValue[3], rs.getString(2));
         this.CreateXmlElement(doc, subRoot, this.DepartementElement[4], this.DepartementValue[4], rs.getString(3));
         Element old = this.GetAllSpeciality(rs.getString(1));
         Node newer = doc.importNode(old, true);
         subRoot.appendChild(newer);
      }

      return rootElement;
   }

   public String GetSpeciality(String id) throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.SpecialityElement[0], this.SpecialityValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select s.id , s.Specialityname, s.departementid from  Speciality s ,admin a where s.departementid = a.departementid and a.id=?");
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element subRoot = this.CreateXmlElement(doc, rootElement, this.SpecialityElement[1], this.SpecialityValue[1], "");
         this.CreateXmlElement(doc, subRoot, this.SpecialityElement[2], this.SpecialityValue[2], rs.getString(1));
         this.CreateXmlElement(doc, subRoot, this.SpecialityElement[3], this.SpecialityValue[3], rs.getString(2));
         this.CreateXmlElement(doc, subRoot, this.SpecialityElement[4], this.SpecialityValue[4], rs.getString(3));
      }

      System.out.print(id);
      return this.XmlToString(doc, rootElement);
   }

   public String GetGroups(String id) throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError, SAXException, IOException {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.GroupElement[0], this.GroupValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select g.id,g.groupe ,s.specialityname  from groupe g,speciality s  ,admin a where  g.specialityid = s.id and s.departementid = a.departementid and a.id =?");
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element subRoot = this.CreateXmlElement(doc, rootElement, this.GroupElement[1], this.GroupValue[1], "");
         this.CreateXmlElement(doc, subRoot, this.GroupElement[2], this.GroupValue[2], rs.getString(1));
         this.CreateXmlElement(doc, subRoot, this.GroupElement[3], this.GroupValue[3], rs.getString(2));
         this.CreateXmlElement(doc, subRoot, this.GroupElement[4], this.GroupValue[4], rs.getString(3));
         PreparedStatement ps2 = this.con.prepareStatement("select count(id) as NbrOfStudent from student where groupid =? and specialityid =(select id from speciality where specialityname =?)");
         ps2.setString(1, rs.getString(1));
         ps2.setString(2, rs.getString(3));
         ResultSet rs2 = ps2.executeQuery();
         if (rs2.next()) {
            this.CreateXmlElement(doc, subRoot, this.GroupElement[5], this.GroupValue[5], rs2.getString(1));
         }
      }

      return this.XmlToString(doc, rootElement);
   }

   public Element GetAllSpeciality(String id) throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.SpecialityElement[0], this.SpecialityValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select s.id , s.specialityname, d.departementname  from  Speciality s , departement d where s.departementid = d.id and departementid=?");
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element subRoot = this.CreateXmlElement(doc, rootElement, this.SpecialityElement[1], this.SpecialityValue[1], "");
         this.CreateXmlElement(doc, subRoot, this.SpecialityElement[2], this.SpecialityValue[2], rs.getString(1));
         this.CreateXmlElement(doc, subRoot, this.SpecialityElement[3], this.SpecialityValue[3], rs.getString(2));
         this.CreateXmlElement(doc, subRoot, this.SpecialityElement[4], this.SpecialityValue[4], rs.getString(3));
      }

      return rootElement;
   }

   public String GetModuleData(String id) throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.ModuleElement[0], this.ModuleValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select m.id,m.modulename ,s.Specialityname , d.departementname from module m,Speciality s , departement d ,admin a where  m.Specialityid = s.id and  s.departementid =d.id and d.id=a.departementid and a.id=? order by Specialityname");
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element subRoot = this.CreateXmlElement(doc, rootElement, this.ModuleElement[1], this.ModuleValue[1], "");
         this.CreateXmlElement(doc, subRoot, this.ModuleElement[2], this.ModuleValue[2], rs.getString(1));
         this.CreateXmlElement(doc, subRoot, this.ModuleElement[3], this.ModuleValue[3], rs.getString(2));
         this.CreateXmlElement(doc, subRoot, this.ModuleElement[4], this.ModuleValue[4], rs.getString(3));
      }

      return this.XmlToString(doc, rootElement);
   }

   public String GetExamPaper(String id, String target) throws SQLException, TransformerException, ParserConfigurationException {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element oldexam = this.GetExamData(id, target);
      Node newexam = doc.importNode(oldexam, true);
      doc.appendChild(newexam);
      Element oldSections = this.GetSections(id);
      Node newSections = doc.importNode(oldSections, true);
      newexam.appendChild(newSections);
      return this.XmlToString(doc, oldexam);
   }

   public Element GetExamData(String id, String target) throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.ExamElements[0], this.ExamValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from exam where " + target + " = ?");
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element exam = this.CreateXmlElement(doc, rootElement, this.ExamElements[1], this.ExamValue[1], "");
         this.CreateXmlElement(doc, exam, this.ExamElements[2], this.ExamValue[2], rs.getString(1));
         this.CreateXmlElement(doc, exam, this.ExamElements[3], this.ExamValue[3], rs.getString(2));
         this.CreateXmlElement(doc, exam, this.ExamElements[4], this.ExamValue[4], rs.getString(3));
         this.CreateXmlElement(doc, exam, this.ExamElements[5], this.ExamValue[5], rs.getString(4));
         this.CreateXmlElement(doc, exam, this.ExamElements[6], this.ExamValue[6], rs.getString(5));
         this.CreateXmlElement(doc, exam, this.ExamElements[7], this.ExamValue[7], rs.getString(6));
         this.CreateXmlElement(doc, exam, this.ExamElements[8], this.ExamValue[8], rs.getString(7));
         this.CreateXmlElement(doc, exam, this.ExamElements[9], this.ExamValue[9], this.GetProf(rs.getString(8)));
         Element oldPermission = this.GetExamPermissionData(rs.getString(1));
         Node newPermission = doc.importNode(oldPermission, true);
         exam.appendChild(newPermission);
      }

      return rootElement;
   }

   public String GetPlanningData() throws SQLException, TransformerException, ParserConfigurationException {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.ExamElements[0], this.ExamValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from exam where id in (select Examid from planning )");
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element subRoot = this.CreateXmlElement(doc, rootElement, this.ExamElements[1], this.ExamValue[1], "");
         this.CreateXmlElement(doc, subRoot, this.ExamElements[2], this.ExamValue[2], rs.getString(1));
         this.CreateXmlElement(doc, subRoot, this.ExamElements[3], this.ExamValue[3], rs.getString(2));
         this.CreateXmlElement(doc, subRoot, this.ExamElements[4], this.ExamValue[4], rs.getString(3));
         this.CreateXmlElement(doc, subRoot, this.ExamElements[5], this.ExamValue[5], rs.getString(4));
         this.CreateXmlElement(doc, subRoot, this.ExamElements[6], this.ExamValue[6], rs.getString(5));
         this.CreateXmlElement(doc, subRoot, this.ExamElements[7], this.ExamValue[7], rs.getString(6));
         this.CreateXmlElement(doc, subRoot, this.ExamElements[8], this.ExamValue[8], rs.getString(7));
         this.CreateXmlElement(doc, subRoot, this.ExamElements[9], this.ExamValue[9], rs.getString(8));
      }

      return this.XmlToString(doc, rootElement);
   }

   public Element GetSections(String id) throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.SectionElements[0], this.SectionValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from section where examid= ?");
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element section = this.CreateXmlElement(doc, rootElement, this.SectionElements[1], this.SectionValue[1], "");
         this.CreateXmlElement(doc, section, this.SectionElements[2], this.SectionValue[2], rs.getString(1));
         this.CreateXmlElement(doc, section, this.SectionElements[3], this.SectionValue[3], rs.getString(2));
         this.CreateXmlElement(doc, section, this.SectionElements[4], this.SectionValue[4], rs.getString(3));
         Element oldQuestions = this.GetQuestionData(rs.getString(2), "sectionid");
         Node newQuestions = doc.importNode(oldQuestions, true);
         section.appendChild(newQuestions);
      }

      return rootElement;
   }

   public Element GetQuestionData(String objectid, String target) throws SQLException, ParserConfigurationException {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.QuestionElements[0], this.QuestionValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from question where " + target + "= ? ");
      ps.setString(1, objectid);
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element question = this.CreateXmlElement(doc, rootElement, this.OptionElements[1], this.QuestionValue[1], "");
         this.CreateXmlElement(doc, question, this.QuestionElements[2], this.QuestionValue[2], rs.getString(1));
         this.CreateXmlElement(doc, question, this.QuestionElements[3], this.QuestionValue[3], rs.getString(2));
         this.CreateXmlElement(doc, question, this.QuestionElements[4], this.QuestionValue[4], rs.getString(3));
         this.CreateXmlElement(doc, question, this.QuestionElements[5], this.QuestionValue[5], rs.getString(4));
         this.CreateXmlElement(doc, question, this.QuestionElements[6], this.QuestionValue[6], this.GetProf(rs.getString(5)));
         this.CreateXmlElement(doc, question, this.QuestionElements[7], this.QuestionValue[7], rs.getString(6));
         this.CreateXmlElement(doc, question, this.QuestionElements[8], this.QuestionValue[8], rs.getString(7));
         Element oldOption = this.GetOptionData(rs.getString(1));
         Node newOption = doc.importNode(oldOption, true);
         question.appendChild(newOption);
      }

      return rootElement;
   }

   public Element GetOptionData(String Questionid) throws SQLException, ParserConfigurationException {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.OptionElements[0], this.OptionValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from options where questionid= ?");
      ps.setString(1, Questionid);
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element section = this.CreateXmlElement(doc, rootElement, this.OptionElements[1], this.OptionValue[1], "");
         this.CreateXmlElement(doc, section, this.OptionElements[2], this.OptionValue[2], rs.getString(1));
         this.CreateXmlElement(doc, section, this.OptionElements[3], this.OptionValue[3], rs.getString(2));
         this.CreateXmlElement(doc, section, this.OptionElements[4], this.OptionValue[4], rs.getString(3));
         this.CreateXmlElement(doc, section, this.OptionElements[5], this.OptionValue[5], rs.getString(4));
      }

      return rootElement;
   }

   public Element GetExamPermissionData(String id) throws SQLException, TransformerConfigurationException, ParserConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.PermissionElements[0], this.PermissionValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from permissions where id in (select id from exam where id=?)");
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element subRoot = this.CreateXmlElement(doc, rootElement, this.PermissionElements[1], this.PermissionValue[1], "");
         this.CreateXmlElement(doc, subRoot, this.PermissionElements[2], this.PermissionValue[2], rs.getString(1));
         this.CreateXmlElement(doc, subRoot, this.PermissionElements[3], this.PermissionValue[3], rs.getString(2));
         this.CreateXmlElement(doc, subRoot, this.PermissionElements[4], this.PermissionValue[4], rs.getString(3));
      }

      return rootElement;
   }

   public String GetProf(String id) throws SQLException {
      PreparedStatement ps = this.con.prepareStatement("select userfname,userlname from prof where id =?");
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      String name;
      for(name = null; rs.next(); name = rs.getString(1) + " " + rs.getString(2)) {
      }

      return name;
   }

   public String GetNameDepartement(String id) throws SQLException {
      PreparedStatement ps = this.con.prepareStatement("select departementname from Departement where  id=?");
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      String str = null;
      if (rs.next()) {
         str = rs.getString(1);
      }

      return str;
   }

   public String GetCustomized(String column, String table, String condition, String id) throws SQLException {
      PreparedStatement ps = this.con.prepareStatement("select " + column + " from " + table + " where  " + condition + "=?");
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      String str = null;
      if (rs.next()) {
         str = rs.getString(1);
      }

      return str;
   }

   public String GetNearestExam() throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.Exams, "Exams");
      PreparedStatement ps = this.con.prepareStatement("select id from exam where DATEDIFF( now(),examdate )<=1 and datediff(now(),examdate)>=0 and timediff(current_time,examtime)<='00:30:00' and timediff(examtime,current_time)<='12:00:00'");
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element oldExam = this.GetExamData(rs.getString(1), "id");
         Node newExam = doc.importNode(oldExam, true);
         rootElement.appendChild(newExam);
      }

      return this.XmlToString(doc, rootElement);
   }

   public boolean DateCompare(String a) {
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
      LocalDateTime now = LocalDateTime.now();
      LocalDateTime date1 = LocalDateTime.parse(a, dtf);
      LocalDateTime date2 = LocalDateTime.parse(dtf.format(now), dtf);
      if (date1.isEqual(date2)) {
         return true;
      } else {
         return date1.isBefore(date2);
      }
   }

   public String GetExamDate(String id) throws SQLException {
      PreparedStatement ps = this.con.prepareStatement("select * from exam where id = ?");
      ps.setString(1, id);
      String date = null;
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
         date = rs.getString(3) + " " + rs.getString(4);
      }

      return date;
   }

   public String GetProfQuesion(String objectid) throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.QuestionElements[0], this.QuestionValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from question where profid= ? ");
      ps.setString(1, objectid);
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element question = this.CreateXmlElement(doc, rootElement, this.OptionElements[1], this.QuestionValue[1], "");
         this.CreateXmlElement(doc, question, this.QuestionElements[2], this.QuestionValue[2], rs.getString(1));
         this.CreateXmlElement(doc, question, this.QuestionElements[3], this.QuestionValue[3], rs.getString(2));
         this.CreateXmlElement(doc, question, this.QuestionElements[4], this.QuestionValue[4], rs.getString(3));
         this.CreateXmlElement(doc, question, this.QuestionElements[5], this.QuestionValue[5], rs.getString(4));
         this.CreateXmlElement(doc, question, this.QuestionElements[6], this.QuestionValue[6], this.GetProf(rs.getString(5)));
         this.CreateXmlElement(doc, question, this.QuestionElements[7], this.QuestionValue[7], rs.getString(6));
         this.CreateXmlElement(doc, question, this.QuestionElements[8], this.QuestionValue[8], rs.getString(7));
         Element oldOption = this.GetOptionData(rs.getString(1));
         Node newOption = doc.importNode(oldOption, true);
         question.appendChild(newOption);
      }

      return this.XmlToString(doc, rootElement);
   }

   public boolean setStudentData(User student) throws SQLException {
      PreparedStatement ps = this.con.prepareStatement("Insert into Student (userfname,userlname,useremail,userpassword,userdob,usersexe,studentid,universityid,facultyid,departementid,specialityid,levelid,groupid,id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
      ps.setString(1, student.getFirstName());
      ps.setString(2, student.getLastName());
      ps.setString(3, student.getEmail());
      ps.setString(4, student.getPassWord());
      ps.setString(5, student.getDateOfBirth());
      ps.setString(6, student.getSexe());
      ps.setString(7, student.getStudentId());
      ps.setString(8, student.getUniversity());
      ps.setString(9, student.getFaculte());
      ps.setString(10, student.getDepartement());
      ps.setString(11, student.getSpeciality());
      ps.setString(12, student.getLevel());
      ps.setString(13, student.getGroupId());
      ps.setString(14, student.getId());
      int rs = ps.executeUpdate();
      if (rs == 1) {
         this.update = true;
      }

      return this.update;
   }

   public boolean setProfData(User prof) throws SQLException {
      PreparedStatement ps = this.con.prepareStatement("insert into prof (userfname,userlname,useremail,userpassword,userdob,usersexe,universityid,id) values (?,?,?,?,?,?,?,?)");
      ps.setString(1, prof.getFirstName());
      ps.setString(2, prof.getLastName());
      ps.setString(3, prof.getEmail());
      ps.setString(4, prof.getPassWord());
      ps.setString(5, prof.getDateOfBirth());
      ps.setString(6, prof.getSexe());
      ps.setString(7, prof.getUniversity());
      ps.setString(8, prof.getId());
      int rs = ps.executeUpdate();
      if (rs == 1) {
         this.update = true;
      }

      return this.update;
   }

   public boolean setAdminData(User admin) throws SQLException {
      PreparedStatement ps = this.con.prepareStatement(" insert into admin (userfname,userlname,useremail,userpassword,userdob,usersexe,facultyid,universityid,departementid,id)values (?,?,?,?,?,?,?,?,?,?)");
      ps.setString(1, admin.getFirstName());
      ps.setString(2, admin.getLastName());
      ps.setString(3, admin.getEmail());
      ps.setString(4, admin.getPassWord());
      ps.setString(5, admin.getDateOfBirth());
      ps.setString(6, admin.getSexe());
      ps.setString(7, admin.getUniversity());
      ps.setString(8, admin.getFaculte());
      ps.setString(9, admin.getDepartement());
      ps.setString(10, admin.getId());
      int rs = ps.executeUpdate();
      if (rs == 1) {
         this.update = true;
      }

      return this.update;
   }

   public String GetStudentData(String id) throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.StudentElements[0], this.StudentValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from student where id=?");
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element section = this.CreateXmlElement(doc, rootElement, this.StudentElements[1], this.StudentValue[1], "");
         this.CreateXmlElement(doc, section, this.StudentElements[2], this.StudentValue[2], rs.getString(1));
         this.CreateXmlElement(doc, section, this.StudentElements[3], this.StudentValue[3], rs.getString(2));
         this.CreateXmlElement(doc, section, this.StudentElements[4], this.StudentValue[4], rs.getString(3));
         this.CreateXmlElement(doc, section, this.StudentElements[5], this.StudentValue[5], rs.getString(4));
         this.CreateXmlElement(doc, section, this.StudentElements[6], this.StudentValue[6], rs.getString(5));
         this.CreateXmlElement(doc, section, this.StudentElements[7], this.StudentValue[7], rs.getString(6));
         this.CreateXmlElement(doc, section, this.StudentElements[8], this.StudentValue[8], rs.getString(7));
         this.CreateXmlElement(doc, section, this.StudentElements[9], this.StudentValue[9], rs.getString(8));
         this.CreateXmlElement(doc, section, this.StudentElements[10], this.StudentValue[10], rs.getString(9));
         this.CreateXmlElement(doc, section, this.StudentElements[11], this.StudentValue[11], rs.getString(10));
         this.CreateXmlElement(doc, section, this.StudentElements[12], this.StudentValue[12], rs.getString(11));
         this.CreateXmlElement(doc, section, this.StudentElements[13], this.StudentValue[13], rs.getString(12));
         this.CreateXmlElement(doc, section, this.StudentElements[14], this.StudentValue[14], rs.getString(13));
         this.CreateXmlElement(doc, section, this.StudentElements[15], this.StudentValue[15], rs.getString(14));
         this.CreateXmlElement(doc, section, this.StudentElements[16], this.StudentValue[16], rs.getString(15));
         this.CreateXmlElement(doc, section, this.StudentElements[17], this.StudentValue[17], rs.getString(16));
      }

      return this.XmlToString(doc, rootElement);
   }

   public String GetProfData(String id) throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.ProfElements[0], this.ProfValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from prof where id=?");
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element section = this.CreateXmlElement(doc, rootElement, this.ProfElements[1], this.ProfValue[1], "");
         this.CreateXmlElement(doc, section, this.ProfElements[2], this.ProfValue[2], rs.getString(1));
         this.CreateXmlElement(doc, section, this.ProfElements[3], this.ProfValue[3], rs.getString(2));
         this.CreateXmlElement(doc, section, this.ProfElements[4], this.ProfValue[4], rs.getString(3));
         this.CreateXmlElement(doc, section, this.ProfElements[5], this.ProfValue[5], rs.getString(4));
         this.CreateXmlElement(doc, section, this.ProfElements[6], this.ProfValue[6], rs.getString(5));
         this.CreateXmlElement(doc, section, this.ProfElements[7], this.ProfValue[7], rs.getString(6));
         this.CreateXmlElement(doc, section, this.ProfElements[8], this.ProfValue[8], rs.getString(7));
         this.CreateXmlElement(doc, section, this.ProfElements[9], this.ProfValue[9], rs.getString(8));
         this.CreateXmlElement(doc, section, this.ProfElements[10], this.ProfValue[10], rs.getString(9));
         this.CreateXmlElement(doc, section, this.ProfElements[11], this.ProfValue[11], rs.getString(10));
      }

      return this.XmlToString(doc, rootElement);
   }

   public String GetAdminData(String id) throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.ProfElements[0], this.ProfValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from Prof where id=?");
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element section = this.CreateXmlElement(doc, rootElement, this.ProfElements[1], this.ProfValue[1], "");
         this.CreateXmlElement(doc, section, this.ProfElements[2], this.ProfValue[2], rs.getString(1));
         this.CreateXmlElement(doc, section, this.ProfElements[3], this.ProfValue[3], rs.getString(2));
         this.CreateXmlElement(doc, section, this.ProfElements[4], this.ProfValue[4], rs.getString(3));
         this.CreateXmlElement(doc, section, this.ProfElements[5], this.ProfValue[5], rs.getString(4));
         this.CreateXmlElement(doc, section, this.ProfElements[6], this.ProfValue[6], rs.getString(5));
         this.CreateXmlElement(doc, section, this.ProfElements[7], this.ProfValue[7], rs.getString(6));
         this.CreateXmlElement(doc, section, this.ProfElements[8], this.ProfValue[8], rs.getString(7));
         this.CreateXmlElement(doc, section, this.ProfElements[9], this.ProfValue[9], rs.getString(8));
         this.CreateXmlElement(doc, section, this.ProfElements[10], this.ProfValue[10], rs.getString(9));
         this.CreateXmlElement(doc, section, this.ProfElements[11], this.ProfValue[11], rs.getString(10));
         this.CreateXmlElement(doc, section, this.ProfElements[12], this.ProfValue[12], rs.getString(11));
      }

      return this.XmlToString(doc, rootElement);
   }

   public String GetTrueStudent() throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.StudentElements[0], this.StudentValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from student where checked=1 and active=1");
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element section = this.CreateXmlElement(doc, rootElement, this.StudentElements[1], this.StudentValue[1], "");
         this.CreateXmlElement(doc, section, this.StudentElements[2], this.StudentValue[2], rs.getString(1));
         this.CreateXmlElement(doc, section, this.StudentElements[3], this.StudentValue[3], rs.getString(2));
         this.CreateXmlElement(doc, section, this.StudentElements[4], this.StudentValue[4], rs.getString(3));
         this.CreateXmlElement(doc, section, this.StudentElements[5], this.StudentValue[5], rs.getString(4));
         this.CreateXmlElement(doc, section, this.StudentElements[6], this.StudentValue[6], rs.getString(5));
         this.CreateXmlElement(doc, section, this.StudentElements[7], this.StudentValue[7], rs.getString(6));
         this.CreateXmlElement(doc, section, this.StudentElements[8], this.StudentValue[8], rs.getString(7));
         this.CreateXmlElement(doc, section, this.StudentElements[9], this.StudentValue[9], rs.getString(8));
         this.CreateXmlElement(doc, section, this.StudentElements[10], this.StudentValue[10], rs.getString(9));
         this.CreateXmlElement(doc, section, this.StudentElements[11], this.StudentValue[11], rs.getString(10));
         this.CreateXmlElement(doc, section, this.StudentElements[12], this.StudentValue[12], rs.getString(11));
         this.CreateXmlElement(doc, section, this.StudentElements[13], this.StudentValue[13], rs.getString(12));
         this.CreateXmlElement(doc, section, this.StudentElements[14], this.StudentValue[14], rs.getString(13));
         this.CreateXmlElement(doc, section, this.StudentElements[15], this.StudentValue[15], rs.getString(14));
         this.CreateXmlElement(doc, section, this.StudentElements[16], this.StudentValue[16], rs.getString(15));
         this.CreateXmlElement(doc, section, this.StudentElements[17], this.StudentValue[17], rs.getString(16));
      }

      return this.XmlToString(doc, rootElement);
   }

   public String GetTrueProf() throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.ProfElements[0], this.ProfValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from prof where checked=1 and active=1");
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element section = this.CreateXmlElement(doc, rootElement, this.ProfElements[1], this.ProfValue[1], "");
         this.CreateXmlElement(doc, section, this.ProfElements[2], this.ProfValue[2], rs.getString(1));
         this.CreateXmlElement(doc, section, this.ProfElements[3], this.ProfValue[3], rs.getString(2));
         this.CreateXmlElement(doc, section, this.ProfElements[4], this.ProfValue[4], rs.getString(3));
         this.CreateXmlElement(doc, section, this.ProfElements[5], this.ProfValue[5], rs.getString(4));
         this.CreateXmlElement(doc, section, this.ProfElements[6], this.ProfValue[6], rs.getString(5));
         this.CreateXmlElement(doc, section, this.ProfElements[7], this.ProfValue[7], rs.getString(6));
         this.CreateXmlElement(doc, section, this.ProfElements[8], this.ProfValue[8], rs.getString(7));
         this.CreateXmlElement(doc, section, this.ProfElements[9], this.ProfValue[9], rs.getString(8));
         this.CreateXmlElement(doc, section, this.ProfElements[10], this.ProfValue[10], rs.getString(9));
         this.CreateXmlElement(doc, section, this.ProfElements[11], this.ProfValue[11], rs.getString(10));
         this.CreateXmlElement(doc, section, this.ProfElements[12], this.ProfValue[12], rs.getString(11));
      }

      return this.XmlToString(doc, rootElement);
   }

   public String GetTrueAdmin() throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.AdminElements[0], this.AdminValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from admin where checked=1 and active=1");
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element section = this.CreateXmlElement(doc, rootElement, this.AdminElements[1], this.AdminValue[1], "");
         this.CreateXmlElement(doc, section, this.AdminElements[2], this.AdminValue[2], rs.getString(1));
         this.CreateXmlElement(doc, section, this.AdminElements[3], this.AdminValue[3], rs.getString(2));
         this.CreateXmlElement(doc, section, this.AdminElements[4], this.AdminValue[4], rs.getString(3));
         this.CreateXmlElement(doc, section, this.AdminElements[5], this.AdminValue[5], rs.getString(4));
         this.CreateXmlElement(doc, section, this.AdminElements[6], this.AdminValue[6], rs.getString(5));
         this.CreateXmlElement(doc, section, this.AdminElements[7], this.AdminValue[7], rs.getString(6));
         this.CreateXmlElement(doc, section, this.AdminElements[8], this.AdminValue[8], rs.getString(7));
         this.CreateXmlElement(doc, section, this.AdminElements[9], this.AdminValue[9], rs.getString(8));
         this.CreateXmlElement(doc, section, this.AdminElements[10], this.AdminValue[10], rs.getString(9));
         this.CreateXmlElement(doc, section, this.AdminElements[11], this.AdminValue[11], rs.getString(10));
         this.CreateXmlElement(doc, section, this.AdminElements[12], this.AdminValue[12], rs.getString(11));
         this.CreateXmlElement(doc, section, this.AdminElements[13], this.AdminValue[13], rs.getString(12));
      }

      return this.XmlToString(doc, rootElement);
   }

   public String GetStudentbyGroup(String id) throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.StudentElements[0], this.StudentValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from student where groupid=?");
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element section = this.CreateXmlElement(doc, rootElement, this.StudentElements[1], this.StudentValue[1], "");
         this.CreateXmlElement(doc, section, this.StudentElements[2], this.StudentValue[2], rs.getString(1));
         this.CreateXmlElement(doc, section, this.StudentElements[3], this.StudentValue[3], rs.getString(2));
         this.CreateXmlElement(doc, section, this.StudentElements[4], this.StudentValue[4], rs.getString(3));
         this.CreateXmlElement(doc, section, this.StudentElements[5], this.StudentValue[5], rs.getString(4));
         this.CreateXmlElement(doc, section, this.StudentElements[6], this.StudentValue[6], rs.getString(5));
         this.CreateXmlElement(doc, section, this.StudentElements[7], this.StudentValue[7], rs.getString(6));
         this.CreateXmlElement(doc, section, this.StudentElements[8], this.StudentValue[8], rs.getString(7));
         this.CreateXmlElement(doc, section, this.StudentElements[9], this.StudentValue[9], rs.getString(8));
         this.CreateXmlElement(doc, section, this.StudentElements[10], this.StudentValue[10], rs.getString(9));
         this.CreateXmlElement(doc, section, this.StudentElements[11], this.StudentValue[11], rs.getString(10));
         this.CreateXmlElement(doc, section, this.StudentElements[12], this.StudentValue[12], rs.getString(11));
         this.CreateXmlElement(doc, section, this.StudentElements[13], this.StudentValue[13], rs.getString(12));
         this.CreateXmlElement(doc, section, this.StudentElements[14], this.StudentValue[14], rs.getString(13));
         this.CreateXmlElement(doc, section, this.StudentElements[15], this.StudentValue[15], rs.getString(14));
         this.CreateXmlElement(doc, section, this.StudentElements[16], this.StudentValue[16], rs.getString(15));
         this.CreateXmlElement(doc, section, this.StudentElements[17], this.StudentValue[17], rs.getString(16));
      }

      return this.XmlToString(doc, rootElement);
   }

   public String GetNotCheckedProf() throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.ProfElements[0], this.ProfValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from prof where  active=1 and checked=0");
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element section = this.CreateXmlElement(doc, rootElement, this.ProfElements[1], this.ProfValue[1], "");
         this.CreateXmlElement(doc, section, this.ProfElements[2], this.ProfValue[2], rs.getString(1));
         this.CreateXmlElement(doc, section, this.ProfElements[3], this.ProfValue[3], rs.getString(2));
         this.CreateXmlElement(doc, section, this.ProfElements[4], this.ProfValue[4], rs.getString(3));
         this.CreateXmlElement(doc, section, this.ProfElements[5], this.ProfValue[5], rs.getString(4));
         this.CreateXmlElement(doc, section, this.ProfElements[6], this.ProfValue[6], rs.getString(5));
         this.CreateXmlElement(doc, section, this.ProfElements[7], this.ProfValue[7], rs.getString(6));
         this.CreateXmlElement(doc, section, this.ProfElements[8], this.ProfValue[8], rs.getString(7));
         this.CreateXmlElement(doc, section, this.ProfElements[9], this.ProfValue[9], rs.getString(8));
         this.CreateXmlElement(doc, section, this.ProfElements[10], this.ProfValue[10], rs.getString(9));
         this.CreateXmlElement(doc, section, this.ProfElements[11], this.ProfValue[11], rs.getString(10));
         this.CreateXmlElement(doc, section, this.ProfElements[12], this.ProfValue[12], rs.getString(11));
      }

      return this.XmlToString(doc, rootElement);
   }

   public String GetNotCheckedAdmin() throws SQLException, ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      Element rootElement = this.CreateXmlRoot(doc, this.AdminElements[0], this.AdminValue[0]);
      PreparedStatement ps = this.con.prepareStatement("select * from admin where checked=0 and active=1");
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         Element section = this.CreateXmlElement(doc, rootElement, this.AdminElements[1], this.AdminValue[1], "");
         this.CreateXmlElement(doc, section, this.AdminElements[2], this.AdminValue[2], rs.getString(1));
         this.CreateXmlElement(doc, section, this.AdminElements[3], this.AdminValue[3], rs.getString(2));
         this.CreateXmlElement(doc, section, this.AdminElements[4], this.AdminValue[4], rs.getString(3));
         this.CreateXmlElement(doc, section, this.AdminElements[5], this.AdminValue[5], rs.getString(4));
         this.CreateXmlElement(doc, section, this.AdminElements[6], this.AdminValue[6], rs.getString(5));
         this.CreateXmlElement(doc, section, this.AdminElements[7], this.AdminValue[7], rs.getString(6));
         this.CreateXmlElement(doc, section, this.AdminElements[8], this.AdminValue[8], rs.getString(7));
         this.CreateXmlElement(doc, section, this.AdminElements[9], this.AdminValue[9], rs.getString(8));
         this.CreateXmlElement(doc, section, this.AdminElements[10], this.AdminValue[10], rs.getString(9));
         this.CreateXmlElement(doc, section, this.AdminElements[11], this.AdminValue[11], rs.getString(10));
         this.CreateXmlElement(doc, section, this.AdminElements[12], this.AdminValue[12], rs.getString(11));
         this.CreateXmlElement(doc, section, this.AdminElements[13], this.AdminValue[13], rs.getString(12));
      }

      return this.XmlToString(doc, rootElement);
   }

   public boolean updateData(User user, String target) throws SQLException {
      switch(target.hashCode()) {
      case -214492645:
         if (target.equals("Student")) {
            PreparedStatement ps = this.con.prepareStatement("update  student  set userfname =?,userlname=?,useremail=?,userpassword=? userdob=?,usersexe=?,studentid=?,facultyid=?,universityid=?,departementid=?,specialityid=?,groupid=?,levelid=?");
            ps.setString(1, this.student.getFirstName());
            ps.setString(2, this.student.getLastName());
            ps.setString(3, this.student.getEmail());
            ps.setString(4, this.student.getPassWord());
            ps.setString(5, this.student.getDateOfBirth());
            ps.setString(6, this.student.getSexe());
            ps.setString(8, this.student.getStudentId());
            ps.setString(11, this.student.getFaculte());
            ps.setString(7, this.student.getDepartement());
            ps.setString(10, this.student.getUniversity());
            ps.setString(10, this.student.getSpeciality());
            ps.setString(9, this.student.getGroupId());
            ps.setString(12, this.student.getLevel());
            int rs = ps.executeUpdate();
            if (rs == 1) {
               this.update = true;
            }
         }
         break;
      case 2496377:
         if (target.equals("Prof")) {
            PreparedStatement ps2 = this.con.prepareStatement("update  Prof  set userfname =?,userlname=?,useremail=?,userpassword=?,userdob=?,usersexe=?,facultyid=?,universityid=?");
            ps2.setString(1, this.prof.getFirstName());
            ps2.setString(2, this.prof.getLastName());
            ps2.setString(3, this.prof.getEmail());
            ps2.setString(4, this.prof.getPassWord());
            ps2.setString(5, this.prof.getDateOfBirth());
            ps2.setString(6, this.prof.getSexe());
            ps2.setString(11, this.prof.getFaculte());
            ps2.setString(10, this.prof.getUniversity());
            int rs2 = ps2.executeUpdate();
            if (rs2 == 1) {
               this.update = true;
            }
         }
         break;
      case 63116079:
         if (target.equals("Admin")) {
            PreparedStatement ps3 = this.con.prepareStatement("update  admin  set userfname =?,userlname=?,useremail=?,userpassword=?,userdob=?,usersexe=?,facultyid=?,universityid=?,departementid=?");
            ps3.setString(1, this.admin.getFirstName());
            ps3.setString(2, this.admin.getLastName());
            ps3.setString(3, this.admin.getEmail());
            ps3.setString(4, this.admin.getPassWord());
            ps3.setString(5, this.admin.getDateOfBirth());
            ps3.setString(6, this.admin.getSexe());
            ps3.setString(7, this.admin.getUniversity());
            ps3.setString(11, this.admin.getFaculte());
            ps3.setString(8, this.admin.getDepartement());
            int rs3 = ps3.executeUpdate();
            if (rs3 == 1) {
               this.update = true;
            }
         }
      }

      return this.update;
   }

   public int GetStatsProf(String id, String target) throws SQLException {
      PreparedStatement ps = this.con.prepareStatement("select count(id) as totalExam from " + target + " where profid =?");
      ps.setString(1, id);
      int result = 0;

      for(ResultSet rs = ps.executeQuery(); rs.next(); result = rs.getInt(1)) {
      }

      return result;
   }

   public int GetStatsAdmin(String id, String target, String clause) throws SQLException {
      PreparedStatement ps = this.con.prepareStatement("select count(id) as totalExam from " + target + " where " + clause + "=?");
      ps.setString(1, id);
      int result = 0;

      for(ResultSet rs = ps.executeQuery(); rs.next(); result = rs.getInt(1)) {
      }

      return result;
   }

   public int GetStatsAdmin2(String id, String target) throws SQLException {
      PreparedStatement ps = this.con.prepareStatement("select count(x.id) as totalExam from " + target + " x , speciality s where  x.specialityid = s.id and s.departementid = ?");
      ps.setString(1, id);
      int result = 0;

      for(ResultSet rs = ps.executeQuery(); rs.next(); result = rs.getInt(1)) {
      }

      return result;
   }

   public List<String> GetNotification(String id, String target) throws SQLException {
      List<String> list = new ArrayList();
      PreparedStatement ps = this.con.prepareStatement("select text from notification" + target + " where " + target + "id=? order by id desc");
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
         list.add(rs.getString(1));
      }

      return list;
   }

   public boolean deleteData(String Id, String target) throws SQLException {
      PreparedStatement ps = this.con.prepareStatement("delete from " + target + " where id=?");
      ps.setString(1, Id);
      int rs = ps.executeUpdate();
      if (rs == 1) {
         this.update = true;
      }

      return this.update;
   }

   public boolean ifActivate(String Email, String target) throws SQLException {
      this.update = false;
      PreparedStatement ps = this.con.prepareStatement("select * from " + target + " where useremail=? and active=?");
      ps.setString(1, Email);
      ps.setInt(2, 1);
      ResultSet rs = ps.executeQuery();
      this.update = rs.next();
      return this.update;
   }
   public int SaveMark(float mark,String stdid,String examid) throws SQLException {
	      update = false;
	      PreparedStatement ps = this.con.prepareStatement("insert into marks (mark,studentid,examid) values(?,?,?)");
	      ps.setFloat(1, mark);
	      ps.setString(2,stdid);
	      ps.setString(3,examid);
	      int rs = ps.executeUpdate();
	      return rs;
	   }

   public void StoreExamPaper(String text, String student, String exam) throws SQLException {
      PreparedStatement pstmt = this.con.prepareStatement("insert into exampaper (paper,studentid,examid) values (?,?,?)");
      pstmt.setString(1, text);
      pstmt.setString(2, student);
      pstmt.setString(3, exam);
      pstmt.executeUpdate();
   }

   public Element CreateXmlElement(Document doc, Element parentElement, Element Element, String Text, String Value) throws ParserConfigurationException {
      Element = doc.createElement(Text);
      if (Value == null) {
         Element.appendChild(doc.createTextNode(""));
      } else {
         Element.appendChild(doc.createTextNode(Value));
      }

      parentElement.appendChild(Element);
      return Element;
   }

   public Element CreateXmlRoot(Document doc, Element Element, String Text) throws ParserConfigurationException {
      Element = doc.createElement(Text);
      doc.appendChild(Element);
      return Element;
   }

   public String XmlToString(Document doc, Element rootElement) throws ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
      StringWriter writer = new StringWriter();
      TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(writer));
      String xmlString = writer.getBuffer().toString();
      return xmlString;
   }

   public Document StringToXml(String xmlString) throws ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError, SAXException, IOException {
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xmlString)));
      return doc;
   }

   public void StringToFile(Document doc, Element rootElement) throws ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError, SAXException, IOException {
      TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(new File("C:\\Users\\DELL\\eclipse-workspace\\ExamPro\\src\\main\\webapp\\Library\\faculty.xml")));
   }
}
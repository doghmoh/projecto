/* Decompiler 15ms, total 982ms, lines 158 */
package Model;

public class ExamCreation {
   private String ExamId;
   private String ExamName;
   private String ExamDate;
   private String ExamTime;
   private String ExamType;
   private String ExamDuration;
   private String ExamTarget;
   private String ExamPermission;
   private String QuestionId;
   private String QuestionText;
   private String QuestionNbr;
   private String QuestionMark;
   private String QuestionResponse;
   private String QuestionType;
   private String OptionText;
   private boolean HasImg;
   private boolean IfChecked;

   public void SetExamId(String ExamId) {
      this.ExamId = ExamId;
   }

   public String GetExamId() {
      return this.ExamId;
   }

   public String GetExamName() {
      return this.ExamName;
   }

   public void SetExamName(String examname) {
      this.ExamName = examname;
   }

   public String GetExamDate() {
      return this.ExamDate;
   }

   public void SetExamDate(String examdate) {
      this.ExamDate = examdate;
   }

   public String GetExamType() {
      return this.ExamType;
   }

   public void SetExamType(String ExamType) {
      this.ExamType = ExamType;
   }

   public String GetExamTime() {
      return this.ExamTime;
   }

   public void SetExamTime(String examtime) {
      this.ExamTime = examtime;
   }

   public String GetExamDuration() {
      return this.ExamDuration;
   }

   public void SetExamDuration(String examduration) {
      this.ExamDuration = examduration;
   }

   public String GetExamTarget() {
      return this.ExamTarget;
   }

   public void SetExamTarget(String examtarget) {
      this.ExamTarget = examtarget;
   }

   public String GetExamPermission() {
      return this.ExamPermission;
   }

   public void SetExamPermission(String exampermission) {
      this.ExamName = exampermission;
   }

   public String GetQuestionId() {
      return this.QuestionId;
   }

   public void SetQuestionId(String QuestionId) {
      this.QuestionId = QuestionId;
   }

   public String GetQuestionText() {
      return this.QuestionText;
   }

   public void SetQuestionText(String questiontext) {
      this.QuestionText = questiontext;
   }

   public String GetQuestionType() {
      return this.QuestionType;
   }

   public void SetQuestionType(String questiontype) {
      this.QuestionType = questiontype;
   }

   public String GetQuestionNbr() {
      return this.QuestionNbr;
   }

   public void SetQuestionNbr(String questionnbr) {
      this.QuestionNbr = questionnbr;
   }

   public String GetQuestionMark() {
      return this.QuestionMark;
   }

   public void SetQuestionMark(String questionmark) {
      this.QuestionMark = questionmark;
   }

   public String GetQuestionRespone() {
      return this.QuestionResponse;
   }

   public void SetQuestionResponse(String questionresponse) {
      this.QuestionResponse = questionresponse;
   }

   public boolean GetHasImg() {
      return this.HasImg;
   }

   public void SetHasImg(boolean hasimg) {
      this.HasImg = hasimg;
   }

   public void SetOptionText(String text) {
      this.OptionText = text;
   }

   public String GetOptionText() {
      return this.OptionText;
   }

   public void SetIfChecked(boolean text) {
      this.IfChecked = text;
   }

   public boolean GetIfChecked() {
      return this.IfChecked;
   }
}
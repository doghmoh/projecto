<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/fontawesome-free-6.1.1-web/css/all.min.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/FamilyPoppins.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/001/AdminHome.css">
<link rel="stylesheet" href="<%= request.getContextPath()%>/003/PassExam.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Nav&Side.css">
<title>Pass an Exam</title>
</head>
<body class="container">
  
    

    <!-- Call NabBar Component -->
    <%@ include file = "./NavBarStudent.jsp" %>
    
     <!--  Parse Xml String  -->
    <x:parse xml ="${Question}" var ="output"/>
	 				
	<div class="bigone" id="bigoneid"> 
	   <div id="ClockDiv"></div> 
		<div class="QuestonsForm  bg-info">
			     <div class="quiz_box">
			       <header>
			          <div class="title"><span id="examid" hidden=""><x:out select = "$output/Exams/Exam/Id" /></span>
			          <x:out select = "$output/Exams/Exam/Module" /></div>
			            <div class="date_time timer text-center" style="width:410px">
							<div class="time_left_txt col">Today <label id="today"></label></div><br>
							<div class="time_left_txt col">Time <label id="currentTime"></label></div>
						</div>
			            <div class="time_line"></div>
			        </header>
			        <section>
			        <% int i =0; %>
			        <x:forEach select = "$output/Exams/Sections/Section" var ="item">
			            <div class="que_text" id="<%= i++ %>"><h2><x:out select = "Text" /></h2></div>
			            <hr>
			            <x:forEach select = "Questions/Question" var ="item2">
			            <input type="text" name="question" value="<x:out select = "Id" />" hidden="">
			            <c:set var="QType">
					    <x:out select="Type"/>
						</c:set>
			            <div class="que_text"><x:out select = "Text" /></div>
			            <div class="option_list">
			            <c:if test="${QType=='QRL-Question a Reponse Libre'}">
						 <textarea name="text" placeholder="Write your answer here."></textarea>
					    </c:if>
			             <x:forEach select = "Options/Option" var ="item3">
		                <div class="option" onclick="checker(event)">
			               <input type="text" name="option" value="<x:out select = "Id" />" hidden="">
			               <input type="checkbox" name="checkbox"> 
					       <label class="form-check-label" style="left:0;pointer-events: none;"><x:out select = "Text" /> </label>
				        </div>
				        </x:forEach><hr>
			            </div>
			            </x:forEach>
			            </x:forEach>
			        </section>
    			</div><br>
    			<div class="text-center">
				<input class="btn btn-primary" type="submit" id="submitbtn"> 
				<input class="btn btn-primary" type="file" id="ffile" hidden> 
				<input class="btn btn-primary" id="SendDocument" type="button" value="Send Document" >
			</div>
	  </div>
               </div>
	
    <script src="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
    <script src="<%= request.getContextPath()%>/Library/checkbox2button.min.js"></script>
    <script src="<%= request.getContextPath()%>/Library/jquery.min.js"></script>
    <script src="<%= request.getContextPath()%>/Nav&Side.js"></script>
	<script src="<%= request.getContextPath()%>/003/PassExam.js"></script>
	
</body>
</html>
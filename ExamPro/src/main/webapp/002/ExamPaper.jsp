<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@page import="java.util.List"%>
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
<style>
textarea{
    width: 100%;height: 150px;
    padding: 12px 20px;box-sizing: border-box;
	border: 1px solid dodgerblue;border-radius: 4px;
  	background-color: #f8f8f8;font-size: 16px;resize: none; }
textarea{outline-color: dodgerblue;}
</style>
<body>


    <!-- Call NabBar Component -->
    <% // include file = "./NavBarStudent.jsp" %>
    
     <!--  Parse Xml String  -->
    <x:parse xml="${Question}" var="output" />   
	<div class="bigone" id="bigoneid"> 
		<form class="QuestonsForm  bg-info">
			     <div class="quiz_box">
			        <section>
			        <x:forEach select = "$output/Exams/Sections/Section" var ="item">
			            <div class="que_text"><h2><x:out select = "Text" /></h2></div>
			            <hr>
			            <x:forEach select = "Questions/Question" var ="item">
			            <c:set var="QType">
								 <x:out select="Type" />
						</c:set>
			            <div class="que_text"><x:out select = "Text" /> </div>
			            <div class="option_list">
			             <c:if test="${QType == 'QRL-Question a Reponse Libre' }">
						 <textarea ></textarea>
						 </c:if>
			             <x:forEach select = "Options/Option" var ="item">
				             <c:set var="ischeked">
								 <x:out select="IsChecked" />
						     </c:set>
						    <c:choose>
							<c:when test="${ischeked == 0}">
							<div class="option" onclick="checker(event)">
					               <input type="checkbox" name="checkbox1"> 
							       <label class="form-check-label" style="left:0;pointer-events: none;"><x:out select = "Text" /> </label>
						       </div>
							</c:when>
							<c:otherwise>
							<div class="option" onclick="checker(event)">
					               <input type="checkbox" name="checkbox1"> 
							       <label class="form-check-label" style="left:0;pointer-events: none;"><x:out select = "Text" /> </label>
						    </div>
							</c:otherwise>
							</c:choose>
			            </x:forEach><hr>
			            </div>
			            </x:forEach>
	            </x:forEach>
	        </section>
    			</div><br>
    			<div class="text-center">
				<input class="btn btn-primary" type="submit"> 
				<input class="btn btn-primary" type="file" id="ffile" hidden> 
				<input class="btn btn-primary" id="SendDocument" type="button" value="Send Document" >
			</div>
	  </form>
               </div>
	
    <script src="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
    <script src="<%= request.getContextPath()%>/Library/checkbox2button.min.js"></script>
    <script src="<%= request.getContextPath()%>/Library/jquery.min.js"></script>
    <script src="<%= request.getContextPath()%>/Nav&Side.js"></script>
	<script src="<%= request.getContextPath()%>/003/PassExam.js"></script>
	

</body>
</html>
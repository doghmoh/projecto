<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <link rel="stylesheet" href="<%= request.getContextPath()%>/001/ManageAccount.css">
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
    <%@include file ="/002/NavBarProf.jsp" %>
    <%@include file ="/002/SideBarProf.jsp" %>
    
     <!--  Parse Xml String  -->
    <x:parse xml="${Question}" var="output" />  
    <section class="GlobalSection  bg-light"> 
	<div class="bigone" id="bigoneid" style="pointer-events:none">
		<div class="QuestonsForm  bg-info">
			     <div class="quiz_box">
			        <section><% int i =0; %>
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
						 <c:if test="${QType == 'QCU-Question a Choix Unique' }">
						  <c:set var="type" value="radio"></c:set><c:set var="name" value="radio"></c:set>
						 </c:if>
						 <c:if test="${QType == 'QCM-Question a Choix Multiple' }">
						 <c:set var="type" value="checkbox"></c:set><c:set var="name" value="checkbox"></c:set>
						 </c:if>
			             <x:forEach select = "Options/Option" var ="item">
				             <c:set var="ischeked">
								 <x:out select="IsChecked" />
						     </c:set>
						     <c:choose>
							<c:when test="${ischeked == 0}"><c:set var="color" value="bg-danger" ></c:set><c:set var="checked" value="" ></c:set></c:when>
							<c:otherwise><c:set var="color" value="bg-success" ></c:set><c:set var="checked" value="checked" ></c:set></c:otherwise>
							</c:choose>
							<div class="option  <c:out value="${color}" />" onclick="checker(event)">
					               <input type='<c:out value="${type}"></c:out>' name="${name}<%= i%>" ${checked}> 
							       <label class="form-check-label" style="left:0;pointer-events: none;"><x:out select = "Text" /> </label>
						       </div>
			            </x:forEach><hr><% i++;%>
			            </div>
			            </x:forEach>
	            </x:forEach>
	        </section>
    	</div>
	</div>
</div>
</section>
    <script src="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
    <script src="<%= request.getContextPath()%>/Library/checkbox2button.min.js"></script>
    <script src="<%= request.getContextPath()%>/Library/jquery.min.js"></script>
    <script src="<%= request.getContextPath()%>/Nav&Side.js"></script>
	<script src="<%= request.getContextPath()%>/003/PassExam.js"></script>
	

</body>
</html>
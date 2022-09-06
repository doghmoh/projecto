<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/fontawesome-free-6.1.1-web/css/all.min.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/FamilyPoppins.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Nav&Side.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Alert.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/001/ManageAccount.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/jquery.datatable.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/dataTable.bootstrap5.min.css">  
</head>
<body>
<x:parse xml ="${Exam}" var ="output"/>
<!-- Call NabBar Component -->
    <%@ include file = "./NavBarStudent.jsp" %>
    <!-- Call SideBar Component -->
    <%@ include file = "./SideBarStudent.jsp" %>
    
    <section class="GlobalSection  bg-light">
          <h1 class="text-center mt-5" style="    font-size: 25px !important;font-weight: 900;">Exam Planning</h1><br>
           <table id="example" class="table table-striped pt-3" style="width:100%">
            <thead>
                <tr class="table-success">
                   <th scope="col">Exam ID</th>
                   <th scope="col">Exam Name</th>
                   <th scope="col">Exam Date</th>
                   <th scope="col">Exam Time</th>
                   <th scope="col">Exam Duration</th>
                   <th scope="col">Exam Type</th>
                   <th scope="col">Exam Target</th>
                   <th scope="col">Exam ProfID</th>
               </tr>
           </thead>
           <tbody>
            <x:forEach select = "$output/Exams/Exam" var ="item">
                <tr>
           	     <td><x:out select = "ExamId" /></td>
           	     <td><x:out select = "ExamName" /></td>
           	     <td><x:out select = "ExamDate" /></td>
           	     <td><x:out select = "ExamTime" /></td>
           	     <td><x:out select = "ExamDuration" /></td>
           	     <td><x:out select = "ExamType" /></td>
           	     <td><x:out select = "ExamTarget" /></td>
           	     </tr>
           	</x:forEach>
             </tbody>
          </table>
        </section>
        <script src="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
    <script src="<%= request.getContextPath()%>/Library/jquery.min.js"></script>
    <script src="<%= request.getContextPath()%>/Library/jquery.datatable.js"></script>
    <script src="<%= request.getContextPath()%>/Library/dataTables.bootstrap5.min.js"></script>
    <script src="<%= request.getContextPath()%>/Nav&Side.js"></script>
</body>
</html>
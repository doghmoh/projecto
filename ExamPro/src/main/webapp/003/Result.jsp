<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Insert title here</title>
  <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/fontawesome-free-6.1.1-web/css/all.min.css">
  <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/FamilyPoppins.css">
  <link rel="stylesheet" href="<%= request.getContextPath()%>/004/Signup/Signup.css" >
</head>
<body>
<%  String id = (String)session.getAttribute("id") ;
   float mark =(float) session.getAttribute("Mark");
   %>
<section>
	    <section class="subBox " style="left: 50%;top: 50%;transform: translate(40%, 30%); width: 60%;height: 70%;">
	       <section class="divLeft w-100">
	          <div  id="HelloBox">
	             <header class="text-center">
	                <div class="title" style="margin-top:50px;">
	                 <h1>Your Mark </h1>
	                </div>
	                <h1 class="text-danger mt-5 p-0"> <%=mark %>/20 </h1>
                  <a href="<%= request.getContextPath()%>/003/StudentHome.jsp" class="btn btn-info mt-4" >Go It</a>
	             </header>
                </div>
          </section>
      </section>
</section>
</body>
</html>
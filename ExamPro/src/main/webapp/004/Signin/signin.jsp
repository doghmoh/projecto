<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0" >
  <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/fontawesome-free-6.1.1-web/css/all.min.css">
  <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/FamilyPoppins.css">
  <link rel="stylesheet" href="<%= request.getContextPath()%>/004/Signup/Signup.css" >
  <title>Signin</title>
</head>
    <body>
     <!-- no back button, clear all cache -->
   
      <% response.setHeader("Cache-Control","no-cache");
      response.setHeader("Cache-Control","no-store");
      response.setHeader("Pragma","no-cache");
      response.setDateHeader ("Expires", 0);%>
      
       <!-- **************************************** -->
       
       <!-- verify if user stay login  -->
       
    <%  String uid = (String)session.getAttribute("id");
        String role = (String)session.getAttribute("role");
           if (uid != null && role=="Student"){
           response.sendRedirect("StudentHome.jsp");  }  
           else if (uid != null && role=="prof"){
           response.sendRedirect("ProfHome.jsp");             
           }
            else if (uid != null && role=="admin"){
           response.sendRedirect("AdminHome.jsp");             
           }else { %>
           
   <!-- **************************************** -->

  <section>
       <div class="SignupBox">
	    <section class="subBox d-flex flex-row">
	       <section class="divRight">
	       </section>
	       <section class="divLeft">
	          <div  id="HelloBox">
	             <header>
	                <div class="title" style="margin-top:70px;">Signin as </div>
	             </header>
                 <div class="btn-group-vertical  btn-nodetype col-12 mt-4" >
	                <button id="2" class="btn btn-primary border-raduis-2">Student</button>
	                <button id="3" class="btn btn-primary border-raduis-2">Teacher</button>
	                <button id="4" class="btn btn-primary border-raduis-2">Administrator</button>
	                <a href="<%= request.getContextPath()%>/004/Signup/Signup.jsp">Create an account</a>
	                <h6 class="text-danger mt-3 p-0"> <% String r = (String)request.getAttribute("message");if(r == null ) { }
	                 else out.print(r); %></h6>
                </div>
             </div>
             <div id="LoginForm1" >
		    	 <%@ include file = "/004/Signin/Signin003.jsp" %>
		   	 </div>
		     <div  id="LoginForm2" >
		        <%@ include file = "/004/Signin/Signin002.jsp" %>
		     </div>
		     <div  id="LoginForm3" >
		        <%@ include file = "/004/Signin/Signin001.jsp" %> 
  			 </div>
          </section>
      </section>
    </div>
</section>
<script src="<%= request.getContextPath()%>/Library/jquery.min.js"></script>
  <script src="<%= request.getContextPath()%>/004/Signup/Signup.js"></script>
      <% } %>
    </body>
</html>

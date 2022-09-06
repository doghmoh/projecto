<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Student Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/fontawesome-free-6.1.1-web/css/all.min.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/FamilyPoppins.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/001/AdminHome.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Nav&Side.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/002/footer.css">
    <%
      response.setHeader("Cache-Control","no-cache");
      response.setHeader("Cache-Control","no-store");
      response.setHeader("Pragma","no-cache");
      response.setDateHeader ("Expires", 0);%>
</head>
<body>
    <%  String id = (String)session.getAttribute("id");
        String role = (String)session.getAttribute("Role");
        String exam =(String)session.getAttribute("exam");
        String question =(String)session.getAttribute("question");
        String mark =(String)session.getAttribute("mark");
        String notification =(String)session.getAttribute("notification");
        if (id !=null && role.equals("Prof") ){%>

    <!-- Call NabBar Component -->
    <%@ include file = "/002/NavBarProf.jsp" %>
    <!-- Call SideBar Component -->
    <%@ include file = "/002/SideBarProf.jsp" %>
    
    <section class="GlobalSection">
 		<section class="HomeSection"><br>
            <div class="container-fluid">
  			<section>
    			<div class="row">
	     			 <div class="col-12 mt-3 mb-1">
				        <h4 class="pt-4 pb-4"> Dashboard</h4>
				     </div>
               </div>
			    <div class="row">
			      <div class="col-xl-3 col-sm-6 col-12 mb-4">
			        <div class="card">
			          <div class="card-body">
			            <div class="d-flex justify-content-between px-md-1">
			              <div class="align-self-center">
			                <i class="fas fa-clipboard text-info fa-3x"></i>
			              </div>
			              <div class="text-end">
			                <h3><%=exam %></h3>
			                <p class="mb-0">Exam</p>
			              </div>
			            </div>
			          </div>
			        </div>
			      </div>
      
			      <div class="col-xl-3 col-sm-6 col-12 mb-4">
			        <div class="card">
			          <div class="card-body">
			            <div class="d-flex justify-content-between px-md-1">
			              <div class="align-self-center">
			                <i class="fas fa-edit text-success fa-3x"></i>
			              </div>
			              <div class="text-end">
			                <h3><%= question %></h3>
			                <p class="mb-0">Question</p>
			              </div>
			            </div>
			          </div>
			        </div>
			      </div>
			      <div class="col-xl-3 col-sm-6 col-12 mb-4">
			        <div class="card">
			          <div class="card-body">
			            <div class="d-flex justify-content-between px-md-1">
			              <div class="align-self-center">
			                <i class="fas fa-map text-warning fa-3x"></i>
			              </div>
			              <div class="text-chart-bar">
			                <h3><%=mark %></h3>
			                <p class="mb-0">Mark</p>
			              </div>
			            </div>
			          </div>
			        </div>
			      </div>
	       </div>
	      </section>
	    </div>
   
     </section> 
  </section><%@ include file = "/002/Footer.html" %>
    <script src="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
    <script src="<%= request.getContextPath()%>/Library/jquery.min.js"></script>
    <script src="<%= request.getContextPath()%>/Nav&Side.js"></script>
    <%} else response.sendRedirect(request.getContextPath()+"/004/signin.jsp"); %>
</body>

</html>
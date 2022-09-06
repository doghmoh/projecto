
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Admin Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="<%= request.getContextPath()%>/Library/fontawesome-free-6.1.1-web/css/all.min.css" />
<link rel="stylesheet"
	href="<%= request.getContextPath()%>/Library/FamilyPoppins.css" />
<link rel="stylesheet"
	href="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%= request.getContextPath()%>/001/AdminHome.css">
<link rel="stylesheet"
	href="<%= request.getContextPath()%>/Nav&Side.css">
<link rel="stylesheet"
	href="<%= request.getContextPath()%>/001/ManageAccount.css">

<%
      response.setHeader("Cache-Control","no-cache");
      response.setHeader("Cache-Control","no-store");
      response.setHeader("Pragma","no-cache");
      response.setDateHeader ("Expires", 0);%>
</head>
<body class="bg-light">
	<%String role = (String)session.getAttribute("Role");
    String id = (String)session.getAttribute("id");
    String departement =(String)session.getAttribute("departement");
    int  speciality =(int )session.getAttribute("speciality");
    int module =(int)session.getAttribute("module");
    int groupe =(int)session.getAttribute("groupe");
    if (id != null && role.equals("Admin")){  %>


	<!-- Call NabBar Component -->
	<%@ include file="/001/NavBarAdmin.jsp"%>
	<!-- Call SideBar Component -->
	<%@ include file="/001/SideBarAdmin.jsp"%>

	<section class="GlobalSection">
		<div class="container-fluid">
			<section>
				<div class="row">
					<div class="col-12 mt-3 mb-1">
						<h4 class="pt-4 pb-4">Dashboard</h4>
					</div>
				</div>
				<div class="row">
					<div class="col-xl-3 col-sm-6 col-12 mb-4">
						<div class="card">
							<div class="card-body">
								<div class="d-flex justify-content-between px-md-1">
									<div class="align-self-center">
										<i class="fas fa-users text-success fa-3x"></i>
									</div>
									<div class="text-end">
										<h3><%=groupe %></h3>
										<p class="mb-0">Groups</p>
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
										<i class="fas fa-book-open text-danger fa-3x"></i>
									</div>
									<div class="text-end">
										<h3><%=module %></h3>
										<p class="mb-0">Module</p>
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
										<i class="fas fa-glasses text-danger fa-3x"></i>
									</div>
									<div class="text-end">
										<h3><%=speciality %></h3>
										<p class="mb-0">Speciality</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</section>
	<script
		src="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
	<script src="<%= request.getContextPath()%>/Library/jquery.min.js"></script>
	<script src="<%= request.getContextPath()%>/Nav&Side.js"></script>
	<% }else response.sendRedirect(request.getContextPath()+"/004/signin.jsp");   %>
</body>
</html>

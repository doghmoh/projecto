<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <title>Prof Page</title>
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

		<% 
		String id = (String)session.getAttribute("id");
		String role = (String)session.getAttribute("Role");
		if (id !=null && role.equals("Prof") ){%>
<body>
   
   <!-- Call NabBar Component -->
    <%@ include file = "./NavBarProf.jsp" %>
    <!-- Call SideBar Component -->
    <%@ include file = "./SideBarProf.jsp" %>
     
   <section class="GlobalSection  bg-light">
                <h1 class="text-center mt-5" style="    font-size: 25px !important;font-weight: 900;">Student Mark</h1><hr>
                <div class="container p-0 d-flex flex-row justify-content-between">
                   <button class="btn btn-danger" data-bs-toggle="tooltip" data-bs-placement="top" title="Delete" id="deletebutton"style="margin-right: 5%;"><i class="fas fa-trash-alt fa-1x "></i></button>
                    </div>
                <hr>
                 <table id="example" class="table table-striped pt-3" style="width:100%">
            <thead>
                <tr class="table-success">
                    <th class=""><input type="checkbox" class="mother"></th>
                    <th scope="col">Id</th>
                    <th scope="col">Module</th>
                    <th scope="col">Mark</th>
                    <th scope="col">edit</th>
                    <th scope="col">delete</th>
                    <th scope="col">view</th>
                </tr>
            </thead>
            <tbody>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tbody>
        </table>
    </section>
    <script src="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
    <script src="<%= request.getContextPath()%>/Library/jquery.min.js"></script>
    <script src="<%= request.getContextPath()%>/Library/jquery.datatable.js"></script>
    <script src="<%= request.getContextPath()%>/Library/dataTables.bootstrap5.min.js"></script>
    <script src="<%= request.getContextPath()%>/Nav&Side.js"></script>
    <script src="<%= request.getContextPath()%>/Alert.js"></script>
    
 
    <%} else response.sendRedirect( request.getContextPath()+"/004/Signin/signin.jsp"); %>
    
</body>

</html>
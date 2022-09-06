
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<head>
    <meta charset="ISO-8859-1">
    <title>Group Member</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/fontawesome-free-6.1.1-web/css/all.min.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/001/ManageAccount.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Nav&Side.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Alert.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/001/ManageAccount.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/jquery.datatable.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/dataTable.bootstrap5.min.css">  
</head>
<% 
	String id = (String)session.getAttribute("id");
	String role = (String)session.getAttribute("Role");
	if (id != null && role.equals("Admin")){  
   	  
 %>
<body>
     <x:parse xml="${student}" var="output"> </x:parse>
     <!-- Call NabBar Component -->
    <%@ include file = "./NavBarAdmin.jsp" %>
    <!-- Call SideBar Component -->
    <%@ include file = "./SideBarAdmin.jsp" %>

   <section class="GlobalSection  bg-light">
                <h1 class="text-center mt-5" style="font-size: 25px !important;font-weight: 900;">Group Member</h1><hr>
                <div class="container p-0 d-flex flex-row justify-content-between m-0 mb-2">
                <button class="btn btn-danger"  data-bs-toggle="modal" data-bs-target="#modelId1"  data-bs-toggle="tooltip" data-bs-placement="top" title="Delete" style="margin-right: 5%;"><i class="fas fa-trash-alt fa-1x "></i></button>
                 </div><hr>
			    <table id="example" class="table table-striped pt-3" style="width:100%">
            <thead>
                <tr class="table-success">
                    <th class=""><input type="checkbox" class="mother"></th>
                    <th hidden="">ID</th>
                    <th >Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Date of Birth</th>
                    <th scope="col">Sexe</th>
                    <th scope="col">Speciality</th>
                    <th scope="col">Level</th>
                </tr>
            </thead>
            <tbody>
                 <x:forEach select="$output/Students/Student">
                <tr>
                     <td><input type="checkbox" name="element"></td>
              	     <td hidden=""><x:out select="Id"/></td>
              	     <td><x:out select="FName"/> <x:out select="LName"/></td>
              	     <td><x:out select="DateOfBirth"/></td>
              	     <td><x:out select="Sexe"/></td>
              	     <td><x:out select="SpecialityId"/></td>
              	     <td><x:out select="LevelId"/></td>
           		</tr>
                </x:forEach>
            </tbody>
        </table>
        
        <!-- Modal -->
             <div class="modal fade" id="modelId1" tabindex="-1" role="dialog"  aria-hidden="true" data-bs-keyboard="false" data-bs-backdrop="static">
              	<div class="modal-dialog" role="document">
                     <div class="modal-content">
                       <div class="modal-header">
                           <h2 class="modal-title">Delete Exam</h2>
                           <button type="button" class="btn-lg btn-close p-0" data-bs-dismiss="modal" aria-label="Close"></button>
                       </div>
                       <div class="modal-body">
                       <h5>Are you sure ?</h5>
                       <button type="button" class="text-center btn-warning p-0 w-100" id="deletebutton" data-bs-dismiss="modal" aria-label="Close">Continue</button>
	               </div>
                   </div>
               </div>
               </div>
    </section>
    <script src="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
    <script src="<%= request.getContextPath()%>/Library/jquery.min.js"></script>
    <script src="<%= request.getContextPath()%>/Library/jquery.datatable.js"></script>
    <script src="<%= request.getContextPath()%>/Library/dataTables.bootstrap5.min.js"></script>
    <script src="<%= request.getContextPath()%>/Nav&Side.js"></script>
    <script src="<%= request.getContextPath()%>/Alert.js"></script>
    <script src="<%= request.getContextPath()%>/002/ManageExam.js"></script>
    <script>
        $(document).ready(function() {
            $('#example').DataTable();
            $('.mother').click(function() {
                var isChecked = $(this).prop("checked");
                $('#example tr:has(td)').find('input[type="checkbox"]').prop('checked', isChecked);
              });
              $('#example tr:has(td)').find('input[type="checkbox"]').click(function() {
                var isChecked = $(this).prop("checked");
                var isHeaderChecked = $(".mother").prop("checked");
                if (isChecked == false && isHeaderChecked)
                  $(".mother").prop('checked', isChecked);
                else {
                  $('#example tr:has(td)').find('input[type="checkbox"]').each(function() {
                    if ($(this).prop("checked") == false)
                      isChecked = false;
                  });
                  $(".mother").prop('checked', isChecked);
                }
        });
              $("#deletebutton").click(function(){
           		 var list = [];
           		$("input[name='element']:checked").each(function(){
           	    list.push($(this).parent().next().text() );
           		});
           		if (list.length == 0) alert("no element selected");
           		else{
           	    $.ajax({
           		  url: "AddDelete",
           		  type: "post", 
           		  data: { 
           		    "objectids" : list,
           		    "operation" : "deleteall",
           		    "table" : "student"
           		  },
           		  success: function() {
           		    window.location = "DisplayGroupMember?"
           		    
           		  },
           		  error: function(xhr) {
           		   console.log("Error........"+ xhr.status);
           	      }
           		})
           	   };
           	  });
     })
    </script>
 
    <%} else response.sendRedirect( request.getContextPath()+"/004/Signin/signin.jsp"); %>
    
</body>

</html>
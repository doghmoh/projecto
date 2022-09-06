<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <title>Manage Exam</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/fontawesome-free-6.1.1-web/css/all.min.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/001/ManageAccount.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Nav&Side.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Alert.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/001/ManageAccount.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/jquery.datatable.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/dataTable.bootstrap5.min.css">  

		<% 
		String id = (String)session.getAttribute("id");
		String role = (String)session.getAttribute("Role");
		if (id !=null && role.equals("Admin") ){%>
<body>
    
    <x:parse xml="${Group}" var="output" /> 
     <!-- Call NabBar Component -->
    <%@ include file = "/001/NavBarAdmin.jsp" %>
    <!-- Call SideBar Component -->
    <%@ include file = "/001/SideBarAdmin.jsp" %>
    
    <section class="GlobalSection  bg-light">
                <h1 class="text-center mt-5" style="    font-size: 25px !important;font-weight: 900;">Group Table</h1><hr>
                <div class="container p-0 d-flex flex-row justify-content-between m-0 mb-2">
                <button class="btn btn-danger"  data-bs-toggle="modal" data-bs-target="#modelId1"  data-bs-toggle="tooltip" data-bs-placement="top" title="Delete" style="margin-right: 5%;"><i class="fas fa-trash-alt fa-1x "></i></button>
                 </div><hr>
         <table id="example" class="table table-striped pt-3" style="width:100%">
            <thead>
                <tr class="table-success">
                    <th class=""><input type="checkbox" class="mother"></th>
                    <th >ID</th>
                    <th >Group n</th>
                    <th scope="col">Speciality</th>
                    <th scope="col">Nbr of Student</th>
                    <th scope="col">edit</th>
                    <th scope="col">view</th>
                </tr>
            </thead>
            <tbody>
            <x:forEach select="$output/Groups/Group" var="item">
                <tr>
                     <td><input type="checkbox" name="element"></td>
              	     <td><x:out select="Id"/></td>
              	     <td>Group <x:out select="Name"/></td>
              	     <td><x:out select="SpecialityId"/></td>
              	     <td><x:out select="GroupMember"/></td>
	                 <td>
	                 <td>
	                 <form action="<%= request.getContextPath()%>/DisplayGroupMember" method="get">
	                 <input type="hidden" name="objectid" value="<x:out select="Id"/>">
                     <button type="submit" class="btn btn-info"><i class="fas fa-eye fa-1x"></i></button>
                     </form>
	            	</td>
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
           		    "table" : "module"
           		  },
           		  success: function() {
           		    window.location = "DisplayModule?"
           		    
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Manage Question</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/fontawesome-free-6.1.1-web/css/all.min.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/FamilyPoppins.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/001/ManageAccount.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Nav&Side.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Alert.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/001/ManageAccount.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/jquery.datatable.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/dataTable.bootstrap5.min.css">
</head>
<body>
        <% String id = (String)session.getAttribute("id");
        String role = (String)session.getAttribute("Role");
        if (id !=null && role.equals("Prof") ){%>
        <x:parse xml="${Question}" var="outputQ" />
        
    
    <!-- Call NabBar Component -->
    <%@ include file = "./NavBarProf.jsp" %>
    <!-- Call SideBar Component -->
    <%@ include file = "./SideBarProf.jsp" %>
    <section class="GlobalSection  bg-light">
           <h1 class="text-center mt-5" style="    font-size: 25px !important;font-weight: 900;">Question Bank</h1><hr>
           <div class="container p-0 d-flex flex-row justify-content-between">
               <button class="btn btn-danger" data-bs-toggle="tooltip" data-bs-placement="top" title="Delete" id="deletebutton"style="margin-right: 5%;"><i class="fas fa-trash-alt fa-1x "></i></button>
              <button class="btn btn-white"  data-bs-toggle="modal" data-bs-target="#modelId"><i class="fa fa-plus-circle" aria-hidden="true" ></i> Add Question</button>
		   </div>
          <%@include file ="AddQuestionModal.jsp" %>
           <hr>
           <table id="example" class="table table-striped pt-3" style="width:100%">
            <thead>
                <tr class="table-success">
                    <th class=""><input type="checkbox" class="mother"></th>
                    <th scope="col">Id</th>
                    <th scope="col">Text</th>
                    <th scope="col">Mark</th>
                    <th scope="col">Type</th>
                    <th scope="col">view</th>
                </tr>
            </thead>
            <tbody>
            <x:forEach select="$outputQ/Questions/Question">
                <tr>
                        <td><input type="checkbox" name="element"></td>
                        <td><x:out select="Id"></x:out></td>
                      	<td><x:out select="Text"></x:out></td>
                      	<td><x:out select="Mark"></x:out></td>
                      	<td><x:out select="Type"></x:out></td>
		              	<td>
                 		<button class="btn btn-info"  data-bs-toggle="modal" data-bs-target="#modelId2"><i class="fa fa-eye text-white" aria-hidden="true" ></i></button>
		                <%@ include file="ViewQuestionModal.jsp" %>
		               </td>
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
    <script src="<%= request.getContextPath()%>/Alert.js"></script>
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
            		})
            		if (list.length == 0) alert("no element selected");
         		    else{
            	    $.ajax({
            		  url: "AddDelete",
            		  type: "post", 
            		  data: { 
            		    "objectids" : list,
            		    "operation" : "deleteall",
            		    "table" : "question"
            		  },
            		  success: function() {
            		    window.location = "DisplayQuestion?"
            		    
            		  },
            		  error: function(xhr) {
            		   console.log("Error........"+ xhr.status);
            	    }
            	   });
         		    }
            	  });
        })
    </script>
 
    <%} else response.sendRedirect( request.getContextPath()+"/004/Signin/signin.jsp"); %>
    
</body>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <title>Manage Exam</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/fontawesome-free-6.1.1-web/css/all.min.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/FamilyPoppins.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Nav&Side.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Alert.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/001/ManageAccount.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/jquery.datatable.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/dataTable.bootstrap5.min.css">  

		<% 
		String id = (String)session.getAttribute("id");
		String role = (String)session.getAttribute("Role");
		if (id !=null && role.equals("Prof") ){%>
<body>
    
    <x:parse xml="${Exam}" var="output" /> 
     <x:parse xml="${Question}" var="outputQ" />
     <!-- Call NabBar Component -->
    <%@ include file = "./NavBarProf.jsp" %>
    <!-- Call SideBar Component -->
    <%@ include file = "./SideBarProf.jsp" %>
    
    <section class="GlobalSection  bg-light">
                <h1 class="text-center mt-5" style="    font-size: 25px !important;font-weight: 900;">Exam Bank</h1><hr>
                <div class="container p-0 d-flex flex-row justify-content-between">
                <button class="btn btn-danger" data-bs-toggle="tooltip" data-bs-placement="top" title="Delete" id="deletebutton"style="margin-right: 5%;"><i class="fas fa-trash-alt fa-1x "></i></button>
                
                <div class="d-flex flex-row justify-content-between col-3">
                    <form action="<%= request.getContextPath()%>/002/ExamCreation.jsp" method="post">
                        <button type="submit" class="btn btn-white"><i class="fa fa-plus-circle" aria-hidden="true"></i> Create Exam</button>
                    </form>
                    
		            <button class="btn btn-white"  data-bs-toggle="modal" data-bs-target="#modelId"><i class="fa fa-plus-circle" aria-hidden="true" ></i> Quick Exam</button>
		        </div>
		        
		        <!-- Modal -->
			    <%@ include file="QuickExamModal.jsp" %>
                </div><hr>
         <table id="example" class="table table-striped pt-3" style="width:100%">
            <thead>
                <tr class="table-success">
                    <th class=""><input type="checkbox" class="mother"></th>
                    <th >Exam ID</th>
                    <th >Exam Name</th>
                    <th scope="col">Exam Date</th>
                    <th scope="col">Exam Time</th>
                    <th scope="col">Exam Duration</th>
                    <th scope="col">Exam Type</th>
                    <th scope="col">schedule</th>
                    <th scope="col">view</th>
                </tr>
            </thead>
            <tbody>
                 <x:forEach select="$output/Exams/Exam">
                <tr>
                     <td><input type="checkbox" name="element"></td>
              	     <td class="idexam"><x:out select="Id"/></td>
              	     <td ><x:out select="Module"/></td>
              	     <td><x:out select="Date"/></td>
              	     <td><x:out select="Time"/></td>
              	     <td><x:out select="Duration"/></td>
              	     <td><x:out select="Type"/></td>
	                 <td>
		             <button class="btn btn-info callsched" data-bs-toggle="modal" data-bs-target="#modelId2"><i class="fas fa-cogs fa-1x"></i></button>
		             </td>
	                 <td>
                        <form action="<%= request.getContextPath()%>/GetExamServlet" method="get" class="form-group" >
                    	    <input type="hidden" name="examid"  value="<x:out select="Id"/>" >
                    		<button type="submit" class="btn btn-info"><i class="fas fa-eye fa-1x"></i></button>
	            		</form>
	            	</td>
           		</tr>
                </x:forEach>
            </tbody>
        </table>
    </section>
     <%@ include file="ScheduleModal.jsp" %>  
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
              $(".callsched").click(function(){
            	  a = $(this).closest('tr').find('td.idexam').text(); 
          $("#schedulebtn").click(function(){
        	  var list= [];
        	  list.push($("select[name='duration'] option:selected").text());
        	  list.push($("select[name='target'] option:selected").text());
        	  list.push( $("input[name='date'] ").val());  
        	  list.push( $("input[name='time']").val()+":00");
        	  list.push( $("select[name='type'] option:selected").text());
        	  list.push($("input[name='AllowUploadFiles']").is(":checked"));
        	  list.push($("input[name='AllowAuto-Grade']").is(":checked"));
        	  
        	  list.push(a); 
        	  $.ajax({
        		  url: "AddDelete",
        		  type: "post", 
        		  data: { 
        		    "objectids" : list,
        		    "operation" : "schedule"
        		  },
        		  success: function() {
        		    window.location = "DisplayExam?msg=success"
        		    
        		  },
        		  error: function(xhr) {
        			  window.location = "DisplayExam?msg=failed"
        		   console.log("Error........"+ xhr.status);
        	    }
        	   });
         })
              });
              $("#deletebutton").click(function(){
            		 var list = [];
            		$("input[name='element']:checked").each(function(){
            	    list.push($(this).parent().next().text() );
            		})
            		if (list.length == 0) alert("no element selected");
            		
            	    else{alert(list)
            	    $.ajax({
            		  url: "AddDelete",
            		  type: "post", 
            		  data: { 
            		    "objectids" : list,
            		    "operation" : "deleteall",
            		    "table" : "exam"
            		  },
            		  success: function() {
            		    window.location = "DisplayExam?msg=success"
            		    
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
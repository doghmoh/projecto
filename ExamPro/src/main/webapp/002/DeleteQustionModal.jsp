<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<button class="btn btn-info" data-bs-toggle="modal" data-bs-target="#modelId3">
		                <i class="fas fa-trash-alt fa-1x"></i></button>
		                  <!-- Modal -->
            			<div class="modal fade" id="modelId3" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true" data-bs-keyboard="false" data-bs-backdrop="static">
              				 <div class="modal-dialog" role="document">
                   				 <div class="modal-content">
                       			 <div class="modal-header">
                         		 <h5 class="modal-title">Delete Question</h5>
                            <button type="button" class="btn-close p-0" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                                 <h5>Are you sure ?</h5>
		                    <br>
		                    <form action="<%= request.getContextPath()%>/AddDelete" method="post" class="form-group" >
			                    <input type="hidden" name="operation"  value="delete" >
			                    <input type="hidden" name="objectid"  value='<x:out select="Id"/>'>
			                    <input type="hidden" name="table"  value="question" >
			                    <button type="submit" class="btn-lg btn-primary p-0 col-12">Continue</button>
			                    
			                </form>
		                    </div>
                   		</div>
                	</div>
                   </div>
</body>
</html>
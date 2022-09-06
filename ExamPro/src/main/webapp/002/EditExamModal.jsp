<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<button onclick="process(event)" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#modelId3"><i class="fas fa-pencil-alt fa-1x"></i></button>
		                <!-- Modal -->
<div class="modal fade" id="modelId3" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true" data-bs-keyboard="false" data-bs-backdrop="static">
			                <div class="modal-dialog" role="document">
                        <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Edit Exam</h5>
                            <button type="button" class="btn-lg btn-close p-0" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
		                    <form action="<%= request.getContextPath()%>/AddDelete" method="post" class="form-group row" >
			                    <input type="hidden" name="operation"  value="edit" >
			                    <input type="hidden" name="objectid"  value="<x:out select="Id"/>" >
			                    <input type="hidden" name="table"  value="exam" >
			                    <div class="col-4"><input type="text" name="variable" placeholder="Exam Name" class="form-control col-4"></div><br>
			                    <div class="col-4"><input type="text" name="variable" placeholder="Exam Date" class="form-control col-6"></div><br>
			                    <div class="col-4"><input type="text" name="variable" placeholder="Exam Time" class="form-control"></div><br><br>
			                    <div class="col-4"><input type="text" name="variable" placeholder="Exam Duration" class="form-control"></div><br>
			                    <div class="col-4"><input type="text" name="variable" placeholder="Exam Type" class="form-control"></div><br>
			                    <div class="col-4"><input type="text" name="variable2" placeholder="Exam Target" class="form-control"></div><br><br>
			                    <br><button type="submit" class="btn-lg btn-primary p-0 col-12">Update</button>
			                </form>
		              </div>
                    </div>
                </div>
                        </div>
</body>
</html>
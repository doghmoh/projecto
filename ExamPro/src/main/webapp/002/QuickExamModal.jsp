<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<div class="modal fade" id="modelId"  tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true" data-bs-keyboard="false" data-bs-backdrop="static" >
			                <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Add new Exam</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
		                    <form action="<%= request.getContextPath()%>/AddDelete" method="post" class="form-group row" >
			                    <input type="hidden" name="operation"  value="add" >
			                    <input type="hidden" name="table"  value="exam" >
			                    <div class="col-6"><input type="text" pattern="[Aa-Zz]+" name="Exam" placeholder="Exam Name" class="form-control col-4" required></div><br>
			                    <div class="col-6"><input type="text" name="Exam" placeholder="Exam Target" class="form-control" required></div>
			                    <br><br>
			                    <div class="">
				                     <select class="form-select" name="Exam">
				                     <option>Test</option><option>Exam Final</option><option>Training</option>
				                     </select>
				                </div><br><br>
				                <div class="">
				                    <h3 class="text-center bg-warning">Question Bank</h3>
				                    <select multiple class="form-select " id="qbank" name="Examoption">
				                    <x:forEach select="$outputQ/Questions/Question" var="item">
				                     <option><x:out select="Id"/>:<x:out select="Text"/></option>
				                    </x:forEach>
				                    </select>
				                </div><br>
				                <div class="text-center"><br>
				                    <h2 class="bg-info" style="font-weight: 900">Click any question to add it.</h2>
				                </div><br>
				                <div class=""><br>
				                    <h3 class="text-center bg-warning">Selected Question</h3>
				                    <select multiple class="form-select" id="qofexam" name="QuestionofExam"  required>
				                    
				                    </select><br>
				            	</div><br>
			                    <button type="submit" class="btn btn-primary col-12">Add</button>
			                </form>
		                    </div>
                    </div>
                </div>
                </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
						<!-- Modal -->
			            <div class="modal fade" id="modelId"  tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true" data-bs-keyboard="false" data-bs-backdrop="static">
			              <div class="modal-dialog" role="document">
                           <div class="modal-content">
                             <div class="modal-header">
	                             <h5 class="modal-title">Add new Module</h5>
	                             <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                             </div>
                        <div class="modal-body">
                            <form action="<%= request.getContextPath()%>/AddDelete" method="post" class="form-group overflow">
                                <input type="hidden" name="operation" value="add">
                                <input type="hidden" name="table" value="question">
                                <input type="text" name="variable" placeholder="Question Text" class="form-control"><br>
                                <input type="text" name="variable2" placeholder="Question Mark" class="form-control"><br>
                                <select name="variable3" class="form-select" id="qtype">
			                    <option selected disabled>Select question type</option>
			                    <option>QCM-Question a Choix Multiple</option>
			                    <option>QCU-Question a Choix Unique</option>
			                    <option>QRL-Question a Reponse Libre</option>
			                    </select><br>
                                <select name="variable4" class="form-select" id="optionnbr" hidden='true'>
			                    <option selected disabled>Select Number of option</option>
			                    <%for(int i =1; i<8 ;i++) {%>
			                    <option><%= i %></option>
			                    <%} %>
			                    </select><br>
			                    <div id="myOptions"></div><br>
                                <br><button type="submit" class="btn-lg btn-primary p-0 col-12">Upload</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div> 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
		                <!-- Modal -->
      <div class="modal fade" id="modelId2" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true" data-bs-keyboard="false" data-bs-backdrop="static">
		<div class="modal-dialog" role="document">
           <div class="modal-content">
              <div class="modal-header">
                  <h5 class="modal-title">Schedule Exam</h5>
                  <button type="button" class="btn-lg btn-close p-0" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
     <div class="modal-body"> <div class="input-group mb-3" style="flex-direction:row;">
            <label class="input-group-text" for="SelectDuration">Duration</label>
				<select class="custom-select form-select" id="SelectDuration" name="duration" >
			      <option value="30">30 min</option>
			      <option value="45">45 min</option>
			      <option value="60" selected>1h 00</option>
			      <option value="75">1h 15</option>
			      <option value="90">1h 30</option>
			      <option value="105">1h 45</option>
			      <option value="120">2h 00</option>
			      <option value="135">2h 15</option>
			      <option value="150">2h 30</option>
			    </select>
								
			    <label class="input-group-text" for="SelectGroups" style="margin-left:8% ;">For Groups</label>
			    <select class="custom-select form-select" id="SelectGroups" name="target" >
			      <option value="L1-A2" selected>L1-A2</option>
			      <option value="L1-A3">L1-A3</option>
			      <option value="L1-A4">L1-A4</option>
			      <option value="L2-G1">L2-G1</option>
			      <option value="L2-G2">L2-G2</option>
			      <option value="M2-SIR1">M2-SIR1</option>
			    </select>
			</div>
								
			<div class="input-group input-group-sm mb-3">
			    <div class="input-group-prepend">
			      <label class="input-group-text" for="ExamDate">Date</label>
			    </div>
			    <input type="date" class="form-control" aria-label="Date" id="ExamDate" name="date" value="2022-01-01">
			</div>
								
			<div class="input-group input-group-sm mb-3 ">
			    <label class="input-group-text" for="ExamTime" >Exam Time</label>
			    <input type="time" class="form-control" id="ExamTime" name="time" value="09:00">
			
			    <label class="input-group-text" for="ExamType" style="margin-left:2% ;">Exam Type</label>
			    <select class="custom-select form-select" id="ExamType" name="type" >
			      <option value="Exam" selected>Exam</option>
			      <option value="Test">Training</option>
			      <option value="Test">Test</option>
			    </select>
		    </div>	  
			<!---------------------------------------------- permissions span------>
			<hr><label class="d-flex"style="margin:0%; font-size: 90%;font-weight: 550; ">Permissions For Students :</label>
			
			<div class="permissons_div pb-4">
			
			  <div class="d-flex flex-row form-switch  mt-4 ">
			    <input class="form-check-input" type="checkbox" role="switch" id="cb1" name="AllowUploadFiles" required>
			    <label class="spn_labels p-1" for="cb1" >Allow Upload Files</label> 
			   </div>
			
			   <div class="d-flex flex-row form-switch">
			    <input class="form-check-input " type="checkbox" role="switch" id="cb2" name="AllowAuto-Grade" required>
			    <label class="spn_labels p-1 for="cb2">Allow Auto-Grade</label>
			   </div>
			</div>
			  <div class="alert alert-warning alert-dismissible fade show" role="alert" style="display:none;" id="SheduleAlert">
			    <strong> <svg xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-emoji-angry" viewBox="0 0 16 16">
			      <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/><path d="M4.285 12.433a.5.5 0 0 0 .683-.183A3.498 3.498 0 0 1 8 10.5c1.295 0 2.426.703 3.032 1.75a.5.5 0 0 0 .866-.5A4.498 4.498 0 0 0 8 9.5a4.5 4.5 0 0 0-3.898 2.25.5.5 0 0 0 .183.683zm6.991-8.38a.5.5 0 1 1 .448.894l-1.009.504c.176.27.285.64.285 1.049 0 .828-.448 1.5-1 1.5s-1-.672-1-1.5c0-.247.04-.48.11-.686a.502.502 0 0 1 .166-.761l2-1zm-6.552 0a.5.5 0 0 0-.448.894l1.009.504A1.94 1.94 0 0 0 5 6.5C5 7.328 5.448 8 6 8s1-.672 1-1.5c0-.247-.04-.48-.11-.686a.502.502 0 0 0-.166-.761l-2-1z"/></svg>
			        You Must !</strong> Fill All The Details.
			  </div>
          <br><button id="schedulebtn" class="btn-lg|sm|xs p-0 btn-primary col-12">Scheduling</button>

      </div>
         </div>
     </div>
     </div>
</body>
</html>
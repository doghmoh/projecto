<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../Setting.css" />
<title>Insert title here</title>

    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/fontawesome-free-6.1.1-web/css/all.min.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/FamilyPoppins.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/css/bootstrap.min.css">
</head>
<body>
<section class="GlobalSection">

<div class="container light-style flex-grow-1 container-p-y">

    <h4 class="font-weight-bold py-3 mb-4">
      Account settings
    </h4>

    <div class="card overflow-hidden">
      <div class="row no-gutters row-bordered row-border-light">
        <div class="col-md-3 pt-0">
          <div class="list-group list-group-flush account-settings-links">
            <a class="list-group-item list-group-item-action" id="generalbtn" >General</a>
            <a class="list-group-item list-group-item-action" id ="changebtn">Change password</a>
          </div>
        </div>
        
        <div class="col-md-9">
          <div class="tab-content">
            <div class="tab-pane fade active show" id="general">
 				<hr class="border-light m-0">
				 <div class="card-body row">
                <div class="form-group col-6">
                  <label class="form-label">First Name</label>
                  <input type="text" class="form-control mb-1" value="nmaxwell">
                </div>
                <div class="form-group col-6">
                  <label class="form-label">Last name</label>
                  <input type="text" class="form-control" value="Nelle Maxwell">
                </div>
                <div class="form-group col-6">
                  <label class="form-label">Date Of Birth</label>
                  <input type="text" class="form-control mb-1" value="nmaxwell@mail.com">
               </div>
                <div class="form-group col-6">
                  <label class="form-label">Email</label>
                  <input type="text" class="form-control mb-1" value="nmaxwell@mail.com">
               </div>
                <div class="form-group col-6">
                  <label class="form-label">Sexe</label>
                  <input type="text" class="form-control mb-1" value="nmaxwell@mail.com">
               </div>
                <div class="form-group col-6">
                  <label class="form-label">University</label>
                  <input type="text" class="form-control mb-1" value="nmaxwell@mail.com">
               </div>
                <div class="form-group col-6">
                  <label class="form-label">Faculty</label>
                  <input type="text" class="form-control mb-1" value="nmaxwell@mail.com">
               </div>
                <div class="form-group col-6">
                  <label class="form-label">Departement</label>
                  <input type="text" class="form-control mb-1" value="nmaxwell@mail.com">
               </div>
                <div class="form-group col-6">
                  <label class="form-label">Speciality</label>
                  <input type="text" class="form-control mb-1" value="nmaxwell@mail.com">
               </div>
                <div class="form-group col-6">
                  <label class="form-label">Level</label>
                  <input type="text" class="form-control mb-1" value="nmaxwell@mail.com">
               </div>
                <div class="form-group col-6">
                  <label class="form-label">Groupe</label>
                  <input type="text" class="form-control mb-1" value="nmaxwell@mail.com">
               </div>
            </div>
            
            <!-- ***************************************************************** -->
            
            <div class="tab-pane fade hide active " id="change">
               <div class="card-body pb-2">
                 <div class="form-group">
                  <label class="form-label">Current password</label>
                  <input type="password" class="form-control">
                </div>

                <div class="form-group">
                  <label class="form-label">New password</label>
                  <input type="password" class="form-control">
                </div>

                <div class="form-group">
                  <label class="form-label">Repeat new password</label>
                  <input type="password" class="form-control">
                </div>
              </div>
           </div>
            </div>
              </div>
            </div>
          </div>
        </div>

    <div class="text-right mt-3">
      <button type="button" class="btn btn-primary">Save changes</button>
      <button type="button" class="btn btn-default">Cancel</button>
    </div>
</div>
</section>
<script src="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
    <script src="<%= request.getContextPath()%>/Library/jquery.min.js"></script>
    <script>
    $(document).ready(function(){
    	$("#change").hide();
    	$("#changebtn").click(function(){
    	    	$("#general").hide()
    	    	$("#change").show()
    	    });
    	    $("#generalbtn").click(function(){
    	    	$("#general").show()
    	    	$("#change").hide()
    	    });
    });
   
    </script>
</body>
</html>
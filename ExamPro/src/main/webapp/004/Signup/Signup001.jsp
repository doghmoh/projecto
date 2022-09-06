<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
     
     <header>
	            <div class="title">Registration Form</div>
	   </header>
    <form action="<%= request.getContextPath() %>/AdminServlet" method="post">
        <div class="row">
            <div class="form-group col-sm-6"> 
                <input name="FirstName" type="text"  placeholder="Prenom" class="form-control" required pattern="[A-Za-z]*" />
             </div>
    
             <div class="form-group col-sm-6"> 
                 <input  name="LastName" type="text" placeholder="Nom"  class="form-control " required pattern="[A-Za-z]*" />
             </div>
            
             <div class="form-group "> 
               <input name="DateOfBirth" type="text" class="form-control" placeholder="Date de Naissance" onfocus="type='date'" pattern="[A-Za-z]*" required/>
             </div>
            
             <div class="form-group ">
                 <input name="Email" type="email"  placeholder="Email" required class="form-control" pattern="[A-Za-z0-9]*@[A-Za-z0-9]*.com" />
             </div>
    
             <div class="form-group col-sm-12 checkeye"> 
            <input name="PassWord" type="password"  placeholder="Mot de Passe" required  class="form-control pw" />
            <i class="checkbtn fas  fa-eye-slash" onclick="eye()"></i>
            </div>
            
               <div class="form-group col-sm-6 select ">
	                <select class="form-select univ" name="University" required>
	                    <option disabled selected>Select universite</option>
	                </select>
	            </div>
	              <div class="form-group col-sm-6 select ">
	                <select class="form-select Faculte"  name="Faculty" id="Faculte" required>
	                    <option disabled selected>Select Faculte</option>
	                </select>
	            </div>
	            <div class="form-group col-sm-6 select ">
	                <select class="form-select Departement"  name="Departement" id="Departement" required>
	                    <option disabled selected>Select Departement</option>
	                </select>
	            </div>
                <!------------------------------------------------------>
                <div class="form-group select col-sm-6 ">
	                <select class="form-select " name="Sexe" required>
	                    <option disabled selected >Select Sexe</option>
	                    <option>Male</option>
	                    <option>Female</option>
	                </select>
	            </div>     
               <div class="form-group  text-center mt-3 mb-3">
                <input class="btn btn-sm btn-primary w-100" type="submit" value="Signup" />
               </div>
        </div>
    </form>
	<a href="<%= request.getContextPath()%>/004/Signin/signin.jsp">I already have an account</a>
</body>
</html>
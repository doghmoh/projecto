<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
    <header>
	 <div class="title" style="margin-top:80px">Signin</div>
	</header>
    <form method="post" action="<%= request.getContextPath()%>/SigninServlet">
        <input type="hidden" value="Admin" name="Role" >
        <div>
        <div class="form-group ">
           <input name="Email" type="email"  placeholder="Email" required class="form-control" pattern="[A-Za-z0-9]*@[A-Za-z0-9]*.com" />
        </div>
        <div class="form-group col-sm-12 checkeye"> 
           <input name="Pasword" type="password"  placeholder="Mot de Passe" required  class="form-control pw" />
        <i class="checkbtn fas  fa-eye-slash" onclick="eye()"></i>
        </div> 
        <div class="form-group  text-center mt-3">
             <input class="btn btn-primary w-100" type="submit" value="Signin" />
        </div>
        </div>
    </form><br><a href="<%= request.getContextPath()%>/004/Signup/Signup.jsp">Create an account</a>
</body>
</html>
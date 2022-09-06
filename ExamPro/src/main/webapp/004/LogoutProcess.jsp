<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
		<%   
         session.removeAttribute("email");
         session.invalidate();  
         response.sendRedirect("Signin/signin.jsp");
                %> 
    <body> <h1> Wait ... </h1>
    </body>
</html>

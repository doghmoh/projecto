<%@ page language="java" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="ISO-8859-1">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/css/bootstrap.min.css">
        <title>Verification Link</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/VerificationLink.css" />
    </head>
    <style>
    body {
  		display: flex;
		flex-direction:row;
		}
    </style>
    <body>
        <% 
        String email = (String)request.getAttribute("email"); 
        String userid = (String)request.getAttribute("uid");
        String role = (String)request.getAttribute("role");
        String msg = (String)request.getAttribute("message");
        %>
        

       <div class="container">
	      <h2>Verify Your Account</h2>
	      <p>We emailed you the six digit code to <% if (email.equals("")){} else out.print(email); %> <br/> Enter the code below to confirm your email address.</p>
	      <div class="code-container">
	      <form method="post" action="<%= request.getContextPath() %>/ActivateAccount">
	        <input  type="hidden" name="email" value="<% out.print(email); %>">
            <input  type="hidden" name="id" value="<% out.print(userid); %>">
            <input type="hidden" name="role" value="<% out.print(role); %>">
	        <input type="text" name="a" class="code"  placeholder="-"  maxlength="1" required>
	        <input type="text" name="b" class="code" placeholder="-"  maxlength="1" required>
	        <input type="text" name="c" class="code" placeholder="-"  maxlength="1" required>
	        <input type="text" name="d" class="code" placeholder="-"  maxlength="1" required>
	        <input type="text" name="e" class="code" placeholder="-"  maxlength="1" required>
	        <input type="text" name="f" class="code" placeholder="-"  maxlength="1" required><br>
	        <input  class=" btn btn-primary" type="submit" value="Verifier code" >
	      </form>
	      
	      <a class="submit" class="text-warning" href="<%= request.getContextPath() %>/ResendEmailServlet?email=<% out.print(email); %>&id=<% out.print(userid); %>&role=<% out.print(role); %> " ></a>
	      </div>
      		<small class="info bg-warning">
        			If you close this tab, you will not able to activate this account next time.
      		</small>
    	</div>
			 
                
           
            
			
    			
    </body>
</html>

<%-- 
    Document   : welcom.jsp
    Created on : 25-Jun-2022, 18:43:36
    Author     : Administrateur
--%>
<%@ page session= "true" %>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome Page</title>
    </head>
    <style>* {
    padding: 0;
    margin: 0;
    text-decoration: none !important;
    list-style: none;
    box-sizing: border-box ;
}

body {
    font-family: monospace !important;
    overflow-x: hidden;
}
</style>
   <body>
       <h1> Error !! go back</h1>
       <% out.print(request.getAttribute("message")); %>
           <a href="AdminPanelServlet.jsp">Back</a>
          <input type="text" value="${message}">
          
    </body>
    </html>

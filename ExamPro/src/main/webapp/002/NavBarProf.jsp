<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<%  String Name = (String)session.getAttribute("Username");%>

<!-- Nav bar in  External file  -->
<nav class="navbar navbar-expand-lg navbar-light bg-info fixed-top">
        <div class="container-fluid ">
            <button class="btn btn-info" id="poper" >
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="#"><img src="<%= request.getContextPath()%>/Library/logo.png" style="width:30px;height:30px"/>amMe</a>
            <ul class="navbar-nav d-flex flex-row justify-content-end flex-grow-1">
                <li class="nav-item p-3 ">
                    <a id="username" class="card-link" href="Setting.html"><%=Name  %></a>
                </li>
            </ul>
            <div class="dropdown open">
                <button class="btn btn-info btn-sm|lg" type="button" id="triggerId" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                   <i class="fas far fa-bell fa-1x"></i>
                </button>
                <div class="dropdown-menu" aria-labelledby="triggerId" style="width:400px; left: -220px; margin: 0; padding: 0;">
                    <li class="bg-warning p-3"><strong>Notification</strong></li>
                    <li class="d-flex flex-row border-bottom-1 border-light  h6 bg-light"><i class="fas fa-bell fa-2x p-4"></i>
                        <p class="p-1 p-lg-3">L'examen de module algo a ete fixe ajourdui.</p>
                    </li>
                </div>
            </div>
            <div class="dropdown open ">
                <button class="btn btn-info btn-sm|lg" type="button" id="triggerId" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                   <i class="fas fas fa-cog fa-1x "></i> 
                </button>
                <div class="dropdown-menu" aria-labelledby="triggerId" style="width: 250px; left: -130px; ">
                    <a class="dropdown-item" href="Setting.html">Profile</a>
                    <a class="dropdown-item" href="#">Policy and Privacy</a>
                    <a class="dropdown-item" href="#">Logout</a>
                </div>
            </div>
        </div>
    </nav>
    
    <!--  ************************************************************************************* -->
</body>
</html>
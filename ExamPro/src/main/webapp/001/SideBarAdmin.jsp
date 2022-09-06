<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<aside class="Aside bg-gradient bg-info " class="collapse navbar-collapse" id="collapsibleNavId">
        <div id="myTab">
            <a href=" <%= request.getContextPath()%>/001/AdminHome.jsp">
                <i class="fas fa-home"></i>
                <p>Home</p>
            </a><hr>
            <a id="navaccount">
                <i class="fas fa-file-invoice"></i>
                <p>Manage Account</p>
            </a>
            <div id="stdprof" style="display: none; padding: 0 0 0 10%">
            <form action="<%= request.getContextPath()%>/DisplayAccount" method="get"><hr>
            <a href="javascript:;" onclick="parentNode.submit();"class="sub-link" >
                <p >Manage Student</p>
            </a>
            </form><hr>
            <form action="<%= request.getContextPath()%>/DisplayProf" method="get">
            <a href="javascript:;" onclick="parentNode.submit();" class="sub-link ml-5">
                <p>Manage Prof</p>
            </a>
            </form><hr>
            <form action="<%= request.getContextPath()%>/DisplayProfRequest" method="get">
            <a href="javascript:;" onclick="parentNode.submit();" class="sub-link ml-5">
                <p>Manage Request (Prof)</p>
            </a>
            </form><hr>
            <form action="<%= request.getContextPath()%>/DisplayAdminRequest" method="get">
            <a href="javascript:;" onclick="parentNode.submit();" class="sub-link ml-5">
                <p>Manage Request (Admin)</p>
            </a>
            </form>
            </div>
            <hr>
            <form action="<%= request.getContextPath()%>/DisplayGroup" method="get">
            <a href="javascript:;" onclick="parentNode.submit();">
                <i class="fas fa-pencil-alt"></i>
                <p>Manage Group</p>
            </a>
            </form><hr>
            <form action="<%= request.getContextPath()%>/DisplayModule" method="get">
            <a href="javascript:;" onclick="parentNode.submit();">
                <i class="fas fa-pencil-alt"></i>
                <p>Manage Module</p>
            </a>
            </form><hr>
            <form action="<%= request.getContextPath()%>/DisplaySpeciality" method="get">
            <a href="javascript:;" onclick="parentNode.submit();">
                <i class="fas fa-draw-polygon"></i>
                <p>Manage Speciality</p>
            </a>
            </form><hr>
            <a href="<%= request.getContextPath()%>/004/LogoutProcess.jsp">
                <i class="fas fa-sign-out-alt"></i>
                <p>Logout</p>
            </a><hr>
        </div>
    </aside>
</body>
</html>
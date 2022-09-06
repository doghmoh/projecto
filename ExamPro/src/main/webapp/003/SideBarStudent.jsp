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
            <a href=" <%= request.getContextPath()%>/003/StudentHome.jsp">
                <i class="fas fa-home"></i>
                <p>Home</p>
            </a><hr>
            <form action="<%= request.getContextPath()%>/DisplayEvent" method="get">
            <a href="javascript:;" onclick="parentNode.submit();">
                <i class="fas fa-file-invoice"></i>
                <p>Exam Room</p>
            </a>
            </form><hr>
            <form action="<%= request.getContextPath()%>/DisplayPlanning" method="post">
            <a href="javascript:;" onclick="parentNode.submit();">
                <i class="fas fa-pencil-alt"></i>
                <p>Planning Room</p>
            </a>
            </form><hr>
            <form action="<%= request.getContextPath()%>/DisplayStats" method="post">
            <a href="javascript:;" onclick="parentNode.submit();">
                <i class="fas fa-pencil-alt"></i>
                <p>Statistics Room</p>
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
<%@page import="Dao.AdminFunction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

<!-- Side Bar in External File  -->
<aside class="Aside bg-gradient bg-info " class="collapse navbar-collapse" id="collapsibleNavId">
        <div id="myTab">
            <a href=" <%= request.getContextPath()%>/002/ProfHome.jsp">
                <i class="fas fa-home"></i>
                <p>Home</p>
            </a>
            <hr>
            <form action="<%= request.getContextPath()%>/DisplayExam" method="get">
            <a href="javascript:;" onclick="parentNode.submit();">
                <i class="fas fa-file-invoice"></i>
                <p>Manage Exam</p>
            </a>
            </form><hr>
            <form action="<%= request.getContextPath()%>/DisplayQuestion" method="get">
            <a href="javascript:;" onclick="parentNode.submit();">
                <i class="fas fa-pencil-alt"></i>
                <p>Manage Question</p>
            </a>
            </form><hr>
            <form action="<%= request.getContextPath()%>/DisplayMark" method="get">
            <a href="javascript:;" onclick="parentNode.submit();">
                <i class="fas fa-draw-polygon"></i>
                <p>Manage Mark</p>
            </a>
            </form><hr>
            <a href="<%= request.getContextPath()%>/004/LogoutProcess.jsp">
                <i class="fas fa-sign-out-alt"></i>
                <p>Logout</p>
            </a><hr>
        </div>
    </aside>
    <!-- ************************************************************************** -->
</body>
</html>
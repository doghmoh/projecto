
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
     
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/fontawesome-free-6.1.1-web/css/all.min.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/FamilyPoppins.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Nav&Side.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/003/Statistics.css">
     <title>Page</title>
    </head>
    <body>
    <%  
        String id = (String)session.getAttribute("id");
    	String role = (String)session.getAttribute("Role");
        if (id != null && role.equals("Student")){ %>
        
     <!-- Call NabBar Component -->
    <%@ include file = "./NavBarStudent.jsp" %>
    <!-- Call SideBar Component -->
    <%@ include file = "./SideBarStudent.jsp" %>
    
    <section class="GlobalSection">
    <div class="divo">
        <div class="ChartDiv1">
            <canvas id="myChart"></canvas>
          </div>
    </div>
    <div class="divo">
          <div class="chart-wrapper">
            <canvas id="myChart3"></canvas>
          </div>
          <div class="chart-wrapper">
            <canvas id="myChart4"></canvas>
          </div>
          <div class="chart-wrapper" >
            <div class="table-responsive">
                <table class="table table-striped table-light text-center">
               <tr class="bg-succes">
                <th>ExamId</th>
                <th>ExamDate</th>
                <th>ExamScore</th>
                <th>Observation</th>
               </tr>
               <tr>
                <td>10</td>
                <td>2018-06-08</td>
                <td>14</td>
                <td>Good</td>
               </tr>
               <tr>
                <td>12</td>
                <td>2019-06-08</td>
                <td>11</td>
                <td>Good</td>
               </tr>
               
            </table>
            </div>
        </div>
    </div>
     
    </section>
    
    <script src="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
    <script src="<%= request.getContextPath()%>/Library/jquery.min.js"></script>
     <script src="<%= request.getContextPath()%>/Library/Chart.js"> </script>
    <script src="<%= request.getContextPath()%>/Nav&Side.js"></script>
     <script src="<%= request.getContextPath()%>/003/Statistics.js"></script>
    <% }else  response.sendRedirect("signin.jsp");  %>
    </body>
    
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/fontawesome-free-6.1.1-web/css/all.min.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/FamilyPoppins.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Nav&Side.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/003/StudentHome.css">
	<link type="text/css" href="<%= request.getContextPath()%>/Library/jquery.countdown.css" rel="stylesheet">
	<style>
	.card-title{
	font-size: 1vw;
	}
	</style>
</head>
<body>

<x:parse xml="${Exam}" var="output" />

<c:set var="doc">
    <x:out select="$output" />
</c:set>

    <%@ include file = "./NavBarStudent.jsp" %>

    <%@ include file = "./SideBarStudent.jsp" %>
<x:out select ="$output"/>
   <section class="GlobalSection">
       <section class="HomeSection">
          <div class="container-fluid">
            <section>
			    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
			      <h1 class="h2"></h1>
          	    </div>
                <div class=" main d-flex flex-column flex-wrap ">
                <c:if test="${empty doc}"> <div class="h5">Nothing to see here, come back next time. We will notify you if there is any news.</div></c:if>
                <% int i=0 ; %>
                <x:forEach select="$output/Exams/Exams/Exam" var ="item">
              
                       <div class="card d-flex flex-row" style="margin-bottom:20px;width: 100%; display: flex;flex-direction: column-reverse;justify-content: center; ">  
	                        <div class="card-header text-center text-dark" style="width: 50%;display: flex;flex-direction: column; justify-content: center;">
	                        <ul class="example e<%=i ++%>">
									<li><span class="hours">00</span><p class="hours_text">Hours</p></li>
									<li class="seperator">:</li>
									<li><span class="minutes">00</span><p class="minutes_text">Minutes</p></li>
									<li class="seperator">:</li>
									<li><span class="seconds">00</span><p class="seconds_text">Seconds</p></li>
									<div class="token" hidden=""><x:out select ="Id" /></div>
							</ul>
	                        </div>
                            <div class="card-body text-dark" style="font-weight:bolder;">
                                <li class="card-title " >Module : <x:out select ="Module" /> </li>
                                <hr>
                                <li class="card-title ">Exam Type : <x:out select ="Type" /></li>
                                <hr>
                                <li class="card-title edate " >Exam Date : <p><x:out select ="Date" /></p> </li>
                                <hr>
                                <li class="card-title timer">Exam Time :  <p><x:out select = "Time" /></p></li>
                                <hr>
                                <li class="card-title ">Exam duration : <x:out select = "Duration" /></li>
                            </div>
                            
                     </div> 
                
                </x:forEach>
                  </div>
             </section>
            </div>
       </section>
   </section>
   <script src="<%= request.getContextPath()%>/Library/jquery.min.js"></script>
   <script src="<%= request.getContextPath()%>/Library/jquery.countdown.min.js" ></script>
    <script type="text/javascript" charset="utf-8">
   $(document).ready(function(){
	   
 
    var i =0;
    $(".main").children().each(function () {
    if($(this).find('.timer p').text() != "" && $(this).find('.edate p').text() != ""){
    	time0 =$(this).find('.timer p').text() ;
    	date =$(this).find('.edate p').text()
    	var a = []; a=date.split("-"); 
    	newtime =  a[1]+'/'+a[2]+'/'+a[0]+" "+time0;
    var now = new Date();
    var time = newtime;
    $('.e'+ i).countdown({
        date: time,
        offset: +1,
        minute: 'minute',
        hideOnComplete: false
    }, function (container) { 
       token = $(container).find(".token").text(); 
       $(container).find("li").hide()
       $(container).html('Press to Start').css({"padding":"15px","font-size":"2vw","cursor":"pointer"});
        $(container).parent().parent().on('click',function(){
        	$.ajax({
      		  url: "DisplayExamPaper",
      		  type: "get", 
      		  data: { 
      			exam: token
      		  },
      		  success: function(data) {
         //       $('html').html(responseText);
               window.location = '003/PassExam.jsp';
      		      console.log(responseText)
      		  },
      		  error: function(xhr) {
      		   console.log("Error........"+ xhr.status);
      	    }
      	   });
        	
        })
      
    })
    }
    i++;
    });
    
   })
      </script>
</body>
</html>
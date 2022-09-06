
<!DOCTYPE html>
<html>
    <head>
 		<link rel="stylesheet" href="<%= request.getContextPath() %>/Library/bootstrap-5.0.2-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/VerificationLink.css" />
        <title>JSP Page</title>
    </head>
    <style> .div1{border: 1px solid black;text-align: center; padding: 30px;position: absolute; left: 50%;top:50%; transform: translate(-50%,-50%); width: 80%;} 
        .div1 h2{ width: 40%;padding-bottom: 20px;} ol.progtrckr { margin: 0; padding: 0; list-style-type: none; } 
        ol.progtrckr li { display: inline-block; text-align: center; line-height: 3em; } 
        ol.progtrckr[data-progtrckr-steps="2"] li { width: 49%; } ol.progtrckr[data-progtrckr-steps="3"] li { width: 33%; } 
        ol.progtrckr[data-progtrckr-steps="4"] li { width: 24%; } ol.progtrckr[data-progtrckr-steps="5"] li { width: 19%; } 
        ol.progtrckr[data-progtrckr-steps="6"] li { width: 16%; } ol.progtrckr[data-progtrckr-steps="7"] li { width: 14%; } 
        ol.progtrckr[data-progtrckr-steps="8"] li { width: 12%; } ol.progtrckr[data-progtrckr-steps="9"] li { width: 11%; } 
        ol.progtrckr li.progtrckr-done { color: black; border-bottom: 4px solid yellowgreen; } 
        ol.progtrckr li.progtrckr-todo { color: silver; border-bottom: 4px solid silver; } 
        ol.progtrckr li:after { content: "\00a0\00a0"; } ol.progtrckr li:before { position: relative; bottom: -2.5em; float: left; left: 50%; line-height: 1em; } ol.progtrckr li.progtrckr-done:before { content: "\2713"; color: white; background-color: yellowgreen; height: 1.2em; width: 1.2em; line-height: 1.2em; border: none; border-radius: 1.2em; } ol.progtrckr li.progtrckr-todo:before { content: "\039F"; color: silver; background-color: white; font-size: 1.5em; bottom: -1.6em; } </style>

    <body>
		      
		<div class="container">
		    <h2>Your Account State</h2>
		    <ol class="progtrckr" data-progtrckr-steps="5">
	           <li class="progtrckr-done">Register</li>
	           <li class="progtrckr-done">Activate</li>
	           <li class="progtrckr-todo">Admin authorization</li>
	        </ol>
	   </div>
       
	   <small class="info mt-3">
           Wait for Admin Authorization.<a href="<%= request.getContextPath()%>/004/Signin/signin.jsp" >Go Back</a>
           
       </small>
		    	
    </body>
</html>
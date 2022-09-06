<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0" >
  <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/bootstrap-5.0.2-dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/fontawesome-free-6.1.1-web/css/all.min.css">
  <script src="<%= request.getContextPath()%>/Library/jquery.min.js"></script>
  <link rel="stylesheet" href="<%= request.getContextPath()%>/Library/FamilyPoppins.css">
 	<link rel="stylesheet" href="<%= request.getContextPath()%>/002/ExamCreation.css" >
 	<link rel="stylesheet" href="<%= request.getContextPath()%>/002/footer.css" >
 	<link rel="icon" href="<%= request.getContextPath()%>/SLogo.png">
  <title>Create an Exam</title>



</head>
<body >
  
  <nav class="NavBar">
    <i class="fas fa-bars"></i>
    <img src="./PLogo.png" class="logo">
    <button type="button" class="BtnLogOut">
      <svg xmlns="http://www.w3.org/2000/svg" width="25" height="50" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
     <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
     <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
</svg> Log Out </button>
    <ul>
        <li><a href="#">Home</a></li>
        <li><a href="./AboutUs.html">About</a></li>
        <li><a href="#">Services</a></li>
        <li><a href="#">Contact</a></li>
    </ul>
  
</nav>

    <!----------------------------------------------------->
  
    <aside class="lables_Side" id="labs_side" ><!----------------------------- this side is for side Navbtns Lables ------------>
          

      <label class="lables" id="lb2"  >Add Image</label>
      <label class="lables" id="lb3"  >Import Questions</label>
      <label class="lables" id="lb4"  >Questions bla</label>
     



    </aside>

    <aside class="side" >
        <p style="font-weight:750; margin-bottom: 30%;" >
           <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"  fill="currentColor" class="bi bi-sliders" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M11.5 2a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM9.05 3a2.5 2.5 0 0 1 4.9 0H16v1h-2.05a2.5 2.5 0 0 1-4.9 0H0V3h9.05zM4.5 7a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM2.05 8a2.5 2.5 0 0 1 4.9 0H16v1H6.95a2.5 2.5 0 0 1-4.9 0H0V8h2.05zm9.45 4a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zm-2.45 1a2.5 2.5 0 0 1 4.9 0H16v1h-2.05a2.5 2.5 0 0 1-4.9 0H0v-1h9.05z"/></svg>
         Nav</p> 
    
        


                
           
           <button class="navbtn" id="Navbtn1" onmouseover="mouseOver1()" onmouseout="mouseOut1()">
            <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-images" viewBox="0 0 16 16">
              <path d="M4.502 9a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z"/>
              <path d="M14.002 13a2 2 0 0 1-2 2h-10a2 2 0 0 1-2-2V5A2 2 0 0 1 2 3a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v8a2 2 0 0 1-1.998 2zM14 2H4a1 1 0 0 0-1 1h9.002a2 2 0 0 1 2 2v7A1 1 0 0 0 15 11V3a1 1 0 0 0-1-1zM2.002 4a1 1 0 0 0-1 1v8l2.646-2.354a.5.5 0 0 1 .63-.062l2.66 1.773 3.71-3.71a.5.5 0 0 1 .577-.094l1.777 1.947V5a1 1 0 0 0-1-1h-10z"/></svg>
           </button>  <!--Add img/graph--> 
          <input type="file" id="prr" hidden name="name">
          <button class="navbtn" id="Navbtn2" onmouseover="mouseOver2()" onmouseout="mouseOut2()">
            <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-cloud-plus" viewBox="0 0 16 16">
              <path fill-rule="evenodd" d="M8 5.5a.5.5 0 0 1 .5.5v1.5H10a.5.5 0 0 1 0 1H8.5V10a.5.5 0 0 1-1 0V8.5H6a.5.5 0 0 1 0-1h1.5V6a.5.5 0 0 1 .5-.5z"/>
              <path d="M4.406 3.342A5.53 5.53 0 0 1 8 2c2.69 0 4.923 2 5.166 4.579C14.758 6.804 16 8.137 16 9.773 16 11.569 14.502 13 12.687 13H3.781C1.708 13 0 11.366 0 9.318c0-1.763 1.266-3.223 2.942-3.593.143-.863.698-1.723 1.464-2.383zm.653.757c-.757.653-1.153 1.44-1.153 2.056v.448l-.445.049C2.064 6.805 1 7.952 1 9.318 1 10.785 2.23 12 3.781 12h8.906C13.98 12 15 10.988 15 9.773c0-1.216-1.02-2.228-2.313-2.228h-.5v-.5C12.188 4.825 10.328 3 8 3a4.53 4.53 0 0 0-2.941 1.1z"/>
            </svg>
          </button>  <!---Import Questions-->

          <button  class="navbtn" id="Navbtn3" onmouseover="mouseOver3()" onmouseout="mouseOut3()">
            <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-file-text" viewBox="0 0 16 16">
              <path d="M5 4a.5.5 0 0 0 0 1h6a.5.5 0 0 0 0-1H5zm-.5 2.5A.5.5 0 0 1 5 6h6a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5zM5 8a.5.5 0 0 0 0 1h6a.5.5 0 0 0 0-1H5zm0 2a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1H5z"/>
              <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2zm10-1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1z"/>
            </svg>
          </button>  <!--------Add Title/Description-->
        
    </aside>

    <!--------------------------------------------action="/ExamProject/ExamCreationServlet" method="get"------------------>
<form class="forma" id="formaid" >
     <div class="date_time">
      <label id="today" style="float: left;"> </label>
      <label id="currentTime" style="float: right;"></label>
     </div>


     <div class="div0">       <!---   Exam Name    --->
      <input type="text" required  id="ExamName" name="ExamName" placeholder="Exam Name ..." >
     </div>
   <!--
    <div class="div1 mb-3">       
        <textarea  style="background-color: rgb(255, 223, 253); font-weight: 600;" class="form-control Ques_TestArea" id="S-1" placeholder="Section Name ..." rows="1"></textarea>
   
        <button class="remove_btn" id="id1" > <img src="./node_modules/bootstrap-icons/icons/trash3.svg" />

        </button> 
      
       
      </div> --->

    <div class="div2 mb-3" id="Q-1">
        <textarea  class="form-control Ques_TestArea" id="Q-ta-1" name="Q-ta-1" placeholder="Question text  ....." rows="2" style="font-weight:600 ;" required></textarea>
    
        <button class="remove_btn"  id="remove-Q-btn-1" > <img src="./node_modules/bootstrap-icons/icons/trash3.svg" />
        Remove Question</button>  <!--------------------------------------------------------  remove question   --->


        <select class="select1" id="Navbtn0" onchange="selectType(this);"> 
          <option value="QCM" selected="true">QCM</option>
          <option value="BA" >BA</option>
          <option value="TEXT" >TEXT</option>
          </select> 

       <div class="div_opt_nbr" >
        <label class="label_opt_nbr">Number of Options</label>
        <select class="select_opt_nbr" id="select-1" onchange="AddOptions(1,this.selectedIndex+1)">
          <option selected>0</option>
          <option>2</option>
          <option>3</option>
          <option>4</option>
          <option>5</option>
          <option>6</option>
        </select>
       </div>
       <br>

       

       <div id="optionsdiv-1"></div>

    </div>
 
     
  
   
    <!----------------------------------------------------------------->
   <div id="CostumedDiv">
     <!--for adding option/questions/Sections with dom-->
    </div>
        
   
     <!----------------------------------------------------------------->   
      <div class="div3">

         <!--  <button class="add_option" id="btn1" onclick="dof1();">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-plus-square-dotted" viewBox="0 0 16 16">
            <path d="M2.5 0c-.166 0-.33.016-.487.048l.194.98A1.51 1.51 0 0 1 2.5 1h.458V0H2.5zm2.292 0h-.917v1h.917V0zm1.833 0h-.917v1h.917V0zm1.833 0h-.916v1h.916V0zm1.834 0h-.917v1h.917V0zm1.833 0h-.917v1h.917V0zM13.5 0h-.458v1h.458c.1 0 .199.01.293.029l.194-.981A2.51 2.51 0 0 0 13.5 0zm2.079 1.11a2.511 2.511 0 0 0-.69-.689l-.556.831c.164.11.305.251.415.415l.83-.556zM1.11.421a2.511 2.511 0 0 0-.689.69l.831.556c.11-.164.251-.305.415-.415L1.11.422zM16 2.5c0-.166-.016-.33-.048-.487l-.98.194c.018.094.028.192.028.293v.458h1V2.5zM.048 2.013A2.51 2.51 0 0 0 0 2.5v.458h1V2.5c0-.1.01-.199.029-.293l-.981-.194zM0 3.875v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zM0 5.708v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zM0 7.542v.916h1v-.916H0zm15 .916h1v-.916h-1v.916zM0 9.375v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zm-16 .916v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zm-16 .917v.458c0 .166.016.33.048.487l.98-.194A1.51 1.51 0 0 1 1 13.5v-.458H0zm16 .458v-.458h-1v.458c0 .1-.01.199-.029.293l.981.194c.032-.158.048-.32.048-.487zM.421 14.89c.183.272.417.506.69.689l.556-.831a1.51 1.51 0 0 1-.415-.415l-.83.556zm14.469.689c.272-.183.506-.417.689-.69l-.831-.556c-.11.164-.251.305-.415.415l.556.83zm-12.877.373c.158.032.32.048.487.048h.458v-1H2.5c-.1 0-.199-.01-.293-.029l-.194.981zM13.5 16c.166 0 .33-.016.487-.048l-.194-.98A1.51 1.51 0 0 1 13.5 15h-.458v1h.458zm-9.625 0h.917v-1h-.917v1zm1.833 0h.917v-1h-.917v1zm1.834-1v1h.916v-1h-.916zm1.833 1h.917v-1h-.917v1zm1.833 0h.917v-1h-.917v1zM8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3v-3z"/>
           </svg> Add Option</button> --> 

           <button  type="button" class="add_opt_btn" id="btn2" onclick="AddQuestion()"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-plus-square-dotted" viewBox="0 0 16 16">
                <path d="M2.5 0c-.166 0-.33.016-.487.048l.194.98A1.51 1.51 0 0 1 2.5 1h.458V0H2.5zm2.292 0h-.917v1h.917V0zm1.833 0h-.917v1h.917V0zm1.833 0h-.916v1h.916V0zm1.834 0h-.917v1h.917V0zm1.833 0h-.917v1h.917V0zM13.5 0h-.458v1h.458c.1 0 .199.01.293.029l.194-.981A2.51 2.51 0 0 0 13.5 0zm2.079 1.11a2.511 2.511 0 0 0-.69-.689l-.556.831c.164.11.305.251.415.415l.83-.556zM1.11.421a2.511 2.511 0 0 0-.689.69l.831.556c.11-.164.251-.305.415-.415L1.11.422zM16 2.5c0-.166-.016-.33-.048-.487l-.98.194c.018.094.028.192.028.293v.458h1V2.5zM.048 2.013A2.51 2.51 0 0 0 0 2.5v.458h1V2.5c0-.1.01-.199.029-.293l-.981-.194zM0 3.875v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zM0 5.708v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zM0 7.542v.916h1v-.916H0zm15 .916h1v-.916h-1v.916zM0 9.375v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zm-16 .916v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zm-16 .917v.458c0 .166.016.33.048.487l.98-.194A1.51 1.51 0 0 1 1 13.5v-.458H0zm16 .458v-.458h-1v.458c0 .1-.01.199-.029.293l.981.194c.032-.158.048-.32.048-.487zM.421 14.89c.183.272.417.506.69.689l.556-.831a1.51 1.51 0 0 1-.415-.415l-.83.556zm14.469.689c.272-.183.506-.417.689-.69l-.831-.556c-.11.164-.251.305-.415.415l.556.83zm-12.877.373c.158.032.32.048.487.048h.458v-1H2.5c-.1 0-.199-.01-.293-.029l-.194.981zM13.5 16c.166 0 .33-.016.487-.048l-.194-.98A1.51 1.51 0 0 1 13.5 15h-.458v1h.458zm-9.625 0h.917v-1h-.917v1zm1.833 0h.917v-1h-.917v1zm1.834-1v1h.916v-1h-.916zm1.833 1h.917v-1h-.917v1zm1.833 0h.917v-1h-.917v1zM8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3v-3z"/>
           </svg> Add Question</button>

           <button type="button" class="add_opt_btn" id="btn3" onclick="AddSection()"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-plus-square-dotted" viewBox="0 0 16 16">
                <path d="M2.5 0c-.166 0-.33.016-.487.048l.194.98A1.51 1.51 0 0 1 2.5 1h.458V0H2.5zm2.292 0h-.917v1h.917V0zm1.833 0h-.917v1h.917V0zm1.833 0h-.916v1h.916V0zm1.834 0h-.917v1h.917V0zm1.833 0h-.917v1h.917V0zM13.5 0h-.458v1h.458c.1 0 .199.01.293.029l.194-.981A2.51 2.51 0 0 0 13.5 0zm2.079 1.11a2.511 2.511 0 0 0-.69-.689l-.556.831c.164.11.305.251.415.415l.83-.556zM1.11.421a2.511 2.511 0 0 0-.689.69l.831.556c.11-.164.251-.305.415-.415L1.11.422zM16 2.5c0-.166-.016-.33-.048-.487l-.98.194c.018.094.028.192.028.293v.458h1V2.5zM.048 2.013A2.51 2.51 0 0 0 0 2.5v.458h1V2.5c0-.1.01-.199.029-.293l-.981-.194zM0 3.875v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zM0 5.708v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zM0 7.542v.916h1v-.916H0zm15 .916h1v-.916h-1v.916zM0 9.375v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zm-16 .916v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zm-16 .917v.458c0 .166.016.33.048.487l.98-.194A1.51 1.51 0 0 1 1 13.5v-.458H0zm16 .458v-.458h-1v.458c0 .1-.01.199-.029.293l.981.194c.032-.158.048-.32.048-.487zM.421 14.89c.183.272.417.506.69.689l.556-.831a1.51 1.51 0 0 1-.415-.415l-.83.556zm14.469.689c.272-.183.506-.417.689-.69l-.831-.556c-.11.164-.251.305-.415.415l.556.83zm-12.877.373c.158.032.32.048.487.048h.458v-1H2.5c-.1 0-.199-.01-.293-.029l-.194.981zM13.5 16c.166 0 .33-.016.487-.048l-.194-.98A1.51 1.51 0 0 1 13.5 15h-.458v1h.458zm-9.625 0h.917v-1h-.917v1zm1.833 0h.917v-1h-.917v1zm1.834-1v1h.916v-1h-.916zm1.833 1h.917v-1h-.917v1zm1.833 0h.917v-1h-.917v1zM8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3v-3z"/>
            </svg> Add Section</button> 
      </div>
       <!------------------------------------------------------------------------------------->
          
       <input type="hidden" id="examinfo" name="examinfo" style="width: 90%; opacity: 0;">
      <!----------------------------------------------------------------------------------------->


  <div class="submit_div">
    <button class="schedulebtn" type="button">Schedule-Exam <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-calendar2-check" viewBox="0 0 17 17">
     <path d="M10.854 8.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L7.5 10.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
     <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM2 2a1 1 0 0 0-1 1v11a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V3a1 1 0 0 0-1-1H2z"/>
     <path d="M2.5 4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H3a.5.5 0 0 1-.5-.5V4z"/></svg>
    </button>
  </div>
      <!---------------------------------------------------------------->
      <span class="schedulespan">
        <div style="float: right; display: flex; width: 40%;">
          <label class="schedule_labels" for="SelectDuration">Duration</label>
          <select  id="SelectDuration" style="padding:1% 1% 1% 1% ; border-radius: 0px 4px 4px 0px;border:0; width:100%;">
            <option value="30">30 min</option>
            <option value="45">45 min</option>
            <option value="60" selected>1h 00</option>
            <option value="75">1h 15</option>
            <option value="90">1h 30</option>
            <option value="105">1h 45</option>
            <option value="120">2h 00</option>
            <option value="135">2h 15</option>
            <option value="150">2h 30</option>
          </select>
        </div>

        <div style="float: left; display: flex; width: 40%;">
          <label class="schedule_labels" for="SelectGroups">For_Groups</label>
          <select  id="SelectGroups" style="padding:1% 1% 1% 1% ; border-radius: 0px 4px 4px 0px;border:0; width:100%;" >
            <option value="L1-A2">L1-A2</option>
            <option value="L1-A3">L1-A3</option>
            <option value="L1-A4">L1-A4</option>
            <option value="L2-G1">L2-G1</option>
            <option value="L2-G2">L2-G2</option>
            <option value="M2-SIR1">M2-SIR1</option>
          </select>
        </div>
        <br><br>
      
        <div style="float: left; display: flex; width: 40%;">
            <label class="schedule_labels" for="ExamDate">Date</label>
            <input type="date" style="padding:1% 1% 1% 1% ; border-radius: 0px 4px 4px 0px;border:0; width:100%;" aria-label="Date" id="ExamDate"  name="ExamDate" required>
        </div>
      
        <div style="float: right; display: flex; width: 40%;" >
          <label class="schedule_labels" for="ExamTime" >Exam_Time</label>
          <input type="time"  id="ExamTime" name="ExamTime"  style="padding:1% 1% 1% 1% ; border-radius: 0px 4px 4px 0px;border:0; width: 100%;" required>
        </div>
        <br>

        <div style="display: flex; margin:7% 0% 5% 30%; text-align: center; width: 40%;">
          <label class="schedule_labels" for="ExamType" >Exam_Type</label>
          <select  id="ExamType" style="padding:1% 1% 1% 1% ; border-radius: 0px 4px 4px 0px;border:0; width: 100%;">
            <option value="Exam" selected>Exam</option>
            <option value="Test">Text</option>
          </select>
        </div>
        
      <!---------------------------------------------- permissions span------>
      <label style="margin:0% 20% 0% 20% ; font-size: 100%;font-weight: 700;">Permissions For Students :</label>
      
      <div class="permissons_div">
      
        <div class="form-switch ">
          <input class="form-check-input" type="checkbox" role="switch" id="cb1" checked>
          <label class="spn_labels" for="cb1" >Allow Upload Documents</label> 
         </div>
      
          <div class="form-switch ">
           <input class="form-check-input" type="checkbox" role="switch" id="cb3" checked>
           <label class="spn_labels" for="cb3">Allow Auto_Correction</label>
          </div>
      <!---
          <div class="form-switch ">
           <input class="form-check-input" type="checkbox" role="switch" id="cb4">
           <label class="spn_labels" for="cb4">Allow something</label>
          </div> -->
      
        </div>
      
        <div class="alert alert-warning alert-dismissible fade show" role="alert" style="display:none;" id="SheduleAlert">
          <strong> <svg xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-emoji-angry" viewBox="0 0 16 16">
            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/><path d="M4.285 12.433a.5.5 0 0 0 .683-.183A3.498 3.498 0 0 1 8 10.5c1.295 0 2.426.703 3.032 1.75a.5.5 0 0 0 .866-.5A4.498 4.498 0 0 0 8 9.5a4.5 4.5 0 0 0-3.898 2.25.5.5 0 0 0 .183.683zm6.991-8.38a.5.5 0 1 1 .448.894l-1.009.504c.176.27.285.64.285 1.049 0 .828-.448 1.5-1 1.5s-1-.672-1-1.5c0-.247.04-.48.11-.686a.502.502 0 0 1 .166-.761l2-1zm-6.552 0a.5.5 0 0 0-.448.894l1.009.504A1.94 1.94 0 0 0 5 6.5C5 7.328 5.448 8 6 8s1-.672 1-1.5c0-.247-.04-.48-.11-.686a.502.502 0 0 0-.166-.761l-2-1z"/></svg>
              You Must !</strong> Fill All The Details.
        </div>
      
      
        <input type="submit" value="Save Changes" class="btn btn-primary btn-lg" id="SaveChanges">
        <button type="button" class="btn btn-secondary btn-lg" id="CancelChanges">Cancel</button>
      
      
      </span>
    </form>






<footer class="footer-distributed">

  <div class="footer-left">

    <img src="./PLogo.png" width="50%" hight="30%">


    <p class="footer-links">
      <a href="#" class="link-1">Home</a>
      
      <a href="#">Blog</a>
    
    
      <a href="#">About</a>
      
      <a href="#">Faq</a>
      
      <a href="#">Contact</a>
    </p>

    <p class="footer-company-name">Company Name © 2022</p>
  </div>

  <div class="footer-center">

    <div>
      <i class="fa fa-map-marker"></i>
      <p><span>FS.UNIV</span> UMBB, Boumerdas</p>
    </div>

    <div>
      <i class="fa fa-phone"></i>
      <p>+1.555.555.5555</p>
    </div>

    <div>
      <i class="fa fa-envelope"></i>
      <p><a href="@company.com">support@company.com</a></p>
    </div>

  </div>

  <div class="footer-right">

    <p class="footer-company-about">
      <span>About the company</span>
     knkdjd zdnzkdkz zk,kzskz,d zdkzkdzkdz k,z,dkzkzdkzl zdkz,dkzdk oookdozk k,dkzdk.
    </p>

    <div class="footer-icons">

      <a href="#"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-facebook" viewBox="0 0 16 16">
        <path d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z"/>
      </svg>
    </a>
      <a href="#"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-linkedin" viewBox="0 0 16 16">
        <path d="M0 1.146C0 .513.526 0 1.175 0h13.65C15.474 0 16 .513 16 1.146v13.708c0 .633-.526 1.146-1.175 1.146H1.175C.526 16 0 15.487 0 14.854V1.146zm4.943 12.248V6.169H2.542v7.225h2.401zm-1.2-8.212c.837 0 1.358-.554 1.358-1.248-.015-.709-.52-1.248-1.342-1.248-.822 0-1.359.54-1.359 1.248 0 .694.521 1.248 1.327 1.248h.016zm4.908 8.212V9.359c0-.216.016-.432.08-.586.173-.431.568-.878 1.232-.878.869 0 1.216.662 1.216 1.634v3.865h2.401V9.25c0-2.22-1.184-3.252-2.764-3.252-1.274 0-1.845.7-2.165 1.193v.025h-.016a5.54 5.54 0 0 1 .016-.025V6.169h-2.4c.03.678 0 7.225 0 7.225h2.4z"/>
      </svg>
    </a>
      <a href="#"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-github" viewBox="0 0 16 16">
        <path d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.012 8.012 0 0 0 16 8c0-4.42-3.58-8-8-8z"/>
      </svg>
    </a>
      <a href="#"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-twitter" viewBox="0 0 16 16">
        <path d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z"/>
      </svg>
    </a>

    </div>

  </div>

</footer>


  <script src="ExamCreation.js"></script>

</body>
</html>
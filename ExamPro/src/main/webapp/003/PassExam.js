
// Exam time in milliseconds 61 min forexample
var ExamTime=61*60*1000;
var countDownDate = new Date().getTime()+ExamTime;

// Update the count down every 1 second
var x = setInterval(function() {

  // Get today's date and time
  var now = new Date().getTime();
    
  // Find the distance between the count down date and now
  var distance = countDownDate - now;
    
  // Time calculations for hours, minutes and seconds

  var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
  if(hours==0){ 
    document.getElementById("ClockDiv").innerHTML =minutes + "m " + seconds + "s ";
  }else{
  document.getElementById("ClockDiv").innerHTML =hours + "h "
  + minutes + "m " + seconds + "s ";
}
  // If the count down is over, write some text 
  if (distance < 0) {
    clearInterval(x);
    document.getElementById("ClockDiv").innerHTML = "EXPIRED";
  }
}, 1000);

//  --------- show  current date and time -----------

var x2 = setInterval(function() {
var today = new Date();
var currentTime = new Date();
var time = currentTime.getHours()%12 + ":" + currentTime.getMinutes() + ":" + currentTime.getSeconds();
var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate(); 
document.getElementById("today").innerHTML = date;
document.getElementById("currentTime").innerHTML = time;
}, 1000);
///////////////////////////////////////////////////////////////////////////


  var SectionText; var QuestionCpt=0;


function MakeSection(SectionText){
let sec=document.createElement("label");
sec.setAttribute("class","SectionDiv");
sec.innerText=SectionText;
 document.getElementById('InsertionDiv').appendChild(sec);
 
}


   var QType,NbrOptions,Text,HasImg;
function MakeQuestion(QType,NbrOptions,Text,HasImg){ 
   //QType="checkbox";NbrOptions="3";Text="how old are you ?";HasImg="null";
   ++QuestionCpt;
   let qst_div=document.createElement('div');
   qst_div.setAttribute("class","mb-3")
   let Q_text=document.createElement('p');
   Q_text.setAttribute("class","QuestionLabel");
   Q_text.innerText= Text;
   Q_text.id=QuestionCpt;
   
   let n=parseInt(NbrOptions);

  qst_div.append(Q_text);

   if(n==0){ //////////// free text
     
     let response_ta =document.createElement('textarea');
     response_ta.setAttribute("class","form-control ResponseLabel");
     qst_div.append(response_ta);
    
//////////// free text
     ////////
   }
   
   else{
        
console.log(n);
        for(let i=1;i<=n; i++){

          let opt=document.createElement('input');
          if(QType=="checkbox"){
            opt.setAttribute("type","checkbox");
          }
          else {
           opt.setAttribute("type","radio");
           var nameStr=""+QuestionCpt+"-"+i+"";
           opt.setAttribute("name",nameStr);
          }

          opt.setAttribute("class","checkBoxStyle");
          
          let OptLabel=document.createElement('label');
          OptLabel.setAttribute("class","OptionsLabel");
          OptLabel.innerText="hello world "+i+"";

          qst_div.append(opt);
          qst_div.append(OptLabel);
          
          qst_div.append(document.createElement('br'));
          
          
        }

   }

   if(HasImg=="Null"){ 
    document.getElementById('InsertionDiv').append(qst_div);
   }
   else{
    /// appending image here //////
   }

}            
			var questions = []; var i =0; var flag;
			$('#submitbtn').click(function(){ 
				var headerPart = "<?xml version=\"1.0\" encoding=\"utf-8\"?><Questions>";
				var footerPart = "</Questions>";
				var bodyHtml = $('#bigoneid')[0].outerHTML;
				var id =$('#examid').text();
				questions.push(headerPart);
				$("input").each(function(){
					if($(this).attr("name") == "question" && i==0) questions.push("<Question><Id>"+$(this).val()+"</Id>");
					else if($(this).attr("name") == "question" && i!=0) questions.push("</Question><Question><Id>"+$(this).val()+"</Id>");
					else if($(this).attr("name") == "option") questions.push("<Option><Id>"+$(this).val()+"</Id>");
					 else  if($(this).attr("name") == "checkbox") {
						if($(this).is(":checked")){flag=1} else flag = 0;
					questions.push("<isChecked>"+flag+"</isChecked></Option>")}
					i++;
			  })
			  if($("textarea[name='text']").text() != "") questions.push("<answer>"+$("textarea[name='text']").text()+"</answer>");
			  questions.push("</Question>"+footerPart);
			  var xml = questions.join("").toString().replace(",","");
			console.log(xml);
			 $.ajax({
            		  url: "../GetResult",
            		  type: "post", 
            		  data: { 
            		    "content" : bodyHtml,
            		    "examid" :  id,
            		    "result" : xml
            		  },
            		  success: function() {
	                     window.location= "Result.jsp";
            		    
            		  },
            		  error: function(xhr) {
            		   console.log("Error........"+ xhr.status);
            	    }
            	   });
		});
$('#SendDocument').click(function(){ 
  $('#ffile').click();
});

 var fla= "true";
function checker(e){
	var a = e.target.firstElementChild;
	if(!a.checked){
	a.setAttribute("checked","true");
	e.target.setAttribute("class","option correct");
	fla="false"
	}
	else {
	a.removeAttribute("checked");
    e.target.setAttribute("class","option");
    fla="true"
	}
}


var qsmORbstanser=false;
var cpt=1; let divnbr=1;
let SectionCpt=0;
let removeid=1; /// to get the id of remove btn in order to delete section
let mymap = new Map(); /// this map contains the questions nbr and there's options nbr
mymap.set(1,0);
let mySectionMap=new Map(); /// this map contains the Sestion nbr and the current Question nbr
//mySectionMap.set(1,0);


function AddOptions(cpt,optnbr){  
 if(optnbr==1) {mymap.set(cpt,0);}else{mymap.set(cpt,optnbr);}
  let hh=document.getElementById("optionsdiv-"+cpt+"");
if(hh){
  document.getElementById("optionsdiv-"+cpt+"").remove();}

let NewOptionsDiv=document.createElement("div");
NewOptionsDiv.setAttribute("id","optionsdiv-"+cpt+"");



  if(optnbr>1){



 for(let i=1;i<=optnbr;i++){

    var inp= document.createElement("input"); 

    if(qsmORbstanser==true){inp.setAttribute("type","radio");
     inp.name="op"+cpt; inp.className="checkBoxStyle";
    }
    else
    {
     inp.setAttribute("type","checkbox");
     inp.name="op"+cpt; inp.className="checkBoxStyle";

    }    

    
  
      
          
                      
    inp.id="Q"+cpt+"-OP"+i+"";  /// hna id ta3 input 
    let lab=document.createElement("input");  //hadi label win tktb opt
    lab.setAttribute("type","text");
    lab.setAttribute('required', '');
    lab.setAttribute("placeholder"," text  her .....");
    lab.setAttribute("rows","1");
    lab.setAttribute("class","OptionsLable");
    
   
    lab.id="Q"+cpt+"-TA"+i+"";
    lab.setAttribute("name","Q"+cpt+"-TA"+i+"");

    let br= document.createElement("br");

    NewOptionsDiv.append(inp);
    NewOptionsDiv.append(lab);
    NewOptionsDiv.append(br);
  } 
  let MarkLabel=document.createElement('label');
  MarkLabel.innerText="Question Mark";
  MarkLabel.style.width="20%";
  MarkLabel.style.textAlign="right";
  MarkLabel.style.fontSize="90%";
  MarkLabel.style.float="right";
  let Mark=document.createElement('input');
  Mark.setAttribute("min","1");
  Mark.setAttribute("value","1");
  Mark.setAttribute("oninput","validity.valid||(value='')");
  Mark.setAttribute("type","number");
  Mark.setAttribute("class","MarkInput");
  Mark.setAttribute("id","QMark"+cpt);

  NewOptionsDiv.append(Mark);
  NewOptionsDiv.append(MarkLabel);
 

}
  
document.getElementById("Q-"+cpt+"").append(NewOptionsDiv); /// hna tls9 newOptionsDiv ta3 les optins m3a div ta3 Question
}



function AddQuestion(){

++cpt;
mymap.set(cpt,0);
  let div= document.createElement("div");
  div.setAttribute("id","Q-"+cpt+"");
  div.style.width="100%";
  div.setAttribute("class","div2 mb-3");

 let Question_ta= document.createElement("textarea");
 Question_ta.setAttribute("class","form-control Ques_TestArea");
 Question_ta.setAttribute("id","Q-ta-"+cpt+"");
 Question_ta.setAttribute("name","Q-ta-"+cpt+"");
 Question_ta.setAttribute('required', '');
 Question_ta.setAttribute("placeholder","Question text "+cpt+" .....");
 Question_ta.setAttribute("rows","2");
 Question_ta.style.fontWeight="600";
 Question_ta.style.margin="0% 0% 0% 0%";

 let remove_Question_btn=document.createElement("button");
 remove_Question_btn.setAttribute("class","remove_btn");
 remove_Question_btn.setAttribute("id","remove-Q-btn-"+cpt+""); 
 let html="<img src='./node_modules/bootstrap-icons/icons/trash3.svg' /> Remove Question";
 remove_Question_btn.innerHTML=html;
 remove_Question_btn.onclick=function(){ // this is the remove function
   
       this.parentNode.remove();
       let questionToDelete=this.parentNode.id.toString();
      let v =parseInt(questionToDelete[2]);
      //alert(v);
      

       mymap.delete(v);
          
  }; 

 let NbrOptionsDiv=document.createElement("div");
  NbrOptionsDiv.setAttribute("class","div_opt_nbr");

 let NbrOptionLabel=document.createElement("label");
  NbrOptionLabel.setAttribute("class","label_opt_nbr");
  NbrOptionLabel.innerText='Number of Options';

let SelectNbrOptions=document.createElement("select");
SelectNbrOptions.setAttribute("class","select_opt_nbr");
SelectNbrOptions.setAttribute("id","select-"+cpt+"");
 let array = [0,2,3,4,5,6];

for (var i = 0; i < array.length; i++) {  
 let newOption = document.createElement('option');
 let optionText = document.createTextNode(array[i]);
 newOption.appendChild(optionText);
  SelectNbrOptions.appendChild(newOption);
}
SelectNbrOptions.options[0].selected;

let newOptionsDiv=document.createElement("div");
newOptionsDiv.setAttribute("id","optionsdiv-"+cpt+"");

  SelectNbrOptions.onchange=function(){

    let questionToDelete=this.parentNode.parentNode.id.toString();
    //console.log("questionToDelete :"+questionToDelete.length);
    let v;
    if(questionToDelete.length==3){ v =parseInt(questionToDelete[2]);console.log("questionToDelete :"+questionToDelete.length);}
    else{ v =parseInt(questionToDelete[2]+questionToDelete[3]);console.log("questionToDelete worked !! :"+questionToDelete.length);}
    
    console.log("hhh "+v+" "+this.selectedIndex);
     AddOptions(v,this.selectedIndex+1);
    } 
////////////// question type select /////////
let SelectQuestionType=document.createElement("select");
SelectQuestionType.setAttribute("class","select1");
SelectQuestionType.onchange=function(){selectType(this);};
let array2 = ['QCM','BA','TEXT'];

for (var i = 0; i < array2.length; i++) {  
 let newOption = document.createElement('option');
 let optionText = document.createTextNode(array2[i]);
 newOption.value=array2[i];
// if(i==0){newOption.setAttribute("selected","true");}
 newOption.appendChild(optionText);
  SelectQuestionType.appendChild(newOption);
}

////////////////////////////////
NbrOptionsDiv.append(NbrOptionLabel);
NbrOptionsDiv.append(SelectNbrOptions);
 
 div.append(Question_ta);
 div.append(remove_Question_btn);
 div.append(SelectQuestionType);
 div.append(NbrOptionsDiv);
 div.append(newOptionsDiv);
 

 let ss=document.getElementById('CostumedDiv');
 ss.appendChild(div);

 
}

function AddSection(){            /////////// ********* add new section *********** //////////
   
  ++SectionCpt;
  mySectionMap.set(SectionCpt,cpt);
    let ta2= document.createElement("textarea");
    ta2.setAttribute("class","form-control Ques_TestArea");
    ta2.setAttribute("id","S-"+SectionCpt+"");
    ta2.setAttribute("name","S-"+SectionCpt+"");
    ta2.setAttribute("placeholder","New Section .....");
    ta2.setAttribute('required', '');
    ta2.setAttribute("rows","1");
    ta2.style.width="100%";
    ta2.style.margin="1% 0% 1% 1%";
    ta2.style.backgroundColor="rgb(255, 223, 253)";
    ta2.style.fontWeight="600";
   ////////////////////////////////////////////////////////////////////
   let div=document.createElement("div");
   div.style.width="100%"
   div.setAttribute("class","div1 mb-3");
   let remove_btn=document.createElement("button");
   remove_btn.setAttribute("class","remove_btn");
   let x="id"+removeid+""; // the id of this remove button
   remove_btn.setAttribute("id",""+x+"");
   remove_btn.onclick=function(){document.getElementById(x).parentNode.remove(); // this is the remove function
    let questionToDelete=this.id.toString();
      let v =parseInt(questionToDelete[2]);
      alert(v);
       mySectionMap.delete(v);
  }; 
   remove_btn.innerHTML="<img src='./node_modules/bootstrap-icons/icons/trash3.svg' /> Remove Section";
   
  
   div.append(ta2);
   div.append(remove_btn);



    let s2 =document.getElementById('CostumedDiv');
    s2.appendChild(div);
   ++removeid;
   
}


  
function selectType (e){
    let idd;let j=e.parentNode.id;
    if(j.length==3){ idd=parseInt(j[2]);}
    else{ idd =parseInt(j[2]+j[3]);}
    if(e.value=='TEXT'){
      document.getElementById("optionsdiv-"+idd).remove();
      document.getElementById("select-"+idd).value=0;
      document.getElementById("select-"+idd).disabled=true;
    }
    else if(e.value=="BA"){
      document.getElementById("select-"+idd).disabled=false;      
      
      let x= document.getElementById("select-"+idd).value;
              if(x>0){
                for(let j=x;j>0;j--){
         
                  let id="Q"+idd+"-OP"+j+"";
                  let ff=document.getElementById(id);
                  ff.type='radio';
                  ff.name="Q"+idd;
                }
      }
    }
      else{
        document.getElementById("select-"+idd).disabled=false;  
        let x= document.getElementById("select-"+idd).value;
        if(x>0){
          for(let j=x;j>0;j--){
   
            let id="Q"+idd+"-OP"+j+"";
            let ff=document.getElementById(id);
            ff.type='checkbox';
          }
        }
      }
}

/********************************************************************************************** */
  function mouseOver1() {
    let nv1=document.getElementById('lb2');
    nv1.style.opacity="1";
    nv1.style.transition="opacity 600ms ease-out";
    document.getElementById("Navbtn1").style.height = "50px";
  
  }

  function mouseOut1(){
    let nv1=document.getElementById("lb2");
    nv1.style.opacity="0";
    nv1.style.transition="opacity 650ms ease-out";
    document.getElementById("Navbtn1").style.height = "30px";

  }
/************************************************************************************************ */
  function mouseOver2() {
    let nv2=document.getElementById('lb3');
    nv2.style.opacity="1";
    nv2.style.transition="opacity 600ms ease-out";
    document.getElementById("Navbtn2").style.height = "50px";
  
  }

  function mouseOut2(){
    let nv2=document.getElementById("lb3");
    nv2.style.opacity="0";
    nv2.style.transition="opacity 650ms ease-out";
    document.getElementById("Navbtn2").style.height = "30px";


  }
/************************************************************************************************** */
  function mouseOver3() {
    let nv3=document.getElementById('lb4');
    nv3.style.opacity="1";
    nv3.style.transition="opacity 600ms ease-out";
    document.getElementById("Navbtn3").style.height = "50px";
  
  }

  function mouseOut3(){
    let nv3=document.getElementById('lb4');
    nv3.style.opacity="0"
    nv3.style.transition="opacity 650ms ease-out";
    document.getElementById("Navbtn3").style.height = "30px";


  }
/*********************************************************************************************** */


  let  myImgMp= new Map();
  let imgg=0;
    $('#Navbtn1').click(function(){    ///// when clicking navbtan2 (add image) in nav bar

     ++imgg;
     myImgMp.set(imgg,cpt);
     let y =document.createElement('img');
     y.setAttribute("class","img-fluid"); // tobe responsive with bootstarp
     y.id=imgg;
     y.style.width="100%";
     y.style.height="75%"
     y.style.marginBottom="2%";

 

     let imgdiv=document.createElement("div");
     imgdiv.append(y);
     imgdiv.id="d"+imgg;

    document.getElementById('CostumedDiv').append(imgdiv);
    let x= document.getElementById("prr").click();
      
 document.getElementById('prr').onchange=function(e){
  const[file]=prr.files;
   if(file){y.src=URL.createObjectURL(file);
     y.style.border="2px solid black";
    }

  let RemoveImg=document.createElement("button");
  RemoveImg.setAttribute("class","remove_btn");
  RemoveImg.setAttribute("type","button");
  RemoveImg.setAttribute("id","RI-"+imgg+"");
  RemoveImg.onclick=function(){ let z= this.parentNode.id;
    let zz= parseInt( z[1]);
     myImgMp.delete(zz);
    this.parentNode.remove();};
  RemoveImg.innerHTML="<img src='./node_modules/bootstrap-icons/icons/trash3.svg' /> Remove Image";
  imgdiv.append(RemoveImg);

 };
      
      $('#lb2').toggle();
})


    $('#Navbtn2').click(function(){    ///// when clicking navbtan3  in nav bar
      $('#lb3').toggle();
    })

    $('#Navbtn3').click(function(){    ///// when clicking navbtan3  in nav bar
       $('#lb4').toggle();
     })

  /************************************* remove functions ********************/
    $("#remove_ques_id").click(function(){ 
    document.getElementById("remove_ques_id").parentElement.remove();
    for(let i=opname;i>0;i--){
      let v="Q"+cpt+"-"+i+"";
      document.getElementById(v).parentNode.remove();
     }

   })
   
   $("#remove_sec_id").click(function(){   
   document.getElementById("remove_sec_id").parentElement.remove();
  })


 





$('.schedulebtn').click(function(){


  $(".NavBar , .side , .submit_div").fadeTo(500, 0.2);
  $('.schedulespan').show(100,"linear",0);
  
 

  

 $('#SaveChanges').click(function(){  
  $(".side , .forma , .NavBar , .submit_div").fadeTo(500, 1);
  document.getElementById("examinfo").setAttribute('value',""+PreparExamInfo()+"");
console.log(document.getElementById("examinfo").value);


  var exam_date = document.getElementById("ExamDate").value;
  var exam_time = document.getElementById("ExamTime").value;

if(exam_date =='' || exam_time ==''){ $('#SheduleAlert').show(); $('#SaveChanges').disabled=true;}
  else{
    $('#SheduleAlert').hide(); $('#SaveChanges').disabled=false;
  }
  


  $('.schedulespan').hide()
 })


 $('#CancelChanges').click(function(){
  $('.schedulespan').hide()
  $(".side , .forma , .NavBar , .submit_div").fadeTo(500, 1);
 })


})

function PreparExamInfo(){

var ToBeJson="[ {";
mymap.forEach((values,keys)=>{
  ToBeJson +="\"Question\" : { \"Section\":\""+getQSection(keys)+"\",\"Text\":\""+getQId(keys)+"\",\"Type\":\""+getQType(keys)+"\",\"HasImg\":\""+getQHasImg(keys)+"\",\"NbrOptions\":"+values+",\"Mark\":"+getQMark(keys)+"" +getQJsonOptions(keys)+"},{";
})

ToBeJson = ToBeJson.slice(0, ToBeJson.length -2);
ToBeJson +="]";
return ToBeJson;
}

function getQSection(qstnbr){  
if(mySectionMap.size==0){return null;}else{

  for (let [key, value] of mySectionMap.entries()) {
    var xx=key;
    if (value >= qstnbr){
       break;
     } else{ xx=key+1;}

} if(xx-1==0){ return null; }else { let r="S-"+(xx-1)+""; return r;}
}
}

function getQId(qstnbr){
let testid="Q-ta-"+qstnbr+"";
 if(mymap.has(qstnbr)){return testid;}else{return null;}

} //// not sure


function getQType(qstnbr){
let x= document.getElementById("select-"+qstnbr+"").value;
if(x==0){ return "free";}
if (document.getElementById("Q"+qstnbr+"-OP1").type == 'checkbox') {
   return "checkbox";
}
else {
return "radio";
}
}
/////////////////////////////////
function getQMark(qstnbr){

  if(mymap.get(qstnbr)>0){
  let mark= document.getElementById("QMark"+qstnbr).value;
return mark;
  }
  else{return 0;}
}
//////////////////////////////////////
function getQHasImg(qstnbr){

  if(myImgMp.size==0){ return null;} 
  else {
  for (let [key, value] of myImgMp.entries()) {
    if (value == qstnbr)
      return key;
      else {return null;}
  } 
 }
}
  

function getQJsonOptions(qstnbr){
  let optionsNbr= mymap.get(qstnbr);
  let OptionsJson="";
  for( let i=1;i<=optionsNbr;i++){
    OptionsJson+=",";
    let label_i = "Q"+qstnbr+"-TA"+i+"";
    let checkbox_i = "Q"+qstnbr+"-OP"+i+"";
    OptionsJson +="\"Label"+i+"\":\""+label_i+"\",\"CheckBox"+i+"\":\""+document.getElementById(checkbox_i).checked+"\"";
  }
  OptionsJson +="}"
  return OptionsJson;
}

//  --------- show  current date and time -----------

var ss = setInterval(function() {
  var today = new Date();
  var currentTime = new Date();
  var time = "Time : "+currentTime.getHours()%12 + ":" + currentTime.getMinutes() + ":" + currentTime.getSeconds();
  var date = "Today : "+today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate(); 
  document.getElementById("today").innerHTML = date;
  document.getElementById("currentTime").innerHTML = time;
  }, 1000);
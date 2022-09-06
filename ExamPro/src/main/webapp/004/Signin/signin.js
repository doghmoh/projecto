$(document).ready(function(){
    $('#2').click(function() {
        $('.divwel').hide();
        $("#divlog1").show();
        $("#divlog1").attr('style','opacity: 1 ;transition :opacity 0.8s linear;')
    });
    $('#3').click(function() {
        $('.divwel').hide();
        $("#divlog2").show();
        $("#divlog2").attr('style','opacity: 1 ;transition :opacity 0.8s linear;')
    });
    $('#4').click(function() {
        $('.divwel').hide();
        $("#divlog3").show();
        $("#divlog3").attr('style','opacity: 1 ;transition :opacity 0.8s linear;')
    });


});

function eye(){
    const a = document.querySelector(".checkbtn");
  
    if (a.getAttribute("class")== "checkbtn fas fa-eye-slash"){
        a.className="checkbtn fas fa-eye";
    document.getElementById("pw").type="text";}

    else{
        a.className="checkbtn fas fa-eye-slash";
        document.getElementById("pw").type="password";}
}

/*
fetch("../Users/Mohamed/Desktop/example.json")
    .then(function(resp){ 
        return resp.json();
      
    }).then(function(data){

        console.log(data);
    });
    */
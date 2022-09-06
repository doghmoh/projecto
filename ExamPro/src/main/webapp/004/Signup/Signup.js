$(document).ready(function(){
    $('#LoginForm1,#LoginForm2,#LoginForm3').hide();
    $('#2').click(function() {
        $('#HelloBox').hide();
        $("#LoginForm1").show();
        $("#LoginForm1").attr('style','opacity: 1 ;transition :opacity 0.8s linear;');
    });
    $('#3').click(function() {
        $('#HelloBox').hide();
        $("#LoginForm2").show();
        $("#LoginForm2").attr('style','opacity: 1 ;transition :opacity 0.8s linear;');
    });
    $('#4').click(function() {
        $('#HelloBox').hide();
        $("#LoginForm3").show();
        $("#LoginForm3").attr('style','opacity: 1 ;transition :opacity 0.8s linear;');
    });
    $("body").on('click', '.checkbtn', function() {
  $(this).toggleClass("fa-eye fa-eye-slash");
  if ($(".pw").attr("type") === "password") {
    $(".pw").attr("type", "text");
  } else {
    $(".pw").attr("type", "password");
  }

});
$.getJSON('University.json', function(data) {
	$.each(data, function(key,value) { 
             $('.univ').append('<option value="'+ key +'">' + value.name + '</option>');    
        });    
  });
        load_data("Faculte");
        
        
function load_data(id, parent_id){
    var html_code='';
  $.getJSON('Departements.json', function(data) {
      html_code +='<option>' + id + '</option>' ;
	$.each(data, function(key,value) { 
             if(id =="Faculte"){
                 if(value.parent_id == '0'){
                     html_code +='<option value="'+ value.id+'" >' + value.name + '</option>' ;
                 }
             }
             else {
                 if (value.parent_id == parent_id){
                 html_code +='<option value="'+ value.id+'" >' + value.name + '</option>' ;
                  }
             } 
         });
             $('.' + id).html(html_code);
           });
    }
     $(document).on('change', '.Faculte', function() {
         var Faculte_id = $(this).val();
         if (Faculte_id != ''){
             load_data("Departement",Faculte_id);
         } 
         else{
             $('.Departement').html('<option value="">Select departement</option>');
         }
     });
   });
   
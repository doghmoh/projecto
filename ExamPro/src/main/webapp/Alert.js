$(document).ready(function() {

    var opt =0;
    var permession  =false;
    	$(document).on('change','#qtype',function(){
	opt++;
    		if($(this).val() =='QRL-Question a Reponse Unique' ){permession  =false;$('#optionnbr').attr('hidden','true');}
    		else if ($(this).val() =='QCM-Question a Choix Multiple' || $(this).val()=='QCU-Question a Choix Unique'){
		        permession = true;
		        $('#optionnbr').removeAttr('hidden');
    		 }
    		 });
    		 $(document).on('change','#optionnbr',function(){
	         $('#subdiv').remove();
	         if(permession == true){
	         var optnbr= $(this).val();
	         if($('#qtype').val() =='QRL-Question a Reponse Libre' ){}
	         else if ($('#qtype').val() =='QCM-Question a Choix Multiple'){$('#myOptions').append("<div id='subdiv'></div>")
		          for(let i = 0 ; i< optnbr ; i++ ){
    					$('#subdiv').append("<br><input type='checkbox' id='opt"+ opt +"' name ='option'><label for='"+ opt +"'><input type='text'  name ='option' class='form-control m-2'></label><br>")
    		 	}}
             else if ($('#qtype').val() =='QCU-Question a Choix Unique'){
	              $('#myOptions').append("<div id='subdiv'></div>")
		          for(let i = 0 ; i< optnbr ; i++ ){
    					$('#subdiv').append("<br><input type='radio' id='opt"+ opt +"' name ='option'><label for='"+ opt +"'><input type='text'  name ='option' class='form-control m-2'></label><br>")
    		 	} 
	         	}
	         }
	         })
	         $(document).on('dblclick', '#qbank option', function(event) {
        var item = $(event.target).val()
        $("#qbank option").each(function() {
            if ($(this).val() == item) $(this).remove();
        });
        $("#qofexam").append("<option  selected>" + item + "</option>");
    });
    var val=0;
    $(document).on('dblclick', '#qofexam option', function(event) {
        var item = $(event.target).val()
        $("#qofexam option").each(function() {
            if ($(this).val() == item) $(this).remove();
        });
        $("#qbank").append("<option>" + item + "</option>");
    })
    
   
   
});
function process(event) {event.preventDefault();
    const id = event.currentTarget;
    id.nextElementSibling.style.display = 'block'
    
}

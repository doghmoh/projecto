$(document).ready(function() {
      $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#myTab tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });

 $(".mother").click(function(){
	if($(".mother").is(":checked")){$(this).attr("checked","checked");
	$("#myTab tr").find("input:checkbox").each(function(){
	this.checked = true
	$("#deletebutton").css("display","block")
	});
	}
	else { 
	$("#myTab tr").find("input:checkbox:checked").each(function(){
	this.checked =false
	$("#myTab tr").find("input:checkbox").removeAttr("checked");
	$("#deletebutton").css("display","none");
	}); } 

 })
 	
  $("input:checkbox").click(function(){
	if($(this).is(":checked")){
	this.checked = true
	$("#deletebutton").css("display","block")}
	else {	
	this.checked =false
	$("#deletebutton").css("display","none")}
	
	})
	
  $("#deletebutton").click(function(){
	 var list = [];
	 var i = 0;
	$("input:checkbox:checked").each(function(){
		if(i==0){}
		else list.push($(this).parent().next().text())
	   i++;
	})
	var result = list.join(',');
    alert(result)
    $.ajax({
	  url: "AddDelete",
	  type: "post", //send it through get method
	  data: { 
	    "Studentid" : result,
	    "operation" : "deleteall",
	    "table" : "student"
	  },
	  success: function() {
	    window.location = "DisplayAccount?"
	    
	  },
	  error: function(xhr) {
	   console.log("Error........"+ xhr.status);
    }
   });
  });
});
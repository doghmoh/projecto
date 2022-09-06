$(document).ready(function() {
    var myflag = true;
    $("#poper").click(function() {
        if (myflag == true) {
            $(".Aside").css("display", "none");
            $(".GlobalSection").css("margin-left", "0");
            $(".GlobalSection").css("width", "100%");
             $("footer").css({"margin-left": "0","width": "100%"});
            myflag = false;
        } else if (myflag == false) {
            $(".Aside").css("display", "unset");
            $(".GlobalSection").css("margin-left", "20%");
            $(".GlobalSection").css("width", "80%");
             $("footer").css({"margin-left": "20%","width": "80%"});
            myflag = true;
        }
    })

    var flag = true;
    $("#mode1").click(function() {
        if (flag == true) {
            $("#mode1 i ").removeClass()
            $("#mode1 i ").attr("class", "fas fa-toggle-on fa-2x")
            flag = false
        } else if (flag == false) {
            $("#mode1 i ").removeClass()
            $("#mode1 i ").attr("class", "fas fa-toggle-off fa-2x")
            flag = true
        }
    })
    var flagg = false;
     $(document).on('click',"#navaccount",function(e) {
	e.preventDefault();
	   if (flagg == false) {  $("div#stdprof").show(); flagg=true}
	   else if (flagg == true){  $("div#stdprof").hide(); flagg=false}
    });
    
	/* function callernews(){
		$.get({url: "../StartUp"},function(data) {
            $("#hah").html(data);
         });
		console.log(".........ok ")
	};
	setInterval(callernews,3000);*/

})
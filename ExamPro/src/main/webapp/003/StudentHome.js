$(document).ready(function(){ 
  
    $("#Cadre").load("Nav&Side.html")
    var flag=true;
    $("#TrieExamDate").click(function(){
        if(flag==true){
        $("#TrieExamDate i").removeClass();
        $("#TrieExamDate i").addClass("fas fa-arrow-down")
        flag=false;
    }
        else if (flag==false){
            $("#TrieExamDate i").removeClass();
            $("#TrieExamDate i").addClass("fas fa-arrow-up")
            flag=true;
        }
    })
}); 
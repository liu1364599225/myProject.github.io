$(function(){
	$("#searchword").focus(function(){
		$("#searchword").css("width","340px");
		//$("#searchword").animate("width","340px");
	});
	
	$("#searchword").blur(function(){
		$("#searchword").css("width","200px");
		//$("#searchword").animate("width","200px");
	});
	
	$(".left-ul-li").click(function(){
		$(".left-ul-li").css("border","0px");
		$(".left-ul-li").css("background-color","white");
		$(this).css("background-color","#EAF4FE");
		$(this).css("border-left","solid 2px #328FFA")
		console.log($("#input-joinfile"));
	});
	
	//console.log($("#input-joinfile"));
    $("#input-joinfile").change(function(){
    	$("#uploadform").submit();
	});
    
    
});
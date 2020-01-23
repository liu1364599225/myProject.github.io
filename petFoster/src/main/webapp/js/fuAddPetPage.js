$(function(){
	var basePath = "http://localhost:8888/petFoster";
	var prompt = $(".prompt");
	
	$("#petName").blur(function(){
		var xhr = getXMLHttpRequest();
		var value = $("#petName").val();
		var fuId = $("#fuId").val();
		$.post(basePath+'/checkFuPetName1.pet','petName='+value+'&fuId='+fuId,function(data){
			text = data;
			prompt[0].innerText = text;
		},'text');
	});
});
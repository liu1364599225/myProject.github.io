$(function(){
	var basePath = "http://localhost:8888/petFoster";
	var prompt = $(".prompt");
	
	$("#UserName").blur(function(){
		var xhr = getXMLHttpRequest();
		var value = $("#UserName").val();
		$.post(basePath+'/checkFuUserName.pet','userName='+value,function(data){
			text = data;
			prompt[0].innerText = text;
		},'text');
		
	});
	
	$("#password").blur(function(){
		var xhr = getXMLHttpRequest();
		var value = $("#password").val();
		$.post(basePath+'/checkFuPassword.pet','password='+value,function(data){
			text = data;
			prompt[1].innerText = text;
		},'text');
		
	});
	
	$("#againPassword").blur(function(){
		var xhr = getXMLHttpRequest();
		var value = $("#againPassword").val();
		var value1 = $("#password").val();
		$.post(basePath+'/checkFuAgainPassword.pet','againPassword='+value+'&'+'password='+value1,function(data){
			text = data;
			prompt[2].innerText = text;
		},'text');
		
	});
	
	
	$("#contactWay").blur(function(){
		var xhr = getXMLHttpRequest();
		var value = $("#contactWay").val();
		$.post(basePath+'/checkFuContactWay.pet','contactWay='+value,function(data){
			text = data;
			prompt[4].innerText = text;
		},'text');
		
	});
	
	$("#address-a").blur(function(){
		var xhr = getXMLHttpRequest();
		var value = $("#address").val();
		$.post(basePath+'/checkFuAddress.pet','address='+value,function(data){
			text = data;
			prompt[5].innerText = text;
		},'text');
	});
});
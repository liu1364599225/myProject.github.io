$(function(){
	var basePath = window.document.location.href;
	basePath = basePath.substring(0,basePath.lastIndexOf('/'));
	
	$(".avatar-div-div").mousemove(function(){
		$(".avatar-div-div").css("display","inline");
	});
	$(".avatar-div-div").mouseleave(function(){
		$(".avatar-div-div").css("display","none");
	});
	$("#avatar").mousemove(function(){
		$(".avatar-div-div").css("display","inline");
	});
	$("#avatar").mouseleave(function(){
		$(".avatar-div-div").css("display","none");
	});
	
	$(".addButton").click(function(){
		$(".promptBox-text").text("你还未登录，请先登录");
		showPromptBox("loginPrompt");
	});
	
	$(".commentsText").bind('input propertychange',function(){
		var len = $(".commentsText").val().length;
		var words = 200 - len;
		if(words >= 0){
			$("#prompt").text("还能输入");
			$("#words").css("color","gray");
			$("#words").text(words);
		}else{
			$("#prompt").text("已超过");
			$("#words").css("color","red");
			$("#words").text(words * -1);
		}
	});
	
	$("#commitButton").click(function(){
		if($("#userId").val().length == 0){
			showPromptBox("loginPrompt");
			return false;
		}
		
		if($(".commentsText").val().length > 200){
			showPromptBox("wordsPrompt");
			$(".promptBox-text").text("评论字数超出限制");
			return false;
		}
		
		if($(".commentsText").val().length == 0){
			showPromptBox("wordsPrompt");
			$(".promptBox-text").text("评论内容不能为空");
			return false;
		}
		
		var re = new RegExp("^[ ]+$");
		if(re.test($(".commentsText").val())){
			showPromptBox("wordsPrompt");
			$(".promptBox-text").text("评论内容不能为空");
			return false;
		}
		$("#commitButton").attr("href",basePath+"/commitComment.fw?commentText="+$(".commentsText").val()+"&userId="+$("#userId").val());
	});
	
	$(".order-housing").click(function(){
		if($("#userId").val().length == 0){
			showPromptBox("loginPrompt");
			return false;
		}
		if($("#indate").val() == ""){
			showPromptBox("orderPrompt");
			return false;
		}
		$(".order-housing").attr("href",basePath+"/orderHousing.fw?lookingTime="+$("#indate").val()+"&userId="+$("#userId").val());
	});
	
});


function showPromptBox(id){
	$("#"+id).toggle();
}


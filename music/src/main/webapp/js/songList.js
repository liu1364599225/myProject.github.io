$(function(){
	$(".moreDetails").click(function(event){
		//终止事件派发
		event.stopPropagation();
		$(".hidden-div").css("display","inline");
	});
	
	$(document).click(function(event){
		var hiddenClass = $(".hidden-div");
		if(!hiddenClass.is(event.target)&&hiddenClass.has(event.target).length === 0){
			$(".hidden-div").css("display","none");
		}
	});
	
	
	var basePath = window.document.location.href;
	basePath = basePath.substring(0,basePath.lastIndexOf('/'));
	
	$(".downloadSongFile").click(function(){
		$.post(basePath + '/isLoginAndVip.lw',function(data) {
			if(data != ""){
				if(data == "0"){ //0表示未登录
					$(".promptBox-text").text("版权方要求下载此歌曲需付费，请先登录");
					showPromptBox("loginPrompt");
				}else if(data == "1"){ //1表示不是vip
					$(".promptBox-text").text("版权方要求下载此歌曲需付费，开通会员畅享千万歌曲");
					showPromptBox("vipPrompt");
				}
			}
		}, 'text');
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
			return;
		}
		
		if($(".commentsText").val().length > 200){
			showPromptBox("wordsPrompt");
			$(".promptBox-text").text("评论字数超出限制");
			return;
		}
		
		if($(".commentsText").val().length == 0){
			showPromptBox("wordsPrompt");
			$(".promptBox-text").text("评论内容不能为空");
			return;
		}
		$("#commitButton").attr("href",basePath+"/commitComments.lw?commentsText="+$(".commentsText").val());
	});
});


function showPromptBox(id){
	$("#"+id).toggle();
}


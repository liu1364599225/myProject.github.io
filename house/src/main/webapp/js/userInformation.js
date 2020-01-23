$(function() {
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
    
	var basePath = window.document.location.href;
	basePath = basePath.substring(0,basePath.lastIndexOf('/'));
	$(".update-a").click(function(){
		if($(this).text() == "修改"){
			$(this).siblings("input").removeAttr("readonly");
    		$(this).siblings("input").css("border","1px solid #999");
    		$(this).removeClass("btn-default");
    		$(this).addClass("btn-success");
    		$(this).text("保存");
		}else{
			var inputName = $(this).siblings("input").attr("name");
			var inputVal = $(this).siblings("input").val();
			$(this).siblings("input").attr("readonly","readonly");
    		$(this).siblings("input").css("border","0px");
    		$(this).removeClass("btn-success");
    		$(this).addClass("btn-default");
    		$(this).text("修改");
    		
    		$.post(basePath + '/updateUserInformation.fw', inputName+'='+inputVal,
    				function(data) {
    			if("" != data){
    				showPromptBox("wordsPrompt");
    				$(".promptBox-text").text(data);
    			}
			}, 'text');
		}
	});
	
	$(".update-sex").click(function(){
		if($(this).text() == "修改"){
			$(this).siblings("input").removeAttr("disabled");
    		$(this).removeClass("btn-default");
    		$(this).addClass("btn-success");
    		$(this).text("保存");
		}else{
			var inputName = $(this).siblings("input").attr("name");
			var inputVal = "";
			for(var i = 0;i < $(this).siblings("input").length;i++){
				if($(this).siblings("input").get(i).checked == true){
					inputVal = $(this).siblings("input").get(i).value;
				}
			}
			$(this).siblings("input").attr("disabled","disabled");
    		$(this).removeClass("btn-success");
    		$(this).addClass("btn-default");
    		$(this).text("修改");
    		
    		$.post(basePath + '/updateUserInformation.fw', inputName+'='+inputVal,
    				function(data) {
			}, 'text');
		}
	});
	
	$(".update-avatar").click(function(){
		if($(this).text() == "修改"){
    		$('#hiddenFile').click();
    		$(this).removeClass("btn-default");
    		$(this).addClass("btn-success");
    		$(this).text("保存");
		}else{
    		$("#avatarForm").submit();
    		$(this).removeClass("btn-success");
    		$(this).addClass("btn-default");
    		$(this).text("修改");
		}
	});
});

function showPromptBox(id){
	$("#"+id).toggle();
}
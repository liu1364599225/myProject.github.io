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
});
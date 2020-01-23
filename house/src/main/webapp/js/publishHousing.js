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
	var prompt = $(".prompt");
	
	$("#housingPrice").blur(
			function() {
				var value = $("#housingPrice").val();
				$.post(basePath + '/checkPriceAndArea.fw', 'number='
						+ value, function(data) {
					text = data;
					prompt[1].innerText = text;
				}, 'text');
			});

	$("#housingArea").blur(
			function() {
				var value = $("#housingArea").val();
				$.post(basePath + '/checkPriceAndArea.fw', 'number='
						+ value, function(data) {
					text = data;
					prompt[2].innerText = text;
				}, 'text');
			});
});
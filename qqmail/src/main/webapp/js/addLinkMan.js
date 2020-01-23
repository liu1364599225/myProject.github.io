$(function(){
	var basePath = window.document.location.href;
	basePath = basePath.substring(0,basePath.lastIndexOf('/'));
	
	$(".userAccount").blur(function(){
		var userAccount = $(".userAccount").val();
		var str = new RegExp("^\\w{1,11}@qq.com$");
		if(userAccount == ""){
			$(".prompt").text("");
			return;
		}
		if(!str.test(userAccount)){
			$(".prompt").text("邮箱格式不正确");
		}else{
			$(".prompt").text("");
		}
	});
	
	$(".save").click(function(){
		var userAccount = $(".userAccount").val();
		var str = new RegExp("^\\w{1,11}@qq.com$");
		if(userAccount == ""){
			$(".prompt").text("邮箱不能为空");
			return;
		}
		if(!str.test(userAccount)){
			$(".prompt").text("邮箱格式不正确");
		}
		$.post(basePath + '/checkAddresseeMN1.do', 'userAccount='
				+ userAccount, function(data) {
			if("" != data){
				$(".prompt").text(data);
			}else if("" == data){
				if($(".groupId").val() == "---选择通讯组---"){
					$(".prompt").text("请选择一个通讯组");
				}else{
					$(".prompt").text("");
					$("#saveForm").submit();
				}
			}
		}, 'text');
	});
});
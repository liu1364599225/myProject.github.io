function quicklogin(){
	document.getElementById("center-left-a1").style.color="#333333";
	document.getElementById("center-left-a2").style.color="#999999";
	document.getElementById("center-right-bottom2").style.display="block";
	document.getElementById("center-right-bottom1").style.display="none";
}

function accountlogin(){
	document.getElementById("center-left-a2").style.color="#333333";
	document.getElementById("center-left-a1").style.color="#999999";
	document.getElementById("center-right-bottom1").style.display="block";
	document.getElementById("center-right-bottom2").style.display="none";
}

function check(){
	var account = document.getElementById("account");
	var textvalue = document.getElementById("center-center");
	if(account.value == ""){
		textvalue.innerText = "账户名不能为空!!!";
		return false;
	}else if(account.value !=""){
		var password = document.getElementById("password");
		var pos = account.value.lastIndexOf("@qq.com");
		if(pos === -1){
			textvalue.innerText = "账号格式不正确!!!";
			return false;
		}else{
			if(password.value == ""){
				textvalue.innerText = "密码不能为空!!!";
				return false;
			}else{
				$.ajax({
					url:"checkLogin.do?account="+account.value+"&password="+password.value,
				    data:"",
				    dataType:"text",
				    success:function(data){
				       textvalue.innerText = data;
				       if(data == ""){
				    	   location.href="jsp/mail.jsp";//请求成功到达并且检测到可以登录直接跳转页面
				       }
				    }
				});
				return false;
			}
		}
	}
}


$(function(){
	$("#login-bottom").mouseover(function(){
		$("#login-bottom").css("background-color","#6AA2E0");
	});
	
	$("#login-bottom").mouseleave(function(){
		$("#login-bottom").css("background-color","#5A98DE");
	});
});


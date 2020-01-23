$(function(){
	$("#language").mouseover(function(){
		$("#language-change").css("display","inline-block");
	});
	
	$("#language").mouseleave(function(){
		$("#language-change").css("display","none");
	});
	
	$("#changer-mail-type").click(function(){
		if($("#mail-type-ul").css("display") == "none"){
			$("#mail-type-ul").css("display","block");
		}else if($("#mail-type-ul").css("display") == "block"){
			$("#mail-type-ul").css("display","none");
		}
	});
	
	$("#mail-type-ul li").click(function(){
		$("#mail-name").html($(this).text());
		$("#mail-type-ul").css("display","none");
	});
	
	$("#phone-change").click(function(){
		if($("#phone-num-type-ul").css("display") == "none"){
			$("#phone-num-type-ul").css("display","block");
		}else if($("#phone-num-type-ul").css("display") == "block"){
			$("#phone-num-type-ul").css("display","none");
		}
	});
	
	$("#phone-num-type-ul li").click(function(){
		$("#phonenum").html($(this).text().substr($(this).text().lastIndexOf("+")));
		$("#phone-num-type-ul").css("display","none");
	});
	
	$("#mail-account").focus(function(){
		$("#mail-account").css("border","solid 1px #549DF8");
		$("#account-patrn").css("display","none");
		$("#account-tip").css("display","inline-block");
	});
	
	$("#mail-account").blur(function(){
		if($("#mail-account").val() == ""){
			$("#mail-account").css("border","solid 1px #FF5B5B");
			$("#account-patrn").css("display","inline-block");
			$("#account-tip").css("display","none");
			$("#account-patrn").html('<font id="warn-font" class="am-icon-exclamation-circle"></font>邮箱号不能为空 ');
		}else{
			var s = $("#mail-account").val();
			var patrn = /^[0-9a-zA-Z][0-9a-zA-Z@.\-_]{1,16}[0-9a-zA-Z]$/;
			if(patrn.exec(s)){
				$("#account-patrn").css("display","none");
		        $("#account-tip").css("display","inline-block");
		        $("#mail-account").css("border","solid 1px #AAAAAA");
			}else{
				$("#account-patrn").css("display","inline-block");
			    $("#account-tip").css("display","none");
				$("#account-patrn").html('<font id="warn-font" class="am-icon-exclamation-circle"></font>邮箱格式输入错误');
			}
		}
	});
	
	
	$("#nickname").focus(function(){
		$("#nickname").css("border","solid 1px #AAAAAA");
		$("#nickname").css("border","solid 1px #549DF8");
		$("#nickname-tip").css("display","none");
	});
	$("#nickname").blur(function(){
		$("#nickname").css("border","solid 1px #AAAAAA");
		if($("#nickname").val() == ""){
			$("#nickname-tip").css("display","inline-block");
			$("#nickname").css("border","solid 1px #FF5B5B");
		}
	});
	
	
	$("#password").focus(function(){
		$("#password").css("border","solid 1px #549DF8");
		$("#password-div-tip").css("display","inline-block");
		$("#password-warn").css("display","none");
		$("#password-warn").html('<font id="warn-font" class="am-icon-exclamation-circle"></font>密码不能为空');
	});
	$("#password").blur(function(){
		$("#password-div-tip").css("display","none");
		$("#password").css("border","solid 1px #AAAAAA");
		if($("#password").val() == ""){
			$("#password-div-tip").css("display","none");
		    $("#password").css("border","solid 1px #AAAAAA");
		    $("#password-warn").css("display","inline-block");
		    $("#password").css("border","solid 1px #FF5B5B");
		}else{
			var patrn = /(?!^[a-zA-Z]+$)(?!^[\d]+$)(?!^[^a-zA-Z\d]+$)^.{8,16}$/
			var password = $("#password").val();
			if(patrn.exec(password)){
				$("#password").css("border","solid 1px #AAAAAA");
				$("#password-div-tip").css("display","none");
				$("#password-warn").css("display","none");
				$("#password").css("border","solid 1px #AAAAAA");
			}else{
		        $("#password-warn").css("display","inline-block");
		        $("#password-div-tip").css("display","none");
		        $("#password-warn").html('<font id="warn-font" class="am-icon-exclamation-circle"></font>密码不符合规定');
		        $("#password").css("border","solid 1px #FF5B5B");
			}
		}
	});
	
	$("#phone-num").focus(function(){
		
		$("#send").css("display","inline");
		$("#phone-num").css("border","solid 1px #549DF8");
		$("#send-code").css("background-color","#307CEB");
		$("#send-code").css("border","solid 1px #307CEB");
		$("#phone-tip").css("display","inline");
		$("#phone-warn").css("display","none");
	});
	$("#phone-num").blur(function(){
		$("#send").css("display","none");
		var phonenum = $("#phone-num").val();
		var patrn = /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/
		if(phonenum == ""){
			$("#phone-warn").html('<font id="warn-font" class="am-icon-exclamation-circle"></font>电话号码不能为空');
			$("#phone-warn").css("display","inline");
			$("#phone-tip").css("display","none");
			$("#phone-num").css("border","solid 1px #FF5B5B");
		}else{
			if(patrn.exec(phonenum)){
				$("#phone-tip").css("display","inline");
				$("#phone-warn").css("display","none");
				$("#send").css("display","inline");
				$("#send-code").css("background-color","#307CEB");
				$("#send-code").css("border","solid 1px #307CEB");
				$("#send-code").attr("href","");
				$("#phone-num").css("border","solid 1px #AAAAAA");
			}else{
				$("#phone-warn").css("display","inline");
				$("#send").css("display","inline");
				$("#phone-tip").css("display","none");
				$("#phone-warn").html('<font id="warn-font" class="am-icon-exclamation-circle"></font>电话号码格式不正确');
				$("#send-code").css("background-color","#F0F0F0");
				$("#send-code").css("border","solid 1px #F0F0F0");
				$("#send-code").attr("href","javascript:void(0)");
				$("#phone-num").css("border","solid 1px #FF5B5B");
			}
		}
	});
	
	$("#code").focus(function(){
		$("#code").css("border","solid 1px #549DF8");
	});
	$("#code").blur(function(){
		$("#code").css("border","solid 1px #959595");
	});
	
	$("#password1").blur(function(){
		if($("#password").val() != $("#password1").val()){
			$("#password-tip").css("display","inline");
		}else{
			$("#password-tip").css("display","none");
		}
	});
	
	$("#send-code").click(function(){
			$(this).css("background-color","#F0F0F0");
			$(this).css("border","solid 1px #F0F0F0");
			$(this).css("color","white");
			$("#send-code").css("cursor","auto");
			$(this).css("pointer-events","none");
			var i = 59;
			setInterval(function(){
				if(i == 0){
					$("#send-code").css("background-color","#3688FF");
					$("#send-code").css("color","white");
					$("#send-code").text("发送短信验证码");
					$("#send-code").css("cursor","pointer");
					$("#send-code").css("pointer-events","auto");
				}else{
					//console.log($("#send-code").text());
					$("#send-code").text("倒计时("+i+")");
					i = i-1;
				}
			},1000);
			
		$.ajax({
			url:"sendCode.do?tel="+$("#phone-num").val(),
		    data:"",
		    dataType:"text",
		    success:function(data){
		        code = data;
		    }
		});
	});
	
	$("#code").blur(function(){
	    if($("#code").val() != code){
	    	$("#code-tip").css("display","block");
	    }
	});
	
	$("#code").focus(function(){
		$("#code-tip").css("display","none");
	});
});

var img = ['01-3.jpg','01-4.jpg'];
var hr = "img/";
var index = 0;
var taskid = setInterval(function(){
	//图片轮播
	if(img.length == index+1){
		//当图片的下标为最后一张图片的时候那么index要重置为0
		index = 0;
	}else{
		index = index + 1;
	}
	document.getElementById("register-img").src = hr+img[index];
},3000);
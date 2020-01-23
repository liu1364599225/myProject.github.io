var basePath = window.document.location.href;
basePath = basePath.substring(0,basePath.lastIndexOf('/'))+"/";
function all_read(obj){
	var c = document.getElementsByClassName("col-md-1 glyphicon glyphicon-envelope");
	for(var i = 0 ; i < c.length; i++){
		if(c[i].style.color == "darkkhaki"){
			$(c[i]).parent().siblings("input").prop("checked", true);
			//console.log($(c[i]).siblings("input"));
			//$(c[i]).siblings("input").get()[0].checked = true;
			//c[i].previousSibling.checked = true;
		}else{
			$(c[i]).parent().siblings("input").prop("checked", false);
		}
	}
}
//-------------------------------转发------------------------------------------------
function transpond(obj){
	var id = document.getElementById("sendMailId").innerText;
	var time = document.getElementById("time").innerText;
	window.location.href = basePath+"transpond.do?time="+time+"&"+"id="+id;
}
//--------------------------单个未读--------------------------------------------
function noread(obj){
	
	var id = document.getElementById("sendMailId").innerText;
	var time = document.getElementById("time").innerText;
	$.ajax({
		type:"post",
		url:basePath+"noReadFun.do",
		data:"time="+time+"&"+"id="+id,
		success:function(data){
			document.getElementById("noread_mail").innerText = data[0];
			if(data == time){
				//v.parent();
			}
		}
	});
}

//---------------------点击星标按钮改变星标状态-------------------------------------------------
function change_star1(obj){
	var id = document.getElementById("sendMailId").innerText;
	var time = document.getElementById("time").innerText;
	$.ajax({
		type:"post",
		url:basePath+"starColor.do",
		data:"color="+color+"&"+"id="+s22+"&"+"time="+s33,
		success:function(data){
		}
	});
	
	
}
//----------------------------取消星标-------------------------------------------------------
function nochange_star1(obj){
	var id = document.getElementById("sendMailId").innerText;
	var time = document.getElementById("time").innerText;
	$.ajax({
		type:"post",
		url:basePath+"starColor.do",
		data:"color="+"black"+"&"+"id="+s22+"&"+"time="+s33,
		success:function(data){
		}
	});
	
}

//-------------加入已发送----------------------------
function asend(obj){ 
	var id = document.getElementById("sendMailId").innerText;
	var time = document.getElementById("time").innerText;
	$.ajax({
		type:"post",
		url:basePath+"asend.do",
		data:"time="+time+"&"+"id="+id,
		success:function(data){
			
		}
	});
	
}

//-------------------全部标记为已读---------------------------------------------
function asend_box(){
	var id = document.getElementById("sendMailId").innerText;
	var time = document.getElementById("time").innerText;
	$.ajax({
		type:"post",
		url:basePath+"inbox1.do",
		data:"time="+time+"&"+"id="+id,
		success:function(data){
			
		}
	});
}

//-------------------单个已读---------------------------------------------------
function read(obj){
	var id = document.getElementById("sendMailId").innerText;
	var time = document.getElementById("time").innerText;
	$.ajax({
		type:"post",
		url:basePath+"allReadFun.do",
		data:"time="+time+"&"+"id="+id,
		success:function(data){
			document.getElementById("noread_mail").innerText = data[0];
			if(data == time){
				//v.parent();
			}
		}
	});
	
}
//-------------------------------举报------------------------------------------------
function report(obj){
	var id = document.getElementById("sendMailId").innerText;
	var time = document.getElementById("time").innerText;
	alert(id);
	$.ajax({
		type:"post",
		url:basePath+"report.do",
		data:"time="+time+"&"+"id="+id,
		success:function(data){
		}
	});
}

function deleteTrue(obj){  //彻底删除
	var id = document.getElementById("sendMailId").innerText;
	var time = document.getElementById("time").innerText;
	alert(id);
	$.ajax({
		type:"post",
		url:basePath+"deleteTrue.do",
		data:"time="+time+"&"+"id="+id,
		success:function(data){
		}
	});
	
	
	/*var a = document.getElementById("page_num").value-1;
	window.location.href = basePath+"readAll_Inbox.do?pageNum="+a;*/
}
//---------------------------------删除-----------------------------------------------
function delete1(obj){  //加入删除状态
	var id = document.getElementById("sendMailId").innerText;
	var time = document.getElementById("mail_id").innerText;
	alert(time+"1");
	$.ajax({
		type:"post",
		url:basePath+"delete1.do",
		data:"time="+time+"&"+"id="+id,
		success:function(data){
			alert("111");
		}
	});
	/*for(var i = 1 ; i < c.length; i++){
		var b = c[i].checked;
		if(b == true){
			var v = $(c[i]);
			var id = v.siblings()[1].children[0].innerText;
			var time = v.siblings()[3].children[0].innerText;
			v.parent()[0].style.display = "none";
			//var num = v.parent().parent().siblings()[4].children[0].children[0].children[1].innerText;
			//num = num - 1;
			//v.parent().parent().siblings()[4].children[0].children[0].children[1].innerText = num;
			//console.log(v.parent().parent().siblings()[4].children[0].children[0].children[1].innerText);
			
			
		}
	}*/
	/*var a = document.getElementById("page_num").value-1;
	window.location.href = basePath+"readAll_Inbox.do?pageNum="+a;*/
}
function all_noread(obj){
	var c = document.getElementsByClassName("col-md-1 glyphicon glyphicon-envelope");
	for(var i = 0 ; i < c.length; i++){
		if(c[i].style.color == "darkkhaki"){
			console.log($(c[i]).parent().siblings("input"));
			$(c[i]).parent().siblings("input").prop("checked", false);
			//console.log($(c[i]).siblings("input"));
			//$(c[i]).siblings("input").get()[0].checked = true;
			//c[i].previousSibling.checked = true;
		}else{
			console.log($(c[i]).parent().siblings("input"));
			$(c[i]).parent().siblings("input").prop("checked", true);
		}
	}
}
function all_no(obj){
	var c = document.getElementsByClassName("col-md-1");
	for(var i = 0 ; i < c.length; i++){
	c[i].checked = false;
	}
}
function all_check(obj){
	var c = document.getElementsByClassName("col-md-1");
	for(var i = 0 ; i < c.length; i++){
	c[i].checked = true;
	}
}

function change_mail(obj){
	$(obj).children().css("color","darkkhaki");
}
var i = 1;
function change_star(obj){
	
	if(i == 0){
		$(obj).css("color","slategray");
		i = 1;
	}else{
		$(obj).css("color","#FAD04D");
		i = 0;
	}
}

function change_color(obj){
	var s1 = $(obj).parent();
	var s2 = $(obj).is(":checked");
	if(s2 == true){
		s1.css("background-color","#528BCB");
	}else{
		s1.css("background-color","white");
	}
	
}
function yc(){
	$("#yc_div_1").css("display","inline");
}
function yc_l(){
	$("#yc_div_1").css("display","none");
}
function on_back(obj){
	$(obj).css("display","none");
	$(obj).next().css("display","inline");
}

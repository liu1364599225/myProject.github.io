//var basePath = "http://localhost:8888/qqmail/";
var basePath = window.document.location.href;
basePath = basePath.substring(0,basePath.lastIndexOf('/'))+"/";
//var basePath = window.document.location.href;
function all_read(obj){  //已读邮件
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
//-------------跳转页面---------------------------------------
function page_t(obj){
	var a = document.getElementById("page_num").value-1;
	
	window.location.href = basePath+"readAll_Garbage.do?pageNum="+a;
}
//-------------------单个已读---------------------------------------------------
function read(obj){
	var c = document.getElementsByClassName("col-md-1 1");
	for(var i = 1 ; i < c.length; i++){
		var b = c[i].checked;
		if(b == true){
			var v = $(c[i]);
			var id = v.siblings()[1].children[0].innerText;
			var time = v.siblings()[3].children[0].innerText;
			var b = c[i].checked;
			if(b == true){
				v.siblings()[0].children[0].style.color = "darkkhaki";
				$.ajax({
					type:"post",
					url:basePath+"allReadFun3.do",
					data:"time="+time+"&"+"id="+id,
					success:function(data){
						document.getElementById("noread_mail").innerText = data[0];
						if(data == time){
							//v.parent();
						}
					}
				});
			}
		}
	}
}

//--------------------------单个未读--------------------------------------------
function noread(obj){
	var c = document.getElementsByClassName("col-md-1 1");
	for(var i = 1 ; i < c.length; i++){
		var b = c[i].checked;
		if(b == true){
			var v = $(c[i]);
			var id = v.siblings()[1].children[0].innerText;
			var time = v.siblings()[3].children[0].innerText;
			var b = c[i].checked;
			if(b == true){
				v.siblings()[0].children[0].style.color = "#FAD04D";
				$.ajax({
					type:"post",
					url:basePath+"noReadFun3.do",
					data:"time="+time+"&"+"id="+id,
					success:function(data){
						document.getElementById("noread_mail").innerText = data[0];
						if(data == time){
							//v.parent();
						}
					}
				});
			}
		}
	}
}
//-------------------全部标记为已读---------------------------------------------
function asend_box(){
	var c = document.getElementsByClassName("col-md-1 1");
	for(var i = 1 ; i < c.length; i++){
		var b = c[i].checked;
		if(b == true){
			var v = $(c[i]);
			var id = v.siblings()[1].children[0].innerText;
			var time = v.siblings()[3].children[0].innerText;
			v.parent()[0].style.display = "none";
			$.ajax({
				type:"post",
				url:basePath+"inbox3.do",
				data:"time="+time+"&"+"id="+id,
				success:function(data){
					document.getElementById("all_mail_num").innerText = data[0];
					document.getElementById("head5_child1_span1_1").innerText = data[1];
					document.getElementById("head5_child1_span1_2").innerText = data[2];
					document.getElementById("head5_child1_span1_3").innerText = data[3];
					document.getElementById("head5_child1_span1_4").innerText = data[4];
					document.getElementById("head5_child1_span1_5").innerText = data[5];
					document.getElementById("head5_child1_span1_6").innerText = data[6];
					document.getElementById("head5_child1_span1_7").innerText = data[7];
					document.getElementById("head5_child1_span1_8").innerText = data[8];
					document.getElementById("head5_child1_span1_9").innerText = data[9];
					document.getElementById("noread_mail").innerText = data[10];
					if(data == time){
						//v.parent();
						v.parent()[0].style.display = "none";
					}
				}
			});
		}
	}
}
function nextPage(obj){
	
}

function all_read_fun(obj){
	var c = document.getElementsByClassName("col-md-1 1");
	
	for(var i = 1 ; i < c.length; i++){
		var b = c[i].checked;
			var v = $(c[i]);
			var id = v.siblings()[1].children[0].innerText;
			var time = v.siblings()[3].children[0].innerText;
			v.siblings()[0].children[0].style.color = "darkkhaki";
			
			$.ajax({
				type:"post",
				url:basePath+"allReadFun3.do",
				data:"time="+time+"&"+"id="+id,
				success:function(data){
					
				}
			});
	}
	
}
function deleteTrue(obj){  //彻底删除
	var c = document.getElementsByClassName("col-md-1 1");
	for(var i = 1 ; i < c.length; i++){
		var b = c[i].checked;
		if(b == true){
			var v = $(c[i]);
			var id = v.siblings()[1].children[0].innerText;
			var time = v.siblings()[3].children[0].innerText;
			v.parent()[0].style.display = "none";
			$.ajax({
				type:"post",
				url:basePath+"deleteTrue3.do",
				data:"time="+time+"&"+"id="+id,
				success:function(data){
					
				}
			});
		}
	}
	/*var a = document.getElementById("page_num").value-1;
	window.location.href = basePath+"readAll_Inbox.do?pageNum="+a;*/
}
//-------------加入已发送----------------------------
function asend(obj){ 
	console.log(11);
	var c = document.getElementsByClassName("col-md-1 1");
	for(var i = 1 ; i < c.length; i++){
		var b = c[i].checked;
		if(b == true){
			var v = $(c[i]);
			var id = v.siblings()[1].children[0].innerText;
			var time = v.siblings()[3].children[0].innerText;
			v.parent()[0].style.display = "none";
			$.ajax({
				type:"post",
				url:basePath+"asend3.do",
				data:"time="+time+"&"+"id="+id,
				success:function(data){
					document.getElementById("all_mail_num").innerText = data[0];
					document.getElementById("head5_child1_span1_1").innerText = data[1];
					document.getElementById("head5_child1_span1_2").innerText = data[2];
					document.getElementById("head5_child1_span1_3").innerText = data[3];
					document.getElementById("head5_child1_span1_4").innerText = data[4];
					document.getElementById("head5_child1_span1_5").innerText = data[5];
					document.getElementById("head5_child1_span1_6").innerText = data[6];
					document.getElementById("head5_child1_span1_7").innerText = data[7];
					document.getElementById("head5_child1_span1_8").innerText = data[8];
					document.getElementById("head5_child1_span1_9").innerText = data[9];
					document.getElementById("noread_mail").innerText = data[10];
					if(data == time){
						//v.parent();
						v.parent()[0].style.display = "none";
					}
				}
			});
		}
	}
}
//-------------------------------跳转二级页面--------------------------------------------
function second(obj,time1,id){
	var ti = $(obj).parent().siblings()[3].children[0].innerText;
	window.location.href=basePath+"second.do?time1="+ti+"&"+"sendId="+id;
}
//-------------------------------转发------------------------------------------------
function transpond(obj){
	var c = document.getElementsByClassName("col-md-1 1");
	for(var i = 1 ; i < c.length; i++){
		var b = c[i].checked;
		if(b == true){
			var v = $(c[i]);
			var id = v.siblings()[1].children[0].innerText;
			var time = v.siblings()[3].children[0].innerText;
			window.location.href = basePath+"transpond.do?time="+time+"&"+"id="+id;
			
		}
	}
}

//-------------------------------举报------------------------------------------------
function report(obj){
	var c = document.getElementsByClassName("col-md-1 1");
	for(var i = 1 ; i < c.length; i++){
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
			$.ajax({
				type:"post",
				url:basePath+"report3.do",
				data:"time="+time+"&"+"id="+id,
				success:function(data){
					console.log(document.getElementById("all_mail_num").innerText);
					document.getElementById("all_mail_num").innerText = data[0];
					document.getElementById("head5_child1_span1_1").innerText = data[1];
					document.getElementById("head5_child1_span1_2").innerText = data[2];
					document.getElementById("head5_child1_span1_3").innerText = data[3];
					document.getElementById("head5_child1_span1_4").innerText = data[4];
					document.getElementById("head5_child1_span1_5").innerText = data[5];
					document.getElementById("head5_child1_span1_6").innerText = data[6];
					document.getElementById("head5_child1_span1_7").innerText = data[7];
					document.getElementById("head5_child1_span1_8").innerText = data[8];
					document.getElementById("head5_child1_span1_9").innerText = data[9];
					document.getElementById("noread_mail").innerText = data[10];
					console.log(data);
					if(data[0]== time){
						//v.parent();
						console.log(data[0]);
					}
				}
			});
		}
	}
}

function delete1(obj){  //加入删除状态
	var c = document.getElementsByClassName("col-md-1 1");
	for(var i = 1 ; i < c.length; i++){
		var b = c[i].checked;
		if(b == true){
			var v = $(c[i]);
			var id = v.siblings()[1].children[0].innerText;
			var time = v.siblings()[3].children[0].innerText;
			alert(time);
			v.parent()[0].style.display = "none";
			//var num = v.parent().parent().siblings()[4].children[0].children[0].children[1].innerText;
			//num = num - 1;
			//v.parent().parent().siblings()[4].children[0].children[0].children[1].innerText = num;
			//console.log(v.parent().parent().siblings()[4].children[0].children[0].children[1].innerText);
			$.ajax({
				type:"post",
				url:basePath+"delete4.do",
				data:"time="+time+"&"+"id="+id,
				success:function(data){
					console.log(document.getElementById("all_mail_num").innerText);
					document.getElementById("all_mail_num").innerText = data[0];
					document.getElementById("head5_child1_span1_1").innerText = data[1];
					document.getElementById("head5_child1_span1_2").innerText = data[2];
					document.getElementById("head5_child1_span1_3").innerText = data[3];
					document.getElementById("head5_child1_span1_4").innerText = data[4];
					document.getElementById("head5_child1_span1_5").innerText = data[5];
					document.getElementById("head5_child1_span1_6").innerText = data[6];
					document.getElementById("head5_child1_span1_7").innerText = data[7];
					document.getElementById("head5_child1_span1_8").innerText = data[8];
					document.getElementById("head5_child1_span1_9").innerText = data[9];
					document.getElementById("noread_mail").innerText = data[10];
					console.log(data);
					if(data[0]== time){
						//v.parent();
						console.log(data[0]);
					}
				}
			});
			
		}
	}
	/*var a = document.getElementById("page_num").value-1;
	window.location.href = basePath+"readAll_Inbox.do?pageNum="+a;*/
}
function main_slect(){ //勾选全选选择框
	var s1 = document.getElementById("main-select");
	var c = document.getElementsByClassName("col-md-1 1");
	if(s1.checked == true){
		for(var i = 0 ; i < c.length; i++){
			c[i].checked = true;
		}
	}else{
			for(var i = 0 ; i < c.length; i++){
			c[i].checked = false;
		}
	}
}
function all_noread(obj){ //未读邮件
	var c = document.getElementsByClassName("col-md-1 glyphicon glyphicon-envelope");
	for(var i = 0 ; i < c.length; i++){
		if(c[i].style.color == "darkkhaki"){
			$(c[i]).parent().siblings("input").prop("checked", false);
			//$(c[i]).siblings("input").get()[0].checked = true;
			//c[i].previousSibling.checked = true;
		}else{
			$(c[i]).parent().siblings("input").prop("checked", true);
		}
	}
}
function all_no(obj){  //勾全选按钮 为false，全不选
	var c = document.getElementsByClassName("col-md-1 1");
	for(var i = 0 ; i < c.length; i++){
	c[i].checked = false;
	}
}
function all_check(obj){ //全选
	var c = document.getElementsByClassName("col-md-1 1");
	
	for(var i = 0 ; i < c.length; i++){
	c[i].checked = true;
	}
}

function change_mail(obj){
	$(obj).children().css("color","darkkhaki");
	var s11 = $(obj).children().css("color");
	var s22 = $(obj).siblings()[1].children[0].innerText;
	var s33 = $(obj).siblings()[3].children[0].innerText;
	$.ajax({
		type:"post",
		url:basePath+"mailColor.do",
		data:"name="+s11+"&"+"id="+s22+"&"+"time="+s33,
		success:function(data){

		}
	});
}
//---------------------点击星标按钮改变星标状态-------------------------------------------------
function change_star1(obj){
	var c = document.getElementsByClassName("col-md-1 1");
	for(var i = 1 ; i < c.length; i++){
		var b = c[i].checked;
		if(b == true){
			var v = $(c[i]);
			var s22 = v.siblings()[1].children[0].innerText;
			var s33 = v.siblings()[3].children[0].innerText;
			console.log(v.siblings()[4].children[0].style.color);
			
			if(v.siblings()[4].children[0].style.color == "black"){
				
				v.siblings()[4].children[0].style.color = "#FAD04D";
				
			}else if(v.siblings()[4].children[0].style.color == "rgb(250, 208, 77)"){
				v.siblings()[4].children[0].style.color = "black";
				//$(obj).css("color","#FAD04D");
			}
			var color = v.siblings()[4].children[0].style.color;
			var b = c[i].checked;
			if(b == true){
				v.siblings()[4].children[0].style.color = "#FAD04D";
				$.ajax({
					type:"post",
					url:basePath+"starColor.do",
					data:"color="+color+"&"+"id="+s22+"&"+"time="+s33,
					success:function(data){
					}
				});
			}
		}
	}
}

//----------------------------取消星标-------------------------------------------------------
function nochange_star1(obj){
	var c = document.getElementsByClassName("col-md-1 1");
	for(var i = 1 ; i < c.length; i++){
		var b = c[i].checked;
		if(b == true){
			var v = $(c[i]);
			var s22 = v.siblings()[1].children[0].innerText;
			var s33 = v.siblings()[3].children[0].innerText;
			console.log(v.siblings()[4].children[0].style.color);
			
			if(v.siblings()[4].children[0].style.color == "black"){
				
				v.siblings()[4].children[0].style.color = "#FAD04D";
				
			}else if(v.siblings()[4].children[0].style.color == "rgb(250, 208, 77)"){
				v.siblings()[4].children[0].style.color = "black";
				//$(obj).css("color","#FAD04D");
			}
			var color = v.siblings()[4].children[0].style.color;
			var b = c[i].checked;
			if(b == true){
				v.siblings()[4].children[0].style.color = "black";
				$.ajax({
					type:"post",
					url:basePath+"starColor.do",
					data:"color="+color+"&"+"id="+s22+"&"+"time="+s33,
					success:function(data){
					}
				});
			}
		}
	}
}
function change_star(obj){  //星标状态
	if($(obj).children()[0].style.color == "black"){
		
		$(obj).children()[0].style.color = "#FAD04D";
		
	}else if($(obj).children()[0].style.color == "rgb(250, 208, 77)"){
		$(obj).children()[0].style.color = "black";
		//$(obj).css("color","#FAD04D");
	}
	var color = $(obj).children()[0].style.color;
	var s22 = $(obj).siblings()[2].children[0].innerText;
	var s33 = $(obj).siblings()[4].children[0].innerText;
	$.ajax({
		type:"post",
		url:basePath+"starColor.do",
		data:"color="+color+"&"+"id="+s22+"&"+"time="+s33,
		success:function(data){
			
		}
	});
	
	
}

function change_color(obj){ //改变center容器的颜色
	var s1 = $(obj).parent();
	var s2 = $(obj).is(":checked");
	if(s2 == true){
		s1.css("background-color","#528BCB");
	}else{
		s1.css("background-color","white");
	}
	
}
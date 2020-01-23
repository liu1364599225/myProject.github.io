$(function(){
	
	var basePath = window.document.location.href;
	basePath = basePath.substring(0,basePath.lastIndexOf('/'));
	
	//富文本js
	var editor1;
	KindEditor.ready(function(K) {
		editor1 = K.create('textarea[name="main_body"]', {
			resizeType : 0,	// 2时可以拖动改变宽度和高度，1时只能改变高度，0时不能拖动。
			themeType : 'simple',//更换主题
//			items:[//菜单栏配置
//			      
//			      ],
			cssPath : basePath+'/kindeditor/plugins/code/prettify.css',
			uploadJson : basePath+'/kindeditor/jsp/upload_json.jsp',
			fileManagerJson : basePath+'/kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function() {
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
			}
		});
	
		prettyPrint();
	});
	
	
	$(".body3-right-title").click(function(){
		var c = $(".body3-right-title");
		var mailList = $(".mailList");
		for(var i = 0; i < c.length;i++){
			c[i].style.backgroundColor = "#EFF5FB";
			c[i].style.border = "1px solid #7F9DB9";
			c[i].style.borderTop = "0px";
			c[i].style.color = "#1e5494";
			c[i].style.fontWeight = "normal";
			if($(this).is(c[i])){
				mailList[i].style.display = "inherit";
			}else{
				mailList[i].style.display = "none";
			}
		}
		$(this).css("background-color","white");
		$(this).css("color","black");
		$(this).css("font-weight","bold");
		$(this).css("border","0px");
	});
	
	
	$(".body3-right-title").mousemove(function(){
		if($(this).css("background-color") == "rgb(239, 245, 251)"){
			$(this).css("background-color","#7F9DB9");
		}
	});
	
	$(".body3-right-title").mouseleave(function(){
		if($(this).css("background-color") == "rgb(127, 157, 185)"){
			$(this).css("background-color","rgb(239, 245, 251)");
		}
	});
	
	
	$("#input2-right").click(function(){
		$("#text-div-hidden").css("display","inline");
	});
	
	$("#text-div-hidden").mouseleave(function(){
		$("#text-div-hidden").css("display","none");
	});
	
	$(".text-div-hidden-text").mousemove(function(){
		var c = $(".text-div-hidden-text");
		for(var i = 0; i < c.length;i++){
			c[i].style.backgroundColor = "white";
		}
		$(this).css("background-color","blue");
	});
	
	$(".text-div-hidden-text").mouseleave(function(){
		var c = $(".text-div-hidden-text");
		for(var i = 0; i < c.length;i++){
			c[i].style.backgroundColor = "white";
		}
	});
	
	$(".text-div-hidden-text").click(function(){
		var c = $(".text-div-hidden-text");
		var id = $("#input2");
		for(var i = 0; i < c.length;i++){
			if($(this).is(c[0])){
				id.css("color","#FB5903");
			}
			if($(this).is(c[1])){
				id.css("color","#008000");
			}
			if($(this).is(c[2])){
				id.css("color","#A60AF4");
			}
			if($(this).is(c[3])){
				id.css("color","black");
			}
		}
		$(this).css("background-color","blue");
	});
	
	$("#caret-right").click(function(){
		$(".body3-right").css("display","none");
		$(".body3-right1").css("display","none");
		$(".body3-left").css("width","99%");
		$(".ke-container-simple").css("width","100%");
		$("#caret-left").css("display","inline");
		$("#caret-right").css("display","none");
	});
	
	$("#caret-left").click(function(){
		$(".body3-right").css("display","inline");
		$(".body3-right1").css("display","inline");
		$(".body3-left").css("width","82%");
		$("#caret-right").css("display","inline");
		$("#caret-left").css("display","none");
	});
	
	$(".contactsList").mousemove(function(){
		var c = $(".contactsList");
		for(var i = 0; i < c.length;i++){
			c[i].style.backgroundColor = "white";
		}
		$(this).css("background-color","#FFF6DF");
	});
	
	$(".contactsList").mouseleave(function(){
		var c = $(".contactsList");
		for(var i = 0; i < c.length;i++){
			c[i].style.backgroundColor = "white";
		}
	});
	

	$(".contactsList").click(function(){
		var selectVal = $(this).text();
		$(".input1").val(selectVal);
	});
	
	$(".send").click(function(){
		$("#message").css("background-color","#eaa000");
		if($(".input1").val() == ""){
			$("#message").css("display","inline");
			$("#message").text("请选择一个通讯组");
			return;
		}
		if($(".input2").val() == ""){
			$("#message").css("display","inline");
			$("#message").text("请填写邮件主题");
			return;
		}
		$("#writerForm").attr("action",basePath+"/sendGroupMail.do");
		$(".richText1").val(editor1.html());
		$("#writerForm").submit();
	})
	
	//通过ajax存草稿箱
	$(".draft").click(function(){
		var mailNumber = $(".input1").val();
		var motive = $(".input2").val();
		var main_body = editor1.html();
		$.ajax({
			"url":basePath + '/saveDraft.do',
			"type":"post",
			"data":{mailNumber:mailNumber,motive:motive,main_body:main_body},  
			"dataType":"text",
			"success":function(data){
				$("#success").text(data);
				$("#success").css("display","inline");
				$("#message").css("display","none");
			}
		});
	});
	
	//跳转到普通邮件预览页面
	$(".preview").click(function(){
		$("#writerForm").attr("action",basePath+"/previewWLPage.do");
		$("#writerForm").attr("target","_blank");
		$(".richText1").val(editor1.html());
		$("#writerForm").submit();
	});
});

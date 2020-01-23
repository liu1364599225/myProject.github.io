$(function(){
	
	var basePath = window.document.location.href;
	basePath = basePath.substring(0,basePath.lastIndexOf('/'));
	
	$(document).on("click",".notepaper",function(){
		var notepaper = $(".notepaper");
		var notepaperImg = $(".notepaperImg");
		for(var j = 0;j < notepaper.length;j++){
			if($(this).is(notepaper[j])){
				var imgSrc = "../qqmail"+notepaperImg[j].src.split("qqmail")[1];
				var notepaperId = $(notepaperImg[j]).next("input").val();
				$("#notepaperId").val(notepaperId);
/*富文本中的对象*/	$(".ke-container-simple").css("background","url("+imgSrc+") center");
				$(".ke-container-simple").css("background-size","100%");
			}
		}
	});
	
	//不使用信纸
	$(document).on("click",".notepaper1",function(){
		var notepaper = $(".notepaper1");
		for(var j = 0;j < notepaper.length;j++){
			if($(this).is(notepaper[j])){
				$("#notepaperId").val("");
/*富文本中的对象*/	$(".ke-container-simple").css("background","");
				$(".ke-container-simple").css("background-size","");
			}
		}
	});
	
	$(document).on("mousemove",".notepaper",function(){
		var notepaper = $(".notepaper");
		for(var i = 0;i < notepaper.length;i++){
			notepaper[i].style.border = "1px solid #b8bfd0";
		}
		$(this).css("border","2px solid yellow");
	});
	
	$(document).on("mouseleave",".notepaper",function(){
		$(this).css("border","1px solid #b8bfd0");
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
	
	$(".groupName").click(function(){
		var groupName = $(".groupName");
		var teamMembers = $(".teamMembers");
		var plus = $(".plus");
		var checkAll = $(".checkAll");
		for(var i = 0;i < groupName.length;i++){
			if($(this).is(groupName[i])){
				if(plus[i].innerText == "+"){
					checkAll[i].style.display = "inline";
					teamMembers[i].style.display = "inline";
					plus[i].innerText = "-";
				}else{
					checkAll[i].style.display = "none";
					teamMembers[i].style.display = "none";
					plus[i].innerText = "+";
				}
				continue;
			}
			checkAll[i].style.display = "none";
			teamMembers[i].style.display = "none";
			plus[i].innerText = "+";
		}
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
	
	$(document).on("mousemove",".contactsList1",function(){
		var c = $(".contactsList1");
		for(var i = 0; i < c.length;i++){
			c[i].style.backgroundColor = "white";
		}
		$(this).css("background-color","#FFEEC2");
	});
	
	$(document).on("mouseleave",".contactsList1",function(){
		var c = $(".contactsList1");
		for(var i = 0; i < c.length;i++){
			c[i].style.backgroundColor = "white";
		}
	});
	
	$(".groupName").mousemove(function(){
		var c = $(".groupName");
		for(var i = 0; i < c.length;i++){
			c[i].style.backgroundColor = "white";
		}
		$(this).css("background-color","#FFF6DF");
	});
	
	$(".groupName").mouseleave(function(){
		var c = $(".groupName");
		for(var i = 0; i < c.length;i++){
			c[i].style.backgroundColor = "white";
		}
	});
	
	
	$(".newNotepaper").click(function(event){
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
	
	$("#cancel").click(function(){
		$(".hidden-div").css("display","none");
	});
	
	
	//选择联系人，添加到收件人input框中
	$(".contactsList").click(function(){
		var userName = $(this).text();
		var mailNumber = $(this).next("input").val();
		var inputVal = $(".input1").val();
		//判断收件人input框中的邮件格式是否以";"结尾，如果不是则加上";"
		if(!inputVal.endsWith(";") && "" != inputVal){
			$(".input1").val(inputVal+";");
			inputVal = $(".input1").val();
		}
		var userAccount = userName+"<"+mailNumber+">;";
		var val = inputVal.split(";");
		for(var i = 0;i < val.length;i++){
			var startIndex = val[i].indexOf("<");
			var endIndex = val[i].indexOf(">");
			var subStr = val[i].substring(startIndex+1,endIndex);
			if(mailNumber == subStr){
				return;
			}
		}
		$(".input1").val(inputVal+userAccount);
		
	});
	
	//选择查询到联系人，添加到收件人input框中
	$(document).on("click",".contactsList1",function(){
		var contactsList1 = $(".contactsList1");
		var nickname = $(".nickname");
		var nlinkmanMN = $(".nlinkmanMN");
		var inputVal = $(".input1").val();
		//判断收件人input框中的邮件格式是否以";"结尾，如果不是则加上";"
		if(!inputVal.endsWith(";") && "" != inputVal){
			$(".input1").val(inputVal+";");
			inputVal = $(".input1").val();
		}
		for(var i = 0;i < contactsList1.length;i++){
			if($(this).is(contactsList1[i])){
				var userName = nickname[i].innerText;
				var mailNumber = nlinkmanMN[i].innerText;
				var userAccount = userName+"<"+mailNumber+">;";
				var val = inputVal.split(";");
				for(var j = 0;j < val.length;j++){
					var startIndex = val[j].indexOf("<");
					var endIndex = val[j].indexOf(">");
					var subStr = val[j].substring(startIndex+1,endIndex);
					if(mailNumber == subStr){
						return;
					}
				}
				$(".input1").val(inputVal+userAccount);
			}
		}
	});
	
	//全选联系人，添加到收件人input框中
	$(".checkAll").click(function(){
		var checkAll = $(".checkAll");
		var inputVal = $(".input1").val();
		//判断收件人input框中的邮件格式是否以";"结尾，如果不是则加上";"
		if(!inputVal.endsWith(";") && "" != inputVal){
			$(".input1").val(inputVal+";");
			inputVal = $(".input1").val();
		}
		var teamMembers = $(".teamMembers");
		var val = inputVal.split(";");
		for(var i = 0;i < checkAll.length;i++){
			if($(this).is(checkAll[i])){
				//拿到当前通讯组下所有的用户名和邮箱号对象
				var userNames =  $(teamMembers[i]).children("div");
				var mailNumbers =  $(teamMembers[i]).children("input");
				for(var j = 0;j < userNames.length;j++){
					var times = 0;
					for(var m = 0;m < val.length;m++){
						var startIndex = val[m].indexOf("<");
						var endIndex = val[m].indexOf(">");
						var subStr = val[m].substring(startIndex+1,endIndex);
						if(mailNumbers[j].value == subStr){
							times = times + 1;
							break;
						}
					}
					if(times == 0){
						var userName = userNames[j].innerText;
						var mailNumber = "<"+mailNumbers[j].value+">;";
						var userAccount = userName+mailNumber;
						$(".input1").val($(".input1").val()+userAccount);
					}
				}
			}
		}
	});
	
	//收件人邮箱格式校验
	$(".input1").blur(function(){
		$("#success").css("display","none");
		var inputVal = $(".input1").val();
		if("" == inputVal){
			$("#message").css("display","none");
			return;
		}else if(!inputVal.endsWith(";") && "" != inputVal){
			$(".input1").val(inputVal+";");
			inputVal = $(".input1").val();
		}
		var str = new RegExp("^[\u4e00-\u9fa5_0-9_a-zA-Z]{0,11}[<][0-9_a-zA-Z]{3,11}[@][q][q][.][c][o][m][>]$");
		var values = this.value.split(";");
		for(var i = 0;i < values.length;i++){
			if(values[i] != ""){
				if(! str.test(values[i])){
					$("#message-div1").text(values[i]);
					$("#message-div2").text("邮箱号格式不正确");
					//如果邮箱格式不正确，则将提示信息div显示
					$("#message").css("display","inline");
					return;
				}

				//校验收件人input框中是否有相同的邮箱号，如果有就删除其他的，只保留一个
				var addresseeInput = $(".input1").val();
				var startIndex = values[i].indexOf("<");
				var endIndex = values[i].indexOf(">");
				var subStr = values[i].substring(startIndex,endIndex+1);
				
				var times = addresseeInput.split(subStr).length - 1;
				if(times > 1){
					var newInput = addresseeInput.replace(values[i]+";","");
					$(".input1").val(newInput);
				}
			}
		}
		
		//通过ajax判断邮箱地址是否存在
		var xhr = getXMLHttpRequest();
		var valueToAjax = $(".input1").val();
		$.post(basePath + '/checkAddresseeMN.do', 'inputVal='
				+ valueToAjax, function(data) {
			if("" != data){
				$("#message").css("display","inline");
				$("#message-div1").text(data);
				$("#message-div2").text("邮箱地址不存在");
			}else{
				$("#message").css("display","none");
			}
		}, 'text');
		
	});
	
	
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
	
	
	//发送邮件链接和校验
	$(".send").click(function(){

		$("#success").css("display","none");
		var inputVal = $(".input1").val();
		var times = 0;
		
		var values = inputVal.split(";");
		for(var i = 0;i < values.length - 1;i++){
			if("" == values[i]){
				times ++;
			}
		}
		if(times == values.length - 1){
			$("#message").css("display","inline");
			$("#message-div1").text("收件人地址不能为空");
			$("#message-div2").text("");
		}
		
		//如果邮箱号格式不正确就在原页面显示提示信息，并且不能跳到发送邮件控制器方法
		var str = new RegExp("^[\u4e00-\u9fa5_0-9_a-zA-Z]{0,11}[<][0-9_a-zA-Z]{1,11}[@][q][q][.][c][o][m][>]$");
		for(var i = 0;i < values.length;i++){
			if(values[i] != ""){
				if(! str.test(values[i])){
					$("#message-div1").text(values[i]);
					$("#message-div2").text("邮箱号格式不正确");
					//如果邮箱格式不正确，则将提示信息div显示
					$("#message").css("display","inline");
					return;
				}
			}
		}
		
		//通过ajax判断邮箱地址是否存在
		var xhr = getXMLHttpRequest();
		var valueToAjax = $(".input1").val();
		$.post(basePath + '/checkAddresseeMN.do', 'inputVal='
				+ valueToAjax, function(data) {
			if("" != data){
				$("#message-div1").text(data);
				$("#message-div2").text("邮箱地址不存在");
				$("#message").css("display","inline");
				
			//如果邮件地址存在则判断是否收件人input框的值是否为空，如果不为空则提交表单到发邮件控制器类的方法中
			}else if("" != inputVal && !(times == values.length - 1)){
					$("#writerForm").attr("action",basePath+"/sendMail.do");
					$(".richText").val(editor1.html());
					$("#writerForm").submit();
			}
		}, 'text');
	});
	
	//通过ajax存草稿箱
	$(".draft").click(function(){
		var mailNumber = $(".input1").val();
		var motive = $(".input2").val();
		var notepaperId = $("#notepaperId").val();
		var main_body = editor1.html();
		
		$.ajax({
			"url":basePath + '/saveDraft.do',
			"type":"post",
			"data":{mailNumber:mailNumber,notepaperId:notepaperId,motive:motive,main_body:main_body},  
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
		$(".richText").val(editor1.html());
		$("#writerForm").submit();
	});
	
	//搜索框模糊匹配    IE9 以下是不支持的 oninput事件	propertychange方法IE专有
	$(".search-input").bind('input propertychange',function(){
		var inputVal = $(".search-input").val();
		if("" == inputVal){
			$(".mail").css("display","block");
			$(".select").css("display","none");
			$(".close-div").attr("class","am-icon-search close-div");
			return;
		}
		$(".close-div").attr("class","am-icon-remove close-div");
		$(".mail").css("display","none");
		$(".select").css("display","block");
		var linkmanList = $(".linkmanList");
		linkmanList.html("");
		var htmlVal = "";
		$.post(basePath+'/selectLike.do','inputVal='+inputVal,function(data) {
			if(data.length == 0){
				linkmanList.html("没有符合条件的联系人");
				return;
			}
			for(var i = 0;i < data.length;i++){
				htmlVal +="<div class=\"contactsList1\">"+
					"<div class=\"nickname\">"+data[i].nickname+"</div>"+
					"<div class=\"nlinkmanMN\">"+data[i].user_account+"</div>"+
				"</div>";
			}
			linkmanList.html(htmlVal);
		},'json');
	});
	
	//关闭搜索功能页面
	$(".close-div").click(function(){
		if($(".close-div").attr("class") == "am-icon-remove close-div"){
			$(".close-div").attr("class","am-icon-search close-div");
			$(".search-input").val("");
			$(".mail").css("display","block");
			$(".select").css("display","none");
		}
	});
	
	//上一页信纸
	$(".left-span").click(function(){
		var pageNum = $(".pageNum").text();
		if(pageNum <= 1){
			return;
		}else{
			$(".right-span").css("color","blue");
			$.ajax({
				"url":basePath + '/lastlistOnePageData.do',
				"type":"post",
				"data":{pageNum:pageNum},
				"dataType":"json",
				"success":function(data){
					$(".notepaper-div").html("");
					var notepaperHtml = "";
					for(var i = 0;i < data.length;i++){
						notepaperHtml += "<div class=\"notepaper\">"+
										"<img class=\"notepaperImg\" src=\""+basePath+data[i].notepaper_img+"\" />"+
										"<input type=\"hidden\" name=\"notepaperId\" value=\""+data[i].notepaper_id+"\">"+
									"</div>";
					}
					$(".notepaper-div").html(notepaperHtml);
					$(".pageNum").text((pageNum*1)-1);
					if((pageNum*1)-1 == 1){
						$(".left-span").css("color","#b8bfd0");
					}
				}
			});
		}
	});
	
	//下一页信纸
	$(".right-span").click(function(){
		var pageCount = $(".pageCount").text();
		var pageNum = $(".pageNum").text();
		if(pageNum >= pageCount){
			return;
		}else{
			$(".left-span").css("color","blue");
			$.ajax({
				"url":basePath+'/nextlistOnePageData.do',
				"type":"post",
				"data":{pageNum:pageNum},
				"dataType":"json",
				"success":function(data){
					$(".notepaper-div").html("");
					var notepaperHtml = "";
					for(var i = 0;i < data.length;i++){
						notepaperHtml += "<div class=\"notepaper\">"+
										"<img class=\"notepaperImg\" src=\""+basePath+data[i].notepaper_img+"\" />"+
										"<input type=\"hidden\" name=\"notepaperId\" value=\""+data[i].notepaper_id+"\">"+
									"</div>";
					}
					$(".notepaper-div").html(notepaperHtml);
					$(".pageNum").text((pageNum*1)+1);
					if((pageNum*1)+1 == pageCount){
						$(".right-span").css("color","#b8bfd0");
					}
				}
			});
		}
	});
});

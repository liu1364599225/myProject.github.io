$(function(){
	var basePath = window.document.location.href;
	basePath = basePath.substring(0,basePath.lastIndexOf('/'));
	
	var index = 0;
	var circle = $(".circle");
	var postcardDiv = $(".postcard-div-class");
	$(".am-icon-arrow-circle-left").click(function(){
		circle[index].style.color = "#C3CEDA";
		for(var i = 0;i < postcardDiv.length;i++){
			postcardDiv[i].style.display = "none";
		}
		if(index == 0){
			index = postcardDiv.length -1;
			$(postcardDiv[index]).fadeIn(700);
		}else{
			index = index-1;
			$(postcardDiv[index]).fadeIn(700);
		}
		circle[index].style.color = "#3A5D86";
	});
	
	$(".am-icon-arrow-circle-right").click(function(){
		circle[index].style.color = "#C3CEDA";
		for(var i = 0;i < postcardDiv.length;i++){
			postcardDiv[i].style.display = "none";
		}
		if(index == postcardDiv.length - 1){
			index = 0;
			$(postcardDiv[index]).fadeIn(700);
		}else{
			index = index + 1;
			$(postcardDiv[index]).fadeIn(700);
		}
		circle[index].style.color = "#3A5D86";
	});
	
	$(".circle").click(function(){
		for(var i = 0;i < postcardDiv.length;i++){
			postcardDiv[i].style.display = "none";
		}
		for(var j = 0;j < circle.length;j++){
			circle[j].style.color = "#C3CEDA";
		}
		this.style.color = "rgb(58, 93, 134)";
		for(var j = 0; j < postcardDiv.length;j++){
			if(circle[j].style.color == "rgb(58, 93, 134)"){
				index = j;
				$(postcardDiv[index]).fadeIn(700);
			}
		}
	});
	
	var music = document.getElementById("music");
	$(".postcards").click(function(){
		var postcards = $(".postcards");
		var postcardNewImg = $(".postcard-newImg");
		var postcardMusic = $(".postcard-music");
		var newImg = $("#newImg").get(0);
		var music = $("#music").get(0);
		$("#background-div").css("display","inline");
		$(".newPostcard").fadeIn(700);
		var musicCheckBox = $(".musicCheckBox");
		for(var i = 0;i < musicCheckBox.length;i++){
			musicCheckBox[i].checked = true;
		}
		for(var i = 0;i < postcards.length;i++){
			if($(this).is(postcards[i])){
				newImg.src = postcardNewImg[i].value;
				music.src = postcardMusic[i].value;
			}
		}
		music.currentTime = 0;
		music.play();
	});
	
	$(".close").click(function(){
		$("#background-div").css("display","none");
		$(".newPostcard").css("display","none");
		$(".writerPostcard").css("display","none");
		$(".exceeding").css("display","none");
		$(".message").val("");
		$("#prompt").text("还能输入");
		$("#words").css("color","gray")
		$("#words").text(80);
		music.pause();
	});
	
	$(".cancel").click(function(){
		$("#background-div").css("display","none");
		$(".newPostcard").css("display","none");
		$(".writerPostcard").css("display","none");
		$(".exceeding").css("display","none");
		$(".message").val("");
		$("#prompt").text("还能输入");
		$("#words").css("color","gray")
		$("#words").text(80);
		music.pause();
	});
	
	$(".nextStep").click(function(){
		if($(".message").val().length > 80){
			$(".exceeding").css("display","inline");
			return;
		}
		$(".exceeding").css("display","none");
		$(".newPostcard").css("display","none");
		$(".writerPostcard").fadeIn(700);
		
		//获得一个二维画布对象环境
		var mainCtx = document.getElementById('canvasImg').getContext("2d");
		var mainWidth = mainCtx.width;
		var maxHeight = mainCtx.height;
		//清空给定矩形内的指定像素
//		mainCtx.clearRect(0,0,0,1000);
		//获取背景图片路径
		var startImg = new Image();
		startImg.src = $("#newImg").attr('src');
		//等图片加载完毕之后再将其“画”出来,否则图片不会显示
		startImg.onload = function(){
			//先将背景图片绘制在这里
			mainCtx.drawImage(startImg,0,0,610,450);
			//判断输入的内容是否为空，不为空则画在背景图片上
			if("" != $(".message").val()){
				//设置字体
				mainCtx.font = "small-caps bold 18px STXinwei";
				//设置字体颜色
				mainCtx.fillStyle = "black";
				var message = $(".message").val();
				var divisor = 9;		//一行画多少个字
				var length = parseInt(message.length % divisor == 0 ? message.length / divisor : (message.length/divisor*1)+1);
				var heightStr = 98;			//画在图片上的高度
				var subStr = "";
				for(var i = 0;i < length;i++){
					subStr = message.substr(0,divisor);
					message = message.substr(subStr.length, message.length - 1);
					//开始将文字画在图片上
					mainCtx.fillText(subStr,423,heightStr);
					heightStr = parseInt(heightStr + 23);
				}
			}
			
			//获得画布对象
			var canvasImg = document.getElementById('canvasImg');
			
			//获取页面图片对象，新画出的图片路径赋值给它的src
			var newImage = document.getElementsByClassName("endPostcard-img");
			var imgdata = canvasImg.toDataURL("image/png");
			//将画布转换成图片，返回base64码的图片路径
			for(var i = 0;i < newImage.length;i++){
				newImage[i].src = imgdata;
			}
			
//			var ajaxData = imgdata.replace(/^data:image\/(png|jpg);base64,/, "");
//			$.ajax({
//				"url":basePath + '/imgUp.do',
//				"type":"post",
//				"data":{imageDataUrl:ajaxData},
//				"dataType":"text",
//				success:function (data){
//					
//				}
//			});
//			//下载画出来的图片
//			var imageImg = canvasImg.toDataURL("image/png").replace("image/png", "image/octet-stream");
//			window.location.href=imageImg;
		}
		
	});
	
	$(".message").bind('input propertychange',function(){
		var len = $(".message").val().length;
		var words = 80 - len;
		if(words >= 0){
			$("#prompt").text("还能输入");
			$("#words").css("color","gray")
			$("#words").text(words);
		}else{
			$("#prompt").text("已超过");
			$("#words").css("color","red")
			$("#words").text(words * -1);
		}
	});
	
	
	$(".musicCheckBox").click(function(){	
		var musicCheckBox = $(".musicCheckBox");
		var music = document.getElementById("music");
		var checked = false;
		for(var i = 0;i < musicCheckBox.length;i++){
			if($(this).is(musicCheckBox[i])){
				checked = musicCheckBox[i].checked;
				if(checked){
					break;
				}
			}
		}
		
		
		if(checked){
			music.currentTime = 0;
			music.play();
			for(var i = 0;i < musicCheckBox.length;i++){
				musicCheckBox[i].checked = true;
			}
		}else{
			music.pause();
			for(var i = 0;i < musicCheckBox.length;i++){
				musicCheckBox[i].checked = false;
			}
		}
	});
	
	$(".lastStep").click(function(){
		$(".writerPostcard").css("display","none");
		$(".newPostcard").fadeIn(700);
	});
	
	
	//切换到发送群邮件
	$(".group").click(function(){
		$(".single-div").css("display","none");
		$(".sendGroupMail").css("display","inline");
		$(".sendMail").css("display","none");
		$(".group-div").css("display","inline-block");
		$(".timing").attr("disabled","disabled");
		music.pause();
	});
	
	//切换到发送普通邮件
	$(".single").click(function(){
		$(".group-div").css("display","none");
		$(".sendMail").css("display","inline");
		$(".sendGroupMail").css("display","none");
		$(".single-div").css("display","inline-block");
		$(".timing").attr("disabled",false);
		var musicCheckBox = $(".musicCheckBox");
		for(var i = 0;i < musicCheckBox.length;i++){
			if(musicCheckBox[i].checked){
				music.currentTime = 0;
				music.play();
				break;
			}
		}
	});
	
	
	//通讯录列表样式
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

	
	//群邮件
	$(".groupContactsList").click(function(){
		var selectVal = $(this).text();
		$(".selectInput").val(selectVal);
	});
	
	
	//发送群邮件链接和校验
	$(".sendGroupMail").click(function(){
		if($(".selectInput").val() == ""){
			$("#messageGroup").css("display","inline");
			$("#messageGroup").text("请选择一个通讯组");
			return;
		}
		
		var canvasImg = document.getElementById('canvasImg');
		var imgdata = canvasImg.toDataURL("image/png");
		var ajaxData = imgdata.replace(/^data:image\/(png|jpg);base64,/, "");
		$.ajax({
			"url":basePath + '/imgUp.do',
			"type":"post",
			"data":{imageDataUrl:ajaxData},
			"dataType":"text",
			success:function (data){
				$(".newImage1").attr("src",data);
				var str = "";
				str += $(".music-div1").html();
				$(".richText1").val(str);
				$("#writerGroupForm").submit();
			}
		});
	})
	
	//发送邮件链接和校验
	$(".sendMail").click(function(){

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
				var canvasImg = document.getElementById('canvasImg');
				var imgdata = canvasImg.toDataURL("image/png");
				var ajaxData = imgdata.replace(/^data:image\/(png|jpg);base64,/, "");
				$.ajax({
					"url":basePath + '/imgUp.do',
					"type":"post",
					"data":{imageDataUrl:ajaxData},
					"dataType":"text",
					success:function (data){
						$(".newImage").attr("src",data);
						$("#sendMusic").attr("src",$("#music").attr("src"));
						var str = "";
						str += $(".music-div").html();
						$(".richText").val(str);
						$("#writerForm").submit();
					}
				});
			}
		}, 'text');
	});
});

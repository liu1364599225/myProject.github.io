$(function(){
	$("#tool-ul li").mouseover(function(){
		$("#tool-ul li").css("background-color","white");
		$("#tool-ul li").css("color","black");
		$(this).css("background-color","#3470CC");
		$(this).css("color","white");
	})
	
	$("#tool-ul li").mouseleave(function(){
		$(this).css("background-color","white");
		$(this).css("color","black");
	})
	
	$("#tool").focus(function(){
		$("#tool-ul").css("display","block");
	});
	
	$("#tool").blur(function(){
		$("#tool-ul").css("display","none");
	});
	
	$("#group-ul li").click(function(){
		$("#group-ul li").css("background-color","#F6F6F6");
		$("#group-ul a").css("color","#1E5494");
		$(this).css("background-color","#5A91D0");
		$(this).find("a").css("color","white");
	});
	
	$("#md-div-search").focus(function(){
		$(this).attr("placeholder","");
	});
	
	$("#md-div-search").blur(function(){
		$(this).attr("placeholder","请输入分组的名字");
	});
	
	$("#mail-linkman-ul font").click(function(){
		if($(this).attr("class") == "am-icon-plus-square-o"){
			//点击之前为隐藏的状态
			$(this).attr("class","am-icon-minus-square-o");
			$(this).nextAll("ul").css("display","block");
		}else{
			$(this).attr("class","am-icon-plus-square-o");
			$(this).nextAll("ul").css("display","none");
		}
	});
	
//	$("#ul-linkman-ul li").click(function(){
//		parent_index = $(this).parent().parent().index();
//		$(this).css("display","none");
//      $(".info-div-right").append('<div name='+parent_index+' class="add-to-linkman" title="'+$(this).attr("title")+'"><span>'+$(this).text()+'</span><font class="add-to-linkman-font am-icon-minus-circle"></font></div>');
//	});
//	
	$("#mail-linkman-ul li").on("click","li",function(){
		parent_index = $(this).parent().parent().index();
		$(this).css("display","none");
        $(".info-div-right").append('<div name='+parent_index+' class="add-to-linkman" title="'+$(this).attr("title")+'"><span>'+$(this).text()+'</span><font class="add-to-linkman-font am-icon-minus-circle"></font></div>');
	});
	
	$(".info-div-right").on("click",".add-to-linkman-font",function(){
		$(this).parent().css("display","none");
		$("#mail-linkman-ul>li").eq(parseInt($(this).parent().attr("name"))).find("ul").append('<li title="'+$(this).parent().attr("title")+'">'+$(this).siblings("span").text()+'</li>')
	});
	
	$("#save").click(function(){
		var groupName = $("#md-div-search").val();
		var info = "";
		for(var i=0;i<$(".add-to-linkman").length;i++){
			var account = $(".add-to-linkman").eq(i).attr("title");
			if(info == ""){
				info = account;
			}else{				
				info =info+"&"+account;
			}
		}
		$.ajax({
			url:"updateGroupInfo.do",
			type:"post",
			data:{"groupName":groupName,"info":info},
			dataType:"json",
			success:function(data){
				location.href="http://localhost:8081/qqmail/toLinkManPage.do?data=1";
			}
		});
	});
	
	$(".group").click(function(){
		$(".linkman-entry-class").remove();
		$.ajax({
			url:"readAllByGroupName.do",
			type:"post",
			data:{"groupName":$(this).text()},
			dataType:"json",
		    success:function(data){
		    	for(var i=0;i<data.length;i++){
		    		$("#linkman-left").append('<div id="linkman-entry" class="linkman-entry-class"><span class="col-md-1" id="span-c1"><input type="checkbox" id="c1" class="select"/></span><span class="col-md-3">'+data[i].name+'</span><span class="col-md-4">'+data[i].account+'</span><span class="col-md-2">'+data[i].tel+'</span><span class="col-md-2">'+data[i].groupName+'</span></div>');
		    	    //console.log(1);
		    	}
		    }
		});
	});
	
	$("#delete").click(function(){
		 var  ch = $(".select").length;
		 var  account = "";
		 for(var i=0;i<ch;i++){
		 	if($(".select")[i].checked){
		 		if(account == ""){
		 			account = $(".select").eq(i).parent().next("span").next("span").text();
		 		}else{
		 			account = account + "&" + $(".select").eq(i).parent().next("span").next("span").text();
		 		}
		 	}
		 }
		 if(account != ""){
			 $.ajax({
				 url:"deleteLinkMan.do",
				 type:"post",
				 data:{"account":account},
				 dataType:"json",
				 success:function(data){
					 location.href="http://localhost:8081/qqmail/toLinkManPage.do?data=1";
				 }
			 });
		 }
	});
	
	$(".selectall").click(function(){
		if($(".selectall")[0].checked){
			for(var i=0;i<$(".select").length;i++){
				$(".select")[i].checked = true;
			}
		}else{
			for(var i=0;i<$(".select").length;i++){
				$(".select")[i].checked = false;
			}
		}
	});
});
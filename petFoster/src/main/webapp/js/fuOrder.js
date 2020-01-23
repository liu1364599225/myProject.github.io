$(function(){
	
	var id1 = $(".delete");
	var id2 = $(".confirmation");
	var id3 = $(".cancellation");
	var id4 = $(".hang");
	var status = $(".status");
	var operation = $(".operation");
	for(var i = 0;i < status.length;i++){
		if(status[i].innerText == "待确认"){
			id1[i].style.display = "none";
		}else if(status[i].innerText == "已确认"){
			id2[i].style.display = "none";
			id3[i].style.display = "none";
			id4[i].style.display = "none";
		}else if(status[i].innerText == "已取消"){
			id2[i].style.display = "none";
			id3[i].style.display = "none";
			id4[i].style.display = "none";
		}else if(status[i].innerText == "拒单"){
			id2[i].style.display = "none";
			id3[i].style.display = "none";
			id4[i].style.display = "none";
		}else if(status[i].innerText == "正在预约"){
			id1[i].style.display = "none";
			id2[i].style.display = "none";
			id4[i].style.display = "none";
		}else if(status[i].innerText == "已挂起"){
			id1[i].style.display = "none";
			id2[i].style.display = "none";
			id3[i].style.display = "none";
			id4[i].style.display = "none";
		}
	}
	
	
	var basePath = "http://localhost:8888/petFoster";
	var fuId = $("#fuId").val();
	$("#typeSelect").change(function(){
		var typeSelect = document.getElementById("typeSelect");
		var orderList = document.getElementById("orderList");
		var ops = typeSelect.options;
		var url = basePath;
		var xhr = getXMLHttpRequest();
		for(var i=0; i<ops.length; i++){
			if(ops[i].selected == true){
				if(ops[i].text == "近一个月") {
					url += "/listOneMonthOrder.pet";
				} else if(ops[i].text == "近三个月"){
					url += "/listThreeMonthOrder.pet";
				} else if(ops[i].text == "近一年"){
					url += "/listOneYearOrder.pet";
				} else if(ops[i].text == "全部订单"){
					url += "/listAllOrder.pet";
				}
			}

			$.post(url,'fuId='+fuId,function(data){
				var divhtml = "";
				for(var i = 0;i < data.length;i++){
					divhtml += "<input type=\"hidden\" class=\"oId\" value="+data[i].oId+">"+
								"<div class=\"col-md-1 fosterFamilyList-text\">"+data[i].oId+"</div>"+
								"<div class=\"col-md-2 fosterFamilyList-text\">"+data[i].fosterUserName+"</div>"+
								"<div class=\"col-md-1 fosterFamilyList-text\">"+data[i].petName+"</div>"+
								"<div class=\"col-md-2 fosterFamilyList-text\">"+data[i].oFosterplaceName+"</div>"+
								"<div class=\"col-md-1 fosterFamilyList-text\">"+data[i].oFosterday+"</div>"+
								"<div class=\"col-md-1 fosterFamilyList-text\">"+data[i].oOrderstatus+"</div>"+
								"<div class=\"col-md-2 fosterFamilyList-text\">"+data[i].oOrderdate+"</div>";
					if(data[i].oOrderstatus == "待确认"){
						divhtml +="<div class=\"col-md-2 fosterFamilyList-text operation\">"+
								    "<a class=\"hang\" href=\""+basePath+"/hangOrder.pet?oId="+data[i].oId+"&fuId="+fuId+"\">挂起</a>&nbsp;"+
									"<a class=\"confirmation\" href=\""+basePath+"/confirmationOrder.pet?oId="+data[i].oId+"&fuId="+fuId+"\">确认订单</a>&nbsp;"+
									"<a class=\"cancellation\" href=\""+basePath+"/cancellationOrder.pet?oId="+data[i].oId+"&fuId="+fuId+"\">取消订单</a>"+
								"</div>";
					}else if(data[i].oOrderstatus == "已确认"){
						divhtml +="<div class=\"col-md-2 fosterFamilyList-text operation\">"+
									"<a class=\"delete\" href=\""+basePath+"/deleteOrder.pet?oId="+data[i].oId+"&fuId="+fuId+"\">删除</a>"+
								"</div>";
					}else if(data[i].oOrderstatus == "已取消"){
						divhtml +="<div class=\"col-md-2 fosterFamilyList-text operation\">"+
									"<a class=\"delete\" href=\""+basePath+"/deleteOrder.pet?oId="+data[i].oId+"&fuId="+fuId+"\">删除</a>"+
								"</div>";
					}else if(data[i].oOrderstatus == "拒单"){
						divhtml +="<div class=\"col-md-2 fosterFamilyList-text operation\">"+
										"<a class=\"delete\" href=\""+basePath+"/deleteOrder.pet?oId="+data[i].oId+"&fuId="+fuId+"\">删除</a>"+
									"</div>";
					}else if(data[i].oOrderstatus == "正在预约"){
						divhtml +="<div class=\"col-md-2 fosterFamilyList-text operation\">"+
									"<a class=\"cancellation\" href=\""+basePath+"/cancellationOrder.pet?oId="+data[i].oId+"&fuId="+fuId+"\">取消订单</a>"+
								"</div>";
					}else if(data[i].oOrderstatus == "已挂起"){
						divhtml +="<div class=\"col-md-2 fosterFamilyList-text operation\"></div>";
					}
				}
				orderList.innerHTML = "<div id=\"fosterFamilyList\">"+ divhtml +"</div>";
			},'json');
		}
	});
	
	
	
	
	
});

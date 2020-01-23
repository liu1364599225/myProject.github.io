$(function(){
	
	$(".avatar-div-div").mousemove(function(){
		$(".avatar-div-div").css("display","inline");
	});
	$(".avatar-div-div").mouseleave(function(){
		$(".avatar-div-div").css("display","none");
	});
	$("#avatar").mousemove(function(){
		$(".avatar-div-div").css("display","inline");
	});
	$("#avatar").mouseleave(function(){
		$(".avatar-div-div").css("display","none");
	});
	
	$(".houseType a").click(function(){
		$(".houseType a").css("color","#797979");
		$(this).css("color","red");
	});
	
	$(".housePrice a").click(function(){
		$(".housePrice a").css("color","#797979");
		$(this).css("color","red");
	});
	
	$(".roomType a").click(function(){
		$(".roomType a").css("color","#797979");
		$(this).css("color","red");
	});
	

	var basePath = window.document.location.href;
	basePath = basePath.substring(0,basePath.lastIndexOf('/'));
	$(".search-ul a").click(function(){
		var housePrice = $(".housePrice a");
		var price = "";
		for(var i = 0;i < housePrice.length;i++){
			if(housePrice[i].style.color == "red"){
				price = housePrice[i].innerText;
			}
		}
		var roomType = $(".roomType a");
		var rType = "";
		for(var i = 0;i < roomType.length;i++){
			if(roomType[i].style.color == "red"){
				rType = roomType[i].innerText;
			}
		}

		var houseType = $(".houseType a");
		var hType = "";
		for(var i = 0;i < houseType.length;i++){
			if(houseType[i].style.color == "red"){
				hType = houseType[i].innerText;
			}
		}
		$.post(basePath + '/selectByType.fw','housePrice='+price+'&roomType='+rType+'&houseType='+hType,
				function(data) {
			var housingContent = "";
			if("" != data && null != data){
				for(var i = 0;i < data.length;i++){
					housingContent += "<li style=\"width: 100%;\">"+
											  	"<a class=\"housing-class\" href=\"javascript:void(0);\" onmouseover=\"housingClassOver(this);\" onmouseleave=\"housingClassLeave(this);\" style=\"color: #797979;\">"+
											  		"<div class=\"housing-div-img\">"+
										  				"<img class=\"housing-class-img\" src=\""+data[i].housingImage.split(";")[0]+"\"/>"+
											  		"</div>"+
											      	"<div class=\"housing-div-left\">"+
											      		"<p class=\"housing-div-left-p\">"+data[i].housingTitle+"</p>"+
											  			"<div class=\"housing-div-left-div1\">"+
												  			"<p class=\"housing-div-left-div1-p\" style=\"margin-left: 0px;\">"+data[i].housingHousetype+"</p>"+
												  			"<p class=\"housing-div-left-div1-p\">"+data[i].housingArea+"平方米</p>"+
												  			"<p class=\"housing-div-left-div1-p\">"+data[i].housingFloor+"</p>"+
											  			"</div>"+
											  			"<div class=\"housing-div-left-div2\">"+
											  				"<p>"+data[i].housingAddress+"+&nbsp;&nbsp;"+data[i].housingDetailsaddress+"</p>"+
											  			"</div>"+
											      	"</div>"+
											      	"<div class=\"housing-div-right\">"+
											      		"<p><strong style=\"font-size: 24px;\">"+data[i].housingPrice+"</strong>元/月</p>"+
											      	"</div>"+
											    "</a>"+
											"</li>";
				}
			}else{
				housingContent += "<div style=\"font-size:24px;text-align:center;\">抱歉，没有搜索找到符合条件的房源~</div>";
			}
			$("#movies").html(housingContent);
			
		}, 'json');
	});
	
	
	$(".find-a").click(function(){
		var searchText = $(".search-input").val();
		if("" == searchText){
			alert("搜索内容不能为空");
			return false;
		}
		var re = new RegExp("^[ ]+$");
		if(re.test(searchText)){
			alert("搜索内容不能为空");
			return false;
		}
		$.post(basePath + '/search.fw','searchText='+searchText,
				function(data) {
			var housingContent = "";
			if("" != data && null != data){
				for(var i = 0;i < data.length;i++){
					housingContent += "<li style=\"width: 100%;\">"+
											  	"<a class=\"housing-class\" href=\"housingPage.fw?housingId="+data[i].housingId+"\" onmouseover=\"housingClassOver(this);\" onmouseleave=\"housingClassLeave(this);\" style=\"color: #797979;\">"+
											  		"<div class=\"housing-div-img\">"+
										  				"<img class=\"housing-class-img\" src=\""+data[i].housingImage.split(";")[0]+"\"/>"+
											  		"</div>"+
											      	"<div class=\"housing-div-left\">"+
											      		"<p class=\"housing-div-left-p\">"+data[i].housingTitle+"</p>"+
											  			"<div class=\"housing-div-left-div1\">"+
												  			"<p class=\"housing-div-left-div1-p\" style=\"margin-left: 0px;\">"+data[i].housingHousetype+"</p>"+
												  			"<p class=\"housing-div-left-div1-p\">"+data[i].housingArea+"平方米</p>"+
												  			"<p class=\"housing-div-left-div1-p\">"+data[i].housingFloor+"</p>"+
											  			"</div>"+
											  			"<div class=\"housing-div-left-div2\">"+
											  				"<p>"+data[i].housingAddress+"&nbsp;&nbsp;"+data[i].housingDetailsaddress+"</p>"+
											  			"</div>"+
											      	"</div>"+
											      	"<div class=\"housing-div-right\">"+
											      		"<p><strong style=\"font-size: 24px;\">"+data[i].housingPrice+"</strong>元/月</p>"+
											      	"</div>"+
											    "</a>"+
											"</li>";
				}
			}else{
				housingContent += "<div style=\"font-size:24px;text-align:center;\">抱歉，没有搜索找到符合条件的房源~</div>";
			}
			$("#movies").html(housingContent);
			
		}, 'json');
	});
});

function housingClassLeave(hc){
	$(hc).find(".housing-div-left-p").css("text-decoration","none");
	$(hc).find(".housing-div-left-p").css("color","black");
};

function housingClassOver(hc){
	$(hc).find(".housing-div-left-p").css("text-decoration","underline");
	$(hc).find(".housing-div-left-p").css("color","red");
};
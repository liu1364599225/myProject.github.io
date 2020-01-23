<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房屋租赁系统首页</title>

    <link rel="stylesheet" href="css/index.css" />
    <link rel="stylesheet" href="css/font-style.css" />
    <link rel="stylesheet" href="css/pick-pcc.min.1.0.1.css">
	<style>
		body{padding:10px;}
		.pick-area{display: inline-block;}
		.a{float:left;width:100%;margin:10px;}
		.a a{float:left;margin:10px;}
		.a input{float:left;width:400px;padding:10px;margin:10px;outline-color: gold;}
		h1{text-align: center;}
		h3{margin:5px;color:#333;}
		h4{margin:5px;color:#666;padding:0 20px;font-weight: 100;}
		.blank{float:left;width:50%;height:400px;background:cyan;border-top:1px solid #333;margin-top:50px;}
		.blank2{float:left;width:50%;height:400px;background:lightpink;border-top:1px solid #333;padding-top:50px;}
		.box{width:100%;overflow: hidden;background:lightgreen;}
	</style>

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="bootstrap-3.3.7-dist/js/html5shiv.min.js"></script>
      <script src="bootstrap-3.3.7-dist/js/respond.min.js"></script>
    <![endif]-->
  	</head>
  	<body>
  		<div id="top" class="container">
	  		<a href="index.fw">
				<div style="float: left;">
					<img src="img/logo.png" width="100px" height="100px" />
				</div>
				<div style="float: left;">
					<span id="sytemName">房屋租赁系统</span>
				</div>
			</a>
			
			<div id="top-navigation">
				<c:if var="isNull" test="${null == userAccount}">
					<a class="top-navigation-a" href="loginPage.fw">
						登录、注册
					</a>
				</c:if>
				<c:if test="${!isNull }">
					<div class="avatar-div" style="">
						<a id="avatar" class="btn btn-default btn-lg" href="#">
						<c:if var="avatar" test="${null == userAccount.userAvatar}">
							<img src="img/userAvatar.jpg" width="100%" height="100%" />
						</c:if>
						<c:if test="${!avatar }">
							<img src="${userAccount.userAvatar}" width="100%" height="100%" />
						</c:if>
						</a>
						<div class="avatar-div-div">
							<p class="userName">${userAccount.userAccount}</p>
							<a href="userInformationPage.fw" style="margin-left: 0px;">个人信息</a>
							<a href="userOrderRecords.fw" style="margin-left: 0px;">预约记录</a>
							<a href="userExit.fw" style="margin-left: 0px;">退出</a>
						</div>
					</div>
				</c:if>
			</div>
		</div>
  		
		<div id="center" class="container">
			<div id="search">
				<ul class="search-ul housePrice">
				  <li style="font-weight: bold;">租金: </li>
				  <li><a style="color: red;" href="javascript:void(0);">全部</a></li>
				  <li><a href="javascript:void(0);">500元以下</a></li>
				  <li><a href="javascript:void(0);">500-1000元</a></li>
				  <li><a href="javascript:void(0);">1000-1500元</a></li>
				  <li><a href="javascript:void(0);">1500-2000元</a></li>
				  <li><a href="javascript:void(0);">2000-3000元</a></li>
				  <li><a href="javascript:void(0);">3000-4000元</a></li>
				  <li><a href="javascript:void(0);">4000元以上</a></li>
				</ul>
				<ul class="search-ul houseType">
				  <li style="font-weight: bold;">类型: </li>
				  <li><a style="color: red;" href="javascript:void(0);">全部</a></li>
				  <c:forEach items="${htList}" var="ht">
					  <li><a href="javascript:void(0);">${ht.housetypeName }</a></li>
				  </c:forEach>
				</ul>
				<ul class="search-ul roomType">
				  <li style="font-weight: bold;">房型: </li>
				  <li><a style="color: red;" href="javascript:void(0);">全部</a></li>
				  <li><a href="javascript:void(0);">1室0厅</a></li>
				  <li><a href="javascript:void(0);">1室1厅</a></li>
				  <li><a href="javascript:void(0);">2室1厅</a></li>
				  <li><a href="javascript:void(0);">2室2厅</a></li>
				  <li><a href="javascript:void(0);">3室1厅</a></li>
				  <li><a href="javascript:void(0);">3室2厅</a></li>
				  <li><a href="javascript:void(0);">3室3厅</a></li>
				  <li><a href="javascript:void(0);">4室1厅</a></li>
				  <li><a href="javascript:void(0);">4室2厅</a></li>
				  <li><a href="javascript:void(0);">4室3厅</a></li>
				</ul>
				
				<ul class="search-box-ul">
					<div>
						<input class="search-input" type="text" placeholder="请输入房源标题或房源地址..." />
						<a class="btn btn-success find-a">查找</a>
					</div>
				</ul>
			</div>
			<div id="housing-context" >
				<ul class="housing-ul">
				    <div id="movies">
				    	<c:forEach items="${housingList }" var="housing">
							<li style="width: 100%;">
							  	<a class="housing-class" href="housingPage.fw?housingId=${housing.housingId }" onmouseover="housingClassOver(this);" onmouseleave="housingClassLeave(this);" style="color: #797979;">
							  		<div class="housing-div-img">
						  				<img class="housing-class-img" src="${fn:split(housing.housingImage,';')[0]}"/>
							  		</div>
							      	<div class="housing-div-left">
							      		<p class="housing-div-left-p">${housing.housingTitle}</p>
							  			<div class="housing-div-left-div1">
								  			<p class="housing-div-left-div1-p" style="margin-left: 0px;">${housing.housingHousetype}</p>
								  			<p class="housing-div-left-div1-p">${housing.housingArea}平方米</p>
								  			<p class="housing-div-left-div1-p">${housing.housingFloor}</p>
							  			</div>
							  			<div class="housing-div-left-div2">
							  				<p>${housing.housingAddress}&nbsp;&nbsp;${housing.housingDetailsaddress}</p>
							  			</div>
							      	</div>
							      	<div class="housing-div-right">
							      		<p><strong style="font-size: 24px;">${housing.housingPrice}</strong>元/月</p>
							      	</div>
							    </a>
							</li>
						</c:forEach>
					</div>
				</ul>
				<div class="container-fluid" style="margin-top: 30px;float: right;">
			        <!--分页 start-->
			        <div class="fanye">
			            <div class="holder"></div>
			        </div>
			        <!--分页 end-->
			  	</div>
			</div>
		</div>
		
		
	    <script type="text/javascript" src="js/pick-pcc.min.1.0.1.js" ></script>
    	<script type="text/javascript" src="js/index.js" ></script>
	    <script type="text/javascript">
	    	$(".pick-area7").pickArea({
	    		"format": "",
	    		"width": "250px",
	    		"height": "30px",
	    		"borderColor": "#ccc",
	    		"color": '#7894D4',
	    		"arrowColor": "#7894D4"
	    	});
	    	
	    	
	        $("div.holder").jPages({
	            containerID: "movies",
	            previous: "← 上一页",
	            next: "下一页 →",
	            perPage: 5,
	            delay: 5
	        });
	    </script>
  </body>
</html>
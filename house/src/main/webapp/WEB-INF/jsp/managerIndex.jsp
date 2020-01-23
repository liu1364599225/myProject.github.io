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
	<style>
		body{
			margin: 0;
			background: url(img/indexBG.jpg) no-repeat;
			background-size: 100%;
		}
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
	  		<a href="managerIndex.fw">
				<div style="float: left;">
					<img src="img/logo.png" width="100px" height="100px" />
				</div>
				<div style="float: left;">
					<span id="sytemName">房屋租赁系统</span>
				</div>
			</a>
			
			<div id="top-navigation">
				<c:if var="isNull" test="${null == managerAccount}">
					<a class="top-navigation-a" href="loginPage.fw">
						登录、注册
					</a>
				</c:if>
				<c:if test="${!isNull }">
				<p class="top-navigation-a" style="color: white;float: left;">
					${managerAccount.managerAccount }
				</p>
				</c:if>
				
				<a class="top-navigation-a" href="managerExit.fw">
					退出
				</a>
			</div>
		</div>
  		
		<div id="center" class="container">
			<div class="container-fluid" style="border-bottom: 1px dashed gray;">
				<h3>待审核的房源信息</h3>
			</div>
			<c:if test="${0 != housingList.size() }">
				<div id="housing-context" >
					<ul class="housing-ul">
					    <div id="movies">
					    	<c:forEach items="${housingList }" var="housing">
								<li style="width: 100%;">
								  	<a class="housing-class" href="housingCheckPage.fw?housingId=${housing.housingId }" onmouseover="housingClassOver(this);" onmouseleave="housingClassLeave(this);" style="color: #797979;">
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
			</c:if>
			<c:if test="${0 == housingList.size() }">
				<div id="housing-context" style="text-align:center;font-size:20px;" >
					<p>暂无待审核的房源信息~</p>
				</div>
			</c:if>
		</div>
		
		
    	<script type="text/javascript" src="js/index.js" ></script>
	    <script type="text/javascript">
	    	
	    	
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>宠物寄养及医疗服务管理系统</title>
	<link href="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/ffInformation.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/font-style.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/pick-pcc.min.1.0.1.css">


    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/html5shiv.min.js"></script>
      <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div id="top" class="container">
		<a href="javascript:void(0)">
			<div style="float: left;">
				<span id="logo-img" class="am-icon-home" />
			</div>
			<div style="float: left;">
				<span id="sytemName">宠物寄养平台</span>
			</div>
		</a>
		<div style="height:80px;line-height:80px;color:yellow;margin-left:80px;float:left;">${msg }</div>
		<div id="top-navigation">
			<div id="top-navigation-name">账户名:${accountName }</div>
			<a class="btn btn-default btn-lg" href="${pageContext.servletContext.contextPath }/fuIndex.pet?accountName=${accountName}"> 返回上层页面 </a>
			<a class="btn btn-default btn-lg" href="${pageContext.servletContext.contextPath }/loginPage.pet"> 退出 </a>
		</div>
	</div>

	<div class="container">
		<div class="col-md-6 col-md-offset-3" id="center">
			<div class="container-fluid information-title">${family.getfAdoptername() }寄养家庭详细信息</div>
			<div class="row">
				<div class="col-md-10 col-md-offset-1" style="margin-top: 20px;">
					<div class="information-row" style="height:300px;">
						<img src="${pageContext.servletContext.contextPath }${family.getfFamilyphoto() }" width="100%" height="300px" />
					</div>
					<div class="information-row">
						<span class="information-row-title">收养人姓名：</span> <span>${family.getfAdoptername() }</span>
					</div>
					<div class="information-row">
						<span class="information-row-title">收养人性别：</span> <span>${family.getfAdoptersex() }</span>
					</div>
					<div class="information-row">
						<span class="information-row-title">寄养经历：</span> <span>${family.getfFosterexperience() }</span>
					</div>
					<div class="information-row">
						<span class="information-row-title">可寄养的宠物类型：</span> <span>${family.getfTyperange() }</span>
					</div>
					<div class="information-row">
						<span class="information-row-title">联系方式：</span> <span>${family.getfContactway() }</span>
					</div>
					<div class="information-row">
						<span class="information-row-title">联系地址：</span> <span>${family.getfAddress() }</span>
					</div>
					<div class="information-row">
						<span class="information-row-title">寄养环境：</span> <span>${information.getiEnvironment() }</span>
					</div>
					<div class="information-row">
						<span class="information-row-title">寄养服务：</span> <span>￥${information.getiFostercare() }元/日</span>
					</div>
					<div class="information-row">
						<span class="information-row-title">接送服务：</span> <span>￥${information.getiPickupservice() }元/次</span>
					</div>
					<div class="information-row">
						<span class="information-row-title">客服热线：</span> <span>${information.getiCshotline() }</span>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10 col-md-offset-1" style="margin-bottom: 20px;">
					<div>
						<span class="information-row-title"
							style="color: goldenrod; font-size: 20px;"> 寄养家庭描述： </span>
					</div>
					
					<textarea class="userInformation" name="psInformation"
						readonly="readonly">${information.getiDescribe() }</textarea>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10 col-md-offset-1" style="margin-bottom: 20px;">
					<div>
						<span class="information-row-title"
							style="color: goldenrod; font-size: 20px;"> 寄养须知： </span>
					</div>
					<textarea class="userInformation" name="psInformation"
						readonly="readonly">${information.getiNeedtoknow() }</textarea>
				</div>
			</div>
			<div class="information-row" style="text-align:center">
				<a class="btn btn-success" href="${pageContext.servletContext.contextPath }/fosterPage.pet?fuId=${fosterUser.getFuId()}&fId=${family.getfId()}&style=寄养家庭"> 开始寄养 </a>
			</div>
		</div>
	</div>

	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/pick-pcc.min.1.0.1.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/xhr.js" ></script>
</body>
</html>
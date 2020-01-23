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
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/fuInformation.css" />
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
		<div id="top-navigation">
			<div id="top-navigation-name">账户名:${fosterUser.getFuAccountname() }</div>
			<a class="btn btn-default btn-lg" href="${pageContext.servletContext.contextPath }/updateFuPage.pet?fuId=${fosterUser.getFuId()}"> 修改信息 </a>
			<a class="btn btn-default btn-lg" href="${pageContext.servletContext.contextPath }/fuIndex.pet?accountName=${fosterUser.getFuAccountname() }"> 返回上层页面 </a>
			<a class="btn btn-default btn-lg" href="${pageContext.servletContext.contextPath }/loginPage.pet"> 退出 </a>
		</div>
	</div>

	<div class="container">
		<div class="col-md-6 col-md-offset-3" id="center">
			<div class="container-fluid information-title">寄养用户信息</div>
			<div class="row">
				<div class="col-md-5 col-md-offset-1" style="margin-top: 20px;">
					<div class="information-row">
						<span class="information-row-title"
							style="color: goldenrod; font-size: 20px;"> 用户信息 </span>
					</div>
					<div class="information-row">
						<span class="information-row-title">账户名：</span> <span>${fosterUser.getFuAccountname()}</span>
					</div>
					<div class="information-row">
						<span class="information-row-title">姓名：</span> <span>${fosterUser.getFuFosterusername()}</span>
					</div>
					<div class="information-row">
						<span class="information-row-title">性别：</span> <span>${fosterUser.getFuFosterusersex()}</span>
					</div>
					<div class="information-row">
						<span class="information-row-title">联系方式：</span> <span>${fosterUser.getFuContactway()}</span>
					</div>
					<div class="information-row">
						<span class="information-row-title">联系地址：</span> <span>${fosterUser.getFuAddress()}</span>
					</div>
				</div>
				<div class="col-md-4 col-md-offset-1" style="margin-top: 20px;">
					<div class="information-row">
						<span class="information-row-title"
							style="color: goldenrod; font-size: 20px;"> 宠物信息 </span>
					</div>
					<c:forEach var="pet" items="${petList}">
						<div class="information-row">
							<span class="information-row-title">宠物名：</span> <span>${pet.getpPetname()}</span>
						</div>
						<div class="information-row">
							<span class="information-row-title">宠物性别：</span> <span>${pet.getpSex()}</span>
						</div>
						<div class="information-row">
							<span class="information-row-title">宠物类型：</span> <span>${pet.getpType()}</span>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10 col-md-offset-1" style="margin-top: 20px;">
					<div>
						<span class="information-row-title"
							style="color: goldenrod; font-size: 20px;"> 系统回复的信息 </span>
					</div>
					<div class="systemInformation">${systemInformation}</div>
				</div>

				<div class="col-md-10 col-md-offset-1" style="margin-top: 20px;">
				<form action="${pageContext.servletContext.contextPath }/feedbackinformation.pet" method="post">
					<div>
						<span class="information-row-title"
							style="color: goldenrod; font-size: 20px;"> 填写反馈信息 </span>
					</div>
					<textarea class="userInformation" name="userInformation"
						placeholder="可向系统提出反馈信息（如需要进行信息修改可填写申请~）"></textarea>
						
					<div class="prompt">${msg}</div>
					<input type="hidden" name="fuId" value="${fosterUser.getFuId()}">
					<div style="text-align: center; margin-bottom: 10px;">
						<button type="submit" class="btn btn-success"> 提交反馈信息 </button>
					</div>
				</form>
				</div>
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
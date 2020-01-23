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
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/psUpdate.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/font-style.css" />

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
			<div id="top-navigation-name">账户名:${accountName }</div>
			<a class="btn btn-default btn-lg" href="${pageContext.servletContext.contextPath }/manager.pet?accountName=${accountName}"> 返回上层页面 </a> <a
				class="btn btn-default btn-lg" href="${pageContext.servletContext.contextPath }/loginPage.pet"> 退出 </a>
		</div>
	</div>

	<div class="container" style="background-color: white;">
		<div id="title" class="container-fluid">宠物店信息</div>
		<div id="fosterUser" style="margin-top: 20px;">
			<div id="fosterFamilyTitle">
				<div class="col-md-2 fosterFamilyList-title">账户名</div>
				<div class="col-md-2 col-md-offset-1 fosterFamilyList-title">
					宠物店名</div>
				<div class="col-md-3 col-md-offset-1 fosterFamilyList-title">
					反馈信息</div>
				<div class="col-md-2 col-md-offset-1 fosterFamilyList-title">
					操作</div>
			</div>
			<c:forEach  var="petShop" items="${psList}">
				<div id="fosterFamilyList">
					<div class="col-md-2 fosterFamilyList-text">${petShop.getPsAccountname()}</div>
					<div class="col-md-2 col-md-offset-1 fosterFamilyList-text">${petShop.getPsPetshopname()}</div>
					<div class="col-md-3 col-md-offset-1 fosterFamilyList-text"
						style="overflow: scroll; white-space: nowrap;">${petShop.getPsFeedbackinformation()}</div>
					<div class="col-md-2 col-md-offset-1 fosterFamilyList-text">
						<a href="${pageContext.servletContext.contextPath }/psUpdatePage.pet?accountName=${accountName}&psId=${petShop.getPsId() }"> 修改 </a>
						<a href="${pageContext.servletContext.contextPath }/PsfeedbackInformationPage.pet?accountName=${accountName}&psId=${petShop.getPsId() }"> 回复反馈信息 </a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/xhr.js" ></script>
</body>
</html>
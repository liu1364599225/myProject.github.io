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
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/petUpdatePage.css" />
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
			<a class="btn btn-default btn-lg" href="${pageContext.servletContext.contextPath }/updateFuPage.pet?fuId=${fuId}"> 返回上层页面 </a>
			<a class="btn btn-default btn-lg" href="${pageContext.servletContext.contextPath }/loginPage.pet"> 退出 </a>
		</div>
	</div>

	<div class="container">
		<div class="col-md-6 col-md-offset-3" id="center"
			style="background-color: white;">
			<div id="title" class="container-fluid">修改宠物信息</div>
			<input type="hidden" id="fuId" name="fuId" value="${fuId}">
			<form style="margin-top: 20px;" action="${pageContext.servletContext.contextPath }/updatePetInformation.pet?accountName=${accountName}&fuId=${fuId}" method="post">
			<input type="hidden" id="pId" name="pId" value="${pet.getpId() }">
				<div class="information">
					<span class="information-title"> 宠物姓名： </span> <input type="text" id="petName" name="pPetname"
						class="form-control information-input" value="${pet.getpPetname() }">
				</div>

				<div class="prompt"></div>

				<div class="information">
					<span class="information-title"> 宠物性别： </span>
					<c:if test="${pet.getpSex()  =='公'}">
						<div class="information-input">
							<li style="list-style-type: none;">
								<input type="radio" name="pSex" checked="checked" value="公"/>公
								<input style="margin-left: 20px;" type="radio" name="pSex" value="母" />母
							</li>
						</div>
					</c:if>
					<c:if test="${pet.getpSex()  =='母'}">
						<div class="information-input">
							<li style="list-style-type: none;">
								<input type="radio" name="pSex" value="公"/>公
								<input style="margin-left: 20px;" type="radio" name="pSex" value="母" checked="checked"  />母
							</li>
						</div>
					</c:if>
				</div>

				<div class="prompt"></div>

				<div class="information">
					<span class="information-title"> 宠物类型： </span>
					<div class="information-input">
						<select id="form-group-select" name="pType" style="margin-top:5px;" >
							<c:if test="${pet.getpType() == '猫类'}" var="type">
								<option selected="true">猫类</option>
							</c:if>
							<c:if test="${!type }">
								<option>猫类</option>
							</c:if>
							<c:if test="${pet.getpType() == '狗类'}" var="type">
								<option selected="true">狗类</option>
							</c:if>
							<c:if test="${!type }">
								<option>狗类</option>
							</c:if>
							<c:if test="${pet.getpType() == '鼠类'}" var="type">
								<option selected="true">鼠类</option>
							</c:if>
							<c:if test="${!type }">
								<option>鼠类</option>
							</c:if>
							<c:if test="${pet.getpType() == '蛇类'}" var="type">
								<option selected="true">蛇类</option>
							</c:if>
							<c:if test="${!type }">
								<option>蛇类</option>
							</c:if>
							<c:if test="${pet.getpType() == '鸟类'}" var="type">
								<option selected="true">鸟类</option>
							</c:if>
							<c:if test="${!type }">
								<option>鸟类</option>
							</c:if>
						</select>
					</div>
				</div>

				<div class="prompt"></div>
				<div class="prompt">${msg }</div>

				<div id="div-button">
					<button type="submit" id="loginButton" class="btn btn-success">保存修改</button>
				</div>
			</form>
		</div>
	</div>

	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/xhr.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/updatePetPage.js" ></script>
</body>
</html>
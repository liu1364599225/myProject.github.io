<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/userInformation.css" />
    <link rel="stylesheet" href="css/font-style.css" />

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
		
		<div id="center">
			<div class="container-fluid title">
				<p>个人信息</p>
			</div>
			<div class="container-fluid user-information">
				<div class="user-information-div">
					<span style="float: left;">头像：</span>
					<a class="btn btn-default update-avatar">修改</a>
					<c:if test="${null == userAccount.userAvatar }" var="isNotNull">
						<div class="userAvatar-box">
							<img width="100%" height="100%" src="img/userAvatar.jpg"/>
						</div>
					</c:if>
					<c:if test="${!isNotNull }">
						<div class="userAvatar-box">
							<img width="100%" height="100%" src="${userAccount.userAvatar }"/>
						</div>
					</c:if>
					<form id="avatarForm" action="updateUserAvatar.fw" method="post" enctype="multipart/form-data">
						<input id="hiddenFile" name="userAvatar" type="file" style="display: none;" />
					</form>
				</div>
				<div class="user-information-div">
					<span>账号：</span>
					<input type="text" name="userAccount" readonly="readonly" value="${userAccount.userAccount }" />
				</div>
				<div class="user-information-div">
					<span>密码：</span>
					<input type="password" name="userPassword" readonly="readonly" value="${userAccount.userPassword }" />
					<a class="btn btn-default update-a">修改</a>
				</div>
				<div class="user-information-div">
					<span>姓名：</span>
					<input type="text" name="userName" readonly="readonly" value="${userAccount.userName }" />
					<a class="btn btn-default update-a">修改</a>
				</div>
				<div class="user-information-div">
					<span>性别：</span>
		 				<c:if test="${'男' == userAccount.userSex}">
							<input type="radio" name="userSex" value="男"  disabled="disabled" checked="checked"/>男
							<input style="margin-left: 20px;" type="radio"  disabled="disabled" name="userSex" value="女" />女
						</c:if>
						<c:if test="${'女' == userAccount.userSex}">
							<input type="radio" name="userSex" value="男" disabled="disabled"/>男
							<input style="margin-left: 20px;" type="radio" disabled="disabled" name="userSex" checked="checked" value="女" />女
						</c:if>
					<a class="btn btn-default update-sex">修改</a>
				</div>
				<div class="user-information-div">
					<span>电话：</span>
					<input type="text" name="userTelnumber" readonly="readonly" value="${userAccount.userTelnumber }" />
					<a class="btn btn-default update-a">修改</a>
				</div>
				<!-- <div class="user-information-div">
					<span>地址：</span>
					<input type="text" name="housekeeperAddress" readonly="readonly" value="湖南省长沙市岳麓区" />
					<a class="btn btn-default update-a">修改</a>
				</div> -->
			</div>
		</div>
		
		<!-- 字数限制提示框 -->
		<div class="promptBox-background" id="wordsPrompt">
			<div class="promptBox">
				<div class="promptBox-title">
					芦苇音乐
					<a class="promptBox-close" onclick="showPromptBox('wordsPrompt');" href="javascript:void(0);">x</a>
				</div>
				<div class="promptBox-text">评论字数超出限制</div>
				<div style="text-align:right;">
					<a style="font-size:14px;" onclick="showPromptBox('wordsPrompt');" href="userInformationPage.fw" class="btn btn-default btn-lg">知道了</a>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/userInformation.js"></script>
  </body>
</html>
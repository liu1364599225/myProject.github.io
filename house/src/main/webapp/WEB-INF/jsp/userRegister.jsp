<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>普通用户注册</title>

    <!-- Bootstrap -->
    <link href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="css/userRegister.css" />
    <link rel="stylesheet" href="css/font-style.css" />

    
    

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="bootstrap-3.3.7-dist/js/html5shiv.min.js"></script>
      <script src="bootstrap-3.3.7-dist/js/respond.min.js"></script>
    <![endif]-->
  	</head>
  	<body>
		<div id="logo" class="container">
	  		<a href="javascript:void(0)">
				<div style="float: left;">
					<img src="img/logo.png" width="100px" height="100px" />
				</div>
				<div style="float: left;">
					<span id="sytemName">房屋租赁系统</span>
				</div>
			</a>
		</div>
		
		<div id="center" class="container">
			<div id="userRegister" class="col-md-5 col-md-offset-3">
				<div id="userRegister-title">
					普通用户注册
				</div>
				<form style="margin-top: 20px;" action="userRegister.fw" method="post" enctype="multipart/form-data">
					<div class="information">
						<span class="information-title">
							账户名：
						</span>
						<input id="accountName" name="userAccount" maxlength="16" type="text" class="form-control information-input" placeholder="请设置要注册的账户名">
					</div>
					
					<div class="prompt"></div>
					
					<div class="information" >
						<span  class="information-title">
							密码：
						</span>
						<input id="password" name="userPassword" maxlength="16" type="password" class="form-control information-input" placeholder="请设置登录密码">
					</div>
					
					<div class="prompt"></div>
					
					<div class="information" >
						<span  class="information-title">
							确认密码：
						</span>
						<input id="againPassword" name="againPassword" maxlength="16" type="password" class="form-control information-input" placeholder="请确认登录密码">
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							姓名：
						</span>
						<input id="UserName" name="userName" type="text" class="form-control information-input" placeholder="请输入姓名">
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							联系电话：
						</span>
						<input id="contactWay" name="userTelnumber" maxlength="11" type="text" class="form-control information-input" placeholder="请输入联系方式">
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							用户头像：
						</span>
						<div class="information-input">
							<input id="avatarPhoto" name="avatar" type="file" style="width: 180px;float: left;">
						</div>
					</div>
					
					<div class="prompt"></div>
					
					<div class="information" >
						<span class="information-title">
							性别：
						</span>
						<div class="information-input">
							<li style="list-style-type: none;">
								<input type="radio" name="userSex" value="男" checked="checked"/>男
								<input style="margin-left: 20px;" type="radio" name="userSex" value="女" />女	
							</li>
						</div>
					</div>
					
					<div class="prompt">
						<c:if test="${msg!=null}">
							${msg}
						</c:if>
					</div>
					
					<div id="div-button">
						<button type="submit" id="loginButton" class="btn btn-success">注册</button>
					</div>
				</form>
			</div>
		</div>
		
	    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	    <script src="bootstrap-3.3.7-dist/js/jquery.min.js"></script>
	    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	    <script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	    <script src="js/userRegister.js"></script>
  </body>
</html>
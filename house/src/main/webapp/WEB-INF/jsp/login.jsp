<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

    <!-- Bootstrap -->
    <link href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="css/login.css" />
    <link rel="stylesheet" href="css/font-style.css" />
    <script type="text/javascript">
		function changeCode(img){
			img.src="valicode.fw?"+new Date().getTime();
		}
	</script>

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="../bootstrap-3.3.7-dist/js/html5shiv.min.js"></script>
      <script src="../bootstrap-3.3.7-dist/js/respond.min.js"></script>
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
			<div id="login" class="col-md-4 col-md-offset-7">
				<div id="title">
					账户名密码登录
				</div>
<!--登录校验提示-->	<div id="prompt">${msg }</div>
				<form style="margin-top: 5px;" action="login.fw" method="post">
					<div class="form-group">
						<input id="accountName" name="userAccount" maxlength="16" type="text" class="form-control" placeholder="账号">
					</div>
					<div class="form-group">
						<input id="password" name="userPassword" maxlength="16" type="password" class="form-control" placeholder="密码">
					</div>
					<div id="div-select">
						<span id="form-group-title">请选择您的身份：</span>
						<select id="form-group-select" name="identity">
							<option>普通用户</option>
							<option>房管员</option>
							<option>管理员</option>
						</select>
					</div>
					
					<div id="div-valicode">
						<span style="font-size: 16px;">
							验证码：
						</span>
						<input type="text" id="valicode" name="valicode" placeholder="您的验证码"/>
						<img id="img-valicode" onclick="changeCode(this);" src="valicode.fw" />
					</div>

					
					<div id="div-button">
						<button type="submit" id="loginButton" class="btn btn-success">登  录</button>
						<div class="btn-group" style="margin-left: 10px;">
							<button type="button" id="registerButton" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    	注册 <span class="caret"></span>
						    </button>
							<ul class="dropdown-menu">
								<li>
									<a href="userRegisterPage.fw">普通用户</a>
								</li>
								<li>
									<a href="houseKeeperRegisterPage.fw">房管员</a>
								</li>
							</ul>
						</div>
					</div>
				</form>
			</div>
		</div>
		
	    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	    <script src="js/jquery.js"></script>
	    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	    <script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
  </body>
</html>
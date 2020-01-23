<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login page</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/font-style.css" />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/login.css" />
</head>
<body>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/js/jquery.min.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/login.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.js" ></script>
    <div id="top">
    	<img src="${pageContext.servletContext.contextPath}/img/qqmail_logo_default_35h206ff1.png" id="top-img"/>
    	<div id="top-right">
    		<a href="" class="top-right-a">基本版</a>&nbsp;|&nbsp;
    		<a href="" class="top-right-a">English</a>&nbsp;|&nbsp;
    		<a href="" class="top-right-a">手机版</a>&nbsp;|&nbsp;
    		<a href="" class="top-right-a">企业邮箱</a>
    	</div>
    </div>
    
    <div id="center">
    	<div id="center-left">
    		<p id="center-left-p1">QQ邮箱，常联系！</p>
    		<p class="center-left-p">没有什么能够阻挡</p>
    		<p class="center-left-p">你对自由的向往</p>
    		<p class="center-left-p">天马行空的生涯</p>
    		<p class="center-left-p">你的心了无牵挂</p>
    		<p id="center-left-p2">摘自《蓝莲花》</p>
    		<p id="center-left-p3"><a href="">听更多许巍音乐</a></p>
    	</div>
    	<div id="center-right">
    		<div id="center-right-top">
    			<div id="crt">
    				 <a id="center-left-a1" onclick="quicklogin();">快速登录</a>
    			   <a id="center-left-a2" onclick="accountlogin();">账号密码登录</a>
    			</div>
    		</div>
    		<div id="center-center">
    			${msg}
    		</div>
    		<div id="center-right-bottom1">
    			<form onsubmit="return check();" method="post">
    				<input id="account" type="text" placeholder="支持QQ号/邮箱/手机号登录" class="login" name="account"/>
    				<input id="password" type="password" placeholder="QQ密码" class="login" name="password"/>
    				<div id="checkbox-div">
    					<input type="checkbox" id="checkbox"/><span>下次自动登录</span>
    				</div>
    				<input type="submit" class="btn btn-primary" id="login-bottom" value="登      录"/>
    			</form>
    			<div id="center-right-bottom-a">
	    			<a href="${pageContext.servletContext.contextPath}/fpassword.do">忘记密码？</a>&nbsp;&nbsp;|&nbsp;&nbsp;
	    			<a href="${pageContext.servletContext.contextPath}/register.do">注册新账号？</a>&nbsp;&nbsp;|&nbsp;&nbsp;
	    			<a href="">意见反馈</a>
	    		</div>
    		</div>
    		
    		<div id="center-right-bottom2">
    			 <span id="center-right-bottom2-span">安全登录，防止被盗</span>
    			 <div><img src="${pageContext.servletContext.contextPath}/img/ptqrshow.jpg" /></div>
    			 <a href="" id="center-right-bottom2-a">使用QQ手机版扫描登录</a>
    			 <div id="center-right-bottom2-bottom">
    			 	 <form>
    			 	 	  <input type="checkbox" id="bottom-checkbox"/><span id="bottom-span">下次自动登录</span>
    			 	 	  <span id="bottom-span-a">
	    			 	 	  	<a href="${pageContext.servletContext.contextPath}/register.do">注册新账号</a>&nbsp;&nbsp;|&nbsp;&nbsp;
	    			 	 	    <a href="">意见反馈</a>
    			 	 	  </span>
    			 	 </form>
    			 </div>
    		</div>
    		
    	</div>
    </div>
    <div id="bottom">
    	<a href="" class="bottom-a">关于腾讯</a>&nbsp;|&nbsp;
    	<a href="" class="bottom-a">服务条款</a>&nbsp;|&nbsp;
    	<a href="" class="bottom-a">客服中心</a>&nbsp;|&nbsp;
    	<a href="" class="bottom-a">联系我们</a>&nbsp;|&nbsp;
    	<a href="" class="bottom-a">帮助中心</a>&nbsp;|&nbsp;
    	<span>©1998 - 2018 Tencent Inc. All Rights Reserved.</span>
    </div>
</body>
</html>
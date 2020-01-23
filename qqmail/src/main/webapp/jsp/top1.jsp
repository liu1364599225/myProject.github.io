<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/main.css" />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/font-style.css" />
    
</head>
<body>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/js/jquery.min.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/main.js" ></script>
    <div class="container-fluid" id="top">
    	<div class="col-md-4" id="top-logo">
    		<a href="${pageContext.servletContext.contextPath}/jsp/right.jsp" target="right">
    		  <img src="${pageContext.servletContext.contextPath}/img/logo_0_01f1927.png" id="logo"/>
    		</a>
    		<div id="userinfo">
    			<strong>${user.nickname}</strong>&nbsp;${user.user_account}&nbsp;&nbsp;
   				<font class="am-icon-sort-desc" style="font-size: 20px;"></font>&nbsp;&nbsp;
   				<font class="am-icon-exclamation-circle" id="warning"></font>
    		</div>
    		<span id="userinfo-bottom">
    			<a href="">邮箱</a>
    			&nbsp;|&nbsp;
    			<a href="">设置</a>
    			&nbsp;-&nbsp;
    			<a href="">换肤</a>
    		</span>
    	</div>
    	<div class="col-md-4" id="top-bg">
    		<div class="top-bg-rigth" id="top-bg-right">
    			<font class="am-icon-mobile-phone" id="phone"></font>
    			&nbsp; | &nbsp;
    			<a href="">反馈建议</a>
    			&nbsp; | &nbsp;
    			<a href="">帮助中心</a>
    			&nbsp; | &nbsp;
    			<a href="${pageContext.servletContext.contextPath}/login.do" target="_top">退出</a>
    		</div>
    		
    		<div id="top-search">
    			<font class="am-icon-search" id="search"></font>
    			<input type="text" value="邮件搜索.." id="top-search-text" onblur="textonblur();" onfocus="textonfocus();"/>
    			<font class="am-icon-sort-desc" id="top-search-text-right"></font>
    		</div>
    	</div>
    </div>
</body>
</html>
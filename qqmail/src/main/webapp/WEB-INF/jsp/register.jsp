<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register page</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/font-style.css" />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/register.css" />
</head>
<body>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/js/jquery.min.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/register.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.js" ></script>
    <img  src="${pageContext.servletContext.contextPath}/img/01-3.jpg" id="register-img"/>
    <div id="register-div" class="container-fluid">
    	<div id="register-left-top">
    		 <div class="left-top">意见反馈</div>
    		 <div class="left-top" id="language">简体中文 <span class="glyphicon glyphicon-triangle-bottom"></span>
    		 	  <div id="language-change">
    		 	  	<br/><span>繁體中文</span><br/>
    		 	  	<span>English</span>
    		 	  </div>
    		 </div>
    		 <div class="left-top"><font class="am-icon-qq" id="qqaccount"></font>&nbsp;QQ账号</div>
    		 <div id="leaf-top-img">
    		 	<img src="${pageContext.servletContext.contextPath}/img/logo3.png" />
    		 	<div id="left-img-font">QQ靓号</div>
    		 </div>
    	</div>
    	
    	<div class="col-md-2"></div>
    	<div class="col-md-7" id="register-left-bottom">
  		<div id="bottom-mail-register">QQ邮箱注册</div>
  		<div id="bottom-mail-qqname">个性化QQ邮箱名称</div>
        <form action="${pageContext.servletContext.contextPath}/registerUser.do" method="post">
    		  <div>
    		 	 <input type="text" placeholder="邮箱" id="mail-account" name="account"/>
    		 	 <div id="mail-type"><p id="mail-name">@QQ.com</p><span class="glyphicon glyphicon-triangle-bottom" id="changer-mail-type"></span>
	    		 	 	<ul id="mail-type-ul">
	    		 	 	 <li>@foxmail.com</li>
	    		 	 	 <li>@QQ.com</li>
	    		 	 </ul>
    		 	 </div>
    		 </div>
    		 <div id="account-tip" >请创建邮箱名，由3-18个英文、数字、点、减号、下划线组成</div>
    		 <div class="warn" style="display: none;" id="account-patrn"><font id="warn-font" class="am-icon-exclamation-circle"></font>请输入邮箱</div>
    		 
    		 <div>
    		 	<input type="text" placeholder="昵称" id="nickname" name="nickname"/>
    		 </div>
    		 <div class="warn" style="display: none;" id="nickname-tip"><font id="warn-font" class="am-icon-exclamation-circle"></font>昵称不能为空</div>
    		 
    		 <div>
    		 	<input type="password" placeholder="密码" id="password" name="password"/>
    		 	<div class="warn" style="display: none;" id="password-warn"><font id="warn-font" class="am-icon-exclamation-circle"></font>密码不能为空</div>
    		 	<div style="display: none;" id="password-div-tip">
    		 		<div class="password-tip"><font id="password-font1" class="am-icon-check-circle"></font>不能包括空格</div>
    		 		<div class="password-tip"><font id="password-font2" class="am-icon-exclamation-circle"></font>长度为8-16个字符</div>
    		 		<div class="password-tip"><font id="password-font2" class="am-icon-exclamation-circle"></font>必须包含字母、数字、符号中至少2种</div>
    		 	</div>
    		 </div>
    		 
    		 <div>
    		 	 <div id="phone-num-type"><p id="phonenum">+86</p><span class="glyphicon glyphicon-triangle-bottom" id="phone-change"></span>
	    		 	<ul id="phone-num-type-ul" style="display: none;">
	    		 	 	 <li>中国+86</li>
	    		 	 	 <li>中国香港特别行政区+852</li>
	    		 	 	 <li>中国澳门特别行政区+853</li>
	    		 	 </ul>
    		 	 </div>
    		 	 <input type="text" placeholder="手机号码" id="phone-num" name="phonenum"/>
    		 	 <div id="phone-tip">可通过该手机号找回密码</div>
    		 	 <div class="warn" id="phone-warn" style="display: none;"><font id="warn-font" class="am-icon-exclamation-circle"></font>手机号不能为空</div>
    		 </div>
    		 
    		 <div id="send" style="display: none;">
    		 	 <input type="text" name="code" id="code" placeholder="短信验证码"/>
    		 	 <div id="send-code">发送短信验证码</div>
    		 </div>
    		 <div id="code-tip">验证码错误</div>
    		 <input type="submit" id="register-buttom" value="立即注册"/>
    	</div>
    </form>
    	<div class="col-md-2"></div>
    </div>
</body>
</html>
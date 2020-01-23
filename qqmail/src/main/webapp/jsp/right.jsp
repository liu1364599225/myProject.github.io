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
    <div id="bottom" class="container-fluid">
		<div class="container-fluid" id="bottom-right">
	    	 	  <div class="col-md-8" id="bottom-md">
	    	 	  	<ul id="bottom-md-infoul">
	    	 	  		<li id="bottom-md-infoul-li1">晚上好&nbsp;,&nbsp;<a href="">${user.nickname}</a>。</li>
	    	 	  		<li id="bottom-md-infoul-li2"><a href="">注册英文邮箱帐号</a>
	    	 	  			<span id="bottom-md-infoul-li2-span">(如：chen@foxmail.com)</span>
	    	 	  		</li>
	    	 	  		<li id="bottom-md-infoul-li3">
	    	 	  			<font class="am-icon-envelope-o"></font>
	    	 	  			邮件：0封未读邮件，1封<a href="">星标邮件</a>
	    	 	  		</li>
	    	 	  		<li id="bottom-md-infoul-li4">
	    	 	  			&nbsp;&nbsp;&nbsp;&nbsp;
	    	 	  			<a href="">进入收件箱</a>&nbsp;&nbsp;
	    	 	  			<a href="">订阅中心(7)</a>
	    	 	  		</li>
	    	 	  	</ul>
	    	 	  	
		    	 	  <div id="mail-groom">
		    	 	  	<div id="mail-groom-top"><a href="">邮箱推荐</a></div>
		    	 	  	<div id="mail-groom-img">
		    	 	  		<a href="">
		    	 	  			<img src="${pageContext.servletContext.contextPath}/img/20160218_mailapp01_2x.png" />
		    	 	  		</a>
		    	 	  	</div>
		    	 	  	<ul id="mail-groom-ul">
		    	 	  		<li><font class="am-icon-apple"></font>&nbsp;&nbsp;&nbsp;<a href="">iPhone版</a></li>
		    	 	  		<li><font class="am-icon-heart-o"></font>&nbsp;&nbsp;&nbsp;<a href="">明信片&nbsp;-&nbsp;贺卡</a></li>
		    	 	  		<li id="mobile"><font class="am-icon-mobile"></font>&nbsp;&nbsp;&nbsp;<a href="">&nbsp;iPad版</a></li>
		    	 	  		<li><font class="am-icon-calendar-o"></font>&nbsp;&nbsp;&nbsp;<a href="">记事本&nbsp;-&nbsp;日历</a></li>
		    	 	  		<li><font class="am-icon-android"></font>&nbsp;&nbsp;&nbsp;<a href="">Android版</a></li>
		    	 	  		<li><font class="am-icon-retweet"></font>&nbsp;&nbsp;&nbsp;<a href="">文件中转站</a></li>
		    	 	  	</ul>
		    	 	  </div>
		    	 	  <div id="ending">
		    	 	  	<a href="">2017年8月31日更新</a>&nbsp;|&nbsp;
		    	 	  	<a href="">暖灯行动</a>&nbsp;|&nbsp;
		    	 	  	<a href="">企业邮箱</a>&nbsp;|&nbsp;
		    	 	  	<a href="">开方平台</a>&nbsp;|&nbsp;
		    	 	  	<a href="">体验室</a>&nbsp;|&nbsp;
		    	 	  	<a href="">邮箱助手</a>&nbsp;|&nbsp;
		    	 	  	<a href="">自助查询</a>&nbsp;|&nbsp;
		    	 	  	<a href="">团队博客</a>&nbsp;|&nbsp;
		    	 	  	<a href="">加入我们</a>
		    	 	  	<br/>
		    	 	  	<span>标准版 - <a href="">基本版</a> |  © 1998 - 2018 Tencent Inc. All Rights Reserved</span>
		    	 	  </div>
	    	 	  </div>
	    	 	  <div class="col-md-3" id="right">
	    	 	  	<div id="white-div"></div>
	    	 	  	<div id="mail-tips">
	    	 	  		<b>推荐使用QQ邮箱英文帐号</b>
	    	 	  		<br />
	    	 	  		<span>QQ邮箱英文帐号，不仅保护QQ号码安全，更适合用于发送正式邮件。<a href="">点击前往设置</a></span>
	    	 	  	</div>
	    	 	  	
	    	 	  	<div id="point-out">
	    	 	  		 <div id="point-out-top1" onclick="birthdaytip();">生日提醒</div>
	    	 	  		 <div id="point-out-top2" onclick="mycontent();">我的信息</div>
	    	 	  		 <div id="point-out-content1">
			    	 	  		暂无即将过生日的好友
			    	 	   </div>
			    	 	   
			    	 	   <div id="point-out-content2">
			    	 	   	  <div class="mycontent">积分等级 ： &nbsp;&nbsp;<a href="">4级</a>&nbsp;&nbsp;<a href="">自助查询</a></div>
			    	 	   	  <div class="mycontent">邮箱容量 ： &nbsp;&nbsp;<a href="">2G</a>&nbsp;(已使用6M，0%)</div>
			    	 	   	  <div class="mycontent">上次登录 ： &nbsp;&nbsp;<a href="">4月21日</a></div>
			    	 	   	  <div class="mycontent">垃圾举报 ： &nbsp;&nbsp;<a href="">2次</a></div>
			    	 	   </div>
	    	 	  	</div>
	    	 	  </div>
	    	 	  
	    	 </div>
	    </div>
</body>
</html>
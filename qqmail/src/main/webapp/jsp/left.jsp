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
		<div class="col-md-2" id="bottom-left">
	    	 	   <div id="bottom-left-img">
	    	 	   	   <ul id="bottom-left-img-ul">
	    	 	   	   	  <li>
	    	 	   	   	  	<img src="${pageContext.servletContext.contextPath}/img/2018-04-21_172331.png" />
	    	 	   	   	  	<a href="${pageContext.servletContext.contextPath}/writerLettersPage.do" target="right">写信</a>
	    	 	   	   	  </li>
	    	 	   	   	  <li>
	    	 	   	   	  	<img src="${pageContext.servletContext.contextPath}/img/2018-04-21_171922.png" id="bottom-left-img-ul-md"/>
	    	 	   	   	  	<a href="${pageContext.servletContext.contextPath}/readAll_Inbox.do?pageNum=0" target="right">收信</a>
	    	 	   	   	  </li>
	    	 	   	   	  <li>
	    	 	   	   	  	<img src="${pageContext.servletContext.contextPath}/img/2018-04-21_172354.png" />
	    	 	   	   	  	<a href="${pageContext.servletContext.contextPath}/toLinkManPage.do" target="right">通讯录</a>
	    	 	   	   	  </li>
	    	 	   	   </ul>
	    	 	   </div>
	    	 	   <div id="bottom-left-select">
	    	 	   	   <ul id="bottom-left-select-ul">
	    	 	   	   	  <a href="${pageContext.servletContext.contextPath}/readAll_Inbox.do?pageNum=0" target="right"><li>收件箱</li></a>
	    	 	   	   	  <a href="${pageContext.servletContext.contextPath}/readAll_Star.do?pageNum=0" target="right">
	    	 	   	   	  	<li>星标邮件
	    	 	   	   	       &nbsp;<font class="am-icon-star" id="star-mail"></font>
	    	 	   	   	    </li>
	    	 	   	   	  </a>
	    	 	   	   	  <a href="${pageContext.servletContext.contextPath}/readAll_Flock.do?pageNum=0" target="right"><li>群邮件</li></a>
	    	 	   	   	  <a href="${pageContext.servletContext.contextPath}/readAll_Draft.do?pageNum=0" target="right"><li>草稿箱</li></a>
	    	 	   	   	  <a href="${pageContext.servletContext.contextPath}/readAll_Send.do?pageNum=0" target="right" ><li>已发送</li></a>
	    	 	   	   	  <a href="${pageContext.servletContext.contextPath}/readAll_Delete.do?pageNum=0" target="right">
	    	 	   	   	  	<li>已删除
	    	 	   	   	       <a href="" id="empty" >[清空]</a>
	    	 	   	   	    </li>
	    	 	   	   	  </a>
	    	 	   	   	  <a href="${pageContext.servletContext.contextPath}/readAll_Garbage.do?pageNum=0" target="right">
	    	 	   	   	  	<li>垃圾箱
	    	 	   	   	      <a href="" id="empty">[清空]</a>
	    	 	   	   	    </li>
	    	 	   	   	  </a>
	    	 	   	   	  
	    	 	   	   	  <a href="">
	    	 	   	   	  	<li>QQ邮件订阅</li>
	    	 	   	   	  </a>
	    	 	   	   	  
	    	 	   	   	  <a href="">
	    	 	   	   	  	<div id="othermail-top"></div>
	    	 	   	   	  	<li id="othermail">
		    	 	   	   	  	其他邮箱 
		    	 	   	   	  </li>
		    	 	   	   	  <div id="othermail-bottom"></div>
	    	 	   	   	  </a>
	    	 	   	   	  <a href="">
	    	 	   	   	  	<li>漂流瓶
		    	 	   	   	     &nbsp;<font class="am-icon-leaf" id="leaf"></font>
		    	 	   	   	  </li>
	    	 	   	   	  </a>
	    	 	   	   	  <li><a href="${pageContext.servletContext.contextPath}/toSelectablePage.do" target="right">日历</a> &nbsp;|&nbsp; <a href="bbb">记事本</a></li>
	    	 	   	   	
	    	 	   	   	  <a href="${pageContext.servletContext.contextPath}/readAllFileByUser.do" target="right">
	    	 	   	   	  	<li>在线文档</li>
	    	 	   	   	  </a>
	    	 	   	   	  
	    	 	   	   	  <a href="">
	    	 	   	   	  	<li>附件收藏</li>
	    	 	   	   	  </a>
	    	 	   	   	  
	    	 	   	   	  <a href="">
	    	 	   	   	  	<li>文件中转站</li>
	    	 	   	   	  </a>
	    	 	   	   	  
	    	 	   	   	  <li><a href="aaa">贺卡</a> &nbsp;|&nbsp; <a href="bbb">明信片</a></li>
	    	 	   	   	  
	    	 	   	   	  <a href="">
	    	 	   	   	  	<li>阅读空间</li>
	    	 	   	   	  </a>
	    	 	   	   </ul>
	    	 	   </div>
	    	 	   <div id="bottom-left-select-bottom"></div>
	    	 </div>
	   </div>
</body>
</html>
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
    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/html5shiv.min.js"></script>
      <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/respond.min.js"></script>
    <![endif]-->
    
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7/js/jquery.min.js" ></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7/js/bootstrap.min.js" ></script>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/css/bootstrap.min.css" />
   
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="${pageContext.servletContext.contextPath }/kindeditor/kindeditor-all.js"></script>
	<script charset="utf-8" src="${pageContext.servletContext.contextPath }/kindeditor/lang/zh-CN.js"></script>
	<script charset="utf-8" src="${pageContext.servletContext.contextPath }/kindeditor/plugins/code/prettify.js"></script>
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/sendSuccess.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/font-style.css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/xhr.js" ></script>
  	
</head>
<body>
	<div class="container-fluid" style="padding:50px;">
		<div class="left">
			<img src="${pageContext.servletContext.contextPath }/img/ico_sendf1e9c5d.gif">
		</div>
		<div class="right">
			<div class="container-fluid div1">
				您的邮件已发送
			</div>
			<div class="container-fluid div2">
				此邮件发送成功
			</div>
			<div class="container-fluid div3">
				<c:if test="${style == 'old' }">
					<a href="${pageContext.servletContext.contextPath }/rightPage.do">
						<button class="btn btn-success btn-lg button1">返回邮箱首页</button>
					</a>
					<a href="${pageContext.servletContext.contextPath }/writerLettersPage.do">
						<button class="btn btn-default btn-lg button2">再写一封</button>
					</a>
				</c:if>
				<c:if test="${style == 'new' }">
					<a href="javascript:void(0);">
						<button onclick="window.close()" class="btn btn-success btn-lg button1">关闭窗口</button>
					</a>
					<a href="${pageContext.servletContext.contextPath }/newWriterLettersPage.do">
						<button class="btn btn-default btn-lg button2">再写一封</button>
					</a>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>
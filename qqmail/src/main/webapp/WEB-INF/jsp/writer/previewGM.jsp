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
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/previewWL.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/font-style.css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/previewWL.js" ></script>
  	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
//				items:[//菜单栏配置
//				      
//				      ],
				cssPath : '${pageContext.servletContext.contextPath }/kindeditor/plugins/code/prettify.css',
				uploadJson : '${pageContext.servletContext.contextPath }/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '${pageContext.servletContext.contextPath }/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
		
	</script>
</head>
	<body>
    	<div class="container-fluid">
    		<img src="${pageContext.servletContext.contextPath }/img/logo_0_01f1927.png" width="215px"height="60px" />
    	</div>
    	<div class="container-fluid center">
    		<div class="container-fluid theme">
    			重要文件
    		</div>
    		<div class="container-fluid" style="padding: 0px;margin-top: 15px;margin-bottom: 20px;">
	    		<div class="container-fluid content">
	    			<div class="title">发件人：</div>
	    			<span class="text" style="color: #5fa207;font-weight: bold;">い不说再见 </span>
	    			<span class="text">< 1364599225@qq.com ></span>
	    		</div>
	    		<div class="container-fluid content">
	    			<div class="title">时间：</div>
	    			<span class="text" id="time" style="color: black;"></span>
	    		</div>
	    		<div class="container-fluid content">
	    			<div class="title">收件人：</div>
	    			<span class="text" style="color: black;">是否我已被遗忘</span>
	    			<span class="text">< 452849107@qq.com ></span>
	    		</div>
	    	</div>
    	</div>
		<div class="container-fluid" style="padding: 30px;">
			<textarea class="richText" readonly="true" style="background: url(${pageContext.servletContext.contextPath }/img/notepaperImg/a_04.jpg);background-size: 100%;">11</textarea>
		</div>
	</body>
</html>
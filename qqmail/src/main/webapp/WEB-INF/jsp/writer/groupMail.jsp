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
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/kindeditor/themes/simple/simple.css" />
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="${pageContext.servletContext.contextPath }/kindeditor/kindeditor-all.js"></script>
	<script charset="utf-8" src="${pageContext.servletContext.contextPath }/kindeditor/lang/zh-CN.js"></script>
	<script charset="utf-8" src="${pageContext.servletContext.contextPath }/kindeditor/plugins/code/prettify.js"></script>
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/writerLetters.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/font-style.css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/groupMail.js" ></script>
  	
</head>
<body>
		<div class="container-fluid">
	    	<div id="body1" class="container-fluid">
				<a href="${pageContext.servletContext.contextPath }/writerLettersPage.do"><div class="TAB" style="margin-left: 0px;">普通邮件</div></a>
				<a href="javascript:void(0);"><div class="TAB" style="background-color: #C1D9F3;">群邮件</div></a>
				<a href="javascript:void(0);"><div class="TAB">贺卡</div></a>
				<a href="${pageContext.servletContext.contextPath }/postcardPage.do"><div class="TAB">明信片</div></a>
			</div>
			
<!--群邮件-->
			<div id="groupMail">
				<div id="body2" class="container-fluid" style="padding: 0px;">
					<a href="javascript:void(0);">
						<button class="operation send">发送</button>
					</a>
					<a href="javascript:void(0);">
						<button class="operation draft">存草稿</button>
					</a>
					<a href="${pageContext.servletContext.contextPath }/rightPage.do">
						<button class="operation">关闭</button>
					</a>
<!-- 提示信息	 -->	<div id="message"></div>
					<div id="success"></div>
					<div class="div-right">
						<a class="preview" href="javascript:void(0);">预览</a>
						&nbsp;&nbsp; 
						<a href="${pageContext.servletContext.contextPath }/newGroupMailPage.do"
							target="_blank">新窗口写信</a>
					</div>
				</div>
				<div id="body3" class="container-fluid">
					<div class="row">
						<div class="body3-left">
							<form id="writerForm" action="" method="post">
<!-- 写信方式 -->					<input name="style" type="hidden" value="old">
								<div class="container-fluid">
									<div class="title-div">
										<a class="title" href="#">通讯组</a>
									</div>
									<div class="text-div">
										<select class="input1" name="mailNumber">
											<option class="option" value="" checked="checked">---选择通讯组---</option>
											<c:forEach var="lmgList" items="${lmgList }">
												<option class="option" value="${lmgList.group_name }">${lmgList.group_name }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="container-fluid" style="margin-top:10px;">
									<div class="title-div">
										主题
									</div>
									<div class="text-div text-div-class">
										<input class="input2" id="input2"  name="motive" type="text"/>
										<div class="input2-right" id="input2-right">
											<img src="${pageContext.servletContext.contextPath }/img/2018-04-26_232417.png" width="100%" height="100%" />
										</div>
										<div class="text-div-hidden" id="text-div-hidden">
											<div class="text-div-hidden-title">
												彩色主题...
											</div>
											<div class="text-div-hidden-text">
												<div class="rectangle" style="background-color: #FB5903;"></div>
												<span class="text-div-hidden-text-text">橙红色</span>
											</div>
											
											<div class="text-div-hidden-text">
												<div class="rectangle" style="background-color: #008000;"></div>
												<span class="text-div-hidden-text-text">深绿色</span>
											</div>
											<div class="text-div-hidden-text">
												<div class="rectangle" style="background-color: #A60AF4;"></div>
												<span class="text-div-hidden-text-text">鲜紫色</span>
											</div>
											<div class="text-div-hidden-text">
												<div class="rectangle" style="background-color: black;"></div>
												<span class="text-div-hidden-text-text">纯黑色</span>
											</div>
											<div class="text-div-hidden-a" style="margin-bottom: 5px;">
												<div class="container-fluid" style="text-align: right;">
													<a href="#">
														帮助
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="container-fluid" style="margin-top:20px;">
									<div class="title-div" style="height: 70px;line-height: 120px;">
										正文
									</div>
									<div id="richText-div" style="width:94%;float: right;">
										<textarea class="richText1" name="main_body" cols="100" rows="8"></textarea>
									</div>
								</div>
							</form>
						</div>
						<div class="am-icon-caret-right caret-right" id="caret-right"></div>
						<div class="am-icon-caret-left caret-right" id="caret-left" style="display: none;"></div>
						<div class="body3-right1">
							<div class="container-fluid" style="padding: 5px;">
								<div class="container-fluid addressList">
									通讯组
								</div>
							</div>
							<div class="container-fluid addressList-div">
								<c:forEach var="lmgList" items="${lmgList }">
									<div class="contactsList">${lmgList.group_name }</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div id="body2" class="container-fluid" style="padding: 0px;margin-top: 10px;">
					<a href="javascript:void(0);">
						<button class="operation send">发送</button>
					</a>
					<a href="javascript:void(0);">
						<button class="operation draft">存草稿</button>
					</a>
					<a href="${pageContext.servletContext.contextPath }/rightPage.do">
						<button class="operation">关闭</button>
					</a>
				</div>
			</div>
		</div>
	</body>
</html>
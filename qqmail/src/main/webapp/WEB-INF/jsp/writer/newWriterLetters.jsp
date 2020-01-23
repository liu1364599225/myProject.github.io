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
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/writerLetters.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/font-style.css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/writeLetters.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/xhr.js" ></script>
  	
</head>
<body>
	<div class="container-fluid">
		<!--普通邮件-->
		<div id="ordinaryMail">
			<div id="body2" class="container-fluid" style="padding: 0px;">
				<a href="javascript:void(0);">
					<button class="operation send">发送</button>
				</a> <a href="javascript:void(0);">
					<button class="operation">定时发送</button>
				</a> <a href="javascript:void(0);">
					<button class="operation draft">存草稿</button>
				</a> <a href="javascript:void(0);">
					<button class="operation" onclick="window.close()">关闭</button>
				</a>
				
<!-- 如果页面取到的提示信息不为空则显示提示信息div，否则隐藏 -->
				<c:if var="isflags" test="${message1 != null || message2 != null}">
					<div id="message" style="display:inline;">
						<div id="message-div1">${message1}</div>
						<div id="message-div2">${message2}</div>
					</div>
				</c:if>
				<c:if test="${!isflags }">
					<div id="message">
						<div id="message-div1">${message1}</div>
						<div id="message-div2">${message2}</div>
					</div>
				</c:if>
				<c:if var="isflags" test="${success != null}">
					<div id="success" style="display:inline;">${success }</div>
				</c:if>
				<c:if test="${!isflags}">
					<div id="success"></div>
				</c:if>
				<div class="div-right">
					<a class="preview" href="javascript:void(0);">预览</a>
				</div>
			</div>
			<div id="body3" class="container-fluid">
				<div class="row">
					<div class="body3-left">
						<form id="writerForm" action="" method="post">
<!-- 写信方式 -->				<input name="style" type="hidden" value="new">
							<div class="container-fluid">
								<div class="title-div">
									<a class="title" href="javascript:void(0);">收件人</a>
								</div>
								<div class="text-div">
									<input class="input1" name="mailNumber" type="text" />
								</div>
							</div>
							<div class="container-fluid">
								<div class="text-div" style="margin-top: 3px;">
									<a class="title" href="javascript:void(0);">添加抄送</a> <span style="color: #798699;">-</span>
									<a class="title" href="javascript:void(0);">添加密送</a> <span style="color: #798699;">|</span>
									<a class="title" href="javascript:void(0);">分别发送</a>
								</div>
							</div>
							<div class="container-fluid" style="margin-top: 10px;">
								<div class="title-div">主题</div>
								<div class="text-div text-div-class">
									<input class="input2" id="input2" name="motive" type="text" />
									<div class="input2-right" id="input2-right">
										<img src="${pageContext.servletContext.contextPath }/img/2018-04-26_232417.png" width="100%" height="100%" />
									</div>
									<div class="text-div-hidden" id="text-div-hidden">
										<div class="text-div-hidden-title">彩色主题...</div>
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
												<a href="javascript:void(0);"> 帮助 </a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="container-fluid" style="margin-top: 20px;">
								<div class="title-div" style="height: 70px; line-height: 120px;">
									正文</div>
								<div id="richText-div" style="width: 94%; float: right;">
									<textarea class="richText" name="main_body" cols="100" rows="8"></textarea>
								</div>
							</div>
							<input type="hidden" id="notepaperId" name="notepaperId" value="">
						</form>
						<div class="container-fluid" style="margin-top: 10px;">
							<div class="text-div" style="height: 30px; line-height: 30px;">
								<span>发件人：</span> <span class="title"
									style="color: black; cursor: pointer;"> <span
									style="font-weight: bold;">${user.nickname }</span> <${user.user_account}> <span
									class="am-icon-caret-down"
									style="font-size: 20px; color: #798699;"></span>
								</span> &nbsp;&nbsp;|&nbsp;&nbsp; <span class="title"
									style="color: black; cursor: pointer;"> 其他选项 <span
									class="am-icon-angle-double-down"></span>
								</span>
							</div>
						</div>
					</div>
					<div class="am-icon-caret-right caret-right" id="caret-right"></div>
					<div class="am-icon-caret-left caret-right" id="caret-left"
						style="display: none;"></div>
					<div class="body3-right">
						<div class="body3-right-title">通讯录</div>
						<div class="body3-right-title body3-right-title-right">信纸</div>
						<div class="container-fluid mailList">
							<div class="container-fluid row-div">
								<div class="search-div">
									<input type="text" class="search-input" placeholder="查找联系人..." />
									<span class="am-icon-search close-div" style="color: #9A979B;"></span>
								</div>
							</div>
							<div class="mailList-list mail">
								<div class="container-fluid row-div1">
									<div class="container-fluid row-div-title">
										最近联系人 <a href="${pageContext.servletContext.contextPath}/deleteNewNowlinkman.do" style="float: right;"> 清空 </a>
									</div>
									<div class="container-fluid" style="padding: 5px;">
										<c:forEach var="nlinkman" items="${nlinkmanList }">
											<div class="contactsList">${nlinkman.nickname}</div>
											<input id="nlinkmanMN" type="hidden" value="${nlinkman.user_account}">
										</c:forEach>
										<c:if test="${nlinkmanList.size() == 0 }">
											暂无最近联系人
										</c:if>
									</div>
								</div>
								<div class="container-fluid row-div1">
									<div class="container-fluid row-div-title">邮箱联系人</div>
									<div class="container-fluid" style="padding: 5px;">
										<c:forEach var="groupList" items="${groupList}">
											<div class="groupName">
												<div class="plus">+</div>
												&nbsp; ${groupList.linkman_group.group_name } <a href="javascript:void(0);" class="checkAll">全选</a>
											</div>
											<div class="teamMembers">
												<c:forEach var="userList" items="${groupList.user}">
													<div class="contactsList">${userList.nickname}</div>
													<input class="grouplinkmanMN" type="hidden" value="${userList.user_account}">
												</c:forEach>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
							
							<div class="mailList-list select" style="display:none;">
								<div class="container-fluid row-div-title">
									查找到：
								</div>
								<div class="container-fluid linkmanList" style="padding: 5px;">
								</div>
							</div>
						</div>
						
						<div class="container-fluid mailList" style="display: none;">
							<div class="container-fluid paging">
								<span class="am-icon-caret-left left-span" style="color:#b8bfd0;cursor:pointer;"></span>
								<span class="pageNum">${pageNum }</span>
								<span>/</span>
								<span class="pageCount">${pageCount }</span>
								<c:if var="isflags" test="${pageNum == pageCount }">
									<span class="am-icon-caret-right right-span" style="color:#b8bfd0;cursor:pointer;"></span>
								</c:if>
								<c:if test="${!isflags }">
									<span class="am-icon-caret-right right-span" style="color:blue;cursor:pointer;"></span>
								</c:if>
							</div>
							<div class="container-fluid notepaper-div" style="padding: 4px;">
								<div class="notepaper1">
									<img class="notepaperImg1" src="${pageContext.servletContext.contextPath }/img/notepaperImg/xinzhi_icon2s.png" />
								</div>
								<div class="notepaper-div">
									<c:forEach var="pageList" items="${pageList }">
										<div class="notepaper">
											<img class="notepaperImg" src="${pageContext.servletContext.contextPath }${pageList.notepaper_img }" />
											<input type="hidden" name="nId" value="${pageList.notepaper_id }">
										</div>
									</c:forEach>
								</div>
							</div>
							<div class="container-fluid newNotepaper-button">
								<div class="btn btn-default btn-lg newNotepaper">
									<img class="newNotepaper-img"
										src="${pageContext.servletContext.contextPath }/img/2018-05-07_163131.png" /> <span>设计新信纸</span>
								</div>
								<div class="hidden-div" style="display: none;">
									<div class="hidden-fileUpload">
										<form action="${pageContext.servletContext.contextPath }/fileUp.do" method="post" enctype="multipart/form-data">
											<span style="height: 50px; font-size: 12px; color: #797d86;">请选择要上传的图片，支持gif、jpg和png格式</span>
											<div style="margin-top: 10px;">
												<input type="file" name="newNotepaperImg" style="height: 24px;" />
											</div>
											<div style="margin-top: 10px;">
												<button class="submit-button" type="submit">上传</button>
												<a id="cancel" href="javascript:void(0);"
													style="font-size: 12px; margin-left: 5px;">取消</a>
											</div>
											<input name="style" type="hidden" value="new">
										</form>
									</div>
									<div class="markDown"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="body2" class="container-fluid" style="padding: 0px;">
				<a href="javascript:void(0);">
					<button class="operation send">发送</button>
				</a> <a href="javascript:void(0);">
					<button class="operation">定时发送</button>
				</a> <a href="javascript:void(0);">
					<button class="operation draft">存草稿</button>
				</a> <a href="javascript:void(0);">
					<button class="operation" onclick="window.close()">关闭</button>
				</a>
			</div>
		</div>
	</div>
</body>
</html>
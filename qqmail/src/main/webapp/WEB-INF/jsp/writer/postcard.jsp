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
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/postcard.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/font-style.css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/postcard.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/xhr.js" ></script>
  
</head>
	<body>
		<div class="container-fluid" style="z-index: 900;">
	    	<div id="title" class="container-fluid">
				<a href="${pageContext.servletContext.contextPath }/writerLettersPage.do"><div class="TAB" style="margin-left: 0px;">普通邮件</div></a>
				<a href="${pageContext.servletContext.contextPath }/groupMailPage.do"><div class="TAB">群邮件</div></a>
				<a href="javascript:void(0);"><div class="TAB">贺卡</div></a>
				<a href="javascript:void(0);"><div class="TAB" style="background-color: #C1D9F3;">明信片</div></a>
			</div>
			
			<div class="container-fluid center">
				<div class="col-md-7 postcard-div">
					<div class="container-fluid">
						<div class="row postcard-div-class">
							<div class="col-md-3 postcards">
								<img class="postcard-img" src="${pageContext.servletContext.contextPath }/img/postcardImg/20150923_zhongqiu.png" />
								<input class="postcard-newImg" type="hidden" value="${pageContext.servletContext.contextPath }/img/postcardImg/mask.png" />
								<input class="postcard-music" type="hidden" value="${pageContext.servletContext.contextPath }/mp3/111.mp3" />
							</div>
							<div class="col-md-3 postcards">
								<img class="postcard-img" src="${pageContext.servletContext.contextPath }/img/postcardImg/20150923_guangsu.png" />
								<input class="postcard-newImg" type="hidden" value="${pageContext.servletContext.contextPath }/img/postcardImg/mask2.png" />
								<input class="postcard-music" type="hidden" value="${pageContext.servletContext.contextPath }/mp3/12.mp3" />
							</div>
							<div class="col-md-3 postcards">
								<img class="postcard-img" src="${pageContext.servletContext.contextPath }/img/postcardImg/20150814_duominuo.png" />
								<input class="postcard-newImg" type="hidden" value="${pageContext.servletContext.contextPath }/img/postcardImg/mask3.png" />
								<input class="postcard-music" type="hidden" value="${pageContext.servletContext.contextPath }/mp3/222.mp3" />
							</div>
							<div class="col-md-3 postcards">
								<img class="postcard-img" src="${pageContext.servletContext.contextPath }/img/postcardImg/20141222_shengdanliwu.png" />
								<input class="postcard-newImg" type="hidden" value="${pageContext.servletContext.contextPath }/img/postcardImg/mask4.jpg" />
								<input class="postcard-music" type="hidden" value="${pageContext.servletContext.contextPath }/mp3/333.mp3" />
							</div>
						</div>
						<div class="row postcard-div-class" style="display: none;">
							<div class="col-md-3 postcards">
								<img class="postcard-img" src="${pageContext.servletContext.contextPath }/img/postcardImg/20140928_sishuinianhua.png" />
								<input class="postcard-newImg" type="hidden" value="${pageContext.servletContext.contextPath }/img/postcardImg/mask5.jpg" />
								<input class="postcard-music" type="hidden" value="${pageContext.servletContext.contextPath }/mp3/444.mp3" />
							</div>
						</div>
						<div class="row postcard-div-class" style="display: none;">
							<div class="col-md-3 postcards">
								<img class="postcard-img" src="${pageContext.servletContext.contextPath }/img/postcardImg/20140828_yujianweizhi.png" />
								<input class="postcard-newImg" type="hidden" value="${pageContext.servletContext.contextPath }/img/postcardImg/mask6.jpg" />
								<input class="postcard-music" type="hidden" value="${pageContext.servletContext.contextPath }/mp3/555.mp3" />
							</div>
						</div>
						<div class="container-fluid operation">
							<div class="am-icon-arrow-circle-left direction"></div>
							<div class="circle-div">
								<a class="am-icon-circle circle" style="color: #3A5D86;"></a>
								<a class="am-icon-circle circle"></a>
								<a class="am-icon-circle circle"></a>
							</div>
							<div class="am-icon-arrow-circle-right direction"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="background-div"></div>
		<div class="newPostcard">
			<div class="container-fluid top-div">
				<button type="button" class="close"><span aria-hidden="true">&times;</span></button> 发送明信片
			</div>
			<span class="exceeding">明信片字数超出限制</span>
			<div class="container-fluid center-div">
				<div class="img-div">
					<img id="newImg" src="${pageContext.servletContext.contextPath }/img/postcardImg/mask.png" width="100%" height="100%" />
					<textarea name="message" class="message"></textarea>
				</div>
				<div class="center-div-bottom">
					<div style="float: left;">
						<input class="musicCheckBox" type="checkbox">
						<span class="span-text">背景音乐</span>
						<audio id="music" src=""></audio>
					</div>
					<div style="float: right;">
						<span class="span-text" id="prompt">还能输入</span>
						<span id="words" class="span-text" style="font-family: Georgia,Tahoma,Arial;font-size: 24px;font-style: italic;">80</span>
						<span class="span-text">字</span>
					</div>
				</div>
			</div>
			<div class="container-fluid bottom-div">
				<div style="float: right;">
					<button type="button" class="btn btn-default nextStep">下一步</button>
					<button type="button" class="btn btn-default cancel">取消</button>
				</div>
			</div>
		</div>
		<div class="writerPostcard">
			<div class="container-fluid top-div">
				<button type="button" class="close"><span aria-hidden="true">&times;</span></button> 发送明信片
			</div>
			<div class="container-fluid center-div single-div">
				<div class="center-div-top">
					<a class="group" href="javascript:void(0);">发送到群</a>
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
				</div>
				<div class="body3-left">
					<form id="writerForm" action="${pageContext.servletContext.contextPath }/sendPostcardMail.do" method="post">
						<div class="container-fluid" style="padding: 0px;">
							<div class="title-div">
								收件人
							</div>
							<div class="text-div">
								<input class="input1" name="mailNumber" type="text" />
							</div>
						</div>
						<div class="prompt-div">
							可填写多个收件人，每个人收到的是单独发送的明信片。
						</div>
				
	<!-- 画好的图片	 -->	
						<div class="endPostcard-div">
							<img class="endPostcard-img" src="" />
						</div>
						<div class="music-div" style="display:none;">
							<img class="newImage" src="" />
							<audio id="sendMusic" src="" controls="controls" autoplay="autoplay"></audio>
						</div>
						
	<!-- 发送的明信片内容	-->	
						<textarea class="richText" name="main_body" style="display:none;" ></textarea>
						<div class="center-div-bottom1">
							<input class="musicCheckBox" type="checkbox">
							<span class="span-text">背景音乐</span>
						</div>
					</form>
<!-- 画布 -->
					<canvas id="canvasImg" height="450px" width="610px" style="border:1px solid #d3d3d3;display:none;"></canvas>
				
				</div>
				<div class="body3-right">
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
									最近联系人 <a href="${pageContext.servletContext.contextPath}/deletePostCardNowlinkman.do" style="float: right;"> 清空 </a>
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
				</div>
			</div>
			
			<div class="container-fluid center-div group-div" style="display: none;">
				<div class="center-div-top">
					<a class="single" href="javascript:void(0);">发送到好友</a>
					<!-- 如果页面取到的提示信息不为空则显示提示信息div，否则隐藏 -->
					<div id="messageGroup"></div>
				</div>
				<div class="body3-left">
					<form id="writerGroupForm" action="${pageContext.servletContext.contextPath }/sendPostcardGroupMail.do" method="post">
						<div class="container-fluid" style="padding: 0px;">
							<div class="title-div">
								通讯组
							</div>
							<div class="text-div">
								<select class="selectInput" name="mailNumber">
									<option class="option" value="" checked="checked">---选择通讯组---</option>
									<c:forEach var="lmgList" items="${lmgList }">
										<option class="option" value="${lmgList.group_name }">${lmgList.group_name }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="prompt-div">
							可填写多个收件人，每个人收到的是单独发送的明信片。
						</div>
						<div class="endPostcard-div">
							<img class="endPostcard-img" src="" />
						</div>
						<div class="music-div1" style="display:none;">
							<img class="newImage1" src="" />
						</div>
						
						<textarea class="richText1" name="main_body" style="display:none;" ></textarea>
					</form>
				</div>
								
				<div class="body3-right">
					<div class="container-fluid addressList-div">
						<c:forEach var="lmgList" items="${lmgList }">
							<div class="groupContactsList">${lmgList.group_name }</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="container-fluid bottom-div">
				<div style="float: left;">
					<button type="button" class="btn btn-default lastStep">上一步</button>
				</div>
				<div style="float: right;">
					<button type="button" class="btn btn-default sendMail">发送</button>
					<button type="button" class="btn btn-default sendGroupMail" style="display:none;">发送</button>
					<button type="button" class="btn btn-default cancel">取消</button>
				</div>
			</div>
		</div>
	</body>
</html>
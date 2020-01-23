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
   
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/addLinkMan.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/pick-pcc.min.1.0.1.css">
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/pick-pcc.min.1.0.1.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/addLinkMan.js" ></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/My97DatePicker/WdatePicker.js" ></script>
  	<style>
		body{padding:10px;}
		.pick-area{display: inline-block;}
		.a{float:left;width:100%;margin:10px;}
		.a a{float:left;margin:10px;}
		.a input{float:left;width:400px;padding:10px;margin:10px;outline-color: gold;}
		h1{text-align: center;}
		h3{margin:5px;color:#333;}
		h4{margin:5px;color:#666;padding:0 20px;font-weight: 100;}
		.blank{float:left;width:50%;height:400px;background:cyan;border-top:1px solid #333;margin-top:50px;}
		.blank2{float:left;width:50%;height:400px;background:lightpink;border-top:1px solid #333;padding-top:50px;}
		.box{width:100%;overflow: hidden;background:lightgreen;}
	</style>
</head>
	<body>
		<div class="container-fluid">
			<div class="container-fluid top-div">
				<button class="save">保存</button>
				<a href="${pageContext.servletContext.contextPath}/toLinkManPage.do">
					<button class="cancel">取消</button>
				</a>
				<div class="prompt">${prompt }</div>
			</div>
			<div class="container-fluid bottom-div">
				<div class="center">
					<form id="saveForm" action="${pageContext.servletContext.contextPath }/saveLinkMan.do" method="post">
						<div class="row-div">
							<div class="title-div">
								姓名
							</div>
							<div class="text-div">
								<input class="inputCss nickname" placeholder="联系人姓名" name="nickname" type="text">
							</div>
						</div>
						
						<div class="row-div">
							<div class="title-div">
								个人邮箱
							</div>
							<div class="text-div">
								<input class="inputCss userAccount" placeholder="格式：xxx@qq.com" name="user_account" type="text">
							</div>
						</div>
						
						<div class="row-div">
							<div class="title-div">
								分组
							</div>
							<div class="text-div">
								<select class="inputCss groupId" name="group_id" style="width: 40%;">
									<option checked="checked">---选择通讯组---</option>
									<c:forEach var="group" items="${groupList }">
										<option value="${group.group_id }">${group.group_name }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="row-div">
							<div class="title-div">
								生日
							</div>
							<div class="text-div">
								<input class="inputCss" placeholder="年-月-日" name="hiredate" type="text" onClick="WdatePicker()">
							</div>
						</div>
						
						<div class="row-div">
							<div class="title-div">
								家庭地址
							</div>
							<div class="text-div">
								<a href="javascript:void(0)" class="pick-area pick-area7" id="address-a"></a>
								<input type="hidden" id="address" name="address" class="pick-area-hidden" />
							</div>
						</div>
						
						<div class="row-div">
							<div class="title-div">
								职业
							</div>
							<div class="text-div">
								<input class="inputCss job" placeholder="联系人职业" name="job" type="text">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<script>
			$(".pick-area7").pickArea({
	    		"format": "",
	    		"width": "258px",
	    		"height": "30px",
	    		"borderColor": "#ccc",
	    		"color": '#7894D4',
	    		"arrowColor": "#7894D4"
	    	});
	    </script>
	</body>
</html>
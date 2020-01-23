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
    <title>宠物寄养及医疗服务管理系统</title>
	<link href="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/fosterPage.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/font-style.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/pick-pcc.min.1.0.1.css">


    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/html5shiv.min.js"></script>
      <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div id="top" class="container">
  		<a href="javascript:void(0)">
			<div style="float: left;">
				<span id="logo-img" class="am-icon-home"/>
			</div>
			<div style="float: left;">
				<span id="sytemName">宠物寄养平台</span>
			</div>
		</a>
		<div id="top-navigation">
			<div id="top-navigation-name">
				账户名:${accountName }
			</div>
			<a class="btn btn-default btn-lg" style="margin-top: 18px;"
				href="${pageContext.servletContext.contextPath }/fuIndex.pet?accountName=${accountName }">
				返回上层页面
			</a>
		</div>
	</div>

	<div id="center" class="container" style="margin-top: 50px;">
		<div id="center-center">
		<form action="${pageContext.servletContext.contextPath }/startFoster.pet?accountName=${accountName }&fId=${fId}&style=${style}" method="post">
			<div class="container center-center-c">
				<span class="title">请选择要寄养的宠物：</span>
				<c:forEach  var="pet" items="${petList}">
					<input type="radio" name="pId" style="margin-left: 10px;" value="${pet.getpId()}" />${pet.getpPetname()}
				</c:forEach>
			</div>

			<div class="container center-center-c">
				<span class="title">请选择要寄养的天数：</span>
					<a class="addAndsub" href="javascript:void(0);">-</a>
					<input type="text" id="fosterDay"
					style="width: 40px; height: 20px; text-align: center;"
					disabled="disabled" value="1" />
					<input type="hidden" value="1" id="fosterDay1" name="fosterDay" >
					<a class="addAndsub" href="javascript:void(0);">+</a>
			</div>
			
			<div class="prompt">${msg }</div>
			
			<div class="container center-center-c"
				style="text-align: center; margin-top: 20px;">
				<button class="btn btn-success" type="submit">开始寄养</button>
			</div>
		</form>
		</div>
	</div>

	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/pick-pcc.min.1.0.1.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/xhr.js" ></script>
    <script type="text/javascript">
    	$(function(){
			$(".addAndsub").click(function(){
				var opt = $(this).text();
				if(opt == "-"){
					var num = parseInt($("#fosterDay").val());
					if(num > 1){
						$("#fosterDay").val(--num);
						$("#fosterDay1").val($("#fosterDay").val());
					}
				}else if(opt == "+"){
					var num = parseInt($("#fosterDay").val());
					$("#fosterDay").val(++num);
					$("#fosterDay1").val($("#fosterDay").val());
				}
							
			});
		});
    </script>
</body>
</html>
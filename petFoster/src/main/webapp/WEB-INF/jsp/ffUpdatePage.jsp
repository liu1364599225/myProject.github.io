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
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/ffUpdatePage.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/font-style.css" />

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
				<span id="logo-img" class="am-icon-home" />
			</div>
			<div style="float: left;">
				<span id="sytemName">宠物寄养平台</span>
			</div>
		</a>
		<div id="top-navigation">
			<div id="top-navigation-name">账户名:${accountName }</div>
			<a class="btn btn-default btn-lg" href="${pageContext.servletContext.contextPath }/ffUpdate.pet?accountName=${accountName}"> 返回上层页面 </a>
			<a class="btn btn-default btn-lg" href="${pageContext.servletContext.contextPath }/loginPage.pet"> 退出 </a>
		</div>
	</div>

	<div class="container">
		<div class="col-md-6 col-md-offset-3" id="center"
			style="background-color: white;">
			<div id="title" class="container-fluid">修改寄养家庭信息</div>

			<form style="margin-top: 20px;" method="post" action="${pageContext.servletContext.contextPath }/updateFf.pet?accountName=${accountName}"
				enctype="multipart/form-data">
				<input type="hidden" name="fId" value="${family.getfId() }">
				<div class="information">
					<span class="information-title"> 账户名： </span> <input type="text" name="fAccountname"
						class="form-control information-input" value="${family.getfAccountname() }">
				</div>
				
				<div class="prompt"></div>

				<div class="information">
					<span class="information-title"> 密码： </span> <input type="text" name="fPassword"
						class="form-control information-input" value="${family.getfPassword() }">
				</div>

				<div class="prompt"></div>

				<div class="information">
					<span class="information-title"> 收养人姓名： </span> <input type="text" name="fAdoptername"
						class="form-control information-input" value="${family.getfAdoptername() }">
				</div>

				<div class="prompt"></div>

				<div class="information">
					<span class="information-title"> 收养人性别： </span>
					<c:if test="${family.getfAdoptersex() =='男'}">
						<div class="information-input">
							<li style="list-style-type: none;">
								<input type="radio" name="fAdoptersex" checked="checked" value="男"/>男 
								<input style="margin-left: 20px;" type="radio" name="fAdoptersex" value="女" />女
							</li>
						</div>
					</c:if>
					<c:if test="${family.getfAdoptersex() =='女'}">
						<div class="information-input">
							<li style="list-style-type: none;">
								<input type="radio" name="fAdoptersex" value="男"/>男
								<input style="margin-left: 20px;" type="radio" name="fAdoptersex" value="女" checked="checked"  />女
							</li>
						</div>
					</c:if>
				</div>

				<div class="prompt"></div>

				<div class="information">
					<span class="information-title"> 联系方式： </span> <input type="text" name="fContactway"
						class="form-control information-input" value="${family.getfContactway() }">
				</div>

				<div class="prompt"></div>

				<div class="information">
					<span class="information-title"> 联系地址： </span> <input type="text" name="fAddress"
						class="form-control information-input" value="${family.getfAddress() }">
				</div>

				<div class="prompt"></div>

				<div class="information">
					<span class="information-title"> 寄养经历： </span> <input type="text" name="fFosterexperience"
						class="form-control information-input" value="${family.getfFosterexperience() }">
				</div>

				<div class="prompt"></div>

				<div class="information">
					<span class="information-title"> 可寄养的宠物类型： </span>
					<input type="text" name="fTyperange" class="form-control information-input" value="${family.getfTyperange() }">
				</div>

				<div class="prompt"></div>

				<div class="information">
					<span class="information-title"> 寄养家庭图片： </span>
					<div class="information-input">
						<input id="fosterFamilyPhoto" type="file" name="familyPhoto"
							style="width: 180px; float: left;">
					</div>
				</div>

				<div class="prompt"></div>
				
				<input type="hidden" name="iId" value="${information.getiId() }">
				<div class="information">
					<span class="information-title"> 寄养环境： </span> <input name="iEnvironment"
						type="text" class="form-control information-input" value="${information.getiEnvironment() }">
				</div>
				
				<div class="prompt"></div>
				
				<div class="information">
					<span class="information-title"> 寄养服务： </span> <input
						id="contactWay" name="iFostercare" type="text" class="form-control information-input"
						value="${information.getiFostercare() }">
				</div>
				
				<div class="prompt"></div>
				
				<div class="information">
					<span class="information-title"> 接送服务： </span> <input
						id="contactWay" name="iPickupservice" type="text" class="form-control information-input"
						value="${information.getiPickupservice() }">
				</div>
				
				<div class="prompt"></div>
				
				<div class="information">
					<span class="information-title"> 寄养须知： </span> <input name="iNeedtoknow"
						type="text" class="form-control information-input" value="${information.getiNeedtoknow() }">
				</div>
				
				<div class="prompt"></div>
				
				<div class="information">
					<span class="information-title"> 自我描述： </span> <input
						id="contactWay" name="iDescribe" type="text" class="form-control information-input"
						value="${information.getiDescribe() }">
				</div>
				
				<div class="prompt"></div>
				
				<div class="prompt">
					<c:if test="${msg!=null}">
						${msg}
					</c:if>
				</div>

				<div id="div-button">
					<button type="submit" id="loginButton" class="btn btn-success">保存修改</button>
				</div>
			</form>
		</div>
	</div>

	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/xhr.js" ></script>
</body>
</html>
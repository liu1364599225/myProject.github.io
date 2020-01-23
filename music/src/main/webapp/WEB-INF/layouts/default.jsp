<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title><sitemesh:write property='title' /></title>
	<link rel="stylesheet" href="${ctxsta}/css/bootstrap.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<sitemesh:write property='head' />
  </head>
  <body>

	<jsp:include page="/WEB-INF/layouts/header.jsp" />
	
	<sitemesh:write property='body' />
	
	<jsp:include page="/WEB-INF/layouts/footer.jsp" />
	
	<!-- 全局js -->
		<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="js/jquery.js"></script>
		<script src="js/jPages.js"></script>
		<link href="css/style.css" rel='stylesheet' type='text/css' />
	<!-- 第三方插件 -->
	<sitemesh:write property='myfooter' />

  </body>
</html>

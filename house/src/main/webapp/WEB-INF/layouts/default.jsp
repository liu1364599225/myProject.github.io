<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title><sitemesh:write property='title' /></title>
	<link rel="stylesheet" href="${ctxsta}/bootstrap-3.3.7-dist/css/bootstrap.css" />
	<link rel="stylesheet" href="${ctxsta}/css/jPages.css" />
	<script type="text/javascript" src="${ctxsta}/js/jquery.js"></script>
    <script type="text/javascript" src="${ctxsta}/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script type="text/javascript" src="${ctxsta}/js/jPages.js"></script>
	<script type="text/javascript" src="${ctxsta}/js/xhr.js"></script>
	<sitemesh:write property='head' />
  </head>
  <body>

	<%-- <jsp:include page="/WEB-INF/layouts/header.jsp" /> --%>
	
	<sitemesh:write property='body' />
	
	<%-- <jsp:include page="/WEB-INF/layouts/footer.jsp" /> --%>
	
	<!-- 全局js -->
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<!-- 第三方插件 -->
	<sitemesh:write property='myfooter' />

  </body>
</html>

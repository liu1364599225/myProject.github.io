<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href='${pageContext.servletContext.contextPath}/fullcalendar-3.9.0/fullcalendar.min.css' rel='stylesheet' />
<link href='${pageContext.servletContext.contextPath}/fullcalendar-3.9.0/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/selecttable.css" />
<script src='${pageContext.servletContext.contextPath}/fullcalendar-3.9.0/lib/moment.min.js'></script>
<script src='${pageContext.servletContext.contextPath}/fullcalendar-3.9.0/lib/jquery.min.js'></script>
<script src='${pageContext.servletContext.contextPath}/fullcalendar-3.9.0/fullcalendar.js'></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/selectable.js" ></script>

</head>
<body>
   <div id='calendar'></div>
   <div id="alerttest">
  	 <div id="top">
  	 	  <p>管理事件</p>
  	 	  <a id="close"><img src="${pageContext.servletContext.contextPath}/fullcalendar-3.9.0/demos/img/2018-05-08_151433.png" /></a>
  	 </div>
  	 
  	 <div id="md">
  	 	  <div id="thing-tip">请输入要修改的行程</div>
  	 	  <input type="text" id="thing" name="name"/>
  	 </div>
  	 
  	 <div id="bottom">
  	 	   <a class="bottom-a" id="delete">删除</a>
  	 	   <a class="bottom-a" id="update">修改</a>
  	 	   <a class="bottom-a" id="cancel">取消</a>
  	 </div>
  </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<frameset rows="66,22,*" border="1" frameborder="0">
		<frame name="top1" src="${pageContext.servletContext.contextPath}/jsp/top1.jsp"/>
		<frame name="top2" src="${pageContext.servletContext.contextPath}/jsp/top2.jsp"/>
		<frameset cols="194,*">
			<frame name="left" src="${pageContext.servletContext.contextPath}/jsp/left.jsp" scrolling="no"/>
			<frame name="right" src="${pageContext.servletContext.contextPath}/jsp/right.jsp"/>
		</frameset>
</frameset>
</html>
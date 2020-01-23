<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/font-style.css" />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/wordtest.css" />
  </head>
  <body>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/js/jquery.min.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/wordtest.js" ></script>
    <div id="top">
    	<img src="${pageContext.servletContext.contextPath}/img/getqqicon.jpg" id="top-headimg"/>
    	<font class="am-icon-bell-o" id="bell-font"></font>
    	<input type="text" id="searchword" name="searchword" placeholder="搜索"/>
    	<font class="am-icon-search" id="search-font"></font>
    </div>
    
    <div id="bottom" class="container-fluid">
    	<div id="left"  class="col-md-2">
    		<ul id="left-ul">
    			<li id="recently" class="left-ul-li"><font class="am-icon-history" style="margin-right: 10px; color: #999896;"></font>最近</li>
    			<li class="left-ul-li"><font class="am-icon-file-text-o" style="margin-right: 10px; color: #999896;"></font>全部</li>
    		</ul>
    	</div>
    	<div id="md" class="col-md-8">
    		<div id="md-tip">
    			<span class="md-tip-font" style="color: #999896;">最近更新</span>
    			<span class="md-tip-font">最近查看</span>
    		</div>
    		
    		<c:forEach items="${list}" var="file">
    		    <div id="file-entry">
	    			<font class="am-icon-file-text-o" id="file-img"></font>
	    			<a href="${file.filePath}" target="right">
	    			  <div id="file-content" class="file-content-class">
	    				<div id="file-name">${file.fileName}</div>
	    				<div id="file-info">
	    				   <fmt:formatDate value="${file.uploadDate}" pattern="yyyy-MM-dd"/>
	    				   &nbsp;&nbsp;.&nbsp;&nbsp;${user.nickname}更新
	    				   <a href="deleteById.do?id=${file.fileId}" class="delete-file">删除</a></div>
	    			  </div>
	    			</a>
	    		</div>
    		</c:forEach>
    		
    	</div>
    	<div id="right" class="col-md-2">
    		<a href="" id="again-file">新建</a>
    		<a href="" id="right-a">
    			<div id="join-file" style="color: #808080;">
    			   <span class="glyphicon glyphicon-download-alt" id="right-span"></span>
    			     导入文档
    			   <form method="post" action="${pageContext.servletContext.contextPath}/uploadFile.do" enctype="multipart/form-data" id="uploadform">
    			      <input type="file" title="导入文档" id="input-joinfile" name="inputfile"/>
    			   </form>
    			</div>
    		</a>
    	</div>
    </div>
	</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/font-style.css" />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/linkman.css" />
</head>
<body>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/js/jquery.min.js" ></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/linkman.js" ></script>
    <div class="container-fluid">
    	<div class="col-md-10" id="linkman-left">
    		<div id="left-top">
    			<a href="${pageContext.servletContext.contextPath}/addLinkManPage.do" id="add"><img src="${pageContext.servletContext.contextPath}/img/2018-05-09_232809.png" /></a>
    			<a href="" id="phone-linkman"><img src="${pageContext.servletContext.contextPath}/img/2018-05-09_232949.png" /></a>
    			<a href="#" id="tool">工具<font class="am-icon-caret-down" style="margin-left: 6px;"></font>
    				<ul id="tool-ul">
    					<li>导入QQ邮箱联系人</li>
    					<li>导入其他邮箱联系人</li>
    					<li>导入联系人文件</li>
    					<li>导出联系人</li>
    					<li style="border: solid 1px #CBCBCB; border-top: 0px;"></li>
    					<li>合并联系人</li>
    				</ul>
    			</a>
    			<button id="delete">删除</button>
    			<font class="am-icon-search" id="search-img"></font>
    			<input type="text" id="search-linkman" placeholder="搜索全部联系人"/>
    		</div>
    		
    		<div id="left-md">
    			全部
    		</div>
    		
    		<div id="left-bottom" class="container-fluid">
    			<span class="col-md-1" id="span-c1"><input type="checkbox" id="c1" class="selectall"/></span>
    			<span class="col-md-3">姓名<font class="am-icon-long-arrow-down"></font></span>
    			<span class="col-md-4">邮箱</span>
    			<span class="col-md-2">电话</span>
    			<span class="col-md-2">分组</span>
    		</div>
    		
    		<c:forEach items="${list}" var="info">
    		    <div id="linkman-entry" class="linkman-entry-class">
	    			<span class="col-md-1" id="span-c1"><input type="checkbox" id="c1" class="select"/></span>
	    			<span class="col-md-3">${info.name}</span>
	    			<span class="col-md-4">${info.account}</span>
	    			<span class="col-md-2">${info.tel}</span>
	    			<span class="col-md-2">${info.groupName}</span>
	    		</div>
    		</c:forEach>
    		
    	</div>
    	<div class="col-md-2" id="linkman-right">
    		<div id="tip-title">
    			<a href="" id="linkman">通讯录</a>
    			<a href="" id="newgroup" data-target="#myModal" data-toggle="modal">新建组</a>
    		</div>
    		<ul id="group-ul">
    			<li style="background-color: #5A91D0; color: white;"><a href="#" class="group" style="color: white;">全部</a></li>
    			<c:forEach items="${listGroup}" var="ginfo">
    			    <li><a href="#" class="group">${ginfo.groupName}(${ginfo.num})</a></li>
    			</c:forEach>
    		</ul>
    		
    		<div id="tip-title">
    			<a href="" id="linkman">其他联系人</a>
    		</div>
    		
    		<a href="#" id="history-linkman">历史联系人(3)</a>
    	</div>
    	
    	<!--引用的bootstrap模态框-->
    	<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel" id="myModal">
		  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header" style="background-color: #EAEAEA; border-radius: 3px;">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="gridSystemModalLabel">新建组</h4>
			      </div>
			      <input type="text" id="md-div-search" placeholder="请输入分组的名字"/>
			      <div id="md-div-info">
			      	<div class="info-title" style="float: left;">通讯录</div>
			      	<div class="info-title" style="float: right;">已有联系人</div>
			      	<div class="info-div" style="float: left;">
			      		<!--通讯录-->
			      		<div id="info-div-top">
			      			<input type="text" id="search-linkmaninfo" placeholder="查找联系人..."/>
			      		    <font class="am-icon-search"></font>
			      		</div>
			      		<div id="mail-linkman">邮箱联系人</div>
			      		<ul id="mail-linkman-ul">
			      			<c:forEach items="${listGroup}" var="ginfo">
			      			    <li>
				      				<font class="am-icon-plus-square-o" id="plus"></font>
				      				<span>${ginfo.groupName}</span>
				      				<ul id="ul-linkman-ul">
					      				<c:forEach items="${list}" var="linfo">
						      				<c:if test="${ginfo.groupName==linfo.groupName}">
						      				  <li title="${linfo.account}">${linfo.name}</li>
						      				</c:if>
					      				</c:forEach>
					      		    </ul>
				      			</li>
			      			</c:forEach>
			      		</ul>
			      	</div>
			      	<span id="info-cursor"><font class="am-icon-hand-o-right"></font></span>
			      	<div class="info-div-right" style="float: right;">
			      		
			      	</div>
			      </div>
			      <div class="modal-footer" style="background-color: #EAEAEA;border-radius: 3px;">
			        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			         <button type="button" class="btn btn-primary" data-dismiss="modal" id="save">保存</button>
			      </div>
			    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
    </div>
</body>
</html>
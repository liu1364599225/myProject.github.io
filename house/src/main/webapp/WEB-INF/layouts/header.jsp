<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<!--     bar栏  begin       -->
	<!-- container -->
	
		<div id="top" class="container">
			<c:if test="${'普通用户' == identity }">
		  		<a href="index.fw">
					<div style="float: left;">
						<img src="img/logo.png" width="100px" height="100px" />
					</div>
					<div style="float: left;">
						<span id="sytemName">房屋租赁系统</span>
					</div>
				</a>
			</c:if>
			<c:if test="${'房管员' == identity }">
		  		<a href="hkIndex.fw">
					<div style="float: left;">
						<img src="img/logo.png" width="100px" height="100px" />
					</div>
					<div style="float: left;">
						<span id="sytemName">房屋租赁系统</span>
					</div>
				</a>
			</c:if>
			
			<div id="top-navigation">
				<c:if var="isNull" test="${null == userAccount && null == houseKeeperAccount}">
					<a class="top-navigation-a" href="loginPage.fw">
						登录、注册
					</a>
				</c:if>
				<c:if test="${!isNull }">
					<c:if test="${'普通用户' == identity }">
						<div class="avatar-div" style="">
							<a id="avatar" class="btn btn-default btn-lg" href="#">
							<c:if var="avatar" test="${null == userAccount.userAvatar}">
								<img src="img/userAvatar.jpg" width="100%" height="100%" />
							</c:if>
							<c:if test="${!avatar }">
								<img src="${userAccount.userAvatar}" width="100%" height="100%" />
							</c:if>
							</a>
							<div class="avatar-div-div">
								<p class="userName">${userAccount.userAccount}</p>
								<a href="#" style="margin-left: 0px;">个人信息</a>
								<a href="#" style="margin-left: 0px;">预约记录</a>
								<a href="userExit.fw" style="margin-left: 0px;">退出</a>
							</div>
						</div>
					</c:if>
					<c:if test="${'房管员' == identity }">
						<div class="avatar-div" style="">
							<a id="avatar" class="btn btn-default btn-lg" href="#">
							<c:if var="avatar" test="${null == houseKeeperAccount.housekeeperAvatar}">
								<img src="img/userAvatar.jpg" width="100%" height="100%" />
							</c:if>
							<c:if test="${!avatar }">
								<img src="${houseKeeperAccount.housekeeperAvatar}" width="100%" height="100%" />
							</c:if>
							</a>
							<div class="avatar-div-div">
								<p class="userName">${houseKeeperAccount.housekeeperAccount }</p>
								<a href="#" style="margin-left: 0px;">个人信息</a>
								<a href="#" style="margin-left: 0px;">预约记录</a>
								<a href="houseKeeperExit.fw" style="margin-left: 0px;">退出</a>
							</div>
						</div>
					</c:if>
				</c:if>
			</div>
		</div>
		<!-- categories -->
	<!--     bar栏  end         --> 
	
		
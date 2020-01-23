<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<!--     bar栏  begin       -->
	<!-- container -->
	
<style>
	.imgDiv{
		width:50px;
		height:50px;
		overflow:hidden;
		border-radius:120px;
	}
	
	.user-hiddenDiv{
		width:100px;
		height:auto;
		padding:10px;
		background-color:white;
		line-height:30px;
		text-align:center;
		border:1px solid gainsboro;
		position:absolute;
		top:70px;
		left:0;
		z-index:1000;
		display:none;
	}
</style>
		<div class="header top-header">
		<div class="container" >
			<!-- header -->
				<!-- logo -->
				<div class="logo">
					<a href="indexPage.lw"><img src="images/logo.png" title="musicz" /></a>
				</div>
				<!-- logo -->
				<!-- top-nav -->
				<div class="top-nav">
					<span class="menu"> </span>
					<ul>
						<li><a href="indexPage.lw">主页<span> </span></a></li>
						<!-- 根据用户登录状态显示不同的div -->
							
						<li class="userLi" style="position:relative;">
							<c:if test="${not empty user}">
						        <div class="topbar-info">
									<a rel="nofollow" class="link" style="padding:10px;" href="javascript:void(0);">
										<div class="imgDiv">
											<c:if var="isNull" test="${null == user.usersAvatar}">
												<img width="100%" height="100%" src="${pageContext.servletContext.contextPath}/images/users/userAvatar.jpg" />
											</c:if>
											<c:if test="${!isNull }">
												<img width="100%" height="100%" src="${pageContext.servletContext.contextPath}/${user.usersAvatar}" />
											</c:if>
										</div>
									</a>
								</div>
								
								<!-- 隐藏的div -->
								
								<div class="user-hiddenDiv">
									<p style="font-weight:bold;">${user.usersName}</p>
									<p>vip</p>
									<a style="border:0px;padding:0px;" href="${pageContext.servletContext.contextPath}/exit.lw">退出登录</a>
								</div>
					        </c:if>
					        <c:if test="${empty user}">
					        	<div class="topbar-info"> <a rel="nofollow" class="link" href="${pageContext.servletContext.contextPath}/loginPage.lw">登录/注册</a><span class="sep"></span></div>
       						</c:if>
       					</li>
						<div class="clearfix"> </div>
					</ul>
				</div>
				<div class="clearfix"> </div>
				<!-- top-nav -->
				<!-- script-for-menu -->
				<script>
					$(document).ready(function(){
						$("span.menu").click(function(){
							$(".top-nav ul").slideToggle(200);
						});
					});
					/**
					 * 展示用户登陆下拉菜单
					 */
					$(function() {
						$("#J_userInfo .user").hover(function() {
							$(this).addClass('user-active');
							$(this).children(".user-menu").css('display', 'block').animate({
								height : "120px"
							}, 120);
						}, function() {
							$(this).removeClass('user-active');
							$(this).children(".user-menu").css('display', 'none');
						})
					});

				</script>
				<!-- script-for-menu -->
			</div>
			<!-- header -->
		</div>
		<!-- categories -->
		<div class="categories c-cate">
			<div class="container">
				<div class="categories-left">
					<ul class="options">
						<li><a href="singerPage.lw">歌手</a></li>
						<li><a href="indexPage.lw">专辑</a></li>
						<li><a href="mvList.lw">MV</a></li>
						<c:if test="${user != null }">
							<li><a href="detailed.lw">我的歌单</a></li>
						</c:if>
					</ul>
				</div>
				<div class="categories-right">
					<form>
						<input type="text" placeholder="搜索歌曲，歌手，MV等" required>
						<input type="submit" value="搜索" />
					</form>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		<!-- categories -->
	<!--     bar栏  end         --> 
	
    <script>
   		$(".userLi").mouseout(function(){
    	  $(".user-hiddenDiv").toggle();
    	});
   		$(".userLi").mouseover(function(){
      	  $(".user-hiddenDiv").toggle();
      	});
    </script>
		
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>歌曲详情</title>
		<link href="css/songDetails.css" rel="stylesheet" type="text/css" />
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script type="text/javascript" src="js/jPages.js" ></script>
		<script type="text/javascript" src="js/songList.js"></script>
		 <!-- Custom Theme files -->
   		 <!-- Custom Theme files -->
		<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
		</head>
	<body>
		
		<!-- 登录提示框 -->
		<div class="promptBox-background" id="loginPrompt">
			<div class="promptBox">
				<div class="promptBox-title">
					芦苇音乐
					<a class="promptBox-close" onclick="showPromptBox('loginPrompt');" href="javascript:void(0);"><img src="images/2018-10-24_203251.png" /></a>
				</div>
				<div class="promptBox-text">要登录才能评论，请先登录</div>
				<div style="text-align:right;">
					<a style="font-size:14px;" href="loginPage.lw" class="btn btn-success btn-lg">立即登录</a>
					<a style="font-size:14px;" onclick="showPromptBox('loginPrompt');" href="javascript:void(0);" class="btn btn-default btn-lg">取消</a>
				</div>
			</div>
		</div>
		
		<!-- 字数限制提示框 -->
		<div class="promptBox-background" id="wordsPrompt">
			<div class="promptBox">
				<div class="promptBox-title">
					芦苇音乐
					<a class="promptBox-close" onclick="showPromptBox('wordsPrompt');" href="javascript:void(0);"><img src="images/2018-10-24_203251.png" /></a>
				</div>
				<div class="promptBox-text">评论字数超出限制</div>
				<div style="text-align:right;">
					<a style="font-size:14px;" onclick="showPromptBox('wordsPrompt');" href="javascript:void(0);" class="btn btn-default btn-lg">知道了</a>
				</div>
			</div>
		</div>
		
		
		<!--	歌曲信息	-->
		<div class="container" style="margin-top: 50px;position:relative;padding-left:300px;">
			<div class="singerImg-box">
				<img width="100%" height="100%" src="${songDetails.songPricture}" />
			</div>
			<div class="singer-details">
				<h1 class="songName-h1">${songDetails.songName}</h1>
				<div class="songSketch-div">
					<ul class="songSketch-ul">
						<c:if test="${songDetails.singerName != null }">
							<li class="songSketch-li">歌手：${songDetails.singerName}</li>
						</c:if>
						<c:if test="${songDetails.songtypeName != null }">
							<li class="songSketch-li">类型：${songDetails.songtypeName}</li>
						</c:if>
						<c:if test="${songDetails.specialName != null }">
							<li class="songSketch-li">专辑：${songDetails.specialName}</li>
						</c:if>
						<c:if test="${songDetails.songVip != null && songDetails.songVip != 0}">
							<li class="songSketch-li">VIP专享歌曲</li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
		
		<!--	歌词列表	-->
		<div class="container" style="margin-top: 150px;">
			<h2>歌词</h2>
		</div>
		<div class="container">
			<textarea disabled="disabled" class="lyricsText">${lyricsText }</textarea>
		</div>
		
		<!--	评论列表	-->
		<div class="container" style="margin-top: 20px;">
			<h2>评论</h2>
		</div>
		<div class="container">
			<textarea class="commentsText" placeholder="期待你的评论..."></textarea>
			<div class="prompt-div">
				<div style="padding:10px;">
					<span id="prompt">剩余</span>
					<span id="words" style="color:gray;">200</span>
					<span>字</span>
				</div>
				<div>
					<input id="userId" type="hidden" value="${user.usersId }" />
					<a href="javascript:void(0);" id="commitButton" class="btn btn-success btn-lg">
						发表评论
					</a>
				</div>
			</div>
		</div>
		<div class="container">
			<h4>评论列表</h4>
		</div>
		<div class="container" style="margin-top:30px;border-bottom:1px solid #ededed;" id="movies">
			<c:forEach var="comments" items="${commentsList }">
				<div class="otherComments-div">
					<div class="userAvatar-box">
						<c:if var="isNotNull" test="${comments.usersAvatar != null}">
							<img width="100%" height="100%" src="${comments.usersAvatar }"/>
						</c:if>
						<c:if test="${!isNotNull }">
							<img width="100%" height="100%" src="images/users/userAvatar.jpg"/>
						</c:if>
					</div>
					<p style="font-weight:bold;">${comments.usersName }</p>
					<textarea class="otherComments-text" disabled="disabled">${comments.commentsContent }</textarea>
					<span style="color:#999">${comments.stringTime }</span>
				</div>
			</c:forEach>
		</div>
		
			
		<div class="container" style="margin-top: 40px;">
            <!--分页 start-->
            <div class="fanye">
                <div class="holder"></div>
            </div>
            <!--分页 end-->
      	</div>
		
	<script>
	    $(function() {
	        $("div.holder").jPages({
	            containerID: "movies",
	            previous: "← 上一页",
	            next: "下一页 →",
	            perPage: 10,
	            delay: 5
	        });
	
	    });
    </script>
	
</body>
</html>
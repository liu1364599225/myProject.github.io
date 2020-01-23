<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>歌单歌曲列表</title>
		<link href="css/detailedList.css" rel='stylesheet' type='text/css' />
	</head>
	<body>
	<!-- 登录提示框 -->
		<div class="promptBox-background" id="loginPrompt">
			<div class="promptBox">
				<div class="promptBox-title">
					芦苇音乐
					<a class="promptBox-close" onclick="showPromptBox('loginPrompt');" href="javascript:void(0);"><img src="images/2018-10-24_203251.png" /></a>
				</div>
				<div class="promptBox-text">版权方要求下载此歌曲需付费，请先登录</div>
				<div style="text-align:right;">
					<a style="font-size:14px;" href="loginPage.lw" class="btn btn-success btn-lg">立即登录</a>
					<a style="font-size:14px;" onclick="showPromptBox('loginPrompt');" href="javascript:void(0);" class="btn btn-default btn-lg">取消</a>
				</div>
			</div>
		</div>
		
		<!-- vip提示框 -->
		<div class="promptBox-background" id="vipPrompt">
			<div class="promptBox">
				<div class="promptBox-title">
					芦苇音乐
					<a class="promptBox-close" onclick="showPromptBox('vipPrompt');" href="javascript:void(0);"><img src="images/2018-10-24_203251.png" /></a>
				</div>
				<div class="promptBox-text">版权方要求下载此歌曲需付费，开通会员畅享千万歌曲</div>
				<div style="text-align:right;">
					<a style="font-size:14px;" onclick="showPromptBox('vipPrompt');" href="javascript:void(0);" class="btn btn-default btn-lg">知道了</a>
				</div>
			</div>
		</div>
		
		<div class="container">
			<div id="content">
				<div><h2>${songListAndSong.songlistName}</h2></div>
				<div><a class="btn btn-primary" href="songAllPlayPage.lw">播放全部</a></div>
			</div>
			
		</div>
		<div class="container list-title">
			<ul class="song-list-ul">
				<li class="list-title-0 sequence">&nbsp;</li>
				<li class="list-title-1">歌曲</li>
				<li class="list-title-2">歌手</li>
				<li class="list-title-3">下载</li>
				<li class="list-title-4">播放</li>
			</ul>
		</div>
		<div class="container song-list" id="movies">
			<c:forEach var="song" items="${songListAndSong.songList}" varStatus="sequence">
				<ul class="song-list-ul-1">
					<li class="list-title-0 sequence">${sequence.count}</li>
					<li class="list-title-1"><a href="songDetails.lw?songId=${song.songId}">${song.songName}</a></li>
					<li class="list-title-2"><a href="songList.lw?singerId=${song.singer.singerId}">${song.singer.singerName}</a></li>
					<li class="list-title-3"><a href="songPlayPage.lw?songId=${song.songId}"><div class="play"></div></a></li>
					<!-- 判断该歌曲是否为会员专享歌曲 -->
					<c:if var="isflags" test="${song.songVip == 1}">
						<!-- 判断用户是否登录以及是否为会员，如果都满足则可以正常下载 -->
						<c:if var="isvip" test="${null != user && null != user.usersType && user.usersType == 1}">
							<li class="list-title-4"><a href="songDownload.lw?songId=${song.songId}&songUrl=${song.songSongfile}"><div class="download"></div></a></li>
						</c:if>
						<!-- 如果用户未登录或不是会员则弹出相应的提示框 -->
						<c:if test="${!isvip }">
							<li class="list-title-4"><a href="javascript:void(0);"><div class="download downloadSongFile"></div></a></li>
						</c:if>
					</c:if>
					<!-- 如果该歌曲不是会员专享歌曲，则可以正常下载 -->
					<c:if test="${!isflags}">
						<li class="list-title-4"><a href="songDownload.lw?songId=${song.songId}&songUrl=${song.songSongfile}"><div class="download"></div></a></li>
					</c:if>
				</ul>
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

		function showPromptBox(id){
			$("#"+id).toggle();
		}
		
	    $(function() {
	    	$(".downloadSongFile").click(function(){
	    		$.post('isLoginAndVip.lw',function(data) {
	    			if(data != ""){
	    				if(data == "0"){ //0表示未登录
	    					showPromptBox("loginPrompt");
	    				}else if(data == "1"){ //1表示不是vip
	    					showPromptBox("vipPrompt");
	    				}
	    			}
	    		}, 'text');
	    	});
	    	
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
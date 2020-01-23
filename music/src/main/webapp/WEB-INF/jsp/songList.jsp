<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>歌曲列表</title>
		<link href="css/songList.css" rel="stylesheet" type="text/css" />
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
		
		
		<!--	歌手信息	-->
		<div class="container" style="margin-top: 50px;position:relative;padding-left:300px;">
			<div class="singerImg-box">
				<img width="100%" height="100%" src="${singer.singerPicture}" />
			</div>
			<div class="singer-details">
				<h1>${singer.singerName}</h1>
				<div class="singer-details-text">${singer.singerSketch}</div>
				<div class="moreDetails">
					<a href="javascript:void(0);">
						[更多]
					</a>
					<div class="hidden-div" style="display: none;">
						<div class="moreDetails-div">
							<h3>歌手简介</h3>
							<textarea disabled="disabled" class="moreDetails-box">${singer.singerSketch}</textarea>
						</div>
						<div class="markDown"></div>
					</div>
				</div>
			</div>
		</div>
		
		<!--	歌曲列表	-->
		<div class="container" style="margin-top: 80px;">
			<h2>歌曲列表</h2>
		</div>
		<div class="container" style="padding:20px;text-align:right;">
			<a class="btn btn-default btn-lg" href="songAllPlayPage.lw">
				播放全部
			</a>
		</div>
		<div class="container list-title">
			<ul class="song-list-ul">
				<li class="list-title-0 sequence">&nbsp;</li>
				<li class="list-title-1">歌曲</li>
				<li class="list-title-2">播放</li>
				<li class="list-title-3">下载</li>
				<li class="list-title-4">加入歌单</li>
			</ul>
		</div>
		<div class="container song-list" id="movies">
			<c:forEach var="song" items="${songList}" varStatus="sequence">
				<ul class="song-list-ul">
					<li class="list-title-0 sequence">${sequence.count}</li>
					<li class="list-title-1"><a href="songDetails.lw?songId=${song.songId}">${song.songName}</a></li>
					<li class="list-title-2"><a href="songPlayPage.lw?songId=${song.songId}"><div class="play"></div></a></li>
					
					<!-- 判断该歌曲是否为会员专享歌曲 -->
					<c:if var="isflags" test="${song.songVip == 1}">
						<!-- 判断用户是否登录以及是否为会员，如果都满足则可以正常下载 -->
						<c:if var="isvip" test="${null != user && null != user.usersType && user.usersType == 1}">
							<li class="list-title-3"><a href="songDownload.lw?songId=${song.songId}&songUrl=${song.songSongfile}"><div class="download"></div></a></li>
						</c:if>
						<!-- 如果用户未登录或不是会员则弹出相应的提示框 -->
						<c:if test="${!isvip }">
							<li class="list-title-3"><a href="javascript:void(0);"><div class="download downloadSongFile"></div></a></li>
						</c:if>
					</c:if>
					<!-- 如果该歌曲不是会员专享歌曲，则可以正常下载 -->
					<c:if test="${!isflags}">
						<li class="list-title-3"><a href="songDownload.lw?songId=${song.songId}&songUrl=${song.songSongfile}"><div class="download"></div></a></li>
					</c:if>
					
					<!-- 如果用户为空则不可以将歌曲加入歌单 -->
					<c:if var="isNotNull" test="${null == user}">
						<li class="list-title-4" style="padding-left:15px;"><a href="javascript:void(0);"><div class="add addButton"></div></a></li>
					</c:if>
					<c:if test="${!isNotNull}">
						<li class="list-title-4" style="padding-left:15px;">
							<a href="javascript:void(0);">
								<div class="add" onclick="showList(this);">
									<div class="songlist-hidden">
										<c:if var="myMusicListIsNotNull" test="${null == myMusicList || myMusicList.size() == 0}">
											<p style="color:red;font-size:12px;">你还没有歌单，快去新建一个吧</p>
										</c:if>
										<c:if test="${!myMusicListIsNotNull}">
											<c:forEach var="myList" items="${myMusicList }">
												<a href="addSongtoMyList.lw?songId=${song.songId }&songlistId=${myList.songlistId }&singerId=${singer.singerId}"><p style="color:black;">${myList.songlistName }</p></a>
											</c:forEach>
										</c:if>
									</div>
								</div>
							</a>
						</li>
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
		function showList(obj){
			//终止事件派发
			event.stopPropagation();
			$(obj).find(".songlist-hidden").css("display","inline");
		}
		
		$(document).click(function(event){
			var hiddenClass = $(".songlist-hidden");
			if(!hiddenClass.is(event.target)&&hiddenClass.has(event.target).length === 0){
				$(".songlist-hidden").css("display","none");
			}
		});
	
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
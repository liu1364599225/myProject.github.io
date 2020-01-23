<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.music.entity.Song,com.music.entity.Singer,java.util.List"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>歌曲播放</title>
		<link href="css/smusic.css" rel="stylesheet" type="text/css" />
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		 <!-- Custom Theme files -->
   		 <!-- Custom Theme files -->
		<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
		</head>
	<body>
	<% List<Song> songList = (List<Song>)request.getAttribute("songList"); %>
	<% Singer singer = (Singer)request.getAttribute("singer"); %>
		
		
		<!--	歌曲列表	-->
		<div class="container" style="margin-top: 20px;text-align: center;">
			<h2 style="font-size: 30px;">播放列表</h2>
		</div>
		<div class="container" style="margin-top: 50px;">
			<div class="grid-music-container f-usn">
			    <div class="f-cb">&nbsp;</div>
			    
			    <div id="songList" style="display:none;">${songList}</div>
			    <!-- 列表 -->
			    <div class="m-music-list-wrap">
			    	<div class="inner">
			                <h1 style="font-size:22px;color:#999">暂无播放记录...</h1>
			        </div>
			    </div>
			    
			    <!-- 歌词 -->
			    <div class="m-music-lyric-wrap">
			        <div class="inner">
			            <ul class="js-music-lyric-content">
			                <li class="eof">暂无歌词...</li>
			            </ul>
			        </div>
			    </div>
			    
			    <!-- 播放控制 -->
			    <div class="m-music-play-wrap">
			        <div class="u-cover"></div>
			        <div class="m-now-info">
			            <h1 class="u-music-title"><strong>标题</strong><small>歌手</small></h1>
			            <div class="m-now-controls">
			                <div class="u-control u-process">
			                    <span class="buffer-process"></span>
			                    <span class="current-process"></span>
			                </div>
			                <div class="u-control u-time">00:00/00:00</div>
			                <div class="u-control u-volume">
			                    <div class="volume-process" data-volume="0.50">
			                        <span class="volume-current"></span>
			                        <span class="volume-bar"></span>
			                        <span class="volume-event"></span>
			                    </div>
			                    <a class="volume-control"></a>
			                </div>
			            </div>
			            <div class="m-play-controls">
			                <a class="u-play-btn prev" title="上一曲"></a>
			                <a class="u-play-btn ctrl-play play" title="暂停"></a>
			                <a class="u-play-btn next" title="下一曲"></a>
			                <a class="u-play-btn mode mode-list current" title="列表循环"></a>
			                <a class="u-play-btn mode mode-random" title="随机播放"></a>
			                <a class="u-play-btn mode mode-single" title="单曲循环"></a>
			            </div>
			        </div>
			    </div>
			</div>
		</div>
		
		
	<script src="js/musicList.js"></script>
	<script src="js/smusic.js"></script>
	<script>
		var basePath = window.document.location.href;
		basePath = basePath.substring(0,basePath.lastIndexOf('/')+1);
		var musicList = [<c:forEach items="${songList}" var="song">
							{title:"${song.songName}",
							singer:"${singer.singerName}",
							cover:basePath+"${song.songPricture}",
							src:basePath+"${song.songSongfile}",
							lyric:basePath+"${song.songWordsfile}"},
					     </c:forEach>];
		
	    new SMusic({
	        musicList : musicList,
	        autoPlay  : true,  //是否自动播放
	        defaultMode : 1,   //默认播放模式，随机
	        callback   : function (obj) {  //返回当前播放歌曲信息
	            
	        }
	    });
	</script>
	
</body>
</html>
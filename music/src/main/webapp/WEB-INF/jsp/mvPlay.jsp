<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Contact</title>
		<link href="css/video-js.min.css" rel="stylesheet">
		<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
		<style>
			.m {
				width: 960px;
				height: 400px;
				margin-left: auto;
				margin-right: auto;
				margin-top: 80px;
				
			}
			.video-js .vjs-time-control {
				display: block;
			}
			.video-js .vjs-remaining-time{display: none;}
			.vjs-paused .vjs-big-play-button,
			.vjs-paused.vjs-has-started .vjs-big-play-button {
				display: block;
			}
		</style>
					  <script src="js/video.min.js"></script> 
					  <script src="js/zh-CN.js"></script>
					  <script type="text/javascript">
							var myPlayer = videojs('my-video');
							videojs("my-video").ready(function(){
								var myPlayer = this;
								myPlayer.play();
							});
						</script> 
		</head>
	<body>
		
		<div class="content" style="background-color: black;">
					
					<div class="m">
					  <video id="my-video" class="video-js vjs-big-play-centered " controls preload="auto" style="object-fit: fill; width: 100%; height: 100%"  
						  poster="${mv.mvPriture}" data-setup="{}" loop="true">
						<source src="" type="video/mp4">
						<source src="${mv.mvMvfile}" type="video/webm">
						<source src="http://vjs.zencdn.net/v/oceans.ogv" type="video/ogg">
						<p class="vjs-no-js"> To view this video please enable JavaScript, and consider upgrading to a web browser that <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a> </p>
					  </video>
					  <br/>
						<h4>
						<font color='white'>${mv.mvName}</font></h4>
					</div>
		</div>
	
	
</body>
</html>
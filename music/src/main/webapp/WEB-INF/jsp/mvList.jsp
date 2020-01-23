<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Contact</title>
		<link href="css/video-js.min.css" rel="stylesheet">
		<link href="css/mvList.css" rel='stylesheet' type='text/css' />
		<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
		
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
		
		<!-- content -->
		<div class="content" >
			<c:if test="${not empty mvList}"> 		
			<div class="container">
				<h2>全部MV</h2>
				<ul class="mvList-ul" id="mvPage">
					<c:forEach items="${mvList}" var="mv">
					<li>
						<div class="mvStyle">
							<a class="avatar" href="mv.lw?mvId=${mv.mvId}"><img class="ava" width="250px" height="150px" src="${mv.mvPriture}"><img class="paly" src="images/bofang.jpg"></a>
							<a style="font-weight:bold;font-size:16px;font-style:oblique;line-height:50px;" href="mv.lw?mvId=${mv.mvId}">${mv.mvName}</a><br>
							<a href="songList.lw?singerId=${mv.singer.singerId}">${mv.singer.singerName}</a>
						</div>
					</li>
					</c:forEach>
				</ul>
			</div>
				
			<div class="container" style="margin-top: 40px;">
                <!--分页 start-->
                <div class="fanye">
                    <div class="holder"></div>
                </div>
                <!--分页 end-->
          	</div>
          	</c:if>
		</div>
		
		<!-- container -->
	<script>
	    $(function() {
	        $("div.holder").jPages({
	            containerID: "mvPage",
	            previous: "← 上一页",
	            next: "下一页 →",
	            perPage: 20,
	            delay: 5
	        });
	
	    });
    </script>
	
</body>
</html>
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
		<title>我的歌单</title>
		<link href="css/detailedList.css" rel='stylesheet' type='text/css' />
		<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.js" ></script>
			<script>
	
	    $(function() {
	    	$("#createMusicList").click(function(){
	    	    window.location.href="createDetailed.lw?songlistName="+$("#slName").val()+"&userId=${user.usersId}";
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
		
	</head>
	<body>
	
		<div class="container">
			<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" data-backdrop="static">新建歌单</button>
			<div class="modal fade" id="myModal"  role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header" style="text-align:center;">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">创建新歌单</h4>
					</div>
					<div class="modal-body"  style="text-align:center;">
						歌单名&nbsp;&nbsp;<input id="slName" type="text">
					</div>
					<div class="modal-footer" >
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" id="createMusicList">确认</button>
					</div>
				</div>	
			</div>
			</div>
		</div>
		<div class="container list-title">
			<ul class="song-list-ul">
				<li class="list-title-0 sequence">&nbsp;</li>
				<li class="list-title-1">歌单</li>
				<!-- <li class="list-title-2">歌曲数</li> -->
			</ul>
		</div>
		<div class="container song-list" id="movies">
			<c:forEach var="song" items="${myMusicList}" varStatus="sequence">
				<ul class="song-list-ul">
					<li class="list-title-0 sequence">${sequence.count}</li>
					<li class="list-title-1"><span><a href="detailedList.lw?songlistId=${song.songlistId}">${song.songlistName}</a></span></li>
					<!-- <li class="list-title-2" style="padding-left:15px;">${fn:length(myMusicList)}</li> --!>
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
	
	</body>
</html>
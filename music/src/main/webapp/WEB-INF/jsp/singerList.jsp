<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>歌手列表</title>
		<link href="css/singerList.css" rel="stylesheet" type="text/css" />
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script type="text/javascript" src="js/jPages.js" ></script>
		 <!-- Custom Theme files -->
   		 <!-- Custom Theme files -->
		<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
		</head>
	<body>
		
		<!--	歌手列表	-->
		<div class="content">
			<div class="container">
				<ul class="singerList-ul" id="movies">
					<c:forEach var="singer" items="${singerList}">
						<li class="col-md-2">
							<a href="songList.lw?singerId=${singer.singerId}">
								<div class="singerList-box">
									<img width="100%" height="100%" src="${singer.singerPicture}" />
								</div>
								<h3 class="singerName">${singer.singerName}</h3>
							</a>
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
		</div>
		
	<script>
	    $(function() {
	        $("div.holder").jPages({
	            containerID: "movies",
	            previous: "← 上一页",
	            next: "下一页 →",
	            perPage: 12,
	            delay: 5
	        });
	
	    });
    </script>
	
</body>
</html>
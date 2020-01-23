<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>芦苇音乐网站</title>
		<link href="${pageContext.servletContext.contextPath}/css/bootstrap.css" rel='stylesheet' type='text/css' />
		<link href="${pageContext.servletContext.contextPath}/css/owl.carousel.css" rel='stylesheet' type='text/css' />
		<link href="${pageContext.servletContext.contextPath}/css/style.css" rel='stylesheet' type='text/css' />
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/jPages.js" ></script>
		 <!-- Custom Theme files -->
   		 <!-- Custom Theme files -->
		<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
		</head>
	<style>
		/**分页组件**/

.fanye {
    height: 60px;
}

.holder {
    margin: 15px 0;
}

.holder span {
    display: block;
    width: 28px;
    height: 32x;
    line-height: 32px;
    text-align: center;
    float: left;
    font-size: 14px;
    margin: 0 5px;
}

.holder a {
    overflow: hidden;
    display: block;
    float: left;
    padding: 0 17px;
    height: 32px;
    line-height: 32px;
    margin: 0 3px;
    vertical-align: middle;
    border: 1px solid #DCDCDC;
    color: #707070;
    cursor: pointer;
}

.holder a:hover {
    background-color: #8fc320;
    color: #FFF;
    text-decoration: none;
}

.holder a.jp-previous {
    margin-left: 0;
    margin-right: 15px;
}

.holder a.jp-next {
    margin-left: 15px;
    margin-right: 0;
}

.holder a.jp-current,
a.jp-current:hover {
    background-color: #8fc320;
    color: #FFF;
    border-color: #8fc320;
    font-weight: bold;
}

.holder a.jp-disabled,
a.jp-disabled:hover {
    background-color: #F6F6F6;
    color: #D6D6D6;
    cursor: default;
}

.holder a.jp-current,
a.jp-current:hover {
    background-color: none;
}

/****/


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
	border:1px solid gainsboro;
	text-align:center;
	position:absolute;
	top:70px;
	left:0;
	z-index:1000;
	display:none;
}
		
</style>
	<body>
		<!-- container -->
		<div class="header">
		<div class="container">
			<!-- header -->
				<!-- logo -->
				<div class="logo">
					<a href="${pageContext.servletContext.contextPath}/indexPage.lw"><img src="${pageContext.servletContext.contextPath}/images/logo.png" title="musicz" /></a>
				</div>
				<!-- logo -->
				<!-- top-nav -->
				<div class="top-nav">
					<span class="menu"> </span>
					<ul>
						<li><a href="${pageContext.servletContext.contextPath}/indexPage.lw">主页<span> </span></a></li>
						
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
				</script>
				<!-- script-for-menu -->
			</div>
			<!-- header -->
		</div>
		<!-- banner -->
		
		<div class="banner">
			<!-- slider -->
				<!--- img-slider --->
				<div class="img-slider">
						<!----start-slider-script---->
					<script src="${pageContext.servletContext.contextPath}/js/responsiveslides.min.js"></script>
					 <script>
					    // You can also use "$(window).load(function() {"
					    $(function () {
					      // Slideshow 4
					      $("#slider4").responsiveSlides({
					        auto: true,
					        pager: true,
					        nav: true,
					        speed: 500,
					        namespace: "callbacks",
					        before: function () {
					          $('.events').append("<li>before event fired.</li>");
					        },
					        after: function () {
					          $('.events').append("<li>after event fired.</li>");
					        }
					      });
					
					    });
					  </script>
					<!----//End-slider-script---->
					<!-- Slideshow 4 -->
					    <div  id="top" class="callbacks_container">
					      
					      <ul class="rslides" id="slider4">
					        <li>
					          <img class="img-responsive" src="${pageContext.servletContext.contextPath}/images/slide1.jpg" alt="">
					          <div class="slider-caption">
					          	<div class="slider-caption-inner">
						          	 <h1>芦苇音乐</h1>
						         	 <p>私人音乐空间，极致音乐享受，听我想听的歌，看我最喜欢的爱豆唱跳。在这里享受视听盛宴。</p>
					         	 </div>
					          </div>
					        </li>
					        <li>
					          <img src="${pageContext.servletContext.contextPath}/images/slide3.jpg" alt="">
					           <div class="slider-caption">
					          	 <div class="slider-caption-inner">
						          	 <h1>芦苇音乐</h1>
						         	 <p>私人音乐空间，极致音乐享受，听我想听的歌，看我最喜欢的爱豆唱跳。在这里享受视听盛宴。</p>
					         	 </div>
					          </div>
					        </li>
					        <li>
					          <img src="${pageContext.servletContext.contextPath}/images/slide1.jpg" alt="">
					           <div class="slider-caption">
					           <div class="slider-caption-inner">
						          	 <h1>芦苇音乐</h1>
						         	 <p>私人音乐空间，极致音乐享受，听我想听的歌，看我最喜欢的爱豆唱跳。在这里享受视听盛宴。</p>
					         	 </div>
					          </div>
					        </li>
					      </ul>
					    </div>
					    <div class="clearfix"> </div>
					</div>
						<!-- slider -->
		</div>
		<!-- banner -->
		<!-- categories -->
		<div class="categories">
			<div class="container">
				<div class="categories-left">
					<ul class="options">
						<li><a href="${pageContext.servletContext.contextPath}/singerPage.lw">歌手</a></li>
						<li><a href="#">专辑</a></li>
						<li><a href="${pageContext.servletContext.contextPath}/mvList.lw">MV</a></li>
						<c:if test="${user != null }">
							<li><a href="${pageContext.servletContext.contextPath}/detailed.lw">我的歌单</a></li>
						</c:if>
					</ul>
				</div>
				
				<div class="clearfix"> </div>
			</div>
		</div>
		<!-- categories -->
		<!--<div class="tlinks">芦苇微微网络文化有限公司 <a href="http://www.cssmoban.com/" >版权所有</a></div>-->
		<!-- content -->
		<div class="content">
			<div class="container">
			<!-- content-left -->
			<div class="col-md-8 content-left">
				<div id="movies">
					<c:forEach items="${speList}" var="s">
						<div class="artical">
							<div class="col-md-4 artical-left">
								<a href="${pageContext.servletContext.contextPath}/specialPage.lw?specialId=${s.specialId}"><img src="${pageContext.servletContext.contextPath}/${s.specialPricture}" title="post-name" /></a>
							</div>
							<div class="col-md-8 artical-right">
								<div class="artical-head">
									<h2><a href="${pageContext.servletContext.contextPath}/specialPage.lw?specialId=${s.specialId}">${s.specialName}</a></h2>
									<div class="clearfix"> </div>
								</div>
								<div class="clearfix"> </div>
								<!-- artical-info -->
								<div class="artical-info">
									<p><strong>歌手: </strong>${s.singerName}</p>
									<p><strong style="float: left;">简介:</strong>
									 	<textarea wrap="hard" readonly="readonly" style="width:92%;height:140px;overflow:hidden;border:0px;border-style:none;float: left;outline:none;">${s.specialSketch}</textarea>
									 </p>
								</div>
								<!-- artical-info -->
							</div>
							<div class="clearfix"> </div>
						</div>
					</c:forEach>
					<!-- artical-end -->
				</div>
			
	            <!--分页 start-->
	            <div class="fanye">
	                <div class="holder"></div>
	            </div>
	            <!--分页 end-->
            </div>
			<!-- content-left -->
			<!-- content-right -->
			<div class="col-md-4 content-right">
				<div class="recent-add">
					<!----sreen-gallery-cursual---->
						<div class="sreen-gallery-cursual">
							 <!-- requried-jsfiles-for owl -->
							<link href="${pageContext.servletContext.contextPath}/css/owl.carousel.css" rel="stylesheet">
							    <script src="${pageContext.servletContext.contextPath}/js/owl.carousel.js"></script>
							        <script>
							    $(document).ready(function() {
							      $("#owl-demo").owlCarousel({
							        items : 1,
							        lazyLoad : true,
							        autoPlay : true,
							        navigation : true,
							        navigationText :  false,
							        pagination : true,
							      });
							    });
							    </script>
							 <!-- //requried-jsfiles-for owl -->
							 <!-- start content_slider -->
						       <div id="owl-demo" class="owl-carousel text-center">
					                <div class="item">
					                	<img class="lazyOwl" data-src="${pageContext.servletContext.contextPath}/images/singer/T001R300x300M000000aHmbL2aPXWH.jpg" alt="name">
					                </div>
					                <div class="item">
					                	<img class="lazyOwl" data-src="${pageContext.servletContext.contextPath}/images/singer/T001R300x300M0000025NhlN2yWrP4.jpg" alt="name">
					                </div>
					                <div class="item">
					                	<img class="lazyOwl" data-src="${pageContext.servletContext.contextPath}/images/singer/T001R300x300M000002azErJ0UcDN6.jpg" alt="name">
					                </div>
				              </div>
						<!--//sreen-gallery-cursual---->
				</div>
			</div>
			<div class="clearfix"> </div>
			<!-- popular-allbums -->
			
			<!-- popular-allbums -->
			<!-- content-right -->
			</div>
		</div>
		</div>
		<!-- content -->
		<!-- footer -->
		<div class="footer">
						<div class="container">
							<div class="footer-grids">
								<div class="col-md-3">
									<div class="footer-grid">
										<h5>联系我们</h5>
										<p>网站：www.lwwwmusic.com </p>
										<p>邮箱：123456lwww@169.com</p>
										<p>电话：8888-123456789</p>
										<p>地址：湖南省长沙市岳麓区文轩路123号</p>
									</div>
								</div>
								<div class="col-md-3">
									<div class="footer-grid f-blog">
										<h5>微博</h5>
										<div class="f-blog-artical">
											<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
											<span>March 20,2014</span>
										</div>
										<div class="f-blog-artical f-blog-artical1">
											<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
											<span>March 20,2014</span>
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<div class="footer-grid site-map">
										<h5>关于我们</h5>
										<p> 服务条款 | 用户服务协议 | 隐私政策  | 权利声明  </p>
										<p> 广告服务 | 腾讯招聘 | 客服中心| 网站导航</p>
									</div>
								</div>
								<div class="col-md-3">
									<div class="footer-grid f-gallery">
										<h5>Form the portfolio</h5>
										<div class="f-gallery-grids">
											<div class="f-gallery-grid">
												<ul>
													<li><a href="#"><img src="${pageContext.servletContext.contextPath}/images/singer/T001R300x300M000000aHmbL2aPXWH.jpg" title="name"></a></li>
													<li><a href="#"><img src="${pageContext.servletContext.contextPath}/images/singer/T001R300x300M0000025NhlN2yWrP4.jpg" title="name"></a></li>
													<li><a href="#"><img src="${pageContext.servletContext.contextPath}/images/singer/T001R300x300M000002azErJ0UcDN6.jpg" title="name"></a></li>
													<li><a href="#"><img src="${pageContext.servletContext.contextPath}/images/singer/T001R300x300M000002J4UUk29y8BY.jpg" title="name"></a></li>
													<li><a href="#"><img src="${pageContext.servletContext.contextPath}/images/singer/T001R300x300M000003Nz2So3XXYek.jpg" title="name"></a></li>
													<li><a href="#"><img src="${pageContext.servletContext.contextPath}/images/singer/T001R300x300M0000001v4XU1cZxPy.jpg" title="name"></a></li>
													<div class="clearfix"></div>
												</ul>
											</div>
										</div>
									</div>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
					</div>
		<!-- footer -->
		<!-- copy-right -->
		<div class="copy-right">
			<div class="container">
				<p>Copyright &copy; 1998 - 2018 Tencent. All Rights Reserved.<a href="http://www.cssmoban.com/" target="_blank" title="模板之家">芦苇微微网络文化有限公司</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">版权所有</a></p>
			</div>
		</div>
		<!-- copy-right -->
		<!-- container -->
	
	<script>
	    $(function() {
	        $("div.holder").jPages({
	            containerID: "movies",
	            previous: "← 上一页",
	            next: "下一页 →",
	            perPage: 3,
	            delay: 5
	        });
	
	    });
    </script>
    <script>
   		$(".userLi").mouseout(function(){
    	  $(".user-hiddenDiv").toggle();
    	});
   		$(".userLi").mouseover(function(){
      	  $(".user-hiddenDiv").toggle();
      	});
    </script>
</body>
</html>
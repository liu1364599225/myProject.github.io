<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房源详细信息</title>

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="jeDate/test/jeDate-test.css">
    <link type="text/css" rel="stylesheet" href="jeDate/skin/jedate.css">
    <link href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="css/housing.css" />
    <link rel="stylesheet" href="css/font-style.css" />

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="bootstrap-3.3.7-dist/js/html5shiv.min.js"></script>
      <script src="bootstrap-3.3.7-dist/js/respond.min.js"></script>
    <![endif]-->
  	</head>
  	<body>
		<div id="top" class="container">
	  		<a href="index.fw">
				<div style="float: left;">
					<img src="img/logo.png" width="100px" height="100px" />
				</div>
				<div style="float: left;">
					<span id="sytemName">房屋租赁系统</span>
				</div>
			</a>
			
			<div id="top-navigation">
				<c:if var="isNull" test="${null == userAccount}">
					<a class="top-navigation-a" href="loginPage.fw">
						登录、注册
					</a>
				</c:if>
				<c:if test="${!isNull }">
					<div class="avatar-div" style="">
						<a id="avatar" class="btn btn-default btn-lg" href="#">
						<c:if var="avatar" test="${null == userAccount.userAvatar}">
							<img src="img/userAvatar.jpg" width="100%" height="100%" />
						</c:if>
						<c:if test="${!avatar }">
							<img src="${userAccount.userAvatar}" width="100%" height="100%" />
						</c:if>
						</a>
						<div class="avatar-div-div">
							<p class="userName">${userAccount.userAccount}</p>
							<a href="userInformationPage.fw" style="margin-left: 0px;">个人信息</a>
							<a href="userOrderRecords.fw" style="margin-left: 0px;">预约记录</a>
							<a href="userExit.fw" style="margin-left: 0px;">退出</a>
						</div>
					</div>
				</c:if>
			</div>
		</div>
		
		<div id="center" class="container">
			<div class="container-fluid housing-title">
				<p>${housing.housingTitle }</p>
			</div>
			<div class="container-fluid housing-type">
				<p class="housing-type-p" style="color: red;">
					<strong style="font-size: 26px;">${housing.housingPrice }</strong>元/月
				</p>&nbsp;&nbsp;
				<p class="housing-type-p" style="color: gray;">
					|
				</p>&nbsp;&nbsp;
				<p class="housing-type-p">${housing.housingHousetype }</p>&nbsp;&nbsp;
				<p class="housing-type-p" style="color: gray;">
					|
				</p>&nbsp;&nbsp;
				<p class="housing-type-p">${housing.housingArea }平方米</p>&nbsp;&nbsp;
				<p class="housing-type-p" style="color: gray;">
					|
				</p>&nbsp;&nbsp;
				<p class="housing-type-p">${housing.housingFloor }</p>
			</div>
			<div class="container-fluid housing-div">
				<div class="housing-div-left">
					<div class="carousel slide" id="carousel-388527">
						<ol class="carousel-indicators">
							<c:set value="${ fn:split(housing.housingImage, ';') }" var="imgUrlList" />
							<c:forEach items="${imgUrlList }" var="imgUrl" varStatus="status">
								<c:if test="${status.index == 0 }">
									<li class="active" data-slide-to="${status.index}" data-target="#carousel-388527">
									</li>
								</c:if>
								<c:if test="${status.index >= 1 }">
									<li data-slide-to="${status.index} " data-target="#carousel-388527">
									</li>
								</c:if>
							</c:forEach>
						</ol>
						<div class="carousel-inner housing-div-left-imgDiv">
							<c:forEach items="${imgUrlList }" var="imgUrl" varStatus="status">
								<c:if test="${status.index == 0 }">
									<div class="item active">
										<img alt="" src="${imgUrl }" style="width: 100%;height: 370px;" />
									</div>
								</c:if>
								<c:if test="${status.index >= 1 }">
									<div class="item">
										<img alt="" src="${imgUrl}" style="width: 100%;height: 370px;" />
									</div>
								</c:if>
							</c:forEach>
						</div>
						<a data-slide="prev" href="#carousel-388527" class="left carousel-control prev-next">‹</a>
						<a data-slide="next" href="#carousel-388527" class="right carousel-control prev-next">›</a>
					</div>
				</div>
				<div class="housing-div-right">
					<div style="width: 60%;margin: auto;">
						<div class="housing-div-right-div">
							<img class="housing-div-right-img" src="${houseKeeper.housekeeperAvatar }" />
						</div>
						<div class="housing-div-right-div">
							<p style="color: black;font-size: 20px;">${houseKeeper.housekeeperName }</p>
						</div>
						<div style="padding-top: 14px;">
							<p>性别：${houseKeeper.housekeeperSex }</p>
							<p>地址：${houseKeeper.housekeeperAddress }</p>
							<p>电话：${houseKeeper.housekeeperTelnumber }</p>
						</div>
						<c:if test="${'正在预约' == ordering || '预约成功' == ordering }" var="isOrdering">
							<div class="housing-div-right-div" style="padding-bottom: 20px;">
								<input style="width: 120px;display:none;" id="indate" type="text" placeholder="请选择预约日期" readonly="readonly">
								<a class="btn btn-success" disabled="disabled">${ordering }</a>
							</div>
						</c:if>
						<c:if test="${!isOrdering }">
							<div class="housing-div-right-div" style="padding-bottom: 20px;">
								<input style="width: 120px;" id="indate" type="text" placeholder="请选择预约日期" readonly="readonly">
								<a class="btn btn-success order-housing">预约看房</a>
							</div>
						</c:if>
					</div>
				</div>
			</div>
			<div class="container-fluid housing-information">
				<div class="housing-information-title">
					房屋信息
				</div>
				<div class="housing-information-content">
					<div class="housing-information-content-div">
						<div>
							<span>房源地址：</span>${housing.housingAddress }&nbsp;&nbsp;&nbsp;${housing.housingDetailsaddress }
						</div>
						<div>
							<span>房源价格：</span>${housing.housingPrice }元/月
						</div>
						<div>
							<span>面积：</span>${housing.housingArea }平米
						</div>
					</div>
					<div class="housing-information-content-div">
						<div>
							<span>户型：</span>${housing.housingHousetype }
						</div>
						<div>
							<span>楼层：</span>${housing.housingFloor }
						</div>
						<div>
							<span>发布时间：</span>${housingCreateTime }
						</div>
					</div>
				</div>
			</div>
			
			<div class="container-fluid housing-information">
				<div class="housing-information-title">
					房屋简介
				</div>
				<div class="housing-information-content">
					<div class="housing-information-content-div2">
						${housing.housingAbout }
					</div>
				</div>
			</div>
			
			<div class="container-fluid housing-information">
				<div class="housing-information-title">
					房屋配套
				</div>
				<div class="housing-information-content">
					<div class="housing-information-content-div2" style="line-height: 100px;">
						<c:if test="${0 == houseMating.housematingBed }" var="isflags">
							<span >床</span>
						</c:if>
						<c:if test="${!isflags }">
							<span style="text-decoration:line-through;color: gray;border-color: gray;">床</span>
						</c:if>
						
						<c:if test="${0 == houseMating.housematingWasher }" var="isflags">
							<span >洗衣机</span>
						</c:if>
						<c:if test="${!isflags }">
							<span style="text-decoration:line-through;color: gray;border-color: gray;">洗衣机</span>
						</c:if>
						
						<c:if test="${0 == houseMating.housematingAirconditioner }" var="isflags">
							<span >空调</span>
						</c:if>
						<c:if test="${!isflags }">
							<span style="text-decoration:line-through;color: gray;border-color: gray;">空调</span>
						</c:if>
						
						<c:if test="${0 == houseMating.housematingBalcony }" var="isflags">
							<span >阳台</span>
						</c:if>
						<c:if test="${!isflags }">
							<span style="text-decoration:line-through;color: gray;border-color: gray;">阳台</span>
						</c:if>
						
						<c:if test="${0 == houseMating.housematingRefrigerator }" var="isflags">
							<span >冰箱</span>
						</c:if>
						<c:if test="${!isflags }">
							<span style="text-decoration:line-through;color: gray;border-color: gray;">冰箱</span>
						</c:if>
						
						<c:if test="${0 == houseMating.housematingToilet }" var="isflags">
							<span >卫生间</span>
						</c:if>
						<c:if test="${!isflags }">
							<span style="text-decoration:line-through;color: gray;border-color: gray;">卫生间</span>
						</c:if>
						
						<c:if test="${0 == houseMating.housematingCookhouse }" var="isflags">
							<span >厨房</span>
						</c:if>
						<c:if test="${!isflags }">
							<span style="text-decoration:line-through;color: gray;border-color: gray;">厨房</span>
						</c:if>
						
						<c:if test="${0 == houseMating.housematingTelevision }" var="isflags">
							<span >电视</span>
						</c:if>
						<c:if test="${!isflags }">
							<span style="text-decoration:line-through;color: gray;border-color: gray;">电视</span>
						</c:if>
						
						<c:if test="${0 == houseMating.housematingWaterheater }" var="isflags">
							<span >热水器</span>
						</c:if>
						<c:if test="${!isflags }">
							<span style="text-decoration:line-through;color: gray;border-color: gray;">热水器</span>
						</c:if>
						
						<c:if test="${0 == houseMating.housematingCloset }" var="isflags">
							<span >衣柜</span>
						</c:if>
						<c:if test="${!isflags }">
							<span style="text-decoration:line-through;color: gray;border-color: gray;">衣柜</span>
						</c:if>
						
						<c:if test="${0 == houseMating.housematingWifi }" var="isflags">
							<span >wifi</span>
						</c:if>
						<c:if test="${!isflags }">
							<span style="text-decoration:line-through;color: gray;border-color: gray;">wifi</span>
						</c:if>
						
						<c:if test="${0 == houseMating.housematingSofa }" var="isflags">
							<span >沙发</span>
						</c:if>
						<c:if test="${!isflags }">
							<span style="text-decoration:line-through;color: gray;border-color: gray;">沙发</span>
						</c:if>
					</div>
				</div>
			</div>
			
			<div class="container-fluid housing-information">
				<div class="housing-information-title">
					用户评论
				</div>
				<div class="housing-information-content">
					<div class="container-fluid">
						<textarea class="commentsText" placeholder="期待你的评论..."></textarea>
						<div class="prompt-div">
							<div style="padding:10px;">
								<span id="prompt">剩余</span>
								<span id="words" style="color:gray;">200</span>
								<span>字</span>
							</div>
							<div>
								<input id="userId" type="hidden" value="${userAccount.userId }" />
								<a href="javascript:void(0);" id="commitButton" class="btn btn-success btn-lg">
									发表评论
								</a>
							</div>
						</div>
					</div>
					<div class="container-fluid">
						<h4>评论列表</h4>
					</div>
					<div class="container-fluid" style="margin-top:30px;border-bottom:1px solid #ededed;" id="movies">
						<c:if test="${0 != commentList.size() }" var="isNotNull">
							<c:forEach var="comment" items="${commentList }">
								<div class="otherComments-div">
									<div class="userAvatar-box">
										<c:if var="isNotNull" test="${comment.user.userAvatar != null}">
											<img width="100%" height="100%" src="${comment.user.userAvatar }"/>
										</c:if>
										<c:if test="${!isNotNull }">
											<img width="100%" height="100%" src="img/userAvatar.jpg"/>
										</c:if>
									</div>
									<p style="font-weight:bold;">${comment.user.userAccount }</p>
									<textarea class="otherComments-text" disabled="disabled">${comment.commentText }</textarea>
									<span style="color:#999">${comment.commentTime }</span>
								</div>
							</c:forEach>
						</c:if>
						<c:if test="${! isNotNull }">
							<p style="text-align: center;font-size: 16px;">暂无评论~</p>
						</c:if>
					</div>
				</div>
			</div>
			
				
			<div class="container-fluid" style="margin-top: 40px;float: right;">
	            <!--分页 start-->
	            <div class="fanye">
	                <div class="holder"></div>
	            </div>
	            <!--分页 end-->
	      	</div>
		
			<!-- 预约提示框 -->
			<div class="promptBox-background" id="orderPrompt">
				<div class="promptBox">
					<div class="promptBox-title">
						房屋租赁系统
						<a class="promptBox-close" onclick="showPromptBox('orderPrompt');" href="javascript:void(0);">x</a>
					</div>
					<div class="promptBox-text">请选择一个预约时间</div>
					<div style="text-align:right;">
						<a style="font-size:14px;" onclick="showPromptBox('orderPrompt');" href="javascript:void(0);" class="btn btn-default btn-lg">知道了</a>
					</div>
				</div>
			</div>
		
			<!-- 登录提示框 -->
			<div class="promptBox-background" id="loginPrompt">
				<div class="promptBox">
					<div class="promptBox-title">
						房屋租赁系统
						<a class="promptBox-close" onclick="showPromptBox('loginPrompt');" href="javascript:void(0);">x</a>
					</div>
					<div class="promptBox-text">要登录才能评论，请先登录</div>
					<div style="text-align:right;">
						<a style="font-size:14px;" href="loginPage.fw" class="btn btn-success btn-lg">立即登录</a>
						<a style="font-size:14px;" onclick="showPromptBox('loginPrompt');" href="javascript:void(0);" class="btn btn-default btn-lg">取消</a>
					</div>
				</div>
			</div>
			
			
			<!-- 字数限制提示框 -->
			<div class="promptBox-background" id="wordsPrompt">
				<div class="promptBox">
					<div class="promptBox-title">
						房屋租赁系统
						<a class="promptBox-close" onclick="showPromptBox('wordsPrompt');" href="javascript:void(0);">x</a>
					</div>
					<div class="promptBox-text">评论字数超出限制</div>
					<div style="text-align:right;">
						<a style="font-size:14px;" onclick="showPromptBox('wordsPrompt');" href="javascript:void(0);" class="btn btn-default btn-lg">知道了</a>
					</div>
				</div>
			</div>
			
		</div>
		
		
		<script type="text/javascript" src="jeDate/src/jedate.js"></script>
		<script type="text/javascript" src="js/housing.js" ></script>
			
		<script type="text/javascript">
			var myDate = new Date();
			//获取当前年
			var year=myDate.getFullYear();
			//获取当前月
			var month=myDate.getMonth()+1;
			//获取当前日
			var day=myDate.getDate();
			
	    	jeDate("#indate",{
			    dateCell:"#test",
			    format:"YYYY年MM月DD日",
			    isTime:false, 
			    minDate:year+"-"+month+"-"+day
	    	})
		    $(function() {
		        $("div.holder").jPages({
		            containerID: "movies",
		            previous: "← 上一页",
		            next: "下一页 →",
		            perPage: 5,
		            delay: 5
		        });
		
		    });
	    </script>
  </body>
</html>
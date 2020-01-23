<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户个人预约记录</title>

    <link rel="stylesheet" href="css/userOrderRecords.css" />
    <link rel="stylesheet" href="css/font-style.css" />
    <link rel="stylesheet" href="css/jPages.css" />

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
			<div class="container-fluid title">
				<p>预约记录</p>
			</div>
			
			<div class="container-fluid records-div" style="font-weight: bold;font-size: 16px;margin-bottom: 0px;">
				<div class="records-div-div1">
					序号
				</div>
				<div class="records-div-div2">
			  		房源图片
				</div>
				<div class="records-div-div3">
			  		房源标题
				</div>
				<div class="records-div-div4">
			  		房管员姓名
				</div>
				<div class="records-div-div5">
			  		看房日期
				</div>
				<div class="records-div-div6">
			  		记录日期
				</div>
				<div class="records-div-div7">
			  		房源详细地址
				</div>
				<div class="records-div-div8">
			  		预约状态
				</div>
			</div>
			<div id="movies">
				<c:forEach items="${uRecordList }" var="uRecord" varStatus="status">
					<div class="container-fluid records-div">
						<div class="records-div-div1">
							${status.index+1 }
						</div>
						<div class="records-div-div2">
					  		<div class="records-div-div2-div">
				  				<img class="records-div-div2-img" src="${fn:split(uRecord.housing.housingImage, ';')[0] }"/>
					  		</div>
						</div>
						<div class="records-div-div3">
							<div class="records-div-div3-div">
					  			${uRecord.housing.housingTitle }
					  		</div>
						</div>
						<div class="records-div-div4">
					  		${uRecord.housekeeperName }
						</div>
						<div class="records-div-div5">
					  		${uRecord.lookHouseTime }
						</div>
						<div class="records-div-div6">
							<div class="records-div-div6-div">
					  			${uRecord.recordTime }
					  		</div>
						</div>
						<div class="records-div-div7">
							<div class="records-div-div7-div">
						  		${uRecord.housing.housingDetailsaddress }
							</div>
						</div>
						<c:if test="${'正在预约' == uRecord.reservationrecordState }">
							<div class="records-div-div8">
						  		<a class="btn btn-default" href="cancelOrder.fw?reservationrecordId=${uRecord.reservationrecordId }">取消预约</a>
							</div>
						</c:if>
						<c:if test="${'预约成功' == uRecord.reservationrecordState }">
							<div class="records-div-div8">
						  		预约成功
							</div>
						</c:if>
						<c:if test="${'预约失败' == uRecord.reservationrecordState }">
							<div class="records-div-div8">
						  		预约失败
							</div>
						</c:if>
						<c:if test="${'已取消' == uRecord.reservationrecordState }">
							<div class="records-div-div8">
						  		已取消
							</div>
						</c:if>
						<c:if test="${'已失效' == uRecord.reservationrecordState }">
							<div class="records-div-div8">
						  		已失效
							</div>
						</c:if>
					</div>
				</c:forEach>
			</div>
			
			<div class="container-fluid" style="margin-top: 30px;float: right;">
		        <!--分页 start-->
		        <div class="fanye">
		            <div class="holder"></div>
		        </div>
		        <!--分页 end-->
		  	</div>
			
		</div>
		<script type="text/javascript" src="js/userOrderRecords.js" ></script>
		<script type="text/javascript">
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
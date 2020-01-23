<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房管员个人预约记录</title>

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="jeDate/test/jeDate-test.css">
    <link type="text/css" rel="stylesheet" href="jeDate/skin/jedate.css">
    <link rel="stylesheet" href="css/userOrderRecords.css" />
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
	  		<a href="hkIndex.fw">
				<div style="float: left;">
					<img src="img/logo.png" width="100px" height="100px" />
				</div>
				<div style="float: left;">
					<span id="sytemName">房屋租赁系统</span>
				</div>
			</a>
			
			<div id="top-navigation">
				<c:if var="isNull" test="${null == houseKeeperAccount}">
					<a class="top-navigation-a" href="loginPage.fw">
						登录、注册
					</a>
				</c:if>
				<c:if test="${!isNull }">
					<div class="avatar-div" style="">
						<a id="avatar" class="btn btn-default btn-lg" href="#">
						<c:if var="avatar" test="${null == houseKeeperAccount.housekeeperAvatar}">
							<img src="img/userAvatar.jpg" width="100%" height="100%" />
						</c:if>
						<c:if test="${!avatar }">
							<img src="${houseKeeperAccount.housekeeperAvatar}" width="100%" height="100%" />
						</c:if>
						</a>
						<div class="avatar-div-div">
							<p class="userName">${houseKeeperAccount.housekeeperAccount }</p>
							<a href="houseKeeperInformationPage.fw" style="margin-left: 0px;">个人信息</a>
							<a href="#" style="margin-left: 0px;">预约记录</a>
							<a href="houseKeeperExit.fw" style="margin-left: 0px;">退出</a>
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
				<div class="records-div-div4" style="width: 8%;">
			  		用户姓名
				</div>
				<div class="records-div-div5" style="width: 10%;">
			  		联系电话
				</div>
				<div class="records-div-div6">
			  		看房日期
				</div>
				<div class="records-div-div7" style="width: 10%;">
			  		记录日期
				</div>
				<div class="records-div-div8" style="width: 19%;">
			  		操作
				</div>
			</div>
			<div id="movies">
				<c:forEach items="${hRecordList }" var="hRecord" varStatus="status">
					<div class="container-fluid records-div">
						<div class="records-div-div1">
							${status.index+1 }
						</div>
						<div class="records-div-div2">
					  		<div class="records-div-div2-div">
				  				<img class="records-div-div2-img" src="${fn:split(hRecord.housing.housingImage, ';')[0] }"/>
					  		</div>
						</div>
						<div class="records-div-div3">
							<div class="records-div-div3-div">
					  			${hRecord.housing.housingTitle }
					  		</div>
						</div>
						<div class="records-div-div4" style="width: 8%;">
					  		${hRecord.user.userName }
						</div>
						<div class="records-div-div5" style="width: 10%;">
					  		${hRecord.user.userTelnumber }
						</div>
						<div class="records-div-div6">
					  		${hRecord.lookHouseTime }
						</div>
						<div class="records-div-div7" style="width: 10%;">
							<div class="records-div-div7-div">
								${hRecord.recordTime }
							</div>
						</div>
						<c:if test="${'正在预约' == hRecord.reservationrecordState }">
							<div class="records-div-div8" style="width: 19%;">
						  		<a class="btn btn-default" href="acceptOrder.fw?reservationrecordId=${hRecord.reservationrecordId }">接受预约</a>
						  		<a class="btn btn-default" href="refuseOrder.fw?reservationrecordId=${hRecord.reservationrecordId }">拒绝预约</a>
							</div>
						</c:if>
						<c:if test="${'预约成功' == hRecord.reservationrecordState }">
							<div class="records-div-div8" style="width: 19%;">
						  		已同意
							</div>
						</c:if>
						<c:if test="${'预约失败' == hRecord.reservationrecordState }">
							<div class="records-div-div8" style="width: 19%;">
						  		已拒绝
							</div>
						</c:if>
						<c:if test="${'已取消' == hRecord.reservationrecordState }">
							<div class="records-div-div8" style="width: 19%;">
						  		用户已取消
							</div>
						</c:if>
						<c:if test="${'已失效' == hRecord.reservationrecordState }">
							<div class="records-div-div8" style="width: 19%;">
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布房源</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="jqueryfileinput/css/index.css">
    <link rel="stylesheet" href="css/publishHousing.css" />
    <link rel="stylesheet" href="css/font-style.css" />
    <link rel="stylesheet" href="css/pick-pcc.min.1.0.1.css">
	<style>
		body{padding:10px;}
		.pick-area{display: inline-block;}
		.a{float:left;width:100%;margin:10px;}
		.a a{float:left;margin:10px;}
		.a input{float:left;width:400px;padding:10px;margin:10px;outline-color: gold;}
		h1{text-align: center;}
		h3{margin:5px;color:#333;}
		h4{margin:5px;color:#666;padding:0 20px;font-weight: 100;}
		.blank{float:left;width:50%;height:400px;background:cyan;border-top:1px solid #333;margin-top:50px;}
		.blank2{float:left;width:50%;height:400px;background:lightpink;border-top:1px solid #333;padding-top:50px;}
		.box{width:100%;overflow: hidden;background:lightgreen;}
	</style>
    
    

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
							<a href="hkOrderRecords.fw" style="margin-left: 0px;">预约记录</a>
							<a href="houseKeeperExit.fw" style="margin-left: 0px;">退出</a>
						</div>
					</div>
				</c:if>
			</div>
		</div>
		
		<div id="center" class="container">
			<div id="userRegister" class="col-md-5 col-md-offset-1">
				<div id="userRegister-title">
					发布房源
				</div>
				<form action="publishHousing.fw" method="post" enctype="multipart/form-data" style="margin-top: 20px;">
					<div class="information">
						<span class="information-title">
							房源标题：
						</span>
						<input id="housingTitle" name="housingTitle" type="text" class="form-control information-input" placeholder="请输入房源标题">
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							房源价格：
						</span>
						<div class="information-input">
							<input id="housingPrice" name="housingPrice" type="text" class="form-control" style="width: 100px;float: left;">
							<p style="margin-left: 5px;float: left;font-weight: bold;">元/月</p>
						</div>
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							房源面积：
						</span>
						<div class="information-input">
							<input id="housingArea" name="housingArea" type="text" class="form-control" style="width: 100px;float: left;">
							<p style="margin-left: 5px;float: left;font-weight: bold;">平方米</p>
						</div>
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							房源户型：
						</span>
						<div class="information-input">
							<select name="housingHousetype" class="housingType-select">
								<option>0室</option>
								<option>1室</option>
								<option>2室</option>
								<option>3室</option>
								<option>4室</option>
								<option>5室</option>
								<option>6室</option>
								<option>7室</option>
								<option>8室</option>
								<option>9室</option>
								<option>10室</option>
							</select>
							<select name="housingHousetype" class="housingType-select">
								<option>0厅</option>
								<option>1厅</option>
								<option>2厅</option>
								<option>3厅</option>
								<option>4厅</option>
								<option>5厅</option>
								<option>6厅</option>
								<option>7厅</option>
								<option>8厅</option>
								<option>9厅</option>
								<option>10厅</option>
							</select>
						</div>
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							房源楼层：
						</span>
						<select name="housingFloor" class="information-input">
							<option>第1层</option>
							<option>第2层</option>
							<option>第3层</option>
							<option>第4层</option>
							<option>第5层</option>
							<option>第6层</option>
							<option>第7层</option>
							<option>第8层</option>
							<option>第9层</option>
							<option>第10层</option>
							<option>第11层</option>
							<option>第12层</option>
							<option>第13层</option>
							<option>第14层</option>
							<option>第15层</option>
							<option>第16层</option>
							<option>第17层</option>
							<option>第18层</option>
							<option>第19层</option>
							<option>第20层</option>
							<option>第21层</option>
							<option>第22层</option>
							<option>第23层</option>
							<option>第24层</option>
							<option>第25层</option>
							<option>第26层</option>
							<option>第27层</option>
							<option>第28层</option>
							<option>第29层</option>
							<option>第30层</option>
						</select>
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							房源类型：
						</span>
						<select name="housetypeName" class="information-input">
							<option>普通住宅</option>
							<option>公寓</option>
							<option>平房</option>
							<option>别墅</option>
							<option>酒店公寓</option>
						</select>
					</div>
					
					<div class="prompt"></div>
					
					<div class="information"  style="height: 90px;">
						<span class="information-title">
							配套设施：
						</span>
						<div class="information-input">
							<li class="houseMating-li">
								<input type="checkbox" name="housematingBed" value="0"/>床
								<input type="checkbox" name="housematingWasher" value="0"/>洗衣机
								<input type="checkbox" name="housematingAirconditioner" value="0"/>空调
								<input type="checkbox" name="housematingBalcony" value="0"/>阳台
							</li>
							<li class="houseMating-li">
								<input type="checkbox" name="housematingRefrigerator" value="0"/>冰箱
								<input type="checkbox" name="housematingToilet" value="0"/>卫生间
								<input type="checkbox" name="housematingCookhouse" value="0"/>厨房
								<input type="checkbox" name="housematingTelevision" value="0"/>电视
							</li>
							<li class="houseMating-li">
								<input type="checkbox" name="housematingWaterheater" value="0"/>热水器
								<input type="checkbox" name="housematingCloset" value="0"/>衣柜
								<input type="checkbox" name="housematingWifi" value="0"/>wifi
								<input type="checkbox" name="housematingSofa" value="0"/>沙发
							</li>
						</div>
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							房源地址：
						</span>
						<a href="javascript:void(0)"  style="float: right;" class="pick-area pick-area7" name=""></a>
						<input id="address-hidden" name="housingAddress" type="hidden" class="pick-area-hidden" />
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							详细地址：
						</span>
						<input id="housingDetailsaddress" name="housingDetailsaddress" type="text" class="form-control information-input" placeholder="请输入详细地址">
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							房源图片：
						</span>
						<div class="information-input fileImgDiv">
   							<div class="simp-bt open-input" onclick="up_files($(this))">上传图片</div>
        '                	<input id="fileImg" type="file" size="30" name="fileselect" multiple="multiple" onchange="readAsDataURL($('.open-input').attr('filenums'))">
						</div>
					</div>
					
					<div class="prompt"></div>
					
					
					<div class="information"  style="height: 100px;">
						<span class="information-title">
							房源简介：
						</span>
						<textarea id="housingAbout" name="housingAbout" class="information-input housing-textarea" placeholder="请输入房源简介~(1000字以内)" maxlength="1000"></textarea>
					</div>
					
					<div class="prompt">
						<c:if test="${msg!=null}">
							${msg}
						</c:if>
					</div>
					
					<div id="div-button">
						<button type="submit" id="loginButton" class="btn btn-success">注册</button>
					</div>
				</form>
			</div>
		</div>
		
    	<script type="text/javascript" src="js/pick-pcc.min.1.0.1.js" ></script>
	    <script type="text/javascript" src="jqueryfileinput/js/fileInput.js"></script>
	    <script type="text/javascript" src="jqueryfileinput/js/test.js"></script>
	    <script type="text/javascript" src="js/publishHousing.js"></script>
	    <script type="text/javascript">
	    	$(".pick-area7").pickArea({
	    		"format": "",
	    		"width": "250px",
	    		"height": "30px",
	    		"borderColor": "#ccc",
	    		"color": '#7894D4',
	    		"arrowColor": "#7894D4"
	    	});
	    </script>
  </body>
</html>
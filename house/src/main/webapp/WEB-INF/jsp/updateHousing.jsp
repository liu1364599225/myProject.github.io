<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改房源信息</title>

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
					修改房源信息
				</div>
				<form action="updateHousing.fw" method="post" enctype="multipart/form-data" style="margin-top: 20px;">
					<input type="hidden" name="housingId" value="${housing.housingId }">
					<div class="information">
						<span class="information-title">
							房源标题：
						</span>
						<input id="housingTitle" name="housingTitle" type="text" class="form-control information-input" value="${housing.housingTitle }">
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							房源价格：
						</span>
						<div class="information-input">
							<input id="housingPrice" name="housingPrice" value="${housing.housingPrice }" type="text" class="form-control" style="width: 100px;float: left;">
							<p style="margin-left: 5px;float: left;font-weight: bold;">元/月</p>
						</div>
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							房源面积：
						</span>
						<div class="information-input">
							<input id="housingArea" name="housingArea" value="${housing.housingArea }" type="text" class="form-control" style="width: 100px;float: left;">
							<p style="margin-left: 5px;float: left;font-weight: bold;">平方米</p>
						</div>
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							房源户型：
						</span>
						<input id="housingHousetype-hidden" type="hidden" value="${housing.housingHousetype }">
						<div class="information-input">
							<select id="housingHousetype-select1" name="housingHousetype" class="housingType-select">
								<option value="0室">0室</option>
								<option value="1室">1室</option>
								<option value="2室">2室</option>
								<option value="3室">3室</option>
								<option value="4室">4室</option>
								<option value="5室">5室</option>
								<option value="6室">6室</option>
								<option value="7室">7室</option>
								<option value="8室">8室</option>
								<option value="9室">9室</option>
								<option value="10室">10室</option>
							</select>
							<select id="housingHousetype-select2" name="housingHousetype" class="housingType-select">
								<option value="0厅">0厅</option>
								<option value="1厅">1厅</option>
								<option value="2厅">2厅</option>
								<option value="3厅">3厅</option>
								<option value="4厅">4厅</option>
								<option value="5厅">5厅</option>
								<option value="6厅">6厅</option>
								<option value="7厅">7厅</option>
								<option value="8厅">8厅</option>
								<option value="9厅">9厅</option>
								<option value="10厅">10厅</option>
							</select>
						</div>
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							房源楼层：
						</span>
						<input id="housingFloor-hidden" type="hidden" value="${housing.housingFloor }">
						<select id="housingFloor-select" name="housingFloor" class="information-input">
							<option value="第1层">第1层</option>
							<option value="第2层">第2层</option>
							<option value="第3层">第3层</option>
							<option value="第4层">第4层</option>
							<option value="第5层">第5层</option>
							<option value="第6层">第6层</option>
							<option value="第7层">第7层</option>
							<option value="第8层">第8层</option>
							<option value="第9层">第9层</option>
							<option value="第10层">第10层</option>
							<option value="第11层">第11层</option>
							<option value="第12层">第12层</option>
							<option value="第13层">第13层</option>
							<option value="第14层">第14层</option>
							<option value="第15层">第15层</option>
							<option value="第16层">第16层</option>
							<option value="第17层">第17层</option>
							<option value="第18层">第18层</option>
							<option value="第19层">第19层</option>
							<option value="第20层">第20层</option>
							<option value="第21层">第21层</option>
							<option value="第22层">第22层</option>
							<option value="第23层">第23层</option>
							<option value="第24层">第24层</option>
							<option value="第25层">第25层</option>
							<option value="第26层">第26层</option>
							<option value="第27层">第27层</option>
							<option value="第28层">第28层</option>
							<option value="第29层">第29层</option>
							<option value="第30层">第30层</option>
						</select>
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							房源类型：
						</span>
						<input id="houseType-hidden" type="hidden" value="${houseType.housetypeName }">
						<select id="houseType-select" name="housetypeName" class="information-input">
							<option value="普通住宅">普通住宅</option>
							<option value="公寓">公寓</option>
							<option value="平房">平房</option>
							<option value="别墅">别墅</option>
							<option value="酒店公寓">酒店公寓</option>
						</select>
					</div>
					
					<div class="prompt"></div>
					
					<div class="information"  style="height: 90px;">
						<span class="information-title">
							配套设施：
						</span>
						<div class="information-input">
							<li class="houseMating-li">
								<input type="checkbox" name="housematingBed" ${houseMating.housematingBed=="0"?'checked':''} value="0"/>床
								<input type="checkbox" name="housematingWasher" ${houseMating.housematingWasher=="0"?'checked':''} value="0"/>洗衣机
								<input type="checkbox" name="housematingAirconditioner" ${houseMating.housematingAirconditioner=="0"?'checked':''} value="0"/>空调
								<input type="checkbox" name="housematingBalcony" ${houseMating.housematingBalcony=="0"?'checked':''} value="0"/>阳台
							</li>
							<li class="houseMating-li">
								<input type="checkbox" name="housematingRefrigerator" ${houseMating.housematingRefrigerator=="0"?'checked':''} value="0"/>冰箱
								<input type="checkbox" name="housematingToilet" ${houseMating.housematingToilet=="0"?'checked':''} value="0"/>卫生间
								<input type="checkbox" name="housematingCookhouse" ${houseMating.housematingCookhouse=="0"?'checked':''} value="0"/>厨房
								<input type="checkbox" name="housematingTelevision" ${houseMating.housematingTelevision=="0"?'checked':''} value="0"/>电视
							</li>
							<li class="houseMating-li">
								<input type="checkbox" name="housematingWaterheater" ${houseMating.housematingWaterheater=="0"?'checked':''} value="0"/>热水器
								<input type="checkbox" name="housematingCloset" ${houseMating.housematingCloset=="0"?'checked':''} value="0"/>衣柜
								<input type="checkbox" name="housematingWifi" ${houseMating.housematingWifi=="0"?'checked':''} value="0"/>wifi
								<input type="checkbox" name="housematingSofa" ${houseMating.housematingSofa=="0"?'checked':''} value="0"/>沙发
							</li>
						</div>
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							房源地址：
						</span>
						<a href="javascript:void(0)"  style="float: right;" class="pick-area pick-area7" name=""></a>
						<input id="address-hidden" name="housingAddress" type="hidden" class="pick-area-hidden" value="${housing.housingAddress }" />
					</div>
					
					<div class="prompt"></div>
					
					<div class="information">
						<span class="information-title">
							详细地址：
						</span>
						<input id="housingDetailsaddress" name="housingDetailsaddress" type="text" class="form-control information-input" value="${housing.housingDetailsaddress }">
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
						<textarea id="housingAbout" name="housingAbout" class="information-input housing-textarea" maxlength="1000">${housing.housingAbout }</textarea>
					</div>
					
					<div class="prompt">
						<c:if test="${msg!=null}">
							${msg}
						</c:if>
					</div>
					
					<div id="div-button">
						<button type="submit" id="loginButton" class="btn btn-success">提交修改</button>
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
	    		"format": "${fn:replace(housing.housingAddress,' ','/') }",
	    		"width": "250px",
	    		"height": "30px",
	    		"borderColor": "#ccc",
	    		"color": '#7894D4',
	    		"arrowColor": "#7894D4"
	    	});
	    	
	    	var housingFloor = $("#housingFloor-hidden").val();
	    	$("#housingFloor-select").find("option[value="+housingFloor+"]").attr("selected",true);
	    	
	    	var houseType = $("#houseType-hidden").val();
	    	$("#houseType-select").find("option[value="+houseType+"]").attr("selected",true);
	    	
	    	var housingHousetype = $("#housingHousetype-hidden").val();
	    	var housingHousetype1 = housingHousetype.substring(0,housingHousetype.indexOf("室")+1);
	    	var housingHousetype2 = housingHousetype.substring(housingHousetype.indexOf("室")+1,housingHousetype.indexOf("厅")+1);
	    	$("#housingHousetype-select1").find("option[value="+housingHousetype1+"]").attr("selected",true);
	    	$("#housingHousetype-select2").find("option[value="+housingHousetype2+"]").attr("selected",true);
	    </script>
  </body>
</html>
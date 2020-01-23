<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>宠物寄养及医疗服务管理系统</title>
	<link href="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/ffRegister.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/font-style.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/pick-pcc.min.1.0.1.css">
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
      <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/html5shiv.min.js"></script>
      <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div id="logo" class="container">
		<a href="${pageContext.servletContext.contextPath }/loginPage.pet">
			<div style="float: right;">
				<span id="sytemName">宠物寄养平台</span>
			</div>
			<div style="float: right;">
				<span id="logo-img" class="am-icon-home" />
			</div>
		</a>
	</div>

	<div id="center" class="container">
		<div id="fuRegister" class="col-md-5 col-md-offset-1">
			<div id="fuRegister-title">寄养家庭注册申请</div>
			<form style="margin-top: 20px;" action="${pageContext.servletContext.contextPath }/ffRegister.pet" method="post" enctype="multipart/form-data">
				<div class="information">
					<span class="information-title"> 账户名： </span>
					<input id="accountName" name="fAccountname" type="text" class="form-control information-input" placeholder="请设置要注册的账户名">
				</div>

				<div class="prompt"></div>

				<div class="information">
					<span class="information-title"> 密码： </span>
					<input id="password" name="fPassword" type="password" class="form-control information-input" placeholder="请设置登录密码">
				</div>

				<div class="prompt"></div>

				<div class="information">
					<span class="information-title"> 确认密码： </span> <input
						id="againPassword" name="againPassword" type="password"
						class="form-control information-input" placeholder="请确认登录密码">
				</div>

				<div class="prompt"></div>

				<div class="information">
					<span class="information-title"> 姓名： </span> <input id="fosterName" name="fAdoptername"
						type="text" class="form-control information-input"
						placeholder="请输入姓名">
				</div>
				
				<div class="prompt"></div>

				<div class="information">
					<span class="information-title"> 性别： </span>
					<div class="information-input">
						<input type="radio" name="fAdoptersex" value="男" checked="checked" />男
						<input style="margin-left: 20px;" type="radio" name="fAdoptersex"
							value="女" />女
					</div>
				</div>

				<div class="prompt"></div>

				<div class="information">
					<span class="information-title"> 寄养经历： </span> <input
						id="fosterExperience" name="fFosterexperience" type="text"
						class="form-control information-input" placeholder="格式可为：(狗类-哈士奇-1年)">
				</div>

				<div class="prompt"></div>

				<div class="information">
					<span class="information-title"> 联系方式： </span> <input
						id="contactWay" name="fContactway" type="text" class="form-control information-input"
						placeholder="请输入联系方式">
				</div>

				<div class="prompt"></div>
				
				<div class="information">
					<span class="information-title"> 联系地址： </span> <a
						id="address-a" href="javascript:void(0)" style="float: right;"
						class="pick-area pick-area7" name=""></a> <input type="hidden" id="address"
						name="fAddress" class="pick-area-hidden" />
				</div>

				<div style="height:1px;"></div>
				<div class="prompt"></div>
					
				<div class="information" >
					<span class="information-title">
						 家庭图片：
					</span>
					<div class="information-input">
						<input id="fosterFamilyPhoto" type="file" name="familyPhoto" style="width: 180px;float: left;">
					</div>
				</div>

				<div class="prompt"></div>

				<div class="information" style="height: 60px;">
					<span class="information-title" style="width: 90px; height: 60px;">
						可寄养的宠物类型： </span>
					<div class="information-input" style="margin-top: 20px;">
						<input type="checkbox" name="fTyperange" class="type" value="猫类" />猫类 
						<input type="checkbox" name="fTyperange" class="type" style="margin-left: 5px;" value="狗类" />狗类 
						<input type="checkbox" name="fTyperange" class="type" style="margin-left: 5px;" value="鼠类" />鼠类 
						<input type="checkbox" name="fTyperange" class="type" style="margin-left: 5px;" value="蛇类" />蛇类 
						<input type="checkbox" name="fTyperange" class="type" style="margin-left: 5px;" value="鸟类" />鸟类
					</div>
				</div>

				<div class="prompt"></div>
				
				<div class="information" style="height: 90px;">
					<span class="information-title" style="width: 90px; height: 60px;">
						寄养环境： </span>
					<div class="information-input">
						<input type="checkbox" name="iEnvironment"  value="单元住宅 " />单元住宅 
						<input type="checkbox" name="iEnvironment"  style="margin-left: 5px;" value="100平方米 " />100平方米 
						<input type="checkbox" name="iEnvironment"  style="margin-left: 5px;" value="两室一厅两阳台 " />两室一厅两阳台 
						<input type="checkbox" name="iEnvironment"  style="margin-left: 5px;" value="封闭阳台" />封闭阳台
						<input type="checkbox" name="iEnvironment"  style="margin-left: 5px;" value="空调环境" />空调环境
						<input type="checkbox" name="iEnvironment"  style="margin-left: 5px;" value="电梯" />电梯
						<input type="checkbox" name="iEnvironment"  style="margin-left: 5px;" value="小区花园" />小区花园
						<input type="checkbox" name="iEnvironment"  style="margin-left: 5px;" value="交通便利" />交通便利
					</div>
				</div>
				
				<div class="prompt"></div>
				
				<div class="information">
					<span class="information-title"> 寄养服务： </span> <input
						id="contactWay" name="iFostercare" type="text" class="form-control information-input"
						placeholder="请输入要每日寄养所需金额">
				</div>
				
				<div class="prompt"></div>
				
				<div class="information">
					<span class="information-title"> 接送服务： </span> <input
						id="contactWay" name="iPickupservice" type="text" class="form-control information-input"
						placeholder="请输入要每次接送所需金额">
				</div>
				
				<div class="prompt"></div>
				
				<div class="information">
					<span class="information-title"> 自我描述： </span> <input
						id="contactWay" name="iDescribe" type="text" class="form-control information-input"
						placeholder="请输入自我描述信息">
				</div>
				
				<div class="prompt"></div>
				
				<div class="prompt">
					<c:if test="${msg!=null}">
						${msg}
					</c:if>
				</div>

				<div id="div-button">
					<button type="submit" id="loginButton" class="btn btn-success">提交申请</button>
				</div>
			</form>
		</div>
	</div>

	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.servletContext.contextPath }/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/pick-pcc.min.1.0.1.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/xhr.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/ffRegister.js" ></script>
    <script type="text/javascript">
    	$(".pick-area1").pickArea();
    
    	$(".pick-area2").pickArea({
    		"format": "北京市/市辖区", //格式
    		"width": "300",
    		"borderColor": "#7b68ee", //文本边框的色值
    		"arrowColor": "#7b68ee", //箭头颜色
    		"listBdColor": "#7b68ee", //下拉框父元素ul的border色值
    		"color": "#7b68ee", //字体颜色
    		"fontSize": "16px", //字体大小
    		"hoverColor": "#7b68ee",
    		"paddingLeft": "10px",
    		"arrowRight": "10px",
    		//"preSet":"北京市/市辖区/东城区",
    		"getVal": function() {
    			//console.log($(".pick-area-hidden").val())
    			//console.log($(".pick-area-dom").val())
    			var thisdom = $("." + $(".pick-area-dom").val());
    			thisdom.next().val($(".pick-area-hidden").val());
    		}
    	});
    
    	$(".pick-area3").pickArea({
    		"format": "江苏省", //格式
    		"width": "400",
    		"borderColor": "#51AFC9", //文本边框的色值
    		"arrowColor": "#51AFC9", //箭头颜色
    		"listBdColor": "#51AFC9", //下拉框父元素ul的border色值
    		"color": "#51AFC9", //字体颜色
    		"fontSize": "16px", //字体大小
    		"hoverColor": "#51AFC9",
    		"paddingLeft": "10px",
    		"arrowRight": "10px",
    		"maxHeight": "600",
    		//"preSet":"河南省/郑州市",
    		"getVal": function() {
    			//console.log($(".pick-area-hidden").val())
    			//console.log($(".pick-area-dom").val())
    			var thisdom = $("." + $(".pick-area-dom").val());
    			thisdom.next().val($(".pick-area-hidden").val());
    		}
    	});
    	$(".pick-area4").pickArea({
    		"format": "province/city/county", //格式
    		"width": "250", //设置“省市县”文本边框的宽度
    		"height": "30", //设置“省市县”文本边框的高度
    		"borderColor": "#ccc", //设置“省市县”文本边框的色值
    		"arrowColor": "#435abd", //设置下拉箭头颜色
    		"listBdColor": "#435abd", //设置下拉框父元素ul的border色值
    		"color": "#435abd", //设置“省市县”字体颜色
    		"fontSize": "12px", //设置字体大小
    		"hoverColor": "#435abd",
    		"paddingLeft": "30px", //设置“省”位置处的span相较于边框的距离
    		"arrowRight": "30px", //设置下拉箭头距离边框右侧的距离
    		"maxHeight": "300px",
    		//"preSet":"",//数据初始化 ；这里的数据初始化有两种方式，第一种是用preSet属性设置，第二种是在a标签里使用name属性设置
    		"getVal": function() { //这个方法是每次选中一个省、市或者县之后，执行的方法
    			//console.log($(".pick-area-hidden").val())
    			//console.log($(".pick-area-dom").val())
    			var thisdom = $("." + $(".pick-area-dom").val()); //返回的是调用这个插件的元素pick-area，$(".pick-area-dom").val()的值是该元素的另一个class名，这个class名在dom结构中是唯一的，不会有重复，可以通过这个class名来识别这个pick-area
    			thisdom.next().val($(".pick-area-hidden").val()); //$(".pick-area-hidden").val()是页面中隐藏域的值，存放着每次选中一个省、市或者县的时候，当前文本存放的省市县的最新值，每点击一次下拉框里的li，这个值就会立即更新
    		}
    	});
    	$(".pick-area5").pickArea({
    		"format": "province/city", //格式
    		"width": "300",
    		"borderColor": "#e02222", //文本边框的色值
    		"arrowColor": "#e02222", //下拉箭头颜色
    		"listBdColor": "#e02222", //下拉框父元素ul的border色值
    		"color": "#e02222", //字体颜色
    		"hoverColor": "#e02222",
    		//"preSet":"山东省/临沂市/兰陵县",
    		"getVal": function() {
    			//console.log($(".pick-area-hidden").val())
    			//console.log($(".pick-area-dom").val())
    			var thisdom = $("." + $(".pick-area-dom").val());
    			thisdom.next().val($(".pick-area-hidden").val());
    		}
    	});
    
    	$(".pick-area6").pickArea({
    		"format": "上海市/市辖区/普陀区", //格式
    		"width": "340",
    		"borderColor": "#ff8c00", //文本边框的色值
    		"arrowColor": "#ff8c00", //下拉箭头颜色
    		"listBdColor": "#ff8c00", //下拉框父元素ul的border色值
    		"color": "#ff8c00", //字体颜色
    		"hoverColor": "#ff8c00",
    		//"preSet":"山东省/临沂市/兰陵县",
    		"getVal": function() {
    			//console.log($(".pick-area-hidden").val())
    			//console.log($(".pick-area-dom").val())
    			var thisdom = $("." + $(".pick-area-dom").val());
    			thisdom.next().val($(".pick-area-hidden").val());
    		}
    	});
    
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
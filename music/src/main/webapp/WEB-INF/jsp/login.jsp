<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>芦苇音乐</title>
<link href="${pageContext.servletContext.contextPath}/css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var $tab_li = $('#tab ul li');
	$tab_li.hover(function(){
		$(this).addClass('selected').siblings().removeClass('selected');
		var index = $tab_li.index(this);
		$('div.tab_box > div').eq(index).show().siblings().hide();
	});	
});
</script>
<script type="text/javascript">
$(function(){
	$(".stu_login_error").Validform({
		tiptype:function(msg,o,cssctl){
			var objtip=$(".stu_error_box");
			cssctl(objtip,o.type); 
			objtip.text(msg);
		},
		
	});
	
	$(".tea_login_error").Validform({
		tiptype:function(msg,o,cssctl){
			var objtip=$(".tea_error_box");
			cssctl(objtip,o.type);
			objtip.text(msg);
		},
	});
});
</script>
<script type="text/javascript">
$(function(){
	$(".screenbg ul li").each(function(){
		$(this).css("opacity","0");
	});
	$(".screenbg ul li:first").css("opacity","1");
	var index = 0;
	var t;
	var li = $(".screenbg ul li");	
	var number = li.size();
	function change(index){
		li.css("visibility","visible");
		li.eq(index).siblings().animate({opacity:0},3000);
		li.eq(index).animate({opacity:1},3000);
	}
	function show(){
		index = index + 1;
		if(index<=number-1){
			change(index);
		}else{
			index = 0;
			change(index);
		}
	}
	t = setInterval(show,8000);
	//根据窗口宽度生成图片宽度
	var width = $(window).width();
	$(".screenbg ul img").css("width",width+"px");
});
</script>
</head>

<body>
<div id="tab">
  <ul class="tab_menu">
    <li class="selected">用户登录</li>
    <li>用户注册</li>
  </ul>
  <div class="tab_box"> 
  		
    <div>
      <div class="stu_error_box" style="color: red;">${requestScope.str}</div>
      <form action="${pageContext.servletContext.contextPath}/login.lw" method="post" class="stu_login_error">
        <div id="username">
          <label>帐&nbsp;&nbsp;&nbsp;号：</label>
          <input type="text" id="stu_username_hide" name="username" placeholder="输入帐号" nullmsg="帐号不能为空！" maxlength="18" datatype="s6-18" errormsg="帐号范围在6~18个字符之间！" sucmsg="帐号验证通过！"/>
          <!--ajaxurl="demo/valid.jsp"--> 
        </div>
        <div id="password">
          <label>密&nbsp;&nbsp;&nbsp;码：</label>
          <input type="password" id="stu_password_hide" name="password" placeholder="输入密码" value="" nullmsg="密码不能为空！" maxlength="16" datatype="*6-16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>
        </div>
        <div id="code">
          <label>验证码：</label>
          <input type="text" id="stu_code_hide" name="code"  placeholder="输入验证码" nullmsg="验证码不能为空！" maxlength="4" datatype="*4-4" errormsg="验证码有4位数！" sucmsg="验证码验证通过！"/>
          <img style="margin-bottom:-15px;" onclick="change(this);" src="${pageContext.servletContext.contextPath}/valiCode.lw" title="点击更换" alt="验证码占位图"/> </div>
       
        <div id="login">
          <button type="submit">登录</button>
        </div>
      </form>
    </div>
    
    
    <div class="hide">
     <div class="tea_error_box" style="color: red;"></div>
      <form action="${pageContext.servletContext.contextPath}/register.lw" method="post" class="tea_login_error" enctype="multipart/form-data">
        <div id="username">
          <label>帐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
          <input type="text" id="tea_username_hide" name="username" placeholder="输入帐号" nullmsg="帐号不能为空！" maxlength="18" datatype="s6-18" errormsg="帐号范围在6~18个字符之间！" sucmsg="帐号验证通过！"/>
          <!--ajaxurl="demo/valid.jsp"--> 
        </div>
        <div id="password">
          <label>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
          <input type="password" id="tea_password_hide" name="password" placeholder="输入密码" nullmsg="密码不能为空！" datatype="*6-16" maxlength="16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>
        </div>
         <div id="passwordAgain">
          <label>重复密码：</label>
          <input type="password" id="tea_password_hide_again" name="passwordagain" placeholder="再次输入密码" nullmsg="密码不能为空！" recheck="password" maxlength="16" datatype="*6-16"  errormsg="密码不一致！" sucmsg="密码一致！"/>
        </div>
        <div id="realname">
          <label>用户姓名：</label>
          <input type="text" id="tea_realname_hide" name="realname" placeholder="输入姓名" nullmsg="姓名不能为空！" maxlength="6" datatype="s" errormsg="姓名错误！" sucmsg="姓名验证通过！"/>
        </div>
        <div id="avatar" style="margin-top:15px;margin-bottom:5px;">
          <label style="margin-left:-5px;">用户头像：</label>
          <input type="file" id="tea_avatar_hide" name="avatar"/>
        </div>
        <div id="gender" style="text-align: left;padding: 20px;padding-left: 36px;">
          <label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
          	<input type="radio" id="tea_gender_hide_man" name="gender" checked="checked" value="男" />
          	男
          	&nbsp;&nbsp;&nbsp;&nbsp;
          	<input type="radio" id="tea_gender_hide_woman" name="gender" value="女" />
          	女
        </div>
        <div id="code">
          <label>验&nbsp;证&nbsp;码：</label>
          <input type="text" id="tea_code_hide" name="code"  placeholder="输入验证码" nullmsg="验证码不能为空！" datatype="*4-4" maxlength="4" errormsg="验证码有4位数！" sucmsg="验证码验证通过！"/>
          <img style="margin-bottom:-15px;" onclick="change(this);" src="${pageContext.servletContext.contextPath}/valiCode.lw" title="点击更换" alt="验证码占位图"/> </div>
        
        <div id="login">
          <button type="submit">注册</button>
        </div>
      </form>
    </div>
     
  </div>
</div>
<div class="screenbg">
  <ul>
    <li><a href="javascript:;"><img src="${pageContext.servletContext.contextPath}/images/0.jpg"></a></li>
    <li><a href="javascript:;"><img src="${pageContext.servletContext.contextPath}/images/1.jpg"></a></li>
    <li><a href="javascript:;"><img src="${pageContext.servletContext.contextPath}/images/2.jpeg"></a></li>
  </ul>
</div>
	<script type="text/javascript">
		function change(img){
		img.src = "valiCode.lw?"+new Date().getTime();
	
		}
	</script>
</body>
</html>
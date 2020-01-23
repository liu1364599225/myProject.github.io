<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/css/bootstrap.min.css" />
    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
	    <script src="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/js/html5shiv.min.js"></script>
	    <script src="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/js/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/main.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/font-style.css" />
   	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/draft/draft.css"/>
  </head>
  <body>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/js/jquery.min.js" ></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/main.js" ></script>
   	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/draft/draft.js" ></script>
   
   <div id="send" class="container-fluid">
   <div id="msg"></div>
   	<ul id="send_ul">
   		<li>
   			
   			<div id="head1" class="container-fluid">
				<div id="head1-1" class="col-md-3" >
					<span id="head1-1-span1" class="text-info"><b>草稿箱</b></span><span id="">(共<span id="all_mail_num" ">${list_size }</span>封)<span id="show_nomail"> &nbsp;未读邮件&nbsp;</span><span id="noread_mail">${noread_list_size }&nbsp;封</span></span>
				</div>
			</div>
   		</li>
   		<li>
   			<div id="head2" class="">
						<a id="head2_a2" href="javascript:void(0)" onclick="deleteTrue(this)" class="btn btn-default btn-lg active" role="button">删除草稿</a>
						<a id="head2_a3" href="javascript:void(0)" onclick="transpond(this)"class="btn btn-default btn-lg active" role="button">转发</a>
						<div class="btn-group" style="" role="group">
					    		<div class="btn-group">
								  <button id="head2_button1" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								   标记为... <span class="caret"></span>
								  </button>
								  <ul class="dropdown-menu">
								    <li><a href="javascript:void(0)" onclick="read(this)">已读邮件</a></li>
								    <li><a href="javascript:void(0)" onclick="noread(this)">未读邮件</a></li>
								    <li role="separator" class="divider"></li>
								    <li><a href="javascript:void(0)" onclick="change_star1(this)">星标邮件</a></li>
								    <li><a href="javascript:void(0)" onclick="nochange_star1(this)">取消星标</a></li>
								    <li role="separator" class="divider"></li>
								  </ul>
							</div>
						</div>
						<div class="btn-group" style="" role="group">
					    	<div class="btn-group">
								  <button id="head2_button2" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								   		移动到... <span class="caret"></span>
								  </button>
								  <ul class="dropdown-menu">
								    <li><a href="javascript:void(0)" onclick="asend_box(this)">收件箱</a></li>
								    <li><a href="javascript:void(0)" onclick="asend(this)">已发送</a></li>
								    <li role="separator" class="divider"></li>
								  </ul>
							</div>
						</div>
				<div id="head2_right1" class="col-md-4">
						<div id="head2_right1_child1" class="col-md-7 col-md-offset-7">
							<span id="head2_right1_child1_span">${now_page }/${all_page}页</span><a style="display: ${msg3}" href="${pageContext.servletContext.contextPath}/readAll_Inbox.do?pageNum=${pageNum}">下一页</a>&nbsp;&nbsp;<input id="page_num" type="text" style="" value="${pageNum }" /><a href="javascript:void(0)" onclick="page_t(this)">&nbsp;&nbsp;跳转</a>							
						</div>
				</div>
			</div>
   		</li>
   		<li>
			<div id="head3">
				<input id="main-select" onclick="main_slect()"  class="col-md-1 1" type="checkbox" name="" id="" value="" />
				<span id="head3_span1"  class="col-md-1 glyphicon glyphicon-envelope"></span>
				<span id="head3_span2" class="col-md-1" >发件人</span>
				<span id="head3_span3"  class="col-md-8">主题</span>
				<span id="head3_span4">时间↓</span>
			</div>   			
   		</li> 		
   		
   		<li>
   			<div id="head4">
   				<a href="">查询发信投递状态</a>
   			</div>
   		</li>
   		<li id="li_1" style="display:${msg2}">
   			<div id="center">
	   				<input  style="display: none;" id="center_input"  class="col-md-1 11"  type="checkbox" name="" id="" value="" onclick="change_color(this)" />
					<a style="display: none;" href="javascript:void(0)" onclick="change_mail(this)"><span id="center_a1"  class="col-md-1 glyphicon glyphicon-envelope" style=""></span></a>
					<span id="center_span1" class="col-md-0"><a id="center_span1_a" href="">${msg1}</a></span>
					<span id=""><span></span></span>
	   			</div>
   		</li>
   		<!-- 今天 -->
   		<li >
   			<div id="head5" style="${head1}">
   				<div id="head5_child1" >
   					<span id="" class="text-info" style=""><b>今天</b></span>(<span id="head5_child1_span1_1">${today1}</span>封)
   				</div>
   			</div>
   		</li>
		<c:forEach var ="lnbox" items="${today}">
			<li>
	   			
	   			<div id="center">
	   				<input id="center_input"  class="col-md-1 1"  type="checkbox" name="" id="" value="" onclick="change_color(this)" />
					<a href="javascript:void(0)" onclick="change_mail(this)"><span id="center_a1"  class="col-md-1 glyphicon glyphicon-envelope" style="color:${lnbox.getAfind()}"></span></a>
					<span id="center_span1" class="col-md-1"><a id="center_span1_a" href="javascript:void(0)" onclick="second(this,${lnbox.getDate()},${lnbox.getSend_mail_id()})">${lnbox.getSend_mail_id()}</a></span>
					<span id="center_span2"  class="col-md-8"><a id="center_span2_a" href="">${lnbox.getMotive() }</a></span>
					<span id=""><span style="display: none">${lnbox.getMail_id() }</span><span>${lnbox.getDate()}</span></span>
					<a href="javascript:void(0)" onclick="change_star(this)"><span id="" class="glyphicon glyphicon-star-empty"  aria-hidden="true" style="color:${lnbox.getBit_mail()}"></span></a>
	   			</div>
   			</li>
		</c:forEach>
   		
   		<!-- 星期一 -->
   		<li>
   			<div id="head5" style="${head2}">
   				<div id="head5_child1" >
   					<span id="" class="text-info" style=""><b>星期一</b></span>(<span id="head5_child1_span1_2">${one1}</span>封)
   				</div>
   			</div>
   		</li>
		<c:forEach var ="lnbox" items="${one}">
			<li>
	   			<div id="center">
	   				<input id="center_input"  class="col-md-1 1"  type="checkbox" name="" id="" value="" onclick="change_color(this)" />
					<a href="javascript:void(0)" onclick="change_mail(this)"><span id="center_a1"  class="col-md-1 glyphicon glyphicon-envelope" style="color:${lnbox.getAfind()}"></span></a>
					<span id="center_span1" class="col-md-1"><a id="center_span1_a" href="javascript:void(0)" onclick="second(this,${lnbox.getDate()},${lnbox.getSend_mail_id()})">${lnbox.getSend_mail_id()}</a></span>
					<span id="center_span2"  class="col-md-8"><a id="center_span2_a" href="">${lnbox.getMotive() }</a></span>
					<span id=""><span style="display: none">${lnbox.getMail_id() }</span><span style="display: none">${lnbox.getMail_id() }</span><span>${lnbox.getDate()}</span></span>
					<a href="javascript:void(0)" onclick="change_star(this)"><span id="" class="glyphicon glyphicon-star-empty"  aria-hidden="true" style="color:${lnbox.getBit_mail()}"></span></a>
	   			</div>
   			</li>
		</c:forEach>
   		<!-- 星期二 -->
   		<li>
   			<div id="head5" style="${head3}">
   				<div id="head5_child1" >
   					<span id="" class="text-info" style=""><b>星期二</b></span>(<span id="head5_child1_span1_3">${two1 }</span>封)
   				</div>
   			</div>
   		</li>
		<c:forEach var ="lnbox" items="${two}">
			<li>
	   			<div id="center">
	   				<input id="center_input"  class="col-md-1 1"  type="checkbox" name="" id="" value="" onclick="change_color(this)" />
					<a href="javascript:void(0)" onclick="change_mail(this)"><span id="center_a1"  class="col-md-1 glyphicon glyphicon-envelope" style="color:${lnbox.getAfind()}"></span></a>
					<span id="center_span1" class="col-md-1"><a id="center_span1_a" href="javascript:void(0)" onclick="second(this,${lnbox.getDate()},${lnbox.getSend_mail_id()})">${lnbox.getSend_mail_id()}</a></span>
					<span id="center_span2"  class="col-md-8"><a id="center_span2_a" href="">${lnbox.getMotive() }</a></span>
					<span id=""><span style="display: none">${lnbox.getMail_id() }</span><span style="display: none">${lnbox.getMail_id() }</span><span>${lnbox.getDate()}</span></span>
					<a href="javascript:void(0)" onclick="change_star(this)"><span id="" class="glyphicon glyphicon-star-empty"  aria-hidden="true" style="color:${lnbox.getBit_mail()}"></span></a>
	   			</div>
   			</li>
		</c:forEach>
   		<!-- 星期三 -->
   		<li>
   			<div id="head5" style="${head4}">
   				<div id="head5_child1" >
   					<span id="" class="text-info" style=""><b>星期三</b></span>(<span id="head5_child1_span1_4">${three1 }</span>封)
   				</div>
   			</div>
   		</li>
		<c:forEach var ="lnbox" items="${three}">
			<li>
	   			<div id="center">
	   				<input id="center_input"  class="col-md-1 1"  type="checkbox" name="" id="" value="" onclick="change_color(this)" />
					<a href="javascript:void(0)" onclick="change_mail(this)"><span id="center_a1"  class="col-md-1 glyphicon glyphicon-envelope" style="color:${lnbox.getAfind()}"></span></a>
					<span id="center_span1" class="col-md-1"><a id="center_span1_a" href="javascript:void(0)" onclick="second(this,${lnbox.getDate()},${lnbox.getSend_mail_id()})">${lnbox.getSend_mail_id()}</a></span>
					<span id="center_span2"  class="col-md-8"><a id="center_span2_a" href="">${lnbox.getMotive() }</a></span>
					<span id=""><span style="display: none">${lnbox.getMail_id() }</span><span style="display: none">${lnbox.getMail_id() }</span><span>${lnbox.getDate()}</span></span>
					<a href="javascript:void(0)" onclick="change_star(this)"><span id="" class="glyphicon glyphicon-star-empty"  aria-hidden="true" style="color:${lnbox.getBit_mail()}"></span></a>
	   			</div>
   			</li>
		</c:forEach>
		<!-- 星期四 -->
   		<li>
   			<div id="head5" style="${head5}">
   				<div id="head5_child1" >
   					<span id="" class="text-info" style=""><b>星期四</b></span>(<span id="head5_child1_span1_5">${four1 }</span>封)
   				</div>
   			</div>
   		</li>
		<c:forEach var ="lnbox" items="${four}">
			<li>
	   			<div id="center">
	   				<input id="center_input"  class="col-md-1 1"  type="checkbox" name="" id="" value="" onclick="change_color(this)" />
					<a href="javascript:void(0)" onclick="change_mail(this)"><span id="center_a1"  class="col-md-1 glyphicon glyphicon-envelope" style="color:${lnbox.getAfind()}"></span></a>
					<span id="center_span1" class="col-md-1"><a id="center_span1_a" href="javascript:void(0)" onclick="second(this,${lnbox.getDate()},${lnbox.getSend_mail_id()})">${lnbox.getSend_mail_id()}</a></span>
					<span id="center_span2"  class="col-md-8"><a id="center_span2_a" href="">${lnbox.getMotive() }</a></span>
					<span id=""><span style="display: none">${lnbox.getMail_id() }</span><span>${lnbox.getDate()}</span></span>
					<a href="javascript:void(0)" onclick="change_star(this)"><span id="" class="glyphicon glyphicon-star-empty"  aria-hidden="true" style="color:${lnbox.getBit_mail()}"></span></a>
	   			</div>
   			</li>
		</c:forEach>
   		<!-- 星期五 -->
   		<li>
   			<div id="head5" style="${head6}">
   				<div id="head5_child1" >
   					<span id="" class="text-info" style=""><b>星期五</b></span>(<span id="head5_child1_span1_6">${five1 }</span>封)
   				</div>
   			</div>
   		</li>
		<c:forEach var ="lnbox" items="${five}">
			<li>
	   			<div id="center">
	   				<input id="center_input"  class="col-md-1 1"  type="checkbox" name="" id="" value="" onclick="change_color(this)" />
					<a href="javascript:void(0)" onclick="change_mail(this)"><span id="center_a1"  class="col-md-1 glyphicon glyphicon-envelope" style="color:${lnbox.getAfind()}"></span></a>
					<span id="center_span1" class="col-md-1"><a id="center_span1_a" href="javascript:void(0)" onclick="second(this,${lnbox.getDate()},${lnbox.getSend_mail_id()})">${lnbox.getSend_mail_id()}</a></span>
					<span id="center_span2"  class="col-md-8"><a id="center_span2_a" href="">${lnbox.getMotive() }</a></span>
					<span id=""><span style="display: none">${lnbox.getMail_id() }</span><span>${lnbox.getDate()}</span></span>
					<a href="javascript:void(0)" onclick="change_star(this)"><span id="" class="glyphicon glyphicon-star-empty"  aria-hidden="true" style="color:${lnbox.getBit_mail()}"></span></a>
	   			</div>
   			</li>
		</c:forEach>
   		<!-- 星期六 -->
   		<li>
   			<div id="head5" style="${head7}">
   				<div id="head5_child1" >
   					<span id="" class="text-info" style=""><b>星期六</b></span>(<span id="head5_child1_span1_7">${six1 }</span>封)
   				</div>
   			</div>
   		</li>
		<c:forEach var ="lnbox" items="${six}">
			<li>
	   			<div id="center">
	   				<input id="center_input"  class="col-md-1 1"  type="checkbox" name="" id="" value="" onclick="change_color(this)" />
					<a href="javascript:void(0)" onclick="change_mail(this)"><span id="center_a1"  class="col-md-1 glyphicon glyphicon-envelope" style="color:${lnbox.getAfind()}"></span></a>
					<span id="center_span1" class="col-md-1"><a id="center_span1_a" href="javascript:void(0)" onclick="second(this,${lnbox.getDate()},${lnbox.getSend_mail_id()})">${lnbox.getSend_mail_id()}</a></span>
					<span id="center_span2"  class="col-md-8"><a id="center_span2_a" href="">${lnbox.getMotive() }</a></span>
					<span id=""><span style="display: none">${lnbox.getMail_id() }</span><span>${lnbox.getDate()}</span></span>
					<a href="javascript:void(0)" onclick="change_star(this)"><span id="" class="glyphicon glyphicon-star-empty"  aria-hidden="true" style="color:${lnbox.getBit_mail()}"></span></a>
	   			</div>
   			</li>
		</c:forEach>
   		<!-- 星期日 -->
   		<li>
   			<div id="head5"  style="${head8}">
   				<div id="head5_child1"  >
   					<span id="" class="text-info" style=""><b>星期日</b></span>(<span id="head5_child1_span1_8">${seven1 }</span>封)
   				</div>
   			</div>
   		</li>
		<c:forEach var ="lnbox" items="${seven}">
			<li>
	   			<div id="center">
	   				<input id="center_input"  class="col-md-1 1"  type="checkbox" name="" id="" value="" onclick="change_color(this)" />
					<a href="javascript:void(0)" onclick="change_mail(this)"><span id="center_a1"  class="col-md-1 glyphicon glyphicon-envelope" style="color:${lnbox.getAfind()}"></span></a>
					<span id="center_span1" class="col-md-1"><a id="center_span1_a" href="javascript:void(0)" onclick="second(this,${lnbox.getDate()},${lnbox.getSend_mail_id()})">${lnbox.getSend_mail_id()}</a></span>
					<span id="center_span2"  class="col-md-8"><a id="center_span2_a" href="">${lnbox.getMotive() }</a></span>
					<span id=""><span style="display: none">${lnbox.getMail_id() }</span><span>${lnbox.getDate()}</span></span>
					<a href="javascript:void(0)" onclick="change_star(this)"><span id="" class="glyphicon glyphicon-star-empty"  aria-hidden="true" style="color:${lnbox.getBit_mail()}"></span></a>
	   			</div>
   			</li>
		</c:forEach>
   		
   		<!-- 更早 -->
   		<li>
   			<div id="head5" style="${head9}">
   				<div id="head5_child1" >
   					<span id="" class="text-info" style=""><b>更早</b></span>(<span id="head5_child1_span1_9">${more1 }</span>封)
   				</div>
   			</div>
   		</li>
		<c:forEach var ="lnbox" items="${more}">
			<li>
	   			<div id="center">
	   				<input id="center_input"  class="col-md-1 1"  type="checkbox" name="" id="" value="" onclick="change_color(this)" />
					<a href="javascript:void(0)" onclick="change_mail(this)"><span id="center_a1"  class="col-md-1 glyphicon glyphicon-envelope" style="color:${lnbox.getAfind()}"></span></a>
					<span id="center_span1" class="col-md-1"><a id="center_span1_a" href="javascript:void(0)" onclick="second(this,${lnbox.getDate()},${lnbox.getSend_mail_id()})">${lnbox.getSend_mail_id()}</a></span>
					<span id="center_span2"  class="col-md-8"><a id="center_span2_a" href="">${lnbox.getMotive() }</a></span>
					<span id=""><span style="display: none">${lnbox.getMail_id() }</span><span>${lnbox.getDate()}</span></span>
					<a href="javascript:void(0)" onclick="change_star(this)"><span id="" class="glyphicon glyphicon-star-empty"  aria-hidden="true" style="color:${lnbox.getBit_mail()}"></span></a>
	   			</div>
   			</li>
		</c:forEach>
   		
   		
   	
   			<div id="tail1">
   				<span id="tail1_span1">选择:</span>
   				<a href="javascript:void(0)" onclick="all_check(this)">全部</a>
   				<a href="javascript:void(0)"> - </a>
   				<a href="javascript:void(0)" onclick="all_no(this)">无</a>
   				<a href="javascript:void(0)"> - </a>
   				<a href="javascript:void(0)" onclick="all_read(this)">已读</a>
   				<a href="javascript:void(0)"> - </a>
   				<a href="javascript:void(0)" onclick="all_noread(this)">未读</a>
   			</div>
   		</li>
   		
   		<li>
   			<div id="head2" class="">
						<a id="head2_a2" href="javascript:void(0)" onclick="deleteTrue(this)" class="btn btn-default btn-lg active" role="button">删除草稿</a>
						<a id="head2_a3" href="" class="btn btn-default btn-lg active" role="button">转发</a>
						<div class="btn-group" style="" role="group">
					    		<div class="btn-group">
								  <button id="head2_button1" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								   标记为... <span class="caret"></span>
								  </button>
								  <ul class="dropdown-menu">
								    <li><a href="javascript:void(0)" onclick="read(this)">已读邮件</a></li>
								    <li><a href="javascript:void(0)" onclick="noread(this)">未读邮件</a></li>
								    <li role="separator" class="divider"></li>
								    <li><a href="javascript:void(0)" onclick="change_star1(this)">星标邮件</a></li>
								    <li><a href="javascript:void(0)" onclick="nochange_star1(this)">取消星标</a></li>
								    <li role="separator" class="divider"></li>
								  </ul>
							</div>
						</div>
						<div class="btn-group" style="" role="group">
					    	<div class="btn-group">
								  <button id="head2_button2" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								   		移动到... <span class="caret"></span>
								  </button>
								  <ul class="dropdown-menu">
								    <li><a href="javascript:void(0)" onclick="asend_box(this)">收件箱</a></li>
								    <li><a href="javascript:void(0)" onclick="asend(this)">已发送</a></li>
								    <li role="separator" class="divider"></li>
								  </ul>
							</div>
						</div>
   		
   			
				<div id="tail2_div1" class="col-md-4">
						<div class="col-md-7 col-md-offset-7">
							<span id="tail2_div1_span1">${now_page }/${all_page }页</span><a style="display: ${msg3}" href="${pageContext.servletContext.contextPath}/readAll_Inbox.do?pageNum=${pageNum}">下一页</a>&nbsp;&nbsp;<input id="page_num" type="text" style="" value="${pageNum }" /><a href="javascript:void(0)" onclick="page_t(this)">&nbsp;&nbsp;跳转</a>							
						</div>
				</div>
			</div>
   		</li>
   		<li>
   			
   		</li>
   	</ul>
	</div>
	<script type="text/javascript">
		
	</script>
	</body>
</html>

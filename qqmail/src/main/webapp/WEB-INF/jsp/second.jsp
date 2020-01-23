<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/second/second.css"/>
  </head>
  <body>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/js/jquery.min.js" ></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/bootstrap-3.3.7/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/main.js" ></script>
   	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/second/second.js" ></script>
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="${pageContext.servletContext.contextPath}/kindeditor/kindeditor-all.js"></script>
	<script charset="utf-8" src="${pageContext.servletContext.contextPath}/kindeditor/lang/zh-CN.js"></script>
	<script charset="utf-8" src="${pageContext.servletContext.contextPath}/kindeditor/plugins/code/prettify.js"></script>
   <div id="send" class="container-fluid">
   	<ul id="send_ul">
   		<li>
   			<div id="head1" class="container-fluid">
				<div id="head1-1" class="col-md-2" >
					<span id="head1-1-span1" class="text-info"><b>已发送</b></span><span id="">(共<span id="" ">1</span>封)</span>
				</div>
			</div>
   		</li>
   		
   		<li>
   			<div id="head2" class="">
   						<a id="head2_a0" href="${pageContext.servletContext.contextPath}${url_back}?pageNum=0" class="btn btn-default btn-lg active" role="button">返回</a>
   						<a id="head2_a1" href="" class="btn btn-default btn-lg active" role="button">回复</a>
   						<a id="head2_a2" href="" class="btn btn-default btn-lg active" role="button">回复全部</a>
   						<a id="head2_a1" href="javascript:void(0)" onclick="transpond(this)" class="btn btn-default btn-lg active" role="button">转发</a>
		   				<a id="head2_a1" href="javascript:void(0)" onclick="delete1(this)" class="btn btn-default btn-lg active" role="button">删除</a>
						<a id="head2_a2" href="javascript:void(0)" onclick="deleteTrue(this)" class="btn btn-default btn-lg active" role="button">彻底删除</a>
						<a id="head2_a1" href="javascript:void(0)" onclick="report(this)" class="btn btn-default btn-lg active" role="button">举报</a>
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
				<div id="head2_right1" class="col-md-3">
						<div id="head2_right1_child1" class="col-md-7 col-md-offset-6">
							<span id="head2_right1_child1_span"></span><span id="head2_right1_child1_span_1">	<!-- <a href="">上一封</a>&nbsp;<a>下一封</a> -->	</span>							
						</div>
				</div>
			</div>
   		</li>
   		
   		<li>
   			<div id="head4" class="container-fluid"">
   				<div id="head4_c" class="col-lg-10">
	   				<table border="0px" cellspacing="0" cellpadding="0">
	   					<tbody>
	   						<tr ><td id="td_1"><span id="motive" style="margin-left: 12px;">${mailPro.getMotive() }</span><a href="javascript:void(0)" onclick="change_star(this)"><span id="" class="glyphicon glyphicon-star-empty"  aria-hidden="true"></span></a></td></tr>
	   						<tr ><td style="height: 18.8px;width: 500px;"><span id="td_span_1">发件人：</span><b id="sendMailId" style="color: green;font-size: 13px;">${mailPro.getSend_mail_id()}</b><b style="color: lightsteelblue;font-size: 12px;"> <${mailPro.getSend_mail_id()}@qq.com></b><span id="tu_1"><input type="button" name="" id="input_tu_1"/></td></tr>
	   						<tr><td style="height: 20px;width: 500px;">时间：<span id="mail_id" style="display: none">${mailPro.getMail_id() }</span><span id="time" style="margin-left: 12px;color: lightsteelblue;font-size: 14px;">${mailPro.getDate() }</span></td></tr>
	   						<tr onmouseover="yc()" onmouseleave="yc_l()"><td style="height: 20px;width: 500px;"><span style="margin-left: 12px;color: lightsteelblue;font-size: 14px;">收件人：成<${mailPro.getSend_mail_id()}@qq.com></span></td>
	   							<td><div id="yc_div_1">
	   								<img id="img_yc_1" src="${pageContext.servletContext.contextPath}/img/2018-04-21_172354.png"/>
	   								<span id="yc_c_1">
	   									成
	   								</span>
	   								<span id="">
	   									<a href="">${mailPro.getSend_mail_id()}@qq.com</a>
	   								</span>
	   							</div></td>
	   						</tr>
	   					</tbody>
	   				</table>
   				</div>
   				<div id="" class="col-lg-2" style="">
   					<div id="" class="col-lg-offset-10" style="height: 44px;width: 44px;margin-top: 10px;">
   						<img src=""/>
   					</div>
   				</div>
   			</div>
   		</li>
   		<li>
   			<!----------------------富文本显示------------------------->
		   	<form name="example" method="post" action="demo.jsp">
				<textarea name="content1" cols="100" rows="8"  style="width:100%;height:200px;visibility:hidden; ">${mailPro.getMain_body() }</textarea>
				<br />
			</form>
			<input onclick="on_back(this)" class="form-control" type="" name="" id="" value="" placeholder="快捷回复给：" />
			<form style="display: none;" name="example" method="post" action="demo.jsp">
				<textarea name="content2" cols="100" rows="8" style="width:100%;height:10px;visibility:hidden;"></textarea>
				<br />
				<input id="submit_1" type="submit" name="button" value="发送" class="btn btn-success"/>
			</form>
   		</li>
   		<li>
   			<div id="tail2" style="margin-top: 5px;">
   						<a id="head2_a0" href="${pageContext.servletContext.contextPath}${url_back}?pageNum=0"  class="btn btn-default btn-lg active" role="button">返回</a>
   						<a id="head2_a1" href="" class="btn btn-default btn-lg active" role="button">回复</a>
   						<a id="head2_a2" href="" class="btn btn-default btn-lg active" role="button">回复全部</a>
   						<a id="head2_a1" href="javascript:void(0)" onclick="transpond(this)" class="btn btn-default btn-lg active" role="button">转发</a>
		   				<a id="head2_a1" href="javascript:void(0)" onclick="delete1(this)" class="btn btn-default btn-lg active" role="button">删除</a>
						<a id="head2_a2" href="javascript:void(0)" onclick="deleteTrue(this)" class="btn btn-default btn-lg active" role="button">彻底删除</a>
						<a id="head2_a1" href="javascript:void(0)" onclick="report(this)" class="btn btn-default btn-lg active" role="button">举报</a>
						<div class="btn-group" role="group">
					    		<div class="btn-group dropup">
								  <button id="tail2_button1" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
					    	<div class="btn-group dropup">
								  <button id="tail2_button2" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								   		移动到... <span class="caret"></span>
								  </button>
								  <ul class="dropdown-menu">
								    <li><a href="javascript:void(0)" onclick="asend_box(this)">收件箱</a></li>
								    <li><a href="javascript:void(0)" onclick="asend(this)">已发送</a></li>
								    <li role="separator" class="divider"></li>
								  </ul>
							</div>
						</div>
				<div id="tail2_div1" class="col-md-3">
						<div class="col-md-7 col-md-offset-6">
							<span id="tail2_div1_span1"></span><span id="" style="font-size: 15px;font-weight: bold;">	<!-- <a href="">上一封</a>&nbsp;<a>下一封</a> -->	</span>						
						</div>
				</div>
			</div>
   		</li>
   		<li>
   			
   		</li>
   	</ul>
	</div>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				items:[],
				cssPath : '${pageContext.servletContext.contextPath}/kindeditor/plugins/code/prettify.css',
				uploadJson : '${pageContext.servletContext.contextPath}/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '${pageContext.servletContext.contextPath}/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content2"]', {
				cssPath : '${pageContext.servletContext.contextPath}/kindeditor/plugins/code/prettify.css',
				uploadJson : '${pageContext.servletContext.contextPath}/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '${pageContext.servletContext.contextPath}/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
	</body>
	
</html>
<!--<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>-->
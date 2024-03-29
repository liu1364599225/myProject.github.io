<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
//String htmlData = request.getSession().getAttribute("content1") != null ? request.getParameter("content1") : "";
String htmlData = (String)request.getAttribute("content1") != null ? (String)request.getAttribute("content1") : "";
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>KindEditor JSP</title>
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="${pageContext.servletContext.contextPath}/kindeditor/kindeditor-all.js"></script>
	<script charset="utf-8" src="${pageContext.servletContext.contextPath}/kindeditor/lang/zh-CN.js"></script>
	<script charset="utf-8" src="${pageContext.servletContext.contextPath}/kindeditor/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				cssPath : 'plugins/code/prettify.css',
				uploadJson : 'jsp/upload_json.jsp',
				fileManagerJson : 'jsp/file_manager_json.jsp',
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
</head>
<body>
	<form name="example" method="post" action="jsp/demo.jsp">
		<textarea name="content1" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"><%=htmlspecialchars(htmlData)%></textarea>
		<br />
		<input type="submit" name="button" value="提交内容" /> (提交快捷键: Ctrl + Enter)
	</form>
</body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>
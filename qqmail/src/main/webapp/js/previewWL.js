$(function(){
	var basePath = window.document.location.href;
	basePath = basePath.substring(0,basePath.lastIndexOf('/'));
	
	var nowtime=new Date();
	var year=nowtime.getFullYear();
	var month=nowtime.getMonth()+1;
	var day=nowtime.getDate();
	var hours = nowtime.getHours();
	var minutes = nowtime.getMinutes();
	var seconds = nowtime.getSeconds();
	document.getElementById("time").innerText=year+"年"+month+"月"+day+"日  "+hours+":"+minutes+":"+seconds;
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="main_body"]', {
			resizeType : 0,	// 2时可以拖动改变宽度和高度，1时只能改变高度，0时不能拖动。 
			readonlyMode : true, //是否为只读
			themeType : 'simple',//更换主题
			items:[//菜单栏配置
			      
			      ],
			cssPath :  basePath+'/kindeditor/plugins/code/prettify.css',
			uploadJson : basePath+'/kindeditor/jsp/upload_json.jsp',
			fileManagerJson : basePath+'/kindeditor/jsp/file_manager_json.jsp',
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
		
		if($("#notepaperImg").val() != ""){
			var imgSrc = "../qqmail"+$("#notepaperImg").val();
			/*富文本中的对象*/	
			$(".ke-container-simple").css("background","url("+imgSrc+") center");
			$(".ke-container-simple").css("background-size","100%");
		}
		prettyPrint();
	});
});

    function showTime(){
	    nowtime=new Date();
	    year=nowtime.getFullYear();
	    month=nowtime.getMonth()+1;
	    day=nowtime.getDate();
	    hours = nowtime.getHours();
	    minutes = nowtime.getMinutes();
        seconds = nowtime.getSeconds();
	    document.getElementById("time").innerText=year+"年"+month+"月"+day+"日  "+hours+":"+minutes+":"+seconds;
	}
	
	setInterval("showTime()",1000);

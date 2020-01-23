function all_read(obj){
	var c = document.getElementsByClassName("col-md-1 glyphicon glyphicon-envelope");
	for(var i = 0 ; i < c.length; i++){
		if(c[i].style.color == "darkkhaki"){
			$(c[i]).parent().siblings("input").prop("checked", true);
			//console.log($(c[i]).siblings("input"));
			//$(c[i]).siblings("input").get()[0].checked = true;
			//c[i].previousSibling.checked = true;
		}else{
			$(c[i]).parent().siblings("input").prop("checked", false);
		}
	}
}
function all_noread(obj){
	var c = document.getElementsByClassName("col-md-1 glyphicon glyphicon-envelope");
	for(var i = 0 ; i < c.length; i++){
		if(c[i].style.color == "darkkhaki"){
			console.log($(c[i]).parent().siblings("input"));
			$(c[i]).parent().siblings("input").prop("checked", false);
			//console.log($(c[i]).siblings("input"));
			//$(c[i]).siblings("input").get()[0].checked = true;
			//c[i].previousSibling.checked = true;
		}else{
			console.log($(c[i]).parent().siblings("input"));
			$(c[i]).parent().siblings("input").prop("checked", true);
		}
	}
}
function all_no(obj){
	var c = document.getElementsByClassName("col-md-1");
	for(var i = 0 ; i < c.length; i++){
	c[i].checked = false;
	}
}
function all_check(obj){
	var c = document.getElementsByClassName("col-md-1");
	for(var i = 0 ; i < c.length; i++){
	c[i].checked = true;
	}
}

function change_mail(obj){
	$(obj).children().css("color","darkkhaki");
}
var i = 1;
function change_star(obj){
	
	if(i == 0){
		$(obj).css("color","black");
		i = 1;
	}else{
		$(obj).css("color","#FAD04D");
		i = 0;
	}
}

function change_color(obj){
	var s1 = $(obj).parent();
	var s2 = $(obj).is(":checked");
	if(s2 == true){
		s1.css("background-color","#528BCB");
	}else{
		s1.css("background-color","white");
	}
	
}
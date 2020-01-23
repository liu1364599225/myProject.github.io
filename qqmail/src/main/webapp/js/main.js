function textonblur(){
	var text = document.getElementById("top-search-text");
	text.value="邮箱搜索..";
}

function textonfocus(){
	var text = document.getElementById("top-search-text");
	text.value="";
}

function birthdaytip(){
	var top1 = document.getElementById("point-out-top1");
	top1.style.backgroundColor="white";
	document.getElementById("point-out-top2").style.backgroundColor="#EFF5FB";
	document.getElementById("point-out-content1").style.display="inline";
	document.getElementById("point-out-content2").style.display="none";
}

function mycontent(){
	var top2 = document.getElementById("point-out-top2");
	top2.style.backgroundColor="white";
	document.getElementById("point-out-top1").style.backgroundColor="#EFF5FB";
	document.getElementById("point-out-content2").style.display="inline";
	document.getElementById("point-out-content1").style.display="none";
}

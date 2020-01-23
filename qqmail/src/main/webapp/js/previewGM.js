window.onload = function(){
	var nowtime=new Date();
	var year=nowtime.getFullYear();
	var month=nowtime.getMonth()+1;
	var day=nowtime.getDate();
	var hours = nowtime.getHours();
	var minutes = nowtime.getMinutes();
	var seconds = nowtime.getSeconds();
	document.getElementById("time").innerText=year+"年"+month+"月"+day+"日  "+hours+":"+minutes+":"+seconds;
}

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

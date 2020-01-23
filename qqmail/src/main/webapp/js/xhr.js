function getXMLHttpRequest(){
	var xhr = null;
	if((typeof XMLHttpRequest)!= 'undefined'){
		xhr = new XMLHttpRequest();
	}else{
		xhr = new ActiveXObject('Microsoft.XMLHttp');
	}
	return xhr;
}
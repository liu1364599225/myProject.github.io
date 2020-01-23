$(function(){
	
	$("#typeSelect").change(function(){
		var typeSelect = document.getElementById("typeSelect");
		var petShop = document.getElementById("petShop");
		var fosterFamily = document.getElementById("fosterFamily");
		
		var ops = typeSelect.options;
		for(var i=0; i<ops.length; i++){
			if(ops[i].selected == true){
				if(ops[i].text == "寄养家庭寄养") {
					petShop.style.display = "none";
					fosterFamily.style.display = "inline";
				} else {
					petShop.style.display = "inline";
					fosterFamily.style.display = "none";
				}
			}
		}
	});
	
	$(".addAndsub").click(function(){
		var opt = $(this).text();
		if(opt == "-"){
			var num = parseInt($("#fosterDay").val());
			if(num > 1){
				$("#fosterDay").val(--num);
			}
		}else if(opt == "+"){
			var num = parseInt($("#fosterDay").val());
			$("#fosterDay").val(++num);
		}
					
	});
	
//	$("#address-hidden").change(function(){
//			var xhr = getXMLHttpRequest();
//			var value = $("#address").val();
//			$.post(basePath + '/checkAddress1.pet', 'address=' + value,
//					function(data) {
//						text = data;
//					}, 'text');
//	});
});
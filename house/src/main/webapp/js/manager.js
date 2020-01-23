$(function(){
	$("#typeSelect").change(function(){
		var typeSelect = document.getElementById("typeSelect");
		var fosterUser = document.getElementById("fosterUser");
		var petShop = document.getElementById("petShop");
		var fosterFamily = document.getElementById("fosterFamily");
		
		var ops = typeSelect.options;
		for(var i=0; i<ops.length; i++){
			if(ops[i].selected == true){
				if(ops[i].text == "寄养用户") {
					fosterUser.style.display = "inline";
					fosterFamily.style.display = "none";
					petShop.style.display = "none";
				} else if(ops[i].text == "寄养家庭"){
					fosterFamily.style.display = "inline";
					petShop.style.display = "none";
					fosterUser.style.display = "none";
				} else if(ops[i].text == "宠物店"){
					petShop.style.display = "inline";
					fosterUser.style.display = "none";
					fosterFamily.style.display = "none";
				}
			}
		}
	});
});
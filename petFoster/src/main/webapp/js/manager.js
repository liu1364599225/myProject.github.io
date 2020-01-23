$(function(){
	$("#typeSelect").change(function(){
		var typeSelect = document.getElementById("typeSelect");
		var petShop = document.getElementById("petShop");
		var fosterFamily = document.getElementById("fosterFamily");
		
		var ops = typeSelect.options;
		for(var i=0; i<ops.length; i++){
			if(ops[i].selected == true){
				if(ops[i].text == "寄养家庭"){
					fosterFamily.style.display = "inline";
					petShop.style.display = "none";
				} else if(ops[i].text == "宠物店"){
					petShop.style.display = "inline";
					fosterFamily.style.display = "none";
				}
			}
		}
	});
});
$(function() {
	var basePath = "http://localhost:8888/petFoster";
	var prompt = $(".prompt");

	$("#accountName").blur(
			function() {
				var xhr = getXMLHttpRequest();
				var value = $("#accountName").val();
				$.post(basePath + '/checkAccountName1.pet', 'accountName='
						+ value, function(data) {
					text = data;
					prompt[0].innerText = text;
				}, 'text');
			});

	$("#password").blur(
			function() {
				var xhr = getXMLHttpRequest();
				var value = $("#password").val();
				$.post(basePath + '/checkPassword1.pet', 'password=' + value,
						function(data) {
							text = data;
							prompt[1].innerText = text;
						}, 'text');

			});

	$("#againPassword").blur(
			function() {
				var xhr = getXMLHttpRequest();
				var value = $("#againPassword").val();
				var value1 = $("#password").val();
				$.post(basePath + '/checkAgainPassword1.pet', 'againPassword='
						+ value + '&' + 'password=' + value1, function(data) {
					text = data;
					prompt[2].innerText = text;
				}, 'text');

			});

	$("#fosterName").blur(
			function() {
				var xhr = getXMLHttpRequest();
				var value = $("#fosterName").val();
				$.post(basePath + '/checkFosterName.pet',
						'fosterName=' + value, function(data) {
							text = data;
							prompt[3].innerText = text;
						}, 'text');

			});

	$("#fosterExperience").blur(
			function() {
				var xhr = getXMLHttpRequest();
				var value = $("#fosterExperience").val();
				$.post(basePath + '/checkfosterExperience.pet',
						'fosterExperience=' + value, function(data) {
							text = data;
							prompt[5].innerText = text;
						}, 'text');

			});

	$("#contactWay").blur(
			function() {
				var xhr = getXMLHttpRequest();
				var value = $("#contactWay").val();
				$.post(basePath + '/checkContactWay1.pet', 'contactWay='
						+ value, function(data) {
					text = data;
					prompt[6].innerText = text;
				}, 'text');

			});

	$("#address-a").blur(
			function() {
				var xhr = getXMLHttpRequest();
				var value = $("#address").val();
				$.post(basePath + '/checkAddress1.pet', 'address=' + value,
						function(data) {
							text = data;
							prompt[7].innerText = text;
						}, 'text');
			});

	$("#fosterFamilyPhoto").blur(
			function() {
				var xhr = getXMLHttpRequest();
				var value = $("#fosterFamilyPhoto").val();
				$.post(basePath + '/checkFosterFamilyPhoto.pet',
						'fosterFamilyPhoto=' + value, function(data) {
							text = data;
							prompt[8].innerText = text;
						}, 'text');
			});

	$(".type").blur(function() {
		var times = 0;
		for (var i = 0; i < $(".type").length; i++) {
			if ($(".type")[i].checked == true) {
				times = 1;
				break;
			}
		}

		if (times == 0) {
			prompt[9].innerText = "宠物类型范围不能为空";
		} else {
			prompt[9].innerText = "";
		}
	});
});
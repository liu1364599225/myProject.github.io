$(function() {
	var basePath = window.document.location.href;
	basePath = basePath.substring(0,basePath.lastIndexOf('/'));
	var prompt = $(".prompt");

	$("#accountName").blur(
			function() {
				var value = $("#accountName").val();
				$.post(basePath + '/checkUserAccount.fw', 'userAccount='
						+ value, function(data) {
					text = data;
					prompt[0].innerText = text;
				}, 'text');
			});

	$("#password").blur(
			function() {
				var value = $("#password").val();
				$.post(basePath + '/checkPassword.fw', 'userPassword=' + value,
						function(data) {
							text = data;
							prompt[1].innerText = text;
						}, 'text');

			});

	$("#againPassword").blur(
			function() {
				var value = $("#againPassword").val();
				var value1 = $("#password").val();
				$.post(basePath + '/checkAgainPassword.fw', 'againPassword='
						+ value + '&' + 'userPassword=' + value1, function(data) {
					text = data;
					prompt[2].innerText = text;
				}, 'text');

			});

	$("#UserName").blur(
			function() {
				var value = $("#UserName").val();
				$.post(basePath + '/checkUserName.fw',
						'userName=' + value, function(data) {
							text = data;
							prompt[3].innerText = text;
						}, 'text');

			});

	$("#contactWay").blur(
			function() {
				var value = $("#contactWay").val();
				$.post(basePath + '/checkContactWay.fw', 'userTelnumber='
						+ value, function(data) {
					text = data;
					prompt[4].innerText = text;
				}, 'text');

			});

	$("#avatarPhoto").blur(
			function() {
				var value = $("#avatarPhoto").val();
				$.post(basePath + '/checkAvatar.fw',
						'avatar=' + value, function(data) {
							text = data;
							prompt[5].innerText = text;
						}, 'text');
			});
});
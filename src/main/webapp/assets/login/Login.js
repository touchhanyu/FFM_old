$(function() {
	document.onkeydown = keyDowm;
	var cookies = document.cookie.split(";");
	for (var i = 0; i < cookies.length; i++) {
		var cookie = cookies[i];
		var attr = cookie.split("=");
		if (attr[0] == "username") {
			$('#username').val(decodeURI(attr[1]));
		}
	}
})
function keyDowm() {
	if (event.keyCode == 13) {
		login();
	}
}
function freshImg() {
	var url = $('#verifyCode').attr('src');
	var date = new Date();
	$('#verifyCode').attr('src', url + '?' + date.getTime());
}
function login() {
	var url = basePath + '/login/login';
	var username = $('#username').val();
	var password = $('#password').val();
	var verifycode = $('#verifycode').val();
	var autologin = $('#autologin').val();
	var param = {
		name : username,
		password : password,
		verifycode : verifycode,
		autologin : autologin
	};
	if (username == null || username == '' || password == '' || password == null)
		return;
	$.post(url, param, function(data) {
		if (data.status) {
			window.location.href = basePath + '/sys/main';
		} else {
			alert(data.msg);
			window.location.reload();
		}
	}, 'json');
}
function register() {
	var url = basePath + "/login/registerPage";
	window.open(url, "FFM_Register");
}
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>家庭财务管理系统-Family Financial Managment</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/AdminLTE-2.4.3/css/AdminLTE.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/Ionicons/css/ionicons.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/ffm/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/login/Login.js"></script>
<script type="text/javascript">
	var basePath = '<%=request.getContextPath()%>';
	$(function() {
		$('input').iCheck({
			checkboxClass : 'icheckbox_square-blue',
			radioClass : 'iradio_square-blue',
			increaseArea : '20%' // optional
		});
	})
</script>
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="#"><b>F</b>FM</a>
		</div>
		<div class="login-box-body">
			<p class="login-box-msg">登录</p>
			<form id="loginform" method="post">
				<div class="form-group has-feedback">
					<input type="text" id="username" class="form-control" placeholder="用户名">
					<span class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" id="password" class="form-control" placeholder="密码">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group row">
					<div class="col-md-7">
						<input type="password" id="verifycode" class="form-control" placeholder="验证码">
					</div>
					<div class="col-md-5">
						<img id="verifyCode" src="../${pageContent.request.contextPath}/login/verifyCode" onclick="freshImg();">
					</div>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label><input id="autologin" type="checkbox" name="autologin" checked/> 下次自动登录</label>
						</div>
					</div>
					<div class="col-xs-4">
						<button type="button" class="btn btn-primary btn-block btn-flat" onclick="login()">登     录</button>
					</div>
				</div>
			</form>
			<a href="#">忘记密码</a><br>
			<span>没有帐号？</span><a href="#" class="text-center" onclick="register();">注     册</a>
		</div>
	</div>
</body>
</html>
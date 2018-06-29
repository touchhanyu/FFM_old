<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!-- <!DOCTYPE html> -->
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<meta name="renderer" content="webkit"><!-- 国产浏览器高速模式 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/Ionicons/css/ionicons.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/AdminLTE-2.4.3/css/skins/_all-skins.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/css/select2.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/AdminLTE-2.4.3/css/AdminLTE.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/huiadmin/H-ui.admin.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/googlefont/googlefont.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/select2/js/select2.full.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/select2/js/i18n/zh-CN.js"></script>
<!-- [if IE 9]>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/html5shiv.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/respond.min.js"></script>
<[end if] -->
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/AdminLTE-2.4.3/js/adminlte.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/huiadmin/H-ui.admin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/huiadmin/jquery.contextmenu.r2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/home/main.js"></script>
<script type="text/javascript">
	var basePath = '${pageContext.request.contextPath}';
</script>
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<header class="main-header">
			<a href="#" class="logo">
				<span class="logo-mini"><b>F</b>FM</span>
				<span class="logo-lg"><b>F</b>FM</span>
			</a>
			<nav class="navbar navbar-static-top" role="navigation">
				<a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
					<span class="sr-only">Toggle navigation</span>
				</a>
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<li class="dropdown messages-menu">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="fa fa-envelope-o"></i>
								<span class="label label-success">4</span>
							</a>
							<ul class="dropdown-menu">
								<li class="header">你有4条消息</li>
								<li>
									<ul class="menu">
										<li>
											<a href="#">
												<div class="pull-left">
													<img src="../plugins/AdminLTE-2.4.3/img/user2-160x160.jpg" class="img-circle" alt="User Image">
												</div>
												<h4>H4<small><i class="fa fa-clock-o"></i> 5 mins</small></h4>
												<p>text?</p>
											</a>
										</li>
									</ul>
								</li>
								<li class="footer"><a href="#">查看全部消息</a></li>
							</ul>
						</li>
						<li class="dropdown notifications-menu">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="fa fa-bell-o"></i>
								<span class="label label-warning">10</span>
							</a>
							<ul class="dropdown-menu">
								<li class="header">你有10个提醒</li>
								<li>
									<ul class="menu">
										<li>
											<a href="#">
												<i class="fa fa-users text-aqua"></i> 5 new members joined today
											</a>
										</li>
									</ul>
								</li>
								<li class="footer"><a href="#">查看全部提醒</a></li>
							</ul>
						</li>
						<li class="dropdown tasks-menu">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="fa fa-flag-o"></i>
								<span class="label label-danger">9</span>
							</a>
							<ul class="dropdown-menu">
								<li class="header">你有9个任务</li>
								<li>
									<ul class="menu">
										<li>
											<a href="#">
												<h3>H3<small class="pull-right">20%</small></h3>
												<div class="progress xs">
													<div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
														<span class="sr-only">完成20%</span>
													</div>
												</div>
											</a>
										</li>
									</ul>
								</li>
								<li class="footer">
									<a href="#">查看全部任务</a>
								</li>
							</ul>
						</li>
						<li class="dropdown user user-menu">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<img src="../plugins/AdminLTE-2.4.3/img/user2-160x160.jpg" class="user-image" alt="User Image">
								<span class="hidden-xs">${session.user.name}</span>
							</a>
							<ul class="dropdown-menu">
								<li class="user-header">
									<img src="../plugins/AdminLTE-2.4.3/img/user2-160x160.jpg" class="img-circle" alt="User Image">
									<p>${session.user.name}<small>欢迎回来!</small></p>
								</li>
								<li class="user-body">
									<div class="row">
										<div class="col-xs-4 text-center">
											<a href="#">个人资料</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="#" onclick="changePwd(this);">修改密码</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="#">Row3</a>
										</div>
									</div>
								</li>
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat" onclick="lockScreen();"><span class="glyphicon glyphicon-lock"></span>&nbsp;锁屏</a>
									</div>
									<div class="pull-right">
										<a href="#" class="btn btn-default btn-flat" onclick="logout()"><span class="glyphicon glyphicon-off" style="color:red"></span>&nbsp;退  出</a>
									</div>
								</li>
							</ul>
						</li>
						<li>
							<a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
						</li>
					</ul>
				</div>
			</nav>
		</header>
		<aside class="main-sidebar">
			<section class="sidebar">
				<!-- 搜索框 -->
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control" placeholder="Search...">
						<span class="input-group-btn">
							<button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
						</span>
					</div>
				</form>
				<ul id="menu" class="sidebar-menu" data-widget="tree"></ul>
			</section>
		</aside>
		<section class="content-wrapper">
			<div id="Hui-tabNav" class="Hui-tabNav">
		        <div class="Hui-tabNav-wp">
					<ul id="min_title_list" class="acrossTab cl" style="padding-left: 6px;">
						<li class="active">
						    <span title="首页" data-href="">首页</span><em></em>
						</li>
					</ul>
				</div>
		    </div>
		    <div id="iframe_box" class="Hui-article">
		        <div class="show_iframe">
		           <iframe scrolling="yes" frameborder="0" src="${pageContext.request.contextPath}/sys/home"></iframe>
		        </div>
		    </div>
		</section>
		<div class="contextMenu" id="Huiadminmenu">
			<ul>
				<li id="closethis">关闭当前 </li>
				<li id="closeall">关闭全部 </li>
			</ul>
		</div>
	</div>
</body>
</html>
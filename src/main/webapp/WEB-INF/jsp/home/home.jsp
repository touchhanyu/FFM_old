<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!Doctype html>
<html>
<head>
<%@ include file="../common/common.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/home/home.js"></script>
</head>
<body>
<div class="wrapper">
	<section class="content-header">
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
		</ol>
	</section>
	<hr>
	<section class="content">
		<div class="row">
			<section class="col-xs-7 connectedSortable">
				<div class="box box-primary">
					<div class="box-header">
						<i class="ion ion-clipboard"></i>
						<h3 class="box-title">待办任务</h3>
						<div class="box-tools pull-right">
							<button type="button" class="btn btn-default pull-right"><i class="fa fa-plus"></i> Add item</button>
						</div>
					</div>
					<div class="box-body">
						<ul class="todo-list">
							<li>
								<span class="handle">
									<i class="fa fa-ellipsis-v"></i>
									<i class="fa fa-ellipsis-v"></i>
								</span>
								<input type="checkbox" value="">
								<span class="text">Design a nice theme</span>
								<small class="label label-danger"><i class="fa fa-clock-o"></i> 2 mins</small>
								<div class="tools">
									<i class="fa fa-edit"></i>
									<i class="fa fa-trash-o"></i>
								</div>
							</li>
							<li>
								<span class="handle">
									<i class="fa fa-ellipsis-v"></i>
									<i class="fa fa-ellipsis-v"></i>
								</span>
								<input type="checkbox" value="">
								<span class="text">Make the theme responsive</span>
								<small class="label label-info"><i class="fa fa-clock-o"></i> 4 hours</small>
								<div class="tools">
									<i class="fa fa-edit"></i>
									<i class="fa fa-trash-o"></i>
								</div>
							</li>
							<li>
								<span class="handle">
									<i class="fa fa-ellipsis-v"></i>
									<i class="fa fa-ellipsis-v"></i>
								</span>
								<input type="checkbox" value="">
								<span class="text">Let theme shine like a star</span>
								<small class="label label-warning"><i class="fa fa-clock-o"></i> 1 day</small>
								<div class="tools">
									<i class="fa fa-edit"></i>
									<i class="fa fa-trash-o"></i>
								</div>
							</li>
							<li>
								<span class="handle">
									<i class="fa fa-ellipsis-v"></i>
									<i class="fa fa-ellipsis-v"></i>
								</span>
								<input type="checkbox" value="">
								<span class="text">Let theme shine like a star</span>
								<small class="label label-success"><i class="fa fa-clock-o"></i> 3 days</small>
								<div class="tools">
									<i class="fa fa-edit"></i>
									<i class="fa fa-trash-o"></i>
								</div>
							</li>
							<li>
								<span class="handle">
									<i class="fa fa-ellipsis-v"></i>
									<i class="fa fa-ellipsis-v"></i>
								</span>
								<input type="checkbox" value="">
								<span class="text">Check your messages and notifications</span>
								<small class="label label-primary"><i class="fa fa-clock-o"></i> 1 week</small>
								<div class="tools">
									<i class="fa fa-edit"></i>
									<i class="fa fa-trash-o"></i>
								</div>
							</li>
							<li>
								<span class="handle">
									<i class="fa fa-ellipsis-v"></i>
									<i class="fa fa-ellipsis-v"></i>
								</span>
								<input type="checkbox" value="">
								<span class="text">Let theme shine like a star</span>
								<small class="label label-default"><i class="fa fa-clock-o"></i> 1 month</small>
								<div class="tools">
									<i class="fa fa-edit"></i>
									<i class="fa fa-trash-o"></i>
								</div>
							</li>
						</ul>
					</div>
					<div class="box-footer clearfix no-border">
						<ul class="pagination pagination-sm inline">
							<li><a href="#">&laquo;</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>
					</div>
				</div>
			</section>
			<section class="col-xs-5 connectedSortable">
				<!-- 日历 -->
				<div class="box box-solid bg-blue-gradient">
					<div class="box-header">
						<i class="fa fa-calendar"></i>
						<h3 class="box-title">日历</h3>
						<div class="pull-right box-tools">
							<div class="btn-group">
								<button type="button" class="btn btn-outline btn-sm dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bars"></i></button>
								<ul class="dropdown-menu pull-right" role="menu">
									<li><a href="#">Add new event</a></li>
									<li><a href="#">Clear events</a></li>
									<li class="divider"></li>
									<li><a href="#">View calendar</a></li>
								</ul>
							</div>
							<button type="button" class="btn btn-outline btn-sm" data-widget="collapse"><i class="fa fa-minus"></i></button>
							<button type="button" class="btn btn-outline btn-sm" data-widget="remove"><i class="fa fa-times"></i></button>
						</div>
					</div>
					<div class="box-body no-padding">
						<div id="calendar" style="width: 100%"></div>
					</div>
					<div class="box-footer text-black">
						<div class="row">
							<div class="col-sm-6">
								<div class="clearfix">
									<span class="pull-left">Task #1</span>
									<small class="pull-right">90%</small>
								</div>
								<div class="progress xs">
									<div class="progress-bar progress-bar-blue" style="width: 90%;"></div>
								</div>
								
								<div class="clearfix">
									<span class="pull-left">Task #2</span>
									<small class="pull-right">70%</small>
								</div>
								<div class="progress xs">
									<div class="progress-bar progress-bar-blue" style="width: 70%;"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 地图 -->
				<div class="box box-solid bg-light-blue-gradient">
					<div class="box-header">
						<div class="pull-right box-tools">
							<button type="button" class="btn btn-primary btn-sm daterange pull-right" data-toggle="tooltip" title="Date range"><i class="fa fa-calendar"></i></button>
							<button type="button" class="btn btn-primary btn-sm pull-right" data-widget="collapse" data-toggle="tooltip" title="Collapse" style="margin-right: 5px;"><i class="fa fa-minus"></i></button>
						</div>
						<i class="fa fa-map-marker"></i>
						<h3 class="box-title">地图</h3>
						<div class="box-body">
							<div id="world-map" style="height: 250px; width: 100%;"></div>
						</div>
						<div class="box-footer no-border">
							<div class="row">
								<div class="col-xs-4 text-center" style="border-right: 1px solid #f4f4f4">
									<div id="sparkline-1"></div>
									<div class="knob-label">Visitors</div>
								</div>
								<div class="col-xs-4 text-center" style="border-right: 1px solid #f4f4f4">
									<div id="sparkline-2"></div>
									<div class="knob-label">Online</div>
								</div>
								<div class="col-xs-4 text-center">
									<div id="sparkline-3"></div>
									<div class="knob-label">Exists</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</section>
</div>
</body>
</html>
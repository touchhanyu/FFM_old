$(function() {
	$('#menu').adminmenu({
		header : '菜单',
		url : basePath + '/menu/sysMenu',
		onclick : function(obj) {
			var href = $(obj).attr("data-href");
			if (href != null && href != undefined) {
				Hui_admin_tab(obj);
			}
		}
	});
})
function searchMenu() {
}
function openTabs(id, text, href) {
	var tabs = $('#tabsnav > li[id="' + id + '"]');
	if (tabs.length == 0) { //创建
		var htmlStr = '<li id="' + id + '"><a href="#tab' + id + '" data-toggle="tab">' + text + ' <i class="fa fa-times"></i></a></li>';
		$('#tabsnav').append(htmlStr);
		htmlStr = '<div class="tab-pane" id="tab' + id + '"></div>';
		$('#tabcontext').append(htmlStr);
		$('#tab' + id).load(href);
	}
	$('#tabsnav > li[id="' + id + '"] a').click();
}
function testICheck() {
	var clicks = $(this).data('clicks');
	if (clicks) {
		$(".table input[type='checkbox']").iCheck("uncheck");
		$(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
	} else {
		$(".table input[type='checkbox']").iCheck("check");
		$(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
	}
}
function logout() {
	var url = basePath + '/sys/logout';
	$.post(url, function() {
		window.location.reload();
	}, 'text');
}
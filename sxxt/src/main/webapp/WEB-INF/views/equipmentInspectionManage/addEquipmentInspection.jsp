<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Dashboard</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="<%=path%>/assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=path%>/assets/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="<%=path%>/assets/css/bootstrap-select.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=path%>/assets/css/font-awesome.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%=path%>/assets/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="<%=path%>/assets/css/unicorn.main.css" />
<link rel="stylesheet" href="<%=path%>/assets/css/unicorn.grey.css"
	class="skin-color" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" href="<%=path%>/assets/css/_all-skins.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="<%=path%>/assets/css/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="<%=path%>/assets/css/bootstrapValidator.css" />
<link rel="stylesheet" href="<%=path%>/assets/css/square/blue.css" />
</head>
<style type="text/css">
.content-wrapper, .right-side, .main-footer {
	/* -webkit-transition: -webkit-transform .3s ease-in-out,margin .3s ease-in-out; */
	-moz-transition: -moz-transform .3s ease-in-out, margin .3s ease-in-out;
	-o-transition: -o-transform .3s ease-in-out, margin .3s ease-in-out;
	/* transition: transform .3s ease-in-out,margin .3s ease-in-out; */
	margin-left: 120px;
	z-index: 820;
}

.form-horizontal .control-group {
	background: none repeat scroll 0 0 #F9F9F9;
}

.form-horizontal .form-group {
	margin: 0px;
}

.form-horizontal .background {
	background: none repeat scroll 0 0 #F9F9F9;
}

.form-horizontal .control-label {
	padding-top: 15px;
}

.form-control {
	width: 50%;
}

.panel-body {
	padding: 0px;
}

.form-actions {
	background: none repeat scroll 0 0 #F9F9F9;
	padding: 5px;
}

.form-actions .btn-submit {
	margin-left: 45%;
}

.form-horizontal .has-feedback .form-control-feedback {
	right: 239px;
	top: 9px;
}

.bv-form .help-block {
	margin-bottom: 0;
	margin-left: 275px;
}

.radio-label {
	padding-right: 10px;
}

.add-input {
	display: initial;
}
</style>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<%-- <jsp:include page="header.jsp"></jsp:include> --%>
	<jsp:include page="${myheader}"></jsp:include>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->

			<div class="content-wrapper">
				<section class="content">

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">添加场地设备年检信息</h3>
					</div>
					<div id="breadcrumb">
						<a href="#" title="首页" class="tip-bottom"> <i
							class="icon-home"></i> Home
						</a> <a href="listClass.html">设备年检信息</a> <a href="#" class="current">添加设备年检信息</a>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post"
							action="/equipmentInspection/doAdd" id="registerForm">
							<!-- 添加学校 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">场所名称</label>
								<div class="controls form-group">
									<div class="dropdown btn-group" style="width: 50%">
										<button id="dLabel" class="btn btn-default dropdown-toggle"
											type="button" data-toggle="dropdown" style="width: 100%">
											<span id="siteId" value="${siteList.get(0).id}">${siteList.get(0).classroomCode}</span>
											<span class="caret"></span>
										</button>
										<input id='site-input' name="site.id"
											value="${siteList.get(0).id}" hidden="true" />
										<ul class="dropdown-menu site-menu" aria-labelledby="dLabel"
											role="menu"
											style="width: 100%; height: 150px; overflow: scroll;">
											<c:forEach var="siteList" items="${siteList}">
												<li><a valueID="${siteList.id}">${siteList.classroomCode}</a></li>
											</c:forEach>
										</ul>
									</div>

								</div>
							</div>
							<!-- 添加专业 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">设备名称</label>
								<div class="controls form-group">
									<div class="dropdown btn-group" style="width: 50%">
										<button id="dLabel" class="btn btn-default dropdown-toggle"
											type="button" data-toggle="dropdown" style="width: 100%">
											<span id="equipmentInfoId"
												value="${equipmentInfoList.get(0).id}">${equipmentInfoList.get(0).name}</span>
											<span class="caret"></span>
										</button>
										<input id='equipmentInfo-input' name="equipmentInfo.id"
											value="${equipmentInfoList.get(0).id}" hidden="true" />
										<ul class="dropdown-menu equipmentInfo-menu"
											aria-labelledby="dLabel" role="menu"
											style="width: 100%; height: 150px; overflow: scroll;">
											<c:forEach var="equipmentInfoList"
												items="${equipmentInfoList}">
												<li><a valueID="${equipmentInfoList.id}">${equipmentInfoList.name}</a></li>
											</c:forEach>
										</ul>
									</div>

								</div>
							</div>

							<!-- 添加年检日期-->
							<div class="form-group background">
								<label class="col-sm-3 control-label">年检日期</label>
								<div class="controls form-group">
									<input type="date" class="form-control" name="inspectionDate" />
								</div>
							</div>
							<!-- 添加年检内容 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">年检内容</label>
								<div class="controls form-group">
									<input type="text" class="form-control" name="content" />
								</div>
							</div>

							<div class="form-actions">
								<input type="submit" value="保存"
									class="btn btn-primary btn-submit" /> <input type="reset"
									value="重置" class="btn btn-danger btn-reset">
							</div>
						</form>
					</div>
				</div>
				</section>
			</div>
		</div>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 2.2.3 -->
	<script src="<%=path%>/assets/js/jquery-2.2.3.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="<%=path%>/assets/js/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<!-- Bootstrap 3.3.6 -->
	<script src="<%=path%>/assets/js/bootstrap.min.js"></script>
	<script src="<%=path%>/assets/js/bootstrap-select.js"></script>
	<!-- DataTables -->
	<script src="<%=path%>/assets/js/jquery.dataTables.min.js"></script>
	<script src="<%=path%>/assets/js/dataTables.bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script src="<%=path%>/assets/js/app.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<%=path%>/assets/js/demo.js"></script>
	<script src="<%=path%>/assets/js/bootstrapValidator.js"></script>
	<script src="<%=path%>/assets/js/icheck.js"></script>



	<script>
		$(document).ready(function() {
			$('input').iCheck({
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
		$("body").on('click', '.site-menu li', function(e) {
			var $target = $(e.target);
			$target.is('a') && $('#siteId').text($target.text());
			$('#site-input').attr('value', $target.attr("valueid"));

			//如果点击的是a标签
			if ($target.is('a')) {
				//更新新的专业列表
				var siteId = $target.attr("valueid");
				updateequipmentInfoBysiteId(siteId);
			}
		});
		$('body').on(
				'click',
				'.equipmentInfo-menu li',
				function(e) {
					var $target = $(e.target);
					$target.is('a')
							&& $('#equipmentInfoId').text($target.text());
					$('#equipmentInfo-input').attr('value',
							$target.attr("valueid"));
					//如果点击的是a标签
					if ($target.is('a')) {
						//更新新的专业列表
						var equipmentInfoId = $target.attr("valueid");
						updateClassByequipmentInfoId(equipmentInfoId);
					}
				});
		$('body').on('click', '.class-menu', function(e) {
			var $target = $(e.target);
			$target.is('a') && $('#classId').text($target.text());
			$('#class-input').attr('value', $target.attr("valueid"));
		});
		$('body').on('click', '#add-class-btn', function(e) {
			$('.class-menu').parent().hide();
			$('.new-class').show();
		});
		//添加Class,成功后刷新列表,并且隐藏输入框
		$('#add-class')
				.on(
						'click',
						function(e) {
							var name = document
									.getElementById('add-class-input').value;
							document.getElementById('add-class-input').value = '';
							var equipmentInfoId = document
									.getElementById('equipmentInfo-input').value;
							$
									.ajax({
										type : "POST",
										dataType : 'json',
										data : {
											equipmentInfoId : equipmentInfoId,
											name : name
										},
										url : "/class/add",
										complete : function(msg) {
											var message = eval("("
													+ msg.responseText + ")");
											if (message.length == 1) {
												var data = message.object;
												var classList = '${classList}';

												if (document.classFlag
														&& document.classFlag == 1) {
													var list = new Array();
													document.classFlag = 0;
												} else {
													var list;
													if (document.wclasslists) {
														list = document.wclasslists;
													} else {

														list = JSON
																.parse(classList);
													}
												}
												list.push(data);
												document.wclasslists = list;
												list
														.sort(keysrt('name',
																false));

												console.log(list);

												var pul = $('.class-menu')
														.parent();
												$('.class-menu').remove();

												var ul = $('<ul></ul>')
														.addClass(
																'dropdown-menu class-menu')
														.attr(
																'aria-labelledby',
																'dLabel')
														.attr('role', 'menu')
														.attr('style',
																'width: 100%;height:150px;overflow:scroll;');

												for (var i = 0; i < list.length; i++) {
													var li = $('<li></li>');
													$('<a></a>').attr(
															'valueID',
															list[i].id).html(
															list[i].name)
															.appendTo(li);
													li.appendTo(ul);
												}

												$('<li></li>').addClass(
														'divider').appendTo(ul);

												var li = $('<li></li>');

												var button = $(
														'<button></button>')
														.addClass('btn')
														.attr('type', 'button')
														.attr('id',
																'add-class-btn')
														.attr('style',
																'width: 100%');

												$('<i></i>').addClass(
														'fa fa-plus').appendTo(
														button);

												$('<span></span>').html('增加班级')
														.appendTo(button);
												button.appendTo(li);

												li.appendTo(ul);

												ul.appendTo(pul);
												$('.class-menu').parent()
														.show();
												$('.new-class').hide();

											} else {
												//alert("添加班级失败");
												$('.class-menu').parent()
														.show();
												$('.new-class').hide();
											}
										}
									});

						});
		$('body').on('click', '#add-site-btn', function(e) {
			$('.site-menu').parent().hide();
			$('.new-site').show();
		});
		$('#add-site')
				.on(
						'click',
						function(e) {
							var name = document
									.getElementById('add-site-input').value;
							document.getElementById('add-site-input').value = '';
							$
									.ajax({
										type : "POST",
										dataType : 'json',
										async : false,
										data : {
											name : name
										},
										url : "/site/add",

										complete : function(msg) {
											var message = eval("("
													+ msg.responseText + ")");
											if (message.length == 1) {
												var data = message.object;
												var siteList = '${siteList}';

												var list;

												if (document.wsiteLists) {
													list = document.wsiteLists;
												} else {
													list = JSON.parse(siteList);
												}
												list.push(data);
												document.wsiteLists = list;

												list
														.sort(keysrt('name',
																false));

												console.log(list);

												var pul = $('.site-menu')
														.parent();
												$('.site-menu').remove();

												var ul = $('<ul></ul>')
														.addClass(
																'dropdown-menu site-menu')
														.attr(
																'aria-labelledby',
																'dLabel')
														.attr('role', 'menu')
														.attr('style',
																'width: 100%;height:150px;overflow:scroll;');

												for (var i = 0; i < list.length; i++) {
													var li = $('<li></li>');
													$('<a></a>').attr(
															'valueID',
															list[i].id).html(
															list[i].name)
															.appendTo(li);
													li.appendTo(ul);
												}

												$('<li></li>').addClass(
														'divider').appendTo(ul);

												var li = $('<li></li>');

												var button = $(
														'<button></button>')
														.addClass('btn').attr(
																'type',
																'button').attr(
																'id',
																'add-site-btn')
														.attr('style',
																'width: 100%');

												$('<i></i>').addClass(
														'fa fa-plus').appendTo(
														button);

												$('<span></span>').html('增加学校')
														.appendTo(button);
												button.appendTo(li);

												li.appendTo(ul);

												ul.appendTo(pul);
												$('.site-menu').parent().show();
												$('.new-site').hide();

											} else {
												alert("添加学校失败");
												$('.site-menu').parent().show();
												$('.new-site').hide();
											}

										}

									});
						});
		$('body').on('click', '#add-equipmentInfo-btn', function(e) {
			$('.equipmentInfo-menu').parent().hide();
			$('.new-equipmentInfo').show();
		});
		$('#add-equipmentInfo')
				.on(
						'click',
						function(e) {

							var name = document
									.getElementById('add-equipmentInfo-input').value;
							var siteId = document.getElementById('site-input').value;
							document
									.getElementById('add-equipmentInfo-input').value = '';
							$
									.ajax({
										type : "POST",
										dataType : 'json',
										async : false,
										data : {
											siteId : siteId,
											name : name
										},
										url : "/equipmentInfo/add",

										complete : function(msg) {
											var message = eval("("
													+ msg.responseText + ")");
											if (message.length == 1) {
												var data = message.object;
												var equipmentInfoList = '${equipmentInfoList}';

												if (document.equipmentInfoFlag
														&& document.equipmentInfoFlag == 1) {
													var list = new Array();
													document.equipmentInfoFlag = 0;
												} else {
													var list;
													if (document.wequipmentInfoLists) {
														list = document.wequipmentInfoLists;
													} else {
														list = JSON
																.parse(equipmentInfoList);
													}
												}

												list.push(data);
												document.wequipmentInfoLists = list;
												list
														.sort(keysrt('name',
																false));

												console.log(list);

												var pul = $(
														'.equipmentInfo-menu')
														.parent();
												$('.equipmentInfo-menu')
														.remove();

												var ul = $('<ul></ul>')
														.addClass(
																'dropdown-menu equipmentInfo-menu')
														.attr(
																'aria-labelledby',
																'dLabel')
														.attr('role', 'menu')
														.attr('style',
																'width: 100%;height:150px;overflow:scroll;');

												for (var i = 0; i < list.length; i++) {
													var li = $('<li></li>');
													$('<a></a>').attr(
															'valueID',
															list[i].id).html(
															list[i].name)
															.appendTo(li);
													li.appendTo(ul);
												}

												$('<li></li>').addClass(
														'divider').appendTo(ul);

												var li = $('<li></li>');

												var button = $(
														'<button></button>')
														.addClass('btn')
														.attr('type', 'button')
														.attr('id',
																'add-equipmentInfo-btn')
														.attr('style',
																'width: 100%');

												$('<i></i>').addClass(
														'fa fa-plus').appendTo(
														button);

												$('<span></span>').html('增加专业')
														.appendTo(button);
												button.appendTo(li);

												li.appendTo(ul);

												ul.appendTo(pul);
												$('.equipmentInfo-menu')
														.parent().show();
												$('.new-equipmentInfo')
														.hide();

											} else {
												alert("添加专业失败");
												$('.equipmentInfo-menu')
														.parent().show();
												$('.new-equipmentInfo')
														.hide();
											}

										}

									});

						});
		function keysrt(key, desc) {
			return function(a, b) {
				return desc ? ~~(a[key] < b[key]) : ~~(a[key] > b[key]);
			}
		}

		function updateClassByequipmentInfoId(equipmentInfoId) {
			//更新新的班级列表
			var siteId = siteId;
			$
					.ajax({
						type : "POST",
						dataType : 'json',
						async : false,
						data : {
							id : equipmentInfoId
						},
						url : "/student/findByequipmentInfoId",
						complete : function(msg) {
							console.log(msg);
							var message = eval("(" + msg.responseText + ")");
							if (message.length > 0) {
								var list = message.object;
								console.log(list);
								if (list && list.length > 0) {
									//列表的初始值更改
									$('#classId').text(list[0].name);
									$('#classId').attr('value', list[0].id);
									$('#class-input').attr('value', list[0].id);
									var pul = $('.class-menu').parent();
									$('.class-menu').remove();
									var ul = $('<ul></ul>')
											.addClass(
													'dropdown-menu class-menu')
											.attr('aria-labelledby', 'dLabel')
											.attr('role', 'menu')
											.attr('style',
													'width: 100%;height:150px;overflow:scroll;');

									for (var i = 0; i < list.length; i++) {
										var li = $('<li></li>');
										$('<a></a>')
												.attr('valueID', list[i].id)
												.html(list[i].name)
												.appendTo(li);
										li.appendTo(ul);
									}
									$('<li></li>').addClass('divider')
											.appendTo(ul);

									var li = $('<li></li>');

									var button = $('<button></button>')
											.addClass('btn').attr('type',
													'button').attr('id',
													'add-class-btn').attr(
													'style', 'width: 100%');

									$('<i></i>').addClass('fa fa-plus')
											.appendTo(button);

									$('<span></span>').html('增加班级').appendTo(
											button);
									button.appendTo(li);

									li.appendTo(ul);

									ul.appendTo(pul);
								}
							} else {
								//	alert("暂无相关班级");
								document.classFlag = 1;
								$('.class-menu').parent().hide();
								$('.new-class').show();
							}
						}

					});

		}
	</script>
	<script>
		function updateequipmentInfoBysiteId(id) {
			$
					.ajax({
						type : "POST",
						dataType : 'json',
						async : false,
						data : {
							id : id
						},
						url : "/equipmentInspection/findBySiteId",
						complete : function(msg) {
							flag = 0;
							var message = eval("(" + msg.responseText + ")");
							if (message.length > 0) {
								var list = message.object;
								console.log(list);
								if (list && list.length > 0) {
									//列表的初始值更改
									$('#equipmentInfoId').text(list[0].name);
									$('#equipmentInfoId').attr('value',
											list[0].id);
									$('#equipmentInfo-input').attr('value',
											list[0].id);
									var pul = $('.equipmentInfo-menu')
											.parent();
									$('.equipmentInfo-menu').remove();
									var ul = $('<ul></ul>')
											.addClass(
													'dropdown-menu equipmentInfo-menu')
											.attr('aria-labelledby', 'dLabel')
											.attr('role', 'menu')
											.attr('style',
													'width: 100%;height:150px;overflow:scroll;');

									for (var i = 0; i < list.length; i++) {
										var li = $('<li></li>');
										$('<a></a>')
												.attr('valueID', list[i].id)
												.html(list[i].name)
												.appendTo(li);
										li.appendTo(ul);
									}

									/* 	$('<li></li>').addClass('divider')
												.appendTo(ul);

										var li = $('<li></li>');

										var button = $('<button></button>')
												.addClass('btn').attr('type',
														'button').attr('id',
														'add-equipmentInfo-btn')
												.attr('style', 'width: 100%');

										$('<i></i>').addClass('fa fa-plus')
												.appendTo(button);

											$('<span></span>').html('增加专业').appendTo(
													button);
											button.appendTo(li);
									 */
									li.appendTo(ul);

									ul.appendTo(pul);

									//	updateClassByequipmentInfoId(list[0].id);
								}
							} else {
								alert("暂无相关专业");
							//	document.classFlag = 1;
							/* 	document.equipmentInfoFlag = 1;
								$('.equipmentInfo-menu').parent().hide();
								$('.new-equipmentInfo').show(); */

								//alert("暂无相关班级");
								$('.class-menu').parent().hide();
								$('.new-class').show();

							}
						}
					});

		}
	</script>
</body>
</html>

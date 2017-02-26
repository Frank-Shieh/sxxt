<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
						<h3 class="panel-title">修改实训教师信息</h3>
					</div>
					<div id="breadcrumb">
						<a href="#" title="首页" class="tip-bottom"> <i
							class="icon-home"></i> Home
						</a> <a href="listClass.html">实训教师信息</a> <a href="#" class="current">修改实训教师信息</a>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post"
							action="/teachingTask/doEdit" id="registerForm">
							<input type="hidden" class="form-control" name="id"
								value="${teachingTask.id}" />
							<!-- 添加名字 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">名字</label>
								<div class="controls form-group">
									<input type="text" class="form-control" name="name"
										value="${teachingTask.name}" />
								</div>
							</div>
							<!-- 添加教务主管 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">教务主管</label>
								<div class="controls form-group">
									<div class="dropdown btn-group" style="width: 50%">
										<button id="dLabel" class="btn btn-default dropdown-toggle"
											type="button" data-toggle="dropdown" style="width: 100%">
											<span id="educationManagerId"
												value="${teachingTask.educationManager.id}">${teachingTask.educationManager.name}</span>
											<span class="caret"></span>
										</button>
										<input id='educationManager-input' name="educationManager.id"
											value="${teachingTask.educationManager.id}" hidden="true" />
										<ul class="dropdown-menu educationManager-menu"
											aria-labelledby="dLabel" role="menu"
											style="width: 100%; height: 150px; overflow: scroll;">
											<c:forEach var="educationManagerList"
												items="${educationManagerList}">
												<li><a valueID="${educationManagerList.id}">${educationManagerList.name}</a></li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</div>

							<!-- 添加发布日期 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">发布日期</label>
								<div class="controls form-group">
									<input type="date" class="form-control" name="releaseDate"
										value="<fmt:formatDate  pattern="yyyy-MM-dd"  value="${teachingTask.releaseDate}"  type="date" dateStyle="default"/>" />
								</div>
							</div>
							<!-- 添加开始日期 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">开始日期</label>
								<div class="controls form-group">
									<input type="date" class="form-control" name="startDate"
										value="<fmt:formatDate  pattern="yyyy-MM-dd"  value="${teachingTask.startDate}"  type="date" dateStyle="default"/>" />
								</div>
							</div>
							<!-- 添加结束日期 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">结束日期</label>
								<div class="controls form-group">
									<input type="date" class="form-control" name="endDate"
										value="<fmt:formatDate  pattern="yyyy-MM-dd"  value="${teachingTask.endDate}"  type="date" dateStyle="default"/>" />
								</div>
							</div>
							<!-- 添加内容 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">内容</label>
								<div class="controls form-group">
									<input type="text" class="form-control" name="content"
										value="${teachingTask.content}" />
								</div>
							</div>
							<div class="form-group background">
								<label class="col-sm-3 control-label">实训教师分配</label>
								<div class="controls form-group">
									<table>
										<c:forEach items="${trainningTeacherList}" var="s"
											varStatus="status">
											<tr>
												<td><input type="text" name="trainningTeacherCode"
													value="${s.trainningTeacher.code}" /></td>
												<td><button class="delete-btn">删除</button></td>
											</tr>
										</c:forEach>
										<tr>
											<td><input type="button" onclick="addRows();"
												value="添加一行" /></td>
										</tr>
									</table>

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
		var index = 0;
		function addRows() {
			/* var text = "<tr><td><input name=\"list["+index+"].lname\" /></td></tr>"; */
			var tr = $("<tr></tr>");
			var td = $("<td></td>");
			var input = $("<input/>").attr("type", "text").attr("name",
					"trainningTeacherCode").attr("placeholder", "实训教师编号").attr(
					"class", "form-control");

			var btn = $("<button></button>").html("删除").addClass('delete-btn');

			td.append(input);
			tr.append(td);
			$('<td></td>').append(btn).appendTo(tr);

			jQuery("table").append(tr);
			index += 1;
		}

		$('table').on('click', 'tr td .delete-btn', function(e) {
			e.preventDefault();
			var btn = $(this);
			$(this).parent('td').parent('tr').remove();

		});
	</script>


	<script>
		$(document).ready(function() {
			$('input').iCheck({
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
		$("body").on(
				'click',
				'.educationManager-menu li',
				function(e) {
					var $target = $(e.target);
					$target.is('a')
							&& $('#educationManagerId').text($target.text());
					$('#educationManager-input').attr('value',
							$target.attr("valueid"));

					//如果点击的是a标签
					if ($target.is('a')) {
						//更新新的专业列表
						var educationManagerId = $target.attr("valueid");
						updateMajorByeducationManagerId(educationManagerId);
					}
				});
		$('body').on('click', '.major-menu li', function(e) {
			var $target = $(e.target);
			$target.is('a') && $('#majorId').text($target.text());
			$('#major-input').attr('value', $target.attr("valueid"));
			//如果点击的是a标签
			if ($target.is('a')) {
				//更新新的专业列表
				var majorId = $target.attr("valueid");
				updateClassByMajorId(majorId);
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
							var majorId = document
									.getElementById('major-input').value;
							$
									.ajax({
										type : "POST",
										dataType : 'json',
										data : {
											majorId : majorId,
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

												$('<span></span>').html(
														'增加实训教师').appendTo(
														button);
												button.appendTo(li);

												li.appendTo(ul);

												ul.appendTo(pul);
												$('.class-menu').parent()
														.show();
												$('.new-class').hide();

											} else {
												//alert("添加实训教师失败");
												$('.class-menu').parent()
														.show();
												$('.new-class').hide();
											}
										}
									});

						});
		$('body').on('click', '#add-educationManager-btn', function(e) {
			$('.educationManager-menu').parent().hide();
			$('.new-educationManager').show();
		});
		$('#add-educationManager')
				.on(
						'click',
						function(e) {
							var name = document
									.getElementById('add-educationManager-input').value;
							document
									.getElementById('add-educationManager-input').value = '';
							$
									.ajax({
										type : "POST",
										dataType : 'json',
										async : false,
										data : {
											name : name
										},
										url : "/educationManager/add",

										complete : function(msg) {
											var message = eval("("
													+ msg.responseText + ")");
											if (message.length == 1) {
												var data = message.object;
												var educationManagerList = '${educationManagerList}';

												var list;

												if (document.weducationManagerLists) {
													list = document.weducationManagerLists;
												} else {
													list = JSON
															.parse(educationManagerList);
												}
												list.push(data);
												document.weducationManagerLists = list;

												list
														.sort(keysrt('name',
																false));

												console.log(list);

												var pul = $(
														'.educationManager-menu')
														.parent();
												$('.educationManager-menu')
														.remove();

												var ul = $('<ul></ul>')
														.addClass(
																'dropdown-menu educationManager-menu')
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
																'add-educationManager-btn')
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
												$('.educationManager-menu')
														.parent().show();
												$('.new-educationManager')
														.hide();

											} else {
												alert("添加学校失败");
												$('.educationManager-menu')
														.parent().show();
												$('.new-educationManager')
														.hide();
											}

										}

									});
						});
		$('body').on('click', '#add-major-btn', function(e) {
			$('.major-menu').parent().hide();
			$('.new-major').show();
		});
		$('#add-major')
				.on(
						'click',
						function(e) {

							var name = document
									.getElementById('add-major-input').value;
							var educationManagerId = document
									.getElementById('educationManager-input').value;
							document.getElementById('add-major-input').value = '';
							$
									.ajax({
										type : "POST",
										dataType : 'json',
										async : false,
										data : {
											educationManagerId : educationManagerId,
											name : name
										},
										url : "/major/add",

										complete : function(msg) {
											var message = eval("("
													+ msg.responseText + ")");
											if (message.length == 1) {
												var data = message.object;
												var majorList = '${majorList}';

												if (document.majorFlag
														&& document.majorFlag == 1) {
													var list = new Array();
													document.majorFlag = 0;
												} else {
													var list;
													if (document.wmajorLists) {
														list = document.wmajorLists;
													} else {
														list = JSON
																.parse(majorList);
													}
												}

												list.push(data);
												document.wmajorLists = list;
												list
														.sort(keysrt('name',
																false));

												console.log(list);

												var pul = $('.major-menu')
														.parent();
												$('.major-menu').remove();

												var ul = $('<ul></ul>')
														.addClass(
																'dropdown-menu major-menu')
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
																'add-major-btn')
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
												$('.major-menu').parent()
														.show();
												$('.new-major').hide();

											} else {
												alert("添加专业失败");
												$('.major-menu').parent()
														.show();
												$('.new-major').hide();
											}

										}

									});

						});
		function keysrt(key, desc) {
			return function(a, b) {
				return desc ? ~~(a[key] < b[key]) : ~~(a[key] > b[key]);
			}
		}

		function updateClassByMajorId(majorId) {
			//更新新的实训教师列表
			var educationManagerId = educationManagerId;
			$
					.ajax({
						type : "POST",
						dataType : 'json',
						async : false,
						data : {
							id : majorId
						},
						url : "/student/findByMajorId",
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

									$('<span></span>').html('增加实训教师').appendTo(
											button);
									button.appendTo(li);

									li.appendTo(ul);

									ul.appendTo(pul);
								}
							} else {
								//	alert("暂无相关实训教师");
								document.classFlag = 1;
								$('.class-menu').parent().hide();
								$('.new-class').show();
							}
						}

					});

		}
	</script>
	<script>
		function updateMajorByeducationManagerId(id) {
			$
					.ajax({
						type : "POST",
						dataType : 'json',
						async : false,
						data : {
							id : id
						},
						url : "/student/findByeducationManagerId",
						complete : function(msg) {
							flag = 0;
							var message = eval("(" + msg.responseText + ")");
							if (message.length > 0) {
								var list = message.object;
								console.log(list);
								if (list && list.length > 0) {
									//列表的初始值更改
									$('#majorId').text(list[0].name);
									$('#majorId').attr('value', list[0].id);
									$('#major-input').attr('value', list[0].id);
									var pul = $('.major-menu').parent();
									$('.major-menu').remove();
									var ul = $('<ul></ul>')
											.addClass(
													'dropdown-menu major-menu')
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
													'add-major-btn').attr(
													'style', 'width: 100%');

									$('<i></i>').addClass('fa fa-plus')
											.appendTo(button);

									$('<span></span>').html('增加专业').appendTo(
											button);
									button.appendTo(li);

									li.appendTo(ul);

									ul.appendTo(pul);

									updateClassByMajorId(list[0].id);
								}
							} else {
								alert("暂无相关专业");
								document.classFlag = 1;
								document.majorFlag = 1;
								$('.major-menu').parent().hide();
								$('.new-major').show();

								//alert("暂无相关实训教师");
								$('.class-menu').parent().hide();
								$('.new-class').show();

							}
						}
					});

		}
	</script>
</body>
</html>

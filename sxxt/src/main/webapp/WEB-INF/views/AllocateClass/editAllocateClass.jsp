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
						<h3 class="panel-title">修改班级教师分配信息</h3>
					</div>
					<div id="breadcrumb">
						<a href="#" title="首页" class="tip-bottom"> <i
							class="icon-home"></i> Home
						</a> <a href="listClass.html">班级教师分配信息</a> <a href="#" class="current">修改班级教师分配信息</a>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post"
							action="/allocateClass/doEdit" id="registerForm">

							<!-- 添加学校 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">学校名称</label>
								<div class="controls form-group">
									<div class="dropdown btn-group" style="width: 50%">
										<button id="dLabel" class="btn btn-default dropdown-toggle"
											type="button" data-toggle="dropdown" style="width: 100%">
											<span id="schoolId" value="${result.classId.major.school.id}">${result.classId.major.school.name}</span>
											<span class="caret"></span>
										</button>
										<input id='school-input' name="school.id"
											value="${result.classId.major.school.id}" hidden="true" />
										<ul class="dropdown-menu school-menu" aria-labelledby="dLabel"
											role="menu"
											style="width: 100%; height: 150px; overflow: scroll;">
											<c:forEach var="schoolList" items="${schoolList}">
												<li><a valueID="${schoolList.id}">${schoolList.name}</a></li>
											</c:forEach>
										</ul>
									</div>

								</div>
							</div>
							<!-- 添加专业 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">专业名称</label>
								<div class="controls form-group">
									<div class="dropdown btn-group" style="width: 50%">
										<button id="dLabel" class="btn btn-default dropdown-toggle"
											type="button" data-toggle="dropdown" style="width: 100%">
											<span id="majorId" value="${result.classId.major.id}">${result.classId.major.name}</span>
											<span class="caret"></span>
										</button>
										<input id='major-input' name="major.id"
											value="${result.classId.major.id}" hidden="true" />
										<ul class="dropdown-menu major-menu" aria-labelledby="dLabel"
											role="menu"
											style="width: 100%; height: 150px; overflow: scroll;">
											<c:forEach var="majorList" items="${majorList}">
												<li><a valueID="${majorList.id}">${majorList.name}</a></li>
											</c:forEach>
										</ul>
									</div>

								</div>
							</div>
							<!-- 添加班级 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">班级名称</label>
								<div class="controls form-group">
									<div class="dropdown btn-group" style="width: 50%">
										<button id="dLabel" class="btn btn-default dropdown-toggle"
											type="button" data-toggle="dropdown" style="width: 100%">
											<span id="classId" value="${result.classId.id}">${result.classId.name}</span>
											<span class="caret"></span>
										</button>
										<input id='class-input' name="classId"
											value="${result.classId.id}" hidden="true" />
										<ul class="dropdown-menu class-menu" aria-labelledby="dLabel"
											role="menu"
											style="width: 100%; height: 150px; overflow: scroll;">
											<c:forEach var="classList" items="${classList}">
												<li><a valueID="${classList.id}">${classList.name}</a></li>
											</c:forEach>
										</ul>
									</div>

								</div>
							</div>

							<div class="form-group background">
								<label class="col-sm-3 control-label">实训教师分配</label>
								<div class="controls form-group">
									<table>
										<c:forEach items="${teacherList}" var="s" varStatus="status">
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

	<script type="text/javascript">
		$(document).ready(function() {
			$('#registerForm').bootstrapValidator({
				message : 'This value is not valid',
				feedbackIcons : {
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				fields : {
					age : {
						validators : {
							numeric : {
								message : '年龄只能输入数字'
							},
							notEmpty : {
								message : '年龄不能为空'
							},
							stringLength : {
								min : 2,
								max : 3,
								message : '年龄至少为两位且少于四位'
							}
						}
					},
					studentPhone : {
						message : '电话长度需为11位',
						validators : {
							notEmpty : {
								message : '联系电话不能为空'
							},
							stringLength : {
								min : 11,
								max : 11,
								message : '电话长度需为11位'
							},
							numeric : {
								message : '请输入正确的电话号码'
							}
						}
					},
					parentPhone : {
						message : '电话长度需为11位',
						validators : {
							notEmpty : {
								message : '父母电话不能为空'
							},
							stringLength : {
								min : 11,
								max : 11,
								message : '电话长度需为11位'
							},
							numeric : {
								message : '请输入正确的电话号码'
							}
						}
					}

				}
			});
		});
	</script>
	<script>
		$(document).ready(function() {
			$('input').iCheck({
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
		$("body").on('click', '.school-menu li', function(e) {
			var $target = $(e.target);
			$target.is('a') && $('#schoolId').text($target.text());
			$('#school-input').attr('value', $target.attr("valueid"));

			//如果点击的是a标签
			if ($target.is('a')) {
				//更新新的专业列表
				var schoolId = $target.attr("valueid");
				updateMajorBySchoolId(schoolId);
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

												$('<span></span>').html('增加班级')
														.appendTo(button);
												button.appendTo(li);

												li.appendTo(ul);

												ul.appendTo(pul);
												$('.class-menu').parent()
														.show();
												$('.new-class').hide();

											} else {
												alert("添加班级失败");
												$('.class-menu').parent()
														.show();
												$('.new-class').hide();
											}
										}
									});

						});
		$('body').on('click', '#add-school-btn', function(e) {
			$('.school-menu').parent().hide();
			$('.new-school').show();
		});
		$('#add-school')
				.on(
						'click',
						function(e) {
							var name = document
									.getElementById('add-school-input').value;
							document.getElementById('add-school-input').value = '';
							$
									.ajax({
										type : "POST",
										dataType : 'json',
										async : false,
										data : {
											name : name
										},
										url : "/school/add",

										complete : function(msg) {
											var message = eval("("
													+ msg.responseText + ")");
											if (message.length == 1) {
												var data = message.object;
												var schoolList = '${schoolList}';

												var list;

												if (document.wschoolLists) {
													list = document.wschoolLists;
												} else {
													list = JSON
															.parse(schoolList);
												}
												list.push(data);
												document.wschoolLists = list;

												list
														.sort(keysrt('name',
																false));

												console.log(list);

												var pul = $('.school-menu')
														.parent();
												$('.school-menu').remove();

												var ul = $('<ul></ul>')
														.addClass(
																'dropdown-menu school-menu')
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
																'add-school-btn')
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
												$('.school-menu').parent()
														.show();
												$('.new-school').hide();

											} else {
												alert("添加学校失败");
												$('.school-menu').parent()
														.show();
												$('.new-school').hide();
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
							var schoolId = document
									.getElementById('school-input').value;
							document.getElementById('add-major-input').value = '';
							$
									.ajax({
										type : "POST",
										dataType : 'json',
										async : false,
										data : {
											schoolId : schoolId,
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
			//更新新的班级列表
			var schoolId = schoolId;
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

									$('<span></span>').html('增加班级').appendTo(
											button);
									button.appendTo(li);

									li.appendTo(ul);

									ul.appendTo(pul);
									pul.show();
								}
							} else {
								alert("暂无相关班级");
								document.classFlag = 1;
								$('.class-menu').parent().hide();
								$('.new-class').show();
							}
						}

					});

		}
	</script>
	<script>
		function updateMajorBySchoolId(id) {
			$
					.ajax({
						type : "POST",
						dataType : 'json',
						async : false,
						data : {
							id : id
						},
						url : "/student/findBySchoolId",
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
									pul.show();
								}
							} else {
								alert("暂无相关专业");
								document.classFlag = 1;
								document.majorFlag = 1;
								$('.major-menu').parent().hide();
								$('.new-major').show();

								alert("暂无相关班级");
								$('.class-menu').parent().hide();
								$('.new-class').show();

							}
						}
					});

		}
	</script>
</body>
</html>

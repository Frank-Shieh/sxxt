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

		<jsp:include page="header.jsp"></jsp:include>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->

			<div class="content-wrapper">
				<section class="content">

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">添加单个班级人员信息</h3>
					</div>
					<div id="breadcrumb">
						<a href="#" title="首页" class="tip-bottom"> <i
							class="icon-home"></i> Home
						</a> <a href="listClass.html">班级人员信息</a> <a href="#" class="current">添加单个班级人员信息</a>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post" action="/user/doAdd"
							id="registerForm">
							<!-- 添加学号 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">学号</label>
								<div class="controls form-group">
									<input type="text" class="form-control" name="code" />
								</div>
							</div>
							<!-- 添加名字 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">名字</label>
								<div class="controls form-group">
									<input type="text" class="form-control" name="name" />
								</div>
							</div>
							<!-- 添加出生年月日 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">出生年月日</label>
								<div class="controls form-group">
									<input type="date" class="form-control" name="birthDate" />
								</div>
							</div>
							<!-- 添加性别 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">性别</label>
								<div class="controls form-group">
									<input type="radio" name="sex" value="1" checked> <label
										class="radio-label">男</label> <input type="radio" name="sex"
										value="0"> <label class="radio-label">女</label>
								</div>
							</div>
							<!-- 添加年龄 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">年龄</label>
								<div class="controls form-group">
									<input type="text" class="form-control" name="age" />
								</div>
							</div>
							<!-- 添加学校 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">学校名称</label>
								<div class="controls form-group">
									<div class="dropdown btn-group" style="width: 50%">
										<button id="dLabel" class="btn btn-default dropdown-toggle"
											type="button" data-toggle="dropdown" style="width: 100%">
											<span id="schoolId" value="${schoolList.get(0).id}">${schoolList.get(0).name}</span>
											<span class="caret"></span>
										</button>
										<input id='school-input' name="school"
											value="${schoolList.get(0).id}" hidden="true" />
										<ul class="dropdown-menu school-menu" aria-labelledby="dLabel"
											role="menu"
											style="width: 100%; height: 150px; overflow: scroll;">
											<c:forEach var="schoolList" items="${schoolList}">
												<li><a valueID="${schoolList.id}">${schoolList.name}</a></li>
											</c:forEach>
											<li class="divider"></li>
											<li>
												<button type="button" class="btn" style="width: 100%"
													id="add-school-btn">
													<i class="fa fa-plus"></i> <span>增加学校</span>
												</button>
											</li>
										</ul>
									</div>
									<div hidden="true" class="new-school">
										<input type="text" class="form-control add-input"
											name="schoolName" />
										<button type="button" class="btn btn-primary" id="add-school">
											<span>保存</span>
										</button>
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
											<span id="majorId" value="${majorList.get(0).id}">${majorList.get(0).name}</span>
											<span class="caret"></span>
										</button>
										<input id='major-input' name="major.id"
											value="${majorList.get(0).id}" hidden="true" />
										<ul class="dropdown-menu major-menu" aria-labelledby="dLabel"
											role="menu"
											style="width: 100%; height: 150px; overflow: scroll;">
											<c:forEach var="majorList" items="${majorList}">
												<li><a valueID="${majorList.id}">${majorList.name}</a></li>
											</c:forEach>
											<li class="divider"></li>
											<li>
												<button type="button" class="btn" style="width: 100%"
													id="add-major-btn">
													<i class="fa fa-plus"></i> <span>增加专业</span>
												</button>
											</li>
										</ul>
									</div>
									<div hidden="true" class="new-major">
										<input type="text" class="form-control add-input"
											name="majorName" />
										<button type="button" class="btn btn-primary" id="add-major">
											<span>保存</span>
										</button>
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
											<span id="classId" value="${classList.get(0).id}">${classList.get(0).name}</span>
											<span class="caret"></span>
										</button>
										<input id='class-input' name="classId.id"
											value="${classList.get(0).id}" hidden="true" />
										<ul class="dropdown-menu class-menu" aria-labelledby="dLabel"
											role="menu"
											style="width: 100%; height: 150px; overflow: scroll;">
											<c:forEach var="classList" items="${classList}">
												<li><a valueID="${classList.id}">${classList.name}</a></li>
											</c:forEach>
											<li class="divider"></li>
											<li>
												<button type="button" class="btn" style="width: 100%"
													id="add-class-btn">
													<i class="fa fa-plus"></i> <span>增加班级</span>
												</button>
											</li>
										</ul>
									</div>
									<div hidden="true" class="new-class">
										<input type="text" class="form-control add-input"
											name="className" id="add-class-input" />
										<button type="button" class="btn btn-primary" id="add-class">
											<span>保存</span>
										</button>
									</div>

								</div>
							</div>
							<!-- 添加联系电话 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">联系电话</label>
								<div class="controls form-group">
									<input type="text" class="form-control" name="studentPhone"
										maxlength="13" />
								</div>
							</div>
							<!-- 添加家庭地址 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">家庭地址</label>
								<div class="controls form-group">
									<input type="text" class="form-control" name="familiyAddress" />
								</div>
							</div>
							<!-- 添加父母电话 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">父母电话</label>
								<div class="controls form-group">
									<input type="text" class="form-control" name="parentPhone"
										maxlength="13" />
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
		$(function() {
			$("#example1").dataTable({
				"sPaginationType" : "full_numbers",
				"oLanguage" : {
					"sLengthMenu" : "每页显示 _MENU_ 条记录",
					"sZeroRecords" : "抱歉， 没有找到",
					"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
					"sInfoEmpty" : "没有数据",
					"sInfoFiltered" : "(从 _MAX_ 条数据中检索)",
					"sZeroRecords" : "没有检索到数据",
					"sSearch" : "搜索:",
					"oPaginate" : {
						"sFirst" : "首页",
						"sPrevious" : "前一页",
						"sNext" : "后一页",
						"sLast" : "尾页"
					}

				}
			});
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
						message : '电话长度需为13位',
						validators : {
							notEmpty : {
								message : '联系电话不能为空'
							},
							stringLength : {
								min : 13,
								max : 13,
								message : '电话长度需为13位'
							},
							numeric : {
								message : '请输入正确的电话号码'
							}
						}
					},
					parentPhone : {
						message : '电话长度需为13位',
						validators : {
							notEmpty : {
								message : '父母电话不能为空'
							},
							stringLength : {
								min : 13,
								max : 13,
								message : '电话长度需为13位'
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

		$('.school-menu')
				.on(
						'click',
						function(e) {
							var $target = $(e.target);
							$target.is('a')
									&& $('#schoolId').text($target.text());
							$('#school-input').attr('value',
									$target.attr("valueid"));
							//更新新的专业列表
							var schoolId = $target.attr("valueid");
							$
									.ajax({
										type : "POST",
										dataType : 'json',
										data : {
											id : schoolId
										},
										url : "/student/findBySchoolId",
										complete : function(msg) {
											var list = eval("("
													+ msg.responseText + ")");
											console.log(list);
											if (list && list.length > 0) {
												//列表的初始值更改
												$('#majorId')
														.text(list[0].name);
												$('#majorId').attr('value',
														list[0].id);
												$('#major-input').attr('value',
														list[0].id);
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
											}
										}

									});

							//更新新的班级列表
							//为了处理异步问题,所以传的是学校的id,而不是更新后的专业的ID
							var schoolId = $target.attr("valueid");
							$
									.ajax({
										type : "POST",
										dataType : 'json',
										data : {
											id : schoolId
										},
										url : "/student/findByMajorId",
										complete : function(msg) {
											var list = eval("("
													+ msg.responseText + ")");
											console.log(list);
											if (list && list.length > 0) {
												//列表的初始值更改
												$('#classId')
														.text(list[0].name);
												$('#classId').attr('value',
														list[0].id);
												$('#class-input').attr('value',
														list[0].id);
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
											}
										}

									});

						});
		$('*').on('click', '.major-menu', function(e) {
			var $target = $(e.target);
			$target.is('a') && $('#majorId').text($target.text());
			$('#major-input').attr('value', $target.attr("valueid"));
		});
		$('*').on('click', '.class-menu', function(e) {
			var $target = $(e.target);
			$target.is('a') && $('#classId').text($target.text());
			$('#class-input').attr('value', $target.attr("valueid"));
		});
		$('*').on('click', '#add-class-btn', function(e) {
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
							$
									.ajax({
										type : "POST",
										dataType : 'json',
										data : {
											name : name
										},
										url : "/class/add",
										complete : function(msg) {
											var data = eval("("
													+ msg.responseText + ")");
											var classList = '${classList}';
											var list = JSON.parse(classList);

											list.push(data);
											list.sort(keysrt('name', false));

											console.log(list);

											var pul = $('.class-menu').parent();
											$('.class-menu').remove();

											var ul = $('<ul></ul>')
													.addClass(
															'dropdown-menu class-menu')
													.attr('aria-labelledby',
															'dLabel')
													.attr('role', 'menu')
													.attr('style',
															'width: 100%;height:150px;overflow:scroll;');

											for (var i = 0; i < list.length; i++) {
												var li = $('<li></li>');
												$('<a></a>').attr('valueID',
														list[i].id).html(
														list[i].name).appendTo(
														li);
												li.appendTo(ul);
											}

											$('<li></li>').addClass('divider')
													.appendTo(ul);

											var li = $('<li></li>');

											var button = $('<button></button>')
													.addClass('btn')
													.attr('type', 'button')
													.attr('id', 'add-class-btn')
													.attr('style',
															'width: 100%');

											$('<i></i>').addClass('fa fa-plus')
													.appendTo(button);

											$('<span></span>').html('增加班级')
													.appendTo(button);
											button.appendTo(li);

											li.appendTo(ul);

											ul.appendTo(pul);
											$('.class-menu').parent().show();
											$('.new-class').hide();

										}

									});

						});
		$('*').on('click', '#add-school-btn', function(e) {
			$('.school-menu').parent().hide();
			$('.new-school').show();
		});
		$('#add-school').on('click', function(e) {
			$('.school-menu').parent().show();
			$('.new-school').hide();
		});
		$('*').on('click', '#add-major-btn', function(e) {
			$('.major-menu').parent().hide();
			$('.new-major').show();
		});
		$('#add-major').on('click', function(e) {
			$('.major-menu').parent().show();
			$('.new-major').hide();
		});
		function keysrt(key, desc) {
			return function(a, b) {
				return desc ? ~~(a[key] < b[key]) : ~~(a[key] > b[key]);
			}
		}
	</script>

</body>
</html>

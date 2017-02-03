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
						<h3 class="panel-title">添加报告与总结信息</h3>
					</div>
					<div id="breadcrumb">
						<a href="#" title="首页" class="tip-bottom"> <i
							class="icon-home"></i> Home
						</a> <a href="listClass.html">报告与总结信息</a> <a href="#" class="current">添加报告与总结信息</a>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post"
							action="/reportAndSummary/doAdd" id="registerForm">
							<!-- 添加自我评价 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">自我评价</label>
								<div class="controls form-group">
									<input type="text" class="form-control" name="selfComment" />
								</div>
							</div>
							<!-- 添加撰写日期 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">撰写日期</label>
								<div class="controls form-group">
									<input type="date" class="form-control" name="writeDate" />
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
										<input id='school-input' 
											value="${schoolList.get(0).id}" hidden="true" />
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
											<span id="majorId" value="${majorList.get(0).id}">${majorList.get(0).name}</span>
											<span class="caret"></span>
										</button>
										<input id='major-input' 
											value="${majorList.get(0).id}" hidden="true" />
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
											<span id="classId" value="${classList.get(0).id}">${classList.get(0).name}</span>
											<span class="caret"></span>
										</button>
										<input id='class-input' 
											value="${classList.get(0).id}" hidden="true" />
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
							<!-- 添加学生 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">学生名称</label>
								<div class="controls form-group">
									<div class="dropdown btn-group" style="width: 50%">
										<button id="dLabel" class="btn btn-default dropdown-toggle"
											type="button" data-toggle="dropdown" style="width: 100%">
											<span id="studentId" value="${studentList.get(0).id}">${studentList.get(0).name}</span>
											<span class="caret"></span>
										</button>
										<input id='student-input' name="student.id"
											value="${studentList.get(0).id}" hidden="true" />
										<ul class="dropdown-menu student-menu"
											aria-labelledby="dLabel" role="menu"
											style="width: 100%; height: 150px; overflow: scroll;">
											<c:forEach var="studentList" items="${studentList}">
												<li><a valueID="${studentList.id}">${studentList.name}</a></li>
											</c:forEach>
										</ul>
									</div>

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
			//如果点击的是a标签
			if ($target.is('a')) {
				//更新新的专业列表
				var classId = $target.attr("valueid");
				updateStudentByClassId(classId);
			}
		});
		$('body').on('click', '.student-menu', function(e) {
			var $target = $(e.target);
			$target.is('a') && $('#studentId').text($target.text());
			$('#student-input').attr('value', $target.attr("valueid"));
			//如果点击的是a标签
			if ($target.is('a')) {
				//更新新的专业列表
				var classId = $target.attr("valueid");
			}
		});

		function keysrt(key, desc) {
			return function(a, b) {
				return desc ? ~~(a[key] < b[key]) : ~~(a[key] > b[key]);
			}
		}
	</script>

	<script>
		function updateStudentByClassId(id) {
			$
					.ajax({
						type : "POST",
						dataType : 'json',
						async : false,
						data : {
							id : id
						},
						url : "/student/findByClassId",
						complete : function(msg) {
							console.log(msg);
							var message = eval("(" + msg.responseText + ")");
							if (message.length > 0) {
								var list = message.object;
								console.log(list);
								if (list && list.length > 0) {
									//列表的初始值更改
									$('#studentId').text(list[0].name);
									$('#studentId').attr('value', list[0].id);
									$('#student-input').attr('value',
											list[0].id);
									var pul = $('.student-menu').parent();
									$('.student-menu').remove();
									var ul = $('<ul></ul>')
											.addClass(
													'dropdown-menu student-menu')
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


									ul.appendTo(pul);
									pul.show();
								}
							} else {

								alert("暂无相关学生");
								$('.student-menu').parent().hide();
								//$('.new-class').show();
							}
						}
					});
		}
	</script>

	<script>
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

									ul.appendTo(pul);
									updateStudentByClassId(list[0].id);
								}
							} else {
								alert("暂无相关班级");
								document.classFlag = 1;
								$('.class-menu').parent().hide();
								$('.new-class').show();

								alert("暂无相关学生");
								$('.student-menu').parent().hide();
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

									ul.appendTo(pul);

									updateClassByMajorId(list[0].id);
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

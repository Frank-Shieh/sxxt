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
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%=path%>/assets/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="<%=path%>/assets/css/_all-skins.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="<%=path%>/assets/css/dataTables.bootstrap.css">
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

.table td {
	text-align: center;
	vertical-align: middle;
}

.table th {
	text-align: center;
	vertical-align: middle;
}
</style>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<jsp:include page="${myheader}"></jsp:include>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->

			<div class="content-wrapper">
				<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">教师评价信息</h3>
							</div>
							<div class="panel-body">
								<table id="tp-result-table"
									class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>教师名称</th>
											<th>教师得分</th>
											<th>查看</th>
											<th>修改</th>
											<th>删除</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="result" items="${result}">
											<tr>
												<td>${result.trainningTeacher.name}</td>
												<td>${result.totalScore}</td>
												<td><a class="btn btn-info"
													href="/teacherComment/viewByStudent?id=${result.id}">查看</a></td>
												<td><a href="/teacherComment/edit?id=${result.id}"
													class="btn btn-primary">修改</a></td>
												<td><a class="btn btn-danger"
													onclick="delTeacherComment(${result.id},${user.id})">删除</a></td>
											</tr>
										</c:forEach>
									</tbody>

								</table>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row --> </section>
			</div>
		</div>
	</div>
	<!-- ./wrapper -->
	<!-- Modal -->
	<div id="error-msg" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">操作错误提示信息</h3>
		</div>
		<div class="modal-body">
			<p>${errorMsg}</p>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		</div>
	</div>
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
	<!-- DataTables -->
	<script src="<%=path%>/assets/js/jquery.dataTables.min.js"></script>
	<script src="<%=path%>/assets/js/dataTables.bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script src="<%=path%>/assets/js/app.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<%=path%>/assets/js/demo.js"></script>
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
		function delTeacherComment(id,studentId) {
			var result = confirm("确定删除该班级吗?");
			if (result) {
				console.log(result);
				var url = '/teacherComment/delete/' + id+'/'+studentId;
				$.get(url, function(data) {
					console.log('deleted.');
					window.location.href = '/teacherComment/listByStudent?id='+studentId;
				});
			}
		}
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			var msg = "${errorMsg}";
			console.log(msg);
			if (msg.length > 0) {
				$('#error-msg').modal({
					keyboard : false
				});
			}
		});
		$(document).ready(function() {
			$('#tp-result-table').DataTable();
		});
	</script>
</body>
</html>

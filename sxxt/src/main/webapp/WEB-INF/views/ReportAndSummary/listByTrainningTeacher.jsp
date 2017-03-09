<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

		<%-- <jsp:include page="header.jsp"></jsp:include> --%>
	<jsp:include page="${myheader}"></jsp:include>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->

			<div class="content-wrapper">
				<section class="content">
				<div class="row">
					<div class="col-xs-12">

						<c:if test="${fn:length(errorMsg) gt 0}">
							<div class="bs-example bs-example-standalone">
								<div class="alert alert-danger alert-dismissible fade in"
									role="alert">
									<button type="button" class="close" data-dismiss="alert">
										<span aria-hidden="true">×</span><span class="sr-only">Close</span>
									</button>
									<h4>Oh snap! You got an error!</h4>
									<p>该班级暂无相关的报告与总结信息。请先添加报告与总结信息</p>
									<p>
										<a class="btn btn-primary" href="/student/add"
											style="text-decoration: none;">添加报告与总结信息</a>
									</p>
								</div>
							</div>
						</c:if>

						<!-- 如果查找出来的数据存在则显示出来，否则不显示 -->
						<c:if test="${fn:length(result) gt 0}">
							<div class="panel panel-info">
								<div class="panel-heading">
									<h3 class="panel-title">报告与总结列表信息</h3>
								</div>
								<div class="panel-body">
									<table id="example1" class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>学生学号</th>
												<th>学生名称</th>
												<th>撰写日期</th>
												<th>实训教师</th>
												<th>查看</th>
												<th>评价</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="result" items="${result}">
												<tr>
													<td>${result.student.code}</td>
													<td>${result.student.name}</td>
													<td><fmt:formatDate value="${result.writeDate}"
															type="date" dateStyle="default" /></td>
													<td>${result.trainningTeacher.name}</td>
													<td><a class="btn btn-info"
														href="/reportAndSummary/view?id=${result.id}">查看</a></td>
												<%-- 	<td><a href="/reportAndSummary/edit?id=${result.id}"
														class="btn btn-primary">修改</a></td> --%>
													<%-- <td><a class="btn btn-danger"
														onclick="delReportAndSummary(${result.id})">删除</a></td> --%>
												<td><a href="/reportAndSummary/comment?id=${result.id}"
														class="btn btn-danger">评价</a></td>
												</tr>
											</c:forEach>

										</tbody>

									</table>
								</div>
								<!-- /.box-body -->
							</div>
						</c:if>
						<!-- /.box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row --> </section>
			</div>
		</div>
	</div>
	<!-- ./wrapper -->
	<!-- 警告提示 -->


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
	function delReportAndSummary(id) {
		var result = confirm("确定删除编号:"+ id +"吗?");
		if (result) {
			console.log(result);
			var url = '/reportAndSummary/delete?id='+id;
			$.get(url, function(data) {
				console.log('deleted.');
			 	window.location.href='/reportAndSummary/list'; 
			});
		}
	}
</script>
	<script type="text/javascript">
		
		$(document).ready(function() {
			$('#tp-result-table').DataTable();
			});
	</script>
</body>
</html>

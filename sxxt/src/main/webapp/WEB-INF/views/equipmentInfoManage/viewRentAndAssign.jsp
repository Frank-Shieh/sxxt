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

.form-horizontal .form-group {
	margin: 0px;
}

.form-horizontal .background {
	background: none repeat scroll 0 0 #F9F9F9;
}

.form-horizontal .control-label {
	padding-top: 15px;
	width: 45%;
}

.form-horizontal span {
	line-height: 30px;
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
						<h3 class="panel-title">查看场地设备信息</h3>
					</div>
					<div id="breadcrumb">
						<a href="#" title="首页" class="tip-bottom"> <i
							class="icon-home"></i> Home
						</a> <a href="listClass.html">设备信息</a> <a href="#" class="current">查看设备信息</a>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post"
							action="/equipmentInfo/listRentAndAssign" id="registerForm">
							<!-- 查看所属场地 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">所属场地</label>
								<div class="controls form-group">
									<span>${result.site.classroomCode}</span>
								</div>
							</div>
							<!-- 查看设备名称 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">设备名称</label>
								<div class="controls form-group">
									<span>${result.name}</span>
								</div>
							</div>
							<!-- 查看设备数量 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">设备数量 </label>
								<div class="controls form-group">
									<span>${result.num}</span>
								</div>
							</div>
							<!-- 查看购买日期 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">购买日期 </label>
								<div class="controls form-group">
									<span><fmt:formatDate value="${result.buyDate}"
											type="date" dateStyle="default" /></span>
								</div>
							</div>
							<!-- 查看所属公司 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">出产日期</label>
								<div class="controls form-group">
									<span><fmt:formatDate value="${result.produceDate}"
											type="date" dateStyle="default" /></span>
								</div>
							</div>
							<!-- 查看场地管理员 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">下次年检日期</label>
								<div class="controls form-group">
									<span><fmt:formatDate value="${result.inspectionDate}"
											type="date" dateStyle="default" /></span>
								</div>
							</div>
							<!-- 查看设备年检期限（以年为单位） -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">设备年检期限（以年为单位） </label>
								<div class="controls form-group">
									<span>${result.inspectionTime}</span>
								</div>
							</div>
							<div class="form-group background">
								<label class="col-sm-3 control-label">设备管理员</label>
								<div class="controls form-group">
									<span>${result.equipmentManager.name}</span>
								</div>
							</div>
							<!-- 查看状态 -->
							<div class="form-group background">
								<label class="col-sm-3 control-label">状态</label>
								<div class="controls form-group">
									<c:if test="${result.state==1}">
										<span>可用</span>
									</c:if>
									<c:if test="${result.state==2}">
										<span>自身已用</span>
									</c:if>
									<c:if test="${result.state==3}">
										<span>借用</span>
									</c:if>
									<c:if test="${result.state==4}">
										<span>已出租</span>
									</c:if>
								</div>
							</div>

							<div class="form-actions">
								<input type="submit" value="返回"
									class="btn btn-primary btn-submit" />
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


</body>
</html>

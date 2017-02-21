<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords"
	content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="<%=path%>/assets/css/login.css" rel='stylesheet'
	type='text/css' />
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="<%=path%>/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=path%>/assets/css/bootstrap-select.css">
<script src="<%=path%>/assets/js/jquery-2.2.3.min.js"></script>
</head>

<style type="text/css">
.password{
margin-bottom : 0;
}
</style>
<body>
	<script>
		$(document).ready(function(c) {
			$('.close').on('click', function(c) {
				$('.login-form').fadeOut('slow', function(c) {
					$('.login-form').remove();
				});
			});
		});
	</script>
	<!--SIGN UP-->
	<h1>klasikal Login Form</h1>
	<div class="login-form">
		<div class="close"></div>
		<div class="head-info">
			<label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
				class="lbl-3"> </label>
		</div>
		<div class="clear"></div>
		<div class="avtar">
			<img src="<%=path%>/assets/img/avtar.png" />
		</div>
		<form class="form-horizontal" method="post" action="/doLogin"
			id="registerForm">

			<input type="text" class="text" name="code" value="UserCode">
			<div class="key">
				<input class="password" type="password" name="password" value="Password">
			</div>
			<div class="form-group">
				<label class=" control-label"><font color=#9199aa>身份选择</font></label>
				<div class="controls form-group">
					<div class="dropdown btn-group" style="width: 50%">
						<button id="dLabel" class="btn btn-default dropdown-toggle"
							type="button" data-toggle="dropdown" style="width: 100%">
							<span id="schoolId" value="1">${roleList.get(0)}</span> <span
								class="caret"></span>
						</button>
						<input id='role-input' name="role" value="1" hidden="true" />
						<ul class="dropdown-menu role-menu" aria-labelledby="dLabel"
							role="menu" style="width: 100%; height: 150px; overflow: scroll;">
							<c:set var="index" value="0" />
							<c:forEach var="roleList" items="${roleList}">
								<li><a valueID="${index+1}">${roleList}</a></li>
								<c:set var="index" value="${index+1}" />
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div class="signin">
				<input type="submit" value="Login">
			</div>
		</form>

	</div>
	<script src="<%=path%>/assets/js/bootstrap.min.js"></script>
	<script src="<%=path%>/assets/js/bootstrap-select.js"></script>
	<script>
		$("body").on('click', '.role-menu li', function(e) {
			var $target = $(e.target);
			$target.is('a') && $('#schoolId').text($target.text());
			$('#role-input').attr('value', $target.attr("valueid"));

			//如果点击的是a标签
			if ($target.is('a')) {
				//更新新的专业列表
				var schoolId = $target.attr("valueid");
			}
		});
	</script>

</body>
</html>
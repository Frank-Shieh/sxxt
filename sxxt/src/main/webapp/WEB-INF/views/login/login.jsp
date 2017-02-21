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
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<meta name="keywords"
	content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="<%=path%>/assets/css/login.css" rel='stylesheet'
	type='text/css' />

<!--//webfonts-->
<script src="<%=path%>/assets/js/jquery-2.2.3.min.js"></script>
</head>
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
				<input type="password" name="password" value="Password">
			</div>
			<label><input name="role" type="radio" value="1" />学校教师 </label>
			<div class="signin">
				<input type="submit" value="Login">
			</div>
		</form>

	</div>

</body>
</html>
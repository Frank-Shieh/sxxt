<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<header class="main-header">
	<!-- Logo -->
	<a href="index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>T</b>S</span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>Training</b>System</span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span>
		</a>
	</nav>
</header>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">MAIN NAVIGATION</li>
			<!-- 班级人员信息导航列表 -->
			<li class="treeview"><a href="#"> <i class="fa fa-child"
					aria-hidden="true"></i> <span>班级人员信息</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="#"><i class="fa fa-circle-o"></i> 添加班级信息 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/class/addClass"><i class="fa fa-circle-o"></i>添加单个班级信息</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i>导入全部班级信息</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> 添加人员信息 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/student/add"><i class="fa fa-circle-o"></i>添加单个人员信息</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i>导入班级人员信息</a></li>
						</ul></li>
					<li><a href="/class/list"><i class="fa fa-circle-o"></i>查看班级列表</a></li>
				</ul></li>


			<!-- 实训公司信息导航列表 -->
			<li class="treeview"><a href="#"> <i class="fa fa-child"
					aria-hidden="true"></i> <span>实训公司信息管理</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="#"><i class="fa fa-circle-o"></i> 实训公司基本信息 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/company/add"><i class="fa fa-circle-o"></i>添加实训公司信息</a></li>
							<li><a href="/company/list"><i class="fa fa-circle-o"></i>查看实训公司列表</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> 实训场地信息管理 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/site/add"><i class="fa fa-circle-o"></i>添加实训场地信息</a></li>
							<li><a href="/site/list"><i class="fa fa-circle-o"></i>查看实训场地列表</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> 场地设备信息管理 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/equipment/add"><i class="fa fa-circle-o"></i>添加场地设备信息</a></li>
							<li><a href="/equipment/list"><i class="fa fa-circle-o"></i>查看场地设备列表</a></li>
						</ul></li>
				</ul></li>

			<!-- 实训公司人员导航列表 -->
			<li class="treeview"><a href="#"> <i class="fa fa-child"
					aria-hidden="true"></i> <span>实训公司人员管理</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="#"><i class="fa fa-circle-o"></i> 场地管理员信息 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/siteManager/add"><i class="fa fa-circle-o"></i>添加场地管理员信息</a></li>
							<li><a href="/siteManager/listAll"><i class="fa fa-circle-o"></i>查看场地管理员列表</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> 设备管理员信息 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/equipmentManager/add"><i class="fa fa-circle-o"></i>添加
									设备管理员信息</a></li>
							<li><a href="/equipmentManager/list"><i class="fa fa-circle-o"></i>查看
									设备管理员列表</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> 实训教师信息 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/trainningTeacher/add"><i class="fa fa-circle-o"></i>添加实训教师信息</a></li>
							<li><a href="/trainningTeacher/list"><i class="fa fa-circle-o"></i>查看实训教师列表</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> 教务主管信息 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/equipment/add"><i class="fa fa-circle-o"></i>添加
									教务主管信息</a></li>
							<li><a href="/equipment/list"><i class="fa fa-circle-o"></i>查看
									教务主管列表</a></li>
						</ul></li>

				</ul></li>

			<!-- 资料共享平台 -->
			<li class="treeview"><a href="#"> <i class="fa fa-book"
					aria-hidden="true"></i> <span>资料共享平台</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="#"><i class="fa fa-circle-o"></i> 上传资料与共享 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-circle-o"></i>上传资料</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i>共享资料</a></li>
						</ul></li>
					<li><a href="index2.html"><i class="fa fa-circle-o"></i>浏览共享资料</a></li>
					<li><a href="index2.html"><i class="fa fa-circle-o"></i>自己的资料</a></li>
				</ul></li>

			<!-- 学生实训情况 -->
			<li class="treeview"><a href="#"> <i class="fa fa-file"
					aria-hidden="true"></i> <span>学生实训情况</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="#"><i class="fa fa-circle-o"></i>学生报告与总结</a></li>
					<li><a href="index2.html"><i class="fa fa-circle-o"></i>学生实训成绩
							<span class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-circle-o"></i>学生实训成绩</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i>实训成绩统计</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-circle-o"></i>学生出勤情况 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-circle-o"></i>学生出勤情况</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i>出勤情况统计</a></li>
						</ul></li>
				</ul></li>
			<li class="header">INFORMATION</li>
			<li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>通知与公告</span></a></li>
			<!-- 个人中心 -->
			<li class="treeview"><a href="#"> <i
					class="fa fa-circle-o text-aqua"></i> <span>个人中心</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="#"><i class="fa fa-circle-o"></i> 我的资料</a></li>
					<li><a href="index2.html"><i class="fa fa-circle-o"></i>修改密码</a></li>
				</ul></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>

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
		<label style="float: right;">欢迎您,${user.name}<a href="/logout"><font
				color=#333>退出</font></a></label>

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

			<!-- 学校人员导航列表 -->
			<li class="treeview"><a href="#"> <i class="fa fa-child"
					aria-hidden="true"></i> <span>学校人员管理</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<!-- <li><a href="#"><i class="fa fa-circle-o"></i> 学校教师信息 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/schoolTeacher/add"><i
									class="fa fa-circle-o"></i>添加学校教师信息</a></li>
							<li><a href="/schoolTeacher/list"><i
									class="fa fa-circle-o"></i>查看学校教师列表</a></li>
						</ul></li> -->
					<li><a href="#"><i class="fa fa-circle-o"></i> 学校班级信息 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/class/addClass"><i class="fa fa-circle-o"></i>添加班级信息</a></li>
							<li><a href="/class/list"><i class="fa fa-circle-o"></i>查看班级列表</a></li>
						</ul></li>
						<li><a href="/student/add"><i class="fa fa-circle-o"></i>添加学生信息</a></li>
					<!-- <li><a href="/student/add"><i class="fa fa-circle-o"></i> 添加学生信息 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
					 	<ul class="treeview-menu">
							<li><a href="/student/add"><i class="fa fa-circle-o"></i>添加单个学生信息</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i>导入班级人员信息</a></li>
						</ul> </li> -->

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
							<!-- <li><a href="/company/add"><i class="fa fa-circle-o"></i>添加实训公司信息</a></li> -->
							<li><a href="/company/listOnly"><i class="fa fa-circle-o"></i>查看实训公司列表</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> 实训场地信息管理 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
						<!-- 	<li><a href="/site/add"><i class="fa fa-circle-o"></i>添加实训场地信息</a></li> -->
							<li><a href="/site/listOnly"><i class="fa fa-circle-o"></i>查看实训场地列表</a></li>
						<!-- 	<li><a href="/site/rentAndAssign"><i
									class="fa fa-circle-o"></i>场地租借与分配管理</a></li> -->

						</ul></li>
				<!-- 	<li><a href="#"><i class="fa fa-circle-o"></i> 场地设备信息管理 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/equipmentInfo/add"><i
									class="fa fa-circle-o"></i>添加场地设备信息</a></li>
							<li><a href="/equipmentInfo/list"><i
									class="fa fa-circle-o"></i>查看场地设备列表</a></li>
							<li><a href="/equipmentInfo/rentAndAssign"><i
									class="fa fa-circle-o"></i>设备租借与分配管理</a></li>
							<li><a href="/equipmentInspection/add"><i
									class="fa fa-circle-o"></i>添加设备年检信息</a></li>
						</ul></li> -->
				</ul></li>

			<!-- 实训公司人员导航列表 -->
		<!-- 	<li class="treeview"><a href="#"> <i class="fa fa-child"
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
							<li><a href="/siteManager/listAll"><i
									class="fa fa-circle-o"></i>查看场地管理员列表</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> 设备管理员信息 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/equipmentManager/add"><i
									class="fa fa-circle-o"></i>添加 设备管理员信息</a></li>
							<li><a href="/equipmentManager/list"><i
									class="fa fa-circle-o"></i>查看 设备管理员列表</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> 实训教师信息 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/trainningTeacher/add"><i
									class="fa fa-circle-o"></i>添加实训教师信息</a></li>
							<li><a href="/trainningTeacher/list"><i
									class="fa fa-circle-o"></i>查看实训教师列表</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> 教务主管信息 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/educationManager/add"><i
									class="fa fa-circle-o"></i>添加教务主管信息</a></li>
							<li><a href="/educationManager/list"><i
									class="fa fa-circle-o"></i>查看教务主管列表</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> 系统管理员信息 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/systemManager/add"><i
									class="fa fa-circle-o"></i>添加系统管理员信息</a></li>
							<li><a href="/systemManager/list"><i
									class="fa fa-circle-o"></i>查看系统管理员列表</a></li>
						</ul></li>
				</ul></li> -->

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
							<li><a href="/dataInfo/add"><i class="fa fa-circle-o"></i>上传资料</a></li>
							<li><a href="/dataInfo/listMyself/${user.id}/${user.role.id}"><i class="fa fa-circle-o"></i>自己的资料</a></li>
						</ul></li>
					<li><a href="/dataInfo/list"><i class="fa fa-circle-o"></i>浏览共享资料</a></li>
				<%-- 	<li><a href="/dataInfo/listMyself/${user.id}/${user.role.id}"><i
							class="fa fa-circle-o"></i>自己的资料</a></li> --%>
				</ul></li>
			<!-- 实训教学安排 -->
		<!-- 	<li class="treeview"><a href="#"> <i class="fa fa-file"
					aria-hidden="true"></i> <span>实训教学安排</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="#"><i class="fa fa-circle-o"></i>实训教学任务 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/teachingTask/add"><i
									class="fa fa-circle-o"></i>添加实训教学任务</a></li>
							<li><a href="/teachingTask/list"><i
									class="fa fa-circle-o"></i>实训教学任务列表</a></li>
						</ul></li>
				</ul>
				<ul class="treeview-menu">
					<li><a href="#"><i class="fa fa-circle-o"></i>实训训练任务 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/trainningTask/add"><i
									class="fa fa-circle-o"></i>添加实训训练任务</a></li>
							<li><a href="/trainningTask/list"><i
									class="fa fa-circle-o"></i>实训训练任务列表</a></li>
						</ul></li>
				</ul>
				<ul class="treeview-menu">
					<li><a href="#"><i class="fa fa-circle-o"></i>班级教师分配 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/allocateClass/add"><i
									class="fa fa-circle-o"></i>添加班级教师分配</a></li>
							<li><a href="/allocateClass/list"><i
									class="fa fa-circle-o"></i>班级教师分配列表</a></li>
						</ul></li>
				</ul></li> -->

			<!-- 学生实训情况 -->
			<li class="treeview"><a href="#"> <i class="fa fa-file"
					aria-hidden="true"></i> <span>学生实训情况</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="/reportAndSummary/list"><i
							class="fa fa-circle-o"></i>学生报告与总结 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
						<!-- 	<li><a href="/reportAndSummary/add"><i
									class="fa fa-circle-o"></i>学生撰写报告</a></li> -->
							<li><a href="/reportAndSummary/listOnly"><i
									class="fa fa-circle-o"></i>学生报告列表</a></li>
						</ul></li>
					<li><a href="index2.html"><i class="fa fa-circle-o"></i>学生实训成绩
							<span class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
						<!-- 	<li><a href="/studentScore/add"><i
									class="fa fa-circle-o"></i>添加学生实训成绩</a></li> -->
							<li><a href="/studentScore/listClass"><i
									class="fa fa-circle-o"></i>学生实训成绩列表</a></li>
						</ul></li>
					<!-- <li><a href="#"><i class="fa fa-circle-o"></i>教师评价情况 <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/teacherComment/add"><i
									class="fa fa-circle-o"></i>添加教师评价情况</a></li>
							<li><a href="/teacherComment/listAll"><i
									class="fa fa-circle-o"></i>教师评价情况列表</a></li>
						</ul></li> -->
				</ul></li>
			<li class="header">INFORMATION</li>
			<!-- 个人中心 -->
			<li class="treeview"><a href="#"> <i
					class="fa fa-circle-o text-aqua"></i> <span>个人中心</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<!-- <li><a href="#"><i class="fa fa-circle-o"></i> 我的资料</a></li> -->
					<li><a href="/password"><i class="fa fa-circle-o"></i>修改密码</a></li>
				</ul></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>

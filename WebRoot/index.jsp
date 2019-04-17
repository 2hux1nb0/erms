<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>教室信息管理系统</title>
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/css/index.css">
			<script type="text/javascript" src="${pageContext.request.contextPath}/js/background.js"></script>
	</head>

	<body>
		<div id="container">
			<div id="login">
				<div id="title" class="center">教室管理系统登录</div>
				<div id="form">
					<form action="${pageContext.request.contextPath}/servlet/LoginServlet" method="post">
						<div id="input">
							<div id="text" class="center">
								<input type="text" name="username" value="${form.username }"/>
							</div>
							<div id="text" class="center">
								<input type="password" name="password" value="${form.password }"/>
							</div>
							<div id="btn" class="center">
								<input type="submit" value=" " />
							</div>
						</div>
						<div id="radio">
							<input type="radio" name="type" value="student" ${(form.type=='student'||form.type==null)?'checked':'' }/>
							<span>学生</span>
							<input type="radio" name="type" value="teacher" ${form.type=='teacher'?'checked':'' }/>
							<span>教师</span>
							<input type="radio" name="type" value="admin" ${form.type=='admin'?'checked':'' }/>
							<span>管理员</span>
						</div>
						<div id="a">
							<a href="${pageContext.request.contextPath}/servlet/RegisterUIServlet">没有账号,立即注册</a>
						</div>
						<div id="error">
							<span>${form.error}</span>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>

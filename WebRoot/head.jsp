<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'head.jsp' starting page</title>
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath }/css/head.css">
	</head>

	<body>
		<div id="title" class="inline"></div>
		<div id="v" class="inline">
			<span id="version">V1.0</span>
		</div>
		<div id="l" class="inline">
			<span>hello!&nbsp;<a href='${pageContext.request.contextPath }/servlet/MyInfoUIServlet?id=${pageContext.request.getParameter("id") }' target="main">${pageContext.request.getParameter("username")}</a>&nbsp;&nbsp;<a id="logout" href="index.jsp" target="_parent">退出登录</a></span>
		</div>
	</body>
</html>

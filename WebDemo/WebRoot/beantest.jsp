<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ page import="ex.Person" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>javaBean测试</title>
</head>
<body>
	<!-- 创建person实例，该实例的实例名为p1 -->
	<jsp:useBean id="p1" class="ex.Person" scope="page">
		<!-- 设置p1的name属性值 -->
		<jsp:setProperty name="p1" property="name" value="mike"/>
		<!-- 设置p1的age属性值 -->
		<jsp:setProperty name="p1" property="age" value="21"/>
		<!-- 输出p1的name属性值 -->
		<jsp:getProperty name="p1" property="name"/>
		<!-- 输出p1的age属性值 -->
		<jsp:getProperty name="p1" property="age" />
	</jsp:useBean>
</body>
</html>
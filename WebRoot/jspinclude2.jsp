<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jspinclude测试</title>
</head>
<body>
	<jsp:include page="forwardresult.jsp">
		<jsp:param value="13" name="age"/>
		<jsp:param value="admin" name="username"/>
	</jsp:include>
</body>
</html>
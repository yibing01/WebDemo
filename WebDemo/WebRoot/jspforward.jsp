<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forward原始页</title>
</head>
<body>
	<h3>forward原始页</h3>
	<jsp:forward page="forwardresult.jsp">
		<jsp:param value="20" name="age"/>
	</jsp:forward>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>errortest</title>
</head>
<body>
	<%
		//下面代码运行时将出现错误
		int a = 6;
		int b = 0;
		int c = a / b;
	 %>
</body>
</html>
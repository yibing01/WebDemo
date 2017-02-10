<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报错页面</title>
</head>
<body>
	<%
		out.println("请求页面出错");
	 %>
	 异常类型是：<%=exception.getClass()%>
	 异常信息是：<%=exception.getMessage() %>>
</body>
</html>
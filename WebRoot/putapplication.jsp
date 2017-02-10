<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP内置对象application测试</title>
</head>
<body>
	<!-- JSP声明 -->
	<%!
		int i ;
	 %>
	 <!-- 将i值自加后放入application中 -->
	 <%
	 	application.setAttribute("counter", String.valueOf(++i));
	  %>
	  <!-- 输出i值 -->
	  <%=i %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>输出表达式值</title>
</head>
	<%!
		public int count;
		
		public String info(){
			return "Hello World";
		}
	 %>
<body>
	<!-- 使用表达式输出变量 -->
	<%=count++ %>
	<br>
	<%=info() %>
</body>
</html>
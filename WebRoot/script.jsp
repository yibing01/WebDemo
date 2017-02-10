<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP脚本</title>
</head>
<body>
	<table bgcolor="red" border="1" width="300px">
		<!-- java脚本 -->
		<%
			for(int i = 0; i < 10; i++){
		 %>
		 	<!-- 上面循环控制<tr>标签循环输出 -->
		 	<tr>
		 		<td>循环值：
		 		<td><%= i %>
		 	</tr>
		 <%
			}
		  %>
	</table>
</body>
</html>
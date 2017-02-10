<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP声明示例</title>
</head>
<body>
	<%!
		//声明一个整型变量
		public int count;
		//声明一个方法
		public String info(){
			return "Hello World!";
		}
	 %>
	 <%
	 	//讲count值输出后加1
	 	out.println(count++);
	  %>
	  <br>
	  <%
	  	//输出info方法的返回值
	  	out.println(info());
	   %>
</body>
</html>
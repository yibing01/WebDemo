<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ex.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>javaBean测试</title>
</head>
<body>
	<%
		//实例化JavaBean实例
		Person p1 = new Person();
		//将p1放在page范围内
		pageContext.setAttribute("p1", p1);
		//设置p1的name属性值
		p1.setName("nike");
		//设置p1的age属性值
		p1.setAge(23);
	 %>
	 <!-- 输出p1的name属性值 -->
	 <%=p1.getName() %><br>
	 <!-- 输出p1的age属性值 -->
	 <%=p1.getAge() %>
</body>
</html>
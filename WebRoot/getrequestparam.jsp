<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>获取get请求的参数</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	//设置解码方式，对于简体中文，使用gb2312解码
    	request.setCharacterEncoding("UTF-8");
    	//获取请求参数中的姓名和性别
    	String name = request.getParameter("name");
    	String gender = request.getParameter("gender");
    	//获取get请求中的颜色等信息
    	String[] color = request.getParameterValues("color");
    	String country = request.getParameter("country");
    	
     %>
     <!-- 依次输出表单域的值 -->
     	您的名字：<%=name %><hr>
     	您的性别：<%=gender %><hr>
     	<!-- 输出复选框获取的数组值 -->
     	您喜欢的颜色：<%
     		for(String c:color){
     			out.println(c + "");
     		}
     	 %><hr>
     	 您的祖国是：<%=country %><hr>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>获取请求头或请求参数</title>
    
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
    	//获取所有的请求头名称
    	Enumeration<String> headerNames = request.getHeaderNames();
    	while(headerNames.hasMoreElements()){
    		String headerName = headerNames.nextElement();
    		//获取每个请求及对应的值
    		out.println(headerName + "-->" + request.getHeader(headerName)+"<br>");
    	}
    	out.println("<hr>");
    	//设置解码方式，对于简体中文，使用gb2312解码
    	request.setCharacterEncoding("UTF-8");
    	//下面依次获取表单域的值
    	String name = request.getParameter("name");
    	String gender = request.getParameter("gender");
    	//如果某个请求参数有多个值，将使用该方法获取多个值
    	String[] color = request.getParameterValues("color");
    	String national = request.getParameter("country");
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
     	 您的祖国是：<%=national %><hr>
  </body>
</html>

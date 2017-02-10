<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加Cookie</title>
    
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
    	//获取请求参数
    	String name = request.getParameter("name");
    	//以获取的请求参数为值，创建一个Cookie对象
    	Cookie cookie = new Cookie("username",name);
    	//设置Cookie对象的生存周期
    	cookie.setMaxAge(1 * 60);
    	//向客户端添加Cookie
    	response.addCookie(cookie);
     %>
    
  </body>
</html>

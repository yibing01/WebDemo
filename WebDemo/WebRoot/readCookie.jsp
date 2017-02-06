<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>读取Cookie</title>
    
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
    	//获取本站在客户端上保留的所有Cookie
    	Cookie[] cookies = request.getCookies();
    	//遍历所有的Cookie
    	for(Cookie c : cookies){
    		//如果Cookie的名为username，表明该Cookie是需要访问的Cookie
    		if(c.getName().equals("username")){
    			out.println(c.getComment());
    			out.println(c.getDomain());
    			out.println(c.getMaxAge());
    			out.println(c.getValue());
    			out.println(c.getPath());
    			out.println(c.getSecure());
    			out.println(c.getVersion());
    			out.println(c.getClass());
    		}
    	}
     %>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/mytaglib" prefix="mytaglib" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FragmentTag.jsp' starting page</title>
    
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
    <h2>显示自定义标签内容</h2>
    <mytaglib:fragment fragment="fragment"/>
    <jsp:attribute name="fragment">
    	<!-- 下面是动态的jsp页面片段 -->
    	<mytaglib:helloWorld/>
    </jsp:attribute><br>
    <mytaglib:fragment fragment="fragment1"/>
    <jsp:attribute name="fragment1">
    	<!-- 下面是动态的jsp页面片段 -->
    	${pageContext.request.remoteAddr}
    </jsp:attribute><br>
  </body>
</html>

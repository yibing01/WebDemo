<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  prefix="tags" tagdir="/WEB-INF/tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>iterator tag file</title>
    
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
    <h2>迭代器Tag File</h2>
    <%
    	//创建集合对象，用于测试Tag File所定义的标签
    	List<String> a = new ArrayList<String>();
    	a.add("hello");
    	a.add("world");
    	a.add("java");
    	//将集合对象放入页面范围
    	request.setAttribute("a", a);
     %>
     <!-- 使用自定义标签 -->
     <tags:iterator bgColor="#99dd99" cellColor="#9999cc"
     				title="迭代器标签" bean="a"></tags:iterator>
  </body>
</html>

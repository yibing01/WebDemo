<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/mytaglib" prefix="mytaglib"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dynamicAttributesTag.jsp' starting page</title>
    
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
    <h2>下面显示的是自定义标签中的内容</h2>
    <h4>指定两个属性</h4>
    <mytaglib:dynamic name="qw" url="www.baidu.com"/><br>
    <h4>指定四个属性</h4>
    <mytaglib:dynamic 书名="疯狂java" 价格="99元" 出版时间="2001年" 描述="Java学习图书"/><br>
  </body>
</html>

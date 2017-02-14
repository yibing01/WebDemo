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
    
    <title>My JSP 'useFunctions.jsp' starting page</title>
    
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
    <h2>表达式语言-自定义函数</h2>
    请输入一个字符串：
    <form action="useFunctions.jsp" method="post">
    	字符串 = <input type="text" name="name" value="${param['name']}"> 
    	<input type="submit" value="提交">
    </form>
    <table border="1" bgcolor="#aaaadd">
    	<tr>
    		<td><b>表达式</b></td>
    		<td><b>计算结果</b></td>
    	</tr>
    	<tr>
    		<td>\${param['name']}</td>
    		<td>${param['name']}</td>
    	</tr>
    	<!-- 使用reverse函数 -->
    	<tr>
    		<td>\${mytaglib:reverse(param['name'])}</td>
    		<td>${mytaglib:reverse(param['name'])}</td>
    	</tr>
    	<!-- 使用countChar函数 -->
    	<tr>
    		<td>\${mytaglib:countChar(param['name'])}</td>
    		<td>${mytaglib:countChar(param['name'])}</td>
    	</tr>
    </table>
  </body>
</html>

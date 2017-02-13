<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>表达式语言之算术运算符</title>
    
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
    <h2>表达式语言之算术运算符</h2><hr>
    <table border="1" bgcolor="#aaaadd">
    <tr>
    		<td><b>表达式语言</b>
    		<td><b>计算结果</b>
    	</tr>
    	<!-- 直接输出常量 -->
    	<tr>
    		<td>\${1}</td>
    		<td>${1}</td>
    	</tr>
    	<!-- 计算加法 -->
    	<tr>
    		<td>\${1.2 + 2.3}</td>
    		<td>${1.2 +2.3}</td>
    	</tr>
    	<!-- 计算加法 -->
    	<tr>
    		<td>\${1.2E4 + 2.3}</td>
    		<td>${1.2E4 +2.3}</td>
    	</tr>
    	<!-- 计算减法 -->
    	<tr>
    		<td>\${4 - 2}</td>
    		<td>${4 - 2}</td>
    	</tr>
    	<!-- 计算乘法 -->
    	<tr>
    		<td>\${2 * 4}</td>
    		<td>${2 * 4}</td>
    	</tr>
    	<!-- 计算除法 -->
    	<tr>
    		<td>\${4 / 2}</td>
    		<td>${4 / 2}</td>
    	</tr>
    	<!-- 计算除法 -->
    	<tr>
    		<td>\${4 / 2}</td>
    		<td>${4 / 2}</td>
    	</tr>
    	<!-- 求余 -->
    	<tr>
    		<td>\${10 % 3}</td>
    		<td>${10 % 3}</td>
    	</tr>
    	<!-- 三目运算符 -->
    	<tr>
    		<td>\${(1 == 2) ? 3 : 4}</td>
    		<td>${(1 == 2) ? 3 : 4}</td>
    	</tr>
    </table>
  </body>
</html>

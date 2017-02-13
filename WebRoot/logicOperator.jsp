<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>表达式语言逻辑运算</title>
    
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
    <h2>表达式语言逻辑运算</h2><hr>
    数字之间的比较：
    <table border="1" bgcolor="#aaaadd">
    	<tr>
    		<td><b>表达式语言</b></td>
    		<td><b>计算结果</b></td>
    	</tr>
    	<!-- 直接比较两个数字的大小 -->
    	<tr>
    		<td>\${1 &lt; 2}</td>
    		<td>${1 < 2}</td>
    	</tr>
    	<!-- 使用lt比较运算符 -->
    	<tr>
    		<td>\${1 lt 2}</td>
    		<td>${1 lt 2}</td>
    	</tr>
    	<!-- 使用>比较运算符 -->
    	<tr>
    		<td>\${1 &gt; 2}</td>
    		<td>${1 gt 2}</td>
    	</tr>
    	<!-- 使用ge比较运算符 -->
    	<tr>
    		<td>\${1.0 ge 2}</td>
    		<td>${1.0 ge 2}</td>
    	</tr>
    	<!-- 使用le比较运算符 -->
    	<tr>
    		<td>\${3 le 2}</td>
    		<td>${3 le 2}</td>
    	</tr>
    	<!-- 使用ne比较运算符 -->
    	<tr>
    		<td>\${(10 * 10) ne 100 }</td>
    		<td>${(10 * 10) ne 100}</</td>
    	</tr>
    	<!-- 使用eq比较运算符 -->
    	<tr>
    		<td>\${(10 * 10) eq 100 }</td>
    		<td>${(10 * 10) eq 100}</td>
    	</tr>
    </table>
  </body>
</html>

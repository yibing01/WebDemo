<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>表达式语言内置对象</title>
    
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
    <h2>表达式语言内置对象</h2><hr>
    请输入你的名字：
    <!-- 通过表单提交请求参数 -->
    <form action="implicit-objects.jsp" method="post">
    	<!-- 通过${param['name']}获取请求参数 -->
    	你的名字 = <input type="text" name="name" value="${param['name']}">
    	<input type="submit" value="提交">
    </form><br/>
    <%
    	session.setAttribute("user", "abc");
    	//添加Cookie
    	Cookie cookie = new Cookie("name","yibing");
    	cookie.setMaxAge(24 * 3600);
    	response.addCookie(cookie);
     %>
     <table border="1" width="660" bgcolor="#aaaadd">
     	<tr>
     		<td width="170"><b>功能</b></td>
     		<td width="200"><b>表达式</b></td>
     		<td width="300"><b>计算结果</b></td>
     	</tr>
     	<!-- 使用两种方式获取请求参数 -->
     	<tr>
     		<td>取得请求参数</td>
     		<td>\${param.name}</td>
     		<td>${param.name}</td>
     	</tr>
     	<tr>
     		<td>取得请求参数</td>
     		<td>\${param['name']}</td>
     		<td>${param['name']}</td>
     	</tr>
     	<!-- 使用两种方式获取请求头 -->
     	<tr>
     		<td>取得请求头的值</td>
     		<td>\${header.host}</td>
     		<td>${header.host}</td>
     	</tr>
     	<tr>
     		<td>取得请求头的值</td>
     		<td>\${header['accept']}</td>
     		<td>${header['accept']}</td>
     	</tr>
     	<!-- 获取web应用的初始化参数值 -->
     	<tr>
     		<td>取得初始化参数值</td>
     		<td>\${initParam['author']}</td>
     		<td>${initParam['author']}</td>
     	</tr>
     	<!-- 获取session返回的属性值 -->
     	<tr>
     		<td>取得session的属性值</td>
     		<td>\${sessionScope['user']}</td>
     		<td>${sessionScope['user']}</td>
     	</tr>
     	<!-- 获取指定的cookie的值 -->
     	<tr>
     		<td>取得指定的Cookie的值</td>
     		<td>\${cookie['name'].value}</td>
     		<td>${cookie['name'].value}</td>
     	</tr>
     </table>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
    <!-- 输出错误提示 -->
    <span style="color:red;font-weight:bold">
    	<%
    		if(request.getAttribute("error") != null){
    			out.println(request.getAttribute("error") + "<br/>");
    		}
    	 %>
    </span>
	请输入用户名和密码：
	<!-- 登录表单，该表单提交到一个Servlet -->
	<form id="login" method="post" action="login">
		用户名：<input type="text" name="username"><br>
		密&nbsp;码：<input type="password" name="password"><br>
		<input type="submit" value="登录"><br>
	</form>
  </body>
</html>

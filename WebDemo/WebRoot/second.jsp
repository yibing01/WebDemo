<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>request处理</title>
    
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
    	//取出请求参数
    	String bal = request.getParameter("balance");
    	double money = Double.parseDouble(bal);
    	//取出request范围内的info属性
    	List<String> info = (List<String>)request.getAttribute("info");
    	for(String str:info){
    		out.println(str + "<br>");
    	}
    	out.println("取钱" + money +"块");
    	out.println("账户减少" + money);
    	
     %>
  </body>
</html>

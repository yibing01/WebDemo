<%@ page language="java" import="java.util.*,java.net.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>获取URL中的中文参数</title>
    
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
			//获取请求里包含的查询字符串
			String rawQueryStr = request.getQueryString();
			out.println("原始查询字符串为：" + rawQueryStr + "<hr>");
			//使用URLEncoder解码字符串
			String queryStr = URLDecoder.decode(rawQueryStr,"UTF-8");
			out.println("解码后的查询字符串为：" + queryStr);
			//以$符号分解查询字符串
			String[] paramPairs = queryStr.split("&");
			for(String paramPair:paramPairs){
				out.println("每个请求参数名、值对为：" + paramPair + "<br>");
				//以=来分解请求参数名和值
				String[] nameValue = paramPair.split("=");
				out.println(nameValue[0] + "参数的值是：" + nameValue[1] + "<hr>");
			}
		 %>
  </body>
</html>

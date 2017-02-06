<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加中文Cookie</title>
    
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
		//以编码后的字符串为值，创建一个Cookie对象
		Cookie cookie = new Cookie("cnName",
				java.net.URLEncoder.encode("孙悟空", "UTF-8"));
		//设置Cookie的生存周期
		cookie.setMaxAge(2 * 60);
		//向客户端增加Cookie
		response.addCookie(cookie);
		
		//获取本站在该客户端保留的所有Cookie
		Cookie[] cookies = request.getCookies();
		//遍历所有的Cookie
		for(Cookie coo : cookies){
			//如果Cookie名为username，表明该Cookie是所需的Cookie
			if(coo.getName().equals("cnName")){
				//使用java.net.URLDecoder对Cookie进行解码
				out.println(java.net.URLDecoder.decode(coo.getValue().toString(),"UTF-8"));
				
			}
		}
	 %>
  </body>
</html>

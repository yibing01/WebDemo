<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>取钱请求处理页面</title>
    
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
    	//获取请求的钱数
    	String bal = request.getParameter("balance");
    	//将钱数转为double类型
    	double money = Double.parseDouble(bal);
    	//对取钱操作进行处理
    	if(money < 500){
    		out.println("给你" + money + "钱");
    		out.println("账户减少" + money);
    	}else{
    		//创建一个List对象
    		List<String> info = new ArrayList<String>();
    		info.add("111111");
    		info.add("222222");
    		info.add("333333");
    		//将info对象放入request范围内
    		request.setAttribute("info",info);
    	
     %>
     <!-- 实现转发 -->
     <jsp:forward page="second.jsp"></jsp:forward>
     <%} %>
  </body>
</html>

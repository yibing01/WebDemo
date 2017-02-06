<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pagecontext测试</title>
</head>
<body>
	<%
		//使用pagecontext设置属性，该属性默认在page范围内
		pageContext.setAttribute("page", "hellopage");
		//使用request设置属性，该属性默认在request范围内
		pageContext.setAttribute("request1", "hellorequest1", pageContext.REQUEST_SCOPE);
		//使用session将属性设置在request范围中
		session.setAttribute("session", "hellosession");
		//使用pagecontext将属性设置在session范围中
		pageContext.setAttribute("session1", "hellosession1", pageContext.SESSION_SCOPE);
		//使用application将属性设置在application范围内
		application.setAttribute("application", "helloApplication");
		//使用pageContext将属性设在application范围内
		pageContext.setAttribute("application1", "helloapplication1", 
									pageContext.APPLICATION_SCOPE);
		//获取以上属性的作用范围
		out.println("page变量所在范围："+
					pageContext.getAttributesScope("page")+"<br/>");
		out.println("request变量坐在范围："+
					pageContext.getAttributesScope("request1"));
		out.println("sesssion变量的范围："+
					pageContext.getAttributesScope("session"));
		out.println("session1变量的范围："+
					pageContext.getAttributesScope("session1"));
		out.println("application变量的范围："+
					pageContext.getAttributesScope("application"));
		out.println("application1的变量范围："+
					pageContext.getAttributesScope("application1"));
	 %>
</body>
</html>
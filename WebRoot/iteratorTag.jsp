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
    
    <title>My JSP 'iteratorTag.jsp' starting page</title>
    
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
    <h2>带标签体的标签--迭代器标签</h2>
    <%
    	//创建一个List对象
    	List<String> list = new ArrayList<String>();
    	list.add("曲儿");
    	list.add("adajkkdf");
    	list.add("akmlio");
    	//将List对象放入page范围内
    	pageContext.setAttribute("list", list);
     %>
     <table border="1" bgColor="#aaaadd" width="400">
     	<!-- 使用迭代器标签，对list集合进行迭代 -->
		<mytaglib:iterator item="item" collection="list">
			<tr>
				<td>${pageScope.item}</td>
			</tr>
		</mytaglib:iterator>
     </table>
  </body>
</html>

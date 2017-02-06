<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
    	//取出session范围内 的itemMap属性
    	Map<String,Integer> itemMap = (Map<String,Integer>)session.getAttribute("itemMap");
    	//如果Map对象为空，则初始化Map对象
    	if(itemMap == null){
    		itemMap = new HashMap<String,Integer>();
    		itemMap.put("书籍", 0);
    		itemMap.put("电脑", 0);
    		itemMap.put("汽车", 0);
    	}
    	//获取上一个页面的请求参数
    	String[] buys = request.getParameterValues("item");
    	//遍历数组各元素
    	for(String item : buys){
    		//如果item为book，表示选择购买书籍
    		if(item.equals("book")){
    			int num = itemMap.get("书籍").intValue();
    			//将书籍的key对应的数量加1
    			itemMap.put("书籍", num + 1);
    		}
    		//如果item对应为computer，表示选择购买电脑
    		else if(item.equals("computer")){
    			int num1 = itemMap.get("电脑").intValue();
    			//将电脑的key对应的数量加1
    			itemMap.put("电脑", num1 + 1);
    		}
    		//如果item对应为car，表示选择购买汽车
    		else if(item.equals("car")){
    			int num2 = itemMap.get("汽车").intValue();
    			//将汽车的key对应的数量加1
    			itemMap.put("汽车", num2 + 1);
    		}
    	}
    	//将itemMap对象放到session范围内的 itemMap属性
    	session.setAttribute("itemMap",itemMap);
     %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>处理购物请求</title>
    
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
    	您所购买的物品：<br>
    	书籍：<%=itemMap.get("书籍") %>本<br>
    	汽车：<%=itemMap.get("汽车") %>辆<br>
    	电脑：<%=itemMap.get("电脑") %>台<br>
    <p><a href="shop.jsp">再次购买</a>
  </body>
</html>

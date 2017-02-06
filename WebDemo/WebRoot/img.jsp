<%--通过contentType属性指定响应数据是图片 --%>
<%@ page contentType="image/jpeg" language="java" import="java.awt.image.*,javax.imageio.*,java.io.*,java.awt.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>使用response对象响应生成非字符响应</title>
    
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
    	//创建BufferedImage对象
    	BufferedImage image = new BufferedImage(340,
    			160,BufferedImage.TYPE_INT_RGB);
    	//使用Image对象获取Graphics对象
    	Graphics graphic = image.getGraphics();
    	//使用Graphics绘图，绘制图像将会出现在image对象中
    	graphic.fillRect(0, 0, 400, 400);
    	//设置颜色:红色
    	graphic.setColor(new Color(255,0,0));
    	//画出一段弧
    	graphic.fillArc(20, 20, 100, 100, 30, 120);
    	//设置颜色:绿色
    	graphic.setColor(new Color(0,255,0));
    	//画出一段弧
    	graphic.fillArc(20, 20, 100, 100, 150, 120);
    	//设置颜色：蓝
    	graphic.setColor(new Color(0,0,255));
    	//画出一段弧
    	graphic.fillArc(20,20,100,100,270,120);
    	//设置颜色：黑
    	graphic.setColor(new Color(0,0,0));
    	//设置文字格式
    	graphic.setFont(new Font("Arial Black",Font.PLAIN,16));
    	//画出三个字符串
    	graphic.drawString("red:climb",200,60);
    	graphic.drawString("green:swim",200,100);
    	graphic.drawString("blue:jump",200,140);
    	graphic.dispose();
    	//将图像输出到页面响应
    	ImageIO.write(image, "jpg", response.getOutputStream());
     %>
  </body>
</html>

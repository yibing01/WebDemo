<%@ tag pageEncoding="UTF-8" import="java.util.*"%>
<!-- 定义了4个标签属性 -->
<%@ attribute name="bgColor" %>
<%@ attribute name="cellColor"%>
<%@ attribute name="title" %>
<%@ attribute name="bean" %>
<table border="1" bgColor="${bgColor}">
  <tr>
    <td><b>${title}</b></td>
  </tr>
  <!-- 取出request范围的a集合 -->
  <%
  	List<String> list = (List<String>)request.getAttribute("a");
  	//遍历输出list集合的元素
  	for(Object ele : list){%>
  		<tr>
  		<td bgColor="${cellColor}">
  		<%=ele %>
  		</td>
  		</tr>
  <%		
  	}
   %>
</table>


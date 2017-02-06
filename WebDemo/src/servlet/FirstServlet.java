package servlet;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Servlet必须继承HttpServlet类
@WebServlet(name="firstServlet",
			urlPatterns={"/firstServlet"})
public class FirstServlet extends HttpServlet {
	//客户端的响应方法，使用该方法可以响应客户端所有的请求
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置解码方式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//设置客户端解码方式
		response.setCharacterEncoding("GBK");
		//获取name的请求参数值
		String name = request.getParameter("name");
		//获取gender的请求参数值
		String gender = request.getParameter("gender");
		//获取Color的请求参数值
		String[] color = request.getParameterValues("color");
		//获取Country的请求参数值
		String country = request.getParameter("country");
		//获取页面输出流
		PrintStream out = new PrintStream(response.getOutputStream());
		//输出成Html页面标签
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet测试</title>");
		out.println("</head>");
		out.println("<body>");
		//输出请求参数name的值
		out.println("您的名字：" + name + "<hr>");
		//输出请求参数gender的值
		out.println("您的性别：" + gender + "<hr>");
		//输出请求参数color的值
		out.println("您喜欢的颜色：");
		for(String co :color){
			out.println(co + "");
		}
		out.println("<hr>");
		//输出请求参数Country的值
		out.println("您的祖国是：" + country + "<hr>");
		out.println("</body>");
		out.println("</html>");
	}
}

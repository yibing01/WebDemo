package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javassist.bytecode.analysis.Executor;

/**
* @author yibing 
* @E-mail:yibingzn@qq.com
* @version 创建时间：2017年2月14日 上午10:29:21
* 类说明
*/
@WebServlet(urlPatterns="/async",asyncSupported=true)
public class AsyncServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<title>异步调用示例</title>");
		out.println("进入Servlet的时间：" + 
						new Date() + "<br/>");
		out.flush();
		//创建AsyncContext，开始异步调用
		AsyncContext asyncContext = request.startAsync();
		//设置异步调用超时时长
		asyncContext.setTimeout(30 * 1000);
		//启动异步调用的线程
		asyncContext.start(new ex.Executor(asyncContext));
		out.println("结束Servlet的时间：" + new Date() + "<br/>");
		out.flush();
	}
}

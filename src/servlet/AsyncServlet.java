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
* @version ����ʱ�䣺2017��2��14�� ����10:29:21
* ��˵��
*/
@WebServlet(urlPatterns="/async",asyncSupported=true)
public class AsyncServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<title>�첽����ʾ��</title>");
		out.println("����Servlet��ʱ�䣺" + 
						new Date() + "<br/>");
		out.flush();
		//����AsyncContext����ʼ�첽����
		AsyncContext asyncContext = request.startAsync();
		//�����첽���ó�ʱʱ��
		asyncContext.setTimeout(30 * 1000);
		//�����첽���õ��߳�
		asyncContext.start(new ex.Executor(asyncContext));
		out.println("����Servlet��ʱ�䣺" + new Date() + "<br/>");
		out.flush();
	}
}

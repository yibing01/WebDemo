package ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="getApplication",
		urlPatterns={"/getapplication"})
public class GetApplication extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>");
		out.println("application测试");
		out.println("</title></head><body>");
		ServletContext sc = getServletConfig().getServletContext();
		out.println("application中当前的counter值为：");
		out.println(sc.getAttribute("counter"));
		out.println("</body></html>");
	}
}

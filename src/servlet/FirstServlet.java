package servlet;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Servlet����̳�HttpServlet��
@WebServlet(name="firstServlet",
			urlPatterns={"/firstServlet"})
public class FirstServlet extends HttpServlet {
	//�ͻ��˵���Ӧ������ʹ�ø÷���������Ӧ�ͻ������е�����
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ý��뷽ʽ
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//���ÿͻ��˽��뷽ʽ
		response.setCharacterEncoding("GBK");
		//��ȡname���������ֵ
		String name = request.getParameter("name");
		//��ȡgender���������ֵ
		String gender = request.getParameter("gender");
		//��ȡColor���������ֵ
		String[] color = request.getParameterValues("color");
		//��ȡCountry���������ֵ
		String country = request.getParameter("country");
		//��ȡҳ�������
		PrintStream out = new PrintStream(response.getOutputStream());
		//�����Htmlҳ���ǩ
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet����</title>");
		out.println("</head>");
		out.println("<body>");
		//����������name��ֵ
		out.println("�������֣�" + name + "<hr>");
		//����������gender��ֵ
		out.println("�����Ա�" + gender + "<hr>");
		//����������color��ֵ
		out.println("��ϲ������ɫ��");
		for(String co :color){
			out.println(co + "");
		}
		out.println("<hr>");
		//����������Country��ֵ
		out.println("��������ǣ�" + country + "<hr>");
		out.println("</body>");
		out.println("</html>");
	}
}

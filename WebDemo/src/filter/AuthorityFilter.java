package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * �����û�
 * 		1.����request������ַ���������ÿ��jsp��Servlet�ظ�����
 * 		2.�ж��û��Ƿ��¼�����ޣ�ֱ����ת����¼ҳ��
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017��2��6�� ����2:00:54
 */
@WebFilter(filterName="filter0_authority"
		,urlPatterns={"/*"}
		,initParams={
				@WebInitParam(name="encoding",value="gbk"),
				@WebInitParam(name="loginPage",value="/login.jsp"),
				@WebInitParam(name="proLogin",value="/proLogin.jsp")
		})
public class AuthorityFilter implements Filter {
	//FilterConfig���ڷ���Filter��������Ϣ
	private FilterConfig config;
	//ʵ�����ٷ���
	@Override
	public void destroy() {
		config = null;
		System.out.println("Authority����");
	}
	//ִ�й��˵ĺ��ķ���
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//��ȡ��Filter�����ò���
		String encoding = config.getInitParameter("encoding");
		String loginPage = config.getInitParameter("loginPage");
		String proLogin = config.getInitParameter("proLogin");
		//����request�������õ��ַ���
		request.setCharacterEncoding(encoding);
		//���û�����ת��ΪHttpServletRequest
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpSession session = hrequest.getSession(true);
		//��ȡ�ͻ������ҳ��
		String requestPath = hrequest.getServletPath();
		System.out.println(requestPath);
		//���session��Χ�ڵ�userΪnull��������û�е�¼
		//���û�����ļȲ��ǵ�¼ҳ��
		if(session.getAttribute("name") != null
				|| requestPath.endsWith(loginPage)){
			//��������
			chain.doFilter(request, response);
		}else{
			//forward����¼ҳ��
			request.setAttribute("tip", "����û�е�¼�����ȵ�¼");
			request.getRequestDispatcher(loginPage).forward(request, response);
		}
		
	}
	//ʵ�ֳ�ʼ������
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		System.out.println("Authority��ʼ�����");
	}

}

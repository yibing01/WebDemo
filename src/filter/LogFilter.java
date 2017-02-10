package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
/**
 * ��־Filter
 * �����û����󲢽��������Ϣ��¼����־��
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017��2��6�� ����1:21:23
 */
@WebFilter(filterName="filter1_log",urlPatterns={"/*"})
public class LogFilter implements Filter {
	//FilterConfig���ڷ���Filter��������Ϣ
	private FilterConfig config;
	//ʵ�ֳ�ʼ������
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
	//ʵ�����ٷ���
	@Override
	public void destroy() {
		this.config = null;
	}
	//ִ�й��˵ĺ��ķ���
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//����������ڶ��û��������Ԥ����
		//��ȡServletContext�������ڼ�¼��־
		ServletContext context = config.getServletContext();
		long before = System.currentTimeMillis();
		System.out.println("��ʼ�������󡣡�����");
		//������ת��ΪHttpServletRequest
		HttpServletRequest hrequest = (HttpServletRequest) request;
		//�����ʾ��Ϣ
		System.out.println("Filter�Ѿ����ص��û��������ַ" + hrequest.getServletPath());
		//Filterֻ����ʽ����������Ȼ���е�Servlet
		chain.doFilter(request, response);
		//�Է�������Ӧִ�к���
		long after = System.currentTimeMillis();
		//�����ʾ��Ϣ
		System.out.println("���˽���");
		//�����ʾ��Ϣ
		System.out.println("���󱻶�λ����" + hrequest.getRequestURL() +
							"�ķ�ʱ��Ϊ��" + (after - before));
		
	}
}

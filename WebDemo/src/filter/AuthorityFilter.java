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
 * 过滤用户
 * 		1.设置request编码的字符集，避免每个jsp、Servlet重复设置
 * 		2.判断用户是否登录，若无，直接跳转到登录页面
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017年2月6日 下午2:00:54
 */
@WebFilter(filterName="filter0_authority"
		,urlPatterns={"/*"}
		,initParams={
				@WebInitParam(name="encoding",value="gbk"),
				@WebInitParam(name="loginPage",value="/login.jsp"),
				@WebInitParam(name="proLogin",value="/proLogin.jsp")
		})
public class AuthorityFilter implements Filter {
	//FilterConfig用于访问Filter的配置信息
	private FilterConfig config;
	//实现销毁方法
	@Override
	public void destroy() {
		config = null;
		System.out.println("Authority结束");
	}
	//执行过滤的核心方法
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//获取该Filter的配置参数
		String encoding = config.getInitParameter("encoding");
		String loginPage = config.getInitParameter("loginPage");
		String proLogin = config.getInitParameter("proLogin");
		//设置request编码所用的字符集
		request.setCharacterEncoding(encoding);
		//将用户请求转换为HttpServletRequest
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpSession session = hrequest.getSession(true);
		//获取客户请求的页面
		String requestPath = hrequest.getServletPath();
		System.out.println(requestPath);
		//如果session范围内的user为null，即表明没有登录
		//且用户请求的既不是登录页面
		if(session.getAttribute("name") != null
				|| requestPath.endsWith(loginPage)){
			//放行请求
			chain.doFilter(request, response);
		}else{
			//forward到登录页面
			request.setAttribute("tip", "您还没有登录，请先登录");
			request.getRequestDispatcher(loginPage).forward(request, response);
		}
		
	}
	//实现初始化方法
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		System.out.println("Authority初始化完成");
	}

}

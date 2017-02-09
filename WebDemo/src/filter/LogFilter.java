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
 * 日志Filter
 * 拦截用户请求并将请求的信息记录在日志中
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017年2月6日 下午1:21:23
 */
@WebFilter(filterName="filter1_log",urlPatterns={"/*"})
public class LogFilter implements Filter {
	//FilterConfig用于访问Filter的配置信息
	private FilterConfig config;
	//实现初始化方法
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
	//实现销毁方法
	@Override
	public void destroy() {
		this.config = null;
	}
	//执行过滤的核心方法
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//下面代码用于对用户请求进行预处理
		//获取ServletContext对象，用于记录日志
		ServletContext context = config.getServletContext();
		long before = System.currentTimeMillis();
		System.out.println("开始过滤请求。。。。");
		//将请求转换为HttpServletRequest
		HttpServletRequest hrequest = (HttpServletRequest) request;
		//输出提示信息
		System.out.println("Filter已经拦截到用户的请求地址" + hrequest.getServletPath());
		//Filter只是链式处理，请求依然放行到Servlet
		chain.doFilter(request, response);
		//对服务器响应执行后处理
		long after = System.currentTimeMillis();
		//输出提示信息
		System.out.println("过滤结束");
		//输出提示信息
		System.out.println("请求被定位到：" + hrequest.getRequestURL() +
							"耗费时间为：" + (after - before));
		
	}
}

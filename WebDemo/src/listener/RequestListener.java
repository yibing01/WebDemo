package listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
/**
 * 用户请求监听
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017年2月6日 下午4:40:52
 */
public class RequestListener implements ServletRequestListener, ServletRequestAttributeListener {
	//向request范围内添加属性时触发该方法发
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		ServletRequest request = srae.getServletRequest();
		//获取添加的属性名和属性值
		String name = srae.getName();
		Object value = srae.getValue();
		System.out.println(request + "范围内添加了名为：" + name +"的属性，值为：" + value);
	}
	//删除request范围内的属性时触发该方法
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		ServletRequest request = srae.getServletRequest();
		//获取添加的属性名和属性值
		String name = srae.getName();
		Object value = srae.getValue();
		System.out.println(request + "范围内删除了名为：" + name +"的属性，值为：" + value);
	}
	//修改request范围内的属性时触发该方法
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		ServletRequest request = srae.getServletRequest();
		//获取添加的属性名和属性值
		String name = srae.getName();
		Object value = srae.getValue();
		System.out.println(request + "范围内修改了名为：" + name +"的属性，值为：" + value);
	}
	//用户请求结束，被销毁时触发该方法
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		System.out.println("发向----" + request.getRequestURI() + "的请求被销毁");
	}
	//初始化用户请求时，触发该方法
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		System.out.println("发向----" + request.getRequestURI() + "的请求被初始化");
	}
}

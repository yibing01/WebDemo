package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
/**
 * application范围内的属性监听
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017年2月6日 下午4:11:34
 */
@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
	private ServletContext application;
	//向application范围内添加属性时触发该方法
	@Override
	public void attributeAdded(ServletContextAttributeEvent sce) {
		application = sce.getServletContext();
		//获取添加的属性名和属性值
		String name = sce.getName();
		Object value = sce.getValue();
		System.out.println(application + "范围内添加的属性名为：" + name +"值为：" + value);
	}
	//从application范围内删除属性时触发该方法
	@Override
	public void attributeRemoved(ServletContextAttributeEvent sce) {
		application = sce.getServletContext();
		//获取添删除的属性名和属性值
		String name = sce.getName();
		Object value = sce.getValue();
		System.out.println(application + "范围内删除的属性名为：" + name +"值为：" + value);
	}
	//替换application范围内的属性时触发该方法法
	@Override
	public void attributeReplaced(ServletContextAttributeEvent sce) {
		application = sce.getServletContext();
		//获取修改的属性名和属性值
		String name = sce.getName();
		Object value = sce.getValue();
		System.out.println(application + "范围内修改的属性名为：" + name +"值为：" + value);
	}
}

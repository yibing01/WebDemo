package listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.jws.soap.InitParam;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebListener;
/**
 * 获取数据库连接的监听器
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017年2月6日 下午3:43:45
 */
@WebListener
public class GetConnectionListener implements ServletContextListener {
	//应用销毁时调用方法
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//获取应用的ServletContext实例
		ServletContext application = sce.getServletContext();
		Connection connection = (Connection) application.getAttribute("application");
		//关闭数据库连接
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//应用启动时调用方法
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//获取该应用的ServletContext实例
		ServletContext application = sce.getServletContext();
		//从配置参数中获取参数
		String driver = application.getInitParameter("driver");
		String url = application.getInitParameter("url");
		String username = application.getInitParameter("username");
		String password = application.getInitParameter("password");
		try {
			//注册驱动
			Class.forName(driver);
			//获取数据库连接
			Connection connection = DriverManager.getConnection(url, username, password);
			//将数据库连接设置为applicatin范围内的属性
			application.setAttribute("connection", connection);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

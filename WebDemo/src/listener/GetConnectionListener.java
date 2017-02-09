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
 * ��ȡ���ݿ����ӵļ�����
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017��2��6�� ����3:43:45
 */
@WebListener
public class GetConnectionListener implements ServletContextListener {
	//Ӧ������ʱ���÷���
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//��ȡӦ�õ�ServletContextʵ��
		ServletContext application = sce.getServletContext();
		Connection connection = (Connection) application.getAttribute("application");
		//�ر����ݿ�����
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//Ӧ������ʱ���÷���
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//��ȡ��Ӧ�õ�ServletContextʵ��
		ServletContext application = sce.getServletContext();
		//�����ò����л�ȡ����
		String driver = application.getInitParameter("driver");
		String url = application.getInitParameter("url");
		String username = application.getInitParameter("username");
		String password = application.getInitParameter("password");
		try {
			//ע������
			Class.forName(driver);
			//��ȡ���ݿ�����
			Connection connection = DriverManager.getConnection(url, username, password);
			//�����ݿ���������Ϊapplicatin��Χ�ڵ�����
			application.setAttribute("connection", connection);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

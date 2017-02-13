package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.swing.Timer;

import dao.DbDao;
@WebListener
public class OnlineListener1 implements ServletContextListener {
	//����һ��ʱ��û�з��ʼ���Ϊ�û�������
	private final int MAX_MILLIS = 10 * 60 * 1000;
	//Ӧ������ʱ�����÷���
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//ÿ��5����һ��
		new Timer(5 * 1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DbDao dao = new DbDao("oracle.jdbc.driver.OracleDriver",
							"jdbc:oracle:thin:@localhost:1521:oracle",
							"system","admin");
					ResultSet rs = dao.query("select sessionID,username,ip,pager,timer from SCOTT.online_info");
					StringBuffer beRemove = new StringBuffer("(");
					while (rs.next()) {
						//��������ϴη���ʱ�䳬����ָ��ʱ��
						if(System.currentTimeMillis() - rs.getLong(5) > MAX_MILLIS){
							//����Ҫ��ɾ����sessionId��ӽ���
							beRemove.append("'");
							beRemove.append(rs.getString(1));
							beRemove.append("',");
						}
					}
					//����Ҫɾ���ļ�¼
					if(beRemove.length() > 3){
						beRemove.setLength(beRemove.length() - 3);
						beRemove.append("')");
						dao.modify("delete from SCOTT.online_info where sessionId in " + beRemove.toString());
					}
					dao.closeConnection();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		}).start();;
	}
	//
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}
}

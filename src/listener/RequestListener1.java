package listener;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DbDao;
@WebListener
public class RequestListener1 implements ServletRequestListener {
	//�û����󵽴����ʼ��ʱ�����÷���
	@Override
	public void requestInitialized(ServletRequestEvent sRequestEvent) {
		HttpServletRequest request = (HttpServletRequest) sRequestEvent.getServletRequest();
		HttpSession session = request.getSession();
		//��ȡsessionId
		String sessionId = session.getId();
		//��ȡ���ʵ�IP�����ڷ��ʵ�ҳ��
		String ip = request.getRemoteAddr();
		String page = request.getRequestURI();
		String user = (String) session.getAttribute("user");
		//δ��¼ʱ�����û������οʹ���
		user = (user == null) ? "�ο�" : user;
		
		;
		try {
			DbDao dao = new DbDao("oracle.jdbc.driver.OracleDriver", 
					"jdbc:oracle:thin:@localhost:1521:oracle", 
					"system", "admin");
			ResultSet rs = dao.query("select * from SCOTT.online_info where sessionId = ?",sessionId);
			//������û���Ӧ��sessionId���ڣ������ǾɵĻỰ
			if(rs.next()){
				//���¼�¼
				rs.updateString(4, page);
				rs.updateLong(5, System.currentTimeMillis());
				rs.updateRow();
				rs.close();
				System.out.println("�Ѹ��£�");
			}else {
				//�����û���������Ϣ
				System.out.println("׼����������");
				dao.insert("insert into SCOTT.online_info values (?,?,?,?,?)",
						sessionId,user,ip,page,System.currentTimeMillis());
				System.out.println("�����������");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//���û����������������ʱ�����÷���
	@Override
	public void requestDestroyed(ServletRequestEvent sRequestEvent) {
		System.out.println("�û��������");
	}
}

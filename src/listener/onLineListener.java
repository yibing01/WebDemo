package listener;

import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class onLineListener implements HttpSessionListener {
	//�û��������֮�俪ʼsession�����÷���
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext application = session.getServletContext();
		//��ȡsessionID
		String sessionID = session.getId();
		//�����һ���µĻػ�
		if(session.isNew()){
			String user = (String) session.getAttribute("user");
			//δ��½�û����οʹ���
			user = (user == null) ? "�ο�" : user;
			@SuppressWarnings("unchecked")
			Map<String,String> online = (Map<String, String>) application.getAttribute("online");
			if(online == null){
				online = new Hashtable<String,String>();
			}
			//���û�������Ϣ����map��
			online.put(sessionID, user);
			application.setAttribute("online", online);
		}
	}
	//���û��������֮���session�Ͽ�ʱ�����÷���
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext application = session.getServletContext();
		String sessionId = session.getId();
		@SuppressWarnings("unchecked")
		Map<String,String> online = (Map<String, String>) application.getAttribute("online");
		if(online != null){
			//ɾ�����û���������Ϣ
			online.remove(sessionId);
		}
		application.setAttribute("online", online);
	}
}

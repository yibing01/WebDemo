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
	//用户与服务器之间开始session触发该方法
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext application = session.getServletContext();
		//获取sessionID
		String sessionID = session.getId();
		//如果是一次新的回话
		if(session.isNew()){
			String user = (String) session.getAttribute("user");
			//未登陆用户当游客处理
			user = (user == null) ? "游客" : user;
			@SuppressWarnings("unchecked")
			Map<String,String> online = (Map<String, String>) application.getAttribute("online");
			if(online == null){
				online = new Hashtable<String,String>();
			}
			//将用户在线信息放在map中
			online.put(sessionID, user);
			application.setAttribute("online", online);
		}
	}
	//当用户与服务器之间的session断开时触发该方法
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext application = session.getServletContext();
		String sessionId = session.getId();
		@SuppressWarnings("unchecked")
		Map<String,String> online = (Map<String, String>) application.getAttribute("online");
		if(online != null){
			//删除该用户的在线信息
			online.remove(sessionId);
		}
		application.setAttribute("online", online);
	}
}

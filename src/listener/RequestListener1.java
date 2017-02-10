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
	//用户请求到达、被初始化时触发该方法
	@Override
	public void requestInitialized(ServletRequestEvent sRequestEvent) {
		HttpServletRequest request = (HttpServletRequest) sRequestEvent.getServletRequest();
		HttpSession session = request.getSession();
		//获取sessionId
		String sessionId = session.getId();
		//获取访问的IP和正在访问的页面
		String ip = request.getRemoteAddr();
		String page = request.getRequestURI();
		String user = (String) session.getAttribute("user");
		//未登录时，将用户当做游客处理
		user = (user == null) ? "游客" : user;
		
		;
		try {
			DbDao dao = new DbDao("oracle.jdbc.driver.OracleDriver", 
					"jdbc:oracle:thin:@localhost:1521:oracle", 
					"system", "admin");
			ResultSet rs = dao.query("select * from SCOTT.online_info where sessionId = ?",sessionId);
			//如果该用户对应的sessionId存在，表明是旧的会话
			if(rs.next()){
				//更新记录
				rs.updateString(4, page);
				rs.updateLong(5, System.currentTimeMillis());
				rs.updateRow();
				rs.close();
				System.out.println("已更新！");
			}else {
				//插入用户的在线信息
				System.out.println("准备插入数据");
				dao.insert("insert into SCOTT.online_info values (?,?,?,?,?)",
						sessionId,user,ip,page,System.currentTimeMillis());
				System.out.println("插入数据完成");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//当用户请求结束，被销毁时触发该方法
	@Override
	public void requestDestroyed(ServletRequestEvent sRequestEvent) {
		System.out.println("用户请求结束");
	}
}

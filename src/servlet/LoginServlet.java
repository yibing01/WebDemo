package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbDao;
@WebServlet(name="login",urlPatterns="/login")
public class LoginServlet extends HttpServlet {
	//响应客户端请求的方法
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorMsg="";
		//Servlet本身并不输出响应到客户端，因此必须将请求转发
		RequestDispatcher rd;
		//获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			//Servlet本身不执行任何的业务逻辑处理，调用JavaBean处理用户请求
			DbDao dao = new DbDao("oracle.jdbc.driver.OracleDriver",
					"jdbc:oracle:thin:@localhost:1521:oracle",
					"system","admin");
			//查询结果集
			ResultSet rs = dao.query("select username,password from scott.usertable where username = ?", username);
			if(rs.next()){
				//用户名和密码匹配
				if(rs.getString("password").equals(password)){
					//获取session对象
					HttpSession session = request.getSession(true);
					//设置session属性跟踪用户回话状态
					session.setAttribute("name", username);
					//获取转发对象
					rd = request.getRequestDispatcher("/welcome.jsp");
					//转发请求
					rd.forward(request, response);
					return;
				}else{
					//用户名和密码不匹配
					errorMsg += "您的用户名和密码不匹配，请重新输入";
				}
			}else{
				//用户名不存在
				errorMsg += "您的用户名不存在，请先注册！";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//如果出错转发至重新登陆
		if(errorMsg != null  && !errorMsg.equals("")){
			rd = request.getRequestDispatcher("/logins.jsp");
			request.setAttribute("error", errorMsg);
			rd.forward(request, response);
			return;
		}
	}
}

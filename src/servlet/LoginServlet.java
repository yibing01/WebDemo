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
	//��Ӧ�ͻ�������ķ���
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorMsg="";
		//Servlet�����������Ӧ���ͻ��ˣ���˱��뽫����ת��
		RequestDispatcher rd;
		//��ȡ�������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			//Servlet����ִ���κε�ҵ���߼���������JavaBean�����û�����
			DbDao dao = new DbDao("oracle.jdbc.driver.OracleDriver",
					"jdbc:oracle:thin:@localhost:1521:oracle",
					"system","admin");
			//��ѯ�����
			ResultSet rs = dao.query("select username,password from scott.usertable where username = ?", username);
			if(rs.next()){
				//�û���������ƥ��
				if(rs.getString("password").equals(password)){
					//��ȡsession����
					HttpSession session = request.getSession(true);
					//����session���Ը����û��ػ�״̬
					session.setAttribute("name", username);
					//��ȡת������
					rd = request.getRequestDispatcher("/welcome.jsp");
					//ת������
					rd.forward(request, response);
					return;
				}else{
					//�û��������벻ƥ��
					errorMsg += "�����û��������벻ƥ�䣬����������";
				}
			}else{
				//�û���������
				errorMsg += "�����û��������ڣ�����ע�ᣡ";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//�������ת�������µ�½
		if(errorMsg != null  && !errorMsg.equals("")){
			rd = request.getRequestDispatcher("/logins.jsp");
			request.setAttribute("error", errorMsg);
			rd.forward(request, response);
			return;
		}
	}
}

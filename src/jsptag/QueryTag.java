package jsptag;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * ����һ�������Ե��Զ����ǩ
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017��2��4�� ����3:52:41
 */
public class QueryTag extends SimpleTagSupport {
	//�����ǩ������
	private String driver;
	private String url;
	private String username;
	private String password;
	private String sql;
	//ִ�����ݿ���ʵĶ���
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private ResultSetMetaData rsmd = null;
	//��ǩ���Ե�getter��setter����
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passsword) {
		this.password = passsword;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	//��дdoTag()����
	@Override
	public void doTag() throws JspException, IOException {
		
		try {
			//ע������
			Class.forName(driver);
			//��ȡ���ݿ�����
			connection = DriverManager.getConnection(url,username,password);
			//����Statement����
			stmt = connection.createStatement();
			//ִ�в�ѯ
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			//��ȡ����
			int columnCount = rsmd.getColumnCount();
			//��ȡҳ�������
			Writer out = getJspContext().getOut();
			//��ҳ��������
			out.write("<table border='1' bgColor='#9999cc' width='400'>");
			//���������
			while(rs.next()){
				out.write("<tr>");
				//���������ѯ��������
				for(int i = 1; i <= columnCount; i++){
					out.write("<td>");
					out.write(rs.getString(i));
					out.write("</td>");
				}
				out.write("</tr>");
			}
			out.write("</table>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new JspException("�Զ����ǩ����" + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new JspException("�Զ����ǩ����" + e.getMessage());
		}finally{
			//�رս����
			try {
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(connection != null){
					connection.close();
				}
			} catch (SQLException e) {
					e.printStackTrace();
			}
			
		}
		
	}
}

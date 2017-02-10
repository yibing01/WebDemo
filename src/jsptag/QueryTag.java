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
 * 定义一个带属性的自定义标签
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017年2月4日 下午3:52:41
 */
public class QueryTag extends SimpleTagSupport {
	//定义标签的属性
	private String driver;
	private String url;
	private String username;
	private String password;
	private String sql;
	//执行数据库访问的对象
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private ResultSetMetaData rsmd = null;
	//标签属性的getter和setter属性
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
	//重写doTag()方法
	@Override
	public void doTag() throws JspException, IOException {
		
		try {
			//注册驱动
			Class.forName(driver);
			//获取数据库连接
			connection = DriverManager.getConnection(url,username,password);
			//创建Statement对象
			stmt = connection.createStatement();
			//执行查询
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			//获取列数
			int columnCount = rsmd.getColumnCount();
			//获取页面输出流
			Writer out = getJspContext().getOut();
			//在页面输出表格
			out.write("<table border='1' bgColor='#9999cc' width='400'>");
			//遍历结果集
			while(rs.next()){
				out.write("<tr>");
				//逐列输出查询到的数据
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
			throw new JspException("自定义标签错误" + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new JspException("自定义标签错误" + e.getMessage());
		}finally{
			//关闭结果集
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

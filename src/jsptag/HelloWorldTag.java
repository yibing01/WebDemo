package jsptag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloWorldTag extends SimpleTagSupport {
	//重写doTag()方法，该方法在标签结束生成页面内容
	@Override
	public void doTag() throws JspException, IOException {
		//获取页面输出流并输出字符串
		getJspContext().getOut().write("HelloWorld" + new Date());
	}
}

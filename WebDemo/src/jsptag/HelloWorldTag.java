package jsptag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloWorldTag extends SimpleTagSupport {
	//��дdoTag()�������÷����ڱ�ǩ��������ҳ������
	@Override
	public void doTag() throws JspException, IOException {
		//��ȡҳ�������������ַ���
		getJspContext().getOut().write("HelloWorld" + new Date());
	}
}

package jsptag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * ��̬���Ա�ǩ��ʵ����
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017��2��6�� ����11:23:55
 */
public class DynamicAttributesTag extends SimpleTagSupport implements DynamicAttributes {
	//�����������ļ���
	private ArrayList<String> keys = new ArrayList<String>();
	//��������ֵ�ļ���
	private ArrayList<Object> values = new ArrayList<Object>();
	//��дdoTag()
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		//�˴�ֻ�Ǽ򵥵����ÿ������
		out.println("<ol>");
		for(int i = 0; i < keys.size(); i++){
			String key = keys.get(i);
			Object value = values.get(i);
			out.println("<li>" + key + "=" + value + "</li>");
		}
		out.print("</ol>");
	}
	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		//���������
		keys.add(localName);
		//�������ֵ
		values.add(value);
	}

}

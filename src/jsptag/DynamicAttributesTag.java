package jsptag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 动态属性标签的实现类
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017年2月6日 上午11:23:55
 */
public class DynamicAttributesTag extends SimpleTagSupport implements DynamicAttributes {
	//保存属性名的集合
	private ArrayList<String> keys = new ArrayList<String>();
	//保存属性值的集合
	private ArrayList<Object> values = new ArrayList<Object>();
	//重写doTag()
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		//此处只是简单地输出每个属性
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
		//添加属性名
		keys.add(localName);
		//添加属性值
		values.add(value);
	}

}

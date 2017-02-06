package jsptag;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * ����һ�����б�ǩ��ı�ǩ
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017��2��4�� ����3:59:28
 */
public class IteratorTag extends SimpleTagSupport {
	//��ǩ���ԣ�����ָ����Ҫ�������ļ���
	private String collection;
	//��ǩ���ԣ�ָ����������Ԫ�أ�Ϊ����Ԫ��ָ������
	private String item;
	//��ǩ���Ե�getter��setter����
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	//��дdoTag()����ʵ�ֱ�ǩ�Ĵ�����
	@Override
	public void doTag() throws JspException, IOException {
		//��page scope�л�ȡ������Ϊcollection�ļ���
		Collection itemList = (Collection) getJspContext().getAttribute(collection);
		//��������
		for(Object s : itemList){
			//�����ϵ�Ԫ�����õ�page��Χ
			getJspContext().setAttribute(item, s);
			//�����ǩ��
			getJspBody().invoke(null);
		}
	}
}

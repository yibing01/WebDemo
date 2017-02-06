package jsptag;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 创建一个带有标签体的标签
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017年2月4日 下午3:59:28
 */
public class IteratorTag extends SimpleTagSupport {
	//标签属性，用于指定需要被迭代的集合
	private String collection;
	//标签属性，指定迭代集合元素，为集合元素指定名称
	private String item;
	//标签属性的getter和setter方法
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
	//重写doTag()方法实现标签的处理方法
	@Override
	public void doTag() throws JspException, IOException {
		//从page scope中获取属性名为collection的集合
		Collection itemList = (Collection) getJspContext().getAttribute(collection);
		//遍历集合
		for(Object s : itemList){
			//将集合的元素设置到page范围
			getJspContext().setAttribute(item, s);
			//输出标签体
			getJspBody().invoke(null);
		}
	}
}

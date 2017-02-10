package jsptag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 可使用页面片段作为属性的标签
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017年2月6日 上午11:21:21
 */
public class FragmentTag extends SimpleTagSupport {
	private JspFragment fragment;
	//属性的getter和setter方法
	public JspFragment getFragment() {
		return fragment;
	}

	public void setFragment(JspFragment fragment) {
		this.fragment = fragment;
	}
	//重写doTag()
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<div style='padding:10px;border:1px solid black'>");
		out.println("<h3>下面是传入的动态jsp片段</h3>");
		//调用输出页面片段
		fragment.invoke( null );
		out.println("</div>");
	}
	
}

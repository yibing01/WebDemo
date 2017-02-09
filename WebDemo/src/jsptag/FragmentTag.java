package jsptag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * ��ʹ��ҳ��Ƭ����Ϊ���Եı�ǩ
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017��2��6�� ����11:21:21
 */
public class FragmentTag extends SimpleTagSupport {
	private JspFragment fragment;
	//���Ե�getter��setter����
	public JspFragment getFragment() {
		return fragment;
	}

	public void setFragment(JspFragment fragment) {
		this.fragment = fragment;
	}
	//��дdoTag()
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<div style='padding:10px;border:1px solid black'>");
		out.println("<h3>�����Ǵ���Ķ�̬jspƬ��</h3>");
		//�������ҳ��Ƭ��
		fragment.invoke( null );
		out.println("</div>");
	}
	
}

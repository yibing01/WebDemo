package listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
/**
 * �û��������
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017��2��6�� ����4:40:52
 */
public class RequestListener implements ServletRequestListener, ServletRequestAttributeListener {
	//��request��Χ���������ʱ�����÷�����
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		ServletRequest request = srae.getServletRequest();
		//��ȡ��ӵ�������������ֵ
		String name = srae.getName();
		Object value = srae.getValue();
		System.out.println(request + "��Χ���������Ϊ��" + name +"�����ԣ�ֵΪ��" + value);
	}
	//ɾ��request��Χ�ڵ�����ʱ�����÷���
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		ServletRequest request = srae.getServletRequest();
		//��ȡ��ӵ�������������ֵ
		String name = srae.getName();
		Object value = srae.getValue();
		System.out.println(request + "��Χ��ɾ������Ϊ��" + name +"�����ԣ�ֵΪ��" + value);
	}
	//�޸�request��Χ�ڵ�����ʱ�����÷���
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		ServletRequest request = srae.getServletRequest();
		//��ȡ��ӵ�������������ֵ
		String name = srae.getName();
		Object value = srae.getValue();
		System.out.println(request + "��Χ���޸�����Ϊ��" + name +"�����ԣ�ֵΪ��" + value);
	}
	//�û����������������ʱ�����÷���
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		System.out.println("����----" + request.getRequestURI() + "����������");
	}
	//��ʼ���û�����ʱ�������÷���
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		System.out.println("����----" + request.getRequestURI() + "�����󱻳�ʼ��");
	}
}

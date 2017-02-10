package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
/**
 * application��Χ�ڵ����Լ���
 * @author yibing
 * @email  yibing.zn@gmail.com
 * 2017��2��6�� ����4:11:34
 */
@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
	private ServletContext application;
	//��application��Χ���������ʱ�����÷���
	@Override
	public void attributeAdded(ServletContextAttributeEvent sce) {
		application = sce.getServletContext();
		//��ȡ��ӵ�������������ֵ
		String name = sce.getName();
		Object value = sce.getValue();
		System.out.println(application + "��Χ����ӵ�������Ϊ��" + name +"ֵΪ��" + value);
	}
	//��application��Χ��ɾ������ʱ�����÷���
	@Override
	public void attributeRemoved(ServletContextAttributeEvent sce) {
		application = sce.getServletContext();
		//��ȡ��ɾ����������������ֵ
		String name = sce.getName();
		Object value = sce.getValue();
		System.out.println(application + "��Χ��ɾ����������Ϊ��" + name +"ֵΪ��" + value);
	}
	//�滻application��Χ�ڵ�����ʱ�����÷�����
	@Override
	public void attributeReplaced(ServletContextAttributeEvent sce) {
		application = sce.getServletContext();
		//��ȡ�޸ĵ�������������ֵ
		String name = sce.getName();
		Object value = sce.getValue();
		System.out.println(application + "��Χ���޸ĵ�������Ϊ��" + name +"ֵΪ��" + value);
	}
}

package ex;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;


/**
* @author yibing 
* @E-mail:yibingzn@qq.com
* @version ����ʱ�䣺2017��2��14�� ����10:41:59
* ��˵��
*/
public class Executor implements Runnable {
	
	private AsyncContext asyncContext = null;
	public Executor(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}
	@Override
	public void run() {
		
		try {
			//�ȴ�5������ģ��ҵ�񷽷���ִ��
			Thread.sleep(5 * 1000);
			ServletRequest request = asyncContext.getRequest();
			List<String> books = new ArrayList<String>();
			books.add("���java����");
			books.add("����JavaEE��ҵӦ��ʵս");
			books.add("���xml����");
			request.setAttribute("books", books);
			asyncContext.dispatch("/async.jsp");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

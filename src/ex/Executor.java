package ex;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;


/**
* @author yibing 
* @E-mail:yibingzn@qq.com
* @version 创建时间：2017年2月14日 上午10:41:59
* 类说明
*/
public class Executor implements Runnable {
	
	private AsyncContext asyncContext = null;
	public Executor(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}
	@Override
	public void run() {
		
		try {
			//等待5秒钟以模拟业务方法的执行
			Thread.sleep(5 * 1000);
			ServletRequest request = asyncContext.getRequest();
			List<String> books = new ArrayList<String>();
			books.add("疯狂java讲义");
			books.add("经典JavaEE企业应用实战");
			books.add("疯狂xml讲义");
			request.setAttribute("books", books);
			asyncContext.dispatch("/async.jsp");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

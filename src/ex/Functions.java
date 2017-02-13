package ex;

/**
 * 函数处理类
 * @author yibing
 * 2017年2月13日 下午5:12:51
 */
public class Functions {
	//对字符串进行反转
	public static String reverse(String text){
		return new StringBuffer(text).reverse().toString();
	}
	//统计字符串中的字符个数
	public static int countChar(String text){
		return text.length();
	}
}

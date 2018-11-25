package stack.application;

import stack.Stack;
import stack.impl.StackSLinked;

/**
 * 实现十进制数到八进制数的转换
 * @author Administrator
 *
 */
public class BaseConversion {
	
	/**
	 * 	实现十进制数到八进制数的转换
	 * @param i	十进制正整数i
	 * 	打印相应八进制数
	 */
	public static void baseConversion(int i) {
		Stack s = new StackSLinked();
		while(i > 0) {
			s.push(i % 8);
			i = i / 8;
		}
		while(!s.isEmpty()) {
			System.out.print(s.pop());
		}
	}
	
	public static void main(String[] args) {
		baseConversion(100);
	}
}

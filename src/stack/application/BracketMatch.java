package stack.application;

import stack.Stack;
import stack.impl.StackSLinked;

/**
 * 	括号匹配检测
 * @author Administrator
 *
 */
public class BracketMatch {
	/**
	 * 括号匹配检测
	 * @param str
	 * @return
	 */
	public boolean bracketMatch(String str) {
		Stack s = new StackSLinked();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch(c) {
				case '{':
				case '[':
				case '(':
					s.push(Integer.valueOf(c));
					break;
				case '}':
					if(!s.isEmpty() && ((Integer)s.pop()).intValue() == '{') {
						break;
					}else {
						return false;
					}
				case ']':
					if(!s.isEmpty() && ((Integer)s.pop()).intValue() == '[') {
						break;
					}else {
						return false;
					}
				case ')':
					if(!s.isEmpty() && ((Integer)s.pop()).intValue() == '(') {
						break;
					}else {
						return false;
					}
				}
			}
		
		if(s.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
}

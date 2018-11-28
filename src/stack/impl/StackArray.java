package stack.impl;

import exception.StackEmptyException;
import stack.Stack;

/**
 * Stack的顺序存储实现
 * @author hzp
 *
 */
public class StackArray implements Stack{
	/**
	 * 数组的默认大小
	 */
	private final int LEN = 8;
	/**
	 * 数据元素数组
	 */
	private Object[] elements;
	/**
	 * 栈顶指针
	 */
	private int top;
	
	public StackArray() {
		top = -1;
		elements = new Object[LEN];
	}
	
	/**
	 * 返回堆栈的大小
	 * @return
	 */
	public int getSize() {
		return top + 1;
	}
	
	/**
	 * 判断堆栈是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return top < 0;
	}

	@Override
	public void push(Object e) {
		if(getSize() >= elements.length) {
			expandSpace();
		}
		elements[++top] = e;
	}

	private void expandSpace() {
		Object[] a = new Object[elements.length * 2];
		for(int i = 0; i < elements.length; i++) {
			a[i] = elements[i];
		}
		elements = a;
	}

	@Override
	public Object pop() throws StackEmptyException {
		if(getSize() < 1) {
			throw new StackEmptyException("错误，堆栈为空");
		}
		Object obj = elements[top];
		elements[top--] = null;
		return obj;
	}
	
	

	@Override
	public Object peek() throws StackEmptyException {
		if(getSize() < 1) {
			throw new StackEmptyException("错误，堆栈为空。");
		}
		return elements[top];
	}
	
	
	
}

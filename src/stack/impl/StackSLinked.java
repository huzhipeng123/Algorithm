package stack.impl;

import exception.StackEmptyException;
import node.SLNode;
import stack.Stack;
/**
 * Stack的链式存储实现
 * @author hzp
 *
 */
public class StackSLinked implements Stack {

	/**
	 * 链表首结点引用
	 */
	private SLNode top;
	
	/**
	 * 栈的大小
	 */
	private int size;
	
	public StackSLinked() {
		top = null;
		size = 0;
	}
	
	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void push(Object e) {
		SLNode q = new SLNode(e, top);
		top = q;
		size++;
	}

	@Override
	public Object pop() throws StackEmptyException {
		if(size < 1) {
			throw new StackEmptyException("错误，堆栈为空");
		}
		Object obj = top.getData();
		top = top.getNext();
		size--;
		return obj;
	}

	@Override
	public Object peek() throws StackEmptyException {
		if(size < 1) {
			throw new StackEmptyException("错误，堆栈为空。");
		}
		return top.getData();
	}

}

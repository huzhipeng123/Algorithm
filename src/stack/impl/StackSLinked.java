package stack.impl;

import exception.StackEmptyException;
import node.SLNode;
import stack.Stack;
/**
 * Stack����ʽ�洢ʵ��
 * @author hzp
 *
 */
public class StackSLinked implements Stack {

	/**
	 * �����׽������
	 */
	private SLNode top;
	
	/**
	 * ջ�Ĵ�С
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
			throw new StackEmptyException("���󣬶�ջΪ��");
		}
		Object obj = top.getData();
		top = top.getNext();
		size--;
		return obj;
	}

	@Override
	public Object peek() throws StackEmptyException {
		if(size < 1) {
			throw new StackEmptyException("���󣬶�ջΪ�ա�");
		}
		return top.getData();
	}

}
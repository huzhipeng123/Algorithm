package iterator.impl;

import exception.OutOfBoundaryException;
import iterator.Iterator;
import list.LinkedList;
import node.Node;

/**
 * LinkedListIterator ���� LinkedList�ۼ�����ĵ�����ʵ��
 * @author hzp
 *
 */
public class LinkedListIterator implements Iterator{
	/**
	 * ���ӱ�
	 */
	private LinkedList list;
	
	/**
	 * ��ǰ���
	 */
	private Node current;

	/**
	 * ���췽��
	 * @param list
	 */
	public LinkedListIterator(LinkedList list) {
		this.list = list;
		//���б�Ϊ��
		if(list.isEmpty()) {	
			//��ǰԪ���ÿ�
			current = null;
		}else {
			//����ӵ�һ��Ԫ�ؿ�ʼ
			current = list.first();
		}
	}
	
	/**
	 * �ƶ�����һ��Ԫ��
	 */
	public void first() {
		//���б�Ϊ��
		if(list.isEmpty()) {
			//��ǰԪ���ÿ�
			current = null;
		}else {
			//����ӵ�һ��Ԫ�ؿ�ʼ
			current = list.first();
		}
	}
	
	/**
	 * �ƶ�����һ��Ԫ��
	 * @throws OutOfBoundaryException
	 */
	public void next() throws OutOfBoundaryException{
		if(isDone()) {
			throw new OutOfBoundaryException("�����Ѿ�û��Ԫ�ء�");
		}
		if(current == list.last()) {
			//��ǰԪ�غ���û�и���Ԫ��
			current = null;
		}else {
			current = list.getNext(current);
		}
	}
	
	/**
	 * ���ص�ǰԪ��
	 * @return
	 */
	public boolean isDone() {
		return current == null;
	}
	
	
	public Object currentItem() throws OutOfBoundaryException{
		if(isDone()) {
			throw new OutOfBoundaryException("�����Ѿ�û��Ԫ�ء�");
		}
		return current.getData();
	}
	
}

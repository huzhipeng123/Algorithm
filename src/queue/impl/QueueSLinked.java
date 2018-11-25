package queue.impl;

import exception.QueueEmptyException;
import node.SLNode;
import queue.Queue;
/**
 * Queue����ʽ�洢ʵ��
 * @author hzp
 *
 */
public class QueueSLinked implements Queue {

	/**
	 * ���׽��
	 */
	private SLNode front;
	
	/**
	 * ��β���
	 */
	private SLNode rear;
	
	/**
	 * ���д�С
	 */
	private int size;
	
	public QueueSLinked() {
		front = new SLNode();
		rear = front;
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
	public void enqueue(Object e) {
		SLNode p = new SLNode(e, null);
		rear.setNext(p);
		rear = p;
		size++;
	}

	@Override
	public Object dequeue() throws QueueEmptyException {
		if(size < 1) {
			throw new QueueEmptyException("���󣺶���Ϊ��");
		}
		SLNode p = front.getNext();
		front.setNext(p.getNext());
		size--;
		//�������Ϊ�գ�rearָ��ͷ���
		if(size < 1) {
			rear = front;
		}
		return p.getData();
	}

	@Override
	public Object peek() throws QueueEmptyException {
		if(size < 1) {
			throw new QueueEmptyException("���󣺶���Ϊ��");
		}
		return front.getNext().getData();
	}

}

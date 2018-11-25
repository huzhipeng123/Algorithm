package queue.impl;

import exception.QueueEmptyException;
import queue.Queue;
/**
 * Queue的顺序存储实现
 * @author hzp
 *
 */
public class QueueArray implements Queue{

	/**
	 * 队列默认大小
	 */
	private static final int CAP = 7;
	
	/**
	 * 数据元素数组
	 */
	private Object[] elements;	
	
	/**
	 * 数组的大小elements.length
	 */
	private int capacity;
	
	/**
	 * 队首指针，指向队首
	 */
	private int front;
	
	/**
	 * 队尾指针，指向队尾后一个位置
	 */
	private int rear;
	
	public QueueArray() {
		this(CAP);
	}
	
	public QueueArray(int cap) {
		capacity = cap + 1;
		elements = new Object[capacity];
	}
	
	@Override
	public int getSize() {
		return (rear - front + capacity) % capacity;
	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	@Override
	public void enqueue(Object e) {
		if(getSize() == capacity - 1) {
			expandSpace();
		}
		elements[rear] = e;
		rear = (rear + 1) % capacity;
	}

	/**
	 * 队列的扩容机制
	 */
	private void expandSpace() {
		Object[] a = new Object[elements.length * 2];
		int i = front;
		int j = 0;
		//将从front开始到rear前一个存储单元的元素复制到新数组
		while(i != rear) {
			a[j++] = elements[i];
			i = (i+1) % capacity;
		}
		elements = a;
		capacity = elements.length;
		//设置新的队首，队尾指针
		front = 0;
		rear = j;
	}

	@Override
	public Object dequeue() throws QueueEmptyException {
		if(isEmpty()) {
			throw new QueueEmptyException("错误：队列为空");
		}
		Object obj = elements[front];
		elements[front] = null;
		front = (front + 1) % capacity;
		return obj;
	}

	@Override
	public Object peek() throws QueueEmptyException {
		if(isEmpty()) {
			throw new QueueEmptyException("错误：队列为空");
		}
		return elements[front];
	}

}

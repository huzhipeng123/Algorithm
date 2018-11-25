package queue;

import exception.QueueEmptyException;

/**
 * Queue(����)�ӿ�
 * @author hzp
 *
 */
public interface Queue {
	/**
	 * ���ض��еĴ�С
	 * @return
	 */
	public int getSize();

	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * ����Ԫ��e���
	 * @param e
	 * @return
	 */
	public void enqueue(Object e);
	
	/**
	 * ����Ԫ�س���
	 * @return
	 * @throws QueueEmptyException
	 */
	public Object dequeue() throws QueueEmptyException;
	
	/**
	 * ȡ����Ԫ��
	 * @return
	 * @throws QueueEmptyException
	 */
	public Object peek() throws QueueEmptyException;
	
}

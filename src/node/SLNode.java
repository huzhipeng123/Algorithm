package node;
/**
 * �������㶨��
 * @author hzp
 *
 */
public class SLNode implements Node{
	
	/**
	 * ��������Ԫ��ֵ
	 */
	private Object element;
	
	/**
	 * �����������һ���
	 */
	private SLNode next;
	
	public SLNode() {
		
	}
	
	public SLNode(Object ele, SLNode next) {
		this.element = ele;
		this.next = next;
	}
	
	public SLNode getNext() {
		return next;
	}
	
	public void setNext(SLNode next) {
		this.next = next;
	}

	@Override
	public Object getData() {
		return element;
	}

	@Override
	public void setData(Object obj) {
		element = obj;
	}
}

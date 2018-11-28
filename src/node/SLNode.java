package node;
/**
 * 单链表结点定义
 * @author hzp
 *
 */
public class SLNode implements Node{
	
	/**
	 * 单链表结点元素值
	 */
	private Object element;
	
	/**
	 * 单链表结点的下一结点
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

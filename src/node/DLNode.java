package node;
/**
 * 双向链表结点定义
 * @author hzp
 *
 */
public class DLNode implements Node{
	/**
	 * 数据域
	 */
	private Object element;
	
	/**
	 * 前驱结点
	 */
	private DLNode pre;
	
	/**
	 * 后继结点
	 */
	private DLNode next;

	public DLNode() {
		this(null, null, null);
	}
	
	public DLNode(Object ele, DLNode pre, DLNode next) {
		this.element = ele;
		this.pre = pre;
		this.next = next;
	}
	
	public DLNode getNext() {
		return next;
	}
	
	public void setNext(DLNode next) {
		this.next = next;
	}
	
	public DLNode getPre() {
		return pre;
	}
	
	public void setPre(DLNode pre) {
		this.pre = pre;
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

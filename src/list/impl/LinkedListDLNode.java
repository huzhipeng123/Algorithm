
package list.impl;


import exception.InvalidNodeException;
import exception.OutOfBoundaryException;
import iterator.Iterator;
import iterator.impl.LinkedListIterator;
import list.LinkedList;
import node.DLNode;
import node.Node;
/**
 * 带前驱结点和后继结点的单链表
 * @author Administrator
 *
 */
public class LinkedListDLNode implements LinkedList{
	
	/**
	 * 规模
	 */
	private int size;

	/**
	 * 头结点，哑元结点
	 */
	private DLNode head;
	
	/**
	 * 尾结点，哑元结点
	 */
	private DLNode tail;
	
	public LinkedListDLNode() {
		size = 0;
		//构建只有头尾结点的链表
		head = new DLNode();
		tail = new DLNode();
		head.setNext(tail);
		tail.setPre(head);
	}
	
	/**
	 * 辅助方法，判断结点p是否合法，如合法转换为DLNode
	 * @param p
	 * @return
	 * @throws InvalidNodeException
	 */
	protected DLNode checkPosition(Node p) throws InvalidNodeException{
		if(p == null) {
			throw new InvalidNodeException("错误：p为空。");
		}
		if(p == head) {
			throw new InvalidNodeException("错误：p指向头结点，非法。");
		}
		if(p == tail) {
			throw new InvalidNodeException("错误：p指向尾结点，非法。");
		}
		DLNode node = (DLNode) p;
		return node;
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
	public Node first() throws OutOfBoundaryException {
		if(isEmpty()) {
			throw new OutOfBoundaryException("错误：链接表为空。");
		}
		return head.getNext();
	}

	@Override
	public Node last() throws OutOfBoundaryException {
		if(isEmpty()) {
			throw new OutOfBoundaryException("错误：链接表为空。");
		}
		return tail.getPre();
	}

	@Override
	public Node getNext(Node p) throws InvalidNodeException, OutOfBoundaryException {
		DLNode node = checkPosition(p);
		node = node.getNext();
		if(node == tail) {
			throw new OutOfBoundaryException("错误：已经是链接表尾端。");
		}
		return node;
	}

	@Override
	public Node getPre(Node p) throws InvalidNodeException, OutOfBoundaryException {
		DLNode node = checkPosition(p);
		node = node.getPre();
		if(node == head) {
			throw new OutOfBoundaryException("错误：已经是链接表前端。");
		}
		return node;
	}

	@Override
	public Node insertFirst(Object e) {
		DLNode node = new DLNode(e, head, head.getNext());
		head.getNext().setPre(node);
		head.setNext(node);
		size++;
		return node;
	}

	@Override
	public Node insertLast(Object e) {
		DLNode node = new DLNode(e, tail.getPre(), tail);
		tail.getPre().setNext(node);
		tail.setPre(node);
		size++;
		return node;
	}

	@Override
	public Node insertAfter(Node p, Object e) throws InvalidNodeException {
		DLNode node = checkPosition(p);
		DLNode newNode = new DLNode(e, node, node.getNext());
		node.getNext().setPre(newNode);
		node.setNext(newNode);
		size++;
		return newNode;
	}

	@Override
	public Node insertBefore(Node p, Object e) throws InvalidNodeException {
		DLNode node = checkPosition(p);
		DLNode newNode = new DLNode(e, node, node.getNext());
		node.getPre().setNext(newNode);
		node.setPre(newNode);
		size++;
		return newNode;
	}

	@Override
	public Object remove(Node p) throws InvalidNodeException {
		DLNode node = checkPosition(p);
		Object obj = node.getData();
		node.getPre().setNext(node.getNext());
		node.getNext().setPre(node.getPre());
		size--;
		return obj;
	}

	@Override
	public Object removeFirst() throws InvalidNodeException {
		return remove(head.getNext());
	}

	@Override
	public Object removeLast() throws InvalidNodeException {
		return remove(tail.getPre());
	}

	@Override
	public Object replace(Node p, Object e) throws InvalidNodeException {
		DLNode node = checkPosition(p);
		Object obj = node.getData();
		node.setData(e);
		return obj;
	}

	@Override
	public Iterator elements() {
		return new LinkedListIterator(this);
	}

}

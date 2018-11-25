
package list.impl;


import exception.InvalidNodeException;
import exception.OutOfBoundaryException;
import iterator.Iterator;
import iterator.impl.LinkedListIterator;
import list.LinkedList;
import node.DLNode;
import node.Node;

public class LinkedListDLNode implements LinkedList{
	
	/**
	 * ��ģ
	 */
	private int size;

	/**
	 * ͷ��㣬��Ԫ���
	 */
	private DLNode head;
	
	/**
	 * β��㣬��Ԫ���
	 */
	private DLNode tail;
	
	public LinkedListDLNode() {
		size = 0;
		//����ֻ��ͷβ��������
		head = new DLNode();
		tail = new DLNode();
		head.setNext(tail);
		tail.setPre(head);
	}
	
	/**
	 * �����������жϽ��p�Ƿ�Ϸ�����Ϸ�ת��ΪDLNode
	 * @param p
	 * @return
	 * @throws InvalidNodeException
	 */
	protected DLNode checkPosition(Node p) throws InvalidNodeException{
		if(p == null) {
			throw new InvalidNodeException("����pΪ�ա�");
		}
		if(p == head) {
			throw new InvalidNodeException("����pָ��ͷ��㣬�Ƿ���");
		}
		if(p == tail) {
			throw new InvalidNodeException("����pָ��β��㣬�Ƿ���");
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
			throw new OutOfBoundaryException("�������ӱ�Ϊ�ա�");
		}
		return head.getNext();
	}

	@Override
	public Node last() throws OutOfBoundaryException {
		if(isEmpty()) {
			throw new OutOfBoundaryException("�������ӱ�Ϊ�ա�");
		}
		return tail.getPre();
	}

	@Override
	public Node getNext(Node p) throws InvalidNodeException, OutOfBoundaryException {
		DLNode node = checkPosition(p);
		node = node.getNext();
		if(node == tail) {
			throw new OutOfBoundaryException("�����Ѿ������ӱ�β�ˡ�");
		}
		return node;
	}

	@Override
	public Node getPre(Node p) throws InvalidNodeException, OutOfBoundaryException {
		DLNode node = checkPosition(p);
		node = node.getPre();
		if(node == head) {
			throw new OutOfBoundaryException("�����Ѿ������ӱ�ǰ�ˡ�");
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
package iterator.impl;

import exception.OutOfBoundaryException;
import iterator.Iterator;
import list.LinkedList;
import node.Node;

/**
 * LinkedListIterator 基于 LinkedList聚集对象的迭代器实现
 * @author hzp
 *
 */
public class LinkedListIterator implements Iterator{
	/**
	 * 链接表
	 */
	private LinkedList list;
	
	/**
	 * 当前结点
	 */
	private Node current;

	/**
	 * 构造方法
	 * @param list
	 */
	public LinkedListIterator(LinkedList list) {
		this.list = list;
		//若列表为空
		if(list.isEmpty()) {	
			//则当前元素置空
			current = null;
		}else {
			//否则从第一个元素开始
			current = list.first();
		}
	}
	
	/**
	 * 移动到第一个元素
	 */
	public void first() {
		//若列表为空
		if(list.isEmpty()) {
			//则当前元素置空
			current = null;
		}else {
			//否则从第一个元素开始
			current = list.first();
		}
	}
	
	/**
	 * 移动到下一个元素
	 * @throws OutOfBoundaryException
	 */
	public void next() throws OutOfBoundaryException{
		if(isDone()) {
			throw new OutOfBoundaryException("错误，已经没有元素。");
		}
		if(current == list.last()) {
			//当前元素后面没有更多元素
			current = null;
		}else {
			current = list.getNext(current);
		}
	}
	
	/**
	 * 返回当前元素
	 * @return
	 */
	public boolean isDone() {
		return current == null;
	}
	
	
	public Object currentItem() throws OutOfBoundaryException{
		if(isDone()) {
			throw new OutOfBoundaryException("错误：已经没有元素。");
		}
		return current.getData();
	}
	
}

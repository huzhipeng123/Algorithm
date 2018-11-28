package list.impl;

import exception.OutOfBoundaryException;
import list.List;
import strategy.Strategy;
import strategy.impl.DefaultStrategy;

public class ListArray implements List{

	/**
	 * 数组的默认大小
	 */
	private final int LEN = 8;
	
	/**
	 * 数组元素比较策略
	 */
	private Strategy strategy;
	
	/**
	 * 线性表中数据元素的个数
	 */
	private int size;
	
	/**
	 * 数据元素数组
	 */
	private Object[] elements;
	
	public ListArray() {
		this(new DefaultStrategy());
	}
	
	public ListArray(Strategy strategy) {
		this.strategy = strategy;
		size = 0;
		elements = new Object[LEN];
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
	public boolean contains(Object e) {
		for(int i = 0; i < size; i++) {
			if(strategy.equal(e, elements[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(Object e) {
		for(int i = 0; i < size; i++) {
			if(strategy.equal(e, elements[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void insert(int i, Object e) throws OutOfBoundaryException {
		if(i < 0 || i > size) {
			throw new OutOfBoundaryException("错误，指定的插入序号越界。");
		}
		if(size >= elements.length) {
			expandSpace();
		}
		for(int j = size; j > i; j--) {
			elements[j] = elements[j - 1];
		}
		elements[i] = e;
		size++;
		return;
	}

	/**
	 * 数组空间扩容
	 * 每次执行扩容为原数组大小的二倍
	 */
	private void expandSpace() {
		Object[] a = new Object[elements.length * 2];
		for(int i = 0; i < elements.length; i++) {
			a[i] = elements[i];
		}
		elements = a;
	}

	@Override
	public boolean insertBefore(Object obj, Object e) {
		int i = indexOf(obj);
		if(i < 0) {
			return false;
		}
		insert(i, e);
		return true;
	}

	@Override
	public boolean insertAfter(Object obj, Object e) {
		int i = indexOf(obj);
		if(i < 0) {
			return false;
		}
		insert(i + 1, e);
		return true;
	}

	@Override
	public Object remove(int i) throws OutOfBoundaryException {
		if(i < 0 || i >= size) {
			throw new OutOfBoundaryException("错误，指定的删除序号越界。");
		}
		Object obj = elements[i];
		for(int j = i; j < size - 1; j++) {
			elements[j] = elements[j+1]; 
		}
		elements[--size] = null;
		return obj;
	}

	@Override
	public boolean remove(Object e) {
		int i = indexOf(e);
		if(i < 0) {
			return false;
		}
		remove(i);
		return true;
	}

	@Override
	public Object get(int i) throws OutOfBoundaryException {
		if(i < 0 || i >= size) {
			throw new OutOfBoundaryException("错误，指定的序号越界。");
		}
		return elements[i];
	}

	@Override
	public Object replace(int i, Object e) throws OutOfBoundaryException {
		if(i < 0 || i >= size) {
			throw new OutOfBoundaryException("错误，指定的序号越界。");
		}
		Object obj = elements[i];
		elements[i] = e;
		return obj;
	}

}

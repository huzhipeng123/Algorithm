package list;

import exception.OutOfBoundaryException;

/**
 * 抽象数据类型List
 * @author hzp
 *
 */
public interface List {
	
	/**
	 * 返回线性表的大小，即数据元素的个数
	 * @return
	 */
	public int getSize();

	/**
	 * 如果线性表为空返回true,否则返回false
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * 返回数据元素e在线性表中的序号
	 * @param c
	 * @return
	 */
	public boolean contains(Object c);
	
	
	/**
	 * 返回数据元素e在线性表中i号位置
	 * @param e
	 * @return
	 */
	public int indexOf(Object e);
	
	/**
	 * 将数据元素e插入到线性表中i号位置
	 * @param i
	 * @param e
	 */
	public void insert(int i, Object e) throws OutOfBoundaryException;
	
	/**
	 * 将数据元素e插入到元素obj之前
	 * @param obj
	 * @param e
	 * @return
	 */
	public boolean insertBefore(Object obj, Object e);

	/**
	 * 将数据元素e插入到元素obj之后
	 * @param obj
	 * @param e
	 * @return
	 */
	public boolean insertAfter(Object obj, Object e);

	/**
	 * 删除线性表中序号为i的数据元素e，返回原数据元素
	 * @param i
	 * @return
	 * @throws OutOfBoundaryException
	 */
	public Object remove(int i) throws OutOfBoundaryException;
	
	/**
	 * 删除线性表中第一个与e相同的元素，
	 * @param e
	 * @return
	 */
	public boolean remove(Object e);
	
	/**
	 * 返回线性表中序号为i的数据元素
	 * @param i
	 * @return
	 * @throws OutOfBoundaryException
	 */
	public Object get(int i) throws OutOfBoundaryException;
	
}

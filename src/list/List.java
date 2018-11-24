package list;

import exception.OutOfBoundaryException;

/**
 * ������������List
 * @author hzp
 *
 */
public interface List {
	
	/**
	 * �������Ա�Ĵ�С��������Ԫ�صĸ���
	 * @return
	 */
	public int getSize();

	/**
	 * ������Ա�Ϊ�շ���true,���򷵻�false
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * ��������Ԫ��e�����Ա��е����
	 * @param c
	 * @return
	 */
	public boolean contains(Object c);
	
	
	/**
	 * ��������Ԫ��e�����Ա���i��λ��
	 * @param e
	 * @return
	 */
	public int indexOf(Object e);
	
	/**
	 * ������Ԫ��e���뵽���Ա���i��λ��
	 * @param i
	 * @param e
	 */
	public void insert(int i, Object e) throws OutOfBoundaryException;
	
	/**
	 * ������Ԫ��e���뵽Ԫ��obj֮ǰ
	 * @param obj
	 * @param e
	 * @return
	 */
	public boolean insertBefore(Object obj, Object e);

	/**
	 * ������Ԫ��e���뵽Ԫ��obj֮��
	 * @param obj
	 * @param e
	 * @return
	 */
	public boolean insertAfter(Object obj, Object e);

	/**
	 * ɾ�����Ա������Ϊi������Ԫ��e������ԭ����Ԫ��
	 * @param i
	 * @return
	 * @throws OutOfBoundaryException
	 */
	public Object remove(int i) throws OutOfBoundaryException;
	
	/**
	 * ɾ�����Ա��е�һ����e��ͬ��Ԫ�أ�
	 * @param e
	 * @return
	 */
	public boolean remove(Object e);
	
	/**
	 * �������Ա������Ϊi������Ԫ��
	 * @param i
	 * @return
	 * @throws OutOfBoundaryException
	 */
	public Object get(int i) throws OutOfBoundaryException;
	
}

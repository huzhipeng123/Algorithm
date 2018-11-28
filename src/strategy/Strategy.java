package strategy;
/**
 * 使用Strategy接口实现各种不同数据元素相互之间独立的比较策略
 * @author hzp
 *
 */
public interface Strategy{

	/**
	 * 判断两个数据元素是否相等
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public boolean equal(Object obj1, Object obj2);
	
	/**
	 * 比较两个数据元素的大小
	 * 如果obj1 < obj2, 返回-1
	 * 如果obj1 = obj2, 返回0
	 * 如果obj1 > obj2, 返回1
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public int compare(Object obj1, Object obj2);
	
}

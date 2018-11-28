package exception;
/**
 * 用于作为参数的结点不合法时抛出的异常
 * 结点p在以下情况下可以认为是不合法的
 * p == null;
 * p在链接表中不存在
 * 在调用方法getPre(p)时，p已经是第一个存有数据的结点
 * 在调用方法getNext(p)时，p已经是最后一个存有数据的结点
 * @author hzp
 *
 */
public class InvalidNodeException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8291212228000565329L;

	public InvalidNodeException(String err) {
		super(err);
	}

}

package exception;

/**
 * 队列为空时出队或取队首元素抛出此异常
 * @author hzp
 *
 */
public class QueueEmptyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1941057031637121503L;

	public QueueEmptyException(String err) {
		super(err);
	}
	
	
}

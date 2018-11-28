package exception;
/**
 * 堆栈为空时出栈或去栈顶元素抛出此异常
 * @author hzp
 *
 */
public class StackEmptyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2376004445662126265L;

	public StackEmptyException(String err) {
		super(err);
	}
	
}

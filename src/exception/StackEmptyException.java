package exception;
/**
 * ��ջΪ��ʱ��ջ��ȥջ��Ԫ���׳����쳣
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

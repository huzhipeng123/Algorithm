package exception;
/**
 * ���Ա��г������Խ��ʱ�׳����쳣
 * @author hzp
 *
 */
public class OutOfBoundaryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -796564935800363493L;

	public OutOfBoundaryException(String err) {
		super(err);
	}
}

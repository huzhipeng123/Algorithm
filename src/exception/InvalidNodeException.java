package exception;
/**
 * ������Ϊ�����Ľ�㲻�Ϸ�ʱ�׳����쳣
 * ���p����������¿�����Ϊ�ǲ��Ϸ���
 * p == null;
 * p�����ӱ��в�����
 * �ڵ��÷���getPre(p)ʱ��p�Ѿ��ǵ�һ���������ݵĽ��
 * �ڵ��÷���getNext(p)ʱ��p�Ѿ������һ���������ݵĽ��
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

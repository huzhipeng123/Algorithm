package divide;


/**
 * 查找数组中的第k小元素
 * @author Administrator
 *
 */
public class SelectK {
	
	private int selectK(int[] a, int k) {
		if(a == null || a.length < k) {
			return Integer.MIN_VALUE;
		}
		return quickSort(a, 0, a.length - 1, k);
	}

	private int quickSort(int[] a, int low, int high, int k) {
		//第0个元素作为枢纽
		int i = low;
		int j = high;
		int temp = a[i];
		if(low > high) {
			return Integer.MIN_VALUE;
		}
		//快速排序
		while(i < j) {
			while(i < j && a[j] >= temp) {
				j--;
			}
			if(i <  j) {
				a[i++] = a[j];
			}
			while(i < j && a[i] < temp) {
				i++;
			}
			if(i < j) {
				a[j--] = a[i];
			}
		}
		a[i] = temp;
		if(i + 1 == k) {
			return temp;
		}else if(i + 1 > k) {
			return quickSort(a, low, i -1, k);
		}else {
			return quickSort(a, i+1, high, k);
		}
	}
	
	public static void main(String[] args) {
		SelectK s = new SelectK();
		int[] a = {1,5,2,6,8,0,6};
		System.out.println(s.selectK(a, 4));
	}
}

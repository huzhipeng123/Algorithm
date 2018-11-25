package divide;

import java.util.Arrays;
import java.util.Random;

/**
 * 寻找具有 n 个元素的数组 a[0, n-1]中的最大与最小元素
 * @author Administrator
 *
 */
public class MinMax {
	private class IntPair{
		int max;
		int min;
		public IntPair() {
			
		}
	}
	
	/**
	 * 直接遍历数组，找出最大与最小元素
	 * @param numbers
	 * @return
	 */
	public IntPair simpleMinMax(Integer[] numbers) {
		IntPair pair = new IntPair();
		pair.max = numbers[0];
		pair.min = numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			if(pair.max < numbers[i]) {
				pair.max = numbers[i];
			}
			if(pair.min > numbers[i]) {
				pair.min = numbers[i];
			}
		}
		return pair;
	}
	
	/**
	 * 使用分治法，把数组a分为大小相等的两个数组a1和a2，
	 * 在a1和a2分别找出最大和最小元素
	 * @param numbers2
	 * @param low
	 * @param high
	 * @return
	 */
	public IntPair  min_max(Integer[] numbers2, int low, int high) {
		IntPair pair = new IntPair();
		if(low > high - 2) {
			if(numbers2[low] < numbers2[high]) {
				pair.max = numbers2[high];
				pair.min = numbers2[low];
			}else {
				pair.min = numbers2[high];
				pair.max = numbers2[low];
			}
		}else {
			int mid = (low + high) / 2;
			IntPair p1 = min_max(numbers2, low, mid);
			IntPair p2 = min_max(numbers2, mid+1, high);
			pair.max = p1.max > p2.max ? p1.max : p2.max;
			pair.min = p1.min > p2.min ? p2.min : p1.min;
		}
		return pair;
	}
	
	
	public static void main(String[] args) {
		MinMax mm = new MinMax();
		Random rand = new Random();
		int N = 1000000;
		Integer[] numbers = new Integer[N];
		for(int i = 0; i < N; i++) {
			numbers[i] = rand.nextInt(10*N);
		}
		Integer[] numbers2 = Arrays.copyOf(numbers, N);
		long startTime = System.currentTimeMillis();
		IntPair p1 = mm.simpleMinMax(numbers);
		long endTime = System.currentTimeMillis();
		System.out.println("直接遍历耗费"+(endTime - startTime) +"毫秒,最大值"+p1.max+", 最小值"+p1.min);
		startTime = System.currentTimeMillis();
		IntPair p2 = mm.min_max(numbers2, 0, N - 1);
		endTime = System.currentTimeMillis();
		System.out.println("分治法耗费"+(endTime - startTime) +"毫秒,最大值"+p2.max+", 最小值"+p2.min);
	}
}

package recursive;
/**
 * 编写一个算法输出 n 个布尔量的所有可能组合
 * @author Administrator
 *每个布尔量有真和假两种取值，分别对应 1，0。对于n个布尔量有 2n
 *种组合，每一种均为n位。
 *基本项：如果 n 为 1，则只需要输出 0 和 1 即可。
 *递归项：n个布尔量的 2n种所有不同的组合可以看成是 2*2n-1种组合，其中 2n-1种组合是
n-1 个布尔量的所有组合，每种组合包含n-1 位。这样n个布尔变量的所有组合是在n-1 个布
尔变量的每种组合的基础上加上 1 或 0 而分别得到的结果。
在具体的实现中使用一个数组 b 来存放 n 位组合的每一个分量。
 */
public class Coding {
	public static void coding(int[] b, int n) {
		if(n == 0) {
			b[n] = 0;
			outBn(b);
			b[n] = 1;
			outBn(b);
		}else {
			b[n] = 0;
			coding(b, n-1);
			b[n] = 1;
			coding(b, n-1);
		}
	}

	private static void outBn(int[] b) {
		for(int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
		}
		System.out.println();
	}
}

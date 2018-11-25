package recursive;
/**
 * n 阶汉诺塔问题
 * @author Administrator
 *	n 阶汉诺塔问题可以描述为：假设有 X、Y、Z 三个塔座，初始时有 n 个大小不一的
 *盘子按照从小到大的次序放在塔座 X 上。现在要求将塔座 X 上的所有盘子移动到塔座 Z 上
 *并保持原来的顺序，在移动过程中要满足以下要求：在塔座之间一次只能移动一个盘子并且
 *何时候大盘子都不能放到小盘子上。
 *本项：若只有一个盘子，则不需要使用过渡塔座，直接把它放到目的塔座即可
 *递归项：如果多于一个盘子，则需要将塔座 X 上的 1 到 n-1 个盘子使用 Z 作为过渡塔
 *放到塔座 Y 上，然后将第 n 个盘子（最后一个盘子）放到塔座 Z，最后将塔座 Y 上的 n-1
 *盘子使用塔座 X 作为过渡放到塔座 Z
 */
public class Hanio {
	
	/**
	 * 输出n阶Hanoi塔的移动步骤
	 * @param n
	 * @param x
	 * @param y
	 * @param z
	 */
	public static void hanio(int n, char x, char y, char z) {
		if(n == 1) {
			move(x, n, z);
		}else {
			hanio(n-1, x, z, y);
			move(x, n, z);
			hanio(n-1, y, x, z);
		}
	}

	
	private static void move(char x, int n, char y) {
		System.out.println("Move "+n+" from "+x+" to "+y);
	}
	
	public static void main(String[] args) {
		hanio(4, 'x', 'y', 'z');
	}
}

package com.ccut.offer;

/**
 *
 * 测试
 * 假设是4
 * 假设第一个小矩形竖着放，那么剩下的就是f(3), 
 * 如果第一个小矩形横着放，那么他底下的也必须横着放，方法数则为余下的f(2)
 * 矩阵覆盖问题 设 2*n
 * 的大矩形有F(n)种被覆盖方法。 1）当n = 0时，大矩形为空，显然F(0) = 0； 2）当n = 1时，大矩形与小矩形规格相同，F(1) = 1；
 * 3）当n = 2时，使用2个小矩形可覆盖大矩形，但横竖摆放各有1种方法，故F(2) = 2； 4）当n > 2时，覆盖方法可分为两大类（见下图）：1.先用
 * 2*1 的小矩形覆盖大矩形的第一列，其后 n-1 列则有 F(n - 1)种覆盖方法；2.先用两个 2*1 的小矩形覆盖大矩形的前两列，其后 n-2
 * 列共有F(n - 2)种覆盖方法， 故有递推公式 F(n) = F(n - 1) + F(n - 2)。
 */
public class Problem10 {
	public static void main(String[] args) {
		Problem10 solution06 = new Problem10();
		System.out.println(solution06.RectCover(5));
	}


	/**
	 * 用递归的方法 n
	 * 测试Test
	 * @return 摆法
	 */
	public int RectCover(int target) {
		int sum;
		if (target < 1) {
			return 0;
		} else if (target == 1) {
			return 1;
		} else if (target == 2) {
			return 2;
		} else {
			sum = RectCover(target - 1) + RectCover(target - 2);
			return sum;
		}
	}

	/**
	 * 迭代的方法
	 */
	public int RectCover_2(int target) {
		int a = 1, b = 2, c = 0;
		if (target < 1) {
			return 0;
		} else if (target <= 2) {
			return target;
		} else {
			for (int i = 0; i < target - 2; i++) {
				c = a + b;
				a = b;
				b = c;
			}
			return c;
		}
	}
}
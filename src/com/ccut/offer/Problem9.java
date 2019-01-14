package com.ccut.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * 
 * @author root
 * 
 */
public class Problem9 {
	public static void main(String[] args) {
		Problem9 solution05 = new Problem9();
		System.out.println(solution05.JumpFloorII_2(3));

	}

	/**
	 * 用递归求解 f(n) = f(n-1) + f(n-2) + ... + f(1) f(n-1) = f(n-2) + ... + f(1)
	 * f(n) = 2*f(n-1)
	 * 
	 * @param target
	 *            台阶数
	 * @return 跳法
	 */
	public int JumpFloorII(int target) {
		if (target <= 1) {
			return 1;
		} else if (target <= 2) {
			return 2;
		} else {
			return 2 * JumpFloorII(target - 1);
		}
	}

	/**
	 * 用数学归纳法能够证明：f(n)=2n−1.
	 * 递归式证明： 当n = 1 时， 仅仅有一种跳法，即1阶跳：Fib(1) = 1; 当n = 2 时。
	 * 有两种跳的方式，一阶跳和二阶跳：Fib(2) = Fib(1) + Fib(0) = 2; 当n = 3
	 * 时。有三种跳的方式，第一次跳出一阶后。后面还有Fib(3-1)中跳法。
	 * 第一次跳出二阶后，后面还有Fib(3-2)中跳法；第一次跳出三阶后，后面还有Fib(3-3)中跳法 Fib(3) = Fib(2) +
	 * Fib(1)+Fib(0)=4; 当n = n 时。共同拥有n种跳的方式，第一次跳出一阶后。后面还有Fib(n-1)中跳法；
	 * 第一次跳出二阶后。后面还有Fib(n-2)中跳法……………………..第一次跳出n阶后, 后面还有 Fib(n-n)中跳法. Fib(n) =
	 * Fib
	 * (n-1)+Fib(n-2)+Fib(n-3)+……….+Fib(n-n)=Fib(0)+Fib(1)+Fib(2)+…….+Fib(n-1)
	 * 又由于Fib(n-1)=Fib(0)+Fib(1)+Fib(2)+…….+Fib(n-2)
	 * 两式相减得：Fib(n)-Fib(n-1)=Fib(n-1) =====》 Fib(n) = 2*Fib(n-1) n >= 2
	 * 递归等式例如以下： f(n)=⎧⎩⎨⎪⎪1,2,2∗f(n−1),n=1n=2n>2
	 * 所以：f(n)=2∗f(n−1)=2∗2(n−2)....=2n−1∗f(0)=2n−1 f(n)=2^(n-1)
	 */
	public int JumpFloorII_2(int target) {
		// 通过移位计算2的次方
		return 1 << (target - 1);
	}

}

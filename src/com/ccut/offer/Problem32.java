package com.ccut.offer;
/**
 * 从1到n整数中1出现的次数 
 */
public class Problem32 {
	public int numberOf1BetweenN(int n) {
		int number = 0;
		for (int i = 0; i < n; i++) {
			number += numberOf1(n);
		}
		return number;
	}

	public int numberOf1(int n) {
		int num = 0;
		while (n != 0) {
			if (n % 10 == 1)
				num++;
			// 去掉个位
			n = n / 10;
		}
		return num;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Problem32 problem32=new Problem32();
		System.out.println(problem32.numberOf1BetweenN(100));
	}

}

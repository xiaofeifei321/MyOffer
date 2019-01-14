package com.ccut.offer;

/**
 * 判断是否为丑数
 */
public class Problem34 {
	public boolean isUgly(int number) {
		while (number % 2 == 0)
			number /= 2;
		while (number % 3 == 0)
			number /= 3;
		while (number % 5 == 0)
			number /= 5;
		return number == 1 ? true : false;
	}

	public int getUglyNumber(int index) {
		if (index <= 1)
			return 0;
		if (index==2) {
			return 1;
		}
		int uglyFound = 0;
		for (int i = 2; i <index ; i++) {
			if (isUgly(i)) {
				++uglyFound;
			}
		}
		return uglyFound;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = 6;
		Problem34 problem34 = new Problem34();
		System.out.println(problem34.getUglyNumber(index));
	}

}

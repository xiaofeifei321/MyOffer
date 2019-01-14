package com.ccut.offer;
/**
 * 斐波那契额数列
 * @author root
 *
 */
public class Problem7 {

	public static void main(String[] args) {
        System.out.println(Fibonacci_2(4));
    }
    /**
     * 用递归直接求解
     */
    public static int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 1) {
            return n;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }

    /**
     * 迭代方法，用两个变量记录fn-1和fn-2:
     * @param n 斐波那契数列第n项
     * @return 斐波那契数列第n项的值
     */
    public static int Fibonacci_2(int n) {
        int zero = 0, one = 1, fN = 0;
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            //由zero和one保存中间结果
            for (int i = 2; i <= n; i++) {
                fN = one + zero;
                zero = one;
                one = fN;
            }
            return fN;
        }
    }
}
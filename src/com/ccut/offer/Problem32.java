package com.ccut.offer;

/**
 * 题目：输入一个整数n，求从1到n个整数的十进制表示中1出现的次数。例如输入12，从1到12这些整数中包含1的数字有1，10，11，和12，1一共出现了5次
 * 从1到n整数中1出现的次数
 * 解法1：
 *    判断一个数字中1的个数：我们可以每次通过对10求余数判断整数的个位数字是不是1.如果这个数字大于10，除以10之后再判断个位数字是不是1.
 * 解法2:
 *
 *
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
        Problem32 problem32 = new Problem32();
        System.out.println(problem32.numberOf1BetweenN(100));
    }

}

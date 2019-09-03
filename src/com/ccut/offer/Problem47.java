package com.ccut.offer;

/**
 * 不用加减乘除做加法
 */
public class Problem47 {
    public int add(int num1, int num2) {
        int sum, carry, temp;
        do {
            //异或运输
            sum = num1 ^ num2;
            //
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }

    public static void main(String[] args) {
        Problem47 test = new Problem47();
        System.out.println(test.add(5, 17));
    }
}

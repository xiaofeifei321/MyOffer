package com.ccut.offer;

/**
 * 不用加减乘除做加法
 * 解法一:
 * 用二进制位运算来求和
 *     1：第一步不考虑进位对每一位相加。0+0，1+1的结果都是0，1+0的结果是1。0+1的结果是1，我们注意到这和异或的结果是一样的。对异或而言，0和0，1和1异或的结果是0，而0和1，1和0的结果异或
 *     2：对0+0，0+1，1+0而言，都不会产生进位，只有1+1时，会向前差生一个进位。此时我们可以想象成是两个数先做位运算，然后再向前左移动一位。只有两个数都是1的时候
 *     3:相加的过程是重复前面的两步，直到不产生进位为止。
 *
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

package com.ccut.offer;

/**
 * 求1+2+3+…+n，要求不能使用乘除法、 for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 解法一:
 *   用二进制位运算来求和
 *    1：第一步不考虑进位对每一位相加。0+0，1+1的结果都是0，1+0的结果是1。0+1的结果是1，我们注意到这和异或的结果是一样的。对异或而言，0和0，1和1异或的结果是0，而0和1，1和0的结果异或
 *    2：对0+0，0+1，1+0而言，都不会产生进位，只有1+1时，会向前差生一个进位。此时我们可以想象成是两个数先做位运算，然后再向前左移动一位。只有两个数都是1的时候
 *    3:相加的过程是重复前面的两步，直到不产生进位为止。
 */
public class Problem46 {
    public static void main(String[] args) {
        Problem46 solution46 = new Problem46();
        // System.out.println(solution46.Sum_Solution(3));
        System.out.println(Problem46.add(5,21));
    }

    /**
     * 用异或运算求和
     */
    public static int add(int num1,int num2){
        int sum,carry;
        do{
            sum = num1 ^ num2;
            System.out.println(num1&num2);
            carry = (num1&num2) <<1;
            num1 = sum;
            num2 = carry;
        }while(num2!=0);
        return num1;
    }

    /**
     * 用异常退出递归
     */
    public int Sum_Solution_2(int n) {
        try {
            int i = 1 % n;
            return n + Sum_Solution_2(n - 1);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 1.利用逻辑与的短路特性实现递归终止。
     * 2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
     * 3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
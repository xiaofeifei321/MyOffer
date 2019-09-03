package com.ccut.offer;

/**
 * 求1+2+3+…+n，要求不能使用乘除法、 for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Problem46 {
    public static void main(String[] args) {
        Problem46 solution46 = new Problem46();
        // System.out.println(solution46.Sum_Solution(3));
        System.out.println(solution46.Sum_Solution_2(4));
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
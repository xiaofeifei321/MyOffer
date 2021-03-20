package com.labuladong.shuzu;

import java.util.Arrays;

/**
 * 返回区间 [2, n) 中有几个素数
 */
public class ShushuoSolution {
    int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim(i))
            {
                count++;
                System.out.println("素数是"+i);
            }
        }
        return count;
    }
    //判断整数n是否为素数
    boolean isPrim(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    int countPrimesTwo(int n) {
        boolean[] isPrim = new boolean[n];
        // 将数组都初始化为 true
        Arrays.fill(isPrim, true);

        for (int i = 2; i < n; i++)
            if (isPrim[i]) {
                // i 的倍数不可能是素数了
                for (int j = 2 * i; j < n; j += i){
                    isPrim[j] = false;
                    System.out.println("j="+j);
                }

            }
        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;
        return count;
    }

    public static void main(String[] args) {
        ShushuoSolution shushuoSolution=new ShushuoSolution();
        System.out.println(shushuoSolution.countPrimesTwo(10));
    }
}

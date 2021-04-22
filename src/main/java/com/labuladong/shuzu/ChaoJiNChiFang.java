package com.labuladong.shuzu;

import java.util.Vector;

/**
 * 超级n次方
 * 计算 a的b次方 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出
 * 示例：
 * 输入 a=2，b=[3]
 * 输出 ：8
 * <p>
 * 输入 a=2，b=[1,0]
 * 输出：1024
 */
public class ChaoJiNChiFang {
    int base = 1337;
    int index = 1;

    public int superPow(int a, int[] b) {
        //数组长度
        int l = b.length;
        //递归的base case
        if (index == l) {
            return myPow(a, b[0]);
        }
        int pary1 = superMyPow(a, b[l - index++]);
        int part2 = superMyPow(superPow(a, b), 10);
        //合并结果
        return (pary1 * part2) % base;
    }

    public int myPow(int a, int b) {
        int ans = 1;
        //对因子求模
        a %= base;
        for (int i = 1; i <= b; i++) {
            //这里有乘法，潜在的溢出点
            ans *= a;
            //对乘法结果求模
            ans %= base;
        }
        return ans;
    }

    /**
     * 高效求幂
     *
     * @param
     */

    public int superMyPow(int a, int k) {
        if (k == 0) {
            return 1;
        }
        if (k % 2 == 1) {
            //次数为奇数
            return (a * superMyPow(a, k - 1)) % base;
        } else {
            //次数为偶数
            int sub = superMyPow(a, k / 2);
            return (sub * sub) % base;
        }
    }


    public static void main(String[] args) {
        ChaoJiNChiFang chaoJiNChiFang = new ChaoJiNChiFang();
        int a[] = {1, 0};
        System.out.println(chaoJiNChiFang.superPow(2, a));
    }

}

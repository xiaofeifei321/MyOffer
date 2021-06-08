package com.labuladong.dongtaiguihua;

import java.util.HashMap;
import java.util.Map;

/**
 * 四键盘问题
 * 特殊键盘包含以下几个按键
 * key1 (A):在屏幕上打印一个A
 * Key2(ctrl-A):选中整个屏幕
 * key3(ctrl-C):复制选中的区域到缓存区
 * key4(ctrl-v): 将缓冲区的内容输出道上次输入的结束为止，并且显示在屏幕上
 * <p>
 * <p>
 * <p>
 * 样例 1:
 * 输入: N = 3
 * 输出: 3
 * 解释:
 * 我们最多可以在屏幕上显示三个'A'通过如下顺序按键：
 * A, A, A
 * <p>
 * 样例 2:
 * 输入: N = 7
 * 输出: 9
 * 解释:
 * 我们最多可以在屏幕上显示九个'A'通过如下顺序按键：
 * A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
 */
public class ShiJianPanWenTI {
    Map<int[], Integer> memo = new HashMap();

    public int maxA(int n) {
        if (n <= 1) {
            return n;
        }
        //表示当前屏幕A的个数
        int a_num = 0;
        //表示剪切板中的个数
        int copy = 0;
        return dp(n, a_num, copy);
    }

    private int dp(int n, int a_num, int copy) {
        if (n <= 0) {
            return a_num;
        }
        int[] arrry = new int[]{n, a_num, copy};
        if (memo.containsKey(arrry)) {
            return memo.get(arrry);
        }
        int tmp = Math.max(dp(n - 1, a_num + 1, copy), dp(n - 1, a_num + copy, copy));
        int max = Math.max(tmp, dp(n - 2, a_num, a_num));
        memo.put(arrry, max);
        return max;
    }


    /**
     * 解法二
     *
     * @param
     */

    public int maxA2(int N) {
        if (N <= 1) {
            return N;
        }
        //dp表达再经过i次操作之后，最多显示多少个A
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;//按 A 键
            //全选 & 复制 dp[j-2]，连续粘贴 i - j 次
            for (int j = 2; j < i; j++) {
                //屏幕上共 dp[j - 2] * (i - j + 1) 个 A
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[N];
    }


    public static void main(String[] args) {
        ShiJianPanWenTI shiJianPanWenTI = new ShiJianPanWenTI();
        System.out.println(shiJianPanWenTI.maxA(7));
    }

}

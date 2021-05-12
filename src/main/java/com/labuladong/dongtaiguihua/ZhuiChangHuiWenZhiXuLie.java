package com.labuladong.dongtaiguihua;

/**
 * 最长回文子序列
 * 给定一个字符串S，找到其中最长的回文子序列，可以假设S的最大长度为10000
 * 示例1
 * 输入 bbbab
 * 输出 4
 * 一个可能的最长回文子序列为"bbbb"
 */
public class ZhuiChangHuiWenZhiXuLie {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            //base Case
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                //状态转移方程
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        System.out.println(f);
        return f[0][n - 1];
    }

    public static void main(String[] args) {
        ZhuiChangHuiWenZhiXuLie zhuiChangHuiWenZhiXuLie = new ZhuiChangHuiWenZhiXuLie();
        System.out.println(zhuiChangHuiWenZhiXuLie.longestPalindromeSubseq("cbbd"));
    }

}

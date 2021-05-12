package com.labuladong.dongtaiguihua;

/**
 * �����������
 * ����һ���ַ���S���ҵ�������Ļ��������У����Լ���S����󳤶�Ϊ10000
 * ʾ��1
 * ���� bbbab
 * ��� 4
 * һ�����ܵ������������Ϊ"bbbb"
 */
public class ZhuiChangHuiWenZhiXuLie {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            //base Case
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                //״̬ת�Ʒ���
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

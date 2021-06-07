package com.labuladong.dongtaiguihua;

public class ShiZiYouXi35 {
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        //��ʾʣ�µ�ʯ�Ӷ��±�i���±�jʱ����ǰһ���˺�����һ��������֮������ֵ
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            //��i==j��ʱ��ֻʣ��һ��ʯͷ����ǰ��Цֻ��ȡ�����ʯͷ
            dp[i][i] = piles[i];
        }
        //dp[i][j] ��ʾ�Ӷ��±�Ϊi���±�λjʣ��ʯ�����ջ��ʯ����������
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }

    public static void main(String[] args) {
        //ʯ����Ϸ
        ShiZiYouXi35 shiZiYouXi35 = new ShiZiYouXi35();
        int[] temp = new int[]{
                5, 3, 4, 5
        };
        System.out.println(shiZiYouXi35.stoneGame(temp));
    }
}

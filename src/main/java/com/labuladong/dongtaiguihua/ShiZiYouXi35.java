package com.labuladong.dongtaiguihua;

public class ShiZiYouXi35 {
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        //表示剩下的石子堆下标i到下标j时，当前一个人和另外一个人数量之差的最大值
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            //当i==j的时候，只剩下一堆石头，当前玩笑只能取走这堆石头
            dp[i][i] = piles[i];
        }
        //dp[i][j] 表示从堆下标为i到下标位j剩下石堆中收获的石子数量最大差
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }

    public static void main(String[] args) {
        //石子游戏
        ShiZiYouXi35 shiZiYouXi35 = new ShiZiYouXi35();
        int[] temp = new int[]{
                5, 3, 4, 5
        };
        System.out.println(shiZiYouXi35.stoneGame(temp));
    }
}

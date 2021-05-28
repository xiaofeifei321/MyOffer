package com.labuladong.dongtaiguihua;

import java.util.Arrays;

/**
 * ��С·����
 * ����һ�������Ǹ������� m x n ���� grid �����ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С
 * ���룺grid = [[1,3,1],[1,5,1],[4,2,1]]
 * �����7
 * ���ͣ���Ϊ·�� 1��3��1��1��1 ���ܺ���С
 * leedCode 64��
 */
public class ZhuiXiaoLuJinHe31 {
    int[][] memo;

    public int minParhSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //���챸��¼����ʼֵȫ������Ϊ-1
        System.out.println("m= " + m + "n= " + n);
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        //��������Ͻǵ���С����С��·����
        return dp(grid, m - 1, n - 1);
    }

    public int dp(int[][] grid, int i, int j) {
        //base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        // // ����������磬����һ���ܴ��ֵ��
        //    // ��֤��ȡ min ��ʱ�򲻻ᱻȡ��
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        try {
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
        } catch (Exception e) {
            System.out.println("i=" + i + "j= " + j);
        }

        memo[i][j] = Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];
        return memo[i][j];
    }


    public static void main(String[] args) {
        ZhuiXiaoLuJinHe31 zhuiXiaoLuJinHe = new ZhuiXiaoLuJinHe31();
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(zhuiXiaoLuJinHe.minParhSum(grid));
    }

}

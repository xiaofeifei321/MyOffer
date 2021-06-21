package com.labuladong;

import java.util.Arrays;

/**
 * ��С·����
 * ����һ�������Ǹ������� m x n ���� grid �����ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С
 * ���룺grid = [[1,3,1],[1,5,1],[4,2,1]]
 * �����7
 * ���ͣ���Ϊ·�� 1��3��1��1��1 ���ܺ���С
 * leedCode 64��
 */
public class ZhuiXiaoLuJinHe32 {
    int[][] memo;

    int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        System.out.println("m= " + m + "  n= " + n);
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(grid, m - 1, n - 1);
    }

    public int dp(int[][] grid, int m, int n) {
        if (m == 1 && n == 1) {
            return grid[0][0];
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        memo[m - 1][n - 1] = Math.min(grid[m - 1][n], grid[m][n - 1]) + grid[m][n];
        return memo[m][n];
    }


    public static void main(String[] args) {
        ZhuiXiaoLuJinHe32 zhuiXiaoLuJinHe = new ZhuiXiaoLuJinHe32();
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
    }

}

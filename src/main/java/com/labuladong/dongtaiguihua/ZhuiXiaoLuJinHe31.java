package com.labuladong.dongtaiguihua;

import java.util.Arrays;

/**
 * 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小
 * leedCode 64题
 */
public class ZhuiXiaoLuJinHe31 {
    int[][] memo;

    public int minParhSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //构造备忘录，初始值全部设置为-1
        System.out.println("m= " + m + "n= " + n);
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        //计算从左上角到右小角最小的路径和
        return dp(grid, m - 1, n - 1);
    }

    public int dp(int[][] grid, int i, int j) {
        //base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        // // 如果索引出界，返回一个很大的值，
        //    // 保证在取 min 的时候不会被取到
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

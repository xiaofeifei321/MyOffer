package com.labuladong.huisu.DFS;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 八皇后问题
 * 你一个 N×N 的棋盘，让你放置 N 个皇后，使得它们不能互相攻击,皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位
 */
class ShuZhuBaHuangHouSolution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] i : board) {
            Arrays.fill(i, '.');
        }
        backtrack(board, 0);
        return res;
    }

    // 路径：board 中小于 row 的那些行都已经成功放置了皇后
    // 选择列表：第 row 行的所有列都是放置皇后的选择
    // 结束条件：row 超过 board 的最后一行
    void backtrack(char[][] board, int row) {
        //触发结束条件
        if (row == board.length) {
            res.add(array2List(board));
            return;
        }

        for (int j = 0; j < board.length; j++) {
            //   // 排除不合法选择
            //        if (!isValid(board, row, col))
            if (!check(board, row, j)) {
                continue;
            }
            // 做选择
            board[row][j] = 'Q';
            backtrack(board, row + 1);
            //撤销选择
            board[row][j] = '.';
        }
    }

    List<String> array2List(char[][] board) {
        List<String> res = new LinkedList<>();
        for (char[] i : board) {
            StringBuffer sb = new StringBuffer();
            for (char j : i) {
                sb.append(j);
            }
            res.add(sb.toString());
        }
        return res;
    }

    boolean check(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ShuZhuBaHuangHouSolution solution = new ShuZhuBaHuangHouSolution();
        System.out.println(JSONUtil.toJsonStr(solution.solveNQueens(8).get(0)));
    }
}

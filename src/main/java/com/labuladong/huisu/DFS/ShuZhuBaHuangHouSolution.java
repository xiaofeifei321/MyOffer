package com.labuladong.huisu.DFS;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * �˻ʺ�����
 * ��һ�� N��N �����̣�������� N ���ʺ�ʹ�����ǲ��ܻ��๥��,�ʺ���Թ���ͬһ�С�ͬһ�С������������������ĸ���������ⵥλ
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

    // ·����board ��С�� row ����Щ�ж��Ѿ��ɹ������˻ʺ�
    // ѡ���б��� row �е������ж��Ƿ��ûʺ��ѡ��
    // ����������row ���� board �����һ��
    void backtrack(char[][] board, int row) {
        //������������
        if (row == board.length) {
            res.add(array2List(board));
            return;
        }

        for (int j = 0; j < board.length; j++) {
            //   // �ų����Ϸ�ѡ��
            //        if (!isValid(board, row, col))
            if (!check(board, row, j)) {
                continue;
            }
            // ��ѡ��
            board[row][j] = 'Q';
            backtrack(board, row + 1);
            //����ѡ��
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
        // ������Ƿ��лʺ����ͻ
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // ������Ϸ��Ƿ��лʺ����ͻ
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        // ������Ϸ��Ƿ��лʺ����ͻ
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

package com.labuladong.huisu.DFS;

/**
 * 解数独:
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 空白格用 '.' 表示
 * 输入：
 * [["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]]
 * 输出：
 * [["5","3","4","6","7","8","9","1","2"],
 * ["6","7","2","1","9","5","3","4","8"],
 * ["1","9","8","3","4","2","5","6","7"],
 * ["8","5","9","7","6","1","4","2","3"],
 * ["4","2","6","8","5","3","7","9","1"],
 * ["7","1","3","9","2","4","8","5","6"],
 * ["9","6","1","5","3","7","2","8","4"],
 * ["2","8","7","4","1","9","6","3","5"],
 * ["3","4","5","2","8","6","1","7","9"]]
 */
public class ShuZhuShuDu {
    void solveSuDu(char[][] board) {
        backTrack(board, 0, 0);
    }

    Boolean backTrack(char[][] board, int row, int col) {
        int m = 9, n = 9;
        if (col == m) {
            return backTrack(board, row + 1, 0);
        }
        //对每一个位置进行穷举
        for (int i = row; i < m; i++) {
            for (int j = col; j < n; j++) {
                //做选择
                //这个位置已经有数字了
                if (board[i][j] != '.') {
                    return backTrack(board, i, j + 1);
                }
                for (char ch = '1'; ch < '9'; ch++) {
                    //数字不合法，遍历下一个
                    if (!isValid(board, i, j, ch)) {
                        continue;
                    }
                    board[i][j] = ch;
                    //遍历子树
                    if (backTrack(board, i, j + 1)) {
                        return true;
                    }
                    //撤销
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return false;
    }

    //验证当前位置是否可存在字符串
    boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            //当前列没有和字符串c重复的
            if (board[i][col] == c) {
                return false;
            }
            if (board[row][i] == c) {
                return false;
            }
            // 判断 3 x 3 方框是否存在重复
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        System.out.println(3 * (col / 3)  );
    }
}

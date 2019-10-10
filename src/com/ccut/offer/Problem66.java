package com.ccut.offer;

/**
 * 66.机器人的运动范围 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
class SolutionMethod1 {

    public int movingCount(int threshold, int rows, int cols) {
        boolean[] visted = new boolean[rows * cols];
        for (int i = 0; i < visted.length; i++)
            visted[i] = false;

        int count = movingCountCore(threshold, rows, cols, 0, 0, visted);
        return count;
    }

    /*
     * 递归回溯方法：
     * @param threshold 约束值
     *
     * @param rows 方格行数
     *
     * @param cols 方格列数
     *
     * @param row 当前处理的行号
     *
     * @param col 当前处理的列号
     *
     * @param visted 访问标记数组
     *
     * @return 最多可走的方格
     */
    public int movingCountCore(int threshold, int rows, int cols, int row,
                               int col, boolean[] visted) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visted)) {
            visted[row * cols + col] = true;
            count = 1
                    + movingCountCore(threshold, rows, cols, row - 1, col,
                    visted)
                    + movingCountCore(threshold, rows, cols, row, col - 1,
                    visted)
                    + movingCountCore(threshold, rows, cols, row + 1, col,
                    visted)
                    + movingCountCore(threshold, rows, cols, row, col + 1,
                    visted);
        }
        return count;
    }

    boolean check(int threshold, int rows, int cols, int row, int col,
                  boolean[] visted) {
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && (getDigitSum(row) + getDigitSum(col) <= threshold)
                && !visted[row * cols + col])
            return true;
        return false;
    }

    /*
     * 一个数字的位数之和
     * @return 数字的位数之和
     */
    public int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}

public class Problem66 {
    public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("请输入限制条件k:");
        int k = 8;
//		System.out.println("请输入方格的行数m：");
        int m = 5;
//		System.out.println("请输入方格的列数n:");
        int n = 5;
        SolutionMethod1 solution1 = new SolutionMethod1();
//		scanner.close();
        System.out.println("矩阵能到达的方格数是：");
        System.out.println(solution1.movingCount(k, m, n));
    }

}

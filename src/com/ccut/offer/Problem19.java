package com.ccut.offer;

/**************************************************************      
 * 输入描述：请输入矩阵的行数
 *			4
 *			请输入矩阵的列数：
 *			5
 *			请输入一个矩阵，以空格隔开：
 *			1 3 9 7 5 2 8 6 1 4 3 7 2 1 9 4 6 5 2 3
 * 程序输出： 输入的矩阵为：
 *			1,3,9,7,5,
 *			2,8,6,1,4,
 *			3,7,2,1,9,
 *			4,6,5,2,3,
 *			顺时针打印的矩阵为：
 *			1,3,9,7,5,4,9,3,2,5,6,4,3,2,8,6,1,1,2,7,
 * 问题分析： 1.从键盘输入一个矩阵
 * 			方法：首先要输入矩阵的行数和列数，int rows = scanner.nextInt();
 * 				  然后定义一个二维矩阵，并用空格的方式输入：
 * 				for(int i = 0;i < rows; i++){
 for(int j = 0; j < columns; j++){
 array[i][j] = scanner.nextInt();
 }
 }

 ***************************************************************/
import java.util.ArrayList;

public class Problem19 {
	ArrayList<Integer> result = new ArrayList<>();

	public ArrayList<Integer> PrintMatrixByClockwise(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return result;
		}
		// 矩阵的行数
		int rows = matrix.length;
		// 矩阵的列数
		int columns = matrix[0].length;

		for (int start = 0; rows > 2 * start && columns > 2 * start; start++) {
			PrintMatrix(matrix, rows, columns, start);
		}
		return result;
	}

	/**
	 * 打印一圈
	 */
	public void PrintMatrix(int[][] matrix, int rows, int columns, int start) {
		int endRows = columns - 1 - start;
		int endColumns = rows - 1 - start;
		// 从左到右打印一行
		for (int i = start; i <= endRows; i++) {
			result.add(matrix[start][i]);
		}
		// 从上到下打印一列 终止号大于起止号 
		if (endColumns > start) {
			for (int i = start + 1; i <= endColumns; i++) {
				result.add(matrix[i][endRows]);
			}
		}
		
		// 从右向左打印一行 ，至少有两行两列
		if (endRows > start && endColumns > start) {
			for (int i = endRows - 1; i >= start; i--) {
				result.add(matrix[endColumns][i]);
			}
		}
		// 从下向上打印一列  至少有三行两列
		if (endRows > start&&endColumns-1 > start) {
			for (int i = endColumns - 1; i > start; i--) {
				result.add(matrix[i][start]);
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }};

		Problem19 test = new Problem19();
		ArrayList result = test.PrintMatrixByClockwise(matrix);
		System.out.print(result);
	}
}

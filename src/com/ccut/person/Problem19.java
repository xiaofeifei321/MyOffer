package com.ccut.person;

import java.util.ArrayList;

public class Problem19 {
	static ArrayList result = new ArrayList();

	public ArrayList printMatrixByClockwise(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		for (int start = 0; rows > 2 * start && columns > 2 * start; start++) {
			// 打印一圈
			printMatrix(matrix, rows, columns, start);
		}

		return null;
	}

	/**
	 * 打印一圈
	 */
	private static void printMatrix(int[][] matrix, int rows, int columns,
			int start) {
		int endRows = columns - 1 - start;
		int endColumns = rows - 1 - start;

		// 从左到右打印
		for (int i = 0; i < endRows; i++) {
			result.add(matrix[start][i]);
		}
		//从上到下
		if(endColumns>start)
		{
			//从上往下打印
			for (int i = start+1; i <endColumns; i++) {
				result.add(matrix[i][endRows]);
			}
		}
		//从右到左
		if(endColumns>start&&endRows>start)
		{
		}
		
		
		
		

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		ArrayList result = new Problem19().printMatrixByClockwise(matrix);

	}

}

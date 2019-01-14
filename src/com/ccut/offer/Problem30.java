package com.ccut.offer;

/**
 * 数组中取最小的n位数字
 * 
 * @author root
 * 
 */
public class Problem30 {
	/**
	 * 快速排序一次排序的过程
	 * 
	 * @return
	 */
	public int partition(int[] arr, int left, int right) {
		int result = arr[left];
		if (left > right)
			return -1;
		while (left < right) {
			while (left < right && arr[right] >= result) {
				right--;
			}
			arr[left] = arr[right];
			while (left < right && arr[left] < result) {
				left++;
			}
			arr[right] = arr[left];
		}

		arr[left] = result;
		return left;
	}

	public int[] getLeastNumbers(int[] input, int k) {
		if (input.length == 0 || k <= 0)
			return null;
		int[] output = new int[k];
		int start = 0;
		int end = input.length - 1;
		int index = partition(input, start, end);
		while (index != k - 1) {
			if (index > k - 1) {
				end = index - 1;
				index = partition(input, start, end);
			} else {
				start = index + 1;
				index = partition(input, start, end);
			}
		}
		for (int i = 0; i < k; i++) {
			output[i] = input[i];
		}
		return output;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 1, 6 };
		Problem30 test = new Problem30();
		int[] output = test.getLeastNumbers(arr, 2);
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + ",");
		}
	}
}

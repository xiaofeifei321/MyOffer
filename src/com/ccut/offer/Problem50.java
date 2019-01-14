package com.ccut.offer;
/**
 * 数组中的重复的数字
 */
public class Problem50 {
	public boolean duplicate(int[] arr) {
		if (arr == null || arr.length <= 0) {
			return false;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0 || arr[i] > arr.length - 1)
				return false;
		}
		for (int i = 0; i < arr.length; i++) {
			while (arr[i] != i) {
				if (arr[i] == arr[arr[i]]) {
					System.out.println(arr[i]);
					return true;
				} else {
					int temp = arr[i];
					arr[i] = arr[temp];
					arr[temp] = temp;
				}
			}
		}
		return false;
	}

	public boolean duplicate1(int[] arr) {
		if (arr.length <= 0 || arr == null) {
			return false;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0 || arr[i] > arr.length)
				return false;
		}
		for (int i = 0; i < arr.length; i++) {
			while (arr[i] != i) {
				if (arr[i] == arr[arr[i]]) {
                     System.out.println(arr[i]);
                     return true;
				}else {
					int temp=arr[i];
					arr[i]=arr[temp];
					arr[temp]=temp;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 3, 1, 4, 2, 5, 5 };
		Problem50 test = new Problem50();
		System.out.println(test.duplicate1(arr));
	}
}
package com.ccut.sort;

import java.util.Arrays;

/**
 * 简单选择排序
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] arr5 = { 0, 12, 15, 9, 20, 6, 31, 24 };
		selectSort(arr5);
		System.out.println("简单选择排序后： " + Arrays.toString(arr5));
	}
 
	/**
	 * 
     * 主要思想：
     *  每趟排序在当前待排序序列中选出关键码最小的记录，添加到有序序列中
     *  特点：
     *    记录的移动的次数最少。
	 * @param arr
	 */
	private static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int index=i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]<arr[index])
					index=j;
			}
			
			if(index!=i)
			{
				int temp=arr[index];
				arr[index]=arr[i];
				arr[i]=temp;
			}
		}
 
	}
}

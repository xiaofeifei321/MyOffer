package com.ccut.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
	public static void main(String[] args) {
		   int[] arr = {0, 12, 15, 9, 20, 6, 31, 24};
	        heapSort(arr);
	        System.out.println("堆排序后  " + Arrays.toString(arr));
	}

	private static void heapSort(int[] arr) {
	  //初始建堆
		for (int i =(arr.length-1)/2; i>=0; i--) 
		  sift(arr,i,arr.length);
		
		for (int i = arr.length-1; i >0; i--) {
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
		     sift(arr,0,i);
		}
	}
	
	/**
	 * @param arr 数组首地址
	 * @param selectNum :待筛选记录
	 * @param length 数组长度
	 */
	private static void sift(int arr[],int selectNum,int length) {
		//暂存要筛选的元素
		int temp=arr[selectNum];
		for(int i = selectNum*2; i < length; i=i*2) {
			//i指向左右节点最大的那个
			if(i<length&&arr[i]<arr[i+1])
            i++;	
			//根节点小于字树,将字数移动到根接单处,继续将temp和子树的作用字数想比较
			if (i<length&&temp<arr[i]) {
				arr[selectNum]=arr[i];
				selectNum=i;
			}else {
				//
				break;
			}
			arr[selectNum]=temp;
		}
	}
}

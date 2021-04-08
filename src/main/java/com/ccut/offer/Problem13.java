package com.ccut.offer;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 思路：
 * 维护两个数组下标，
 */
public class Problem13 {
    public void order(int[] arr) {
        if (arr == null)
            return;
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (isEven(arr[i]) && !isEven(arr[j])) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else if (!isEven(arr[i]) && isEven(arr[j])) {
                i++;
            } else if (isEven(arr[i]) && isEven(arr[j])) {
                j--;
            } else {
                i++;
                j--;
            }
        }
    }

    //判断奇偶
    public boolean isEven(int n) {
        return (n & 1) == 0;
    }

    public static void main(String[] args) {
        Problem13 test = new Problem13();
        System.out.println(test.isEven(2));
//		int[] arr= {1,2,3,4,5,6,12,7,8,9,10};
//		test.order(arr);
//		for(int i = 0;i<arr.length ;i++){
//			System.out.print(arr[i]+",");
//		}
    }
}

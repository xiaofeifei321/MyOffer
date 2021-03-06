package com.ccut.offer;

/**
 * 题目： 数字在排序数组中出现的次数
 * 解法一：二分查找 找到第一个K 和 最后一个K 二者位置相减
 * 二分查找思想：二分查找是一种算法，输入是一个有序的元素列表（必须是有序的），如果查找的元素包含在列表中，二分查找返回其位置，否则返回NULL。
 */
public class Problem38 {

    private int getFirstK(int[] arr, int k, int left, int right) {
        if (left > right)
            return -1;
        int middleIndex = (left + right) / 2;
        int middleData = arr[middleIndex];
        if (middleData == k) {
            //第一个K的位置刚好在处在中间位置
            if ((middleIndex > 0 && arr[middleIndex - 1] != k) || middleIndex == 0)
                return middleIndex;
            else
                right = middleIndex - 1;
        } else if (middleData > k)
            right = middleIndex - 1;
        else
            left = middleIndex + 1;
        return getFirstK(arr, k, left, right);
    }

    private int getLastK(int[] arr, int k, int left, int right) {
        if (left > right)
            return -1;
        int middleIndex = (left + right) / 2;
        int middleData = arr[middleIndex];
        if (middleData == k) {
            if ((middleIndex < arr.length - 1 && arr[middleIndex + 1] != k) || middleIndex == arr.length - 1)
                return middleIndex;
            else
                left = middleIndex + 1;
        } else if (middleData < k) {
            left = middleIndex + 1;
        } else
            right = middleIndex - 1;
        return getLastK(arr, k, left, right);
    }

    public int getNumberOfK(int[] arr, int k) {
        int number = 0;
        if (arr.length > 0) {
            int first = getFirstK(arr, k, 0, arr.length - 1);
            int last = getLastK(arr, k, 0, arr.length - 1);
            if (first > -1 && last > -1)
                number = last - first + 1;
        }
        return number;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        Problem38 test = new Problem38();
        System.out.println(test.getNumberOfK(arr, 3));
    }
}

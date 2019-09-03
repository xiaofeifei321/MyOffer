package com.ccut.offer;

/**
 * 旋转数组最小数字
 * 例如数组｛3，4，5，1，2｝为{1,2,3,4,5}的一个旋转，该数组的最小元素为1
 * 思路：
 * 递增的两个数组:两个数组下标，一个指向首位置,一个指向尾位置 ，中间位置进行比较
 * 如果比首位置大，那么一定处在首位置。下边移动到首位置
 */
public class Problem6 {
    public int minInReversingList(int[] arr) {
        if (arr == null) {
            return -1;
        }
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int midIndex = leftIndex;
        while (arr[leftIndex] >= arr[rightIndex]) {
            if (rightIndex - leftIndex <= 1) {
                midIndex = rightIndex;
                break;
            }
            midIndex = (leftIndex + rightIndex) / 2;
            //这种情况是防止{1，0，1,1,1}这种情况
            if (arr[leftIndex] == arr[rightIndex] && arr[midIndex] == arr[leftIndex]) {
                return MinInOrder(arr, leftIndex, rightIndex);
            }
            if (arr[midIndex] >= arr[leftIndex]) {
                leftIndex = midIndex;
            } else if (arr[midIndex] < arr[rightIndex]) {
                rightIndex = midIndex;
            }
        }
        return arr[midIndex];
    }

    //顺序查找
    public int MinInOrder(int[] arr, int leftIndex, int rightIndex) {
        int result = arr[leftIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (result > arr[i]) {
                result = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem6 test = new Problem6();
        int[] arr = {2, 2, 2, 2, 2, 0, 1, 2, 2};//
        System.out.println(test.minInReversingList(arr));
    }
}

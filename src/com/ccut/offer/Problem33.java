package com.ccut.offer;

import java.util.Collections;
import java.util.List;

/**
 * 问题点：可能出现的大数问题
 * 把数组排成最小的数:把数组排成最小的数｛3，32，321｝
 * 方法一：先求出这个数组中的所有数字的全排列，然后把每个排列拼接起来，最后求出排列起来的数字的最小值
 *方法二：
 *  这道题其实希望我们能够找到一个排序规则，数组根据这个规则排序之后能排成一个最小的数字。
 *  要确定排序的规则，就要比较两个数字，也就是给出两个数字m和n，我们需要确定一个规则判断m和n哪个应该排在前面，两个数字m和n能拼接称数字mn和nm。如果mn<nm，那么我们应该打印出mn，
 *  也就是m应该拍在N的前面，我们定义此时m小于n；反之，如果nm<mn，我们定义n小于m。如果mn=nm,m等于n
 */
public class Problem33 {
    /**
     * 1:拼接的数字可能超过数字的表示范围，可能出现大数问题
     *
     */
    public void printMin(int[] arr) {
        int[] clone = arr.clone();
        printMinNumber(clone, 0, clone.length - 1);
        for (int i : clone)
            System.out.print(i);
    }

    // 核心+快排
    public void printMinNumber(int[] arr, int left, int right) {
        if (left < right) {
            int main_number = arr[right];
            int small_cur = left;
            for (int j = left; j < right; j++) {
                if (isSmall(String.valueOf(arr[j]), String.valueOf(main_number))) {
                    int temp = arr[j];
                    arr[j] = arr[small_cur];
                    arr[small_cur] = temp;
                    small_cur++;
                }
            }
            arr[right] = arr[small_cur];
            arr[small_cur] = main_number;
            printMinNumber(arr, 0, small_cur - 1);
            printMinNumber(arr, small_cur + 1, right);
        }
    }

    public boolean isSmall(String m, String n) {
        String left = m + n;
        String right = n + m;
        boolean result = false;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) < right.charAt(i))
                return true;
            else if (left.charAt(i) > right.charAt(i))
                return false;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {100, 1, 721, 6};
        Problem33 test = new Problem33();
        test.printMin(arr);
    }
}

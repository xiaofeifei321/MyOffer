package com.ccut.offer;

/**
 * 连续子数组求和最大
 *
 * @author root
 */
public class Problem31 {
    public Integer findGreatestSum(int[] arr) {

        if (arr.length == 0)
            return null;
        //int最小的数
        int greatest = 0x80000000;
        int curSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (curSum <= 0)
                curSum = arr[i];
            else
                curSum += arr[i];
            if (curSum > greatest)
                greatest = curSum;
        }
        return greatest;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        Problem31 test = new Problem31();
        System.out.println(test.findGreatestSum(arr));
    }
}

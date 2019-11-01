package com.ccut.offer;

/**
 * 题目：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多个数字的和等于s,输出任意一对即可。
 *    例如输入数组｛1，2，4，7，11，15｝和数字15.由于4+11=15，因此输出4和11
 *    解法1:先在数组中固定一个数字，再依次判断数组中其余n-1个数字与它的和是不是等于s
 *    解法2：
 *      我们先在数组中选择两个数字，如果他们的和等于输入的s,我们就找到了要找的两个数字。如果小于s呢？我们希望两个数字的和再大一点。
 *      由于数组已经排好序了，我们可以考虑选择较小的数字后面的数字。因为排在后面的数字要大一点，那么这两个数字的和也要大一点，就有可能等于输入的数字s了。
 *      同样，当两个数字的和大于输入的数字的时候，我们就可以选择较大的数字前面的数字了，因为排在前面的数字要小一些。
 */
public class Problem41 {
    public void findNumbersWithSum(int[] sortedArray, int number) {
        if (sortedArray == null)
            return;
        int pointHead = 0;
        int pointEnd = sortedArray.length - 1;
        while (pointEnd > pointHead) {
            long curSum = sortedArray[pointEnd] + sortedArray[pointHead];
            if (curSum == number) {
                System.out.println(sortedArray[pointHead]);
                System.out.println(sortedArray[pointEnd]);
                break;
            } else {
                if (curSum > number)
                    pointEnd--;
                else
                    pointHead++;
            }
        }
    }

    /**
     * 打印连续的队列
     *
     * @param s
     */
    public void findContinuousSequence(int s) {
        if (s < 4)
            return;
        int small = 1;
        int big = 2;
        //字符中至少包含两个数字
        while (small < (s + 1) / 2) {
            int curSum = 0;
            for (int i = small; i <= big; i++)
                curSum += i;
            if (curSum == s) {
                System.out.println("find one");
                for (int i = small; i <= big; i++)
                    System.out.print(i + "+");
                small++;
            } else {
                if (curSum > s)
                    small++;
                else
                    big++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 8};
        Problem41 problem41 = new Problem41();
//        problem41.findNumbersWithSum(arr, 15);
        problem41.findContinuousSequence(15);
    }

}

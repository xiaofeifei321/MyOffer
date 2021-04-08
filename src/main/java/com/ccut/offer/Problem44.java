package com.ccut.offer;

/**
 * 扑克牌的顺序、
 * 题目：从扑克牌中随机抽出5张牌，判断是不是一个顺子，即这五张牌是不是连续的。2——10为数字本身，A为1，J为11，Q为12，K为13，而大小王为任意数字
 * 解法1：
 *   首先把数组排序，再统计数组中0的个数，最后统计排序之后数组中相邻的数字之间的空缺总数。如果空缺综述小于或者等于0的个数，那么这个数组就是连续的；反之则不连续。
 *
 */
public class Problem44 {
    /**
     * 做三件事 1:将数据排序 2:统计数组中零的个数 3 :统计相邻数据中空缺数字
     */
    public boolean isContinous(int[] arr) {
        if (arr == null || arr.length != 5)
            return false;
        int countOf0 = (arr[0] == 0 ? 1 : 0);
        int dis = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0)
                countOf0++;
            int t = arr[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (t != 0 && t == arr[j])
                    return false;
                else if (t > arr[j])
                    break;
                else
                    arr[j + 1] = arr[j];
            }
            arr[j + 1] = t;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != 0)
                dis += arr[i + 1] - arr[i] - 1;
        }
        if (dis <= countOf0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 1, 2, 5};
        Problem44 test = new Problem44();
        System.out.println(test.isContinous(arr));
    }

}

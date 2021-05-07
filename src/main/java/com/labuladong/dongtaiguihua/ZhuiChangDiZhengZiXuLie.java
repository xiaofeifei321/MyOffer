package com.labuladong.dongtaiguihua;

import java.util.Arrays;

/**
 * 最长递增子序列(信封问题)
 * 给你一个数组nums，找到其中最长严格递增子序列的长度
 * 输入nums={10,9,2,5,3,7,101,18}
 * 输出 4
 * 最长递增子序列是[2,3,7,101]
 */
public class ZhuiChangDiZhengZiXuLie {
    //dp[i]表示数组nums[i]这个数结尾的最长递增子序列的长度
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int[] dp = new int[len];
        //dp数组全部初始化为1
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        //子序列的最大长度为dp数组中最大值
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 4, 2, 3};
        ZhuiChangDiZhengZiXuLie zhuiChangDiZhengZiXuLie = new ZhuiChangDiZhengZiXuLie();
        System.out.println(zhuiChangDiZhengZiXuLie.lengthOfLIS(nums));
    }

}





package com.labuladong.dongtaiguihua;

/**
 * 给定一个整数数组nums,找到一个具有最大和的连续子数组(子数组中最少包含一个元素)。返回其最大和
 * 示例：
 * 输入：[-2,1.-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释 连续子数组[4,-1.2,1]的和最大，为6
 */
public class ZhuiDaZhiXuLieHe {
    int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        //代表以nums[i]结尾的最大子数组和为dp[i]
        int[] dp = new int[n];
        //base case 第一个元素前面没有子数组
        dp[0] = nums[0];
        //状态转移方程
        for (int i = 1; i < n; i++) {
            //dp[i]要么是自己，要么和前面的相邻子数组连接，形成一个和更大的数组
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        //得到nums的最大子数组
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        ZhuiDaZhiXuLieHe zhuiDaZhiXuLieHe = new ZhuiDaZhiXuLieHe();
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(zhuiDaZhiXuLieHe.maxSubArray(nums));
    }

}

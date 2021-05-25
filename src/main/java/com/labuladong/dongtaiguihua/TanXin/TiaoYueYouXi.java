package com.labuladong.dongtaiguihua.TanXin;

import java.util.Arrays;

/**
 * 跳跃游戏
 */
public class TiaoYueYouXi {

    public boolean canJump(int[] nums) {
        //记录到达的最远位置
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果i小于等于r代表这能到达i这个点
            if (i <= r) {
                //更新最远的长度
                r = Math.max(r, i + nums[i]);
                if (r >= nums.length-1) {
                    return true;
                }
            }else {
                System.out.println("else");
            }
        }
        return false;
    }

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     *输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game-ii
     */
    public int jump2(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return 0;
        //从索引p调到最后一格，至少需要
        int[] dp = new int[len];
        Arrays.fill(dp, len);
        dp[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            for (int step = 1; step <= nums[i]; step++) {  //可选择的步数step：【1,nums[i]】
                if (i + step < len - 1) {
                    dp[i] = Math.min(dp[i], 1 + dp[i + step]);
                } else {
                    dp[i] = 1;
                }
            }
        }
        return dp[0];
    }





    public static void main(String[] args) {
        TiaoYueYouXi tiaoYueYouXi=new TiaoYueYouXi();
    /*    int n[]={2,0,1,1,4};
        System.out.println(tiaoYueYouXi.canJump(n));
        int n2[]={3,2,1,0,4};
        System.out.println(tiaoYueYouXi.canJump(n2));
        int n3[]={0};
        System.out.println(tiaoYueYouXi.canJump(n3));

        int n4[]={2,5,0,0};
        System.out.println(tiaoYueYouXi.canJump(n4));

        //不带if
        int n5[]={3,2,1,0,4};
        System.out.println(tiaoYueYouXi.canJump(n5));*/
        int n6[]={0,2};
        System.out.println(n6.length);
        System.out.println(tiaoYueYouXi.jump2(n6));
    }
}

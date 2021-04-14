package com.labuladong.shuzu;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况
 */
public class QianZhuiShuZhu {

    /**
     * 时间复杂度为 n方
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subSum(int[] nums, int k) {
        int len = nums.length;
        //计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int count = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * hash表进行优化
     */

    public static int subArraySun(int[] nums, int k) {
        Map<Integer, Integer> preSumFreq = new HashMap();
        preSumFreq.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum = sum + num;
            if (preSumFreq.containsKey(sum - k)) {
                count =count+ preSumFreq.get(sum - k);
            }
            // 然后维护 preSumFreq 的定义,记录前缀和以及前缀和出现的次数
            preSumFreq.put(sum, preSumFreq.getOrDefault(sum, 0) + 1);
        }
        return count;

    }


    public static void main(String[] args) {
        int[] s = {3,5,2,-2,4,1};
        System.out.println(QianZhuiShuZhu.subSum(s, 8));
        System.out.println(QianZhuiShuZhu.subArraySun(s, 8));
    }

}

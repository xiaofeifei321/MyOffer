package com.labuladong.dongtaiguihua;

import java.util.Arrays;

/**
 * �����������(�ŷ�����)
 * ����һ������nums���ҵ�������ϸ���������еĳ���
 * ����nums={10,9,2,5,3,7,101,18}
 * ��� 4
 * �������������[2,3,7,101]
 */
public class ZhuiChangDiZhengZiXuLie {
    //dp[i]��ʾ����nums[i]�������β������������еĳ���
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int[] dp = new int[len];
        //dp����ȫ����ʼ��Ϊ1
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        //�����е���󳤶�Ϊdp���������ֵ
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





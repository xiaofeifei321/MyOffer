package com.labuladong.dongtaiguihua;

/**
 * ����һ����������nums,�ҵ�һ���������͵�����������(�����������ٰ���һ��Ԫ��)������������
 * ʾ����
 * ���룺[-2,1.-3,4,-1,2,1,-5,4]
 * �����6
 * ���� ����������[4,-1.2,1]�ĺ����Ϊ6
 */
public class ZhuiDaZhiXuLieHe {
    int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        //������nums[i]��β������������Ϊdp[i]
        int[] dp = new int[n];
        //base case ��һ��Ԫ��ǰ��û��������
        dp[0] = nums[0];
        //״̬ת�Ʒ���
        for (int i = 1; i < n; i++) {
            //dp[i]Ҫô���Լ���Ҫô��ǰ����������������ӣ��γ�һ���͸��������
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        //�õ�nums�����������
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

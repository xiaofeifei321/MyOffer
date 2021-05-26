package com.labuladong.dongtaiguihua.TanXin;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ��Ծ��Ϸ
 */
public class TiaoYueYouXi {

    public boolean canJump(int[] nums) {
        //��¼�������Զλ��
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            //���iС�ڵ���r�������ܵ���i�����
            if (i <= r) {
                //������Զ�ĳ���
                r = Math.max(r, i + nums[i]);
                if (r >= nums.length - 1) {
                    return true;
                }
            } else {
                System.out.println("else");
            }
        }
        return false;
    }

    /**
     * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
     * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶�
     * ���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�
     * ���������ǿ��Ե�����������һ��λ�á�
     * ����: [2,3,1,1,4]
     * ���: 2
     * ����: �������һ��λ�õ���С��Ծ���� 2��
     * ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã��� 1 ����Ȼ���� 3 ��������������һ��λ�á�
     * ��Դ�����ۣ�LeetCode��
     * ���ӣ�https://leetcode-cn.com/problems/jump-game-ii
     * ��̬�滮
     */
    public int jump2(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            //����������һ������ֱ�������һλ�����ñ��Q��
            return 0;
        }
        //������p�������һ��������Ҫ����ٸ�
        int[] dp = new int[len];
        Arrays.fill(dp, len);
        System.out.println(JSONUtil.toJsonStr(dp));
        //���һ�����Ӳ���Ҫ����
        dp[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            for (int step = 1; step <= nums[i]; step++) {
                //��ѡ��Ĳ���step����1,nums[i]��
                if (i + step < len - 1) {
                    //С������ĳ����������ȣ�����ֱ�ӵ���ĩβ
                    dp[i] = Math.min(dp[i], 1 + dp[i + step]);
                } else {
                    dp[i] = 1;
                }
            }
        }
        return dp[0];
    }


    /**
     * ̰���㷨
     *
     * @param
     */
    public int jump4(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0;
        int jums = 0;
        for (int i = 0; i < n - 1; i++) { //nums.size-2
            //������һ������Զ�±�
            farthest = Math.max(nums[i] + i, farthest);
            //ָ���±��ƶ���ʱ�����ֻ���ƶ���nums.size-2����ĩβ����Ҫ����+1��ز���������ĩβ�Ļ�������+1
            if (end == i) {
                jums++;
                end = farthest;
            }
        }
        return jums;
    }



    public static void main(String[] args) {
        TiaoYueYouXi tiaoYueYouXi = new TiaoYueYouXi();
    /*    int n[]={2,0,1,1,4};
        System.out.println(tiaoYueYouXi.canJump(n));
        int n2[]={3,2,1,0,4};
        System.out.println(tiaoYueYouXi.canJump(n2));
        int n3[]={0};
        System.out.println(tiaoYueYouXi.canJump(n3));

        int n4[]={2,5,0,0};
        System.out.println(tiaoYueYouXi.canJump(n4));

        //����if
        int n5[]={3,2,1,0,4};
        System.out.println(tiaoYueYouXi.canJump(n5));*/
        int n6[] = {2,1,4,1,4};
        System.out.println(n6.length);
        System.out.println(tiaoYueYouXi.jump2(n6));
    }
}

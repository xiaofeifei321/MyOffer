package com.labuladong.shuzu;

import java.util.Arrays;

/**
 * ���������ѣ�ÿ�ֱַ���a, b, c�ţ������������ˣ���һ����ֻ�Ե�һ�ֺ͵ڶ������ѣ��ڶ�����ֻ�Եڶ��ֺ͵��������ѣ�
 * ��������ֻ�Ե�һ�ֺ͵��������ѡ����ڸ�������a, b, c����ֵ�������ʵ����ţ��������˳������е����ѣ��㷨���سԵ�����������Ҫ�Զ��ٿ�����
 */
public class ChiPuDaoSolution {

    long sulation(long a,long b,long c){
        long[] nums = new long[]{a, b, c};
        Arrays.sort(nums);
        long sum = a + b + c;
        // �ܹ����������Σ�����ȫƽ��
        if (nums[0] + nums[1] > nums[2]) {
            return (sum + 2) / 3;
        }
        // ���ܹ��������Σ�ƽ����ߵ����
        if (2 * (nums[0] + nums[1]) < nums[2]) {
            return (nums[2] + 1) / 2;
        }
        // ���ܹ��������Σ�����Ȼ������ȫƽ�ֵ����
        return (sum + 2) / 3;
    }

    public static void main(String[] args) {
        ChiPuDaoSolution chiPuDaoSolution=new ChiPuDaoSolution();
        System.out.println(chiPuDaoSolution.sulation(1,2,3));
        System.out.println(chiPuDaoSolution.sulation(1,2,6));
        System.out.println(chiPuDaoSolution.sulation(12,13,11));
    }


}

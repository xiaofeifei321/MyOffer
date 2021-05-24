package com.labuladong.dongtaiguihua;

/**
 * 0,1��������
 * ��һ������װ������ΪW�ı�����N����Ʒ��ÿ����Ʒ�������ͼӸ��������ԣ����е�i����Ʒ
 * ������Ϊwt[i],��ֵΪval[i],�����������������װ��Ʒ�������װ�ļ�ֵ�Ƕ���
 * <p>
 * N=3��W=4
 * wt=[2,1,3];
 * val=[4,2,3]
 * ���Ϊ6 ��ѡ��ǰ������Ʒװ��������������3С��w�����Ի������ֵΪ6
 */
public class BeiBaoWenTi {

    public  int knapsack(int[] w, int[] v, int C) {
        int size = w.length;
        if (size == 0) {
            return 0;
        }
        int[][] dp = new int[size][C + 1];
        //��ʼ����һ�У�����������ΪC�ı�����0����Ʒ�����
        for (int i = 0; i <= C; i++) {
            dp[0][i] = w[0] <= i ? v[0] : 0;
        }
        //���������
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= C; j++) {
                dp[i][j] = dp[i - 1][j];
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i - 1][j - w[i]]);
                }
            }
        }
        return dp[size-1][C];
    }

    public static void main(String[] args) {BeiBaoWenTi beiBaoWenTi=new BeiBaoWenTi();
        int [] w={2,1,3,2};
        int[] v={12,10,20,15};
        System.out.println(beiBaoWenTi.knapsack(w,v,5));

    }

}

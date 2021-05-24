package com.labuladong.dongtaiguihua;

/**
 * 0,1背包问题
 * 给一个可以装载重量为W的背包和N个物品，每个物品有重量和加个两个属性，其中第i个物品
 * 的重量为wt[i],价值为val[i],现在让你用这个背包装物品，最多能装的价值是多少
 * <p>
 * N=3，W=4
 * wt=[2,1,3];
 * val=[4,2,3]
 * 结果为6 ，选择前两件物品装进背包，总重量3小于w，可以获得最大价值为6
 */
public class BeiBaoWenTi {

    public  int knapsack(int[] w, int[] v, int C) {
        int size = w.length;
        if (size == 0) {
            return 0;
        }
        int[][] dp = new int[size][C + 1];
        //初始化第一行，仅考虑容量为C的背包第0个物品的情况
        for (int i = 0; i <= C; i++) {
            dp[0][i] = w[0] <= i ? v[0] : 0;
        }
        //填充其他列
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

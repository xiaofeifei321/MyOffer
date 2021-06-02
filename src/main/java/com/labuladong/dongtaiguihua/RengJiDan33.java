package com.labuladong.dongtaiguihua;

import java.util.HashMap;
import java.util.Map;

/**
 * 高楼扔鸡蛋
 * 给你k个相同的鸡蛋，有一个从1层到n层共有n层的建筑，已知存在楼层f，满足0<=f<=n,任何高于f的楼层落下鸡蛋会碎，低于不会破，如果鸡蛋呗扔下没有被甩碎
 * 可以重复使用这枚鸡蛋，计算要确定f下最坏情况下需要扔几次鸡蛋才能确定这个楼层F
 * 1 <= k <= 100
 * 1 <= n <= 104
 */
public class RengJiDan33 {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    /**
     * 为使用二分法使用的楼层
     *
     * @param kxus
     * @param n
     * @return
     */
    //dp(k,n)表示在状态（k,n）下最小需要的步数  k和鸡蛋
    // 因为k的范围是[1, 100]，n * 100 + k 作为map的key，可以保证key的值与k和n相关，且唯一。 map里存的是对应n和k的最小值。 如果不存的话，每次都要通过二分法来找；存了就不需要重复找，直接返回就行了x。
    public int dp(int k, int n) {
        if (!memo.containsKey(n * 100 + k)) {
            int ans;
            if (n == 0) {
                ans = 0;
            } else if (k == 1) {
                ans = n;
            } else {
                int lo = 1, hi = n;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dp(k - 1, x - 1);
                    int t2 = dp(k, n - x);

                    if (t1 < t2) {
                        lo = x;
                    } else if (t1 > t2) {
                        hi = x;
                    } else {
                        lo = hi = x;
                    }
                }
                //// 将范围缩小到 right - left <= 1
                int leftVal = Math.max(dp(k - 1, lo - 1), dp(k, n - lo));
                int rightVal = Math.max(dp(k - 1, hi - 1), dp(k, n - hi));
                ans = 1 + Math.min(leftVal, rightVal);
            }
            memo.put(n * 100 + k, ans);
        }
        //备忘录
        return memo.get(n * 100 + k);
    }


    public int superRggDrop(int k, int n) {
        // k 鸡蛋数 n 为楼层数
        int[][] dp = new int[k + 1][n + 1];

        // 当楼层数为一时
        for (int i = 1; i <= k; i++) {
            dp[i][1] = 1;
        }

        // 当鸡蛋只有一颗时
        for (int i = 1; i <= n; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    min = Math.min(min, Math.max(dp[i - 1][x - 1], dp[i][j - x]));
                }
                dp[i][j] = 1 + min;
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) {
        RengJiDan33 rengJiDan33=new RengJiDan33();
        System.out.println(rengJiDan33.superEggDrop(3,14));
    }

}

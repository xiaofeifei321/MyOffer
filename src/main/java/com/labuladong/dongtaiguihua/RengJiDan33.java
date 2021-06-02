package com.labuladong.dongtaiguihua;

import java.util.HashMap;
import java.util.Map;

/**
 * ��¥�Ӽ���
 * ����k����ͬ�ļ�������һ����1�㵽n�㹲��n��Ľ�������֪����¥��f������0<=f<=n,�κθ���f��¥�����¼������飬���ڲ����ƣ��������������û�б�˦��
 * �����ظ�ʹ����ö����������Ҫȷ��f����������Ҫ�Ӽ��μ�������ȷ�����¥��F
 * 1 <= k <= 100
 * 1 <= n <= 104
 */
public class RengJiDan33 {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    /**
     * Ϊʹ�ö��ַ�ʹ�õ�¥��
     *
     * @param kxus
     * @param n
     * @return
     */
    //dp(k,n)��ʾ��״̬��k,n������С��Ҫ�Ĳ���  k�ͼ���
    // ��Ϊk�ķ�Χ��[1, 100]��n * 100 + k ��Ϊmap��key�����Ա�֤key��ֵ��k��n��أ���Ψһ�� map�����Ƕ�Ӧn��k����Сֵ�� �������Ļ���ÿ�ζ�Ҫͨ�����ַ����ң����˾Ͳ���Ҫ�ظ��ң�ֱ�ӷ��ؾ�����x��
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
                //// ����Χ��С�� right - left <= 1
                int leftVal = Math.max(dp(k - 1, lo - 1), dp(k, n - lo));
                int rightVal = Math.max(dp(k - 1, hi - 1), dp(k, n - hi));
                ans = 1 + Math.min(leftVal, rightVal);
            }
            memo.put(n * 100 + k, ans);
        }
        //����¼
        return memo.get(n * 100 + k);
    }


    public int superRggDrop(int k, int n) {
        // k ������ n Ϊ¥����
        int[][] dp = new int[k + 1][n + 1];

        // ��¥����Ϊһʱ
        for (int i = 1; i <= k; i++) {
            dp[i][1] = 1;
        }

        // ������ֻ��һ��ʱ
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

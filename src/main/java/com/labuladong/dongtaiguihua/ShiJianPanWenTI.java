package com.labuladong.dongtaiguihua;

import java.util.HashMap;
import java.util.Map;

/**
 * �ļ�������
 * ������̰������¼�������
 * key1 (A):����Ļ�ϴ�ӡһ��A
 * Key2(ctrl-A):ѡ��������Ļ
 * key3(ctrl-C):����ѡ�е����򵽻�����
 * key4(ctrl-v): ��������������������ϴ�����Ľ���Ϊֹ��������ʾ����Ļ��
 * <p>
 * <p>
 * <p>
 * ���� 1:
 * ����: N = 3
 * ���: 3
 * ����:
 * ��������������Ļ����ʾ����'A'ͨ������˳�򰴼���
 * A, A, A
 * <p>
 * ���� 2:
 * ����: N = 7
 * ���: 9
 * ����:
 * ��������������Ļ����ʾ�Ÿ�'A'ͨ������˳�򰴼���
 * A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
 */
public class ShiJianPanWenTI {
    Map<int[], Integer> memo = new HashMap();

    public int maxA(int n) {
        if (n <= 1) {
            return n;
        }
        //��ʾ��ǰ��ĻA�ĸ���
        int a_num = 0;
        //��ʾ���а��еĸ���
        int copy = 0;
        return dp(n, a_num, copy);
    }

    private int dp(int n, int a_num, int copy) {
        if (n <= 0) {
            return a_num;
        }
        int[] arrry = new int[]{n, a_num, copy};
        if (memo.containsKey(arrry)) {
            return memo.get(arrry);
        }
        int tmp = Math.max(dp(n - 1, a_num + 1, copy), dp(n - 1, a_num + copy, copy));
        int max = Math.max(tmp, dp(n - 2, a_num, a_num));
        memo.put(arrry, max);
        return max;
    }


    /**
     * �ⷨ��
     *
     * @param
     */

    public int maxA2(int N) {
        if (N <= 1) {
            return N;
        }
        //dp����پ���i�β���֮�������ʾ���ٸ�A
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;//�� A ��
            //ȫѡ & ���� dp[j-2]������ճ�� i - j ��
            for (int j = 2; j < i; j++) {
                //��Ļ�Ϲ� dp[j - 2] * (i - j + 1) �� A
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[N];
    }


    public static void main(String[] args) {
        ShiJianPanWenTI shiJianPanWenTI = new ShiJianPanWenTI();
        System.out.println(shiJianPanWenTI.maxA(7));
    }

}

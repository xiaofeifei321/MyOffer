package com.labuladong.dongtaiguihua;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CuoQiQiu34 {


    //����һ�����򣬷��ش������ǻ�ȡ��������
    int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //����������
        List<Integer> src = new LinkedList<Integer>();
        src.add(1);
        for (int i = 0; i < nums.length; i++) {
            src.add(nums[i]);
        }
        src.add(1);
        System.out.println(src.size());
        System.out.println(JSONUtil.toJsonStr(src));
        System.out.println(src.get(0));
        return loop(src);
    }
    int loop(List<Integer> src) {
        //�����ͷ��β�����һ��1
        if (src.size() <= 0) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < src.size() -1; i++) {
            int cur = src.get(i);
            //���ǰ�󲻼Ӹ�1�����ȡǰ�ͺ���������
            int temp = src.get(i - 1) * cur * src.get(i + 1);
            src.remove(i);
            //�ݹ�ʣ�µ��������ʣ�������ܵõ����Ӳ�ҵ�����
            res = Math.max(res, temp + loop(src));
            src.add(i, cur);
        }
        return res;
    }

    /**
     * ���仯����
     *
     * @param args
     */
    List<Integer> src = null;  //�������������
    int[][] dp = null;  //dp����
    int len = 0;

    public int maxCoins1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        len = nums.length;
        dp = new int[len + 2][len + 2];
        src = new ArrayList<Integer>();
        src.add(1);
        for (int i : nums) {
            src.add(i);
        }
        src.add(1);
        return loop(1, len);
    }

    int loop(int start, int end) {
        if (start > end) {
            return 0;
        }
        //����л���Ľ⣬ֱ�ӷ���
        if (dp[start][end] > 0) {
            return dp[start][end];
        }
        int res = 0;
        //�������Ž�
        for (int k = start; k <= end; k++) {
            //�������Ǽ����k�������������Ƶģ����д�������ʱ��������ߺ��ұߵ�����ֱ���start - 1��end + 1
            res = Math.max(res, loop(start, k - 1) + loop(k + 1, end) + src.get(start - 1) * src.get(k) * src.get(end + 1));
        }
        //��������浽������
        dp[start][end] = res;
        return res;
    }


    //��̬�滮
    public int maxCoins3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for (int i : nums) {
            list.add(i);
        }
        list.add(1);
        int dp[][] = new int[n + 2][n + 2];
        //��������������
        for (int len = 1; len <= n; len++) {
            //�������и����ȵ�������
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                //����������
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + list.get(i - 1) * list.get(k) * list.get(j + 1));
                }
            }
        }
        return dp[1][n];
    }
    public static void main(String[] args) {
        CuoQiQiu34 cuoQiQiu34 = new CuoQiQiu34();
        int temp[] = new int[]{3, 1, 5, 8};
        System.out.println(cuoQiQiu34.maxCoins(temp));
    }

}

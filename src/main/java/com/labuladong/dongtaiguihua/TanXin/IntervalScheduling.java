package com.labuladong.dongtaiguihua.TanXin;

import cn.hutool.json.JSONUtil;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 区间调度问题
 * 给你很多形如[start,end]的闭区间，请你设计一个算法，算出这些区间中最多有几个互不相交的区间
 * intvs=[[1,3],[2,4],[3,6]]，这些区间最多有两个区间互不相交，
 * 即[[1,3],[3,6]]，你的算法应该返回 2。注意边界相同并不算相交
 *
 */
public class IntervalScheduling {

    public int intevalSchedu(int[][] intvs) {
        if (intvs.length == 0) {
            return 0;
        }
        //将数组按照End升序排序
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //至少应该有一个区间不相交
        int count = 1;
        //排序后，第一个区间为X
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            if (start >= x_end) {
                //更新X
                System.out.println(JSONUtil.toJsonStr(interval));
                count++;
                x_end = interval[1];
            }

        }
        return count;
    }

    public static void main(String[] args) {
        IntervalScheduling intervalScheduling = new IntervalScheduling();
        int[][] board = new int[][]{
                {1, 3},
                {2, 4},
                {3, 6}
        };
        System.out.println(intervalScheduling.intevalSchedu(board));
    }
}

package com.labuladong.dongtaiguihua.TanXin;

import cn.hutool.json.JSONUtil;

import java.util.Arrays;
import java.util.Comparator;

/**
 * �����������
 * ����ܶ�����[start,end]�ı����䣬�������һ���㷨�������Щ����������м��������ཻ������
 * intvs=[[1,3],[2,4],[3,6]]����Щ����������������以���ཻ��
 * ��[[1,3],[3,6]]������㷨Ӧ�÷��� 2��ע��߽���ͬ�������ཻ
 *
 */
public class IntervalScheduling {

    public int intevalSchedu(int[][] intvs) {
        if (intvs.length == 0) {
            return 0;
        }
        //�����鰴��End��������
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //����Ӧ����һ�����䲻�ཻ
        int count = 1;
        //����󣬵�һ������ΪX
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            if (start >= x_end) {
                //����X
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

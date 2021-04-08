package com.labuladong.huisu.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ����һ���������� nums �������е�Ԫ�ػ�����ͬ �����ظ��������п��ܵ��Ӽ����ݼ�����
 * �⼯���ܰ����ظ����Ӽ�������԰� ����˳�� ���ؽ⼯
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,3]
 * �����[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * ʾ�� 2��
 * <p>
 * ���룺nums = [0]
 * �����[[],[0]]
 */
public class ShuZhuZiJi {
    //�洢�߹���·��
    List<List<Integer>> res = new ArrayList<>();


    List<List<Integer>> subsets(int[] nums) {
        //��¼�߹���·��
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, 0, track);
        return res;
    }

    void backTrack(int[] nums, int start, LinkedList<Integer> track) {
        //���������ж�
        res.add(new LinkedList<>(track));
        //��ʼ����
        for (int i = start; i < nums.length; i++) {
            //��ѡ��
            track.add(nums[i]);
            //���ݱ����Ӽ�
            backTrack(nums, i + 1, track);
            //����ѡ��
            track.remove(track.size() - 1);
        }
    }






    public static void main(String[] args) {
        ShuZhuZiJi shuZhuZiJi = new ShuZhuZiJi();
        int[] nums = {1, 2, 3};
        System.out.println(shuZhuZiJi.subsets(nums));
    }
}

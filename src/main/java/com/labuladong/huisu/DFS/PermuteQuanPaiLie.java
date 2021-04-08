package com.labuladong.huisu.DFS;

import cn.hutool.json.JSONUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * �ַ���ȫ����
 * ����һ�� û���ظ� ���ֵ����У����������п��ܵ�ȫ����
 * ����: [1,2,3]
 * ���:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class PermuteQuanPaiLie {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // ��¼ÿһ��·��
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track);
        return res;
    }

    /*
     *   nums��ѡ���б�
     *   track��·��
     */
    public void backTrack(int[] nums, LinkedList<Integer> track) {
        // ��������
        if (nums.length == track.size()) {
            res.add(new LinkedList(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            // ��ѡ��
            track.add(num);
            System.out.println("��ȥ����"+track.get(track.size() - 1));
            backTrack(nums, track);
            // ����ѡ��
            System.out.println("��������"+track.get(track.size() - 1));
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        PermuteQuanPaiLie permute = new PermuteQuanPaiLie();
        int[] nums = {1, 2, 3};
        System.out.println(JSONUtil.toJsonStr(permute.permute(nums)));
    }
}

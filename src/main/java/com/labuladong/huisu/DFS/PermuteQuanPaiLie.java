package com.labuladong.huisu.DFS;

import cn.hutool.json.JSONUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * 字符串全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列
 * 输入: [1,2,3]
 * 输出:
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
        // 记录每一条路径
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track);
        return res;
    }

    /*
     *   nums：选择列表
     *   track：路径
     */
    public void backTrack(int[] nums, LinkedList<Integer> track) {
        // 结束条件
        if (nums.length == track.size()) {
            res.add(new LinkedList(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            // 做选择
            track.add(num);
            System.out.println("进去数据"+track.get(track.size() - 1));
            backTrack(nums, track);
            // 撤销选择
            System.out.println("返回数据"+track.get(track.size() - 1));
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        PermuteQuanPaiLie permute = new PermuteQuanPaiLie();
        int[] nums = {1, 2, 3};
        System.out.println(JSONUtil.toJsonStr(permute.permute(nums)));
    }
}

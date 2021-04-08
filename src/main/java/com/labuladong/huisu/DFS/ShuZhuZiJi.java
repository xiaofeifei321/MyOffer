package com.labuladong.huisu.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集不能包含重复的子集。你可以按 任意顺序 返回解集
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class ShuZhuZiJi {
    //存储走过的路径
    List<List<Integer>> res = new ArrayList<>();


    List<List<Integer>> subsets(int[] nums) {
        //记录走过的路径
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, 0, track);
        return res;
    }

    void backTrack(int[] nums, int start, LinkedList<Integer> track) {
        //结束条件判断
        res.add(new LinkedList<>(track));
        //开始遍历
        for (int i = start; i < nums.length; i++) {
            //做选择
            track.add(nums[i]);
            //回溯遍历子集
            backTrack(nums, i + 1, track);
            //撤销选择
            track.remove(track.size() - 1);
        }
    }






    public static void main(String[] args) {
        ShuZhuZiJi shuZhuZiJi = new ShuZhuZiJi();
        int[] nums = {1, 2, 3};
        System.out.println(shuZhuZiJi.subsets(nums));
    }
}

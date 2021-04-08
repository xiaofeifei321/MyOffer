package com.labuladong.huisu.DFS;

import java.util.ArrayList;
import java.util.List;

public class ShuZhuZhuHe {
    List<List<Integer>> res = new ArrayList<>();

    List<List<Integer>> combin(int n, int k) {
        if (k <= 0 || n <= 0) {
            return res;
        }

        //存储决策树走的路径
        List<Integer> track = new ArrayList<>();
        backTrack(n, k, 1, track);
        return res;
    }

    void backTrack(int n, int k, int start, List<Integer> track) {
        //满足条件
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
        }
        //遍历决策树
        for (int i = start; i <= n; i++) {
            //做选择
            track.add(i);
            backTrack(n, k, i + 1, track);
            //撤销选择
            track.remove(track.size() - 1);
        }
    }


    public static void main(String[] args) {
        ShuZhuZhuHe shuZhuZhuHe=new ShuZhuZhuHe();
        System.out.println(shuZhuZhuHe.combin(4,2));
    }

}

package com.labuladong.huisu.DFS;

import java.util.ArrayList;
import java.util.List;

public class ShuZhuZhuHe {
    List<List<Integer>> res = new ArrayList<>();

    List<List<Integer>> combin(int n, int k) {
        if (k <= 0 || n <= 0) {
            return res;
        }

        //�洢�������ߵ�·��
        List<Integer> track = new ArrayList<>();
        backTrack(n, k, 1, track);
        return res;
    }

    void backTrack(int n, int k, int start, List<Integer> track) {
        //��������
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
        }
        //����������
        for (int i = start; i <= n; i++) {
            //��ѡ��
            track.add(i);
            backTrack(n, k, i + 1, track);
            //����ѡ��
            track.remove(track.size() - 1);
        }
    }


    public static void main(String[] args) {
        ShuZhuZhuHe shuZhuZhuHe=new ShuZhuZhuHe();
        System.out.println(shuZhuZhuHe.combin(4,2));
    }

}

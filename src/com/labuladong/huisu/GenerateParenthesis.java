package com.labuladong.huisu;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * ���� n �����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� �������
 * leedcode22
 * �����㷨���
 *  for ѡ�� in ѡ���б�:
 *     # ��ѡ��
 *     ����ѡ���ѡ���б��Ƴ�
 *     ·��.add(ѡ��)
 *     backtrack(·��, ѡ���б�)
 *     # ����ѡ��
 *     ·��.remove(ѡ��)
 *     ����ѡ���ټ���ѡ���б�
 *
 */
public class GenerateParenthesis {

    public ArrayList<String> res;
    public String pare[] = {"(", ")"};

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if (n == 0)
            return null;
        generateParenthesisHelper(n, 0, 0, "");
        return res;
    }


    public void generateParenthesisHelper(int n, int left, int right, String s) {
        //	���������������������������в��Ϸ�����
        if (right > left) return;
        if (left > n || right > n) return;
        //	����������Ŀ������n
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                generateParenthesisHelper(n, left + 1, right, s + pare[i]);
            } else {
                generateParenthesisHelper(n, left, right + 1, s + pare[i]);
            }

        }
        return;
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(JSONUtil.toJsonStr(generateParenthesis.generateParenthesis(2)));
    }


}

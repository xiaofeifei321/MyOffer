package com.labuladong.huisu;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 * leedcode22
 * 回溯算法框架
 *  for 选择 in 选择列表:
 *     # 做选择
 *     将该选择从选择列表移除
 *     路径.add(选择)
 *     backtrack(路径, 选择列表)
 *     # 撤销选择
 *     路径.remove(选择)
 *     将该选择再加入选择列表
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
        //	若右括号数大于左括号数，即有不合法括号
        if (right > left) return;
        if (left > n || right > n) return;
        //	左右括号数目均等于n
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

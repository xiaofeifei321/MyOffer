package com.labuladong.fenzhi;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
 * 你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。   leedcode241
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 */
public class DiffWays {
    //定义：计算算是 input所有可能的运算结果
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '*' || c == '+') {
                //分 以运算符为中心，分割两个字符串，分别递归
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                //治
                for (int a : left) {
                    for (int b : right) {
                        if (c == '+') {
                            res.add(a + b);
                        } else if (c == '-') {
                            res.add(a - b);
                        } else if (c == '*') {
                            res.add(a * b);
                        }
                    }
                }
            }
        }
        //base case  如果res为空，说明算式是一个数字，没有运算符
        if (res.isEmpty()) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }

    public static void main(String[] args) {
        String stringTmp = "2-1-3";
//        String stringTmp2 = "2*3-4*5";
//        System.out.println(JSONUtil.toJsonStr(DiffWays.diffWaysToCompute(stringTmp)));
//        System.out.println(JSONUtil.toJsonStr(DiffWays.diffWaysToCompute(stringTmp2)));

        String tmpString = "{\n" +
                "\t\"flagSeries\": 0,\n" +
                "\t\"ids\": [{\n" +
                "\t\t\"id\": 1\n" +
                "\t}, {\n" +
                "\t\t\"id\": 2\n" +
                "\t}]\n" +
                "}";
        JSONObject jsonObject = JSONUtil.parseObj(tmpString);
        int flagSeries = jsonObject.getInt("flagSeries");
        System.out.println(flagSeries);
        JSONArray ids = jsonObject.getJSONArray("ids");
        for (int i = 0; i < ids.size(); i++) {
            JSONObject obj = (JSONObject) ids.get(i);
            int id = obj.getInt("id");
            System.out.println(id);
        }

        System.out.println(" -------------------------------------------------------");

        int index=1;
        System.out.println(index%27);

        List arrList=new ArrayList();
        arrList.add("");
        arrList.add("A");
        arrList.add("B");
        arrList.add("C");
        arrList.add("D");
        arrList.add("E");
        arrList.add("F");
        arrList.add("G");
        arrList.add("H");
        arrList.add("I");
        arrList.add("J");
        arrList.add("K");
        arrList.add("L");
        arrList.add("M");
        arrList.add("N");
        arrList.add("O");
        arrList.add("P");
        arrList.add("Q");
        arrList.add("R");
        arrList.add("S");
        arrList.add("T");
        arrList.add("U");
        arrList.add("V");
        arrList.add("W");
        arrList.add("X");
        arrList.add("Y");
        arrList.add("Z");
        System.out.println(arrList.size());
        System.out.println(arrList.get(1));



    }

}

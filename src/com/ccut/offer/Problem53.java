package com.ccut.offer;

import com.ccut.NumberFormatException;

/**
 * 表示数字的字符串 判断子符串是否为整数
 */
public class Problem53 {
    public static void main(String[] args) {
        Problem53 solution29 = new Problem53();
        String s1 = "+2147483647";
        String s2 = "1a33";
        System.out.println(solution29.StrToInt(s2));

    }

    /**
     * 判断字符串为空，长度为0,判断字符串转换后上下界是否溢出
     */
    public int StrToInt_2(String str) {
        // 判断字符串是否为空，长度是否为0
        if (str == null || str.length() == 0) {
            return 0;
        }
        int start;
        int tag;// 1表示+ 0表示-
        if (str.charAt(0) == '+') {
            start = 1;
            tag = 1;
        } else if (str.charAt(0) == '-') {
            start = 1;
            tag = 0;
        } else {
            start = 0;
            tag = 1;
        }
        long result = 0;
        for (int i = start; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp >= '0' && temp <= '9') {
                result = result * 10 + (temp - '0');
                if (tag == 1 && result > Integer.MAX_VALUE)
                    throw new RuntimeException("上溢出");
                if (tag == 0 && result < Integer.MIN_VALUE)
                    throw new RuntimeException("下溢出");
            } else {
                return 0;
            }
        }

        if (tag == 0) {
            return (int) (-1 * result);
        } else {
            return (int) result;
        }
    }

    /**
     * 利用系统上的函数
     */
    public int StrToInt(String str) {
        int res = 0;
        try {
            res = Integer.valueOf(str);
        } catch (NumberFormatException e) {
            res = 0;
        }
        return res;
    }
}
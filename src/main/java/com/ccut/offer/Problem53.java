package com.ccut.offer;

import com.ccut.NumberFormatException;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数），例如字符串字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是
 * 实现思路：
 *  1：关注点:小数点只能有一个
 *  2:0-9里面的数字加个子数e
 *  3：e出现的位置，
 *            不能出现在末尾，e后面如果有+-号，正负号不能有小数点
 *            正负号如果在中间，前一个数字是e或者是E，后面是一个数字，比如0--9的数字
 */
public class Problem53 {
    public static void main(String[] args) {
        Problem53 solution29 = new Problem53();
        String s1 = "+21474";
        String s2 = "-4e-2.1";
        System.out.println(solution29.isNumeric(s2.toCharArray()));
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

    public boolean isNumeric(char[] str) {
        String ss = String.valueOf(str);
//		 先判断每个字符是否合法
        int len = ss.length();
        for(int i=0; i<len; i++){
            char c = ss.charAt(i);
            if(!((c>='0' && c <= '9') || c=='e' || c=='E' || c=='+' || c=='-'|| c=='.')){
                return false;
            }
        }//
//		 正负号,E不能在末尾
        if(ss.charAt(len-1) == '+' || ss.charAt(len-1) == '-' || ss.charAt(len-1) == 'E' || ss.charAt(len-1) == 'e'){
            return false;
        }
//		 判断小数点，只能有一个
        if(ss.indexOf(".") != ss.lastIndexOf(".")){
            return false;
        }
//		 正负号在中间的位置时，前面的是e，E,后面是数字
        for(int i=1; i<len-1; i++){
            char c = ss.charAt(i);
            if(c == '+' || c=='-'){
                if(!(ss.charAt(i-1) == 'e' || ss.charAt(i-1) == 'E') ||
                        !(ss.charAt(i+1)>='0' && ss.charAt(i+1)<='9')){
                    return false;
                }
            }
        }//
//		e的后面不能有数字12E+4.3
        for(int i=1; i<len; i++){
            char c = ss.charAt(i);
            if(c == 'e' || c=='E'){
//				 if(i==len-1) return false;
                if(ss.charAt(i+1) == '+' || ss.charAt(i+1) == '-'){
//					 从i+2开始往后没有小数点.则返回-1
                    if(ss.indexOf(".", i+2) != -1){
                        return false;
                    }
                }
            }
        }//
        return true;
    }
}
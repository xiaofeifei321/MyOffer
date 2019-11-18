package com.ccut.offer;

/**
 * 正则表达式字符串匹配
 * 1：请实现函数来匹配包括'.'和'*'的正则表达式，模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次），例如字符串‘aaa’与模式'a.a'和"ab*"
 * 想法：字符串匹配，匹配的是拿后面的数据匹配前面的数据
 * 1：先考虑特殊情况
 *     1：两个字符串都为空，则返回true
 *     2：第一个字符串不为空，第二个字符串为空，则返回flase，反向，存在成功的可能性，比如a*a*a*
 *  2:正常情况下
 *  2.1：后开始匹配第一个字符，有两种可能性，匹配成功或者匹配失败，考虑pattern下一个字符出现*
 *         2.1.1：分两种情况下一个字符不为*，这种情况比较简单，匹配成功，就下一个比较，如果匹配失败，直接返回false，匹配成功除了两个字符相同之外，还有一种情况，当前匹配的字符为‘.’,同时str的当前字符不为'/0’
 *         2.2.2:当前字符的下一个字符为‘*’
 *               2.2.2.1：当下一个字符匹配0个字符，str当前字符不变，pattern当前字符后移动两位，跳过这个*
 *               2.2.2.3:当‘*’匹配1个或多个时，str当前字符移向下一个，pattern当前字符不变
 *
 */
public class Problem52 {
    public boolean match(char[] str, char[] pattern) {
        // 如果输入为空，返回匹配失败
        if (str == null || pattern == null)
            return false;

        return match(str, pattern, 0, 0);
    }

    private boolean match(char[] str, char[] pattern, int strIndex, int patIndex) {
        // 如果字符串和模式同时遍历完成，说明匹配成功
        if (strIndex == str.length && patIndex == pattern.length)
            return true;
        // 如果字符串还没有遍历完，模式已经遍历完，说明匹配失败
        if (strIndex != str.length && patIndex == pattern.length)
            return false;

        // 【1】当模式中的第二个字符是“*”时：
        if (patIndex < pattern.length - 1 && pattern[patIndex + 1] == '*') {
            // 2、如果字符串第一个字符跟模式第一个字符匹配(相同或者模式为'.')，可以有3种匹配方式：
            if (strIndex < str.length
                    && (pattern[patIndex] == str[strIndex] || pattern[patIndex] == '.')) {
                // （2）字符串后移1字符，模式后移2字符；
                return match(str, pattern, strIndex + 1, patIndex + 2)
                        // （3）字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
                        || match(str, pattern, strIndex + 1, patIndex)
                        // （1）模式后移2字符，相当于x*被忽略；
                        || match(str, pattern, strIndex, patIndex + 2);
            } else {
                // 1、如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。
                return match(str, pattern, strIndex, patIndex + 2);
            }
        }
        // 【2】当模式中的第二个字符不是“*”时：tips!!!切记要把对下标的合法性检查放在&&左侧
        if (strIndex < str.length
                && (pattern[patIndex] == str[strIndex] || pattern[patIndex] == '.')) {
            // 1、如果字符串第一个字符和模式中的第一个字符相匹配
            return match(str, pattern, strIndex + 1, patIndex + 1);
        }
        // 2、如果字符串第一个字符和模式中的第一个字符相不匹配，直接返回false
        return false;
    }


    public static void main(String[] args) {
        Problem52 problem52 = new Problem52();
        char a[] = {'a', 'c', 'd'};
        char d[] = {'a', '*', 'd'};
        System.out.println(problem52.match(a, d));
    }
}

package com.ccut.offer;

import java.util.LinkedHashMap;

/**
 * 字符流中第一个不重复的字符
 *   题目:
 *   例如:当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"
 *    1:将字符串放到LinkedHashMap，键为相应的字符串，值为出现的次数，如果次数等于1，输出相应的位置
 *
 *
 * @author root
 */
public class Problem54 {

    public static void main(String[] args) {
        String str = "abaccdebff";
        Problem54 test = new Problem54();
        System.out.println(test.firstNotRepeating(str));
    }

    public Character firstNotRepeating(String str) {
        char[] strChar = str.toCharArray();
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for (char item : strChar) {
            if (hashMap.containsKey(item)) {
                hashMap.put(item, hashMap.get(item) + 1);
            } else {
                hashMap.put(item, 1);
            }
        }
        for (char key : hashMap.keySet()) {
            if (hashMap.get(key) == 1) {
                return key;
            }
        }
        return null;
    }
}

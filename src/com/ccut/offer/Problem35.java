package com.ccut.offer;

import java.util.LinkedHashMap;

/**
 * 字符串中第一次出现的次数
 */
public class Problem35 {
    public static void main(String[] args) {
        String str = "abaccdebff";
        Problem35 test = new Problem35();
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

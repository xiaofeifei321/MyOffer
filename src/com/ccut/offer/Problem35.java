package com.ccut.offer;

import java.util.LinkedHashMap;

/**
 * 字符串中第一次出现的次数
 * 思路1：我们最直观的想法就是从头开始扫描这个字符串中的字符。当访问某个字符时拿这个字符和后面的每个字符相比较，如果在后面没有发现重复的字符，则该字符就是只出现一次的字符
 * 思路2：
 *     我们可以定义哈希表的键值（key)是字符，而值（Value)是该字符出现的次数。同时我们还需要从头开始扫描字符串两次。第一次扫描字符串时，每扫描到一个字符就在哈希表中的对应项中把次数加1.接下来第二次扫描时，每扫描到一个字符就能从哈希表中得到该字符出现的次数。这样第一个只出现一次的字符就是符合要求的输出
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

package com.ccut.offer;

/**
 * 待看不懂
 *
 * @author root
 */
public class Problem67 {
    public static int getTranslationCount(int number) {
        if (number < 0)
            return 0;
        if (number == 1)
            return 1;
        return getTranslationCount(Integer.toString(number));
    }

    // 动态规划，从右到左计算。
    // f(r-2) = f(r-1)+g(r-2,r-1)*f(r);
    // 如果r-2，r-1能够翻译成字符，则g(r-2,r-1)=1，否则为0
    public static int getTranslationCount(String number) {
        int f1 = 0, f2 = 1, g = 0;
        int temp;
        for (int i = number.length() - 2; i >= 0; i--) {
            if (Integer.parseInt(number.charAt(i) + "" + number.charAt(i + 1)) < 26)
                g = 1;
            else
                g = 0;
            temp = f2;
            System.out.println(f2 + "+" + g + "*" + f1);
            f2 = f2 + g * f1;
//			System.err.println(f2);
            f1 = temp;
        }
        return f2;
    }

    public static void main(String[] args) {
//		System.out.println(getTranslationCount(-10)); // 0
        System.out.println(getTranslationCount(12258)); // 3
//		System.out.println(getTranslationCount(12258)); // 5
    }
}

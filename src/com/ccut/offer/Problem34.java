package com.ccut.offer;

/**
 * 判断是否为丑数
 * 1： 我们把只包含因子2，3，5的数称为丑数，
 *     求按从小到大的顺序的第1500个丑数,例如6，8都是丑数，但14不是，因为它含有因子7.习惯上我们把1当作第一个丑数
 *     丑数的定义：抽数只能被2,3,5整除。
 * 方法一：所谓一个数m是另一个数n的因子，是指n能被m整除，也就是说n%m==0.根据丑数的定义，丑数只能被2，3，5整除。
 *  也就是说如果一个数能被2整除，我们把它连续除以2；如果能被3整除，就连续除以3；如果能被5整除，就除以5.如果最后我们得到的是1，那么这个数就是丑数，否则不是。
 *
 * 方法二:
 * ，丑数应该是另一个丑数乘以2，3，5的结果。因此我们可以创建一个数组，里面的数字是排序好的丑数，每一个丑数都是前面的丑数乘以2，3，5得到的,得到的结果是m1,m2,m3，得到】
 * 取m1,m2,m3,最小的
 */
public class Problem34 {
    public boolean isUgly(int number) {
        while (number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;
        return number == 1 ? true : false;
    }

    public int getUglyNumber(int index) {
        if (index <= 1)
            return 0;
        if (index == 2) {
            return 1;
        }
        int uglyFound = 0;
        for (int i = 2; i < index; i++) {
            if (isUgly(i)) {
                ++uglyFound;
            }
        }
        return uglyFound;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int index = 6;
        Problem34 problem34 = new Problem34();
        System.out.println(problem34.getUglyNumber(index));
    }

}

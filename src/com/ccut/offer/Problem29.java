package com.ccut.offer;

/**
 * 数组中出现次数超过一半的数字
 */
public class Problem29 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        Problem29 p = new Problem29();
        System.out.println(p.moreThanHalfNum(array));
    }

    public Integer moreThanHalfNum(int[] array) {
        if (array == null)
            return null;
        int count = 0;
        Integer resultInteger = null;
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                resultInteger = array[i];
                count = 1;
            } else if (array[i] == resultInteger)
                count++;
            else
                count--;
        }
        if (checkMoreThanHalf(array, resultInteger))
            return resultInteger;
        else
            return null;
    }

    private boolean checkMoreThanHalf(int[] array, Integer number) {
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number)
                times++;
        }
        if (times * 2 <= array.length)
            return false;
        else
            return true;
    }
}
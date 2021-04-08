package com.ccut.offer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次
 *思路：任意一个数字和本身做异或运算，则本身为零
 *  思路：
 *    1：我们在结果数字中找到第一个为1的位的位置，记为第n位。现在我们以第n位是不是1为标准把原数组中的数字分成两个子数组，第一个子数组中的每个数字的第n位都是1，
 *   而第二个子数组中每个数字的第n位都为0.由于我们分组的标准是数字中的某一位是1还是0，那么出现了两次的数字肯定被分配到同一个子数组中。因为两个相同的数字的任意一位都是相同的，
 *   我们不可能把两个相同的数字分配到两个子数组中去
 *   2：从头到尾依次异或数组中的每一个数字，那么最终得到的结果就是两个只出现一次的数字的异或的结果。因为其他数字都出现两次，在异或中全部抵消了，时间复杂度为O(n)
 *
 */
public class Problem40 {
    public void findNumsAppearOnce(int[] arr) {
        if (arr == null)
            return;
        int number = 0;
        for (int i : arr) {
            number = number ^ i;
            System.out.println("测试" + number);
        }

        int index = findFirstBitIs1(number);
        int number1 = 0, number2 = 0;
        for (int i : arr) {
            if (isBit1(i, index))
                number1 ^= i;
            else
                number2 ^= i;
        }
        System.out.println(number1);
        System.out.println(number2);
    }

    private int findFirstBitIs1(int number) {
        int indexBit = 0;
        while ((number & 1) == 0) {
            number = number >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    private boolean isBit1(int number, int index) {
        number = number >> index;
        return (number & 1) == 0;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 6, 3, 2, 5, 5};
        Problem40 test = new Problem40();
        test.findNumsAppearOnce(arr);
    }
}

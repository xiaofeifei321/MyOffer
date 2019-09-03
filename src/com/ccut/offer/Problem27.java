package com.ccut.offer;

/**
 * 字符串全排列
 */
public class Problem27 {
    /*
     * 参数arrayA:给定字符串的字符数组
     * 参数start:开始遍历字符与其后面各个字符将要进行交换的位置
     * 参数end:字符串数组的最后一位
     * 函数功能：输出字符串数字的各个字符全排列
     * 从字符串中选出一个字符作为排列的第一个字符，
     * 然后对剩余的字符进行全排列。如此递归处理，从而得到所有字符的全排列。
     */
    public void recursionArrange(char[] arrayA, int start, int end) {
        if (end <= 1)
            return;
        if (start == end) {
            for (int i = 0; i < arrayA.length; i++)
                System.out.print(arrayA[i]);
            System.out.println();
        } else {
            for (int i = start; i <= end; i++) {
                swap(arrayA, i, start);
                recursionArrange(arrayA, start + 1, end);
                swap(arrayA, i, start);
            }
        }

    }

    //交换数组m位置和n位置上的值
    public void swap(char[] arrayA, int m, int n) {
        char temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
    }

    /**
     * 非递归方式实现
     *
     * @param args
     */
    public static void main(String[] args) {
        Problem27 test = new Problem27();
        String A = "abc";
        char[] arrayA = A.toCharArray();
        test.recursionArrange(arrayA, 0, arrayA.length - 1);
    }
}

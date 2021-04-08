package com.ccut.offer;

/**
 * 二叉树搜索树的后序遍历
 * 题目：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Problem23 {

    public boolean verifySequence(int[] array, int start, int end) throws Exception {
        if (array == null || array.length < 2)
            return true;
        if (start < 0) {
            throw new Exception("first can't be less than 0");
        }
        if (end > array.length) {
            throw new Exception("last can't be greater than the count of the element.");
        }
        int root = array[end];
        //在二叉搜索树中左子树的结点小于根节点
        int i = start;
        for (; i < end; i++) {
            if (array[i] > root)
                break;
        }
        //在二叉搜索树中右子树的结点大于根节点
        int j = i;
        for (; j < end; j++) {
            if (array[j] < root)
                return false;
        }
        //判断左子树是不是二叉搜索树
        boolean left = true;
        if (i > start)
            left = verifySequence(array, start, i - 1);
        //判断右子树是不是二叉搜索树
        boolean right = true;
        if (i < end)
            right = verifySequence(array, i, end - 1);
        return (left && right);
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {5, 7, 6, 9, 11, 10, 8};
        Problem23 test = new Problem23();
        System.out.println(test.verifySequence(arr, 0, arr.length - 1));
    }
}

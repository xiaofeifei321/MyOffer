package com.ccut.offer;

import java.util.ArrayList;

/**
 * 数组中的逆序对个数
 * 1:数组｛7，5，6，4｝中，一共存在5对逆序对，分别是｛7，6｝，｛7，5｝，｛7，4｝，｛6，4｝，｛5，4}
 * 先把数组分隔成子数组，先统计出子数组内部的逆序对的数目，然后再统计出两个相邻子数组之间的逆序对的数目。
 * 在统计逆序对的过程中，还需要对数组进行排序。如果对排序算法很熟悉，我们不难发现这个排序的过程就是归并排序。
 */
public class Problem36 {
    private ArrayList<Integer> assignList(ArrayList<Integer> list, int start, int end) {
        ArrayList<Integer> des = new ArrayList<Integer>();
        for (int i = start; i < end; i++) {
            des.add(list.get(i));
        }
        return des;
    }

    public long mergeTwoList(ArrayList<Integer> list, int start, int half, int end) {
        long count = 0;
        ArrayList<Integer> tempLeft = assignList(list, start, half);
        ArrayList<Integer> tempRight = assignList(list, half, end);
        int leftIndex = 0;
        int rightIndex = 0;
        int index = start;
        while (leftIndex < tempLeft.size() && rightIndex < tempRight.size()) {
            int temp1 = tempLeft.get(leftIndex);
            int temp2 = tempRight.get(rightIndex);
            if (temp1 > temp2) {
                count += tempLeft.size() - leftIndex;
                list.set(index, temp2);
                index++;
                rightIndex++;
            } else {
                list.set(index, temp1);
                index++;
                leftIndex++;
            }
        }
        for (; leftIndex < tempLeft.size(); leftIndex++) {
            list.set(index, tempLeft.get(leftIndex));
            index++;
        }
        for (; rightIndex < tempRight.size(); rightIndex++) {
            list.set(index, tempRight.get(rightIndex));
            index++;
        }
        return count;
    }

    public long getInversions(ArrayList<Integer> list, int start, int end) {
        long count = 0;
        if ((end - start) <= 1)
            return 0;
        int half = start + (end - start) / 2;
        count += getInversions(list, start, half);
        count += getInversions(list, half, end);
        count += mergeTwoList(list, start, half, end);
        return count;
    }

    public long getInversePairs(int[] arr) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            al.add(arr[i]);
        }
        int end = arr.length;
        return getInversions(al, 0, end);
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 4};
        Problem36 test = new Problem36();
        System.out.println(test.getInversePairs(arr));
    }
}

package com.ccut.offer;

/**
 * 数组中取最小的n位数字
 *
 * @author root
 */
public class Problem30 {
    /**
     * 快速排序一次排序的过程：
     *接下来我们每次从输入的n个整数中读入一个数。如果容器中已有数字少于k个，则直接把这次读入的整数放入容器中；
     * 如果容器中已有k个数字了，也就是容器已满，此时我们不能再插入新的数字了而只能替换已有的数字。找出这已有的k个数中的最大值，然后拿这次待插入的整数和最大值进行比较。
     * 如果待插入的值比当前已有的最小值小，则用这个数替换当前已有的最大值；如果待插入的值比当前已有的最大值还大，那么这个数不可能是最小的k个整数之一，于是我们可以抛弃这个整数。
     * @return
     */
    public int partition(int[] arr, int left, int right) {
        int result = arr[left];
        if (left > right)
            return -1;
        while (left < right) {
            while (left < right && arr[right] >= result) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] < result) {
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = result;
        return left;
    }

    public int[] getLeastNumbers(int[] input, int k) {
        if (input.length == 0 || k <= 0)
            return null;
        int[] output = new int[k];
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(input, start, end);
            } else {
                start = index + 1;
                index = partition(input, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            output[i] = input[i];
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6};
        Problem30 test = new Problem30();
        int[] output = test.getLeastNumbers(arr, 2);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ",");
        }
    }
}

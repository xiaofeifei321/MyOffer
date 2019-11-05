package com.ccut.offer;

/**
 * 连续子数组求和最大 示例 ｛1，-2，3，10，-4，7，2，-5｝
 *我们试着从头尾逐个累加示例数组中的每个数字。初始化和为0.
 * 第一步加上第一个数字，此时和为1.接下来第二步加上数字-2，和就编程了-1.第三步加上数字3.我们注意到由于此前累计的和为-1，小于0，那如果用-1加3，得到的和为2，比3本身还小。
 * 也就是说从第一个数字开始的子数组的和会小于从第三个数字开始的子数组的和。因此我们不用考虑从第一个子数组，之前累计的和也被抛弃。
 *  我们从第三个数字重新开始累加，此时得到的和为3.接下来第四步加10，得到和为13.第五步加上-4，和为9.我们发现-4是一个负数，因此累加-4之后得到的和比原来的还小
 * 因此我们要把之前得到的和13保存下来，它有可能是最大的子数组的和。第六步加上数字7，9加7的结果是16，此时和比之前最大的和13还要大，把最大的子数组的和由13更新为16.
 * 第七步加上2，累加得到的和为18，同时我们也要更新最大子数组的和。第八步加上最后一个数字-5，由于得到结果为13，小于此前得到的最大和18，因此最终最大的子数组的和为18，
 * 对应的子数组是｛3，10，-4，7，2｝
 *   1：前面的累计和为负数，舍弃
 *   2：前面的数字和为正，下一个数字为负数，我们把原来的结果保存下来，加上这个负数，再加负数后面的以为数字
 *   3：使用一个变量保存数组中最大的值
 */
public class Problem31 {
    public Integer findGreatestSum(int[] arr) {

        if (arr.length == 0)
            return null;
        //int最小的数
        int greatest = 0x80000000;
        int curSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (curSum <= 0)
                curSum = arr[i];
            else
                curSum += arr[i];
            if (curSum > greatest)
                greatest = curSum;
        }
        return greatest;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        Problem31 test = new Problem31();
        System.out.println(test.findGreatestSum(arr));
    }
}

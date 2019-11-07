package com.ccut.offer;

/**
 * 题目:
 *    把n个骰子仍在地上，所有骰子朝上一面的点数之和为s，输入n，打印出s的所有可能的值出现的概率
 * 解法一:递归，递归结束的条件：n=1,此时某一个点数和出现的次数+1
 *     可以先把n个骰子分为两堆：第一堆只有一个，另一个有n-1个。单独的那一个有可能出现从1到6的点数。我们需要计算从1到6的每一种点数和剩下的n-1个骰子来计算点数和。接下来把剩下的n-1个骰子还是分成两堆，
 *     第一堆只有一个，第二堆有n-2个。我们把上一轮哪个单独骰子的点数和这一轮单独骰子的点数相加，再和n-2个骰子来计算点数和
 * 解法二：全排列
 *     回溯法枚举n个骰子（6面）的全排列，然后计算每一次排列所有值的和，并统计该和的出现的次数，除以6^n（全排列的全部可能性），即为概率。(这里就不列出代码)
 *  解法三：
 *    当有n个骰子，点数和为s，则每一种点数和出现的次数记为f(n,s)。现在假设我有n-1个骰子，再增加一个骰子，它的点数只能是1到6，则n个骰子得到点数和为s的情况有6种，
 *      所以f(n,s)=f(n-1,s-1)+f(n-1,s-2)+…+f(n-1,s-6)，当有一个骰子时，f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1

 */
public class Problem43 {
    private static final int g_maxValue = 6;

    // 基于递归求骰子点数，时间效率不高
    public static void PrintProbability(int number) {
        if (number < 1)
            return;
        int maxSum = number * g_maxValue;
        int[] pProbabilities = new int[maxSum - number + 1];
        // 初始化，开始统计之前都为0次
        for (int i = number; i <= maxSum; i++) {
            pProbabilities[i - number] = 0;
        }
        double total = Math.pow(g_maxValue, number);
        // probability(number,pProbabilities);这个函数计算n~6n每种情况出现的次数
        probability(number, pProbabilities);
        for (int i = number; i <= maxSum; i++) {
            double ratio = pProbabilities[i - number] / total;
            System.out.println("i: " + i + " ratio: " + ratio);
        }
    }

    public static void probability(int number, int[] pProbabilities) {
        for (int i = 1; i <= g_maxValue; i++) {// 从第一个骰子开始
            probability(number, number, i, pProbabilities);
        }
    }

    // 总共original个骰子，当前第 current个骰子，当前的和，贯穿始终的数组
    public static void probability(int original, int current, int sum,
                                   int[] pProbabilities) {
        if (current == 1) {
            pProbabilities[sum - original]++;
        } else {
            for (int i = 1; i <= g_maxValue; i++) {
                probability(original, current - 1, sum + i, pProbabilities);
            }
        }
    }

    public static void main(String[] args) {
        Problem43 problem43 = new Problem43();
        problem43.PrintProbability(3);
    }

}

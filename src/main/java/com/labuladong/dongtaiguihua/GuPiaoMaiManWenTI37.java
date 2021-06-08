package com.labuladong.dongtaiguihua;

/**
 * 股票交易问题
 * https://leetcode-cn.com/circle/article/qiAgHn/
 */
public class GuPiaoMaiManWenTI37 {
    /**
     * 第一道 k=1
     * 给定一个数组prices，它的第i个元素prices[i]表示一支给定的股票第i天的价格，只能选择某一天买入这只股票，然后在未来的一个不同工单日子卖掉该股票，
     * 求获得的最大利润
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[length - 1][0];
    }

    /**
     * 第i天的收益只和第i-1 天的收益有关
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit0 = 0, profit1 = -prices[0];
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            //
            profit0 = Math.max(profit0, profit1 + prices[i]);
            //profit1 表示第i天股票价格的最小值(相反数的最大值)
            profit1 = Math.max(profit1, -prices[i]);
        }
        return profit0;
    }

    /**
     * 第二道 K为正无穷
     * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 输入: prices = [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3
     */
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[length - 1][0];
    }

    public int maxProfit4(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit0 = 0, profit1 = -prices[0];
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            int newProfit0 = Math.max(profit0, profit1 + prices[i]);
            int newProfit1 = Math.max(profit1, profit0 - prices[i]);
            profit0 = newProfit0;
            profit1 = newProfit1;
        }
        return profit0;
    }


    /**
     * 第三道 k=2
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易
     * 输入：prices = [3,3,5,0,0,3,1,4]
     * 输出：6
     * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     */
    public int maxProfit5(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][][] dp = new int[length][3][2];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            /**
             * 最多完成两比交易，也就是说也可以完成一比啊
             */
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
        }
        return dp[length - 1][2][0];
    }

    /**
     * 第四道  k为任意值
     * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     * 输入：k = 2, prices = [2,4,1]
     * 输出：2
     * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 (股票前一天买入，后一天卖出)
     */
    public int maxProfit6(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        if (k >= length / 2) {
            //k为正无穷的情况
            return maxProfitt(prices);
        }
        int[][][] dp = new int[length][k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = k; j > 0; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[length - 1][k][0];
    }

    /**
     * 就是k为正无穷的情况
     * @param prices
     * @return
     */
    public int maxProfitt(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[length - 1][0];
    }


    /**
     * 情况5 ：k为正无穷但是有冷却时间
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。?
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     *     你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *     卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     *
     *
     * 输入: [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     */

    public int maxProfit6(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int prevProfit0 = 0, profit0 = 0, profit1 = -prices[0];
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            int nextProfit0 = Math.max(profit0, profit1 + prices[i]);
            int nextProfit1 = Math.max(profit1, prevProfit0 - prices[i]);
            prevProfit0 = profit0;
            profit0 = nextProfit0;
            profit1 = nextProfit1;
        }
        return profit0;
    }
    /**
     * 情况6
     * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * 返回获得利润的最大值。
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     *
     *
     * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出: 8
     * 解释: 能够达到的最大利润:
     * 在此处买入 prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) =
     */
    public int maxProfit7(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[length - 1][0];
    }



}





package com.labuladong.dongtaiguihua;

/**
 * 编辑距离：
 * 给定两个单子Word1和Word2，将Word1转化为Word2所用的最小操作数
 * 可以对单词进行三种操作
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 */
public class BianJiJuli {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }
        // DP 数组
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //删除
                int left = D[i - 1][j] + 1;
                //插入，在s1[i]插入一个和s2[j]一样的字符.s2[j]被匹配，前移j，继续和i做对比
                int down = D[i][j - 1] + 1;
                //替换跳过
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }


    public static void main(String[] args) {
        BianJiJuli bianJiJuli = new BianJiJuli();
        String a = "rad";
        String b = "apple";
        System.out.println(bianJiJuli.minDistance(a, b));
    }
}

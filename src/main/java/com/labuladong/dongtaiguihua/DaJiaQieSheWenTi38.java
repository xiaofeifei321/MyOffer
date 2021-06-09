package com.labuladong.dongtaiguihua;

import sun.applet.Main;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 打家窃舍问题
 */
public class DaJiaQieSheWenTi38 {
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    /**
     * 自顶部向下解法
     */
    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }
        int res = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
        memo[start] = res;
        return res;
    }

    /**
     * 自底向上
     */
    private int rob1(int[] nums) {
        int n = nums.length;
        System.out.println("n= " + n);
        int[] dp = new int[n + 2];
        //dp[i]=X 表示从i间房子开始抢劫，最多抢到的钱为X
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }


    /**
     * 如果房子是环形的
     */

    public int rob3(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, n - 2),
                robRange(nums, 1, n - 1));
    }

    // 仅计算闭区间 [start,end] 的最优结果
    int robRange(int[] nums, int start, int end) {
        int n = nums.length;
        int dp_i_1 = 0, dp_i_2 = 0;
        int dp_i = 0;
        for (int i = end; i >= start; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }

    /**
     * 如果房子是在一棵二叉树上
     *
     * @param args
     */
    Map<TreeNode, Integer> memo1 = new HashMap<>();

    // rob返回根节点得到的最大
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (memo1.containsKey(root)) {
            return memo1.get(root);
        }

        // 抢，然后去下下家
        int do_it = root.val
                + (root.left == null ?
                0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ?
                0 : rob(root.right.left) + rob(root.right.right));
        // 不抢，然后去下家
        int not_do = rob(root.left) + rob(root.right);

        int res = Math.max(do_it, not_do);
        memo1.put(root, res);
        return res;
    }

    public static void main(String[] args) {
        DaJiaQieSheWenTi38 daJiaQieSheWenTi38 = new DaJiaQieSheWenTi38();
        int[] nums = new int[]{
                1, 2, 3, 1
        };
        System.out.println(daJiaQieSheWenTi38.rob1(nums));
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

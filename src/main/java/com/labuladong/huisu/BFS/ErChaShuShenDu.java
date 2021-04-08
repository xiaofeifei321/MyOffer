package com.labuladong.huisu.BFS;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
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

    /**
     * 二叉树的最小深度
     */
    public class ErChaShuShenDu {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> q = new LinkedList<>();//核心数据结构
            q.offer(root);//将起点加入队列
            int step = 1;//记录扩散的步数
            while (!q.isEmpty()) {
                int sz = q.size();
                //当前节点向四周扩散
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.poll();
                    //判断是否到达终点
                    if (cur.left == null && cur.right == null) {
                        return step;
                    }
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }

                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
                step++;
            }
            return step;
        }
    }

    public static void main(String[] args) {
        Queue q = new LinkedList<>();//核心数据结构
        System.out.println(q.offer(666));
        System.out.println(q.size());
        System.out.println(q.poll());
        System.out.println(q.size());
    }

}

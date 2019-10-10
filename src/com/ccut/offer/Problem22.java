package com.ccut.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印二叉树 二叉树的层序遍历
 */
public class Problem22 {
    /**
     * 二叉树层次遍历
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //往队列插入元素
        queue.offer(root);
        while (!queue.isEmpty()) {
            //从队列中取出一个元素
            TreeNode temp = queue.poll();
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
}
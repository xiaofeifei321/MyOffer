package com.ccut.offer;

import com.ccut.util.BinaryTreeNode;

/**
 * 树的子结构 输入两棵二叉树A和B，判断B是不是A的子结构
 * 思路：
 * 用递归方式实现
 */
public class Problem17 {
    public boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (root1.data == root2.data)
                result = doesTree1HaveTree2(root1, root2);
            if (!result)
                result = hasSubTree(root1.left, root2);
            if (!result)
                result = hasSubTree(root1.right, root2);
        }
        return result;
    }

    public boolean doesTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.data != root2.data)
            return false;
        return doesTree1HaveTree2(root1.left, root2.left)
                && doesTree1HaveTree2(root1.right, root2.right);
    }
}

package com.ccut.offer;

/**
 *
 * 二叉树中下一个节点
 *     题目描述:给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回,注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *     解法1：中序遍历顺序：左根右（1：平淡算是否有右字树 2：该点为该父节点的左右两个孩子进行判断）
 *               1：如果该节点有右字树，则该节点的父节点pNode.next则为下一个节点
 *               2：没有右子树
 *
 */
public class Problem57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 二叉树为空
        if (pNode == null)
            return null;
        // 若有右孩子，则找右孩子的最左节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        // 该节点不是根节点，若该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。
        while (pNode.next != null) {
            if (pNode.next.left == pNode)
                return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

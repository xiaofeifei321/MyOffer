package com.ccut.offer;

/**
 * 二叉搜索树和双向链表
 * 由于要求链表是有序的，可以借助二叉树中序遍历，因为中序遍历算法的特点就是从小到大访问结点。中序遍历过程中，根节点不断加到右边，这样可以保持从左到右升序。
 * 由于中序遍历过程正好是转换成链表的过程，即可采用递归处理。
 */
public class Problem26 {
	// 双向链表的左边头结点和右边头节点
	TreeNode leftHead = null;
	TreeNode rightHead = null;

	/**
	 * 中序遍历，递归
	 * 
	 * @param pRootOfTree
	 * @return
	 */
	public TreeNode Convert(TreeNode pRootOfTree) {
		// 递归调用叶子节点的左右节点返回null
		if (pRootOfTree == null)
			return null;
		// 第一次运行时，它会使最左边叶子节点为链表第一个节点
		Convert(pRootOfTree.left);
		if (rightHead == null) {
			leftHead = rightHead = pRootOfTree;
		} else {
			// 把根节点插入到双向链表右边，rightHead向后移动
			rightHead.right = pRootOfTree;
			pRootOfTree.left = rightHead;
			rightHead = pRootOfTree;
		}
		// 把右叶子节点也插入到双向链表（rightHead已确定，直接插入）
		Convert(pRootOfTree.right);
		// 返回左边头结点
		return leftHead;
	}

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(6);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(14);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(8);
		TreeNode node5 = new TreeNode(12);
		TreeNode node6 = new TreeNode(16);
		root1.left = node1;
		root1.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		Problem26 problem26 = new Problem26();
		problem26.Convert(root1);
	}
}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right
				+ "]";
	}
}
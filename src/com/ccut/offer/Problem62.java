package com.ccut.offer;

import com.ccut.offer.util.TreeNode;

import java.util.Stack;

/**
 *二叉搜索树的第k个结点
 */
public class Problem62 {
	private int cnt;
	private TreeNode res;

	/**
	 * 迭代中序遍历
	 */
	TreeNode KthNode_2(TreeNode pRoot, int k) {
		if (pRoot == null || k == 0)
			return null;
		int cnt = 0;
		Stack<TreeNode> stack = new Stack<>();
		while (pRoot != null || !stack.isEmpty()) {
			while (pRoot != null) {
				stack.push(pRoot);
				pRoot = pRoot.left;
			}
			pRoot = stack.pop();
			cnt++;
			if (cnt == k)
				return pRoot;
			pRoot = pRoot.right;
		}
		return null;
	}

	TreeNode KthNode(TreeNode pRoot, int k) {
		inOrder(pRoot, k);
		return res;
	}

	/**
	 * 递归中序遍历
	 */
	void inOrder(TreeNode pRoot, int k) {
		if (pRoot == null)
			return;
		if (cnt > k)
			return;
		inOrder(pRoot.left, k);
		cnt++;
		if (cnt == k)
			res = pRoot;
		inOrder(pRoot.right, k);
	}

	public static void main(String[] args) {
		Problem62 problem62 = new Problem62();

		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(8);
		// TreeNode n8 = new TreeNode(8);
		// TreeNode n9 = new TreeNode(9);
       //测试
		n1.left = n2;
		n1.right = n3;

		n2.left = n4;
		n2.right = n5;

		n3.left = n6;
		n3.right = n7;

		// n4.left = n8;
		// n4.right = n9;
		System.out.println("第" + 3 + "大的节点是：");
		System.out.println(problem62.KthNode(n1, 3));
	}
}

package com.ccut.offer;

import java.util.Stack;

import com.ccut.util.BinaryTreeNode;

/**
 * 二叉树中和为某一值路径
 * 思路:
 *   用一个栈来保存信息， 
 */
public class Problem24 {
	public void findPath(BinaryTreeNode root, int k) {
		if (root == null)
			return;
		Stack<Integer> stack = new Stack<Integer>();
		findPath(root, k, stack);
	}

	public void findPath(BinaryTreeNode root, int k, Stack<Integer> path) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			if (root.data == k) {
				System.out.println("路径开始");
				for (int i : path)
					System.out.print(i + ",");
				System.out.print(root.data);
			}
		} else {
			path.push(root.data);
			findPath(root.left, k - root.data, path);
			findPath(root.right, k - root.data, path);
			path.pop();
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode root1 = new BinaryTreeNode();
		BinaryTreeNode node1 = new BinaryTreeNode();
		BinaryTreeNode node2 = new BinaryTreeNode();
		BinaryTreeNode node3 = new BinaryTreeNode();
		BinaryTreeNode node4 = new BinaryTreeNode();
		BinaryTreeNode node5 = new BinaryTreeNode();
		BinaryTreeNode node6 = new BinaryTreeNode();
		root1.left = node1;
		root1.right = node2;
		node1.left = node3;
		node1.right = node4;
		node4.left = node5;
		node4.right = node6;
		root1.data = 8;
		node1.data = 8;
		node2.data = 7;
		node3.data = 9;
		node4.data = 2;
		node5.data = 4;
		node6.data = 7;
		Problem24 test = new Problem24();
		test.findPath(root1, 25);
	}
}

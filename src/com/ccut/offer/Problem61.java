package com.ccut.offer;

import com.ccut.offer.util.TreeNode;

/**
 * 问题：反序列化有问题
 * 
 * @author root
 */
public class Problem61 {
	static StringBuilder sb = null;

	static String Serialize(TreeNode root) {
		if (root == null)
			return "#";
		sb = new StringBuilder();
		Serialize_solve(root);
		String s = sb.toString();
		return s.substring(0, s.length() - 1);
	}

	private static void Serialize_solve(TreeNode root) {
		if (root == null) {
			sb.append("#,");
			return;
		}
		sb.append(root.val + ",");
		Serialize_solve(root.left);
		Serialize_solve(root.right);
	}

	static int index;

	// 遇数作左；遇#变向
	static TreeNode Deserialize(String str) {
		if (str == null || str.trim().equals(""))
			return null;

		String[] strs = str.split(",");
		index = 0;
		return Deserialize_solve(strs);
	}

	private static TreeNode Deserialize_solve(String[] chars) {
		if (chars[index].equals("#")) {
			index++;
			return null;
		}
		System.out.println(chars[index]);
		TreeNode node = new TreeNode(Integer.parseInt(chars[index++]));
		node.left = Deserialize_solve(chars);
		node.right = Deserialize_solve(chars);
		return node;
	}

	/**
	 * 8 6 10 5 7 9 11
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode A = new TreeNode(8);
		TreeNode B = new TreeNode(6);
		TreeNode C = new TreeNode(10);
		TreeNode D = new TreeNode(5);
		TreeNode E = new TreeNode(7);
		TreeNode F = new TreeNode(9);
		TreeNode G = new TreeNode(11);

		A.left = B;
		A.right = C;
		B.left = D;
		B.right = E;
		C.left = F;
		C.right = G;

		String s = Serialize(A);
		System.out.println(s);
		Deserialize(s);
	}
}

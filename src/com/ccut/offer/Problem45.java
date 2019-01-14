package com.ccut.offer;

import com.ccut.util.ListNode;
/**
 * 圆圈中最后剩下的数字 
 */
public class Problem45 {
	public static int lastRemaining(int n, int m) {
		if (n < 1 || m < 1)
			return -1;
		ListNode head = new ListNode(0);
		ListNode cur = head;
		for (int i = 1; i < n; i++) {
			ListNode node = new ListNode(i);
			cur.next = node;
			cur = cur.next;
		}
		cur.next = head;
		cur = head;

		while (true) {
			// 长度为1结束循环
			if (cur.next == cur)
				return cur.key;
			// 向后移动
			for (int i = 1; i < m; i++)
				cur = cur.next;
			// 删除当前节点
			cur.key = cur.next.key;
			cur.next = cur.next.next;
			// 删除后，cur停在被删节点的后一节点处
		}
	}

	public static int lastRemaining1(int m, int n) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		for (int i = 1; i < m; i++) {
			ListNode listNode = new ListNode(i);
			cur.next = listNode;
			cur = cur.next;
		}
		head = cur.next;
		cur = head;
		while (true) {
			if (cur.next == cur) 
                return cur.key;
			for (int i = 1; i < n; i++) 
				cur=cur.next;
			cur.key=cur.next.key;
			cur.next=cur.next.next;
		}
	}

	// 另一个思路分析过程较复杂，不强求了。可搜约瑟夫环进行了解。
	public static void main(String[] args) {
		System.out.println(lastRemaining1(3, 2)); // 3
		// System.out.println(lastRemaining(6,7)); //4
		// System.out.println(lastRemaining(0,7)); //-1
	}
}

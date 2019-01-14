package com.ccut.offer;
/**
 *反转链表
 */
public class Problem15 {
	public ListNode ReverseList(ListNode head){
		if(head == null)
			return null;
		ListNode preListNode = null;
		ListNode nowListNode = head;
		
		while(nowListNode != null){
			ListNode nextListNode = nowListNode.next;   //保存下一个结点
			nowListNode.next = preListNode;             //当前结点指向前一个结点
			preListNode = nowListNode;                  //前任结点 到现任节点
			nowListNode = nextListNode;					//现任节点到下一结点
		}
		return preListNode;
	}
	public static void main(String[] args){
		ListNode head = new ListNode();
		ListNode second = new ListNode();
		ListNode third = new ListNode();
		ListNode forth = new ListNode();
		head.next = second;
		second.next = third;
		third.next = forth;
		head.data = 1;
		second.data = 2;
		third.data = 3;
		forth.data = 4;
		Problem15 test = new Problem15();
		ListNode result = test.ReverseList(head);
		System.out.println(result.data);
	}
}

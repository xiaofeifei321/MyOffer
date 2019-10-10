package com.ccut.offer;

/**
 * 链表中倒数第k个结点
 * 思路：两个指针(两个类）A比B先走K步,A到达链表结尾的时候，B刚好指到k位置
 */
public class Problem14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode ANode = head;
        ListNode BNode = null;
        for (int i = 0; i < k - 1; i++) {
            if (ANode.next != null)
                ANode = ANode.next;
            else
                return null;
        }
        BNode = head;
        while (ANode.next != null) {
            ANode = ANode.next;
            BNode = BNode.next;
        }
        return BNode;
    }

    public static void main(String[] args) {
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
        Problem14 test = new Problem14();
        ListNode result = test.FindKthToTail(head, 2);
        System.out.println(result.data);
    }
}

class ListNode {
    public int data;
    public ListNode nextNode;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int key) {
        this.data = key;
    }
}
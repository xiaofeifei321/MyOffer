package com.ccut.offer;

import com.ccut.util.ListNode;

/**
 * 题目：
 * 0，1，，，，，n-1这n 个数字排成一个圆圈，从数字0开始每次从这个圆圈中删除第m个数字。求出这个圆圈里剩下的最后一个数字,0，1，2，3，4这5个数字组成的一个圆圈，从数字0开始每次删除第3个数字，则删除的前四个数字依次是2，0，4，1因此最后剩下的数字是3.
 * 圆圈中最后剩下的数字
 * 解法一:
 *    1：使用环形链表来进行计算,时间复杂度为0(n)
 *    2:
 *
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
                cur = cur.next;
            cur.key = cur.next.key;
            cur.next = cur.next.next;
        }
    }

    // 另一个思路分析过程较复杂，不强求了。可搜约瑟夫环进行了解。
    public static void main(String[] args) {
        System.out.println(lastRemaining1(3, 2)); // 3
        // System.out.println(lastRemaining(6,7)); //4
        // System.out.println(lastRemaining(0,7)); //-1
    }
}

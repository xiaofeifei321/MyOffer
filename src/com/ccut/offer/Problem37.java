package com.ccut.offer;

import com.ccut.util.ListNode;

/**
 * 两个链表的第一个公共结点
 */
public class Problem37 {
    public ListNode findFirstCommonNode(ListNode root1, ListNode root2) {
        int length1 = getLength(root1);
        int length2 = getLength(root2);
        ListNode pointLongListNode = null;
        ListNode pointShortListNode = null;
        int dif = 0;
        if (length1 > length2) {
            pointLongListNode = root1;
            pointShortListNode = root2;
            dif = length1 - length2;
        } else {
            pointLongListNode = root2;
            pointShortListNode = root1;
            dif = length2 - length1;
        }
        for (int i = 0; i < dif; i++)
            pointLongListNode = pointLongListNode.next;
        while (pointLongListNode != null && pointShortListNode != null
                && pointLongListNode != pointShortListNode) {
            pointLongListNode = pointLongListNode.next;
            pointShortListNode = pointShortListNode.next;
        }
        return pointLongListNode;
    }

    private int getLength(ListNode root) {
        int result = 0;
        if (root == null)
            return result;
        ListNode point = root;
        while (point != null) {
            point = point.next;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

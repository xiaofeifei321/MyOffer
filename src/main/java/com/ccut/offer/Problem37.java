package com.ccut.offer;

import com.ccut.util.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共结点
 * 思路1:在第一链表上顺序遍历每个结点，没遍历到一个结点的时候，在第二个链表上顺序遍历每个结点。如果在第二个链表上有一个结点和第一个链表上的结点一样，说明两个链表在这个结点上重合，于是就找到了他们的公共结点。如果第一个链表的长度为m，第二个链表的长度为n，显然该方法的时间复杂度为O(mn).
 *
 *如果我们从两个链表的尾部开始往前比较，最后一个相同的结点就是我们要找的结点。可问题是在单向链表中，我们只能从头结点开始按顺序遍历，最后才能到达尾节点。
 * 最后到达的尾节点却要最先被比较，这听起来是不是像后进先出，也是我们就能想到用栈的特点来解决这个问题：
 * 思路2：分别把两个链表的结点放入两个栈里，这样两个链表的尾节点就位于两个栈的栈顶，接下来比较两个栈顶的结点是否相同。如果相同，则把栈顶弹出接着比较下一个栈顶，直到找到最后一个相同的结点。
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

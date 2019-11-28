package com.ccut.offer;

import java.util.HashSet;

/**
 * 链表中环的入口节点
 * 1：证明链表中中又环
 * 在问题一中两指针相遇后，让一个指针从头结点开始，另一个从相遇结点开始，并以相同速度向后指，再次相遇时就是环的入口结点
 * 延伸问题：
 *     1：（1）环的长度、（2）整个链表的长度、（3）两个无环链表第一次相交的公共节点
 *    （1）环的长度，当快慢指针第一次相遇的时候，把该节点保存下来，让慢指针接着走，当再次到达刚才相遇的节点时所走过的步数就是环的长度。
 *    （2）利用第二步求出环以外的长度再加上环的长度，就是整个链表的长度
 *    （3）先分别求出两个链表的长度，让长的链表先走两个链表长度差的步数，再让两个链表一起走，当走到节点值相同的那个节点时，就是相交的第一个公共节点
 */
public class Problem55 {
    /**
     * 假设x为环前面的路程，a为环入口到相遇点的路程， c为环的长度
     * 当快慢指针相遇的时候： 此时慢指针走的路程为Sslow = x + m * c + a
     * 快指针走的路程为Sfast = x + n * c + a
     * 2 Sslow = Sfast
     * 2 * ( x + m*c + a ) = (x + n *c + a)
     * 从而可以推导出： x = (n - 2 * m )*c - a = (n - 2 *m -1 )*c + c - a
     * 即环前面的路程 = 数个环的长度（为可能为0） + c - a
     * 什么是c - a？这是相遇点后，环后面部分的路程。
     * 所以，我们可以让一个指针从起点A开始走，让一个指针从相遇点B开始继续往后走， 2个指针速度一样，
     * 那么，当从原点的指针走到环入口点的时候（此时刚好走了x） 从相遇点开始走的那个指针也一定刚好到达环入口点。
     * 所以两者会相遇，且恰好相遇在环的入口点。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop_2(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null)
            return null;
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        //先判断有没有环
        while (fast != slow) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                //没有环
                return null;
            }
        }

        fast = pHead;//把fast指向头节点
        //有环
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 利用HashSet元素不能重复
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (pHead != null) {
            if (!hashSet.add(pHead)) {
                return pHead;
            }
            pHead = pHead.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Problem55 problem55 = new Problem55();
    }


}
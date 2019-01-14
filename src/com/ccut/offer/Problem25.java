package com.ccut.offer;

/**
 * 复杂链表的复制 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。 （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * 分为三步： 1）
 * 在旧链表中创建新链表，此时不处理新链表的兄弟节点 ； 
 * 2）根据旧链表的兄弟节点，初始化新链表的兄弟节点； 3）从旧链表中拆分得到新链表；
 */
public class Problem25 {
	static class Node {
		int value;
		Node next;
		Node sbiling;

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("value = " + value);
			sb.append(", next = " + (next == null ? "null" : next.value));
			sb.append(", sbiling = "
					+ (sbiling == null ? "null" : sbiling.value));
			return sb.toString();
		}
	}

	public static void copyList(Node head) {
		Node node = head;
		while (node != null) {
			Node copyNode = new Node();
			copyNode.value = node.value;
			copyNode.next = node.next;
			copyNode.sbiling = null;
			node.next = copyNode;
			node = copyNode.next;
		}
	}

	public static void setSbiling(Node head) {
		Node node = head;
		while (node != null) {
			Node copyNode = node.next;
			if (node.sbiling != null) {
				copyNode.sbiling = node.sbiling.next;
			}
			node = copyNode.next;
		}
	}

	public static Node disConnectList(Node head) {
		Node node = head;
		Node copyHead = null;
		Node copyNode = null;
		if (node != null) {
			copyHead = node.next;
			copyNode = node.next;
			node.next = copyNode.next;
			node = node.next;
		}
		while (node != null) {
			copyNode.next = node.next;
			copyNode = copyNode.next;
			node.next = copyNode.next;
			node = node.next;
		}
		return copyHead;
	}

	public static Node copy(Node head) {
		copyList(head);
		setSbiling(head);
		return disConnectList(head);
	}

	public static void main(String[] args) {
		Node head = new Node();
		head.value = 1;
		Node node2 = new Node();
		node2.value = 2;
		Node node3 = new Node();
		node3.value = 3;
		Node node4 = new Node();
		node4.value = 4;
		Node node5 = new Node();
		node5.value = 5;
		head.next = node2;
		head.sbiling = node3;
		node2.next = node3;
		node2.sbiling = node5;
		node3.next = node4;
		node4.next = node5;
		node4.sbiling = node2;
		Node copyHead = copy(head);
		Node node = copyHead;
		while (node != null) {
			System.out.println(node);
			node = node.next;
		}
	}
}

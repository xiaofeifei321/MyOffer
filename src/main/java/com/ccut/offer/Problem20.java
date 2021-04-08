package com.ccut.offer;

import java.util.Stack;

/**
 * 
 * 题目：定义栈的数据结构，要求添加一个min函数，能够得到栈的最小元素。要求函数min、push以及pop的时间复杂度都是O(1)。
 * 包含min的栈 思路： 使用两个stack，一个为数据栈，另一个为辅助栈。数据栈用于存储所有数据，辅助栈用于存储最小值。
 * 举个例子：
 * 入栈的时候：首先往空的数据栈里压入数字3，显然现在3是最小值，我们也把最小值压入辅助栈。接下来往数据栈里压入数字4。由于4大于之前的最小值，
 * 因此我们只要入数据栈，不压入辅助栈。
 * 出栈的时候：当数据栈和辅助栈的栈顶元素相同的时候，辅助栈的栈顶元素出栈。否则，数据栈的栈顶元素出栈。
 * 获得栈顶元素的时候：直接返回数据栈的栈顶元素。
 * 栈最小元素：直接返回辅助栈的栈顶元素。
 * 思路：
 *    栈的相关方法：
 *        push()进栈
 *        pop()栈顶元素出栈
 *        peek()查看栈顶元素但不移除
 *        offer添加 poll删除
 */
public class Problem20 {

	Stack<Integer> date = new Stack<>();// 存储数据
	Stack<Integer> min = new Stack<>();// 存储最小值

	public void push(int node) {
		date.push(node);
		if (min.empty()) {
			min.push(node);
		} else {
			min.push((min.peek()) > node ? node : min.peek());// min栈顶始终是最小值
		}
	}

	public void pop() {
		date.pop();
		min.pop();
	}

	public int top() {
		return date.peek();
	}

	public int min() {
		return min.peek();
	}
}

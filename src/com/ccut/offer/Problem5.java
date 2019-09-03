package com.ccut.offer;
/**
 * 两个栈实现队列
 */

import java.util.Stack;

public class Problem5 {
    public static void main(String[] args) {
        Problem5 solution18 = new Problem5();
        solution18.push(1);
        solution18.push(2);
        System.out.println(solution18.pop());
        solution18.pop();
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);// stack1负责入队
    }

    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("队列为空");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();// stcak2负责出队
    }
}
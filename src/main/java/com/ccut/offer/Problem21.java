package com.ccut.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入两个看另外一个是否为另外一个出栈的顺序
 * 
 * 栈的压入、弹出序列 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的） 思路：
 * 借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，这里是1，然后判断栈顶元素是不是出栈顺序的第一个元素，这里是4，很显然1≠4，
 * 所以我们继续压栈，直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，这样循环等压栈顺序遍历完成，
 * 如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
 */
public class Problem21 {
	public boolean IsPopOrder(ArrayList<Integer> pushA,ArrayList<Integer> popA) {
		if(pushA.size()!=popA.size()){
			return false;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int j=0;
	      for(int i=0;i<pushA.size();i++){
	    	  stack.push(pushA.get(i));
	    	  while((!stack.empty())&&(stack.peek()==popA.get(j))){
	    		  stack.pop();
	    		  j++;
	    	  }
	      }
	      if(stack.empty()){
	    	  return true;
	      }else{
	    	  return false;
	      }
    }
	public static void main(String[] args){
		ArrayList<Integer> pushA = new ArrayList<Integer>();
		pushA.add(1);
		pushA.add(2);
		pushA.add(3);
		pushA.add(4);
		pushA.add(5);
		ArrayList<Integer> popA = new ArrayList<Integer>();
		popA.add(4);
		popA.add(5);
		popA.add(3);
		popA.add(2);
		popA.add(1);
		Problem21 s = new Problem21();
		boolean res = s.IsPopOrder(pushA, popA);
		System.out.println(res);
	}
}

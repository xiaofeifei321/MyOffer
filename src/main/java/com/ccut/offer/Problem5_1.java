package com.ccut.offer;


import java.util.LinkedList;

/**
 * 两个队列实现栈
 *
 */
public class Problem5_1 {
    private LinkedList<String> queue1;
    private LinkedList<String> queue2;

    public Problem5_1(){
        queue1 = new LinkedList<String>();
        queue2 = new LinkedList<String>();
    }

    public String pop(){
        String re =null;
        if(queue1.size() == 0 && queue2.size() == 0){
            return null;
        }
        if(queue2.size() == 0){
            while(queue1.size() >0){
                re = queue1.removeFirst();
                if(queue1.size() != 0){
                    queue2.addLast(re);
                }
            }
        }else if(queue1.size() == 0){
            while(queue2.size() >0){
                re = queue2.removeFirst();
                if(queue2.size()!=0){
                    queue1.addLast(re);
                }
            }
        }
        return re;
    }
    public String push(String str){
        if(queue1.size() ==0 && queue2.size() == 0){
            queue1.addLast(str);
        }else if(queue1.size()!=0){
            queue1.addLast(str);
        }else if(queue2.size()!=0){
            queue2.addLast(str);
        }
        return str;
    }

    public static void main(String[] args) {
        Problem5_1 stack=new Problem5_1();
        String tmp;
        stack.push("1");
        stack.push("2");
        stack.push("3");
        tmp=stack.pop();
        System.out.println(tmp);//3
        stack.push("4");
        tmp=stack.pop();
        System.out.println(tmp);//4
        tmp=stack.pop();
        System.out.println(tmp);//2
        stack.push("5");
        stack.push("6");
        tmp=stack.pop();
        System.out.println(tmp);//6
        tmp=stack.pop();
        System.out.println(tmp);//5
        tmp=stack.pop();
        System.out.println(tmp);//1
    }
}
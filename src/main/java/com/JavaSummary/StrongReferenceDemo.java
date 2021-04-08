package com.JavaSummary;

/**
 * 强引用例子
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object();//这样定义默认的就是强引用
        Object obj2 = obj1;//obj2引用赋值,指向刚刚创建的Object对象
        //obj1=null;
        obj1 = null;
        //进行垃圾回收
        System.gc();

        System.out.println(obj1);
        System.out.println(obj2);
    }
}

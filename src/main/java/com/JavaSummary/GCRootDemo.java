package com.JavaSummary;

import java.util.PriorityQueue;

/*
 * 在java中可作为GC Roots的对象有：
 * 1.虚拟机栈（栈帧中的局部变量区，也叫做局部变量表）中引用的对象。
 * 2.方法区中的类静态属性引用的对象。
 * 3.方法区中常量引用的对象
 * 4.本地方法栈中JNI（Native方法）引用的对象。
 * */
public class GCRootDemo {
    private byte[] byteArray = new byte[100 * 1024 * 1024];

    private static GCRootDemo t2; //方法区中的类静态属性引用的对象。
    private static final GCRootDemo t3 = new GCRootDemo(); //方法区中常量引用的对象

    /**
     * 方法是是在栈里面的，栈里面的局部变量
     */
    public static void m1() {
        //虚拟机栈中的引用对象
        GCRootDemo t1 = new GCRootDemo();
        System.gc();
        System.out.println("第一次GC完成");
    }

    public static void main(String[] args) {
//        m1();
        for (int i = 0; i < 5; i++) {

        }


    }
}

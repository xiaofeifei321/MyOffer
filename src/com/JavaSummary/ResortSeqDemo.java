package com.JavaSummary;

public class ResortSeqDemo {
    int a= 0;
    boolean flag = false;

    public void method01() {
        System.out.println("��ȥ����һ");
        a = 1;
        flag = true;
    }

    public void method02() {
        if(flag) {
            System.out.println("��ȥ������");
            a = a + 5;
            System.out.println("reValue:" + a);
        }
    }

    public static void main(String[] args) {
        ResortSeqDemo resortSeqDemo=new ResortSeqDemo();
        resortSeqDemo.method01();
        resortSeqDemo.method02();
    }

}

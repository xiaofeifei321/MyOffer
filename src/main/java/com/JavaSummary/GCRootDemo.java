package com.JavaSummary;

import java.util.PriorityQueue;

/*
 * ��java�п���ΪGC Roots�Ķ����У�
 * 1.�����ջ��ջ֡�еľֲ���������Ҳ�����ֲ������������õĶ���
 * 2.�������е��ྲ̬�������õĶ���
 * 3.�������г������õĶ���
 * 4.���ط���ջ��JNI��Native���������õĶ���
 * */
public class GCRootDemo {
    private byte[] byteArray = new byte[100 * 1024 * 1024];

    private static GCRootDemo t2; //�������е��ྲ̬�������õĶ���
    private static final GCRootDemo t3 = new GCRootDemo(); //�������г������õĶ���

    /**
     * ����������ջ����ģ�ջ����ľֲ�����
     */
    public static void m1() {
        //�����ջ�е����ö���
        GCRootDemo t1 = new GCRootDemo();
        System.gc();
        System.out.println("��һ��GC���");
    }

    public static void main(String[] args) {
//        m1();
        for (int i = 0; i < 5; i++) {

        }


    }
}

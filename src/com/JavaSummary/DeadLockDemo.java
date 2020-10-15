package com.JavaSummary;/*
 * ������ָ���������������ϵĽ�����ִ�й����У���������Դ����ɵ�һ�ֻ���ȴ�������
 * ���������������ǽ����޷��ƽ���ȥ�����ϵͳ��Դ���㣬���̵���Դ�����ܹ��õ����㣬
 * �������ֵĿ�����Ҳ�ͺܵͣ�����ͻ����������޵���Դ������������
 * */

import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t�Լ����У�" + lockA + "\t���Ի�ã�" + lockB);
            //��ͣһ��
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t�Լ����У�" + lockB + "\t���Ի�ã�" + lockA);
            }
        }
    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA, lockB), "ThreadAAA").start();
        new Thread(new HoldLockThread(lockB, lockA), "ThreadBBB").start();

        /*
         * linux  ps -ef|grep xxxx    ls -l�鿴��ǰ���̵�����
         * windows�µ�java���г���Ҳ������ps�Ĳ鿴���̵��������Ŀǰ������Ҫ�鿴��ֻ��java
         *           jps = java ps      jps -l
         *           jstack
         * */
    }
}

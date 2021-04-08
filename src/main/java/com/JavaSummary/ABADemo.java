package com.JavaSummary;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.atomic.LongAdder;

/*
 * ABA����Ľ��  AtomicStampedReference
 * */
public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);


    public static void main(String[] args) {
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            // ��ͣ1�����߳�2����֤����t1�߳����һ��ABA����
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2019) + "\t" + atomicReference.get());
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("======������ABA����Ľ��=====");
        new Thread(() -> {
            //��ȡ�汾��
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t��1�ΰ汾�ţ�" + stamp);

//            ��ͣ1����t3�߳�
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //�����ĸ�ֵ, ����ֵ������ֵ�������汾��  ���°汾��
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t��2�ΰ汾�ţ�" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t��3�ΰ汾�ţ�" + atomicStampedReference.getStamp());
        }, "t3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t��1�ΰ汾�ţ�" + stamp);

//            ��ͣ1����t4�߳�
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomicStampedReference.compareAndSet(100, 2019, stamp, atomicStampedReference.getStamp() + 1);

            System.out.println(Thread.currentThread().getName() + "\t�޸ĳɹ��� " + result + "\t��ǰ����ʵ�ʰ汾�ţ�" + atomicStampedReference.getStamp());

        }, "t4").start();



/*//��������
        public static LongAdder count = new LongAdder();
//��������
        count.increment();
//����ȡֵ
        count*/
    }
}

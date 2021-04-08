package com.JavaSummary;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ֤��ReentrantLock1���� ��Դ��
 */
class Phone1 implements Runnable {
    Lock lock = new ReentrantLock();

    public void getLock() {
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t get lock");
            setLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
//            lock.unlock();
        }
    }

    public void setLock() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t set Lock");
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        getLock();
    }
}


public class ReenterLockDemo1 {
    public static void main(String[] args) {
        Phone1 phone1 = new Phone1();
        /**
         * ��ΪPhoneʵ����Runable�ӿ�
         */
        Thread t3 = new Thread(phone1, "t3");
        Thread t4 = new Thread(phone1, "t4");
        t3.start();
        t4.start();
    }
}

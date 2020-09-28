package com.myAutomatic;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicInteger {
    public static void main(String[] args) {
        final AtomicInteger count = new AtomicInteger(5);
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (Exception ignore) {
                }
                boolean re = count.compareAndSet(5, 10);
                System.out.println(Thread.currentThread().getName() + " compareAndSet " + re);
            });
            thread.start();
        }
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (Exception ignore) {
            }
            boolean re = count.compareAndSet(10, 5);
            System.out.println(Thread.currentThread().getName() + " compareAndSet " + re);
        });
        thread.start();
    }
}









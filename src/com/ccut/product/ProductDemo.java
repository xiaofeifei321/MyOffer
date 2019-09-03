package com.ccut.product;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者消费者问题
 *
 * @author root
 */
public class ProductDemo extends Thread {
    /**
     * @param args
     */
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new LinkedBlockingQueue();
        new Product(blockingQueue).start();
        new Consumer(blockingQueue).start();
    }
}


class Product extends Thread {
    private final BlockingQueue sharedQueue;

    public Product(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("product" + i);
                sharedQueue.put(i);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}


class Consumer extends Thread {
    private final BlockingQueue sharedQueue;

    public Consumer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        while (true) {
            int i;
            try {
                i = (int) sharedQueue.take();
                System.err.println("消费" + i);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

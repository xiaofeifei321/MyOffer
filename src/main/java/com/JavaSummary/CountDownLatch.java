package com.JavaSummary;

/*
*
* */
public class CountDownLatch {
    public static void main(String[] args) throws Exception{
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(6);

        for(int i=1;i<=6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t线程"+ Thread.currentThread().getId()+"干活");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t主线程"+ Thread.currentThread().getId()+"干活");
    }
}

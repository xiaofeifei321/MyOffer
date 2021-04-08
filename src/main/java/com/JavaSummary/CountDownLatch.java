package com.JavaSummary;

/*
*
* */
public class CountDownLatch {
    public static void main(String[] args) throws Exception{
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(6);

        for(int i=1;i<=6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t�߳�"+ Thread.currentThread().getId()+"�ɻ�");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t���߳�"+ Thread.currentThread().getId()+"�ɻ�");
    }
}

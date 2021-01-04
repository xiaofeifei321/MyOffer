package com.JavaSummary;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
*
* */
public class CyclicBarrierDemo {
    public static void main(String[] args){
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7, new Runnable() {
            @Override
            public void run() {
                System.out.println("�ٻ�����");
//                System.out.println("�ٻ�����");
            }

        });

        for(int i=1;i<=7;i++){
            final int tempInt = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t �ռ����ڣ�"+tempInt+"����");
                try{
                    cyclicBarrier.await();
                } catch (InterruptedException e){
                    e.printStackTrace();
                } catch (BrokenBarrierException e){
                    e.printStackTrace();
                }

            },String.valueOf(i)).start();
        }
    }
}

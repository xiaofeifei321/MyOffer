package com.JavaSummary;/*
*��4�ֻ��/ʹ��java���̵߳ķ�ʽ��ͨ���̳߳�
* �����������ǣ��̳�Thread�ࣻʵ��Runnable�ӿڣ�����Runnableû�з���ֵ�������쳣��
* ʵ��Callable�ӿڣ��з���ֵ�����ܳ��쳣��
* */

import java.util.concurrent.*;

//System.out.println(Runtime.getRuntime().availableProcessors());
//Array Arrays  ����������
//Collection Collections
//Executor Executors
public class MyThreadPoolDemo {
    public static void main(String[] args){
        // Array  Arrays(����������)
        // Collection Collections(����������)
        // Executor Executors(����������)
         //һ��5�������̣߳����̳߳�һ����סҪ�رգ�
//        ThreadPoolExecutor
        ExecutorService threadPool1=Executors.newFixedThreadPool(5);
        try {
            //ģ��10���û�������ҵ��ÿһ���û�����һ�������ⲿ�������߳�
             for (int i=0;i<10;i++){
                final  int tempInt=i;
                threadPool1.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t ���û�"+tempInt+"����ҵ��");
                });
             }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool1.shutdown();
        }

        System.out.println("__________________�ָ��ߡ�������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
       ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        try{
            for(int i=1;i<12;i++){
                final  int tempInt=i;
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t ����ҵ��"+tempInt);
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    private static void threadPoolInit() {
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);//һ��5�������߳�
        //ExecutorService threadPool = Executors.newFixedThreadPool(1);//һ��1���߳�
        ExecutorService threadPool = Executors.newCachedThreadPool();//һ��N���߳�

        //ģ��10���û�������ҵ��ÿ���û�����һ�������ⲿ�������߳�
        try{
            for(int i=1;i<=10;i++){
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t ����ҵ��");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}

package com.JavaSummary;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
*
* */
public class SemaphoreDemo {
    public static void main(String[] args){

        Semaphore semaphore = new Semaphore(3);  //ģ��3����λ
        for(int i=1;i<=6;i++){  //ģ��6����
            new Thread(()->{
                try{
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t������λ");
                    try{
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {e.printStackTrace();}
                    System.out.println(Thread.currentThread().getName()+"\tͣ��3����뿪��λ");
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}

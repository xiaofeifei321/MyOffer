package com.JavaSummary;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;



class MyData{
     int number = 0;
    public void addTo60(){
        this.number = 60;
    }
    public void addPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtommic(){
        atomicInteger.getAndIncrement();
    }
}
/*
1 ��֤volatile�Ŀɼ���
    1.1 ����int number=0��number����֮ǰ����û�����volatile�ؼ�������,û�пɼ���
    1.2 �����volatile�����Խ���ɼ�������
2 ��֤volatile����֤ԭ����

    2.1 ԭ�����ǲ��ɷָ�����ԣ�Ҳ��ĳ���߳�������ĳ������ҵ��ʱ���м䲻���Ա��������߷ָ
    ��Ҫ������ɣ�Ҫôͬʱ�ɹ���Ҫôͬʱʧ�ܡ�

    2.2 volatile�����Ա�֤ԭ������ʾ

    2.3 ��ν��ԭ����
        *��sync
        *ʹ�����ǵ�JUC��AtomicInteger

* */

class MyData1{
  volatile   int number=0;
    public  void addTo60(){
        this.number=60;
    }
}
public class VolatileDemo {
    public static void main(String[] args){
        MyData1 myData1=new MyData1();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"\t ������");
                TimeUnit.SECONDS.sleep(3);
                myData1.addTo60();
                System.out.println(Thread.currentThread().getName()+"\t updata number value="+myData1.number);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        },"AA").start();
        //���̵߳ȴ�
        while (myData1.number==0){

        }
        System.out.println(Thread.currentThread().getName()+"\t ����");
        System.out.println("-----------------------------------------�ָ���-----------------------------------------------------------------------------------");


        MyData myData = new MyData();
        for (int i = 1; i <= 20 ; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000 ; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtommic();
                }
            },String.valueOf(i)).start();
        }

        //��Ҫ�ȴ�����20���̶߳�������ɺ�����main�߳�ȥ�����յĽ���Ƕ��٣�
//        try{TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
        while(Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finnally number value: "+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t finnally number value: "+myData.atomicInteger);
    }
}

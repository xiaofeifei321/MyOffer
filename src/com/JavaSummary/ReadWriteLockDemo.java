package com.JavaSummary;/*
* ����߳�ͬʱ��һ����Դ��û�����⣬����Ϊ�����㲢��������ȡ������ԴӦ�ÿ���ͬʱ���С�����д����
* ��Դֻ����һ���̡߳�
*
*  С�ܽ�:
     1: ��-���ܹ���
     2����-д���ܹ���
     3��д-д���ܹ���
* д������ԭ��+��ռ���������̱�����һ��������ͳһ�壬�м䲻���ָ����ϡ�
* */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    private Lock lock = new ReentrantLock(true);
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    public void put(String key,Object value){
//        lock.lock();
        reentrantReadWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t xie����д�룺"+key);
            try{
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {e.printStackTrace();}
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t xieд�����");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            lock.unlock();
            reentrantReadWriteLock.writeLock().unlock();
        }

    }

    public void get(String key){
//        lock.lock();
        reentrantReadWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t du���ڶ�ȡ��"+key);
            try{
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {e.printStackTrace();}
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t du��ȡ���"+result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            lock.unlock();
            reentrantReadWriteLock.readLock().unlock();
        }
    }

}

public class ReadWriteLockDemo {
    public static void main(String[] args){
        MyCache myCache = new MyCache();
        for(int i=1;i<=5;i++){
            final int tempInt = i;
            new Thread(()->{
                myCache.put(tempInt+"",tempInt+"");
            },String.valueOf(i)).start();
        }

        for(int i=1;i<=5;i++){
            final int tempInt = i;
            new Thread(()->{
                myCache.get(tempInt+"");
            },String.valueOf(i)).start();
        }
    }
}

package com.JavaSummary;/*
* 多个线程同时读一个资源类没有问题，所以为了满足并发量，读取共享资源应该可以同时进行。但是写共享
* 资源只能有一个线程。
*
*  小总结:
     1: 读-读能共存
     2：读-写不能共存
     3：写-写不能共存
* 写操作：原子+独占，整个过程必须是一个完整的统一体，中间不许被分割，被打断。
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
            System.out.println(Thread.currentThread().getName()+"\t xie正在写入："+key);
            try{
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {e.printStackTrace();}
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t xie写入完成");
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
            System.out.println(Thread.currentThread().getName()+"\t du正在读取："+key);
            try{
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {e.printStackTrace();}
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t du读取完成"+result);
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

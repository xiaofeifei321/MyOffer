package com.ccut.others;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 多线程死锁问题解决方案
 * @author root
 */
//哲学家吃饭问题
public class ETTest2 {
  //创建大小为5的信号量数组，模拟5根筷子
  static Semaphore[] arry=new Semaphore[5];
  //定义一个值为4的信号量，代表最多只能有四个哲学家拿起左边的筷子
   static  Semaphore leftCount=new Semaphore(4,true);
  public static void main(String[] args) {
      //创建一个5个线程的线程池
		ExecutorService es=Executors.newFixedThreadPool(5);

      //初始化信号量
      for(int i=0;i<5;i++){
          arry[i]=new Semaphore(1,true);
      }
      //创建5个哲学家 但这样有可能会产生死锁问题
      for(int i=0;i<5;i++){
          es.execute(new ActionRunnable(i));
      }

  }
  //第i+1号哲学家的活动过程
  static class ActionRunnable implements Runnable{
      private int i=0;
      ActionRunnable(int i){
          this.i=i;
      }

      @Override
      public void run() {
          while(!Thread.interrupted()){
              try {
                  //看拿起左边筷子的线程数是否已满,可以，则能拿起左边筷子的线程数减一，不能则等待
                  leftCount.acquire();
                  arry[i].acquire();
                  //请求右边的筷子
                  arry[(i+1)%5].acquire();
                  //吃饭
                  System.out.println("我是哲学家"+(i+1)+"号我在吃饭");
                  //释放左手的筷子
                  arry[i].release();
                  //能拿起左边筷子的线程数量加一
                  leftCount.release();
                  //释放右手的筷子
                  arry[(i+1)%5].release();
                   //哲学家开始思考
                  System.out.println("我是哲学家"+(i+1)+"号我吃饱了我要开始思考了");
                  //通知cpu 将调度权让给其他哲学家线程
                  Thread.yield();
              } catch (InterruptedException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              }
          }
      }

  }
}
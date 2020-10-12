package com.JavaSummary;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 多线程处理方式
 */
public class Mythread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("******************");
        System.out.println(Thread.currentThread().getName() + "****************");
//        TimeUnit.SECONDS.sleep(12);
        return 1024;
    }

    public static void main(String[] args) throws Exception {

        FutureTask<Integer> futureTask = new FutureTask<>(new Mythread());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new Mythread());
        Thread t1 = new Thread(futureTask, "AA");
        Thread t2 = new Thread(futureTask2, "BB");
        t1.start();
        t2.start();
        int r1 = 100;
        /**
         *  futureTask.get() 需要放在最后执行，这样不会导致主线程阻塞
         */
        // 判断futureTask是否计算完成
        while (!futureTask.isDone()) {
            //主线程等待
        }
        int r2 = futureTask.get();//要求获得Callable线程的计算结果，如果没有计算完成就要强求，会导致阻塞，知道计算完成，建议放在最后
        System.out.println(Thread.currentThread().getName() + "****************");
        System.out.println(".....result  " + r1 + "    " + r2);
    }
}


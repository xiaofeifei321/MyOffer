package com.JavaSummary;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * ���̴߳���ʽ
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
         *  futureTask.get() ��Ҫ�������ִ�У��������ᵼ�����߳�����
         */
        // �ж�futureTask�Ƿ�������
        while (!futureTask.isDone()) {
            //���̵߳ȴ�
        }
        int r2 = futureTask.get();//Ҫ����Callable�̵߳ļ����������û�м�����ɾ�Ҫǿ�󣬻ᵼ��������֪��������ɣ�����������
        System.out.println(Thread.currentThread().getName() + "****************");
        System.out.println(".....result  " + r1 + "    " + r2);
    }
}


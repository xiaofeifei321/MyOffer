package com.JavaSummary;


public class HelloGC {
    public static int oneAddone(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) throws Exception {
/*
        int[] arr = {1,2,3,4,5};
        int n = arr.length, index = 0;
        while (true) {
            System.out.println("index="+index +"  n="+n+"  ����Ϊ"+index  n + " ֵΪ" + (arr[index % n]));
            index++;
            Thread.sleep(1000);
        }
*/


        //����Java��������ڴ����������ʼ���ڴ��С��
        long totalMemory = Runtime.getRuntime().maxMemory();
        //����java���������ͼʹ�õ�����ڴ����������ڴ��С��
        long maxMemory = Runtime.getRuntime().maxMemory();
        //��ʼ�����ڴ棨Ĭ��ֻ������������ڴ��64��1��
        System.out.println("TOTAL_MEMORY(-Xms) = " + totalMemory + "(�ֽ�)��" + (totalMemory / (double) 1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = " + maxMemory + "(�ֽ�)��" + (maxMemory / (double) 1024 / 1024) + "MB");
        System.out.println();
        System.out.println();
        System.out.println("hello GC");
        Thread.sleep(Integer.MAX_VALUE);

//        int res = oneAddone(1,1);
//        System.out.println(res);
    }
}

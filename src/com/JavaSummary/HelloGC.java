package com.JavaSummary;


public class HelloGC {
    public static int oneAddone(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) throws Exception {
        //返回Java虚拟机中内存的总量（初始对内存大小）
        long totalMemory = Runtime.getRuntime().maxMemory();
        //返回java虚拟机中试图使用的最大内存量（最大堆内存大小）
        long maxMemory = Runtime.getRuntime().maxMemory();
        //初始化堆内存（默认只会用最大物理内存的64分1）
        System.out.println("TOTAL_MEMORY(-Xms) = " + totalMemory + "(字节)、" + (totalMemory / (double) 1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = " + maxMemory + "(字节)、" + (maxMemory / (double) 1024 / 1024) + "MB");
        System.out.println();
        System.out.println();
        System.out.println("hello GC");
//        Thread.sleep(Integer.MAX_VALUE);

//        int res = oneAddone(1,1);
//        System.out.println(res);
    }
}

package com.JavaSummary;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * 虚引用
 * 虚引用的主要作用是和跟踪对象被垃圾回收的状态，仅仅是提供一种确保对象被finalize以后，做某些事情的机制，一般是用于回收时候做相关操作
 */
public class WeakHashMapDemo {
    public static void main(String[] args){
        myHashMap();
        System.out.println("========");
        myWeakHashMap();
    }

    private static void myHashMap(){
        HashMap<Integer,String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";

        map.put(key,value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }

    private static void myWeakHashMap(){
        WeakHashMap<Integer,String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "WeakHashMap";

        map.put(key,value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }
}

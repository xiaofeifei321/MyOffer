package com.JavaSummary;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ArrayList Ϊʲô�������԰�ȫ��
 */
public class ArrayListNotSafeDemo {
    /**
     * ���̻߳�����
     * @param args
     */
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (String element:list){
//            System.out.println(element);
        }

        System.out.println("-------------------------------------------------------�ָ���-----------------------------------------------");
        List<String> list1 =new ArrayList<>();
        for (int i=0;i<50;i++){
            new Thread(()->{
                list1.add(UUID.randomUUID().toString().substring(0,8));

            },String.valueOf(i)).start();
        }

        System.out.println("�߳�����= "+Thread.currentThread().getName()+"�߳�id "+Thread.currentThread().getId()+"����list ="+list1);
        System.out.println("---------------------------------------------------�ָ���2-------------------------------------");


        Vector vector=new Vector();
        vector.add(1);


        List<String> list4= Collections.synchronizedList(new ArrayList<>());

        CopyOnWriteArrayList copyOnWriteArrayList=new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(3);
        copyOnWriteArrayList.add(4);
        System.out.println(copyOnWriteArrayList);

    }


}

package com.JavaSummary;

import javax.jws.soap.SOAPBinding;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class User{
    String userName;
    int age;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class AtomicReferenceDemo {
    public static void main(String[] args){


        User z3 = new User("z3",22);
        User li4 = new User("li4",25);
        //����ԭ�����ð�װ��
        AtomicReference<User> atomicReference = new AtomicReference<>();
       //�����������ڴ�Ĺ��������Ϊz3
        atomicReference.set(z3);
        //�Ƚϲ�����,��������������ڴ��ֵΪz3����ô������li4
        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"+atomicReference.get().toString());
        //�ȽϽ����������������ڴ��ֵ��li4������Ԥ��Ϊz3,��˽���ʧ��
        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"+atomicReference.get().toString());
    }
}

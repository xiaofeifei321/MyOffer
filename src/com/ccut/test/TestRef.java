package com.ccut.test;

public class TestRef {
    public Obj aObj = new Obj();
    private int aInt = 0;

    public Obj getAObj() {
        return aObj;
    }

    public int getAInt() {
        return aInt;
    }

    public void changeObj(Obj inObj) {
        inObj.setStr("changed value");
    }

    public void changeInt(int inInt) {
        inInt = 1;
    }

    public static void main(String[] args) {
        TestRef oRef = new TestRef();
        System.out.println("*********引用类型*********");
        System.out.println("调用changeObj()前:" + oRef.getAObj());
        oRef.changeObj(oRef.getAObj());
        System.out.println("调用changeObj()后：" + oRef.getAObj());
        System.out.println("*********基本数据类型*********");
        System.out.println("调用changeInt()前:" + oRef.getAInt());
        oRef.changeInt(oRef.getAInt());
        System.out.println("调用changeInt()后：" + oRef.getAInt());
    }
}
	
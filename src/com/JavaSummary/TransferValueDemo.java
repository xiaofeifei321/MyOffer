package com.JavaSummary;

/**
 * java中值传递和引用传递
 */
class Person {
    private Integer id;
    private String personName;
    public Person(String personName) {
        this.personName = personName;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPersonName() {
        return personName;
    }
    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
public class TransferValueDemo {
    public void changeValue(int age) {
        age = 30;
    }
    public void changeValue2(Person person) {
        person.setPersonName("飞飞");
    }
    public void changeValue3(String str) {
        str = "字符串修改测试";
    }
    public static void main(String[] args) {

        System.out.println("100010005873".length());

        TransferValueDemo transferValueDemo = new TransferValueDemo();
        //定义基本数据类型
        int age = 20;
        transferValueDemo.changeValue(age);
        System.out.println("age=" + age);

        //实例化Person类
        Person person = new Person("abc");
        transferValueDemo.changeValue2(person);
        System.out.println("PersonName=  " + person.getPersonName());


        //实例化字符串
        String str = "JKL";
        transferValueDemo.changeValue3(str);
        System.out.println("string=  " + str);
        /**
         * 总结
         * 对于基本数据类型，传的的是变量的副本，
         *    对于引用类型，传递的是地址，字符串是放在常量池中
         */
    }
}

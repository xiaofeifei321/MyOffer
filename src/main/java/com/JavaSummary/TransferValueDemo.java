package com.JavaSummary;

/**
 * java��ֵ���ݺ����ô���
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
        person.setPersonName("�ɷ�");
    }
    public void changeValue3(String str) {
        str = "�ַ����޸Ĳ���";
    }
    public static void main(String[] args) {

        System.out.println("100010005873".length());

        TransferValueDemo transferValueDemo = new TransferValueDemo();
        //���������������
        int age = 20;
        transferValueDemo.changeValue(age);
        System.out.println("age=" + age);

        //ʵ����Person��
        Person person = new Person("abc");
        transferValueDemo.changeValue2(person);
        System.out.println("PersonName=  " + person.getPersonName());


        //ʵ�����ַ���
        String str = "JKL";
        transferValueDemo.changeValue3(str);
        System.out.println("string=  " + str);
        /**
         * �ܽ�
         * ���ڻ����������ͣ����ĵ��Ǳ����ĸ�����
         *    �����������ͣ����ݵ��ǵ�ַ���ַ����Ƿ��ڳ�������
         */
    }
}

package com.ccut.observer.singleton;

/**
 * 单例模式
 * 饥汉
 *
 * @author root
 * 1：构造函数私有化
 * 2：类初始化之后就创建好类的实例
 * 3:静态工仓直接返回类的实例
 */
public class Singleton {
    private Singleton() {
    }

    private static Singleton single = new Singleton();

    //静态工厂
    public static Singleton getInstance() {
        return single;
    }

}

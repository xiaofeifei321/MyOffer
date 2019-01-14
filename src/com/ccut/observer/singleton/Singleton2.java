package com.ccut.observer.singleton;

/**
 * 懒汉（延迟加载的方式）
 * 
 * @author root 
 * 1：类的初始化的时候不实现  懒汉模式在方法被调用后才创建对象
 */
public class Singleton2 {
	private Singleton2() {
	};
	private static Singleton2 singleton2 = null;
     //产生线程安全问题
	public static Singleton2 getInstance1() {
		if (singleton2 == null) {
			singleton2 = new Singleton2();
		}
		return singleton2;
	}
	//加锁,效率低
	public static Singleton2 getInstance2(){
		synchronized (Singleton2.class) {
			if (singleton2 == null) {
				singleton2 = new Singleton2();
			}
		}
		return singleton2;
	}
	//双重校验锁
	public static Singleton2 getInstance3(){
		if(singleton2==null){
			synchronized (Singleton2.class) {
				if (singleton2 == null) {
					singleton2 = new Singleton2();
				}
			}
		}
		return singleton2;
	}
	//静态内部类
	 // 静态内部类
    private static class InnerObject{
        private static Singleton2 single = new Singleton2();
    }
    
    public static Singleton2 getInstance4() {
        return InnerObject.single;
    }

}

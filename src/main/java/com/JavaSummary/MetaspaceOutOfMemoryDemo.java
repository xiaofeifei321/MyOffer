/*
package com.JavaSummary;

import java.lang.reflect.Method;

public class MetaspaceOutOfMemoryDemo {

    // ��̬��
    static class OOMTest {

    }

    public static void main(final String[] args) {
        // ģ��������ٴ��Ժ����쳣
        int i =0;
        try {
            while (true) {
                i++;
                // ʹ��Spring�Ķ�̬�ֽ��뼼��
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
            }
        } catch (Exception e) {
            System.out.println("�����쳣�Ĵ���:" + i);
            e.printStackTrace();
        } finally {

        }

    }
}
*/

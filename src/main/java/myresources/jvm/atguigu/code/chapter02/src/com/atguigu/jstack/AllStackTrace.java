package myresources.jvm.atguigu.code.chapter02.src.com.atguigu.jstack;

import java.util.Map;
import java.util.Set;

/**
 * @author shkstart
 * @create 15:51
 */
public class AllStackTrace {
    public static void main(String[] args) {
        Map<Thread, StackTraceElement[]> all = Thread.getAllStackTraces();
        Set<Map.Entry<Thread, StackTraceElement[]>> entries = all.entrySet();
        for (Map.Entry<Thread, StackTraceElement[]> en : entries) {
            Thread t = en.getKey();
            StackTraceElement[] v = en.getValue();
            System.out.println("¡¾Thread name is :" + t.getName() + "¡¿");
            for (StackTraceElement s : v) {
                System.out.println("\t" + s.toString());
            }
        }
    }
}

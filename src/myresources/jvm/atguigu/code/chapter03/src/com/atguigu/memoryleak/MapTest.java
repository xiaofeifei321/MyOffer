package myresources.jvm.atguigu.code.chapter03.src.com.atguigu.memoryleak;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 演示内存泄漏
 *
 * @author shkstart
 * @create 14:53
 */
public class MapTest {
    static Map wMap = new WeakHashMap();
    static Map map = new HashMap();

    public static void main(String[] args) throws Exception {
        init();
        System.out.println("---------------------------");
        testWeakHashMap();
        System.out.println("---------------------------");
        testHashMap();
    }

    public static void init() {
        String ref1 = new String("obejct1");
        String ref2 = new String("obejct2");
        String ref3 = new String("obejct3");
        String ref4 = new String("obejct4");
        wMap.put(ref1, "cacheObject1");
        wMap.put(ref2, "cacheObject2");
        map.put(ref3, "cacheObject3");
        map.put(ref4, "cacheObject4");
        System.out.println("String引用ref1，ref2，ref3，ref4 消失");

    }

    public static void testWeakHashMap() throws InterruptedException {
        System.out.println("WeakHashMap GC之前");
        for (Object o : wMap.entrySet()) System.out.println(o);
        System.gc();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("WeakHashMap GC之后");
        for (Object o : wMap.entrySet()) System.out.println(o);
    }

    public static void testHashMap() throws InterruptedException {
        System.out.println("HashMap GC之前");
        for (Object o : map.entrySet()) System.out.println(o);
        System.gc();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("HashMap GC之后");
        for (Object o : map.entrySet()) System.out.println(o);
    }

}
/**
 * 结果
 * String引用ref1，ref2，ref3，ref4 消失
 * ---------------------------
 * WeakHashMap GC之前
 * obejct2=cacheObject2
 * obejct1=cacheObject1
 * WeakHashMap GC之后
 * ---------------------------
 * HashMap GC之前
 * obejct4=cacheObject4
 * obejct3=cacheObject3
 * HashMap GC之后
 * obejct4=cacheObject4
 * obejct3=cacheObject3
 **/

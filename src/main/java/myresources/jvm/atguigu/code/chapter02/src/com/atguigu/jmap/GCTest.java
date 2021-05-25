package myresources.jvm.atguigu.code.chapter02.src.com.atguigu.jmap;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 17:49
 * -Xms60m -Xmx60m -XX:SurvivorRatio=8
 */
public class GCTest {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            byte[] arr = new byte[1024 * 100];  // 100KB
            list.add(arr);
            try {

//                Scanner scanner = new Scanner(System.in);
//                String info = scanner.next();
//                System.out.println(System.getProperties());
            } catch (Exception e) {
                e.printStackTrace();
            }
            while (true){
                new GCTest();
            }
        }
    }
}

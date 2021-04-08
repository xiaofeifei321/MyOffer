package com.JavaSummary;

import java.util.Random;

public class JavaHeapSpaceDemo {
    public static void main(String[] args){
        String str = "AA";

        while(true){
            str += str + new Random().nextInt(11111111)+new Random().nextInt(22222222);
            System.out.println( str.intern());
        }

    }
}

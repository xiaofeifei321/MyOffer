package com.myjava;

public class Test {
    public static void main(String[] args) {

        try {
            Thread myThread = new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });
            myThread.start();


            myThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

package com.example.thread;

/**
 * @author wangyang
 * @date 2020/03/17
 */
public class ThreadTest {


    public static void main(String[] args) {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();


        System.out.println("--------");
        System.out.println("--------");
        System.out.println("--------");
    }
}

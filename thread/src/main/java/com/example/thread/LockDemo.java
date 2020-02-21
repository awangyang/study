package com.example.thread;

/**
 * @author wangyang
 * @date 2020/02/18
 */
public class LockDemo extends Thread {
    private static int i = 0;
    private static final Object object = new Object();

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (object){
            i = i + 1;
            System.out.println(i);
        }

    }

    public static void main(String[] args) {

        for (int j = 0; j < 100; j++) {
            LockDemo lockDemo = new LockDemo();
            lockDemo.start();
        }


    }
}

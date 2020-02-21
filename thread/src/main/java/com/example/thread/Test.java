package com.example.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author wangyang
 * @date 2019/12/26
 */
public class Test {

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5,
                10, 200,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(90),new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 12; i++) {
            Task task = new Task(i);
            pool.execute(task);
            System.out.println("线程池中线程数目：" + pool.getPoolSize() + "，队列中等待执行的任务数目：" +
                    pool.getQueue().size() + "，已执行玩别的任务数目：" + pool.getCompletedTaskCount());
        }
        pool.shutdown();
    }


    public void rt() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.shutdown();
    }


}
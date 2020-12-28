package com.hyf.leetcode.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author huyufei on 2020/11/16
 * @Desc: TODO
 */
public class ExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 10, 1000, TimeUnit.MILLISECONDS, queue, new MyThreadFactory(), new MyRejectedExecutionHandler());
//        threadPoolExecutor.allowCoreThreadTimeOut(true);
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "handling task....");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(100000L, TimeUnit.MILLISECONDS);
    }

    static class MyThreadFactory implements ThreadFactory {
        private AtomicInteger atomicInteger = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            atomicInteger.incrementAndGet();
            return new Thread(r);
        }
    }

    static class MyRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.printf("reject runnable!\n");
            System.out.printf("executor taskCount:%d, active:%d\n", executor.getTaskCount(), executor.getActiveCount());
        }
    }
}

package com.hyf.leetcode.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.LongStream;

/**
 * @Author huyufei on 2020/11/6
 * @Desc: TODO
 */
public class AtomicReferenceTest {
    public static AtomicReference<String> atomicReference = new AtomicReference<>("Hello ");

    public static void main(String[] args) throws InterruptedException {
        testAtomicString();
    }

    public static void testAtomicString() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        List<Task> taskList = new ArrayList<>();
        long finish = System.currentTimeMillis() + 2 * 1000;
        int threads = 1000;
        AtomicLong atomicLong = new AtomicLong(0);
        List<Future<Boolean>> futures = new ArrayList<>();
        for (; System.currentTimeMillis() <= finish; ) {
            List<Task> taskList = new ArrayList();
            LongStream.range(0, threads).forEach(i -> {
                taskList.add(new Task(atomicReference));
            });

            executorService.invokeAll(taskList);
            atomicLong.getAndAdd(threads);
        }

        futures.forEach(f -> {
            try {
                System.out.println("future result:" + f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }

    static class Task implements Callable<Boolean> {
        private AtomicReference<String> stringAtomicReference;

        public Task(AtomicReference<String> atomicReference) {
            this.stringAtomicReference = atomicReference;
        }

        @Override
        public Boolean call() throws Exception {
            boolean flag = stringAtomicReference.compareAndSet(stringAtomicReference.get(), stringAtomicReference.get().concat("World"));
            if(!flag) {
                System.out.println("flag:" + flag + "  str: " + stringAtomicReference.get());
            }else{

            }

            return flag;
        }
    }
}

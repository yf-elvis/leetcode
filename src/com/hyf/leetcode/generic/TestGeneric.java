package com.hyf.leetcode.generic;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author huyufei on 2020/11/15
 * @Desc: TODO
 */
public class TestGeneric {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        Plate<? extends Fruit> p = new Plate<>(new Apple());
//        p.set(new Apple());

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
                throw new RuntimeException("shuot exception");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello World";
        });
        completableFuture.whenComplete((s, throwable) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(s);
            System.out.println(throwable.getMessage());
        }).exceptionally((throwable -> {
            System.out.println("-----exception:"+throwable.getMessage());
            return "FAIL";
        }));

        String s = completableFuture.get();
        System.out.println("s:" + s);

    }
}

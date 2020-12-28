package com.hyf.leetcode.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author huyufei on 2020/10/28
 * @Desc: TODO
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有运动员准备就绪...发抢!!!!");
            }
        });
        List<Runner> runnerList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Runner runner = new Runner(i, cyclicBarrier);
            runnerList.add(runner);
            runner.start();
        }
        Thread.sleep(3000);
        runnerList.get(1).interrupt();
    }
}

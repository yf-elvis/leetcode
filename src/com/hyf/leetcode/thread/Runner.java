package com.hyf.leetcode.thread;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author huyufei on 2020/10/28
 * @Desc: TODO
 */
public class Runner implements Runnable {
    private Thread t;
    private Integer no;
    private CyclicBarrier cyclicBarrier;

    public Runner(int no, CyclicBarrier cyclicBarrier) {
        t = new Thread(this);
        this.no = no;
        this.cyclicBarrier = cyclicBarrier;
    }

    public Runner() {
        t = new Thread(this);
        this.no = new Random().nextInt();
    }

    public void start() {
        this.t.start();
    }

    public void interrupt() {
        this.t.interrupt();
    }
    @Override
    public void run() {
        try {
            System.out.println("第" + this.no + "运动员开始准备");
            Thread.sleep(no * 1000);
            this.cyclicBarrier.await();
            System.out.println("运动员" + this.no + "开始跑步...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }
}

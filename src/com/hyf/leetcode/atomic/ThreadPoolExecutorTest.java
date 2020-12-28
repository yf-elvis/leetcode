package com.hyf.leetcode.atomic;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author huyufei on 2020/11/6
 * @Desc: TODO
 */
public class ThreadPoolExecutorTest {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;

    public static void main(String[] args) {
//        ThreadPoolExecutor
    }

    private static boolean runStateAtLeast(int c, int s) {
        return c >= s;
    }

    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }
}
